package conexao;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/*public class Client {
    public static void main(String[] args) throws UnknownHostException, IOException {
        // dispara cliente
        new Client("127.0.0.1", 1234).executa();
    }

    private String host;
    private int porta;

    public Client (String host, int porta) {
        this.host = host;
        this.porta = porta;
    }

    public void executa() throws UnknownHostException, IOException {
        Socket cliente = new Socket(this.host, this.porta);
        System.out.println("O jogador se conectou ao servidor!");

        // thread para receber mensagens do servidor
        Recebedor r = new Recebedor(cliente.getInputStream());
        new Thread(r).start();

        // lê msgs do teclado e manda pro servidor
        Scanner teclado = new Scanner(System.in);
        PrintStream saida = new PrintStream(cliente.getOutputStream());
        while (teclado.hasNextLine()) {
            saida.println(teclado.nextLine());
        }

        saida.close();
        teclado.close();
        cliente.close();        
    }
}*/

/*public class Client {
	public static void main(String[] args) {
		try {
			Socket client = new Socket("127.0.0.1", 1234);
			Scanner in = new Scanner(client.getInputStream());
			Scanner inUser = new Scanner(System.in);
			PrintWriter out = new PrintWriter(client.getOutputStream(),true);
			System.out.println(in.nextLine());
			
			while (true) {
				System.out.println("Digite uma letra: ");
				out.println(inUser.nextLine());
				System.out.println(in.nextLine());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}*/

public class Client {
    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket client = new Socket("127.0.0.1", 1234);
        System.out.println("O jogador se conectou ao servidor!");

        Scanner teclado = new Scanner(System.in);
        PrintStream saida = new PrintStream(cliente.getOutputStream());

        while (teclado.hasNextLine()) {
            saida.println(teclado.nextLine());
        }

        saida.close();
        teclado.close();
        client.close();
    }
}
