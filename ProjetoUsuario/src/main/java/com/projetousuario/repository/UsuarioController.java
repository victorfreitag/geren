package com.projetousuario.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetousuario.entities.Usuario;
import com.projetousuario.usuario.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	private final UsuarioService usuarioService;
	
	@Autowired
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> buscarId(@PathVariable Long id){
		Usuario usuario = usuarioService.buscarId(id);
		if(usuario != null) {
			return ResponseEntity.ok(usuario);
		}
		else {
			return ResponseEntity.notFound().build();
		}}
	
		@GetMapping("/")
		public ResponseEntity <List<Usuario>> buscartodos(){
		List<Usuario> usuarios = usuarioService.buscarTodos();
		return ResponseEntity.ok(usuarios);
	}
		@PostMapping("/")
		public ResponseEntity<Usuario>salvar(@RequestBody @Valid Usuario usuario){
			Usuario salvar = usuarioService.salvar(usuario);
			return ResponseEntity.status(HttpStatus.CREATED).body(salvar);
		}
		@PutMapping("/")
		public ResponseEntity<Usuario> alterar(@PathVariable Long id, @RequestBody @Valid Usuario usuario){
			Usuario alterar = usuarioService.alterar(id, usuario);
			if(alterar !=null) {
				return ResponseEntity.ok(usuario);
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}
			@DeleteMapping("/{id}")
			public ResponseEntity<Usuario> apagar(@PathVariable Long id){
				boolean apagar = usuarioService.apagar(id);
				if(apagar) {
					return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
				}
				else {
					return ResponseEntity.notFound().build();
				}
			}
		}
		


