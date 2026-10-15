package com.studentgrade;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 功能1: 添加学生面板
 * 成员A负责完善
 */
public class AddStudentPanel extends JPanel {
    private JTextField txtId;
    private JTextField txtName;
    private JTextField txtCourse;

    public AddStudentPanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        // 学号
        gbc.gridx = 0; gbc.gridy = 0;
        add(new JLabel("学号 (Student ID):"), gbc);
        gbc.gridx = 1;
        txtId = new JTextField(20);
        add(txtId, gbc);

        // 姓名
        gbc.gridx = 0; gbc.gridy = 1;
        add(new JLabel("姓名 (Name):"), gbc);
        gbc.gridx = 1;
        txtName = new JTextField(20);
        add(txtName, gbc);

        // 课程
        gbc.gridx = 0; gbc.gridy = 2;
        add(new JLabel("课程 (Course):"), gbc);
        gbc.gridx = 1;
        txtCourse = new JTextField(20);
        add(txtCourse, gbc);

        // 按钮
        gbc.gridx = 0; gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton btnAdd = new JButton("添加学生");
        btnAdd.addActionListener(e -> addStudent());
        add(btnAdd, gbc);
    }

    private void addStudent() {
        String id = txtId.getText().trim();
        String name = txtName.getText().trim();
        String course = txtCourse.getText().trim();

        if (id.isEmpty() || name.isEmpty() || course.isEmpty()) {
            JOptionPane.showMessageDialog(this, "请填写完整信息！", "错误", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // 检查学号是否已存在
        Student existing = StudentManager.getInstance().findStudentById(id);
        if (existing != null) {
            JOptionPane.showMessageDialog(this, "该学号已存在！", "错误", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // 添加学生
        Student newStudent = new Student(id, name, course);
        StudentManager.getInstance().addStudent(newStudent);

        JOptionPane.showMessageDialog(this, "学生添加成功！");
        
        // 清空输入框
        txtId.setText("");
        txtName.setText("");
        txtCourse.setText("");
    }
}
