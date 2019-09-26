package conexao;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/*public class Server {

    public static void main(String[] args) throws IOException {
        // inicia o servidor
        new Server(1234).executa();
    }

    private int porta;
    private List<PrintStream> clientes;

    public Server (int porta) {
        this.porta = porta;
        this.clientes = new ArrayList<PrintStream>();
    }

    public void executa () throws IOException {
        ServerSocket servidor = new ServerSocket(this.porta);
        System.out.println("Porta 1234 aberta!");

        while (true) {
            // aceita um cliente
            Socket cliente = servidor.accept();
            System.out.println("Nova conexão com o jogador " +     
                cliente.getInetAddress().getHostAddress()
            );

            // adiciona saida do cliente à lista
            PrintStream ps = new PrintStream(cliente.getOutputStream());
            this.clientes.add(ps);

            // cria tratador de cliente numa nova thread
            TrataCliente tc = new TrataCliente(cliente.getInputStream(), this);
            new Thread(tc).start();
        }

    }

    public void distribuiMensagem(String msg) {
        // envia msg para todo mundo
        for (PrintStream cliente : this.clientes) {
            cliente.println(msg);
        }
    }
}*/

/*public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket servidor = new ServerSocket(1234);
        System.out.println("Servidor aberto!");

        Socket cliente = servidor.accept();
        System.out.println("Conexao com " +     
            cliente.getInetAddress().getHostAddress() + " estabelecida!"
        );

        Scanner s = new Scanner(cliente.getInputStream());
        while (s.hasNextLine()) {
            System.out.println(s.nextLine());
        }

        s.close();
        servidor.close();
        cliente.close();
    }
}*/

public class Server {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(1234);
			System.out.println("Servidor em rede");
			while (true) {
				Socket client = server.accept();
				Thread thread = new Thread(new AdvinhaPalavra(client));
				thread.start();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}