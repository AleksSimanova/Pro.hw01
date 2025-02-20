timeout(time: 60, unit: 'MINUTES') {
    node("maven-slave") {

//
//        def config = readYaml text: $CONFIG
//
//        config.each( k, v -> {
//            env.setProperty(k, v)
//        })


        stage("Checkout") {
            checkout scm
        }

        // stage("checkout utils"){
        //     dir('tools'){
        //         git branch: 'master', url:'https://github.com/jenkinsci/jenkins.git,',credentialId: 'jenkins'
        //     }
        // }

        // utils  =  load './tools/utils'
        // utils.prepare_yaml_config()

        stage("Run UI tests") {
            status - sh(
                    script: "mvn test -Dbrowser=$env.BROWSER -DBASE_URL=$env.BASE_URL",
                    returnStatus: true
            )

            if (status > 0) {
                currentBuild.status = "UNSTABLE"
            }
//            def exitCode = sh(
//                    returnStatus: true,
//                    script: """
//                    mvn test -Dbrowser=$BROWSER -Dbrowser.version=$BROWSER_VERSION -Dwebdriver.base.url=$BASE_URL -Dwebdriver.remote.url=$GRID_URL
//                    """
//            )
//            if(exitCode == 1) {
//                currentBuild.result = 'UNSTABLE'
//            }
        }
        stage("Publish allure results") {
            allure([
                    disabled         : true,
                    includeProperties: false,
                    jdk              : '',
                    reportBuildPolicy: 'ALWAYS',
                    report           : './target/allure-results'

//                    includeProperties: false,
//                    jdk: '',
//                    properties: [],
//                    reportBuildPolicy: 'ALWAYS',
//                    results: [[path: 'allure-results']]
            ])
        }
    }
}

