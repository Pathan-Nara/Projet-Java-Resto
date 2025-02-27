import java.util.ArrayList;
import java.io.*;

public class Restaurant{
    public int id;
    public String nomRestaurant;
    public String adresse;
    public Menu menu;
    public ArrayList<Commande> commandes = new ArrayList<Commande>();
    public ArrayList<Employe> employes = new ArrayList<Employe>();

    public static void chargerMenu(String fichier){
        try {
            
            BufferedReader reader = new BufferedReader(new FileReader(fichier));
            int id = Integer.parseInt(reader.readLine());
            String nomMenu = reader.readLine();
            int dateCreation = Integer.parseInt(reader.readLine());
            String typeMenu = reader.readLine();
            Menu menu = new Menu(id, nomMenu, dateCreation, typeMenu);
            
            reader.close();

        } catch (Exception e) {
        }
    }

    public Restaurant(int id, String nomRestaurant, String adresse, String nomMenu, int dateCreation, String typeMenu){
        this.id = id;
        this.nomRestaurant = nomRestaurant;
        this.adresse = adresse;
        this.menu = new Menu(1, nomMenu, dateCreation, typeMenu);
    }

    public String getNom(){
        return this.nomRestaurant;
    }


    public void ajouterCommande(Commande commande){
        this.commandes.add(commande);
    }

    public String showCommande(){
        String result = "";
        for (int i = 0; i < this.commandes.size(); i++){
            int z = i+1;
            result += "commande numero " + z + ": " + this.commandes.get(i).afficherCommande() + "\n";
        }
        return result;
    }

    public void ajouterEmploye(Employe employe){
        this.employes.add(employe);
    }

    public void supprimerEmploye(Employe employe){
        this.employes.remove(employe);
    }

    public String searchEmployePerRole(String role){
        String result = "";
        for (int i = 0; i < this.employes.size(); i++){
            if (this.employes.get(i).role.equals(role)){
                result += this.employes.get(i).toString() + "\n";
            }
        }
        if (result.equals("")){
            return "Aucun employe ne possede le role " + role;
        }
        return result;
    }

    public void showEmploye(){
        for(int i = 0; i<this.employes.size(); i++){
            System.out.println(this.employes.get(i).toString() + "\n");
        }
    }

    public int totalSalaireEmploye(){
        int total = 0;
        for (int i = 0; i < this.employes.size(); i++){
            total += this.employes.get(i).salaire;
        }
        return total;
    }

    public float totalChiffreAffaire(){
        float total = 0;
        for (int i = 0; i < this.commandes.size(); i++){
            total += this.commandes.get(i).calculerTotal();
        }
        return total;
    }

    public void showRestaurant(){
        System.out.println("Nom du restaurant: " + this.nomRestaurant + "\n");
        System.out.println("Adresse du restaurant: " + this.adresse + "\n");
        System.out.println("Menu du restaurant: [" + this.menu.toString() + "] \n");
        System.out.println("il y'a " + this.employes.size() + " employes dans ce restaurant" + "\n");
        System.out.println("Les depenses en salaire de ce restaurant sont de: " + this.totalSalaireEmploye() + "\n");
        System.out.println("Le chiffre d'affaire de ce restaurant est de: " + this.totalChiffreAffaire() + "\n");
    }

    public void sauvegarderCommandes(String nomFichier){

        try {
            
            BufferedWriter fichier = new BufferedWriter(new FileWriter(nomFichier + ".txt"));

            for (int i = 0; i < this.commandes.size(); i++){
                fichier.write(this.commandes.get(i).plats.get(i).exportPlat());
                System.out.println("--------------------");
            }
            fichier.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    public void chargerCommande(String fichier){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fichier));
            String line = reader.readLine();
            while (line != null){
                System.out.println(line);
                System.out.println("--------------------");
                Commande com = new Commande();
//                com.ajouterPlat(line);
                line = reader.readLine();

            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sauvegarderRestaurant(String nomFichier){
        try {
            BufferedWriter fichier = new BufferedWriter(new FileWriter(nomFichier + ".txt"));
            fichier.write(this.id + "\n" + this.nomRestaurant + "\n" + this.adresse + "\n" + this.menu.nomMenu + "\n" + this.menu.dateCreation + "\n" + this.menu.typeMenu + "\n");
            fichier.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }

    
}
