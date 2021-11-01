package com.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
	
	Connection con;
	PreparedStatement pstmt;
	
	public List<Student> allStudents() {
		List<Student> stList = new ArrayList<>();
		Student s;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/springdb", "root", "idb@123456");
			pstmt = con.prepareStatement("select * from student");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				//System.out.println(rs.getInt(1));
				s = new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				stList.add(s);
			}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stList;
	}
	
	public Student showbyid(int id) {
		List<Student> stList = new ArrayList<>();
		Student s=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/springdb", "root", "idb@123456");
			pstmt = con.prepareStatement("select * from student where id="+id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				//System.out.println(rs.getInt(1));
				s = new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				//stList.add(s);
			}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	public void insert(Student st) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/springdb", "root", "idb@123456");
			pstmt = con.prepareStatement("insert into student values(?,?,?,?)");
			pstmt.setInt(1, st.id);pstmt.setString(2, st.name);pstmt.setString(3, st.email);pstmt.setString(4, st.round);
			int n = pstmt.executeUpdate();
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void update(Student st) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/springdb", "root", "idb@123456");
			pstmt = con.prepareStatement("update student set name=?,email=?,round=? where id=?");
			pstmt.setString(1, st.name);pstmt.setString(2, st.email);pstmt.setString(3, st.round);pstmt.setInt(4, st.id);
			int n = pstmt.executeUpdate();
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void deletebyid(int id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/springdb", "root", "idb@123456");
			pstmt = con.prepareStatement("delete  from student where id="+id);
			int n = pstmt.executeUpdate();
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

//	public static void main(String[] args) {
//		StudentDao d = new StudentDao();
//		d.allStudents();
//		System.out.println(d.allStudents());
//
//	}
}
