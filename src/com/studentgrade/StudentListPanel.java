package com.studentgrade;

import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * 功能2: 学生列表面板
 * 成员B负责完善
 */
public class StudentListPanel extends JPanel {
    private JTable table;
    private DefaultTableModel tableModel;

    public StudentListPanel() {
        setLayout(new BorderLayout());

        // 表格列名
        String[] columns = {"学号", "姓名", "课程", "作业", "小测", "考试", "总分", "等级"};
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);
        
        // 滚动面板
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // 加载数据
        refreshTable();
    }

    // 刷新表格数据
    public void refreshTable() {
        tableModel.setRowCount(0); // 清空表格
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
