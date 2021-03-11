package sample.Repo;

import sample.Domain.CarteImprumutata;

import java.util.ArrayList;

public class RepoCarti {
    private ArrayList<CarteImprumutata> lista;

    //constructorul
    public RepoCarti(){
        lista  = new ArrayList<>();
    }

    //adaugare ce carti
    public void add(CarteImprumutata c){
        lista.add(c);
    }

    //update de carti
    public void update(CarteImprumutata c, CarteImprumutata newC){
        lista.set(lista.indexOf(c),newC);
    }

    //stergere de carti
    public void delete(CarteImprumutata c){
        lista.remove(c);
    }

    //cautare de carti
    public CarteImprumutata find(String titlu){
        for (CarteImprumutata c:lista) {
            if(c.getTitlu().equals(titlu))
                return c;
        }
        return new CarteImprumutata();
    }

    //lista de carti
    public ArrayList<CarteImprumutata> getLista() {
        return lista;
    }
}
