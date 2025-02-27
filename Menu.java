import java.lang.reflect.Array;
import java.util.ArrayList;
import java.io.*;

public class Menu{
    public int id;
    public String nomMenu;
    public int dateCreation;
    public String typeMenu;
    public ArrayList<Plat> plats = new ArrayList<Plat>();

    public Menu(int id, String nomMenu, int dateCreation, String typeMenu) {
        this.id = id;
        this.nomMenu = nomMenu;
        this.dateCreation = dateCreation;
        this.typeMenu = typeMenu;
        this.plats = new ArrayList<Plat>();
    }

    public void ajouterPlat(Plat plat){
        this.plats.add(plat);
    }

    public void supprimerPlat(Plat plat){
        if(this.plats.contains(plat)){
            this.plats.remove(plat);
        }
    }

    public void showMenu(){
        for(int i =0; i<this.plats.size(); i++){
            System.out.println(this.plats.get(i) + "\n");
        }
    }

    public String search(String nomPlat){

        for(int i =0; i<this.plats.size(); i++){
            if(this.plats.get(i).nom == nomPlat){
                return "Le plat " + nomPlat + " est disponible";
            }
        }
        
        return "Le plat " + nomPlat + " n'est pas disponible";
    }

    public String toString() {
        String pla = "";
        for(int i =0; i<this.plats.size(); i++){
            pla += this.plats.get(i).nom + " " + this.plats.get(i).prix + "\n";
        }
        return "dateCreation=" + dateCreation + ", id=" + id + ", nomMenu=" + nomMenu + ", plats=" + pla + ", typeMenu=" + typeMenu;
    }

    public void sauvegarderMenu(String nomResto){
        try {

            BufferedWriter fichier = new BufferedWriter(new FileWriter("menu du restaurant " + nomResto + ".txt"));
            
            fichier.write(this.id + "\n" + this.nomMenu + "\n" + this.dateCreation + "\n" + this.typeMenu + "\n");
            for (int i = 0; i < this.plats.size(); i++){
                fichier.write(this.plats.get(i).exportPlat());
            }
            fichier.close();

        } catch (Exception e) {
            
            e.printStackTrace();
        }

    }

    public String exportMenu(){
        String pla = "";
        for(int i =0; i<this.plats.size(); i++){
            pla += this.plats.get(i).exportPlat() + "\n";
        }
        return this.id + "\n" + this.nomMenu + "\n" + this.dateCreation + "\n" + this.typeMenu + "\n" + pla;
    }

}