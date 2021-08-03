package com.java.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.Book;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.java.dao.BookDao;
import com.java.dao.BookTypeDao;
import com.java.model.BookType;
import com.java.model.Book_B;
import com.java.util.DbUtil;
import com.java.util.StringUtil;

public class BookManageInterfrm extends JFrame {

	private JPanel contentPane;
	private JTable bookTable;
	private JTextField s_bookNameTxt;
	private JTextField s_authorTxt;
//	private JTextArea bookDescTxt;
	private BookDao bookDao = new BookDao();
	
	private JComboBox s_bookTypeJcb;
	
	private DbUtil dbutil = new DbUtil();
	private BookTypeDao bookTypeDao = new BookTypeDao();
	private JTextField idTxt;
	private JTextField bookNameTxt;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField priceTxt;
	private JTextField authorTxt;
	
	private JRadioButton manJrb;
	private JRadioButton femaleJrb;
	private JTextArea bookDescTxt;
	private JComboBox bookTypeJcb;
	
	private static int page=1;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookManageInterfrm frame = new BookManageInterfrm();
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
	public BookManageInterfrm() {
		setTitle("\u56FE\u4E66\u7BA1\u7406");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 876, 737);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u641C\u7D22\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton btnNewButton_1 = new JButton("\u4E0A\u4E00\u9875");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//��һҳ
				prevActionPerfromed(arg0);
			}
		});
		
		JButton btnNewButton_2 = new JButton("\u4E0B\u4E00\u9875");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nextActionPerfromed(e);		//��һҳ
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton btnNewButton_3 = new JButton("\u4FEE\u6539");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bookUpdateActionPerformed(arg0);
			}
		});
		btnNewButton_3.setIcon(new ImageIcon(BookManageInterfrm.class.getResource("/images/modify.png")));
		
		JButton btnNewButton_4 = new JButton("\u5220\u9664");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bookDeleteActionPerformed(arg0);
			}
		});
		btnNewButton_4.setIcon(new ImageIcon(BookManageInterfrm.class.getResource("/images/delete.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 755, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(56)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 753, Short.MAX_VALUE)
								.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 753, Short.MAX_VALUE))))
					.addGap(41))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(120)
					.addComponent(btnNewButton_1)
					.addPreferredGap(ComponentPlacement.RELATED, 380, Short.MAX_VALUE)
					.addComponent(btnNewButton_2)
					.addGap(212))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(100)
					.addComponent(btnNewButton_3)
					.addPreferredGap(ComponentPlacement.RELATED, 402, Short.MAX_VALUE)
					.addComponent(btnNewButton_4)
					.addGap(194))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_3)
						.addComponent(btnNewButton_4))
					.addContainerGap())
		);
		
		JLabel lblNewLabel_3 = new JLabel("\u7F16\u53F7\uFF1A");
		
		idTxt = new JTextField();
		idTxt.setColumns(10);
		
		bookNameTxt = new JTextField();
		bookNameTxt.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		
		JLabel lblNewLabel_5 = new JLabel("\u4F5C\u8005\u6027\u522B\uFF1A");
		
		manJrb = new JRadioButton("\u7537");
		buttonGroup.add(manJrb);
		manJrb.setSelected(true);
		
		femaleJrb = new JRadioButton("\u5973");
		buttonGroup.add(femaleJrb);
		
		JLabel lblNewLabel_6 = new JLabel("\u4EF7\u683C\uFF1A");
		
		priceTxt = new JTextField();
		priceTxt.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("\u56FE\u4E66\u4F5C\u8005\uFF1A");
		
		authorTxt = new JTextField();
		authorTxt.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("\u56FE\u4E66\u7C7B\u522B;");
		
		JLabel lblNewLabel_9 = new JLabel("\u56FE\u4E66\u7C7B\u522B\uFF1A");
		
	    bookDescTxt = new JTextArea();
		
		bookTypeJcb = new JComboBox();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(17)
							.addComponent(lblNewLabel_3)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
							.addGap(33)
							.addComponent(lblNewLabel_4)
							.addGap(5)
							.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
							.addGap(43)
							.addComponent(lblNewLabel_5)
							.addGap(6)
							.addComponent(manJrb)
							.addGap(12)
							.addComponent(femaleJrb))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(19)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblNewLabel_9)
									.addGap(2)
									.addComponent(bookDescTxt, GroupLayout.PREFERRED_SIZE, 619, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblNewLabel_6)
									.addGap(7)
									.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
									.addGap(32)
									.addComponent(lblNewLabel_7)
									.addGap(5)
									.addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
									.addGap(45)
									.addComponent(lblNewLabel_8)
									.addGap(11)
									.addComponent(bookTypeJcb, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(53, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(21)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
										.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_3)))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(25)
									.addComponent(lblNewLabel_4))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(22)
									.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(23)
									.addComponent(manJrb))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(25)
									.addComponent(lblNewLabel_5))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(23)
									.addComponent(femaleJrb)))
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(29)
									.addComponent(lblNewLabel_6))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(30)
									.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(34)
									.addComponent(lblNewLabel_7))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(30)
									.addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(33)
									.addComponent(lblNewLabel_8)))
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(37)
									.addComponent(lblNewLabel_9))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(34)
									.addComponent(bookDescTxt, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(78)
							.addComponent(bookTypeJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		
		s_bookNameTxt = new JTextField();
		s_bookNameTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u56FE\u4E66\u4F5C\u8005\uFF1A");
		
		s_authorTxt = new JTextField();
		s_authorTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u56FE\u4E66\u7C7B\u522B\uFF1A");
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bookSearchActionPerformed(arg0);
			}
		});
		btnNewButton.setIcon(new ImageIcon(BookManageInterfrm.class.getResource("/images/search.png")));
		
		s_bookTypeJcb = new JComboBox();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(s_bookNameTxt, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
					.addGap(22)
					.addComponent(lblNewLabel_1)
					.addGap(14)
					.addComponent(s_authorTxt, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addGap(25)
					.addComponent(lblNewLabel_2)
					.addGap(14)
					.addComponent(s_bookTypeJcb, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(26))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addComponent(s_bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(14)
							.addComponent(lblNewLabel_1))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(s_authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(11)
							.addComponent(lblNewLabel_2))
						.addGroup(gl_panel.createSequentialGroup()
				
								.addGap(9)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(s_bookTypeJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton))))
					.addContainerGap(18, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		bookTable = new JTable();
		bookTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				bookTableMousePressed(arg0);
			}
		});
		bookTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u56FE\u4E66\u540D\u79F0", "\u56FE\u4E66\u4F5C\u8005", "\u4F5C\u8005\u6027\u522B", "\u56FE\u4E66\u4EF7\u683C", "\u56FE\u4E66\u63CF\u8FF0", "\u56FE\u4E66\u7C7B\u522B", "\u56FE\u4E66\u7C7B\u522BID"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(bookTable);
		contentPane.setLayout(gl_contentPane);
		
		this.setLocationRelativeTo(null);		//���ô��������ʾ
		
		// �����ı���߿�
		bookDescTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185), 1, false));
		
		this.fillBookType("search");
		this.fillBookType("modify");
		
		this.fillTable(new Book_B());
		this.fillTable1(new Book_B());
	}
	
	/**
	 * ��һҳ
	 * @param e
	 */
	private void prevActionPerfromed(ActionEvent e) {
		if(page==1) {
			return;
		}
		page--;
		this.fillTable1(new Book_B());
		}
	
	/**
	 * ��һҳ
	 * @param e
	 */
	private void nextActionPerfromed(ActionEvent ent) {
		page++;
//		if(page) {
//			return;
//		}
		this.fillTable1(new Book_B());
	}
	

	/**
	 * ͼ��ɾ���¼�����
	 * @param evt
	 */
	private void bookDeleteActionPerformed(ActionEvent evt) {
		String id=idTxt.getText();
		if(StringUtil.isEmpty(id)){
			JOptionPane.showMessageDialog(null, "��ѡ��Ҫɾ���ļ�¼");
			return;
		}
		int n=JOptionPane.showConfirmDialog(null, "ȷ��Ҫɾ���ü�¼��");
		if(n==0){
			Connection con=null;
			try{
				con=dbutil.getCon();
				boolean flag = bookDao.existBookByBookTypeId(con, id);
				if (flag) {
					JOptionPane.showMessageDialog(null, "��ǰͼ���������ͼ�飬����ɾ�������");
					return;
				}
				int deleteNum=bookDao.delete(con, id);
				if(deleteNum==1){
					JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
					this.resetValue();
					this.fillTable(new Book_B());
				}else{
					JOptionPane.showMessageDialog(null, "ɾ��ʧ��");
				}
			}catch(Exception e){
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "ɾ��ʧ��");
			}finally{
				try {
					dbutil.closeCon(con);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}


	/**
	 * ͼ���޸��¼�����
	 * @param arg0
	 */
	private void bookUpdateActionPerformed(ActionEvent evt) {
		String id=this.idTxt.getText();
		if(StringUtil.isEmpty(id)){
			JOptionPane.showMessageDialog(null, "��ѡ��Ҫ�޸ĵļ�¼");
			return;
		}
		
		String bookName=this.bookNameTxt.getText();
		String author=this.authorTxt.getText();
		String price=this.priceTxt.getText();
		String bookDesc=this.bookDescTxt.getText();
		
		if(StringUtil.isEmpty(bookName)){
			JOptionPane.showMessageDialog(null, "ͼ�����Ʋ���Ϊ�գ�");
			return;
		}
		
		if(StringUtil.isEmpty(author)){
			JOptionPane.showMessageDialog(null, "ͼ�����߲���Ϊ�գ�");
			return;
		}
		
		if(StringUtil.isEmpty(price)){
			JOptionPane.showMessageDialog(null, "ͼ��۸���Ϊ�գ�");
			return;
		}
		
		String sex="";
		if(manJrb.isSelected()){
			sex="��";
		}else if(femaleJrb.isSelected()){
			sex="Ů";
		}
		
		BookType bookType=(BookType) bookTypeJcb.getSelectedItem();
		int bookTypeId=bookType.getId();
		
		Book_B book=new Book_B(Integer.parseInt(id),  bookName, author, sex, Float.parseFloat(price),  bookTypeId,  bookDesc);
		
		Connection con=null;
		try{
			con=dbutil.getCon();
			int addNum=bookDao.update(con, book);
			if(addNum==1){
				JOptionPane.showMessageDialog(null, "ͼ���޸ĳɹ���");
				resetValue();					//���ñ�
				this.fillTable(new Book_B());	//��ʼ�����
			}else{
				JOptionPane.showMessageDialog(null, "ͼ���޸�ʧ�ܣ�");
			}
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "ͼ���޸�ʧ�ܣ�");
		}finally{
			try {
				dbutil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * ���ñ�
	 */
	private void resetValue(){
		this.idTxt.setText("");
		this.bookNameTxt.setText("");
		this.authorTxt.setText("");
		this.priceTxt.setText("");
		this.manJrb.setSelected(true);
		this.bookDescTxt.setText("");
		if(this.bookTypeJcb.getItemCount()>0){
			this.bookTypeJcb.setSelectedIndex(0);
		}
	}
	
	/**
	 * ����е���¼�����
	 * @param met
	 */
	private void bookTableMousePressed(MouseEvent met) {
		int row=this.bookTable.getSelectedRow();
		this.idTxt.setText((String)bookTable.getValueAt(row, 0));
		this.bookNameTxt.setText((String)bookTable.getValueAt(row, 1));
		this.authorTxt.setText((String)bookTable.getValueAt(row, 2));
		String sex=(String)bookTable.getValueAt(row, 3);
		if("��".equals(sex)){
			this.manJrb.setSelected(true);
		}else if("Ů".equals(sex)){
			this.femaleJrb.setSelected(true);
		}
		this.priceTxt.setText((Float)bookTable.getValueAt(row, 4)+"");
		this.bookDescTxt.setText((String)bookTable.getValueAt(row, 5));
		String bookTypeName=(String)this.bookTable.getValueAt(row, 6);
		int n=this.bookTypeJcb.getItemCount();
		for(int i=0;i<n;i++){
			BookType item=(BookType)this.bookTypeJcb.getItemAt(i);
			if(item.getBookTypeName().equals(bookTypeName)){
				this.bookTypeJcb.setSelectedIndex(i);
			}
		}
	}

	/**
	 * ͼ���ѯ�¼�����
	 * @param arg0
	 */
	private void bookSearchActionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String bookName = this.s_bookNameTxt.getText();
		String author = this.s_authorTxt.getText();
		BookType bookType =(BookType)this.s_bookTypeJcb.getSelectedItem();
		int bookTypeId=bookType.getId();
		
		Book_B book = new Book_B(bookName,author,bookTypeId);
		this.fillTable(book);
	}

	                              
	/**
	 * ��ʼ��������
	 * @param type  ����������
	 */
	private void fillBookType(String type) {
		Connection con=null;
		BookType bookType = null;
		try {
			con=dbutil.getCon();
			ResultSet rs = bookTypeDao.list(con, new BookType());
			if ("search".equals(type)) {
				bookType = new BookType();	//��ʼ��
				bookType.setBookTypeName("��ѡ��");
				bookType.setId(-1);
				this.s_bookTypeJcb.addItem(bookType);
			}
			while (rs.next()) {
				bookType = new BookType();
				bookType.setBookTypeName(rs.getString("bookTypeName"));
				bookType.setId(rs.getInt("id"));
				if ("search".equals(type)) {
					this.s_bookTypeJcb.addItem(bookType);
				}else if ("modify".equals(type)) {
					this.bookTypeJcb.addItem(bookType);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				dbutil.closeCon(con);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * ��ʼ�����
	 * @param bookType
	 */
	private void fillTable(Book_B book1){
		DefaultTableModel dtm=(DefaultTableModel) bookTable.getModel();	//��ȡTableģ��
		dtm.setRowCount(0); // ���ó�0��
		Connection con=null;
		try{
			con=dbutil.getCon();
			ResultSet rs=bookDao.list(con,book1);
//			rs = bookDao.query(con, book1, page);//��������������
			while(rs.next()){
				Vector v=new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("bookName"));
				v.add(rs.getString("author"));
				v.add(rs.getString("sex"));
				v.add(rs.getFloat("price"));
				v.add(rs.getString("bookDesc"));
				v.add(rs.getString("bookTypeName"));
				v.add(rs.getString("bookTypeId"));
				dtm.addRow(v);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				dbutil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * ��ʼ�����(��ҳ��ѯ)
	 * @param book
	 */
	private void fillTable1(Book_B book){
		DefaultTableModel dtm= (DefaultTableModel) bookTable.getModel();
		dtm.setRowCount(0);//����Ϊ0��,�������
//		ResultSet rs=null;
		Connection con=null;
		try {
			con=dbutil.getCon();
			ResultSet rs = bookDao.query(con, book, page);//��������������
//			System.out.println(rs);
			while(rs.next()) {
				Vector v2=new Vector();//Vector����
				v2.add(rs.getString("id"));
				v2.add(rs.getString("bookName"));
				v2.add(rs.getString("author"));
				v2.add(rs.getString("sex"));
				v2.add(rs.getFloat("price"));
				v2.add(rs.getString("bookDesc"));
				v2.add(rs.getString("bookTypeName"));
				v2.add(rs.getString("bookTypeId"));
				dtm.addRow(v2);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
}
