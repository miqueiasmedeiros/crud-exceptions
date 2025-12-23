package com.dev.cadastro_usuario.controller;

import com.dev.cadastro_usuario.business.UsuarioService;
import com.dev.cadastro_usuario.infrastructure.entitys.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> salvarUsuario(@RequestBody Usuario usuario){
       Usuario usuariosalvo = usuarioService.salvarUsuario(usuario);
        return ResponseEntity.ok(usuariosalvo);
    }
    @GetMapping
    public ResponseEntity<Usuario> buscarUsuarioPorEmail(@RequestParam String email){
        return ResponseEntity.ok(usuarioService.buscarUsuarioPorEmail(email));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarUsuarioPorId(@PathVariable Integer id){
        return ResponseEntity.ok(usuarioService.buscarUsuarioPorId(id));
    }

    @DeleteMapping
    public ResponseEntity<String> deletarUsuarioPorEmail(@RequestParam String email){
        usuarioService.deletaUsuarioPorEmail(email);
        return ResponseEntity.ok("Usuário deletado com sucesso!");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarUsuarioPorId(@PathVariable Integer id){
        usuarioService.deletaUsuarioPorId(id);
        return ResponseEntity.ok("Usuário deletado com sucesso!");
    }
    @PutMapping
    public ResponseEntity<Void> atualizarUsuarioPorId(@RequestParam Integer id,
                                                      @RequestBody Usuario usuario){

        usuarioService.atualizarUsuarioPorId(id, usuario);
        return ResponseEntity.ok().build();
    }

}
