package dev.wson.usuario_api.modelos;

import lombok.Data;
import org.springframework.stereotype.Component;
import java.time.LocalDate;

@Data
@Component
public class UsuarioDTO {
    private String nome;
    private String cpf;
    private String endereco;
    private String email;
    private String telefone;
    private LocalDate dataCadastro;

    public static UsuarioDTO converterParaUsuarioDTO(Usuario usuario) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setNome(usuario.getNome());
        usuarioDTO.setEndereco(usuario.getEndereco());
        usuarioDTO.setCpf(usuario.getCpf());
        usuarioDTO.setEmail(usuario.getEmail());
        usuarioDTO.setTelefone(usuario.getTelefone());
        usuarioDTO.setDataCadastro(usuario.getDataCadastro());
        return usuarioDTO;
    }
}