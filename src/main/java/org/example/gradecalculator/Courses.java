package org.example.gradecalculator;

import java.util.List;

public class Courses {
    private final List<Course> courses;

    public Courses(List<Course> courses) {
        this.courses = courses;
    }
    // (학점수 * 교과목 평점)의 합계
    public double multiplyCreditAndCourseGrade(){

        return courses.stream()
                .mapToDouble(Course::multiplyCreditAndCourseGrade)
                .sum();
    }

    public int calculateTotalCompletedCredit(){

        return courses.stream()
                .mapToInt(Course::getCredit)
                .sum();
    }

}

