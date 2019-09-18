package com.cabodeguerra.entidade;


public class Equipe {
    
    private String nome;
    private int vitorias;
    
    public Equipe(String nome){
        setNome(nome);
        this.vitorias = 0;
    }
    
    private void setNome(String nome){
        this.nome = nome;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public int getVitorias(){
        return this.vitorias;
    }
    
    public void addVitoria(){
        this.vitorias++;
    }
}
