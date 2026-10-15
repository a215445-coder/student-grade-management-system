package com.studentgrade;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 功能3: 录入成绩面板
 * 成员C负责完善
 */
public class GradeEntryPanel extends JPanel {
    private JComboBox<String> cmbStudent;
    private JTextField txtAssignment;
    private JTextField txtQuiz;
    private JTextField txtExam;

    public GradeEntryPanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        // 选择学生
        gbc.gridx = 0; gbc.gridy = 0;
        add(new JLabel("选择学生:"), gbc);
        gbc.gridx = 1;
        cmbStudent = new JComboBox<>();
        refreshStudentList();
        add(cmbStudent, gbc);

        // 作业成绩
        gbc.gridx = 0; gbc.gridy = 1;
        add(new JLabel("作业成绩 (0-100):"), gbc);
        gbc.gridx = 1;
        txtAssignment = new JTextField(10);
        add(txtAssignment, gbc);

        // 小测成绩
        gbc.gridx = 0; gbc.gridy = 2;
        add(new JLabel("小测成绩 (0-100):"), gbc);
        gbc.gridx = 1;
        txtQuiz = new JTextField(10);
        add(txtQuiz, gbc);

        // 考试成绩
        gbc.gridx = 0; gbc.gridy = 3;
        add(new JLabel("考试成绩 (0-100):"), gbc);
        gbc.gridx = 1;
        txtExam = new JTextField(10);
        add(txtExam, gbc);

        // 保存按钮
        gbc.gridx = 0; gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton btnSave = new JButton("保存成绩");
        btnSave.addActionListener(e -> saveGrades());
        add(btnSave, gbc);
    }

    // 刷新下拉框学生列表
    private void refreshStudentList() {
        cmbStudent.removeAllItems();
        for (Student s : StudentManager.getInstance().getAllStudents()) {
            cmbStudent.addItem(s.getStudentId() + " - " + s.getName());
        }
    }

    // 保存成绩
    private void saveGrades() {
        if (cmbStudent.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "请先选择学生！", "错误", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            String selected = cmbStudent.getSelectedItem().toString();
            String studentId = selected.split(" - ")[0];
            
            double assignment = Double.parseDouble(txtAssignment.getText().trim());
            double quiz = Double.parseDouble(txtQuiz.getText().trim());
            double exam = Double.parseDouble(txtExam.getText().trim());

            // 验证分数范围
            if (assignment < 0 || assignment > 100 || quiz < 0 || quiz > 100 || exam < 0 || exam > 100) {
                JOptionPane.showMessageDialog(this, "分数必须在0-100之间！", "错误", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Student student = StudentManager.getInstance().findStudentById(studentId);
            if (student != null) {
                student.setAssignment(assignment);
                student.setQuiz(quiz);
                student.setExam(exam);
                JOptionPane.showMessageDialog(this, "成绩保存成功！");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "请输入有效的数字！", "错误", JOptionPane.ERROR_MESSAGE);
        }
    }
}
