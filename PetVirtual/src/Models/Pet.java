package Models;
import Enum.EstadoPet;
import Strategy.BrincadeiraStrategy;

import java.util.UUID;

public abstract class Pet {

    private UUID id;
    private String nome;
    private int idade;
    private int nivelFelicidade;
    private int nivelFome;
    private int nivelCansaco;

    public Pet(String nome){
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.idade = 0;
        this.nivelFelicidade = 50;
        this.nivelFome = 50;
        this.nivelCansaco = 50;
    }

    public UUID getId(){return this.id;}
    public String getNome(){
        return this.nome;
    }
    public int getIdade() {
        return this.idade;
    }
    public int getNivelFelicidade(){
        return this.nivelFelicidade;
    }
    public int getNivelFome(){
        return this.nivelFome;
    }
    public int getNivelCansaco() {return this.nivelCansaco;}

    public String setNome(String nome){
        this.nome = nome;
        return nome;
    }

    public int setIdade(int idade){
        this.idade = idade;
        return idade;
    }
    public void setNivelFelicidade(int nivelFelicidade){
        if(nivelFelicidade > 100){
            nivelFelicidade = 100;
        }
        this.nivelFelicidade = nivelFelicidade;
    }
    public void setNivelFome(int nivelFome){
        if(nivelFome > 100){
            nivelFome = 100;
        } else if(nivelFome < 0){
            nivelFome = 0;
        }
        this.nivelFome = nivelFome;
    }
    public void setNivelCansaco(int nivelCansaco){
        if(nivelCansaco > 100){
            nivelCansaco = 100;
        }
        this.nivelCansaco = nivelCansaco;
    }

    public boolean isPetVivo(){
        return !(nivelFome >= 100 || nivelFelicidade <= 0 || nivelCansaco >= 100);
    }

    public EstadoPet getEstado(){
        if(!isPetVivo()){
           return EstadoPet.MORTO;
        }
        return EstadoPet.VIVO;
    }


    public abstract void brincar(BrincadeiraStrategy estrategia);
    public abstract void comer();
    public abstract void dormir();
    public abstract void envelhecer();
    public abstract void verificarStatus();
}
