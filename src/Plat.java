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
    float prixSpecial;
    String URL;

    public Plat(String nom, String description, float prix, String calories, String taillePortion, String dateAjout, boolean disponible, String ingredients, String typeCuisne, String tempsPreparation, float prixSpecial, String URL) {
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

    @Override
    public String toString() {
        return "[ Nom = " + this.nom + ", Description = " + this.description + ", Prix = " + this.prix + ", Calories = " + this.calories + ", Taille de la portion = " + this.taillePortion + ", Date d'ajout = " + this.dateAjout + ", Disponible = " + this.disponible + ", Ingrédients = " + this.ingredients + ", Type de cuisine = " + this.typeCuisne + ", Temps de préparation = " + this.tempsPreparation + ", Prix spécial = " + this.prixSpecial + ", URL = " + this.URL + "]";
    }

    
}
