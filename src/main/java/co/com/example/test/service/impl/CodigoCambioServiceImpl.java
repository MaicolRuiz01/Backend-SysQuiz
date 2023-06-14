package co.com.example.test.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.example.test.entity.CodigoCambio;
import co.com.example.test.entity.Usuario;
import co.com.example.test.repository.ICodigoCambioRepository;
import co.com.example.test.repository.IUsuarioRepository;
import co.com.example.test.service.ICodigoCambioService;
import co.com.example.test.service.MailService;
@Service
public class CodigoCambioServiceImpl implements ICodigoCambioService{
	@Autowired
	ICodigoCambioRepository codigoCambioRepository;
	@Autowired
	IUsuarioRepository usuarioRepository;
	@Autowired
	MailService mailService;

	@Override
	public List<CodigoCambio> findAll() {
		return codigoCambioRepository.findAll();
	}

	@Override
	public Optional<CodigoCambio> findById(Integer id) {
		
		Optional<CodigoCambio>codigo=codigoCambioRepository.findById(id);
		if(codigo.isPresent()) {
			return codigo;
		}
		return Optional.empty();
	}

	@Override
	public CodigoCambio saveCodigoCambio(CodigoCambio codigoCambio) {
		Optional<Usuario>usuario=usuarioRepository.findByEmail(codigoCambio.getEmail());
		if(usuario.isPresent()) {
			Date fecha=new Date();
			int codigo = (int) Math.round(Math.random() * 1000000);
			codigoCambio.setUsuarioId(usuario.get().getId());
			codigoCambio.setMensaje("CODIGO PARA RETABLECER  CONTRASEÑA");
			codigoCambio.setFechaRegistro(fecha);
			codigoCambio.setCodigo(codigo);
			CodigoCambio cogidoCurrent=codigoCambioRepository.save(codigoCambio);
			Optional<CodigoCambio>codigoReturn=codigoCambioRepository.findById(cogidoCurrent.getId());
			if(codigoReturn.isPresent()) {
				try {
					mailService.cambioPassword(usuario.get(), codigo);
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return codigoReturn.get();
			}
			
		}
		
		return null;
	}

	@Override
	public CodigoCambio updateCodigoCambio(CodigoCambio codigoCambio, Integer id) {
		Optional<CodigoCambio>codigoCurrent=codigoCambioRepository.findById(id);
		if(codigoCurrent.isPresent()) {
			CodigoCambio codigoReturn=codigoCurrent.get();
			codigoReturn.setMensaje(codigoCambio.getMensaje());
			codigoCambioRepository.save(codigoReturn);
			return codigoReturn;
		}
		return null;
	}

	@Override
	public void deleteCodigoCambio(Integer id) {
		Optional<CodigoCambio>codigoCambio=codigoCambioRepository.findById(id);
		if(codigoCambio.isPresent()) {
			codigoCambioRepository.deleteById(id);
		}
		
	}
	

}
