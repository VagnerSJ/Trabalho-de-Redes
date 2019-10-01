package com.cabodeguerra.conexao;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) throws IOException {

        System.out.println("Digite um texto: ");
        Scanner ler = new Scanner(System.in);
        int forca = ler.nextInt();
        
        Socket soc = new Socket("127.0.0.1", 1234);
        PrintWriter escrita = new PrintWriter(soc.getOutputStream(),true);
        escrita.println(forca);
        
        Scanner lerServidor = new Scanner(soc.getInputStream());
        System.out.println(lerServidor.nextLine());

    }
    
}
