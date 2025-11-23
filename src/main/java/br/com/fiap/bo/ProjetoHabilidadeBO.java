package br.com.fiap.bo;

import br.com.fiap.dao.HabilidadeDAO;
import br.com.fiap.dao.ProjetoDAO;
import br.com.fiap.dao.ProjetoHabilidadeDAO;
import br.com.fiap.to.HabilidadeTO;
import br.com.fiap.to.ProjetoHabilidadeTO;
import br.com.fiap.to.ProjetoTO;

import java.util.ArrayList;

public class ProjetoHabilidadeBO {
    private ProjetoHabilidadeDAO projetoHabilidadeDAO;
    private ProjetoDAO projetoDAO;
    private HabilidadeDAO habilidadeDAO;

    public ArrayList<ProjetoHabilidadeTO> findAll() {
        projetoHabilidadeDAO = new ProjetoHabilidadeDAO();
        projetoDAO = new ProjetoDAO();
        habilidadeDAO = new HabilidadeDAO();

        ArrayList<ProjetoHabilidadeTO> Resultado = new ArrayList<ProjetoHabilidadeTO>();
        ArrayList<ProjetoHabilidadeTO> Lista = new ArrayList<ProjetoHabilidadeTO>();
        Lista = projetoHabilidadeDAO.findAll();

        for (ProjetoHabilidadeTO projetoHabilidade : Lista) {

            ProjetoTO projeto = projetoDAO.findById(projetoHabilidade.getProjetoId());
            projetoHabilidade.setNomeProjeto(projeto.getNome());

            HabilidadeTO habilidade = habilidadeDAO.findById(projetoHabilidade.getHabilidadeId());
            projetoHabilidade.setNomeHabilidade(habilidade.getNome());

            Resultado.add(projetoHabilidade);
        }
        return Resultado;
    }

    public ProjetoHabilidadeTO findById(Long id) {
        projetoHabilidadeDAO = new ProjetoHabilidadeDAO();
        projetoDAO = new ProjetoDAO();
        habilidadeDAO = new HabilidadeDAO();

        ProjetoHabilidadeTO projetoHabilidade = projetoHabilidadeDAO.findById(id);

        ProjetoTO projeto = projetoDAO.findById(projetoHabilidade.getProjetoId());
        projetoHabilidade.setNomeProjeto(projeto.getNome());

        HabilidadeTO habilidade = habilidadeDAO.findById(projetoHabilidade.getHabilidadeId());
        projetoHabilidade.setNomeHabilidade(habilidade.getNome());


        return projetoHabilidade;
    }

    public ArrayList<ProjetoHabilidadeTO> findByHabilidade(Long id) {
        projetoHabilidadeDAO = new ProjetoHabilidadeDAO();
        projetoDAO = new ProjetoDAO();
        habilidadeDAO = new HabilidadeDAO();

        ArrayList<ProjetoHabilidadeTO> Resultado = new ArrayList<ProjetoHabilidadeTO>();
        ArrayList<ProjetoHabilidadeTO> Lista = new ArrayList<ProjetoHabilidadeTO>();
        Lista = projetoHabilidadeDAO.findByHabilidade(id);

        for (ProjetoHabilidadeTO projetoHabilidade : Lista) {

            ProjetoTO projeto = projetoDAO.findById(projetoHabilidade.getProjetoId());
            projetoHabilidade.setNomeProjeto(projeto.getNome());

            HabilidadeTO habilidade = habilidadeDAO.findById(projetoHabilidade.getProjetoId());
            projetoHabilidade.setNomeHabilidade(habilidade.getNome());

            Resultado.add(projetoHabilidade);
        }
        return Resultado;
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
