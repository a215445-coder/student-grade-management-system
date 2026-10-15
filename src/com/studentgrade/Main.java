package com.studentgrade;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 * 主入口类
 * 启动整个学生成绩管理系统
 */
public class Main {
    public static void main(String[] args) {
        // 设置系统风格外观
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // 在事件 dispatch 线程中启动 GUI
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
        });
    }
}
