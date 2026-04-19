package Models;

import Strategy.BrincadeiraStrategy;

public class Cachorro extends Pet{

    public Cachorro(String nome){
        super(nome);

    }

    @Override
    public void brincar(BrincadeiraStrategy estrategia) {
        estrategia.executar(this);
    }

    @Override
    public void comer() {
        setNivelFome(getNivelFome() + 10);
    }

    @Override
    public void dormir() {
        setNivelCansaco(getNivelCansaco() - 30);

    }

    @Override
    public void envelhecer() {
        setNivelCansaco(getNivelCansaco() + 10);
    }

    @Override
    public void verificarStatus() {

    }
}
