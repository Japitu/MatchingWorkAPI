package br.com.fiap.dao;

import br.com.fiap.to.UsuarioHabilidadeTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioHabilidadeDAO {

    public ArrayList<UsuarioHabilidadeTO> findAll() {
        ArrayList<UsuarioHabilidadeTO> usuarioHabilidades = new ArrayList<UsuarioHabilidadeTO>();
        String sql = "select * from t_mw_usuario_habilidade order by id_usuario_habilidade";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    UsuarioHabilidadeTO usuarioHabilidade = new UsuarioHabilidadeTO();

                    usuarioHabilidade.setId(rs.getLong("id_usuario_habilidade"));
                    usuarioHabilidade.setUsuarioId(rs.getLong("id_usuario"));
                    usuarioHabilidade.setHabilidadeId(rs.getLong("id_habilidade"));
                    usuarioHabilidade.setNivelExperiencia(rs.getInt("nr_nivel_experiencia"));
                    usuarioHabilidades.add(usuarioHabilidade);
                }
            } else {
                return null;
            }

        }catch(SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return usuarioHabilidades;
    }

    public UsuarioHabilidadeTO findById(Long id) {
        UsuarioHabilidadeTO usuarioHabilidade = new UsuarioHabilidadeTO();
        String sql = "select * from t_mw_usuario_habilidade where id_usuario_habilidade = ?";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)){
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                usuarioHabilidade.setId(rs.getLong("id_usuario_habilidade"));
                usuarioHabilidade.setUsuarioId(rs.getLong("id_usuario"));
                usuarioHabilidade.setHabilidadeId(rs.getLong("id_habilidade"));
                usuarioHabilidade.setNivelExperiencia(rs.getInt("nr_nivel_experiencia"));
            } else {
                return null;
            }
        }catch (SQLException e){
            System.out.println("Erro ao buscar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return usuarioHabilidade;
    }

    public UsuarioHabilidadeTO save(UsuarioHabilidadeTO usuarioHabilidade) {
        String sql = "insert into t_mw_usuario_habilidade (id_usuario, id_habilidade, nr_nivel_experiencia) values (?, ?, ?)";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, usuarioHabilidade.getUsuarioId());
            ps.setLong(2, usuarioHabilidade.getHabilidadeId());
            ps.setInt(3, usuarioHabilidade.getNivelExperiencia());
            if (ps.executeUpdate() > 0) {
                return usuarioHabilidade;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }

    public boolean delete(Long id) {
        String sql = "delete from t_mw_usuario_habilidade where id_usuario_habilidade = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return false;
    }

    public UsuarioHabilidadeTO update(UsuarioHabilidadeTO usuarioHabilidade) {
        String sql = "update t_mw_usuario_habilidade set id_usuario = ?, id_habilidade = ?, nr_nivel_experiencia = ? where id_usuario_habilidade = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, usuarioHabilidade.getUsuarioId());
            ps.setLong(2, usuarioHabilidade.getHabilidadeId());
            ps.setInt(3, usuarioHabilidade.getNivelExperiencia());
            ps.setLong(4, usuarioHabilidade.getId());
            if (ps.executeUpdate() > 0) {
                return usuarioHabilidade;
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
