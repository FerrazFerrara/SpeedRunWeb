package br.com.speedrun3.bo;

import br.com.speedrun2.beans.UsuarioBean;

/**
 * 
 * Classe singleton para armazenar o usuario logado atualmente
 *
 */
public class ActualUserBO {
	// Atributos	
	// Instancia do Bean do usuário para pegar o usuário logado atualmente.
	private static UsuarioBean shared;
	
	// Construtores
	private ActualUserBO() {
	}
	
	// Métodos
	// Pegar instancia do usuário atual
	public static UsuarioBean getActualUser() {
		return shared;
	}
	// Realizar o login e atribuir usuário logado com o pegado por parametro
	public static void realizarLogin(UsuarioBean user) {
		shared = user;
	}
	
	// Deslogar da conta e atribuindo usuário logado com null, tornando inviável pro usuário realizar
	// determinadas açoes
	public static void sairConta() {
		shared = null;
	}
}
