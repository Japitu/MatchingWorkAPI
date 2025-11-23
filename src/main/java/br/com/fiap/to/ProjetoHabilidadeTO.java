package br.com.fiap.to;

import br.com.fiap.enums.TipoNivelHabilidade;

public class ProjetoHabilidadeTO { // t_mw_projeto_habilidade
    private long id; // id_projeto_habilidade
    private long projetoId; // id_projeto
    private String nomeProjeto;
    private long habilidadeId; //id_habilidade
    private String nomeHabilidade;
    private TipoNivelHabilidade nivelRequerido; //tp_nivel_requerido

    public ProjetoHabilidadeTO() {}

    public ProjetoHabilidadeTO(long id, long projetoId, long habilidadeId, TipoNivelHabilidade nivelRequerido) {
        this.id = id;
        this.projetoId = projetoId;
        this.habilidadeId = habilidadeId;
        this.nivelRequerido = nivelRequerido;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getProjetoId() {
        return projetoId;
    }

    public void setProjetoId(long projetoId) {
        this.projetoId = projetoId;
    }

    public String getNomeProjeto() {
        return nomeProjeto;
    }

    public void setNomeProjeto(String nomeProjeto) {
        this.nomeProjeto = nomeProjeto;
    }

    public long getHabilidadeId() {
        return habilidadeId;
    }

    public void setHabilidadeId(long habilidadeId) {
        this.habilidadeId = habilidadeId;
    }

    public String getNomeHabilidade() {
        return nomeHabilidade;
    }

    public void setNomeHabilidade(String nomeHabilidade) {
        this.nomeHabilidade = nomeHabilidade;
    }

    public TipoNivelHabilidade getNivelRequerido() {
        return nivelRequerido;
    }

    public void setNivelRequerido(TipoNivelHabilidade nivelRequerido) {
        this.nivelRequerido = nivelRequerido;
    }
}
