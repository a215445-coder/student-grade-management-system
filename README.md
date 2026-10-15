# 学生成绩管理系统 (Student Grade Management System)

## 项目简介
这是 TTTK1233 小组作业的初始模板，使用 Java Swing GUI 开发。

## 项目结构
```
StudentGradeSystem/
├── src/
│   └── com/
│       └── studentgrade/
│           ├── Main.java              # 主入口（启动程序）
│           ├── MainFrame.java         # 主窗口（选项卡布局）
│           ├── Student.java          # 学生类（数据模型）
│           ├── StudentManager.java   # 数据管理（用ArrayList）
│           ├── AddStudentPanel.java    # 功能1: 添加学生
│           ├── StudentListPanel.java   # 功能2: 学生列表
│           ├── GradeEntryPanel.java    # 功能3: 录入成绩
│           ├── GradeReportPanel.java   # 功能4: 成绩报告
│           └── SearchStudentPanel.java # 功能5: 搜索学生
```

## 5个功能分工（每人一个）
| 成员 | 负责文件 | 功能 |
|------|----------|------|
| 成员A | AddStudentPanel.java | 添加学生 |
| 成员B | StudentListPanel.java | 学生列表查看 |
| 成员C | GradeEntryPanel.java | 录入/修改成绩 |
| 成员D | GradeReportPanel.java | 生成成绩报告 |
| 成员E | SearchStudentPanel.java | 搜索学生 |

## OOP概念已应用
- **类和对象**: Student类、StudentManager类
- **封装**: Student类的私有属性 + getter/setter
- **继承**: （可在各自面板中扩展，比如做不同类型的学生类）
- **多态**: （可扩展，比如不同课程的成绩计算方式不同）

## 如何运行
1. 用 Eclipse 导入这个项目
2. 右键 Main.java → Run As → Java Application
3. 程序会弹出一个窗口，有5个标签页

## 作业要求对照
- [x] Java GUI (Swing)
- [x] 不用数据库，用 ArrayList 存储
- [x] 至少5个主要功能
- [x] 每个成员一个功能
- [x] OOP概念应用
- [x] 现实问题（学生成绩管理）
