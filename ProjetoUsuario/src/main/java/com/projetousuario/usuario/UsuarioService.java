package com.projetousuario.usuario;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetousuario.entities.Usuario;
import com.projetousuario.repository.UsuarioRepository;

@Service
public class UsuarioService {

	private UsuarioRepository usuarioRepository;
		
	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	public List<Usuario> buscarTodos(){
	return usuarioRepository.findAll();
	}
	public Usuario buscarId(Long id) {
		Optional <Usuario> Usuario = usuarioRepository.findById(id);
		return Usuario.orElse(null);
	}
	public Usuario salvar(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	public Usuario alterar(Long id, Usuario alterarprod) {
		Optional <Usuario> existe  = usuarioRepository.findById(id);
		if(existe.isPresent()) {
			alterarprod.setId(id);
			return usuarioRepository.save(alterarprod);
		}
		return null;
	}
	public boolean apagar(Long id) {
		Optional <Usuario> existe = usuarioRepository.findById(id);
		if(existe.isPresent()) {
			usuarioRepository.deleteById(id);
			return true;
		}
				
		return false;
	}

}