package com.java.dao;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.java.model.Book_B;
import com.java.util.DbUtil;
import com.java.util.StringUtil;

/**
 * ͼ��Dao��
 * @author Hasee
 *
 */
public class BookDao {
	
	/**
	 * ͼ�����
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con,Book_B book1) throws Exception {
//		System.out.println(book.getBookName());
		String sql = "insert into t_book values(null,?,?,?,?,?,?)";
		PreparedStatement pstmt =con.prepareStatement(sql);
		pstmt.setString(1, book1.getBookName());
		pstmt.setString(2, book1.getAuthor());
		pstmt.setString(3, book1.getSex());
		pstmt.setFloat(4, book1.getPrice());
		pstmt.setString(5, book1.getBookDesc());
		pstmt.setInt(6, book1.getBookTypeId());
		return pstmt.executeUpdate();
	}
	
	/**
	 * ͼ����Ϣ��ѯ
	 * @param con
	 * @param book1
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection con,Book_B book1)throws Exception{
		StringBuffer sb = new StringBuffer("select * from t_book b,t_bookType bt where b.bookTypeId=bt.id");	//������ѯ boo������=bookType�������
		if (book1.getBookName()!=null) {
			sb.append(" and b.bookName like '%"+book1.getBookName()+"%'");	//ģ����ѯ
		}
		if (book1.getAuthor()!=null) {
			sb.append(" and b.author like '%"+book1.getAuthor()+"%'");	//ģ����ѯ
		}
		if (book1.getBookTypeId()!=null&&book1.getBookTypeId()!=-1) {
			sb.append(" and b.bookTypeId="+book1.getBookTypeId());
		}
		PreparedStatement pstmt = con.prepareStatement(sb.toString());
		return pstmt.executeQuery();
	}
	
	/**
	 * ��ҳ��ѯ
	 * ���Ӳ�ѯ  ������
	 * @param solider
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public ResultSet query(Connection con,Book_B book,int page) throws Exception {
//		Connection con=DbUtil.getCon();
		StringBuffer sb1=new StringBuffer("SELECT s.id,`bookName`,`author`,`sex`,`price`,`bookDesc`,`bookTypeName`,`bookTypeId`\r\n" + 
				"FROM t_booktype s\r\n" + 
				"INNER JOIN t_book r\r\n" + 
				"ON s.id = r.bookTypeId");
		sb1.append(" limit "+(page-1)*10+",10");
		System.out.println(sb1);
		PreparedStatement ps=con.prepareStatement(sb1.toString());
		
		return ps.executeQuery();
	}
	
	/**
	 * ͼ����Ϣɾ��
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int delete(Connection con,String id)throws Exception {
		String sql = "delete from t_book where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1,id);
		return pstmt.executeUpdate();
	}
	
	/**
	 * ͼ����Ϣ�޸�
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public int update(Connection con,Book_B book)throws Exception{
		String sql="update t_book set bookName=?,author=?,sex=?,price=?,bookDesc=?,bookTypeId=? where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, book.getBookName());
		pstmt.setString(2, book.getAuthor());
		pstmt.setString(3, book.getSex());
		pstmt.setFloat(4, book.getPrice());
		pstmt.setString(5, book.getBookDesc());
		pstmt.setInt(6, book.getBookTypeId());
		pstmt.setInt(7, book.getId());
		return pstmt.executeUpdate();
	}
	
	/**
	 * ָ��ͼ��������Ƿ����ͼ��
	 * @param con
	 * @param bookTypeId
	 * @return
	 * @throws Exception
	 */
	public boolean existBookByBookTypeId(Connection con,String bookTypeId)throws Exception{
		String sql="select * from t_book where bookTypeId=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, bookTypeId);
		ResultSet rs=pstmt.executeQuery();
		return rs.next();
	}
}