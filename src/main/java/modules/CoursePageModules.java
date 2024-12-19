package modules;

import java.time.LocalDate;
import java.util.Date;

public class CoursePageModules {
    String nameCourse;
    LocalDate dateCourses;

    public CoursePageModules(String name, LocalDate date){
        name = this.nameCourse;
        date = this.dateCourses;
    }

    public String getNameCourse() {
        return nameCourse;
    }

    public LocalDate getDateCourses() {
        return dateCourses;
    }


}
