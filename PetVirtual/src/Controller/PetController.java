package Controller;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import Models.Pet;
import PetFactory.PetFactory;
import Repository.PetRepository;
import Services.PetService;
import Strategy.BolinhaStrategy;
import Strategy.BrincadeiraStrategy;

public class PetController {
    public Scanner inputUsuario;
    private final PetRepository repositorioPet;
    private final PetService servicoPet;
    private final Map<String, BrincadeiraStrategy> acoesPet = new HashMap<>();

    public PetController(PetService _servico, PetRepository _repositorio) {
        this.repositorioPet = _repositorio;
        this.servicoPet = _servico;

        acoesPet.put("1", new BolinhaStrategy());
    }



    public void executarMenu(Pet pet){
        System.out.println("Selecione o que deseja fazer com " + pet.getNome() + " ?");
        System.out.println("1. Alimentar");
        System.out.println("2. Brincar");
        System.out.println("3. Dormir Juntos");
        System.out.println("4. Verificar Status");
        var escolherAcao = inputUsuario.nextLine();
        var estrategia = acoesPet.get(escolherAcao);

        switch(escolherAcao){
            case "1":
            servicoPet.alimentarPet(pet.getId());
                break;
            case "2":
                servicoPet.brincarComPet(pet.getId(), estrategia);
                break;
        }
    }

    public void comecarJogo(){
        System.out.println("É uma honra tê-lo aqui, seja bem vindo ao simulador de Pets");
        System.out.println("O que deseja fazer? ");
        System.out.println("1. Adotar um pet | 2. Ver meus pets ");
        var opcao = inputUsuario.nextLine();

        switch(opcao){
            case "1":
                selecionarPet();
                break;
            case "2":
                obterTodosPets();
                break;
        }

    }

    public void selecionarPet(){
        System.out.println("Olá, seja bem vindo ao simulador de Pets");
        System.out.println("Selecione qual bichinho você deseja adotar: ");
        System.out.println("1.Cachorro | 2.Canário | 3.Coelho | 4.Furão | 5.Gato | 6.Hamster");
        var escolhaPet = inputUsuario.nextLine();

        switch (escolhaPet) {
            case "1":
                System.out.println("Uhuull! Você escolheu um cachorrinho!");
                System.out.println("          _\n" +
                        "  _..._   \\':,\n" +
                        " `._..-\"\"` ) \\\\\n" +
                        "  ___/9    \\ |/\n" +
                        " P      9     |\n" +
                        " \\            |\n" +
                        "  '--.       _/\n" +
                        "      (`'---'_)\n" +
                        "     ()`---'` \\\n" +
                        "      |        ',\n" +
                        "      |          `'.            ,\n" +
                        "      ;             '-._       /(\n" +
                        "       \\            _   `'.    | \\\n" +
                        "       | ,        .'       '.   \\ `\\\n" +
                        "       | |   ;   /           \\   \\  \\\n" +
                        "       | |   |.  |            |  /  |\n" +
                        "       | |   | `-.\\           |\"`  /\n" +
                        "     .-;.|   |  _..;._       /-..-'\n" +
                        "    (( .-;.  | ((  _..`>    /\n" +
                        "     `((    _/  '-((  `  .__)\n" +
                        "jgs    `\"\"\"`       `\"--'`\n" +
                        "------------------------------------------------\n" +
                        "Thank you for visiting https://asciiart.website/\n" +
                        "This ASCII pic can be found at\n" +
                        "https://asciiart.website/art/6679");
                System.out.println("Dê um nome para o seu cachorrinho: ");
                var nomePet = inputUsuario.nextLine();
                var petCriado = PetFactory.criarPet(nomePet, escolhaPet);

                break;
        }
    }

    public void obterTodosPets(){
        ArrayList<Pet> petsLista = (ArrayList<Pet>) repositorioPet.buscarTodosPets();
        if(!petsLista.isEmpty()){
            System.out.println("Aqui estão os seus pets: ");
            for(int i = 0; i < petsLista.size(); i++){
                System.out.println(i + " - " + petsLista.get(i).getNome());
            }
        } else System.out.println("Sua lista de pets está vazia, adote um bichinho");

    }

}
