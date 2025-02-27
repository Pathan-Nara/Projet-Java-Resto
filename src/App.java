import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;




public class App {

    public static void chargerRestaurant(String fichier, ArrayList<Restaurant> list){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fichier));
            int id = Integer.parseInt(reader.readLine());
            String nom = reader.readLine();
            String adresse = reader.readLine();
            String nomMenu = reader.readLine();
            int dateCreation = Integer.parseInt(reader.readLine());
            String typeMenu = reader.readLine();
            Restaurant rest = new Restaurant(id, nom, adresse, nomMenu, dateCreation, typeMenu);
            list.add(rest);
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        int boucle = 1;
        String test = "";
        int idRest = 1;
        int idEmp = 1;
        int idMenu = 1;
        int indiceResto = 0;
        int boucleChoixPlat = 1;
        ArrayList<Restaurant> listRestaurants = new ArrayList<Restaurant>();

        System.out.println("Bienvenu dans notre application de gestion de restaurant \n");
        Scanner scan = new Scanner(System.in);
        Scanner next = new Scanner(System.in);
        while(boucle == 1){

            System.out.println("Que souhaitez vous faire? \n 1: Ajouter un restaurant \n 2: Afficher la liste des restaurants \n 3: Ajouter un employé a un restaurant \n 4: Ajouter un plat au menu d'un restaurant \n 5: Supprimer un employé d'un restaurant \n 6: Afficher les employés d'un restaurant \n 7: Prendre une commande pour un restaurant \n 8: Afficher toutes les commandes d'un restaurant \n 9: Sauvegarder les commandes d'un restaurant \n 10: Charger les commandes d'un restaurant \n 11: Quitter \n 12: Sauvegarder un restaurant \n 13: Charger un restaurant \n 14: Sauvegarder un menu \n 15: Charger un menu");
            
            
            int choix = scan.nextInt();


            switch(choix){
                case 1:
                    System.out.println("Vous avez choisi d'ajouter un restaurant \n quel est le nom du restaurant?");
                    String nom = next.nextLine();
                    System.out.println("Quelle est l'adresse du restaurant?");
                    String adresse = next.nextLine();
                    System.out.println("Comment se nomme le menu de votre restaurant ?");
                    String nomMenu = next.nextLine();
                    System.out.println("Quelle est la date de creation de votre menu ?");
                    int dateCreation = next.nextInt();
                    next.nextLine();
                    System.out.println("Quel est le type de menu de votre restaurant ?");
                    String typeMenu = next.nextLine();
                    Restaurant rest = new Restaurant(idRest, nom, adresse, nomMenu, dateCreation, typeMenu);
                    listRestaurants.add(rest);
                    idRest++;
                    System.out.println("Operation terminé appuyez sur un bouton pour continuer");
                    test = next.nextLine();
                break;

                    
                    
                
                case 2:
                    System.out.println("Vous avez choisi d'afficher la liste des restaurants :");
                    for (int i = 0; i < listRestaurants.size(); i++){
                        System.out.println("-----------------------------");
                        System.out.println("Restaurant numero " + (i+1) + " :");
                        listRestaurants.get(i).showRestaurant();
                        
                    }
                    System.out.println("-----------------------------");
                    System.out.println("Operation terminé appuyez sur un bouton pour continuer");
                    test = next.nextLine();
                break;

                    
                    

                case 3:
                    System.out.println("Vous avez choisi d'ajouter un employé a un restaurant \n Choisissez le restaurant dans lequel vous voulez ajouter un employé :");
                    for (int i = 0; i < listRestaurants.size(); i++){
                        System.out.println("-----------------------------");
                        System.out.println("Restaurant numero " + (i+1) + ": " + listRestaurants.get(i).getNom());
                    }
                    indiceResto = next.nextInt();
                    next.nextLine();
                    if(indiceResto > listRestaurants.size()){
                        System.out.println("Ce restaurant n'existe pas");
                        break;
                    }
                    System.out.println("Quel est le nom de l'employé ?");
                    String nomEmp = next.nextLine();
                    System.out.println("Quel est le prenom de l'employé ?");
                    String prenomEmp = next.nextLine();
                    System.out.println("Quel est le role de l'employé ?");
                    String roleEmp = next.nextLine();
                    System.out.println("Quel est le salaire de l'employé ?");
                    float salaireEmp = next.nextFloat();
                    next.nextLine();
                    System.out.println("Quelle est la date d'embauche de l'employé ?");
                    int dateEmbaucheEmp = next.nextInt();
                    next.nextLine();
                    Employe emp = new Employe(idEmp, nomEmp, prenomEmp, roleEmp, dateEmbaucheEmp, salaireEmp);
                    listRestaurants.get(indiceResto-1).ajouterEmploye(emp);
                    idEmp++;
                    System.out.println("Operation terminé appuyez sur un bouton pour continuer");
                    test = next.nextLine();
                break;

                    
                    
                case 4:
                    System.out.println("Choisissez le restaurant dans lequel vous voulez ajouter un plat :");
                    for (int i = 0; i < listRestaurants.size(); i++){
                        System.out.println("-----------------------------");
                        System.out.println("Restaurant numero " + (i+1) + ": " + listRestaurants.get(i).getNom());
                    }
                    indiceResto = next.nextInt();
                    next.nextLine();
                    if(indiceResto > listRestaurants.size()){
                        System.out.println("Ce restaurant n'existe pas");
                        break;
                    }
                    System.out.println("Quel est le nom du plat ?");
                    String nomPlat = next.nextLine();
                    System.out.println("Quelle est la description du plat ?");
                    String description = next.nextLine();
                    System.out.println("Quel est le prix du plat ?");
                    float prix = next.nextFloat();
                    next.nextLine();
                    System.out.println("Combien de calories contient le plat ?");
                    String calories = next.nextLine();
                    System.out.println("Quelle est la taille de la portion ?");
                    String taillePortion = next.nextLine();
                    System.out.println("Quelle est la date d'ajout du plat ?");
                    String dateAjout = next.nextLine();
                    System.out.println("Le plat est-il disponible ? (true/false)");
                    boolean disponible = next.nextBoolean();
                    next.nextLine();
                    System.out.println("Quels sont les ingrédients du plat ?");
                    String ingredients = next.nextLine();
                    System.out.println("Quel est le type de cuisine du plat ?");
                    String typeCuisine = next.nextLine();
                    System.out.println("Quel est le temps de préparation du plat ?");
                    String tempsPreparation = next.nextLine();
                    System.out.println("Y'a t'il un prix special au plat ? (True/False)");
                    Boolean isSpecial = next.nextBoolean();
                    next.nextLine();
                    Float prixSpecial = null;
                    if(isSpecial == true){
                        System.out.println("Quel est le prix spécial du plat ?");
                        prixSpecial = next.nextFloat();
                        next.nextLine();
                    }
                    System.out.println("Quelle est l'URL de l'image du plat ?");
                    String URL = next.nextLine();
                    Plat plat = new Plat(nomPlat, description, prix, calories, taillePortion, dateAjout, disponible, ingredients, typeCuisine, tempsPreparation, prixSpecial, URL);
                    listRestaurants.get(indiceResto-1).menu.ajouterPlat(plat);
                    System.out.println("Operation terminé appuyez sur un bouton pour continuer");
                    test = next.nextLine();
                break;



                case 5:
                    System.out.println("Choisissez le restaurant dans lequel souhaitez vous supprimer un employé voir les employés :");
                    for (int i = 0; i < listRestaurants.size(); i++){
                        System.out.println("-----------------------------");
                        System.out.println("Restaurant numero " + (i+1) + ": " + listRestaurants.get(i).getNom());
                    }
                    indiceResto = next.nextInt();
                    next.nextLine();
                    if(indiceResto > listRestaurants.size()){
                        System.out.println("Ce restaurant n'existe pas");
                        break;
                    } else if(listRestaurants.get(indiceResto-1).employes.isEmpty()){
                        System.out.println("Il n'y a pas d'employé dans ce restaurant");
                        break;
                    }
                    
                    System.out.println("Quel employé souhaitez vous supprimer ?");
                    for  (int i =0; i < listRestaurants.get(indiceResto-1).employes.size(); i++){
                        System.out.println("-----------------------------");
                        System.out.println("Employé numero " + (i+1) + ": " + listRestaurants.get(indiceResto-1).employes.get(i).getNom());
                    }
                    int indiceEmp = next.nextInt();
                    next.nextLine();
                    if (indiceEmp < 1 || indiceEmp > listRestaurants.get(indiceResto-1).employes.size()){
                        System.out.println("Cet employé n'existe pas");
                        break;
                    } else{
                        listRestaurants.get(indiceResto-1).supprimerEmploye(listRestaurants.get(indiceResto-1).employes.get(indiceEmp-1));
                    }

                    System.out.println("Operation terminé appuyez sur un bouton pour continuer");
                    test = next.nextLine();
                break;

                    
                    
                case 6:
                    System.out.println("Choisissez le restaurant dans lequel vous voulez voir les employés :");
                    for (int i = 0; i < listRestaurants.size(); i++){
                        System.out.println("-----------------------------");
                        System.out.println("Restaurant numero " + (i+1) + ": " + listRestaurants.get(i).getNom());
                    }
                    indiceResto = next.nextInt();
                    next.nextLine();
                    if(indiceResto > listRestaurants.size()){
                        System.out.println("Ce restaurant n'existe pas");
                        next.nextLine();
                        break;
                    }else if(listRestaurants.get(indiceResto-1).employes.isEmpty()){
                        System.out.println("Il n'y a pas d'employé dans ce restaurant");
                        next.nextLine();
                        break;
                    }
                    System.out.println("Que souhaitez vous faire ? \n 1: Afficher tout les employés \n 2: Rechercher un employé par role \n 3: Retour");
                    int choixEmp = next.nextInt();
                    next.nextLine();
                    
                    switch(choixEmp){
                        case 1:
                            listRestaurants.get(indiceResto-1).showEmploye();
                            break;
                        case 2:
                            System.out.println("Quel role recherchez vous ?");
                            String role = next.nextLine();
                            System.out.println(listRestaurants.get(indiceResto-1).searchEmployePerRole(role));
                            break;
                        case 3:
                            break;
                        default:
                            System.out.println("Veuillez choisir un nombre entre 1 et 3");
                            break;
                    }
                    
                    System.out.println("Operation terminé appuyez sur un bouton pour continuer");
                    test = next.nextLine();
                break;

                    
                    
                case 7:
                    System.out.println("Choisissez le restaurant dans lequel vous voulez prendre commande :");
                    for (int i = 0; i < listRestaurants.size(); i++){
                        System.out.println("-----------------------------");
                        System.out.println("Restaurant numero " + (i+1) + ": " + listRestaurants.get(i).getNom());
                    }
                    indiceResto = next.nextInt();
                    next.nextLine();
                    if(indiceResto > listRestaurants.size()){
                        System.out.println("Ce restaurant n'existe pas");
                        next.nextLine();
                        break;
                    } else if(listRestaurants.get(indiceResto-1).menu.plats.isEmpty()){
                        System.out.println("Nous sommes dans le regret de vous annoncer que le menu de ce restaurant est en cours de préparation.");
                        next.nextLine();
                        break;
                    }
                    Commande commande = new Commande();
                    while(boucleChoixPlat == 1){
                        for(int i =0; i < listRestaurants.get(indiceResto-1).menu.plats.size(); i++){
                            System.out.println("-----------------------------");
                            System.out.println("Plat numero " + (i+1) + ": " + listRestaurants.get(indiceResto-1).menu.plats.get(i).toString());
                        }
                        System.out.println("Quel plat souhaitez vous commander ? (Entrez le numero du plat)");
                        int indicePlat = next.nextInt();
                        next.nextLine();
                        if (indicePlat < 1 || indicePlat > listRestaurants.get(indiceResto-1).menu.plats.size()){
                            System.out.println("Ce plat n'existe pas");
                            next.nextLine();
                            break;
                        } else{
                            System.out.println(listRestaurants.get(indiceResto-1).menu.plats.get(indicePlat-1));
                            commande.ajouterPlat(listRestaurants.get(indiceResto-1).menu.plats.get(indicePlat-1));
                        }
                        System.out.println("Voulez vous commander un autre plat ? (1/0)");
                        boucleChoixPlat = next.nextInt();
                        next.nextLine();
                    }
                    boucleChoixPlat = 1;
                    listRestaurants.get(indiceResto-1).commandes.add(commande);
                    System.out.println("Voici votre commande : \n" + commande.afficherCommande());
                    
                    test = next.nextLine();
                break;

                    
                    
                case 8:
                    System.out.println("Vous avez choisi d'afficher toutes les commandes d'un restaurant \n Choisissez le restaurant dont vous voulez voir les commandes :");
                    for (int i = 0; i < listRestaurants.size(); i++){
                        System.out.println("-----------------------------");
                        System.out.println("Restaurant numero " + (i+1) + ": " + listRestaurants.get(i).getNom());
                    }
                    indiceResto = next.nextInt();
                    next.nextLine();
                    if(indiceResto > listRestaurants.size()){
                        System.out.println("Ce restaurant n'existe pas");
                        next.nextLine();
                        break;
                    } else if(listRestaurants.get(indiceResto-1).menu.plats.isEmpty()){
                        System.out.println("Nous sommes dans le regret de vous annoncer que le menu de ce restaurant est en cours de préparation.");
                        next.nextLine();
                        break;
                    }
                    for(int i = 0; i < listRestaurants.get(indiceResto-1).commandes.size(); i++){
                        System.out.println("-----------------------------");
                        System.out.println("Commande numero " + (i+1) + ": \n" + listRestaurants.get(indiceResto-1).commandes.get(i).afficherCommande());
                    }
                    System.out.println("Operation terminé appuyez sur un bouton pour continuer");
                    test = next.nextLine();
                break;

                    
                case 9:
                    System.out.println("Vous avez choisi de sauvegarder les commandes d'un restaurant \n choississez le restaurant dont vous voulez sauvegarder les commandes :");
                    for (int i = 0; i < listRestaurants.size(); i++){
                        System.out.println("-----------------------------");
                        System.out.println("Restaurant numero " + (i+1) + ": " + listRestaurants.get(i).getNom());
                    }
                    indiceResto = next.nextInt();
                    next.nextLine();
                    if(indiceResto > listRestaurants.size()){
                        System.out.println("Ce restaurant n'existe pas");
                        next.nextLine();
                        break;
                    } else if(listRestaurants.get(indiceResto-1).menu.plats.isEmpty()){
                        System.out.println("Nous sommes dans le regret de vous annoncer que le menu de ce restaurant est en cours de préparation.");
                        next.nextLine();
                        break;
                    }
                    System.out.println("Sauvegarde en cours...");
                    listRestaurants.get(indiceResto-1).sauvegarderCommandes("commandes du restaurant " + listRestaurants.get(indiceResto-1).getNom());
                    System.out.println("Operation terminé appuyez sur un bouton pour continuer");
                    test = next.nextLine();
                break;

                    
                    
                case 10:
                    System.out.println("Vous avez choisi de charger les commandes d'un restaurant \n choississez le restaurant dont vous voulez charger les commandes :");
                    for (int i = 0; i < listRestaurants.size(); i++){
                        System.out.println("-----------------------------");
                        System.out.println("Restaurant numero " + (i+1) + ": " + listRestaurants.get(i).getNom());
                    }
                    indiceResto = next.nextInt();
                    next.nextLine();
                    if(indiceResto > listRestaurants.size()){
                        System.out.println("Ce restaurant n'existe pas");
                        next.nextLine();
                        break;
                    } 
                    String fileName = "commandes du restaurant " + listRestaurants.get(indiceResto-1).getNom() + ".txt";
                    File file = new File(fileName);
                    if(file.exists()){
                        System.out.println("Chargement en cours...");
                        listRestaurants.get(indiceResto-1).chargerCommande(fileName);
                        System.out.println("Operation terminé appuyez sur un bouton pour continuer");
                    } else {
                        System.out.println("Le fichier " + fileName + " n'existe pas.");
                        System.out.println("Operation terminé appuyez sur un bouton pour continuer");
                    }
                    test = next.nextLine();

                break;

                case 11:
                    boucle = 0;
                break;
                    
                case 12:
                    System.out.println("Vous avez choisi de sauvegarder un restaurant \n choississez le restaurant que vous voulez sauvegarder :");
                    for (int i = 0; i < listRestaurants.size(); i++){
                        System.out.println("-----------------------------");
                        System.out.println("Restaurant numero " + (i+1) + ": " + listRestaurants.get(i).getNom());
                    }
                    indiceResto = next.nextInt();
                    next.nextLine();
                    if(indiceResto > listRestaurants.size()){
                        System.out.println("Ce restaurant n'existe pas");
                        next.nextLine();
                        break;
                    }
                    System.out.println("Sauvegarde en cours...");
                    listRestaurants.get(indiceResto-1).sauvegarderRestaurant("restaurant " + listRestaurants.get(indiceResto-1).getNom());
                    System.out.println("Operation terminé appuyez sur un bouton pour continuer");
                    test = next.nextLine();
                break;

                case 13:
                    System.out.println("Vous avez choisi de charger un restaurant \n Quel est le nom du restaurant que vous voulez charger ? :");
                    String nomRest = next.nextLine();
                    String fichierAcharger = "sauvegardes/" + "restaurant " + nomRest + ".txt";
                    System.out.println(fichierAcharger);
                    chargerRestaurant(fichierAcharger, listRestaurants);
                    System.out.println("Operation terminé appuyez sur un bouton pour continuer");
                    test = next.nextLine();
                    System.out.println(listRestaurants.get(0).getNom());
                break;

                case 14:
                    System.out.println("Vous avez choisi de sauvegarder un menu \n choississez le restaurant dont vous voulez sauvegarder le menu :");
                    for (int i = 0; i < listRestaurants.size(); i++){
                        System.out.println("-----------------------------");
                        System.out.println("Restaurant numero " + (i+1) + ": " + listRestaurants.get(i).getNom());
                    }
                    indiceResto = next.nextInt();
                    next.nextLine();
                    if(indiceResto > listRestaurants.size()){
                        System.out.println("Ce restaurant n'existe pas");
                        next.nextLine();
                        break;
                    }
                    System.out.println("Sauvegarde en cours...");
                    listRestaurants.get(indiceResto-1).menu.sauvegarderMenu(listRestaurants.get(indiceResto-1).getNom());
                    System.out.println("Operation terminé appuyez sur un bouton pour continuer");
                    test = next.nextLine();
                break;

                case 15:
                    System.out.println("Vous avez choisi de charger un menu \n choississez le restaurant dont vous voulez charger le menu :");
                    for (int i = 0; i < listRestaurants.size(); i++){
                        System.out.println("-----------------------------");
                        System.out.println("Restaurant numero " + (i+1) + ": " + listRestaurants.get(i).getNom());
                    }
                    indiceResto = next.nextInt();
                    next.nextLine();
                    if(indiceResto > listRestaurants.size()){
                        System.out.println("Ce restaurant n'existe pas");
                        next.nextLine();
                        break;
                    }
                    String fichierAchargerMenu = "sauvegardes/" + "menu du restaurant " + listRestaurants.get(indiceResto-1).getNom() + ".txt";
                    System.out.println(fichierAchargerMenu);
                    listRestaurants.get(indiceResto-1).chargerMenu(fichierAchargerMenu);
                    System.out.println("Operation terminé appuyez sur un bouton pour continuer");

                default:
                    System.out.println("Veuillez choisir un nombre entre 1 et 10");
                    System.out.println("Operation terminé appuyez sur un bouton pour continuer");
                    test = next.nextLine();
                break;

            }
        }

    }
}
