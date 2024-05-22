package com.cglia.sms.dao.impl;

import java.sql.Connection;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cglia.sms.dao.StudentDAO;
import com.cglia.sms.db.util.DataBaseUtil;
import com.cglia.sms.model.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {
	@Override
	public Integer save(Student student) {
	    final String query = "INSERT INTO student(name,age,department) values (?,?,?)";
	    Integer rollNo=0;
	    try (
	        Connection con = DataBaseUtil.getConnection();
	        PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	    ) {
	        ps.setString(1, student.getName());
	        ps.setDouble(2, student.getAge());
	        ps.setString(3, student.getDepartment());
	        int count = ps.executeUpdate();
	        if (count != 0) {
	            try (ResultSet rs = ps.getGeneratedKeys()) {
	                if (rs.next()) {
	                    rollNo = rs.getInt(1);
	                    System.out.println("Student saved with rollNo=" + rollNo);
	                }
	            }
	        } else {
	            System.out.println("Student save failed");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return rollNo;
	}


	public Student getByRollNo(Integer rollNo) {
		final String query="SELECT * FROM student WHERE id = ?";
		Student student=null;
		try(Connection con=DataBaseUtil.getConnection();
				PreparedStatement stmt=con.prepareStatement(query)){
			stmt.setInt(1, rollNo);
			try(ResultSet rs=stmt.executeQuery()){
				if(rs.next()) {
					student=new Student();
					student.setRollNo(rs.getInt("rollNo"));
					student.setName(rs.getString("name"));
					student.setAge(rs.getInt("age"));
					student.setDepartment(rs.getString("department"));
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return student;
	}

	public int update(Student student) {
		final String query="UPDATE student SET name = ?,  age = ?, department = ? WHERE id = ?";
		int count=0;
		try(Connection con=DataBaseUtil.getConnection();
				PreparedStatement stmt=con.prepareStatement(query)){
			stmt.setString(1, student.getName());
			stmt.setDouble(2, student.getAge());
			stmt.setString(3, student.getDepartment());
			stmt.setInt(4, student.getRollNo());
			count=stmt.executeUpdate();
			if(count!=0) {
				System.out.println("Student with ROLL_NO:"+student.getRollNo()+" is updated");
			}else {
				System.out.println("update failed.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	public List<Student> getAll() {
		final String query="SELECT * FROM student";
		List<Student> studentList=new ArrayList<>();
		
		try(Connection con=DataBaseUtil.getConnection();
			Statement stmt=con.createStatement();	){
			boolean areAnyRecords=stmt.execute(query);
			if(areAnyRecords) {
				try(ResultSet rs=stmt.getResultSet()){
					if(rs!=null) {
						while(rs.next()) {
							Student student=new Student();
							student.setRollNo(rs.getInt("ID"));
							student.setName(rs.getString(2));
							student.setAge(rs.getInt(3));
							student.setDepartment(rs.getString(4));
							studentList.add(student);
						}
					}
				}
			}
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return studentList;
	}


	@Override
	public int deleteByRollNO(Integer rollNo) {
		final String query="DELETE FROM student WHERE rollNo=?";
		int count=0;
		try(Connection con=DataBaseUtil.getConnection();
				PreparedStatement stmt=con.prepareStatement(query);	){
			stmt.setInt(1, rollNo);
			count=stmt.executeUpdate();
			
			if(count!=0) {
				System.out.println("Student with ROLL_NO:"+rollNo+" is deleted");
			}else {
				System.out.println("Deletion failed.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return count;
	}
}
