package br.com.fiap.bo;

import br.com.fiap.dao.CursoDAO;
import br.com.fiap.dao.HabilidadeDAO;
import br.com.fiap.to.CursoTO;
import br.com.fiap.to.HabilidadeTO;

import java.util.ArrayList;

public class CursoBO {
    private CursoDAO cursoDAO;
    private HabilidadeDAO habilidadeDAO;

    public ArrayList<CursoTO> findAll() {
        cursoDAO = new CursoDAO();
        habilidadeDAO = new HabilidadeDAO();

        ArrayList<CursoTO> Resultado = new ArrayList<CursoTO>();
        ArrayList<CursoTO> Lista = new ArrayList<CursoTO>();

        for (CursoTO curso : Lista) {
            HabilidadeTO habilidade = habilidadeDAO.findById(curso.getHabilidadeId());
            curso.setNomeHabilidade(habilidade.getNome());

            Resultado.add(curso);
        }

        return Resultado;
    }

    public CursoTO findById(Long id) {
        cursoDAO = new CursoDAO();
        habilidadeDAO = new HabilidadeDAO();

        CursoTO curso = cursoDAO.findById(id);

        HabilidadeTO habilidade = habilidadeDAO.findById(curso.getHabilidadeId());
        curso.setNomeHabilidade(habilidade.getNome());

        return curso;
    }

    public CursoTO save(CursoTO curso) {
        cursoDAO = new CursoDAO();

        return cursoDAO.save(curso);
    }

    public boolean delete(Long id) {
        cursoDAO = new CursoDAO();

        return cursoDAO.delete(id);
    }

    public CursoTO update(CursoTO curso) {
        cursoDAO = new CursoDAO();

        return cursoDAO.update(curso);
    }
}
