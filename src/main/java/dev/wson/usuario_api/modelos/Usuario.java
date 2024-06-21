package dev.wson.usuario_api.modelos;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String cpf;
    private String endereco;
    private String email;
    private String telefone;
    @Column(name = "data_cadastro")
    private LocalDate dataCadastro;

    public static Usuario converterParaUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setNome(usuarioDTO.getNome());
        usuario.setCpf(usuarioDTO.getCpf());
        usuario.setEndereco(usuarioDTO.getEndereco());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setTelefone(usuarioDTO.getTelefone());
        usuario.setDataCadastro(usuarioDTO.getDataCadastro());
        return usuario;
    }
}