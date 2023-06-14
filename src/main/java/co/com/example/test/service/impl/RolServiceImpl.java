package co.com.example.test.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.example.test.entity.Rol;
import co.com.example.test.repository.IRolRepository;
import co.com.example.test.service.IRolService;
@Service
public class RolServiceImpl implements IRolService{
	@Autowired
	IRolRepository rolRepository;

	@Override
	public List<Rol> AllRol() {
		return rolRepository.findAll();
	}

	@Override
	public Optional<Rol> getById(Integer id) {
		Optional<Rol>rol=rolRepository.findById(id);
		if(rol.isPresent()) {
			return rol;
		}
		return Optional.empty();
	}

	@Override
	public Rol saveRol(Rol rol) {
		Rol rolCurrent=rolRepository.save(rol);
		Optional<Rol>rolNew=rolRepository.findById(rolCurrent.getId());
		if(rolNew.isPresent()) {
			return rolNew.get();
		}
		return null;
	}

	@Override
	public Rol updateRol(Integer id, Rol rol) {
		Optional<Rol>rolCurrent=rolRepository.findById(id);
		if(rolCurrent.isPresent()) {
			Rol rolReturn=rolCurrent.get();
			rolReturn.setNombre(rol.getNombre());
			rolRepository.save(rolReturn);
		}
		return null;
	}

	@Override
	public void deleteRol(Integer id) {
		Optional<Rol>rol=rolRepository.findById(id);
		if(rol.isPresent()) {
			rolRepository.deleteById(id);
		}
		
	}

}
