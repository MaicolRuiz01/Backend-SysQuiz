package co.com.example.test.service;

import java.util.List;
import java.util.Optional;

import co.com.example.test.entity.Rol;

public interface IRolService  {
	
	public List<Rol>AllRol();
	public Optional<Rol>getById(Integer id);
	public Rol saveRol(Rol rol);
	public Rol updateRol(Integer id,Rol rol);
	public void deleteRol(Integer id);
	

}
