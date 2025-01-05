package data.menu;

public enum CoursesData {
    POSTGESQL("PostgreSQL. Advanced"),
    QA_LEAD("QA Lead"),
    SQL_FOR_DEV("SQL для разработчиков и аналитиков"),
    QA_ENGINEER_BASIC("QA Engineer. Basic");

    private String name;

    CoursesData(String name) {
        this.name = name;
    }
    public String getNameCourses() {
        return name;
    }
}
