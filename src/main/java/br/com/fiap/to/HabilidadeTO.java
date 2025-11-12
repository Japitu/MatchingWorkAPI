package br.com.fiap.to;

import br.com.fiap.enums.TipoHabilidade;

public class HabilidadeTO {
    private long id;
    private String nome;
    private String descricao;
    private TipoHabilidade tipoHabilidade;

    public HabilidadeTO() {}

    public HabilidadeTO(long id, String nome, String descricao, TipoHabilidade tipoHabilidade) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.tipoHabilidade = tipoHabilidade;
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

    public TipoHabilidade getTipoHabilidade() {
        return tipoHabilidade;
    }

    public void setTipoHabilidade(TipoHabilidade tipoHabilidade) {
        this.tipoHabilidade = tipoHabilidade;
    }
}
