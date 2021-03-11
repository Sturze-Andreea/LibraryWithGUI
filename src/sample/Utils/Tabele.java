package sample.Utils;

import sample.Domain.Autor;
import sample.Domain.Carte;
import sample.Domain.CarteImprumutata;
import sample.Domain.Imprumutator;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Tabele {
    //afisare tabele

    //tabelul pentru persoane
    public void printPersoane(ArrayList<Imprumutator> list) {
        if (list.size() > 0) {
            System.out.println("======================================================================================"); //capul de tabel
            System.out.println("|     Nume     |                          Carti imprumutate                          |");
            System.out.println("======================================================================================");
            int i;
            for (i = 0; i < list.size(); i++) {
                StringBuilder str = new StringBuilder();
                for (int j = 0; j < list.get(i).getCarti_imprumutate().size(); j++)
                    if (j == list.get(i).getCarti_imprumutate().size() - 1)
                        str.append(list.get(i).getCarti_imprumutate().get(j).getTitlu());
                    else
                        str.append(list.get(i).getCarti_imprumutate().get(j).getTitlu()).append(",");
                System.out.format("|%-14s|%-69s|\n", list.get(i).getNume(), str);  //formatarea liniilor
                System.out.println("---------------------------------------------------------------------------------------");
            }
        }
    }

    //tabelul pentru carti
    public void printCarti(ArrayList<CarteImprumutata> list) {
        if (list.size() > 0) {
            System.out.println("==============================================================================================================================="); //capul de tabel
            System.out.println("|                  Titlu                  |     Autor     | An aparitie |  Pret  |     Editura     |    Cota    | Imprumutata |");
            System.out.println("===============================================================================================================================");
            int i;
            for (i = 0; i < list.size(); i++) {
                System.out.format("|%-41s|%-15s|%13s|%8s|%-17s|%-12s|%13s|\n", list.get(i).getTitlu(), list.get(i).getAutor(),
                        list.get(i).getAn_aparitie(), list.get(i).getPret(), list.get(i).getEditura(), list.get(i).getCota(), list.get(i).isImprumutata());  //formatarea liniilor
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
            }
        }
    }

    //tabelul pentru afisarea cartilor imprumutate
    public void printCartiImprumutate(ArrayList<CarteImprumutata> list) {
        if (list.size() > 0) {
            System.out.println("========================================================================================"); //capul de tabel
            System.out.println("|                  Titlu                  |     Autor     |     Pret     | Imprumutata |");
            System.out.println("========================================================================================");
            int i;
            float total = 0;
            for (i = 0; i < list.size(); i++)
                {
                if (list.get(i).isImprumutata()) {
                    total +=list.get(i).getPret();
                    System.out.format("|%-41s|%-15s|%14s|%13s|\n", list.get(i).getTitlu(), list.get(i).getAutor(), list.get(i).getPret(), list.get(i).isImprumutata());  //formatarea liniilor
                    System.out.println("----------------------------------------------------------------------------------------");
                }}
            String str = new DecimalFormat("#0.00").format(total);
            System.out.format("|%-41s|%-15s|%14s|%13s|\n", "", "", "Total: " + str, "");
            System.out.println("----------------------------------------------------------------------------------------");
        }
    }

    //tabelul pentru afisarea cartilor impreuna cu numarul de imprumutatori
    public void printCartiNrImprumutatori(ArrayList<Imprumutator> listI, ArrayList<CarteImprumutata> listC) {
        if (listC.size() > 0) {
            System.out.println("========================================================================="); //capul de tabel
            System.out.println("|                  Titlu                  |     Numar Imprumutatori     |");
            System.out.println("=========================================================================");
            for (CarteImprumutata carteImprumutata : listC) {
                int total = 0;
                for (Imprumutator imp : listI)
                    if (imp.getCarti_imprumutate().contains(carteImprumutata)) {
                        total += 1;

                    }
                System.out.format("|%-41s|%29s|\n", carteImprumutata.getTitlu(), total);  //formatarea liniilor
                System.out.println("-------------------------------------------------------------------------");
            }
        }
    }

    //tabelul pentru afisarea imprumutatorilor descrescator dupa numarul de carti imprumutate
    public void printImprumutatoriDesc(ArrayList<Imprumutator> list) {
        if (list.size() > 0) {
            Pair<String,Integer>[] tuples;
            tuples = new Pair[list.size()];
            System.out.println("============================================"); //capul de tabel
            System.out.println("|     Nume     |  Numar carti imprumutate  |");
            System.out.println("============================================");
            int i,j=0;
            for (i = 0; i < list.size(); i++) {
            Pair<String,Integer> pair = new Pair<>( list.get(i).getNume(), list.get(i).getCarti_imprumutate().size());
            tuples[j]=pair;
            j++;
        }
        Sort s = new Sort();
        tuples = s.sortDesc(tuples);
        for (i = 0; i < tuples.length; i++) {
            System.out.format("|%-14s|%27s|\n", tuples[i].x, tuples[i].y);  //formatarea liniilor
            System.out.println("--------------------------------------------");
        }
    }
    }

    //tabelul pentru afisarea autorilor cei mai imprumutati in ordine descrescatoare
    public void printAutoriDesc(ArrayList<Imprumutator> listI, ArrayList<CarteImprumutata> listC) {
        if (listC.size() > 0) {
            int nr=0;
            for (int i=0;i<listC.size();i++)
            {   boolean ok =true;
                String a= listC.get(i).getAutor();
                for(int j=i+1;j<listC.size();j++)
                    if (a.equals(listC.get(j).getAutor())) {
                        ok = false;
                        break;
                    }
                if(ok)
                    nr++;
            }
            Pair<String,Integer>[] tuples;
            tuples = new Pair[nr];
            System.out.println("==========================================="); //capul de tabel
            System.out.println("|      Autor      |   Numar Imprumutari   |");
            System.out.println("===========================================");
            int i=0;
            for (CarteImprumutata carteImprumutata : listC) {
                boolean ok =true;
                String a= carteImprumutata.getAutor();
                int total = 0;
                for(int j=0;j<i;j++)
                    if(a.equals(tuples[j].x))
                        ok=false;
                for (Imprumutator imp : listI)
                    for(Carte c:imp.getCarti_imprumutate())
                        if (c.getAutor()==a) {
                            total += 1;

                    }
                if(ok)
                {Pair<String,Integer> pair = new Pair<>(carteImprumutata.getAutor(), total);
                    tuples[i]=pair;
                    i++;}
            }
            Sort s = new Sort();
            tuples = s.sortDesc(tuples);
            for (i = 0; i < tuples.length; i++) {
                System.out.format("|%-17s|%23s|\n", tuples[i].x, tuples[i].y);  //formatarea liniilor
                System.out.println("-------------------------------------------");

        }
    }
}}