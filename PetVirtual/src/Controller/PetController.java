package Controller;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Scanner;

import Models.Pet;
import Repository.PetRepository;

public class PetController {
    public Scanner inputUsuario;
    public PetRepository _repositorioPet;

    public void executarMenu(Pet pet){
        System.out.println("Selecione o que deseja fazer com " + pet.getNome() + " ?");
        System.out.println("1. Alimentar");
        System.out.println("2. Brincar");
        System.out.println("3. Dormir Juntos");
        System.out.println("4. Verificar Status");
        var escolherAcao = inputUsuario;

        switch(escolherAcao){
            case "1":
                _servicePet.alimentarPet();
                break;
        }
    }


    public void obterTodosPets(){
        ArrayList<Pet> petsLista = (ArrayList<Pet>) _repositorioPet.buscarTodosPets();
        if(!petsLista.isEmpty()){
            System.out.println("Aqui estão os seus pets: ");
            for(int i = 0; i < petsLista.size(); i++){
                System.out.println(i + " - " + petsLista.get(i).getNome());
            }
        } else System.out.println("Sua lista de pets está vazia, adote um bichinho");

    }

}
