package sample.Domain;

public class Editura {
    private String nume;

    //constructor implicit
    public Editura(){
        nume= new String("");
    }

    //constructor cu parametrii
    public Editura(String n){
        nume= n;
    }

    //functia care returneaza numele unei edituri
    public String getNume() {
        return nume;
    }

    //functia care modifica numele unei edituri
    public void setNume(String nume) {
        this.nume = nume;
    }
}
