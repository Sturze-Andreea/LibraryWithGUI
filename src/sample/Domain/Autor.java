package sample.Domain;

public class Autor {
    private String nume;
    private int imprumutari;

    //constructor implicit
    public Autor(){
        nume= new String("");
        imprumutari=0;
    }

    //constructor cu parametrii
    public Autor(String n){
        nume= n;
        imprumutari=0;
    }
    public Autor(String n, int i){
        nume= n;
        imprumutari=i;
    }

    //functia care returneaza numele unui autor
    public String getNume() {
        return nume;
    }

    //functia care modifica numele unui autor
    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getImprumutari() {
        return imprumutari;
    }

    public void setImprumutari(int imp) {
        this.imprumutari = imp;
    }
}
