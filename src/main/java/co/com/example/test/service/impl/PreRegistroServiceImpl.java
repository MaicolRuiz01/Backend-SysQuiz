package co.com.example.test.service.impl;


import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import co.com.example.test.entity.CodigoRegistro;
import co.com.example.test.entity.PreRegistro;
import co.com.example.test.entity.Usuario;
import co.com.example.test.repository.ICodigoRegistroRepository;
import co.com.example.test.repository.IPreRegistroRepository;
import co.com.example.test.service.IPreRegistroService;
import co.com.example.test.service.MailService;

@Service
public class PreRegistroServiceImpl implements IPreRegistroService {
	@Autowired
	IPreRegistroRepository preRegistroRepository;
	@Autowired
	ICodigoRegistroRepository codigoRegistroRepository;
	@Autowired
	MailService mailService;

	@Override
	public List<PreRegistro> lista() {
		return preRegistroRepository.findAll();
	}

	@Override
	public Optional<PreRegistro> getById(Integer id) {
		Optional<PreRegistro> preRegistro = preRegistroRepository.findById(id);
		if (preRegistro.isPresent()) {
			return preRegistro;
		}
		return Optional.empty();
	}

	@Override
	public PreRegistro savePreRregistro(PreRegistro preRegistro) {
		//Genero la nueva contraseña
		Random random = new Random();
        int codigo = random.nextInt(900000) + 100000; 
        String password = String.format("%06d", codigo);
        //agrego la contraseña el preRegistro
		preRegistro.setPassword(new BCryptPasswordEncoder().encode(password));
		preRegistro.setEstado("proceso");
		PreRegistro current = preRegistroRepository.save(preRegistro);
		//Creo el codigoRegistro
		Date fecha=new Date();
		CodigoRegistro codigoRegistro=new CodigoRegistro();
		
		codigoRegistro.setCodigo(Integer.parseInt(password));
		codigoRegistro.setEmail(preRegistro.getEmail());
		codigoRegistro.setFechaRegistro(fecha);
		
		Optional<PreRegistro> preRetrun = preRegistroRepository.findById(current.getId());
		if (preRetrun.isPresent()) {
			try {
				codigoRegistro.setPreRegistroId(preRetrun.get().getId());
				preRegistro.setPassword(password);
				mailService.usuarioNuevo(preRegistro);
				codigoRegistroRepository.save(codigoRegistro);
			} catch (MessagingException e) {
				return null;
			}
			return preRetrun.get();
		}
		return null;
	}

	@Override
	public PreRegistro updatePreRegistro(PreRegistro preRegistro, Integer id) {
		Optional<PreRegistro> preCurrent = preRegistroRepository.findById(id);
		if (preCurrent.isPresent()) {
			PreRegistro preReturn = preCurrent.get();
			preReturn.setNombre(preRegistro.getNombre());
			preReturn.setCodigo(preRegistro.getCodigo());
			preReturn.setEmail(preRegistro.getEmail());
			;
			preReturn.setPassword(new BCryptPasswordEncoder().encode(preRegistro.getPassword()));
		}
		return null;
	}

	@Override
	public PreRegistro deletePreRegistro(Integer id) {
		Optional<PreRegistro> preRegistro = preRegistroRepository.findById(id);
		if (preRegistro.isPresent()) {
			preRegistroRepository.deleteById(id);
			return preRegistro.get();
		}
		return null;
	}

	@Override
	public List<PreRegistro> saveLista(List<PreRegistro> lista) {

		List<PreRegistro> listaReturn = new ArrayList<>();
		List<PreRegistro> listaError = new ArrayList<>();
		for (int i = 0; i < lista.size(); i++) {
			lista.get(i).setPassword(new BCryptPasswordEncoder().encode(lista.get(i).getPassword()));
			PreRegistro current = preRegistroRepository.save(lista.get(i));
			Optional<PreRegistro> preRetrun = preRegistroRepository.findById(current.getId());
			if (preRetrun.isPresent()) {
				listaReturn.add(preRetrun.get());
				try {
					mailService.usuarioNuevo(preRetrun.get());
				} catch (MessagingException e) {
					e.printStackTrace();
				}
			} else {
				listaError.add(lista.get(i));
			}

		}

		return listaReturn;
	}

	@Override
	public Boolean existePreregistro(PreRegistro preRegistro) {

		List<PreRegistro> lista = preRegistroRepository.findByCodigo(preRegistro.getCodigo());
		if (lista.size() >= 1) {

			PreRegistro pre = lista.get(lista.size() - 1);
			Integer documento = preRegistro.getDocumento();
			if (pre.getDocumento().equals(documento) && pre.getEstado().equals("proceso")) {
				Optional<CodigoRegistro>codigoR=codigoRegistroRepository.findByPreRegistroId(pre.getId());
				if(codigoR.isPresent()) {
					Integer pass=Integer.parseInt(preRegistro.getPassword());
					if(codigoR.get().getCodigo().equals(pass)) {
						return true;
					}
				}
			}
		}

		return false;
	}

	@Override
	public Boolean verificoCodigo(PreRegistro preRegistro) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
