import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class CalculadoraClientHTTP {

	public static void main(String[] args) {
		
		//apenas comentar as linhas de código como foi pedido.
		
	String result="";
    try {
       //cria url
       URL url = new URL("https://double-nirvana-273602.appspot.com/?hl=pt-BR");
       HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
       //timeout de leitura
        conn.setReadTimeout(10000);
      //timeout da conexão
        conn.setConnectTimeout(15000);
      //escolha do método para envio dos dados ao servidor https
        conn.setRequestMethod("POST");
        conn.setDoInput(true);
      //envio de solicitação
        conn.setDoOutput(true) ;

        //ENVIO DOS PARAMETROS
        OutputStream os = conn.getOutputStream();
        BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(os, "UTF-8"));
        writer.write("oper1=15&oper15=2&operacao=1"); //1-somar 2-subtrair 3-multiplicar 4-dividir
        writer.flush();
        writer.close();
        os.close();

     // armazena o retorno da requisição
        int responseCode=conn.getResponseCode();
     // verifica se a requisição foi feita com sucesso
        if (responseCode == HttpsURLConnection.HTTP_OK) {

            //RECBIMENTO DOS PARAMETROS


            BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), "utf-8"));
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            //conversão da resposta para string
            result = response.toString();
            //imprime a resposta do servidor
            System.out.println("Resposta do Servidor PHP="+result);
        }
        //para caso entre em excecão
    } catch (IOException e) {
        e.printStackTrace();
    }
	}
}
