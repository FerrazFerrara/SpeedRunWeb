package br.com.speedrun1.apiservices;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;

public class ServerCommunication {
	// Atributo Mock para setar propety do userAgent
	private static final String USER_AGENT = "Mozilla/5.0";

	// URL para GET do usuário para pegar os dados ou verificar determinado usuário. 
	private static final String GET_URL = "http://speedsouls.herokuapp.com/usuario";

	// URL para Post do usuário, para enviar dado no login para cadastramento.
	// (Passível a mudança)
	private static final String POST_URL = "http://speedsouls.herokuapp.com/usuario";

	// Envia ao servidor em nuvem determinado username e password para verificar existencia no banco de dados
	// retornando um booleano com a confirmaçao de determinado usuário, true se existir e false se não existir
	 public boolean sendLoginGetter(String username,String password) throws IOException {
		URL obj = new URL(GET_URL + "/" + username + "/" + password);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);
		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
			System.out.println(response.toString());
			if (response.toString().equals("[]")) {
				return false;
			}
			return true;
		} else {
			System.out.println("GET request not worked");
			return false;
		}

	}
	 
	 // Envia ao servidor uma conta com dados do username e password, cadastrando assim no serviço
	 // em nuvem, métodos de verificação inclusos no server-side.
	 // Utiliza JSONObject para escrever on OutputStream e assim fazer a comuninicação com o servidor.
	 public void sendPOST(String username,String password) throws IOException {
		URL obj = new URL(POST_URL);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);

		// For POST only - START
		JSONObject account = new JSONObject();
		account.put("name",username);
		account.put("password",password);
		con.setDoOutput(true);
		OutputStreamWriter os = new OutputStreamWriter(con.getOutputStream());
		os.write(account.toString());
		os.flush();
		os.close();
		// For POST only - END

		int responseCode = con.getResponseCode();
		System.out.println("POST Response Code :: " + responseCode);

		if (responseCode == HttpURLConnection.HTTP_OK) { //success
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
			System.out.println(response.toString());
		} else {
			System.out.println("POST request not worked");
		}
	}

}