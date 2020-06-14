package br.com.speedrun3.bo;

import java.util.ArrayList;

import br.com.speedrun.dao.SpeedRunDAO;
import br.com.speedrun2.beans.SpeedRunBean;
import br.com.speedrun2.beans.UsuarioBean;

public class SpeedRunBO {
	public ArrayList<SpeedRunBean> speedRunInDataBase = new ArrayList<SpeedRunBean>();
	private SpeedRunDAO speedRunDAO = new SpeedRunDAO();
	public static int idSpeedRunOwner = -1;

	public SpeedRunBO(){
		this.getSpeedRunDAO();
	}

	public boolean addSpeedRun(SpeedRunBean speedRun) {
		if(this.speedRunDAO.inserirSpeedRun(speedRun))
			return true;
		return false;
	}

	public ArrayList<SpeedRunBean> getSpeedRunDAO() {
		this.speedRunInDataBase = speedRunDAO.buscaSpeedruns();
		return this.speedRunInDataBase;
	}

	public void setSpeedRunDAO(SpeedRunDAO speedRunDAO) {
		this.speedRunDAO = speedRunDAO;
	}
	
	public boolean viewSpeedRunOwner(String id) {
		String[] buttonIDstr = id.split(":");
		int buttonID = Integer.parseInt(buttonIDstr[1]);
		
		for (UsuarioBean user : new UsuarioBO().usuariosInDataBase) {
			if (user.getIdUser() == buttonID) {
				SpeedRunBO.idSpeedRunOwner = buttonID;
				return true;
			}
		}
		return false;
	}
}
