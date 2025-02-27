import java.util.ArrayList;

public class Commande {

    int numeroCommande;
    ArrayList<Plat> plats = new ArrayList<Plat>();
    static float total = 0;
    
    public void  ajouterPlat(Plat plat){
        this.plats.add(plat);
    }

    public float calculerTotal(){
        int total = 0;
        for(int i = 0; i<this.plats.size(); i++){
            total += this.plats.get(i).prix;
        }
        this.total = total;
        return this.total;
    } 

    public String afficherCommande(){
        String commande = "";
        for(int i = 0; i<this.plats.size(); i++){
            commande += this.plats.get(i).nom + " " + this.plats.get(i).prix + "\n";
        }
        this.calculerTotal();
        commande += "Total: " + this.total;
        return commande;
    }
}
