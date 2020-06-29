package br.com.speedrun3.bo;

import java.util.ArrayList;

import br.com.speedrun.dao.SpeedRunDAO;
import br.com.speedrun2.beans.SpeedRunBean;
import br.com.speedrun2.beans.UsuarioBean;

public class SpeedRunBO {
	/// array list de speedruns presentes no banco
	public ArrayList<SpeedRunBean> speedRunInDataBase = new ArrayList<SpeedRunBean>();
	/// referencia ao banco
	private SpeedRunDAO speedRunDAO = new SpeedRunDAO();
	/// usuario dono da speedrun selecionada
	public static int idSpeedRunOwner = -1;

	public SpeedRunBO(){
		this.getSpeedRunDAO();
	}

	/**
	 * inseri uma speedrun ao banco
	 * @param speedRun: speedrun a ser inserida
	 * @return se a operacao de inserção deu certo ou nao
	 */
	public boolean addSpeedRun(SpeedRunBean speedRun) {
		if(this.speedRunDAO.inserirSpeedRun(speedRun))
			return true;
		return false;
	}

	/**
	 * buscar speedruns do banco
	 * @return arraylist de speedruns
	 */
	public ArrayList<SpeedRunBean> getSpeedRunDAO() {
		this.speedRunInDataBase = speedRunDAO.buscaSpeedruns();
		return this.speedRunInDataBase;
	}
	
	/**
	 * busca speedruns de um determinado usuario
	 * @param id: id do usuario que deseja buscar as speedruns
	 * @return array de speedruns
	 */
	public ArrayList<SpeedRunBean> getSpeedRunDAO(int id){
		return speedRunDAO.buscaSpeedruns(id);
	}

	public void setSpeedRunDAO(SpeedRunDAO speedRunDAO) {
		this.speedRunDAO = speedRunDAO;
	}
	
	/**
	 * determina qual usuario foi selecionado
	 * @param id: string com o dado do usuario
	 * @return se o usuario selecionado existe no banco
	 */
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
