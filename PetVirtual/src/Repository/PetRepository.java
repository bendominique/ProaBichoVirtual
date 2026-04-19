package Repository;

import Models.Pet;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class PetRepository {
    List<Pet> pets = new ArrayList<>();

    public void salvarPet(Pet pet){
        pets.add(pet);
    }

    public Optional<Pet> buscarPetId(UUID petId){
            for(Pet pet : pets){
                if(pet.getId().equals(petId)){
                    return Optional.of(pet);
                }
            }
        return Optional.empty();
    }

    public List<Pet> buscarTodosPets(){
        return pets;
    }
}
