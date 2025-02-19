node("maven") {
    timeout(300) {
        wrap([$class: 'BuildUser']) {
            currentBuild.description = "Owner: ${BUILD_USER}"

            yaml_params = readYaml text: $YAML_CONFIG
        }

        stage("Checkout") {
            checkout scm
        }

        stage("Prepare parameters") {
            sh "echo BROWSER=${yaml_params['BROWSER']} > ./.env"
            sh "echo VERSION=$BROWSER_VERSION >> ./.env"
        }

        stage("Running tests") {
            sh "docker run --env-file ./.env -v /root/allure:/root/allure -t ui_tests:1.0.0"
        }

        stage("Publish allure report") {
            withAllureUpload(indexExistingFiles: true, name: '${JOB_NAME}-${STAND_NAME}-#${BUILD_NUMBER}', projectId: '83', serverId: 'default', tags: "api, regular, automated, ${JOB_NAME}", results: [[path: 'allure-results']]) {
                allure([
                        includeProperties: false,
                        jdk: '',
                        properties: [],
                        reportBuildPolicy: 'ALWAYS',
                        results: [[path: 'allure-results']]
                ])
            }
        }
    }
}