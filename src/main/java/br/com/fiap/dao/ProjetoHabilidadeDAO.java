package br.com.fiap.dao;

import br.com.fiap.enums.TipoHabilidade;
import br.com.fiap.enums.TipoNivelHabilidade;
import br.com.fiap.to.ProjetoHabilidadeTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProjetoHabilidadeDAO {

    public ArrayList<ProjetoHabilidadeTO> findAll() {
        ArrayList<ProjetoHabilidadeTO> projetoHabilidades = new ArrayList<ProjetoHabilidadeTO>();
        String sql = "select * from t_mw_projeto_habilidade order by id_projeto_habilidade";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if(rs != null) {
                while (rs.next()) {
                    ProjetoHabilidadeTO projetoHabilidade = new ProjetoHabilidadeTO();
                    projetoHabilidade.setId(rs.getLong("id_projeto_habilidade"));
                    projetoHabilidade.setProjetoId(rs.getLong("id_projeto"));
                    projetoHabilidade.setHabilidadeId(rs.getLong("id_habilidade"));
                    projetoHabilidade.setNivelRequerido(TipoNivelHabilidade.valueOf(rs.getString("tp_nivel_requerido")));

                    projetoHabilidades.add(projetoHabilidade);
                }
            } else {
                return null;
            }
        } catch(SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return projetoHabilidades;
    }

    public ProjetoHabilidadeTO findById(Long id) {
        ProjetoHabilidadeTO projetoHabilidade = new ProjetoHabilidadeTO();
        String sql = "select * from t_mw_projeto_habilidade where id_projeto_habilidade = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)){
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                projetoHabilidade.setId(rs.getLong("id_projeto_habilidade"));
                projetoHabilidade.setProjetoId(rs.getLong("id_projeto"));
                projetoHabilidade.setHabilidadeId(rs.getLong("id_habilidade"));
                projetoHabilidade.setNivelRequerido(TipoNivelHabilidade.valueOf(rs.getString("tp_nivel_requerido")));
            } else {
                return null;
            }
        } catch (SQLException e){
            System.out.println("Erro ao buscar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return projetoHabilidade;
    }

    public ArrayList<ProjetoHabilidadeTO> findByHabilidade(Long id) {
        ArrayList<ProjetoHabilidadeTO> projetoHabilidades = new ArrayList<ProjetoHabilidadeTO>();
        String sql = "select * from t_mw_projeto_habilidade where id_habilidade = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)){
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs != null) {
                while (rs.next()) {
                    ProjetoHabilidadeTO projetoHabilidade = new ProjetoHabilidadeTO();
                    projetoHabilidade.setId(rs.getLong("id_projeto_habilidade"));
                    projetoHabilidade.setProjetoId(rs.getLong("id_projeto"));
                    projetoHabilidade.setHabilidadeId(rs.getLong("id_habilidade"));
                    projetoHabilidade.setNivelRequerido(TipoNivelHabilidade.valueOf(rs.getString("tp_nivel_requerido")));

                    projetoHabilidades.add(projetoHabilidade);
                }
            } else {
                return null;
            }
        } catch (SQLException e){
            System.out.println("Erro ao buscar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return projetoHabilidades;
    }

    public ProjetoHabilidadeTO save(ProjetoHabilidadeTO projetoHabilidade) {
        String sql = "insert into t_mw_projeto_habilidade (id_projeto, id_habilidade, tp_nivel_requerido) values (?, ?, ?)";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, projetoHabilidade.getProjetoId());
            ps.setLong(2, projetoHabilidade.getHabilidadeId());
            ps.setString(3, projetoHabilidade.getNivelRequerido().name());
            if (ps.executeUpdate() > 0) {
                return projetoHabilidade;
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
        String sql = "delete from t_mw_projeto_habilidade where id_projeto_habilidade = ?";
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

    public ProjetoHabilidadeTO update(ProjetoHabilidadeTO projetoHabilidade) {
        String sql = "update t_mw_projeto_habilidade set id_projeto = ?, id_habilidade = ?, tp_nivel_requerido = ? where id_projeto_habilidade = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, projetoHabilidade.getProjetoId());
            ps.setLong(2, projetoHabilidade.getHabilidadeId());
            ps.setString(3, projetoHabilidade.getNivelRequerido().name());
            ps.setLong(4, projetoHabilidade.getId());
            if (ps.executeUpdate() > 0) {
                return projetoHabilidade;
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
