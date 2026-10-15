package com.studentgrade;

import java.util.ArrayList;
import java.util.List;

/**
 * 学生数据管理类
 * 使用 ArrayList 存储数据（不用数据库）
 * 单例模式：整个系统共用一个数据管理器
 */
public class StudentManager {
    private static StudentManager instance;
    private List<Student> studentList;

    // 私有构造方法（单例模式）
    private StudentManager() {
        studentList = new ArrayList<>();
        // 添加一些测试数据
        addSampleData();
    }

    // 获取唯一实例
    public static synchronized StudentManager getInstance() {
        if (instance == null) {
            instance = new StudentManager();
        }
        return instance;
    }

    // 添加测试数据
    private void addSampleData() {
        Student s1 = new Student("A12345", "Ali", "TTTK1233");
        s1.setAssignment(80);
        s1.setQuiz(75);
        s1.setExam(85);
        studentList.add(s1);

        Student s2 = new Student("A12346", "Bala", "TTTK1233");
        s2.setAssignment(60);
        s2.setQuiz(55);
        s2.setExam(70);
        studentList.add(s2);
    }

    // 添加学生
    public void addStudent(Student student) {
        studentList.add(student);
    }

    // 删除学生
    public void removeStudent(String studentId) {
        studentList.removeIf(s -> s.getStudentId().equals(studentId));
    }

    // 根据学号查找学生
    public Student findStudentById(String studentId) {
        for (Student s : studentList) {
            if (s.getStudentId().equals(studentId)) {
                return s;
            }
        }
        return null;
    }

    // 获取所有学生
    public List<Student> getAllStudents() {
        return new ArrayList<>(studentList);
    }

    // 获取学生数量
    public int getStudentCount() {
        return studentList.size();
    }
}
