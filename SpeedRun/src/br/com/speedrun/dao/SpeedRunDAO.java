package br.com.speedrun.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.speedrun.beans.SpeedRunBean;

public class SpeedRunDAO {
	private Connection conn;
	private PreparedStatement prep;
	private Statement st;
	private ResultSet rs;
	ConnectorDAO c = new ConnectorDAO();
	private ArrayList<SpeedRunBean> speedruns = new ArrayList<SpeedRunBean>();
	
	public SpeedRunDAO() {
		conn = new ConnectorDAO().getConnection();
	}
	
	public boolean inserirSpeedRun(SpeedRunBean speedRun) {
		
		String sql = "INSERT INTO speedruns (tempo, modoJogo, plataforma, dia, idUser) values (?,?,?,?,?)";
		
		try {
			
			prep = conn.prepareStatement(sql);
			prep.setString(1, speedRun.getTempo());
			prep.setString(2, speedRun.getModoJogo());
			prep.setString(3, speedRun.getPlataforma());
			prep.setString(4, speedRun.getDia());
//			prep.setDate(4, x);
			prep.setInt(5, speedRun.getIdUser());
			prep.execute();
			prep.close();			
			return true;
			
		}catch (Exception e) {
			System.out.println("Erro ao inserir speedrun: " + e);
			return false;
		}
	}
	
	public ArrayList<SpeedRunBean> buscaSpeedruns() {
		String sql = "SELECT * FROM speedruns";
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				SpeedRunBean speedrun = new SpeedRunBean(rs.getInt("idSR"), rs.getInt("idUser"), rs.getString("tempo"), rs.getString("modoJogo"), rs.getString("plataforma"), rs.getString("dia")/*rs.getDate("dia")*/);
				speedruns.add(speedrun);
			}
			
			return speedruns;
		}catch (Exception e) {
			throw new RuntimeException("erro ao buscar speedruns do banco");
		}
	}
}
