package br.com.fiap.bo;

import br.com.fiap.dao.HabilidadeDAO;
import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.dao.UsuarioHabilidadeDAO;
import br.com.fiap.to.HabilidadeTO;
import br.com.fiap.to.UsuarioHabilidadeTO;
import br.com.fiap.to.UsuarioTO;

import java.util.ArrayList;

public class UsuarioHabilidadeBO {
    private UsuarioHabilidadeDAO usuarioHabilidadeDAO;
    private UsuarioDAO usuarioDAO;
    private HabilidadeDAO habilidadeDAO;

    public ArrayList<UsuarioHabilidadeTO> findAll() {
        usuarioHabilidadeDAO = new UsuarioHabilidadeDAO();
        usuarioDAO = new UsuarioDAO();
        habilidadeDAO = new HabilidadeDAO();

        ArrayList<UsuarioHabilidadeTO> Resultado = new ArrayList<UsuarioHabilidadeTO>();
        ArrayList<UsuarioHabilidadeTO> Lista = new ArrayList<UsuarioHabilidadeTO>();
        Lista = usuarioHabilidadeDAO.findAll();

        for(UsuarioHabilidadeTO usuarioHabilidade : Lista) {

            UsuarioTO usuario = usuarioDAO.findById(usuarioHabilidade.getUsuarioId());
            usuarioHabilidade.setNomeUsuario(usuario.getNome());

            HabilidadeTO habilidade = habilidadeDAO.findById(usuarioHabilidade.getHabilidadeId());
            usuarioHabilidade.setNomeHabilidade(habilidade.getNome());
            usuarioHabilidade.setTipoHabilidade(habilidade.getTipoHabilidade());

            Resultado.add(usuarioHabilidade);
        }

        return Resultado;
    }

    public UsuarioHabilidadeTO findById(Long id) {
        usuarioHabilidadeDAO = new UsuarioHabilidadeDAO();
        usuarioDAO = new UsuarioDAO();
        habilidadeDAO = new HabilidadeDAO();

        UsuarioHabilidadeTO usuarioHabilidade = usuarioHabilidadeDAO.findById(id);

        UsuarioTO usuario = usuarioDAO.findById(usuarioHabilidade.getUsuarioId());
        usuarioHabilidade.setNomeUsuario(usuario.getNome());

        HabilidadeTO habilidade = habilidadeDAO.findById(usuarioHabilidade.getHabilidadeId());

        usuarioHabilidade.setNomeHabilidade(habilidade.getNome());
        usuarioHabilidade.setTipoHabilidade(habilidade.getTipoHabilidade());

        return usuarioHabilidade;
    }

    public ArrayList<UsuarioHabilidadeTO> findByHabilidade(Long id) {
        usuarioHabilidadeDAO = new UsuarioHabilidadeDAO();
        usuarioDAO = new UsuarioDAO();
        habilidadeDAO = new HabilidadeDAO();

        ArrayList<UsuarioHabilidadeTO> Resultado = new ArrayList<UsuarioHabilidadeTO>();
        ArrayList<UsuarioHabilidadeTO> Lista = new ArrayList<UsuarioHabilidadeTO>();
        Lista = usuarioHabilidadeDAO.findByHabilidade(id);

        for(UsuarioHabilidadeTO usuarioHabilidade : Lista) {

            UsuarioTO usuario = usuarioDAO.findById(usuarioHabilidade.getUsuarioId());
            usuarioHabilidade.setNomeUsuario(usuario.getNome());

            HabilidadeTO habilidade = habilidadeDAO.findById(usuarioHabilidade.getHabilidadeId());
            usuarioHabilidade.setNomeHabilidade(habilidade.getNome());
            usuarioHabilidade.setTipoHabilidade(habilidade.getTipoHabilidade());

            Resultado.add(usuarioHabilidade);
        }

        return Resultado;
    }

    public UsuarioHabilidadeTO save(UsuarioHabilidadeTO usuarioHabilidade) throws Exception {
        usuarioHabilidadeDAO = new UsuarioHabilidadeDAO();
        usuarioDAO = new UsuarioDAO();
        habilidadeDAO = new HabilidadeDAO();

        UsuarioTO usuario = usuarioDAO.findById(usuarioHabilidade.getUsuarioId());

        if (usuario == null) {
            throw new Exception("Usuario informado inexistente");
        }

        HabilidadeTO habilidade = habilidadeDAO.findById(usuarioHabilidade.getHabilidadeId());

        if (habilidade == null) {
            throw new Exception("Habilidade informada inexistente");
        }

        return usuarioHabilidadeDAO.save(usuarioHabilidade);
    }

    public boolean delete(Long id) {
        usuarioHabilidadeDAO = new UsuarioHabilidadeDAO();

        return usuarioHabilidadeDAO.delete(id);
    }

    public UsuarioHabilidadeTO update(UsuarioHabilidadeTO usuarioHabilidade) throws Exception {

        usuarioHabilidadeDAO = new UsuarioHabilidadeDAO();
        usuarioDAO = new UsuarioDAO();
        habilidadeDAO = new HabilidadeDAO();

        UsuarioTO usuario = usuarioDAO.findById(usuarioHabilidade.getUsuarioId());

        if (usuario == null) {
            throw new Exception("Usuario informado inexistente");
        }

        HabilidadeTO habilidade = habilidadeDAO.findById(usuarioHabilidade.getHabilidadeId());

        if (habilidade == null) {
            throw new Exception("Habilidade informada inexistente");
        }

        return usuarioHabilidadeDAO.update(usuarioHabilidade);
    }
}
