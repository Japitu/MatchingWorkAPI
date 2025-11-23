package br.com.fiap.bo;

import br.com.fiap.dao.CursoDAO;
import br.com.fiap.to.CursoTO;

import java.util.ArrayList;

public class CursoBO {
    private CursoDAO cursoDAO;

    public ArrayList<CursoTO> findAll() {
        cursoDAO = new CursoDAO();

        return cursoDAO.findAll();
    }

    public CursoTO findById(Long id) {
        cursoDAO = new CursoDAO();

        return cursoDAO.findById(id);
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
