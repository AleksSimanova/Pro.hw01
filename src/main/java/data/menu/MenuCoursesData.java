package data.menu;

public enum MenuCoursesData {

    INFRASTRUCTURE("Инфраструктура", "Инфраструктура", "https://otus.ru/categories/operations"),
    SAFETY("Безопасность", "Безопасность", "https://otus.ru/categories/analytics"),
    DATA_SCIENCE("Data Science", "Data", "https://otus.ru/categories/data-science"),
    GAME_DEV("GameDev", "GameDev", "https://otus.ru/categories/gamedev"),
    MANAGEMENT("Управление", "Управление", "https://otus.ru/categories/marketing-business"),
    ANALYTICS_AND_ANALYSIS("Аналитика и анализ", "Аналитика", "https://otus.ru/categories/analytics"),
    QA("Тестирование", "Тестирование", "https://otus.ru/categories/testing"),
    CORPORATE_COURSES("Корпоративные курсы", "Корпоративные", "https://otus.ru/categories/corporate"),
    WITHOUT_PROGRAMMING("IT без программирования", "IT", "https://otus.ru/categories/it-bez-programmirovanija"),
    ALL("Все направления", "Специализации", "https://otus.ru/categories/spec"),
    PROGRAMMING("Программирование", "Программирование", "https://otus.ru/categories/programming"),
    ARCHITECTURE("Архитектура", "Архитектура", "https://otus.ru/categories/architecture");

    private String name;
    private String cutName;
    private String href;

    MenuCoursesData(String name, String cutName, String href) {
        this.name = name;
        this.cutName = cutName;
        this.href = href;
    }

    public String getName() {
        return name;
    }
    public String getCutName() {
        return cutName;
    }
    public String getHref() {
        return href;
    }

    public static String hrefRandomCourses(String name) {
        for (MenuCoursesData v : values()) {
            if (v.cutName.equals(name)) {
                return v.href;
            }
        }
        return null;
    }
    public static String nameCourses(String name) {
        for (MenuCoursesData v : values()) {
            if (v.cutName.equals(name)) {
                return v.name;
            }
        }
        return null;
    }
}
