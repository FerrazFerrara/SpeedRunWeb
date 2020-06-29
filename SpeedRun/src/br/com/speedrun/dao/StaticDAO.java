package br.com.speedrun.dao;

import java.util.ArrayList;

import br.com.speedrun2.beans.SpeedRunBean;
import br.com.speedrun2.beans.UsuarioBean;

public class StaticDAO {
	public ArrayList<SpeedRunBean> speedRunsData(){
		ArrayList<SpeedRunBean> speedruns = new ArrayList<SpeedRunBean>();
		for(int i = 0; i < 10; i++) {
			speedruns.add(new SpeedRunBean(i+1, i/2, i + ":59:362", "No Cheats", "PC", "12/"+ i + "/19"));
		}
		return speedruns;
	}
	
	public ArrayList<UsuarioBean> usersData(){
		ArrayList<UsuarioBean> users = new ArrayList<UsuarioBean>();
		for(int i = 0; i < 5; i++) {
			users.add(new UsuarioBean(i+1, "usuario" + i, "gui", "Brasil", "https://twitter.com/FerrazFerrara_", "https://www.facebook.com/gabrielferraz.fontes", "https://www.instagram.com/ferraz._.gabriel/"));
		}
		return users;
	}
}
