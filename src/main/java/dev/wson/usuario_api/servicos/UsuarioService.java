package dev.wson.usuario_api.servicos;

import dev.wson.usuario_api.modelos.*;
import dev.wson.usuario_api.repositorios.UsuarioRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioDTO salvar(UsuarioDTO usuarioDTO) {
        Usuario novUsuario = usuarioRepository.save(Usuario.converterParaUsuario(usuarioDTO));
        return UsuarioDTO.converterParaUsuarioDTO(novUsuario);
    }
    public List<UsuarioDTO> buscarTodos() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios
            .stream()
            .map(UsuarioDTO::converterParaUsuarioDTO)
            .collect(Collectors.toList());
    }
    public UsuarioDTO buscarPorId(long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isEmpty()) {
            return null;
        }
        return UsuarioDTO.converterParaUsuarioDTO(usuario.get());
    }
    public UsuarioDTO buscarPorCpf(String cpf) {
        Optional<Usuario> usuario = usuarioRepository.findByCpf(cpf);
        if (usuario.isEmpty()) {
            return null;
        }
        return UsuarioDTO.converterParaUsuarioDTO(usuario.get());
    }
    public List<UsuarioDTO> buscarPorNome(String nome) {
        List<Usuario> usuarios = usuarioRepository.queryByNomeLike(nome);
        return usuarios
            .stream()
            .map(UsuarioDTO::converterParaUsuarioDTO)
            .collect(Collectors.toList());
    }
    public boolean excluir(long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isEmpty()) {
            return false;
        }
        usuarioRepository.delete(usuario.get());
        return true;
    }
}