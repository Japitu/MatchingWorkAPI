package br.com.fiap.to;

import br.com.fiap.enums.TipoNivelHabilidade;

public class CombinacaoTO {
    private long id;
    private long habilidadeId;
    private long usuarioHabilidadeId;
    private TipoNivelHabilidade experienciaUsuario;
    private long projetoHabilidadeId;
    private TipoNivelHabilidade requisitoProjeto;

    public CombinacaoTO() {}

    public CombinacaoTO(long id, long habilidadeId, long usuarioHabilidadeId, TipoNivelHabilidade experienciaUsuario, long projetoHabilidadeId, TipoNivelHabilidade requisitoProjeto) {
        this.id = id;
        this.habilidadeId = habilidadeId;
        this.usuarioHabilidadeId = usuarioHabilidadeId;
        this.experienciaUsuario = experienciaUsuario;
        this.projetoHabilidadeId = projetoHabilidadeId;
        this.requisitoProjeto = requisitoProjeto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getHabilidadeId() {
        return habilidadeId;
    }

    public void setHabilidadeId(long habilidadeId) {
        this.habilidadeId = habilidadeId;
    }

    public long getUsuarioHabilidadeId() {
        return usuarioHabilidadeId;
    }

    public void setUsuarioHabilidadeId(long usuarioHabilidadeId) {
        this.usuarioHabilidadeId = usuarioHabilidadeId;
    }

    public TipoNivelHabilidade getExperienciaUsuario() {
        return experienciaUsuario;
    }

    public void setExperienciaUsuario(TipoNivelHabilidade experienciaUsuario) {
        this.experienciaUsuario = experienciaUsuario;
    }

    public long getProjetoHabilidadeId() {
        return projetoHabilidadeId;
    }

    public void setProjetoHabilidadeId(long projetoHabilidadeId) {
        this.projetoHabilidadeId = projetoHabilidadeId;
    }

    public TipoNivelHabilidade getRequisitoProjeto() {
        return requisitoProjeto;
    }

    public void setRequisitoProjeto(TipoNivelHabilidade requisitoProjeto) {
        this.requisitoProjeto = requisitoProjeto;
    }
}
