package Strategy;

import Models.Pet;

public class BolinhaStrategy implements BrincadeiraStrategy{
    @Override
    public void executar(Pet pet) {
        pet.setNivelFelicidade(pet.getNivelFelicidade() + 10);
        pet.setNivelCansaco(pet.getNivelCansaco() + 10);
    }
}
