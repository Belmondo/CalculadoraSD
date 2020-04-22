import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.Socket;

public class CalculadoraClientSocket {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		// TODO Auto-generated method stub
		double oper1=10,oper2=20;
		//inserindo numeros para as opera��es
		int operacao=1, operaSub = 2, operaMult=3,operaDiv=4; //1-somar 2-subtrair 3-dividir 4-multiplicar
		//declara��o das variaveis a serem utilizadas no decorrer do c�digo		
		String result="";
		Socket clientSocket = null;
		DataOutputStream socketSaidaServer = null;
		BufferedReader messageFromServer = null;
		
		//opera��o de soma
		try {

        	//Conex�o com o Servidor
            clientSocket = new Socket(Inet4Address.getLocalHost().getHostAddress(), 9090);
            socketSaidaServer = new DataOutputStream(clientSocket.getOutputStream());
            messageFromServer = new BufferedReader
                    (new InputStreamReader(clientSocket.getInputStream()));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		//Enviando os dados de opera��o, operando 1 e operando 2
        socketSaidaServer.writeBytes(operacao+"\n");
        socketSaidaServer.writeBytes(oper1+ "\n");
        socketSaidaServer.writeBytes( oper2+ "\n");
        socketSaidaServer.flush();
        
        //Recebendo a resposta
        result=messageFromServer.readLine();
       //imprimindo o resultado
        System.out.println("resultado="+result);           
        //fechando conex�o
        clientSocket.close();
        
        
        
      //opera��o de subtra��o
        try {

        	//Conex�o com o Servidor
            clientSocket = new Socket(Inet4Address.getLocalHost().getHostAddress(), 9090);
            socketSaidaServer = new DataOutputStream(clientSocket.getOutputStream());
            messageFromServer = new BufferedReader
                    (new InputStreamReader(clientSocket.getInputStream()));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
		
      //Enviando os dados de opera��o, operando 1 e operando 2
        socketSaidaServer.writeBytes(operaSub+"\n");
        socketSaidaServer.writeBytes(oper1+ "\n");
        socketSaidaServer.writeBytes( oper2+ "\n");
        socketSaidaServer.flush();
        
        //Recebendo a resposta
        result=messageFromServer.readLine();
       //imprimindo resposta
        System.out.println("resultado="+result);           
        //encerrando conex�o
        clientSocket.close();
        
        
      //opera��o de multiplica��o
        try {

        	//Conex�o com o Servidor
            clientSocket = new Socket(Inet4Address.getLocalHost().getHostAddress(), 9090);
            socketSaidaServer = new DataOutputStream(clientSocket.getOutputStream());
            messageFromServer = new BufferedReader
                    (new InputStreamReader(clientSocket.getInputStream()));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
		
      //Enviando os dados de opera��o, operando 1 e operando 2
        socketSaidaServer.writeBytes(operaMult+"\n");
        socketSaidaServer.writeBytes(oper1+ "\n");
        socketSaidaServer.writeBytes( oper2+ "\n");
        socketSaidaServer.flush();
        
        //Recebendo a resposta
        result=messageFromServer.readLine();
       //imprimindo o resultado
        System.out.println("resultado="+result);           
        //fechando a conex�o
        clientSocket.close();
        
        
        //opera��o de divis�o
        try {

        	//Conex�o com o Servidor
            clientSocket = new Socket(Inet4Address.getLocalHost().getHostAddress(), 9090);
            socketSaidaServer = new DataOutputStream(clientSocket.getOutputStream());
            messageFromServer = new BufferedReader
                    (new InputStreamReader(clientSocket.getInputStream()));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		//Enviando os dados de opera��o, operando 1 e operando 2
        socketSaidaServer.writeBytes(operaDiv+"\n");
        socketSaidaServer.writeBytes(oper1+ "\n");
        socketSaidaServer.writeBytes( oper2+ "\n");
        socketSaidaServer.flush();
        
        //Recebendo a resposta
        result=messageFromServer.readLine();
       //imprimindo o resultado
        System.out.println("resultado="+result);           
        //fechando a conex�o
        clientSocket.close();
    

	}

}
