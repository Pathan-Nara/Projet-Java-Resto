public class Employe{
    int id;
    String nom;
    String prenom;
    String role;
    int DateEmbauche;
    Float salaire;

    public Employe(int id, String nom, String prenom, String role, int DateEmbauche, Float salaire){
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.role = role;
        this.DateEmbauche = DateEmbauche;
        this.salaire = salaire;
    }

    public float getSalaire(){
        return this.salaire;
    }
    public void setSalaire(float salaire){
        this.salaire = salaire;
    }
    public String getNom(){
        return this.nom;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
    public String getPrenom(){
        return this.prenom;
    }
    public void setPrenom(String prenom){
        this.prenom = prenom;
    }
    public String getRole(){
        return this.role;
    }
    public void setRole(String role){
        this.role = role;
    }
    public int getDateEmbauche(){
        return this.DateEmbauche;
    }
    public void setDateEmbauche(int DateEmbauche){
        this.DateEmbauche = DateEmbauche;
    }
    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employe [DateEmbauche=" + DateEmbauche + ", id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", role="
                + role + ", salaire=" + salaire + "]";
    }

}