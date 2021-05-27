package com.cg.bookmydoctor.dao;

import java.util.List;

import com.cg.bookmydoctor.dto.Admin;

public interface IAdminDao {

	
	public Admin addAdmin(Admin admin);
	public Admin updateAdmin(Admin admin);
	public Admin removeAdmin(Admin admin);
	public Admin viewAdmin(Admin admin);
	
}