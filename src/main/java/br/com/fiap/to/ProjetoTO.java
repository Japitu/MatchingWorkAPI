package br.com.fiap.to;

import br.com.fiap.enums.TipoStatusProjeto;

public class ProjetoTO {
    private long id; // id_projeto
    private String nome; // nm_projeto
    private String descricao; // dc_projeto
    private TipoStatusProjeto status; // st_projeto
    private long criadorProjetoId; // id_criador
    private String nomeCriador;

    public ProjetoTO() {}

    public ProjetoTO(long id, String nome, String descricao, TipoStatusProjeto status, long criadorProjetoId) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.status = status;
        this.criadorProjetoId = criadorProjetoId;
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

    public long getCriadorProjetoId() {
        return criadorProjetoId;
    }

    public void setCriadorProjetoId(long criadorProjetoId) {
        this.criadorProjetoId = criadorProjetoId;
    }
}
