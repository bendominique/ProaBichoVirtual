package Services.Implement;

import Models.Pet;
import PetFactory.PetFactory;
import Repository.PetRepository;
import Services.PetService;
import Strategy.BrincadeiraStrategy;

import java.util.UUID;

public class PetServiceImplement implements PetService {

    public PetRepository petRepository;
    public PetServiceImplement(PetRepository repositorio){
        this.petRepository = repositorio;
    }

    @Override
    public void alimentarPet(UUID id) {
        var petId = petRepository.buscarPetId(id);
       // se executarmos assim e um pet não existir, o sistema trava petId.get().setNivelFome(petId.get().getNivelFome() - 30);
        if(!petId.isPresent()){
            System.out.println("Seu bichinho não foi encontrado");
        } else petId.get().setNivelFome(petId.get().getNivelFome() - 30);
    }

    @Override
    public void brincarComPet(UUID id, BrincadeiraStrategy estrategia) {
        var petId = petRepository.buscarPetId(id);
        if(!petId.isPresent()){
            System.out.println("Seu bichinho não foi encontrado");
        } else {
//            petId.get().setNivelFelicidade(petId.get().getNivelFelicidade() + 30);
//            petId.get().setNivelCansaco(petId.get().getNivelCansaco() + 30); já haviamos criado um executar para que implementasse os níveis de cansaço e de felicidade do pet
            estrategia.executar(petId.get());

        }
    }

    @Override
    public void cadastarNovoPet(Pet pet){
        petRepository.salvarPet(pet);
    }

    @Override
    public void mandarDormir(UUID id) {
        var petId = petRepository.buscarPetId(id);
        if(!petId.isPresent()){
            System.out.println("Seu bichinho não foi encontrado");
        } else petId.get().setNivelCansaco(petId.get().getNivelCansaco() - 100);
    }
}

