package sample.Domain;

public class Carte {
    protected String titlu;
    protected String autor;
    protected int an_aparitie;
    protected float pret;
    protected String editura;
    protected String cota;

    //constructor impicit
    public Carte(){
        this("","",0,0,"","");
    }

    //constructor cu parametrii
    public Carte(String t,String a,int y,float p,String e,String c){
        titlu=t;
        autor=a;
        an_aparitie=y;
        pret=p;
        editura=e;
        cota=c;
    }

    //functia care returneaza titlul unei carti
    public String getTitlu() {
        return titlu;
    }

    //functia care returneaza autorul unei carti
    public String getAutor() {
        return autor;
    }

    //functia care returneaza anul aparitiei unei carti
    public int getAn_aparitie() {
        return an_aparitie;
    }

    //functia care returneaza pretul unei carti
    public float getPret() {
        return pret;
    }

    //functia care returneaza editura unei carti
    public String getEditura() {
        return editura;
    }

    //functia care returneaza cota unei carti
    public String getCota() {
        return cota;
    }

    //functia care modifica numele unei carti
    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    //functia care modifica titlul unei carti
    public void setAutor(String autor) {
        this.autor = autor;
    }

    //functia care modifica anul aparitiei unei carti
    public void setAn_aparitie(int an_aparitie) {
        this.an_aparitie = an_aparitie;
    }

    //functia care modifica pretul unei carti
    public void setPret(float pret) {
        this.pret = pret;
    }

    //functia care modifica editura unei carti
    public void setEditura(String editura) {
        this.editura = editura;
    }

    //functia care modifica cota unei carti
    public void setCota(String cota) {
        this.cota = cota;
    }

    //functia cu ajutorul careia scriem o carte ca string
    @Override
    public String toString() {
        return "Carte{" +
                "titlu='" + titlu + '\'' +
                ", autor=" + autor +
                ", an_aparitie=" + an_aparitie +
                ", pret=" + pret +
                ", editura=" + editura +
                ", cota='" + cota + '\'' +
                '}';
    }
}
