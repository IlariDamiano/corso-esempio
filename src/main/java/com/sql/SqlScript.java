package com.sql;

public interface SqlScript {

	public String sqlInsert = "INSERT INTO student(first_name, last_name, age) VALUES (?,?,?)";
	
	public String sqlUpdate= "UPDATE student SET first_name=?, last_name=?, age=? where id=?";
	
	public String sqlDelete = "DELETE FROM student WHERE id=?";
	
	public String sqlRead = "SELECT * FROM student";
	
	public String sqlByIDString = " SELECT * from student where id=?";
}
