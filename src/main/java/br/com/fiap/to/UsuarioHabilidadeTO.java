package br.com.fiap.to;

import br.com.fiap.enums.TipoHabilidade;
import br.com.fiap.enums.TipoNivelHabilidade;

public class UsuarioHabilidadeTO {
    private long id; // id_usuario_habilidade
    private long usuarioId; // id_usuario
    private String nomeUsuario;
    private long habilidadeId; // id_habilidade
    private String nomeHabilidade;
    private TipoHabilidade tipoHabilidade;
    private TipoNivelHabilidade nivelExperiencia; // tp_nivel_experiencia

    public UsuarioHabilidadeTO() {}

    public UsuarioHabilidadeTO(long id, long usuarioId, String nomeUsuario, long habilidadeId, String nomeHabilidade, TipoHabilidade tipoHabilidade, TipoNivelHabilidade nivelExperiencia) {
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

    public TipoNivelHabilidade getNivelExperiencia() {
        return nivelExperiencia;
    }

    public void setNivelExperiencia(TipoNivelHabilidade nivelExperiencia) {
        this.nivelExperiencia = nivelExperiencia;
    }
}
