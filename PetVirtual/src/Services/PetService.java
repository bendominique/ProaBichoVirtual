package Services;

import Models.Pet;
import Strategy.BrincadeiraStrategy;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PetService {

    void alimentarPet(UUID id);
    void brincarComPet(UUID id, BrincadeiraStrategy estrategia);
    void cadastarNovoPet(Pet pet);

    void mandarDormir(UUID id);

}
