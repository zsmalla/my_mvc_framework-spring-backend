package org.example;

import java.util.List;

public class GradeCalculator {
    private final List<Course> courses;

    public GradeCalculator(List<Course> courses) {
        this.courses = courses;
    }
    /**
     * 요구사항
     * 평균학점 계산 방법 = (학점수*교과목 평점)의 합계/수강신청 총 학점 수
     * 일급 컬렉션 사용
     */
    public double calculateGrade() {
        double multipliedCreditAndCourseGrade = 0;
        // (학점수 * 교과목 평점)의 합계
        for (Course course : courses){
            multipliedCreditAndCourseGrade += course.multiplyCreditAndCourseGrade();
        }

        // 수강신청 총 학점 수
        int totalCompletedCredit = courses.stream()
                .mapToInt(Course::getCredit)
                .sum();

        return multipliedCreditAndCourseGrade / totalCompletedCredit;
    }
}
