package br.com.speedrun.bo;

import java.util.ArrayList;

import br.com.speedrun.beans.SpeedRunBean;
import br.com.speedrun.dao.SpeedRunDAO;

public class SpeedRunBO {
	public ArrayList<SpeedRunBean> speedRunInDataBase = new ArrayList<SpeedRunBean>();
	private SpeedRunDAO speedRunDAO = new SpeedRunDAO();

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
}
