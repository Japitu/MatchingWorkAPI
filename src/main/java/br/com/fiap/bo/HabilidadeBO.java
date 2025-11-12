package br.com.fiap.bo;

import br.com.fiap.dao.HabilidadeDAO;
import br.com.fiap.to.HabilidadeTO;

import java.util.ArrayList;

public class HabilidadeBO {
    private HabilidadeDAO habilidadeDAO;

    public ArrayList<HabilidadeTO> findAll() {
        habilidadeDAO = new HabilidadeDAO();

        return habilidadeDAO.findAll();
    }

    public HabilidadeTO findById(Long id) {
        habilidadeDAO = new HabilidadeDAO();

        return habilidadeDAO.findById(id);
    }

    public HabilidadeTO save(HabilidadeTO habilidade) {
        habilidadeDAO = new HabilidadeDAO();

        return habilidadeDAO.save(habilidade);
    }

    public boolean delete(Long id) {
        habilidadeDAO = new HabilidadeDAO();

        return habilidadeDAO.delete(id);
    }

    public HabilidadeTO update(HabilidadeTO habilidade) {
        habilidadeDAO = new HabilidadeDAO();

        return habilidadeDAO.update(habilidade);
    }
}
