package sample.Controller;

import sample.Domain.Carte;
import sample.Domain.CarteImprumutata;
import sample.Domain.Imprumutator;
import sample.Repo.RepoCarti;
import sample.Repo.RepoImprumutatori;

import java.util.ArrayList;

public class Controller {
    //service
    private RepoCarti carti;
    private RepoImprumutatori imprumutatori;

    //constructorul
    public Controller(RepoCarti r1, RepoImprumutatori r2){
        carti = r1;
        imprumutatori= r2;
    }

    //adaugare de carti in repo de carti
    public void addCarte(CarteImprumutata c){
        carti.add(c);
    }

    //update de carti in repo de carti
    public void updateCarte(String titlu, CarteImprumutata newC){
        carti.update(carti.find(titlu),newC);
    }

    //stergere de carti in repo de carti
    public void deleteCarte(CarteImprumutata c){
        carti.delete(c);
    }

    //gasire de carti in repo de carti
    public CarteImprumutata findCarte(String titlu){
        return carti.find(titlu);
    }

    //lista de carti din repo
    public ArrayList<CarteImprumutata> getListaCarte() {
        return carti.getLista();
    }

    //adaugare de imprumutatori in repo de imprumutatori
    public void addImprumutator(Imprumutator i){
        imprumutatori.add(i);
    }

    //update de imprumutatori in repo de imprumutatori
    public void updateImprumutator(String nume, Imprumutator newI){
        imprumutatori.update(imprumutatori.find(nume),newI);
    }

    //stergere de imprumutatori in repo de imprumutatori
    public void deleteImprumutator(Imprumutator i){
        imprumutatori.delete(i);
    }

    //gasire de imprumutatori in repo de imprumutatori
    public Imprumutator findImprumutator(String nume){
        return imprumutatori.find(nume);
    }

    //lista de imprumutatori din repo
    public ArrayList<Imprumutator> getListaImprumutator() {

        return imprumutatori.getLista();
    }

    //functia prin care se efectueaza un imprumut
    public int imprumut(String titlu, String nume){
        CarteImprumutata c = this.findCarte(titlu);
        Imprumutator i = this.findImprumutator(nume);
        if(c.isImprumutata())
            return 1;
        c.setImprumutata(true);
        ArrayList<Carte> carti_imprumutate =i.getCarti_imprumutate();
        carti_imprumutate.add(c);
        i.setCarti_imprumutate(carti_imprumutate);
        return 0;
    }

    
}
