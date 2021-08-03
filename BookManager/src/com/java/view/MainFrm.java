package com.java.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainFrm extends JFrame {

	private JPanel contentPane;
	private JDesktopPane table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrm frame = new MainFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrm() {
		setTitle("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF\u4E3B\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u57FA\u672C\u6570\u636E\u7EF4\u62A4");
		menu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/base.png")));
		menuBar.add(menu);
		
		JMenu menu_1 = new JMenu("\u56FE\u4E66\u7C7B\u522B\u7BA1\u7406");
		menu_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/bookTypeManager.png")));
		menu.add(menu_1);
		
		JMenuItem menuItem = new JMenuItem("\u56FE\u4E66\u7C7B\u522B\u6DFB\u52A0");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookTypeAddInterFrm bookTypeAddInterFrm = new BookTypeAddInterFrm();
				bookTypeAddInterFrm.setVisible(true);
//				table.add(bookTypeAddInterFrm);	
			}
		});
		menuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/add.png")));
		menu_1.add(menuItem);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u56FE\u4E66\u7C7B\u522B\u7EF4\u62A4");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BookTypeManageInterFrm bookTypeManageInterFrm = new BookTypeManageInterFrm();
				bookTypeManageInterFrm.setVisible(true);
//				table.add(bookTypeManageInterFrm);		//将图书类别维护界面添加到主界面中
			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/edit.png")));
		menu_1.add(mntmNewMenuItem);
		
		JMenu menu_2 = new JMenu("\u56FE\u4E66\u7BA1\u7406");
		menu_2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/bookManager.png")));
		menu.add(menu_2);
		
		JMenuItem menuItem_3 = new JMenuItem("\u56FE\u4E66\u6DFB\u52A0");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BookAddInterFrm bookAddInterFrm = new BookAddInterFrm();
				bookAddInterFrm.setVisible(true);
			}
		});
		menuItem_3.setIcon(new ImageIcon(MainFrm.class.getResource("/images/add.png")));
		menu_2.add(menuItem_3);
		
		JMenuItem menuItem_4 = new JMenuItem("\u56FE\u4E66\u7EF4\u62A4");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BookManageInterfrm bookManageInterFrm = new BookManageInterfrm();
				bookManageInterFrm.setVisible(true);
			}
		});
		menuItem_4.setIcon(new ImageIcon(MainFrm.class.getResource("/images/edit.png")));
		menu_2.add(menuItem_4);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u5206\u9875\u67E5\u8BE2");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//分页查询
				BookPageSearchFrm bookPageSearchFrm = new BookPageSearchFrm();
				bookPageSearchFrm.setVisible(true);
			}
		});
		mntmNewMenuItem_2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/search.png")));
		menu_2.add(mntmNewMenuItem_2);
		
		JMenuItem menuItem_1 = new JMenuItem("\u5B89\u5168\u9000\u51FA");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result=	JOptionPane.showConfirmDialog(null, "是否退出系统");
				if (result==0) {
					dispose();
					JOptionPane.showMessageDialog(null, "退出成功！");
				}
			}
		});
		menuItem_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/exit.png")));
		menu.add(menuItem_1);
		
		JMenu menu_3 = new JMenu("\u5173\u4E8E\u6211\u4EEC");
		menu_3.setIcon(new ImageIcon(MainFrm.class.getResource("/images/about.png")));
		menuBar.add(menu_3);
		
		JMenuItem mntmAuthorhuchao = new JMenuItem("Author\uFF1A@HuChao");
		mntmAuthorhuchao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JavaInterFrm javaInterFrm = new JavaInterFrm();
				javaInterFrm.setVisible(true);
//				table.add(javaInterFrm);	//添加窗体
			}
		});
		mntmAuthorhuchao.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u80E1\u8D85.png")));
		menu_3.add(mntmAuthorhuchao);
		
		JMenu mnNewMenu = new JMenu("\u70B9\u51FB\u5173\u6CE8");
		menu_3.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("CSDN");
		mnNewMenu.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("  ");
		mntmNewMenuItem_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/csdn.png")));
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_2 = new JMenu("\u7B80\u4E66");
		mnNewMenu.add(mnNewMenu_2);
		
		JMenuItem menuItem_2 = new JMenuItem("");
		menuItem_2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u7B80\u4E66.png")));
		mnNewMenu_2.add(menuItem_2);
		
		JMenu mnNewMenu_3 = new JMenu("bilibili");
		mnNewMenu.add(mnNewMenu_3);
		
		JMenuItem menuItem_5 = new JMenuItem("");
		menuItem_5.setIcon(new ImageIcon(MainFrm.class.getResource("/images/bili.png")));
		mnNewMenu_3.add(menuItem_5);
		
		JMenu menu_4 = new JMenu("\u6296\u97F3");
		mnNewMenu.add(menu_4);
		
		JMenuItem menuItem_6 = new JMenuItem("  ");
		menuItem_6.setIcon(new ImageIcon(MainFrm.class.getResource("/images/douyin.png")));
		menu_4.add(menuItem_6);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JDesktopPane table = new JDesktopPane();
		table.setBackground(Color.GRAY);
		contentPane.add(table, BorderLayout.CENTER);
		
		//设置JFrame最大化
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
}
