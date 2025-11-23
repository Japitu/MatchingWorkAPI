package br.com.fiap.to;

public class CursoTO {
    private long id; // id_curso
    private String nome; // nm_curso
    private String descricao;
    private long habilidadeId; // id_habilidade

    public CursoTO() {}

    public CursoTO(long id, String nome, String descricao, long habilidadeId) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.habilidadeId = habilidadeId;
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

    public long getHabilidadeId() {
        return habilidadeId;
    }

    public void setHabilidadeId(long habilidadeId) {
        this.habilidadeId = habilidadeId;
    }
}
