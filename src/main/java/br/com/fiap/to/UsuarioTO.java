package br.com.fiap.to;

import br.com.fiap.enums.TipoContaUsuario;
import jakarta.validation.constraints.NotBlank;

public class UsuarioTO { // t_mw_usuario
    private long id; // id_usuario
    @NotBlank
    private String nome; // nm_usuario
    @NotBlank
    private String email; // dc_email
    private TipoContaUsuario tipoConta; // tp_conta

    public UsuarioTO() {}

    public UsuarioTO(long id, String nome, String email, TipoContaUsuario tipoConta) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.tipoConta = tipoConta;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TipoContaUsuario getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoContaUsuario tipoConta) {
        this.tipoConta = tipoConta;
    }
}
