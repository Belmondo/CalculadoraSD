import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class CalculadoraServerSocket {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket welcomeSocket;
		DataOutputStream socketOutput;     	
	    DataInputStream socketInput;
	    BufferedReader socketEntrada;
	    
	    Calculadora calc = new Calculadora();
		try {
			welcomeSocket = new ServerSocket(9090);
		  int i=0; //n�mero de clientes
	  
	      System.out.println ("Servidor no ar");
	      while(true) { 
	  
	           Socket connectionSocket = welcomeSocket.accept(); 
	           i++;
	           System.out.println ("Nova conex�o" + welcomeSocket.getInetAddress());
	          
	           
	           //Interpretando dados do servidor
	           socketEntrada = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
               String operacao= socketEntrada.readLine();
               String oper1=socketEntrada.readLine();
               String oper2=socketEntrada.readLine();
               
             //Chamando a calculadora
               String result="";
               
               //avalia��o da opera��o recebida e direcionamento para cada caso correspondente
               switch(Integer.parseInt(operacao)){
               case 1:
            	   result = ""+ calc.soma(Double.parseDouble(oper1),Double.parseDouble(oper2));
                   break;
               case 2:
            	   result = ""+ calc.subtracao(Double.parseDouble(oper1),Double.parseDouble(oper2));
                   break;
               case 3:
            	   result = ""+ calc.multiplicacao(Double.parseDouble(oper1),Double.parseDouble(oper2));
                   break;
               case 4:
            	   result = ""+ calc.divisao(Double.parseDouble(oper1),Double.parseDouble(oper2));
                   break;
                   
               default:
                   System.out.println("Digite SOMENTE n�meros entre 1 e 4");
                   break;
           }
               
               
               //Enviando dados para o servidor
               socketOutput= new DataOutputStream(connectionSocket.getOutputStream());     	
	           socketOutput.writeBytes(result+ '\n');
	           System.out.println (result);	           
	           socketOutput.flush();
	           socketOutput.close();

	                    
	      }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	    
	}

}
