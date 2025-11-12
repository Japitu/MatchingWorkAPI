package br.com.fiap.bo;

import br.com.fiap.dao.UsuarioHabilidadeDAO;
import br.com.fiap.to.UsuarioHabilidadeTO;

import java.util.ArrayList;

public class UsuarioHabilidadeBO {
    private UsuarioHabilidadeDAO usuarioHabilidadeDAO;

    public ArrayList<UsuarioHabilidadeTO> findAll() {
        usuarioHabilidadeDAO = new UsuarioHabilidadeDAO();

        return usuarioHabilidadeDAO.findAll();
    }

    public UsuarioHabilidadeTO findById(Long id) {
        usuarioHabilidadeDAO = new UsuarioHabilidadeDAO();

        return usuarioHabilidadeDAO.findById(id);
    }

    public UsuarioHabilidadeTO save(UsuarioHabilidadeTO usuarioHabilidade) {
        usuarioHabilidadeDAO = new UsuarioHabilidadeDAO();

        return usuarioHabilidadeDAO.save(usuarioHabilidade);
    }

    public boolean delete(Long id) {
        usuarioHabilidadeDAO = new UsuarioHabilidadeDAO();

        return usuarioHabilidadeDAO.delete(id);
    }

    public UsuarioHabilidadeTO update(UsuarioHabilidadeTO usuarioHabilidade) {
        usuarioHabilidadeDAO = new UsuarioHabilidadeDAO();

        return usuarioHabilidadeDAO.update(usuarioHabilidade);
    }
}
