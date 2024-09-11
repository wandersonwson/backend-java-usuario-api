package dev.wson.usuario_api.controladores;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import dev.wson.usuario_api.modelos.UsuarioDTO;
import dev.wson.usuario_api.servicos.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public UsuarioDTO salvar(@RequestBody UsuarioDTO usuarioDTO) {
        return usuarioService.salvar(usuarioDTO);
    }
    @GetMapping
    public List<UsuarioDTO> buscarUsuarios() {
        List<UsuarioDTO> usuarios = usuarioService.buscarTodos();
        return usuarios;
    }
    @GetMapping("/{id}")
    public UsuarioDTO buscarPorId(@PathVariable long id) {
        return usuarioService.buscarPorId(id);
    }
    @GetMapping("/{cpf}")
    public UsuarioDTO buscarPorCpf(@PathVariable String cpf) {
        return usuarioService.buscarPorCpf(cpf);
    }
    @GetMapping("/busca")
    public List<UsuarioDTO> buscarPorNome(@RequestParam(name = "nome", required = true) String nome) {
        return usuarioService.buscarPorNome(nome);
    }
}