package com.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class EmpDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void save(Employee e)
	{
		String sql = "insert into empmng values('"+e.getEmpid()+"','"+e.getEmpname()+"','"+e.getEmpsalary()+"')";
		
		jdbcTemplate.execute(sql);
	}
	
	public void update(Employee e)
	{
		String sql = "update empmng set emp_name = '"+e.getEmpname()+"', emp_salary = '"+e.getEmpsalary()+"' where emp_id = '"+e.getEmpid()+"'";
		
		jdbcTemplate.execute(sql);
	}
	
	public void delete(Employee e)
	{
		String sql = "delete from empmng where emp_id = '"+e.getEmpid()+"'";
		
		jdbcTemplate.execute(sql);
	}

}
