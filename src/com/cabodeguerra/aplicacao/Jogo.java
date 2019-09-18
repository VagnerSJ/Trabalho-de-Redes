package com.cabodeguerra.aplicacao;

import com.cabodeguerra.entidade.Equipe;
import java.util.Locale;
import java.util.Scanner;

public class Jogo {
	
    public static void main(String args[]) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        char opcao = apresentacao();

        System.out.println("\n\n");
        if(opcao == 'y' || opcao == 'Y') {
            Equipe equipe1;
            equipe1 = new Equipe();
            Equipe equipe2 = new Equipe();
            partida(equipe1, equipe2);
        }
        else{
            fimJogo();
        }
    }

    public static char apresentacao() {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("####################################");
        System.out.println("----BEM VINDO AO CABO DE GUERRA!----");
        System.out.println("####################################");
        System.out.println("\n");

        System.out.println(">>>REGRAS<<<");

        System.out.println("- O jogo possui dois parametros: forca e resistencia;");
        System.out.println("- O jogador possui 10 pontos por rodada para alocar nos parametros");
        System.out.println("- Cada um dos parametros podem ter ate 10 pontos alocados;");
        System.out.println("- Cada jogador possui 30 pontos no seu campo;");
        System.out.println("- Vence o jogador que fizer o adiversario chegar na linha central (perder 30 pontos).");
        System.out.println("\n");

        char opcao = 0;
        boolean querJogar = false;
        while(!querJogar) {	
            System.out.print("Deseja jogar (Y/N)? ");
            opcao = sc.nextLine().charAt(0);

            if(opcao == 'y' || opcao == 'Y') {
                return opcao;
            }
            else if(opcao == 'n' || opcao == 'N'){
                return opcao;
            }
            else {
                System.out.println("Opcao invalida!\n");
            }
        }
        return opcao;
    }

    private static void partida(Equipe equipe1, Equipe equipe2) {
        int tamanho = 76;
        int demarcacao = (tamanho / 2);
        equipe1. = 30;
        int campoEquipe2 = 30;
        String[] campo = new String[tamanho];

        renderizarTela(campo, demarcacao, campoEquipe1, campoEquipe2);
        System.out.println("\n");
        
        


    }

    private static void fimJogo() {
        System.out.println("### Fim do jogo! ###\n");
    }

    private static void renderizarTela(String[] campo, int demarcacao, int campoEquipe1, int campoEquipe2) {
        for(int i = 0; i < campo.length; i++) {
            if(i == demarcacao) {
                campo[i] = "|";
            }
            else if(i <= demarcacao && i >= demarcacao - (campoEquipe1 / 2)){
                campo[i] = "-";
            }
            else if(i >= demarcacao && i <= demarcacao + (campoEquipe2 / 2)){
                campo[i] = "-";
            }
            else if(i == demarcacao - (campoEquipe1 / 2) - 1){
                campo[i] = "]";
            }
            else if(i == demarcacao - (campoEquipe1 / 2) - 5){
                campo[i] = "[";
            }
            else if(i == demarcacao + (campoEquipe2 / 2) + 1){
                campo[i] = "[";
            }
            else if(i == demarcacao + (campoEquipe2 / 2) + 5){
                campo[i] = "]";
            }
            else if(i == demarcacao - (campoEquipe1 / 2) - 2 || 
                    i == demarcacao - (campoEquipe1 / 2) - 3 ||
                    i == demarcacao - (campoEquipe1 / 2) - 4){
                campo[i] = "F";
            }
            else if(i == demarcacao + (campoEquipe2 / 2) + 2 || 
                    i == demarcacao + (campoEquipe2 / 2) + 3 ||
                    i == demarcacao + (campoEquipe2 / 2) + 4){
                campo[i] = "T";
            }
            else if(i == 0){
                campo[i] = Integer.toString(campoEquipe1);
            }
            else if(i == campo.length - 1){
                campo[i] = Integer.toString(campoEquipe2);
            }
            else {
                campo[i] = " ";
            } 
        }

        for(String r : campo) {
            System.out.print(r);
        }

        System.out.println("\n");
    }
    
    public void setNome(String nome){
        nome 
    }
	
}
