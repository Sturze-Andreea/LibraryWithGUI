package sample.UI;

import javafx.scene.control.Control;
import sample.Controller.Controller;
import sample.Domain.Carte;
import sample.Domain.CarteImprumutata;
import sample.Domain.Imprumutator;
import sample.Repo.RepoCarti;
import sample.Repo.RepoImprumutatori;

import java.io.*;
import java.util.ArrayList;

public class MakeController {
    Controller c;

    {RepoCarti r1 = new RepoCarti();
        RepoImprumutatori r2=new RepoImprumutatori();
        c = new Controller(r1, r2);
    }



    public Controller getCtrl(){
    RepoCarti r1 = new RepoCarti();
    readFromFileCarti(r1);
    RepoImprumutatori r2=new RepoImprumutatori();
    Controller ctrl = new Controller(r1,r2);
    readFromFileImprumutatori(r2,ctrl);
    c= ctrl;
    return ctrl;}

    public void saveInFilePers(Controller ctrl) throws FileNotFoundException {
        File file = new File("C:\\Users\\Andreea\\Desktop\\MAP\\Lab4-GUI\\src\\sample\\Imprumutatori.txt");
        PrintWriter printWriter = new PrintWriter(file);
        StringBuilder stringBuilder = new StringBuilder();

        for(Imprumutator m : ctrl.getListaImprumutator()){
            stringBuilder.append(m.getNume()).append(',');
            stringBuilder.append(m.getCartiImp()).append('\n');

            String string = stringBuilder.toString();
            printWriter.write(string);

            stringBuilder.setLength(0);
        }

        printWriter.close();
    }

    public void saveInFileCarti(Controller ctrl) throws FileNotFoundException {
        File file = new File("C:\\Users\\Andreea\\Desktop\\MAP\\Lab4-GUI\\src\\sample\\Carti.txt");
        PrintWriter printWriter = new PrintWriter(file);
        StringBuilder stringBuilder = new StringBuilder();

        for(CarteImprumutata m : ctrl.getListaCarte()){
            stringBuilder.append(m.getTitlu()).append(',');
            stringBuilder.append(m.getAutor()).append(',');
            stringBuilder.append(m.getAn_aparitie()).append(',');
            stringBuilder.append(m.getPret()).append(',');
            stringBuilder.append(m.getEditura()).append(',');
            stringBuilder.append(m.getCota()).append(',');
            stringBuilder.append(m.isImprumutata()).append('\n');

            String string = stringBuilder.toString();
            printWriter.write(string);

            stringBuilder.setLength(0);
        }

        printWriter.close();

    }

    //functia care citeste carti din fisier
    private static void readFromFileCarti(RepoCarti repo){

        try { BufferedReader fileIn =
                new BufferedReader(new FileReader("C:\\Users\\Andreea\\Desktop\\MAP\\Lab4-GUI\\src\\sample\\Carti.txt"));
            String s;
            while((s = fileIn.readLine())!= null){
                String[] columns=s.split(",");

                String titlu=columns[0];
                String autor = columns[1];
                int an=Integer.parseInt(columns[2]);
                float pret = Float.parseFloat(columns[3]);
                String editura = columns[4];
                String cota = columns[5];
                boolean imp = Boolean.parseBoolean(columns[6]);
                CarteImprumutata c = new CarteImprumutata(titlu,autor,an,pret,editura,cota,imp);
                repo.add(c);
            }
            fileIn.close();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //functia care citeste imprumutatori din fisier
    private static void readFromFileImprumutatori(RepoImprumutatori repo,Controller ctrl){

        try { BufferedReader fileIn =
                new BufferedReader(new FileReader("C:\\Users\\Andreea\\Desktop\\MAP\\Lab4-GUI\\src\\sample\\Imprumutatori.txt"));
            String s;
            while((s = fileIn.readLine())!= null){
                String[] columns=s.split(",");

                String nume=columns[0];
                ArrayList<Carte> arr = new ArrayList<>();
                if(!columns[1].equals(" "))
                {String[] carti_imp = columns[1].split("\\.");
                    for (String value : carti_imp) arr.add(ctrl.findCarte(value));
                }
                Imprumutator i = new Imprumutator(nume,arr);
                repo.add(i);
            }
            fileIn.close();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
