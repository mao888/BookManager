package com.java.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

//import com.imooc.view.Solider;
import com.java.dao.BookDao;
import com.java.model.Book_B;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionEvent;


/**
 * 分页查询界面
 * @author 分页查询
 *
 */
public class BookPageSearchFrm extends JFrame {

	private JPanel contentPane;
	private JTable BookTable;
	
	private BookDao bookDao = new BookDao();
	
	private static int page=1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookPageSearchFrm frame = new BookPageSearchFrm();
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
	public BookPageSearchFrm() {
		setTitle("\u5206\u9875\u67E5\u8BE2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 571, 359);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnNewButton = new JButton("\u4E0A\u4E00\u9875");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//上一页
				prevActionPerfromed(e);
			}
		});
		
		JButton btnNewButton_1 = new JButton("\u4E0B\u4E00\u9875");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nextActionPerfromed(e);		//下一页
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(41)
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.RELATED, 241, Short.MAX_VALUE)
					.addComponent(btnNewButton_1)
					.addGap(101))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(24)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap(31, Short.MAX_VALUE))
		);
		
		BookTable = new JTable();
		BookTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u56FE\u4E66\u540D\u79F0", "\u56FE\u4E66\u4F5C\u8005", "\u4F5C\u8005\u6027\u522B", "\u56FE\u4E66\u4EF7\u683C", "\u56FE\u4E66\u63CF\u8FF0", "\u56FE\u4E66\u7C7B\u522B"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		BookTable.getColumnModel().getColumn(3).setPreferredWidth(84);
		BookTable.getColumnModel().getColumn(4).setPreferredWidth(103);
		BookTable.getColumnModel().getColumn(5).setPreferredWidth(96);
		BookTable.getColumnModel().getColumn(6).setPreferredWidth(136);
		scrollPane.setViewportView(BookTable);
		contentPane.setLayout(gl_contentPane);
	}
	
	/**
	 * 下一页
	 * @param e
	 */
	private void nextActionPerfromed(ActionEvent e) {
		// TODO Auto-generated method stub
		page++;
//		if(page) {
//			return;
//		}
		this.fillTable(new Book_B());
	}

	/**
	 * 上一页
	 * @param e
	 */
	private void prevActionPerfromed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(page==1) {
			return;
		}
		page--;
		this.fillTable(new Book_B());
		
	}
	
	//初始化表格
	private void fillTable(Book_B book){
		DefaultTableModel dtm= (DefaultTableModel) BookTable.getModel();
		dtm.setRowCount(0);//设置为0行,清空数据
		ResultSet rs=null;
		Connection con =null;
		try {
			rs = bookDao.query(con, book, page);//结果集请求的数据
			while(rs.next()) {
				Vector v=new Vector();//Vector集合
				v.add(rs.getString("id"));
				v.add(rs.getString("name"));
				v.add(rs.getString("age"));
				v.add(rs.getString("starShipId"));
				dtm.addRow(v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	
}
