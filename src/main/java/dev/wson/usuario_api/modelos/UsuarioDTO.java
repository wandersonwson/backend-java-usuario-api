package dev.wson.usuario_api.modelos;

import lombok.Data;
import org.springframework.stereotype.Component;
import java.time.LocalDate;

@Component
@Data
public class UsuarioDTO {
    private String nome;
    private String cpf;
    private String endereco;
    private String email;
    private String telefone;
    private LocalDate dataCadastro;
}