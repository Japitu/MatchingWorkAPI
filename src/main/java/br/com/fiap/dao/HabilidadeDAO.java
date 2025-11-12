package br.com.fiap.dao;

import br.com.fiap.enums.TipoHabilidade;
import br.com.fiap.to.HabilidadeTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HabilidadeDAO {

    public ArrayList<HabilidadeTO> findAll() {
        ArrayList<HabilidadeTO> habilidades = new ArrayList<HabilidadeTO>();
        String sql = "select * from t_mw_habilidade order by id_habilidade";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs!=null) {
                while (rs.next()) {
                    HabilidadeTO habilidade = new HabilidadeTO();
                    habilidade.setId(rs.getLong("id_habilidade"));
                    habilidade.setNome(rs.getString("nm_habilidade"));
                    habilidade.setDescricao(rs.getString("dc_habilidade"));
                    habilidade.setTipoHabilidade(TipoHabilidade.valueOf(rs.getString("tp_habilidade")));
                    habilidades.add(habilidade);
                }
            } else {
                return null;
            }
        }catch(SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return habilidades;
    }

    public HabilidadeTO findById(Long id) {
        HabilidadeTO habilidade = new HabilidadeTO();
        String sql = "select * from t_mw_habilidade where id_habilidade = ?";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)){
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                habilidade.setId(rs.getLong("id_habilidade"));
                habilidade.setNome(rs.getString("nm_habilidade"));
                habilidade.setDescricao(rs.getString("dc_habilidade"));
                habilidade.setTipoHabilidade(TipoHabilidade.valueOf(rs.getString("tp_habilidade")));
            } else {
                return null;
            }
        }catch (SQLException e){
            System.out.println("Erro ao buscar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return habilidade;
    }

    public HabilidadeTO save(HabilidadeTO habilidade) {
        String sql = "insert int t_mw_habilidade (nm_habilidade, dc_habilidade, tp_habilidade) values (?, ?, ?)";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setString(1, habilidade.getNome());
            ps.setString(2, habilidade.getDescricao());
            ps.setString(3, habilidade.getTipoHabilidade().name());
            if (ps.executeUpdate() > 0) {
                return habilidade;
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

    public boolean delete(Long id) {
        String sql = "delete from t_mw_usuario where id_habilidade = ?";
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

    public HabilidadeTO update(HabilidadeTO habilidade) {
        String sql = "update t_mw_habilidade set nm_habilidade = ?, dc_habilidade = ?, tp_habilidade = ? where id_habilidade = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setString(1, habilidade.getNome());
            ps.setString(2, habilidade.getDescricao());
            ps.setString(3, habilidade.getTipoHabilidade().name());
            ps.setLong(4, habilidade.getId());
            if (ps.executeUpdate() > 0) {
                return habilidade;
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
