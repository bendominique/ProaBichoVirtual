package PetFactory;


import Models.Cachorro;
import Models.Pet;

public class PetFactory {

    public static Pet criarPet(String nome, String escolha) {
        switch (escolha) {
            case "1":
                return new Cachorro(nome);
            default: return null;
        }
    }
}
