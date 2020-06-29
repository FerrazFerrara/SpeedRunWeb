package br.com.speedrun.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.speedrun2.beans.SpeedRunBean;

public class SpeedRunDAO {
	private Connection conn;
	private PreparedStatement prep;
	private Statement st;
	private ResultSet rs;
	ConnectorDAO c = new ConnectorDAO();
	/// array de speedruns do banco
	private ArrayList<SpeedRunBean> speedruns = new ArrayList<SpeedRunBean>();
	
	public SpeedRunDAO() {
		conn = new ConnectorDAO().getConnection();
	}
	
	/**
	 * inseri nova speedrun no banco
	 * @param speedRun: nova Speedrun a ser adicionada ao banco
	 * @return se a operacao de adição funcinou ou nao
	 */
	public boolean inserirSpeedRun(SpeedRunBean speedRun) {
		
		String sql = "INSERT INTO speedruns (tempo, modoJogo, plataforma, dia, idUser) values (TO_DATE(?, '%i:%s:%f'),?,?,TO_DATE(?, 'DD/MM/YYYY'),?)";
		
		try {
			
			prep = conn.prepareStatement(sql);
			prep.setDate(1, Date.valueOf(speedRun.getTempo()));
			prep.setString(2, speedRun.getModoJogo());
			prep.setString(3, speedRun.getPlataforma());
			prep.setDate(4, Date.valueOf(speedRun.getDia()));
			prep.setInt(5, speedRun.getIdUser());
			prep.execute();
			prep.close();			
			return true;
			
		}catch (Exception e) {
			System.out.println("Erro ao inserir speedrun: " + e);
			return false;
		}
	}
	
	/**
	 * busca todas as speedruns do banco
	 * @return arraylist de speedruns
	 */
	public ArrayList<SpeedRunBean> buscaSpeedruns() {
		String sql = "SELECT * FROM speedruns";
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				String tempo = rs.getDate("tempo").toString();
				String dia = rs.getDate("dia").toString();
				SpeedRunBean speedrun = new SpeedRunBean(rs.getInt("idSR"), rs.getInt("idUser"), tempo, rs.getString("modoJogo"), rs.getString("plataforma"), dia);
				speedruns.add(speedrun);
			}
			
			return speedruns;
		}catch (Exception e) {
			throw new RuntimeException("erro ao buscar speedruns do banco");
		}
	}
	
	/**
	 * busca as speedruns de um usuario especifico do banco
	 * @return arraylist de speedruns
	 */
	public ArrayList<SpeedRunBean> buscaSpeedruns(int id) {
		String sql = "SELECT * FROM speedruns where idUser = " + id;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				String tempo = rs.getDate("tempo").toString();
				String dia = rs.getDate("dia").toString();
				SpeedRunBean speedrun = new SpeedRunBean(rs.getInt("idSR"), rs.getInt("idUser"), tempo, rs.getString("modoJogo"), rs.getString("plataforma"), dia);
				speedruns.add(speedrun);
			}
			
			return speedruns;
		}catch (Exception e) {
			throw new RuntimeException("erro ao buscar speedruns do banco");
		}
	}
	
	/**
	 * atualiza uma speedrun
	 * @param speedrun: speedrun com os dados atualizados
	 * @param id: id da speedrun a ser atualizada
	 * @return
	 */
	public boolean updateSpeedRun(SpeedRunBean speedrun, int id) {
		String tempo = "tempo = TO_DATE('" + speedrun.getTempo() + "', '%i:%s:%f')";
		String modoJogo = ", modoJogo = \"" + speedrun.getModoJogo() + "\"";
		String plataforma = ", plataforma = \"" + speedrun.getPlataforma() + "\"";
		String dia = ", dia = TO_DATE('" + speedrun.getDia() + "', 'DD/MM/YYYY')";
		String sql = "UPDATE carros SET " + tempo + modoJogo + plataforma + dia + " where id_carro = " + id;
		
		try {
			prep = conn.prepareStatement(sql);
			prep.execute();
			prep.close();
			return true;
		} catch (Exception e) {
			System.out.println("Erro ao dar update na speedrun: " + e);
			return false;
		}
	}
}
