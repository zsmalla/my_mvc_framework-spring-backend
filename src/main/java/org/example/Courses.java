package org.example;

import java.util.List;

public class Courses {
    private final List<Course> courses;

    public Courses(List<Course> courses) {
        this.courses = courses;
    }
    // (학점수 * 교과목 평점)의 합계
    public double multiplyCreditAndCourseGrade(){
        double multipliedCreditAndCourseGrade = 0;

        for (Course course : courses){
            multipliedCreditAndCourseGrade += course.multiplyCreditAndCourseGrade();
        }

        return multipliedCreditAndCourseGrade;
    }

    public int calculateTotalCompletedCredit(){
        int totalCompletedCredit = courses.stream()
                .mapToInt(Course::getCredit)
                .sum();

        return totalCompletedCredit;
    }

}

