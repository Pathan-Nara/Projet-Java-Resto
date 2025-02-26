import java.lang.reflect.Array;
import java.util.ArrayList;
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

    @Override
    public String toString() {
        String pla = "";
        for(int i =0; i<this.plats.size(); i++){
            pla += this.plats.get(i).nom + " " + this.plats.get(i).prix + "\n";
        }
        return "dateCreation=" + dateCreation + ", id=" + id + ", nomMenu=" + nomMenu + ", plats=" + pla + ", typeMenu=" + typeMenu;
    }

}