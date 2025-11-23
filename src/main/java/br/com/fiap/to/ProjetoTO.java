package br.com.fiap.to;

import br.com.fiap.enums.TipoStatusProjeto;

import java.util.ArrayList;

public class ProjetoTO { // t_mw_projeto
    private long id; // id_projeto
    private String nome; // nm_projeto
    private String descricao; // dc_projeto
    private TipoStatusProjeto status; // st_projeto

    public ProjetoTO() {}

    public ProjetoTO(long id, String nome, String descricao, TipoStatusProjeto status) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.status = status;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoStatusProjeto getStatus() {
        return status;
    }

    public void setStatus(TipoStatusProjeto status) {
        this.status = status;
    }
}
