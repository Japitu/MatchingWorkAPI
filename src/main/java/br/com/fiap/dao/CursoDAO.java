package br.com.fiap.dao;

import br.com.fiap.to.CursoTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CursoDAO {

    public ArrayList<CursoTO> findAll() {
        ArrayList<CursoTO> cursos = new ArrayList<CursoTO>();
        String sql = "select * from t_mw_curso order by id_curso";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    CursoTO curso = new CursoTO();
                    curso.setId(rs.getLong("id_curso"));
                    curso.setNome(rs.getString("nm_curso"));
                    curso.setDescricao(rs.getString("dc_curso"));
                    curso.setHabilidadeId(rs.getLong("id_habilidade"));
                    cursos.add(curso);
                }
            } else {
                return null;
            }
        } catch(
        SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return cursos;
    }

    public CursoTO findById(Long id) {
        CursoTO curso = new CursoTO();
        String sql = "select * from t_mw_curso where id_curso = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                curso.setId(rs.getLong("id_curso"));
                curso.setNome(rs.getString("nm_curso"));
                curso.setDescricao(rs.getString("dc_curso"));
                curso.setHabilidadeId(rs.getLong("id_habilidade"));
            } else {
                return null;
            }
        } catch (SQLException e){
            System.out.println("Erro ao buscar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return curso;
    }

    public CursoTO save(CursoTO curso) {
        String sql = "insert into t_mw_curso (nm_curso, dc_curso, id_habilidade) values (?, ?, ?)";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setString(1, curso.getNome());
            ps.setString(2, curso.getDescricao());
            ps.setLong(3, curso.getHabilidadeId());
            if(ps.executeUpdate() > 0) {
                return curso;
            } else {
                return null;
            }
        }catch (SQLException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }

    public boolean delete (Long id) {
        String sql = "delete from t_mw_curso where id_curso = ?";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return false;
    }

    public CursoTO update(CursoTO curso) {
        String sql = "update t_mw_curso set nm_curso = ?, dc_curso = ?, id_habilidade = ? where id_curso = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setString(1, curso.getNome());
            ps.setString(2, curso.getDescricao());
            ps.setLong(3, curso.getHabilidadeId());
            ps.setLong(4, curso.getId());
            if (ps.executeUpdate() > 0) {
                return curso;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }
}
