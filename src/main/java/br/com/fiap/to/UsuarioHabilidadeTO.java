package br.com.fiap.to;

import br.com.fiap.enums.TipoHabilidade;

public class UsuarioHabilidadeTO {
    private long id;
    private long usuarioId;
    private String nomeUsuario;
    private long habilidadeId;
    private String nomeHabilidade;
    private TipoHabilidade tipoHabilidade;
    private int nivelExperiencia;

    public UsuarioHabilidadeTO() {}

    public UsuarioHabilidadeTO(long id, long usuarioId, String nomeUsuario, long habilidadeId, String nomeHabilidade, TipoHabilidade tipoHabilidade, int nivelExperiencia) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.nomeUsuario = nomeUsuario;
        this.habilidadeId = habilidadeId;
        this.nomeHabilidade = nomeHabilidade;
        this.tipoHabilidade = tipoHabilidade;
        this.nivelExperiencia = nivelExperiencia;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
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

    public TipoHabilidade getTipoHabilidade() {
        return tipoHabilidade;
    }

    public void setTipoHabilidade(TipoHabilidade tipoHabilidade) {
        this.tipoHabilidade = tipoHabilidade;
    }

    public int getNivelExperiencia() {
        return nivelExperiencia;
    }

    public void setNivelExperiencia(int nivelExperiencia) {
        this.nivelExperiencia = nivelExperiencia;
    }
}
