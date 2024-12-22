package data.menu;

public enum MenuCoursesData {

    INFRASTRUCTURE("Инфраструктура"),
    SAFETY("Безопасность"),
    DATA_SCIENCE("Data Science"),
    GAME_DEV("GameDev"),
    MANAGEMENT("Управление"),
    ANALYTICS_AND_ANALYSIS("Аналитика и анализ"),
    QA("Тестирование"),
    CORPORATE_COURSES("Корпоративные курсы"),
    WITHOUT_PROGRAMMING("IT без программирования"),
    ALL("Все направления"),
    PROGRAMMING("Программирование"),
    ARCHITECTURE("Архитектура");

    private String name;

    MenuCoursesData(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
