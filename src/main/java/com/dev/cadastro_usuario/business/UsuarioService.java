package com.dev.cadastro_usuario.business;

import com.dev.cadastro_usuario.infrastructure.entitys.Usuario;
import com.dev.cadastro_usuario.infrastructure.exceptions.UsuarioExceptions;
import com.dev.cadastro_usuario.infrastructure.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository){
        this.repository = repository;

    }

    public Usuario salvarUsuario(Usuario usuario){
        repository.saveAndFlush(usuario);
        return usuario;
    }

    public Usuario buscarUsuarioPorEmail(String email){
        return repository.findByEmail(email).orElseThrow(
                () -> new UsuarioExceptions("Email não encontrado")
        );

    }
    public Usuario buscarUsuarioPorId(Integer id){
        return repository.findById(id).orElseThrow(()-> new UsuarioExceptions("Id não encontrado!"));
    }

    public void deletaUsuarioPorEmail(String email){
        if (!repository.existsByEmail(email)) {
            throw new UsuarioExceptions("Email não encontrado.");
        }
            repository.deleteByEmail(email);
    }

    public void atualizarUsuarioPorId(Integer id, Usuario usuario){
        Usuario usuarioEntity = repository.findById(id).orElseThrow(()-> new UsuarioExceptions("Usuário Não encontrado!"));
        Usuario usuarioAtualizado = Usuario.builder()
                .email(usuario.getEmail()!=null ? usuario.getEmail():usuarioEntity.getEmail())
                .nome(usuario.getNome()!=null ? usuario.getNome():usuarioEntity.getNome())
                .id(usuarioEntity.getId())
                .build();

        repository.saveAndFlush(usuarioAtualizado);
    }

    public void deletaUsuarioPorId(Integer id){
        if(!repository.existsById(id)){
            throw new UsuarioExceptions("Usuário não encontrado!");
        }
        repository.deleteById(id);
    }
}
