package controllers;

import models.User;
import services.UserServiceImpl;

import java.util.List;
import java.util.Scanner;

public class UserController {
    private UserServiceImpl userService;
    private Scanner scanner;

    public UserController(){
        userService = new UserServiceImpl();
        scanner = new Scanner(System.in);
    }

    public void console(){
        System.out.println("********* BIENVENU DANS LA CONSOLE *********");
        System.out.println();
        while(true) {
            System.out.println("1-Ajouter un User");
            System.out.println("2-Rechercher un User");
            System.out.println("3-Afficher les Users");
            System.out.println("4-Mèttre à jour un User");
            System.out.println("5-Supprimer un User");
            System.out.println("6-Quitter le programme");
            System.out.println();
            System.out.println("Entrer votre choix : ");
            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix){
                case 1:
                    addUser();
                break;

                case 2:
                    getUser();
                break;

                case 3:
                    getAllUsers();
                break;

                case 4:
                    updateUser();
                break;
                case 5:
                    deleteUser();
                break;

                case 6:
                    System.exit(0);
                break;

                default:
                    System.out.println("Error choice not available please try again");
                break;
            }
        }
    }
    public void addUser(){
        System.out.println();
        System.out.println("********* Ajout d'un User *********");
        System.out.println();
        System.out.println("Entrer l'id du User ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Entrer le nom du User ");
        String firstName = scanner.nextLine();
        System.out.println("Entrer le prenom du User");
        String lastName = scanner.nextLine();
        System.out.println("Entrer l'email du User");
        String email = scanner.nextLine();
        System.out.println("Entrer le numero de telephone du User");
        String phoneNumber = scanner.nextLine();
        System.out.println();
        userService.createUser(new User(id,firstName,lastName,email,phoneNumber));
        System.out.println("user enregistrer avec succes");
    }

    public void getUser(){
        System.out.println();
        System.out.println("********* Recherche d'un User *********");
        System.out.println();
        System.out.println("Entrer l'id de l'utilisateur");
        Long id = scanner.nextLong();
        scanner.nextLine();
        User user = userService.getUser(id);
        if(user!=null){
            System.out.println();
            System.out.println("UserId : "+user.getId());
            System.out.println("FirstName : "+user.getFirstName());
            System.out.println("LastName : "+user.getLastName());
            System.out.println("Email : "+user.getEmail());
            System.out.println("Phone : "+user.getPhoneNumber());
        }else{
            System.out.println("user introuvable :(");
        }
        System.out.println("-------------------------------------------------");
    }

    public void getAllUsers(){
        System.out.println();
        System.out.println("********* Listes des Users *********");
        System.out.println();
        List<User> users = userService.getAllUser();
        for (User user : users){
            System.out.println("UserId : "+user.getId());
            System.out.println("FirstName : "+user.getFirstName());
            System.out.println("LastName : "+user.getLastName());
            System.out.println("Email : "+user.getEmail());
            System.out.println("Phone : "+user.getPhoneNumber());
            System.out.println("-------------------------------------------------");

        }
    }

    public void updateUser(){
        System.out.println();
        System.out.println("********* Mise à jour d'un User *********");
        System.out.println();
        System.out.println("Entrer l'id du User");
        Long id = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Entrer le nom du User");
        String firstName = scanner.nextLine();
        System.out.println("Entrer le prenom du User");
        String lastName = scanner.nextLine();
        System.out.println("Entrer l'email du User");
        String email = scanner.nextLine();
        System.out.println("Entrer le numero de telephone du User");
        String phoneNumber = scanner.nextLine();

        userService.updateUser(id,new User(id,firstName,lastName,email,phoneNumber));
        System.out.println("user mis à jour avec succes");
    }

    public void deleteUser(){
        System.out.println();
        System.out.println("********* Suppression d'un User *********");
        System.out.println();
        System.out.println("Entrer l'id de l'utilisateur");
        Long id = scanner.nextLong();
        scanner.nextLine();
        userService.deleteUser(id);
        System.out.println("User supprimé avec succès !!!!");
        System.out.println();
    }
}
