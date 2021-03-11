package sample.Repo;


import sample.Domain.Imprumutator;

import java.util.ArrayList;

public class RepoImprumutatori{
    private ArrayList<Imprumutator> lista;

    //constructorul
    public RepoImprumutatori() {
        lista = new ArrayList<>();
    }

    //adaugare de imprumutatori
    public void add(Imprumutator i) {
        lista.add(i);
    }

    //update de imprumutatori
    public void update(Imprumutator i, Imprumutator newI) {
        lista.set(lista.indexOf(i), newI);
    }

    //stergere de imprumutatori
    public void delete(Imprumutator i) {
        lista.remove(i);
    }

    //cautare de imprumutatori
    public Imprumutator find(String nume) {
        for (Imprumutator i : lista) {
            if (i.getNume().equals(nume))
                return i;
        }
        return new Imprumutator();
    }

    //lista de imprumutatori
    public ArrayList<Imprumutator> getLista() {
        return lista;
    }
}
