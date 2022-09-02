package org.example.gradecalculator;

public class Course {
    private final String subject; // 과목명

    private final int credit;   // 학점

    private final String grade; // 성적

    public Course(String subject, int credit, String grade) {
        this.subject = subject;
        this.credit = credit;
        this.grade = grade;
    }

    public int getCredit() {
        return credit;
    }

    public double multiplyCreditAndCourseGrade(){   // Course 객체 내부에서 연산 수행(객체 작업 위임)하여 응집도 향상
        return credit * getGradeToNumber();
    }

    public double getGradeToNumber() {
        double grade = 0;
        switch (this.grade) {
            case "A+":
                grade = 4.5;
                break;
            case "A":
                grade = 4.0;
                break;
            case "B+":
                grade = 3.5;
                break;
            case "B":
                grade = 3.0;
                break;
            case "C+":
                grade = 2.5;
                break;
            case "C":
                grade = 2.0;
                break;
            case "D+":
                grade = 1.5;
                break;
            case "D":
                grade = 1.0;
                break;
            case "F":
                grade = 0;
                break;

        }
        return grade;
    }
}
