package com.studentgrade;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

/**
 * 主窗口
 * 使用选项卡布局，每个功能一个标签页
 */
public class MainFrame extends JFrame {
    
    public MainFrame() {
        // 设置窗口标题
        setTitle("学生成绩管理系统 - Student Grade Management System");
        
        // 设置窗口大小
        setSize(800, 600);
        
        // 关闭窗口时退出程序
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // 窗口居中
        setLocationRelativeTo(null);
        
        // 创建顶部标题面板
        JPanel titlePanel = new JPanel(new FlowLayout());
        JLabel titleLabel = new JLabel("学生成绩管理系统 v1.0");
        titleLabel.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
        titlePanel.add(titleLabel);
        
        // 创建选项卡面板
        JTabbedPane tabbedPane = new JTabbedPane();
        
        // ===== 5个功能标签页（每人负责一个）=====
        
        // 功能1: 添加学生（成员A负责）
        tabbedPane.addTab("添加学生", new AddStudentPanel());
        
        // 功能2: 学生列表（成员B负责）
        tabbedPane.addTab("学生列表", new StudentListPanel());
        
        // 功能3: 录入成绩（成员C负责）
        tabbedPane.addTab("录入成绩", new GradeEntryPanel());
        
        // 功能4: 成绩报告（成员D负责）
        tabbedPane.addTab("成绩报告", new GradeReportPanel());
        
        // 功能5: 搜索学生（成员E负责）
        tabbedPane.addTab("搜索学生", new SearchStudentPanel());
        
        // 添加到窗口
        add(titlePanel, BorderLayout.NORTH);
        add(tabbedPane, BorderLayout.CENTER);
    }
}
