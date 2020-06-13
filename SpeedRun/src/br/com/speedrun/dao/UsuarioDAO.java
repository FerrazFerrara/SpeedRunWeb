package br.com.speedrun.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.speedrun.beans.UsuarioBean;

public class UsuarioDAO {
	private Connection conn;
	private PreparedStatement prep;
	private Statement st;
	private ResultSet rs;
	
	private ArrayList<UsuarioBean> usuarios = new ArrayList<UsuarioBean>();
	
	public UsuarioDAO() {
		conn = new ConnectorDAO().getConnection();
	}
	
	public boolean inserirUsuario(UsuarioBean usuario) {
		String sql = "INSERT INTO usuario (login, senha, pais, twitter, youtube, instagram) values (?,?,?,?,?,?)";
		
		try {
			
			prep = conn.prepareStatement(sql);
			prep.setString(1, usuario.getLogin());
			prep.setString(2, usuario.getSenha());
			prep.setString(3, usuario.getPais());
			prep.setString(4, usuario.getTwitter());
			prep.setString(5, usuario.getYoutube());
			prep.setString(6, usuario.getInstagram());
			prep.execute();
			prep.close();			
			return true;
			
		}catch (Exception e) {
			System.out.println("Erro ao inserir usuario: " + e);
			return false;
		}
	}
	
	public ArrayList<UsuarioBean> buscaUsuarios() {
		String sql = "SELECT * FROM usuario";
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				UsuarioBean usuario = new UsuarioBean(rs.getInt("idUser"), rs.getString("login"), rs.getString("senha"), rs.getString("pais"), rs.getString("twitter"), rs.getString("youtube"), rs.getString("instagram"));
				usuarios.add(usuario);
			}
			
			return usuarios;
		}catch (Exception e) {
			throw new RuntimeException("erro ao buscar usuarios do banco");
		}
	}
	
	public boolean updateCarroAll(UsuarioBean usuario, int id) {
		String instagram = "instagram = \"" + usuario.getInstagram() + "\"";
		String twitter = ", twitter = \"" + usuario.getTwitter() + "\"";
		String youtube = ", youtube = \"" + usuario.getYoutube() + "\"";
		String sql = "UPDATE carros SET " + youtube + twitter + instagram + " where id_carro = " + id;
		
		try {
			prep = conn.prepareStatement(sql);
			prep.execute();
			prep.close();
			return true;
		} catch (Exception e) {
			System.out.println("Erro ao dar update no usuario: " + e);
			return false;
		}
	}
	
	public boolean deleteUsuario(UsuarioBean usuario) {
		String sql = "DELETE FROM usuario WHERE id_carro = " + usuario.getIdUser();
		
		try {
			prep = conn.prepareStatement(sql);
			prep.execute();
			prep.close();
			return true;
		} catch (Exception error) {
			System.out.println("erro ao deletar usuario por conta de: " + error);
			return false;
		}
	}
}
