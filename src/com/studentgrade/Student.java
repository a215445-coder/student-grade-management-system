package com.studentgrade;

/**
 * 学生类（数据模型）
 * 演示封装：私有属性 + getter/setter
 */
public class Student {
    // 私有属性（封装）
    private String studentId;    // 学号
    private String name;        // 姓名
    private String course;      // 课程
    private double assignment;  // 作业成绩
    private double quiz;        // 小测成绩
    private double exam;        // 考试成绩

    // 构造方法
    public Student(String studentId, String name, String course) {
        this.studentId = studentId;
        this.name = name;
        this.course = course;
        this.assignment = 0;
        this.quiz = 0;
        this.exam = 0;
    }

    // 计算总分（方法）
    public double getTotalScore() {
        return assignment + quiz + exam;
    }

    // 计算等级（多态/方法重写可以在这里扩展）
    public String getGradeLevel() {
        double total = getTotalScore();
        if (total >= 80) return "A";
        else if (total >= 70) return "B";
        else if (total >= 60) return "C";
        else if (total >= 50) return "D";
        else return "F";
    }

    // Getter 和 Setter（封装）
    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }

    public double getAssignment() { return assignment; }
    public void setAssignment(double assignment) { this.assignment = assignment; }

    public double getQuiz() { return quiz; }
    public void setQuiz(double quiz) { this.quiz = quiz; }

    public double getExam() { return exam; }
    public void setExam(double exam) { this.exam = exam; }
}
