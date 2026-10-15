package com.studentgrade;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * 功能5: 搜索学生面板
 * 成员E负责完善
 */
public class SearchStudentPanel extends JPanel {
    private JTextField txtSearch;
    private JTable table;
    private DefaultTableModel tableModel;

    public SearchStudentPanel() {
        setLayout(new BorderLayout());

        // 顶部搜索栏
        JPanel searchPanel = new JPanel(new FlowLayout());
        searchPanel.add(new JLabel("输入学号或姓名搜索:"));
        txtSearch = new JTextField(15);
        searchPanel.add(txtSearch);
        
        JButton btnSearch = new JButton("搜索");
        btnSearch.addActionListener(e -> searchStudent());
        searchPanel.add(btnSearch);
        
        JButton btnShowAll = new JButton("显示全部");
        btnShowAll.addActionListener(e -> showAllStudents());
        searchPanel.add(btnShowAll);

        add(searchPanel, BorderLayout.NORTH);

        // 结果表格
        String[] columns = {"学号", "姓名", "课程", "作业", "小测", "考试", "总分", "等级"};
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // 默认显示全部
        showAllStudents();
    }

    // 搜索学生
    private void searchStudent() {
        String keyword = txtSearch.getText().trim().toLowerCase();
        if (keyword.isEmpty()) {
            showAllStudents();
            return;
        }

        tableModel.setRowCount(0);
        List<Student> students = StudentManager.getInstance().getAllStudents();

        for (Student s : students) {
            // 按学号或姓名搜索
            if (s.getStudentId().toLowerCase().contains(keyword) || 
                s.getName().toLowerCase().contains(keyword)) {
                Object[] row = {
                    s.getStudentId(),
                    s.getName(),
                    s.getCourse(),
                    s.getAssignment(),
                    s.getQuiz(),
                    s.getExam(),
                    s.getTotalScore(),
                    s.getGradeLevel()
                };
                tableModel.addRow(row);
            }
        }

        if (tableModel.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "没有找到匹配的学生！");
        }
    }

    // 显示全部学生
    private void showAllStudents() {
        tableModel.setRowCount(0);
        List<Student> students = StudentManager.getInstance().getAllStudents();

        for (Student s : students) {
            Object[] row = {
                s.getStudentId(),
                s.getName(),
                s.getCourse(),
                s.getAssignment(),
                s.getQuiz(),
                s.getExam(),
                s.getTotalScore(),
                s.getGradeLevel()
            };
            tableModel.addRow(row);
        }
    }
}
