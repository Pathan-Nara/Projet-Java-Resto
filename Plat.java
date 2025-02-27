import java.io.*;
public class Plat {
    String nom;
    String description;
    float prix;
    String calories;
    String taillePortion;
    String dateAjout;
    boolean disponible;
    String ingredients;
    String typeCuisne;
    String  tempsPreparation;
    Float prixSpecial;
    String URL;

    public Plat(String nom, String description, float prix, String calories, String taillePortion, String dateAjout, boolean disponible, String ingredients, String typeCuisne, String tempsPreparation, Float prixSpecial, String URL) {
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.calories = calories;
        this.taillePortion = taillePortion;
        this.dateAjout = dateAjout;
        this.disponible = disponible;
        this.ingredients = ingredients;
        this.typeCuisne = typeCuisne;
        this.tempsPreparation = tempsPreparation;
        this.prixSpecial = prixSpecial;
        this.URL = URL;
    }

    public String getNom() {
        return this.nom;
    }

    public String toString() {
        return "[ Nom = " + this.nom + ", Description = " + this.description + ", Prix = " + this.prix + ", Calories = " + this.calories + ", Taille de la portion = " + this.taillePortion + ", Date d'ajout = " + this.dateAjout + ", Disponible = " + this.disponible + ", Ingrédients = " + this.ingredients + ", Type de cuisine = " + this.typeCuisne + ", Temps de préparation = " + this.tempsPreparation + ", Prix spécial = " + this.prixSpecial + ", URL = " + this.URL + "]";
    }

    public String exportPlat(){
        return this.nom + "\n" + this.description + "\n" + this.prix + "\n" + this.calories + "\n" + this.taillePortion + "\n" + this.dateAjout + "\n" + this.disponible + "\n" + this.ingredients + "\n" + this.typeCuisne + "\n" + this.tempsPreparation + "\n" + this.prixSpecial + "\n" + this.URL;
    }

    public void chargerPlat(String fichier){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fichier));
            String nom = reader.readLine();
            String description = reader.readLine();
            float prix = Float.parseFloat(reader.readLine());
            String calories = reader.readLine();
            String taillePortion = reader.readLine();
            String dateAjout = reader.readLine();
            boolean disponible = Boolean.parseBoolean(reader.readLine());
            String ingredients = reader.readLine();
            String typeCuisne = reader.readLine();
            String tempsPreparation = reader.readLine();
            Float prixSpecial = Float.parseFloat(reader.readLine());
            String URL = reader.readLine();
            Plat plat = new Plat(nom, description, prix, calories, taillePortion, dateAjout, disponible, ingredients, typeCuisne, tempsPreparation, prixSpecial, URL);
        } catch (Exception e) { 
            e.printStackTrace();
        }
    }
    
}
