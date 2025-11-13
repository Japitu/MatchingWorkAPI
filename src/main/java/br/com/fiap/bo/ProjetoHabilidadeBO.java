package br.com.fiap.bo;

import br.com.fiap.dao.ProjetoHabilidadeDAO;
import br.com.fiap.to.ProjetoHabilidadeTO;

import java.util.ArrayList;

public class ProjetoHabilidadeBO {
    private ProjetoHabilidadeDAO projetoHabilidadeDAO;

    public ArrayList<ProjetoHabilidadeTO> findAll() {
        projetoHabilidadeDAO = new ProjetoHabilidadeDAO();

        return projetoHabilidadeDAO.findAll();
    }

    public ProjetoHabilidadeTO findById(Long id) {
        projetoHabilidadeDAO = new ProjetoHabilidadeDAO();

        return projetoHabilidadeDAO.findById(id);
    }

    public ProjetoHabilidadeTO save(ProjetoHabilidadeTO projetoHabilidade) {
        projetoHabilidadeDAO = new ProjetoHabilidadeDAO();

        return projetoHabilidadeDAO.save(projetoHabilidade);
    }

    public boolean delete(Long id) {
        projetoHabilidadeDAO = new ProjetoHabilidadeDAO();

        return projetoHabilidadeDAO.delete(id);
    }

    public ProjetoHabilidadeTO update (ProjetoHabilidadeTO projetoHabilidade) {
        projetoHabilidadeDAO = new ProjetoHabilidadeDAO();

        return projetoHabilidadeDAO.update(projetoHabilidade);
    }
}
