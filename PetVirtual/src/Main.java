import Controller.PetController;
import Models.Pet;
import Repository.PetRepository;
import Services.Implement.PetServiceImplement;
import Services.PetService;

public class Main {
    public static void main(String[] args) {

        PetRepository repositorio = new PetRepository();
        PetService servico = new PetServiceImplement(repositorio);
        PetController controller = new PetController(servico, repositorio);

        controller.executarMenu(null);

        }
    }
