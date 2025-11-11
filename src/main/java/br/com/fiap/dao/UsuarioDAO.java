package br.com.fiap.dao;

import br.com.fiap.to.UsuarioTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDAO {

    public ArrayList<UsuarioTO> findAll() {
        ArrayList<UsuarioTO> usuarios = new ArrayList<UsuarioTO>();
        String sql = "select * from t_mw_usuario order by id_usuario";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if ( rs != null) {
                while (rs.next()) {
                    UsuarioTO usuario = new UsuarioTO();
                    usuario.setId(rs.getLong("id_usuario"));
                    usuario.setNome(rs.getString("nm_usuario"));
                    usuario.setEmail(rs.getString("dc_email")); //Ver dps o nome da coluna no banco com a vih
                    usuario.setRM(rs.getInt("nr_rm")); //Ver dps o nome da coluna no banco com a vih
                    usuarios.add(usuario);
                }
            } else {
                return null;
            }
        } catch(SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return usuarios;
    }

    public UsuarioTO findById(Long id) {
        UsuarioTO usuario = new UsuarioTO();
        String sql = "select * from t_mw_usuario where id_usuario = ?";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)){
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                usuario.setId(rs.getLong("id_usuario"));
                usuario.setNome(rs.getString("nm_usuario"));
                usuario.setEmail(rs.getString("dc_email"));
                usuario.setRM(rs.getInt("nr_rm"));
            } else {
                return null;
            }
        }catch (SQLException e){
            System.out.println("Erro ao buscar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return usuario;
    }

    public UsuarioTO save (UsuarioTO usuario) {
        String sql = "insert into t_mw_usuario (nm_usuario, dc_email, nr_rm) values (?, ?, ?)";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getEmail());
            ps.setInt(3, usuario.getRM());
            if (ps.executeUpdate() > 0) {
                return usuario;
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
        String sql = "delete from t_mw_usuario where id_usuario = ?";
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

    public UsuarioTO update(UsuarioTO usuario) {
        String sql = "update t_mw_usuario set nm_usuario = ?, dc_email = ?, nr_rm = ? where id_usuario = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getEmail());
            ps.setInt(3, usuario.getRM());
            ps.setLong(4, usuario.getId());
            if (ps.executeUpdate() > 0) {
                return usuario;
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
