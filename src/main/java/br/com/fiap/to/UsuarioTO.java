package br.com.fiap.to;

import br.com.fiap.enums.TipoContaUsuario;

public class UsuarioTO {
    private long id;
    private String nome;
    private String email;
    private int RM;
    private TipoContaUsuario tipoConta;

    public UsuarioTO() {}

    public UsuarioTO(long id, String nome, String email, int RM, TipoContaUsuario tipoConta) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.RM = RM;
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

    public int getRM() {
        return RM;
    }

    public void setRM(int RM) {
        this.RM = RM;
    }

    public TipoContaUsuario getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoContaUsuario tipoConta) {
        this.tipoConta = tipoConta;
    }
}
