package com.cabodeguerra.conexao;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import javax.net.ssl.SSLServerSocket;

public class Servidor {

    public static void main(String[] args) throws IOException {

        ServerSocket srv = new ServerSocket(1234);
        System.out.println(" Servidor rodando na porta 1234");
        while (true) {
            Socket soc = srv.accept();
            Scanner lerCliente = new Scanner(soc.getInputStream());
            String texto = lerCliente.nextLine();
            texto = texto.toUpperCase();
            PrintWriter escrita = new PrintWriter(soc.getOutputStream(), true);
            escrita.println(texto);
        }
        //System.out.println(" Servidor terminou sua execução");

    }
}
