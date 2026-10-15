package com.studentgrade;

import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * 功能4: 成绩报告面板
 * 成员D负责完善
 */
public class GradeReportPanel extends JPanel {
    private JTextArea reportArea;

    public GradeReportPanel() {
        setLayout(new BorderLayout());

        reportArea = new JTextArea();
        reportArea.setEditable(false);
        reportArea.setFont(new java.awt.Font("Monospaced", java.awt.Font.PLAIN, 14));
        
        JScrollPane scrollPane = new JScrollPane(reportArea);
        add(scrollPane, BorderLayout.CENTER);

        // 生成报告
        generateReport();
    }

    private void generateReport() {
        List<Student> students = StudentManager.getInstance().getAllStudents();
        StringBuilder sb = new StringBuilder();
        
        sb.append("========== 成绩报告 ==========\n\n");
        sb.append("学生总数: ").append(students.size()).append("\n\n");

        // 统计数据
        double totalAvg = 0;
        int passCount = 0;
        int aCount = 0;

        sb.append("学号\t\t姓名\t\t总分\t等级\n");
        sb.append("----------------------------------------\n");

        for (Student s : students) {
            sb.append(String.format("%-12s %-12s %.1f\t%s\n", 
                s.getStudentId(), s.getName(), s.getTotalScore(), s.getGradeLevel()));
            
            totalAvg += s.getTotalScore();
            if (s.getTotalScore() >= 50) passCount++;
            if (s.getGradeLevel().equals("A")) aCount++;
        }

        sb.append("----------------------------------------\n\n");
        sb.append("班级平均分: ").append(String.format("%.2f", totalAvg / students.size())).append("\n");
        sb.append("及格人数: ").append(passCount).append(" / ").append(students.size()).append("\n");
        sb.append("A级人数: ").append(aCount).append("\n");

        reportArea.setText(sb.toString());
    }
}
