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
            System.out.print("Digite o nome da Equipe 1: ");
            Equipe equipe1 = new Equipe(nomeEquipe());
            System.out.print("Digite o nome da Equipe 2: ");
            Equipe equipe2 = new Equipe(nomeEquipe());
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
        System.out.println("- O jogador possui 10 pontos por rodada para alocar nos parametros;");
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
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        
        int tamanho = 76;
        int demarcacao = (tamanho / 2);
        int campoEquipe1 = 30;
        int campoEquipe2 = 30;
        int forcaEquipe1;
        int forcaEquipe2;
        boolean rodando = false;
        String[] nomeEquipes = new String[tamanho];
        String[] campo = new String[tamanho];

        renderizarTela(campo, nomeEquipes, demarcacao, campoEquipe1, campoEquipe2, equipe1, equipe2);
        System.out.println("\n");
        
        while(!rodando){
            System.out.print("Equipe " + equipe1.getNome() + ": quanto deseja alocar em forca? ");
            forcaEquipe1 = sc.nextInt();
            
            System.out.print("Equipe " + equipe2.getNome() + ": quanto deseja alocar em forca? ");
            forcaEquipe2 = sc.nextInt();

            int vencedorRodada = calculoRodada(forcaEquipe1, forcaEquipe2);
            
            if(vencedorRodada == 1){
                campoEquipe1 += forcaEquipe1 - forcaEquipe2;
                campoEquipe2 -= forcaEquipe1 - forcaEquipe2;
                System.out.println("\n\nEquipe " + equipe1.getNome() + " aplicou mais forca, ganhando mais terreno!");
            }
            else if(vencedorRodada == 2){
                campoEquipe1 -= forcaEquipe2 - forcaEquipe1;
                campoEquipe2 += forcaEquipe2 - forcaEquipe1;
                System.out.println("\n\nEquipe " + equipe2.getNome() + " aplicou mais forca, ganhando mais terreno!");
            }
            else{
                System.out.println("\n\nEmpate! Chegamos em um impasse de forcas!");
            }
            
            renderizarTela(campo, nomeEquipes, demarcacao, campoEquipe1, campoEquipe2, equipe1, equipe2);
            System.out.println("\n");
            
            if(campoEquipe1 <= 0 || campoEquipe2 <= 0){
                rodando = true;
                vencedor(campoEquipe1, campoEquipe2, equipe1, equipe2);
            }
        }
    }
    
    private static void vencedor(int campoEquipe1, int campoEquipe2, Equipe equipe1, Equipe equipe2){
        if(campoEquipe2 <= 0){
            System.out.println("Equipe " + equipe1.getNome() + " venceu, ganhando todo o terreno adversario!\n");
            fimJogo();
        }
        else if(campoEquipe1 <= 0){
            System.out.println("Equipe " + equipe2.getNome() + " venceu, ganhando todo o terreno adversario!\n");
            fimJogo();
        }
    }
    
    private static int calculoRodada(int forcaEquipe1, int forcaEquipe2){
        if(forcaEquipe1 > forcaEquipe2){
            return 1;
        }
        else if(forcaEquipe2 > forcaEquipe1){
            return 2;
        }
        
        return 0;
    }

    private static void fimJogo() {
        System.out.println("### Fim do jogo! ###\n");
    }

    private static void renderizarTela(String[] campo, String[] nomeEquipes, int demarcacao, int campoEquipe1, int campoEquipe2, Equipe equipe1, Equipe equipe2) {
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
        
        for(int i = 0; i < nomeEquipes.length; i++){
            if(i == 0){
                nomeEquipes[i] = equipe1.getNome();
            }
            else if(i == nomeEquipes.length - 5){
                nomeEquipes[i] = equipe2.getNome();
            }
            else{
                nomeEquipes[i] = " ";
            }
        }
        
        System.out.println("\n");
        
        for(String n : nomeEquipes) {
            System.out.print(n);
        }
        
        System.out.println("\n");

        for(String r : campo) {
            System.out.print(r);
        }

        System.out.println("\n");
    }
    
    public static String nomeEquipe(){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        
        return sc.nextLine();
    }
	
}
