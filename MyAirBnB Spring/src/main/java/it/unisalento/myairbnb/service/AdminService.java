package it.unisalento.myairbnb.service;

import java.util.List;

import it.unisalento.myairbnb.entities.Admin;

public interface AdminService {
	
	public List<Admin> getAll();
	public Admin getByUsernameandPassword(String username, String password);
	public Admin getById(int id);
	public Admin saveorUpdate(Admin admin);

	

}
