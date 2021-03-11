package sample.Domain;

import java.util.ArrayList;

public class Imprumutator{
    private ArrayList<Carte> carti_imprumutate;
    private String nume;
    private String cartiImp;

    //constructor implicit
    public Imprumutator(){
        nume = "";
        carti_imprumutate=new ArrayList<>();
    }

    //constructor cu parametrii
    public Imprumutator(String n, ArrayList<Carte> carti){
        nume=n;
        carti_imprumutate=carti;
        cartiImp = "";
        if(carti_imprumutate.size()==0)
            cartiImp=" ";
        else{
        for (int j = 0; j < carti_imprumutate.size(); j++)
        if (j == carti_imprumutate.size() - 1)
            cartiImp = cartiImp+carti_imprumutate.get(j).getTitlu();
        else
            cartiImp = cartiImp+carti_imprumutate.get(j).getTitlu()+".";}
    }


    public ArrayList<Carte> getCarti_imprumutate() {
        return carti_imprumutate;
    }

    public void setCarti_imprumutate(ArrayList<Carte> carti_imprumutate) {
        this.carti_imprumutate = carti_imprumutate;
        cartiImp="";
        if(carti_imprumutate.size()==0)
            cartiImp=" ";
        else{
            for (int j = 0; j < carti_imprumutate.size(); j++)
                if (j == carti_imprumutate.size() - 1)
                    cartiImp = cartiImp+carti_imprumutate.get(j).getTitlu();
                else
                    cartiImp = cartiImp+carti_imprumutate.get(j).getTitlu()+".";}
    }
    public String getNume() {
        return nume;
    }
    public String getCartiImp() {
        return cartiImp;
    }
    public void setNume(String nume) {
        this.nume = nume;
    }
}
