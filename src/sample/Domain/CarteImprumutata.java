package sample.Domain;

public class CarteImprumutata extends Carte{
    private boolean imprumutata;
    private int nrImprumutari;

    //constructor implicit
    public CarteImprumutata(){
    this("","",0,0,"","",false);
    nrImprumutari = 0;
    }

    //constructor cu parametrii
    public CarteImprumutata(String t,String a,int y,float p,String e,String c,boolean imp){
        titlu=t;
        autor=a;
        an_aparitie=y;
        pret=p;
        editura=e;
        cota=c;
        imprumutata = imp;
        nrImprumutari=0;
    }

    public CarteImprumutata(String t,String a,int y,float p,String e,String c,boolean imp, int nr){
        titlu=t;
        autor=a;
        an_aparitie=y;
        pret=p;
        editura=e;
        cota=c;
        imprumutata = imp;
        nrImprumutari=nr;
    }
    //functia care verifica daca o carte e imprumutata
    public boolean isImprumutata() {
        return imprumutata;
    }

    //functia care modifica statusul unei carti
    public void setImprumutata(boolean imprumutata){
        this.imprumutata=imprumutata;
    }

    public int getNrImprumutari() {
        return nrImprumutari;
    }

    public void setNrImprumutari(int nrImprumutari1){
        this.nrImprumutari = nrImprumutari1;
    }

}
