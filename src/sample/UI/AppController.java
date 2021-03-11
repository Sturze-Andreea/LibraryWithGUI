package sample.UI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.Controller.Controller;
import sample.Domain.*;
import sample.Utils.Pair;
import sample.Utils.Sort;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AppController implements Initializable{
    MakeController ctrl = new MakeController();


    //APP

    @FXML
    private AnchorPane pane1;


    @FXML
    private RadioButton carti = new RadioButton();

    @FXML
    private Button chooseButton= new Button();

    @FXML
    private Label startText;

    @FXML
    public Label image = new Label();

    @FXML
    private RadioButton persoane = new RadioButton();

    @FXML
    private RadioButton tabel4 = new RadioButton();

    @FXML
    private RadioButton tabel2 = new RadioButton();

    @FXML
    private RadioButton imprumut = new RadioButton();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ctrl.getCtrl();

        final ToggleGroup toggleGroup = new ToggleGroup();
        carti.setToggleGroup(toggleGroup);
        persoane.setToggleGroup(toggleGroup);
        tabel2.setToggleGroup(toggleGroup);
        tabel4.setToggleGroup(toggleGroup);
        imprumut.setToggleGroup(toggleGroup);


        try {

            titluColumn.setCellValueFactory(new PropertyValueFactory<>("titlu"));
            autorColumn.setCellValueFactory(new PropertyValueFactory<>("autor"));
            anColumn.setCellValueFactory(new PropertyValueFactory<>("an_aparitie"));
            pretColumn.setCellValueFactory(new PropertyValueFactory<>("pret"));
            edituraColumn.setCellValueFactory(new PropertyValueFactory<>("editura"));
            cotaColumn.setCellValueFactory(new PropertyValueFactory<>("cota"));
            imprumutataColumn.setCellValueFactory(new PropertyValueFactory<>("imprumutata"));


            tableCarti.
                    setStyle("-fx-selection-bar: red; -fx-selection-bar-non-focused: salmon;");


        } catch (NullPointerException ignored) {
        }

        try {

            numeColumn.setCellValueFactory(new PropertyValueFactory<>("nume"));
            cartiImprumutateColumn.setCellValueFactory(new PropertyValueFactory<>("cartiImp"));


            tablePersoane.
                    setStyle("-fx-selection-bar: red; -fx-selection-bar-non-focused: salmon;");


        } catch (NullPointerException ignored) {
        }


        try {
            titluColumnt2.setCellValueFactory(new PropertyValueFactory<>("titlu"));
            autorColumnt2.setCellValueFactory(new PropertyValueFactory<>("autor"));
            anColumnt2.setCellValueFactory(new PropertyValueFactory<>("an_aparitie"));
            pretColumnt2.setCellValueFactory(new PropertyValueFactory<>("pret"));
            edituraColumnt2.setCellValueFactory(new PropertyValueFactory<>("editura"));
            cotaColumnt2.setCellValueFactory(new PropertyValueFactory<>("cota"));
            imprumutataColumnt2.setCellValueFactory(new PropertyValueFactory<>("imprumutata"));
            nrImprumutariColumn.setCellValueFactory(new PropertyValueFactory<>("nrImprumutari"));


            tabel2.
                    setStyle("-fx-selection-bar: red; -fx-selection-bar-non-focused: salmon;");
        } catch(NullPointerException ignored){}


        try {

            numeAutor.setCellValueFactory(new PropertyValueFactory<>("nume"));
            imprumutari.setCellValueFactory(new PropertyValueFactory<>("imprumutari"));


            tabel4.
                    setStyle("-fx-selection-bar: red; -fx-selection-bar-non-focused: salmon;");


        } catch (NullPointerException ignored) {
        }
    }

    @FXML
    public void mode() throws IOException {

        if (carti.isSelected()) {

            Parent parent = FXMLLoader.load(getClass().getResource("Carti.fxml"));
            Scene scene = new Scene(parent,750,550);

            Stage newWindow = new Stage();
            newWindow.setScene(scene);
            newWindow.setTitle("Carti Menu");
            newWindow.show();
        }

        if (persoane.isSelected()) {
            Parent parent = FXMLLoader.load(getClass().getResource("Persoane.fxml"));
            Scene scene = new Scene(parent,750,550);

            Stage newWindow = new Stage();
            newWindow.setScene(scene);
            newWindow.setTitle("Persoane Menu");
            newWindow.show();
        }

        if (tabel2.isSelected()) {
            Parent parent = FXMLLoader.load(getClass().getResource("CartiImprumutateNumarImprumutatori.fxml"));
            Scene scene = new Scene(parent,750,550);

            Stage newWindow = new Stage();
            newWindow.setScene(scene);
            newWindow.setTitle("Tabel 2");
            newWindow.show();
        }

        if (tabel4.isSelected()) {
            Parent parent = FXMLLoader.load(getClass().getResource("AutoriNumarImprumutari.fxml"));
            Scene scene = new Scene(parent,750,550);

            Stage newWindow = new Stage();
            newWindow.setScene(scene);
            newWindow.setTitle("Tabel 4");
            newWindow.show();
        }

        if (imprumut.isSelected()) {
            Parent parent = FXMLLoader.load(getClass().getResource("Imprumut.fxml"));
            Scene scene = new Scene(parent,750,550);

            Stage newWindow = new Stage();
            newWindow.setScene(scene);
            newWindow.setTitle("Imprumut");
            newWindow.show();
        }


    }


    //CARTI

    @FXML
    private AnchorPane pane2Carti;

    @FXML
    private Button addButtonCarti;

    @FXML
    private Button displayButtonCarti;

    @FXML
    private TextField titlu;

    @FXML
    private TextField autor;

    @FXML
    private TextField an;

    @FXML
    private TextField pret;

    @FXML
    private TextField editura;

    @FXML
    private TextField cota;

    @FXML
    private Label messageCarti = new Label();

    @FXML
    private Button backButtonCarti = new Button();

    @FXML
    private Button deleteButtonCarti;

    @FXML
    private TableView<CarteImprumutata> tableCarti;

    @FXML
    private TableColumn<CarteImprumutata, String> titluColumn;

    @FXML
    private TableColumn<CarteImprumutata, String> autorColumn;

    @FXML
    private TableColumn<CarteImprumutata, Integer> anColumn;

    @FXML
    private TableColumn<CarteImprumutata, Float> pretColumn;

    @FXML
    private TableColumn<CarteImprumutata, String> edituraColumn;

    @FXML
    private TableColumn<CarteImprumutata, String> cotaColumn;

    @FXML
    private TableColumn<CarteImprumutata, Boolean> imprumutataColumn;

    @FXML
    private Button updateButtonCarti;

    @FXML
    private Button clearButtonCarti;

    @FXML
    private Button tabel1Button;

    @FXML
    private ChoiceBox<String> imprumutata;





    @FXML

    public void showAllCarti() {

        tableCarti.getItems().clear();

        ObservableList<CarteImprumutata> cartiObervableList = FXCollections.observableArrayList(ctrl.getCtrl().getListaCarte());
        tableCarti.getItems().addAll(cartiObervableList);
    }

    @FXML
    public void addCarti() throws FileNotFoundException {

        if (
                (titlu.getText() != null && !titlu.getText().isEmpty()) &&
                        (autor.getText() != null && !autor.getText().isEmpty()) &&
                        (an.getText() != null && !an.getText().isEmpty()) &&
                        (pret.getText() != null && !pret.getText().isEmpty()) &&
                        (imprumutata.getValue() != null && !imprumutata.getValue().isEmpty()) &&
                        (editura.getText() != null && !editura.getText().isEmpty()) &&
                        (cota.getText() != null && !cota.getText().isEmpty())
        ) {

            CarteImprumutata newCarte = new CarteImprumutata(titlu.getText(), autor.getText(), Integer.parseInt(an.getText()), Float.parseFloat(pret.getText()),
                    editura.getText(), cota.getText(),Boolean.parseBoolean(imprumutata.getValue()));
            Controller c= ctrl.getCtrl();
            c.addCarte(newCarte);
            ctrl.saveInFileCarti(c);
            messageCarti.setText("Cartea cu titlul " + titlu.getText() + " a fost adaugata cu succes!");

        } else {
            messageCarti.setText("Campuri incomplete!");
        }
    }

    @FXML
    public void updateCarti() throws FileNotFoundException {

        if (
                (titlu.getText() != null && !titlu.getText().isEmpty()) &&
                        (autor.getText() != null && !autor.getText().isEmpty()) &&
                        (an.getText() != null && !an.getText().isEmpty()) &&
                        (pret.getText() != null && !pret.getText().isEmpty()) &&
                        (imprumutata.getValue() != null && !imprumutata.getValue().isEmpty()) &&
                        (editura.getText() != null && !editura.getText().isEmpty()) &&
                        (cota.getText() != null && !cota.getText().isEmpty())
        )  {
            CarteImprumutata newCarte = new CarteImprumutata(titlu.getText(), autor.getText(), Integer.parseInt(an.getText()), Float.parseFloat(pret.getText()),
                    editura.getText(), cota.getText(),Boolean.parseBoolean(imprumutata.getValue()));
            Controller c= ctrl.getCtrl();
            c.updateCarte(titlu.getText(), newCarte);
            ctrl.saveInFileCarti(c);
            CarteImprumutata cart = new CarteImprumutata();
            if(!c.findCarte(titlu.getText()).equals(cart))
                messageCarti.setText("Carte modificata!");
            else
            messageCarti.setText("Cartea nu exista!");
        } else {
            messageCarti.setText("Campuri incomplete!");
        }
    }

    @FXML
    public void removeCarti() throws FileNotFoundException {

        if (
                (titlu.getText() != null && !titlu.getText().isEmpty())
        )  {
            Controller c= ctrl.getCtrl();
            CarteImprumutata cart = new CarteImprumutata();
            if(!c.findCarte(titlu.getText()).equals(cart))
                messageCarti.setText("Carte stearsa!");
            else
                messageCarti.setText("Cartea nu exista!");
            c.deleteCarte(c.findCarte(titlu.getText()));
            ctrl.saveInFileCarti(c);

        }
    }


    @FXML
    public void closeWindowCarti() {

        Stage stage = (Stage) backButtonCarti.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void clearTextFieldCarti() {


        titlu.clear();
        autor.clear();
        an.clear();
        pret.clear();
        imprumutata.getSelectionModel().clearSelection();
        editura.clear();
        cota.clear();

        messageCarti.setText(null);
    }

    @FXML
    public void tabel1Carti() {
        ArrayList<CarteImprumutata> list = ctrl.getCtrl().getListaCarte();
        ArrayList<CarteImprumutata> arr = new ArrayList<>();
        int i;
        float total = 0;
        for (i = 0; i < list.size(); i++)
        {
            if (list.get(i).isImprumutata()) {
                total +=list.get(i).getPret();
                arr.add(list.get(i));}
        }
        String str = new DecimalFormat("#0.00").format(total);
        messageCarti.setText("Total: "+str);
        tableCarti.getItems().clear();

        ObservableList<CarteImprumutata> cartiObervableList = FXCollections.observableArrayList(arr);
        tableCarti.getItems().addAll(cartiObervableList);
    }


    //PERSOANE

    @FXML
    private AnchorPane pane2Pers;

    @FXML
    private Button addButtonPers;

    @FXML
    private Button displayButtonPers;

    @FXML
    private TextField nume;

    @FXML
    private TextField cartiImprumutate;

    @FXML
    private Label messagePers;

    @FXML
    private Button backButtonPers;

    @FXML
    private Button deleteButtonPers;

    @FXML
    private TableView<Imprumutator> tablePersoane;

    @FXML
    private TableColumn<Imprumutator, String> numeColumn;

    @FXML
    private TableColumn<Imprumutator, String> cartiImprumutateColumn;

    @FXML
    private Button updateButtonPers;

    @FXML
    private Button clearButtonPers;

    @FXML
    private Button tabel3Button;



    @FXML

    public void showAllPers() {

        tablePersoane.getItems().clear();

        ObservableList<Imprumutator> persObervableList = FXCollections.observableArrayList(ctrl.getCtrl().getListaImprumutator());
        tablePersoane.getItems().addAll(persObervableList);
    }

    @FXML
    public void addPersoane() throws FileNotFoundException {

        if (
                (nume.getText() != null && !nume.getText().isEmpty())
        ) {

            ArrayList<Carte> arr = new ArrayList<>();
            if(!cartiImprumutate.getText().equals(""))
            {String[] carti_imp = cartiImprumutate.getText().split("\\.");
                for (String value : carti_imp) arr.add(ctrl.getCtrl().findCarte(value));
            }
            Imprumutator newImp = new Imprumutator(nume.getText(), arr);
            Controller c= ctrl.getCtrl();
            c.addImprumutator(newImp);
            ctrl.saveInFilePers(c);
            messagePers.setText("Persoana cu numele " + nume.getText() + " a fost adaugat cu succes!");

        } else {
            messagePers.setText("Campuri incomplete!");
        }
    }

    @FXML
    public void updatePersoane() throws FileNotFoundException {

        if (
                (nume.getText() != null && !nume.getText().isEmpty())
        ) {

            ArrayList<Carte> arr = new ArrayList<>();
            if(!cartiImprumutate.getText().equals(" "))
            {String[] carti_imp = cartiImprumutate.getText().split("\\.");
                for (String value : carti_imp) arr.add(ctrl.getCtrl().findCarte(value));
            }
            Imprumutator newImp = new Imprumutator(nume.getText(), arr);
            Controller c= ctrl.getCtrl();
            c.updateImprumutator(nume.getText(),newImp);
            ctrl.saveInFilePers(c);
            Imprumutator i = new Imprumutator();
            if(!c.findImprumutator(nume.getText()).equals(i))
                messagePers.setText("Imprumutator modificat!");
            else
                messagePers.setText("Imprumutatorul nu exista!");
        } else {
            messagePers.setText("Campuri incomplete!");
        }
    }

    @FXML
    public void removePersoane() throws FileNotFoundException {
        if (
                (nume.getText() != null && !nume.getText().isEmpty())
        )  {
            Controller c= ctrl.getCtrl();
            Imprumutator i = new Imprumutator();
            if(!c.findImprumutator(nume.getText()).equals(i))
                messagePers.setText("Persoana stearsa!");
            else
                messagePers.setText("Persoana nu exista!");
            c.deleteImprumutator(c.findImprumutator(nume.getText()));
            ctrl.saveInFilePers(c);

        }
    }


    @FXML
    public void closeWindowPers() {

        Stage stage = (Stage) backButtonPers.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void clearTextFieldPers() {


        nume.clear();
        cartiImprumutate.clear();

        messagePers.setText(null);
    }

    @FXML
    public void tabel3Persoane() {
        ArrayList<Imprumutator> list = ctrl.getCtrl().getListaImprumutator();
        ArrayList<Imprumutator> arr = new ArrayList<>();
        if (list.size() > 0) {
            Pair<String, Integer>[] tuples;
            tuples = new Pair[list.size()];
            int i, j = 0;
            for (i = 0; i < list.size(); i++) {
                Pair<String, Integer> pair = new Pair<>(list.get(i).getNume(), list.get(i).getCarti_imprumutate().size());
                tuples[j] = pair;
                j++;
            }
            Sort s = new Sort();
            tuples = s.sortDesc(tuples);

            for (i = 0; i < tuples.length; i++){
                arr.add(ctrl.getCtrl().findImprumutator(tuples[i].x));}
            tablePersoane.getItems().clear();

            ObservableList<Imprumutator> persObervableList = FXCollections.observableArrayList(arr);
            tablePersoane.getItems().addAll(persObervableList);

        }
    }

    //TABEL2

    @FXML
    private TableView<CarteImprumutata> tabel2View;

    @FXML
    private TableColumn<CarteImprumutata, String> titluColumnt2;

    @FXML
    private TableColumn<CarteImprumutata, String> autorColumnt2;

    @FXML
    private TableColumn<CarteImprumutata, Integer> anColumnt2;

    @FXML
    private TableColumn<CarteImprumutata, Float> pretColumnt2;

    @FXML
    private TableColumn<CarteImprumutata, String> edituraColumnt2;

    @FXML
    private TableColumn<CarteImprumutata, String> cotaColumnt2;

    @FXML
    private TableColumn<CarteImprumutata, String> imprumutataColumnt2;

    @FXML
    private TableColumn<CarteImprumutata, Integer> nrImprumutariColumn;

    @FXML
    private Button tabel2Button;

    @FXML
    private Button backButtontabel2 ;

    @FXML
    public void tabel2() {
        Controller c = ctrl.getCtrl();
        ArrayList<CarteImprumutata> list = c.getListaCarte();
        ArrayList<CarteImprumutata> arr = new ArrayList<>();
        for (CarteImprumutata carteImprumutata : list) {
            int total = 0;
            for (Imprumutator imp : c.getListaImprumutator())
                {if (imp.getCarti_imprumutate().contains(carteImprumutata)) {
                    total += 1; }
                }
            arr.add(new CarteImprumutata(carteImprumutata.getTitlu(),carteImprumutata.getAutor(),carteImprumutata.getAn_aparitie(),
                    carteImprumutata.getPret(),carteImprumutata.getEditura(),carteImprumutata.getCota(),carteImprumutata.isImprumutata(),total));
        }

        tabel2View.getItems().clear();

        ObservableList<CarteImprumutata> cartiObervableList = FXCollections.observableArrayList(arr);
        tabel2View.setItems(cartiObervableList);
    }

    @FXML
    public void closeWindowtabel2() {

        Stage stage = (Stage) backButtontabel2.getScene().getWindow();
        stage.close();
    }

    //TABEL4


    @FXML
    private TableView<Autor> tabel4View;

    @FXML
    private TableColumn<Autor, String> numeAutor;

    @FXML
    private TableColumn<Autor, Integer> imprumutari;

    @FXML
    private Button tabel4Button;

    @FXML
    private Button backButtontabel4 ;

    @FXML
    public void tabel4() {
        Controller c = ctrl.getCtrl();
        ArrayList<CarteImprumutata> list = c.getListaCarte();
        ArrayList<Autor> arr = new ArrayList<>();

        if (list.size() > 0) {
            int nr=0;
            for (int i=0;i<list.size();i++)
            {   boolean ok =true;
                Autor a= new Autor(list.get(i).getAutor());
                for(int j=i+1;j<list.size();j++)
                    if (a.getNume().equals(list.get(j).getAutor())) {
                        ok = false;
                        break;
                    }
                if(ok)
                    nr++;
            }
            Pair<String,Integer>[] tuples;
            tuples = new Pair[nr];
            int i=0;
            for (CarteImprumutata carteImprumutata : list) {
                boolean ok =true;
                Autor a= new Autor(carteImprumutata.getAutor());
                int total = 0;
                for(int j=0;j<i;j++)
                    if(a.getNume().equals(tuples[j].x))
                        ok=false;
                for (Imprumutator imp : c.getListaImprumutator())
                    for(Carte carte:imp.getCarti_imprumutate())
                        if (carte.getAutor()==a.getNume()) {
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
                Autor a = new Autor(tuples[i].x,tuples[i].y);
                arr.add(a);
            }

        tabel4View.getItems().clear();

        ObservableList<Autor> autorObervableList = FXCollections.observableArrayList(arr);
        tabel4View.getItems().addAll(autorObervableList);
    }
    }

    @FXML
    public void closeWindowtabel4() {

        Stage stage = (Stage) backButtontabel4.getScene().getWindow();
        stage.close();
    }


    //IMPRUMUT

    @FXML
    private AnchorPane pane2Imprumut;

    @FXML
    private Button addButtonImprumut;

    @FXML
    private TextField titluImprumut;

    @FXML
    private TextField numeImprumut;

    @FXML
    private Label messageImprumut = new Label();

    @FXML
    private Button backButtonImprumut;

    @FXML
    private Button clearButtonImprumut;

    @FXML
    public void addImprumut() throws FileNotFoundException {
        if (
                (titluImprumut.getText() != null && !titluImprumut.getText().isEmpty()) &&
                        (numeImprumut.getText() != null && !numeImprumut.getText().isEmpty())
        ) {

            Controller c= ctrl.getCtrl();
            int rez= c.imprumut(titluImprumut.getText(),numeImprumut.getText());
            ctrl.saveInFilePers(c);
            ctrl.saveInFileCarti(c);
            if (rez==0)
                messageImprumut.setText("Imprumut realizat cu succes!");
            else
                messageImprumut.setText("Cartea este deja imprumutata!");

        } else {
            messageImprumut.setText("Campuri incomplete!");
        }
    }

    @FXML
    public void clearTextFieldImprumut() {
        numeImprumut.clear();
        titluImprumut.clear();

        messageImprumut.setText(null);
    }

    @FXML
    public void closeWindowImprumut() {
        Stage stage = (Stage) backButtonImprumut.getScene().getWindow();
        stage.close();
    }
}
