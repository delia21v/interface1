package proiect_delia;

import javafx.scene.control.TextField;
import java.net.URL;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author delia
 */
public class Proiect_DeliaController implements Initializable {
    
    @FXML
    private TableView<Student> tabela_Studenti;
    @FXML
    private Tab tab_Studenti;
    @FXML
    private Button buton_IncarcareStudenti;
    @FXML
    private TableColumn<Student, Integer> atribut_idstudent;
    @FXML
    private TableColumn<Student, String> atribut_NumeS;
    @FXML
    private TableColumn<Student, String> atribut_PrenumeS;
    @FXML
    private TableColumn<Student, String> atribut_Nr_matricolS;
    @FXML
    private TableColumn<Student, String> atribut_EmailS;
    @FXML
    private TableColumn<Student, String> atribut_AnStudiuS;
    @FXML
    private TableView<Departament> tabela_Departamente;
    @FXML
    private Tab tab_Departamente;
    @FXML
    private Button buton_IncarcareDepartament;
    @FXML
    private TableColumn<Departament, Integer> atribut_iddepartament;
    @FXML
    private TableColumn<Departament, String> atribut_Nume_departament;
    @FXML
    private TableColumn<Departament, String> atribut_Coordonator;
    @FXML
    private TableColumn<Departament, String> atribut_Contact;
    @FXML
    private TableColumn<Departament, String> atribut_Facultate;
    @FXML
    private TableView<Proiect> tabela_Proiecte;
    @FXML
    private Tab tab_Proiecte;
    @FXML
    private Button buton_IncarcareProiecte;
    @FXML
    private TableColumn<Proiect, Integer> atribut_idproiect;
    @FXML
    private TableColumn<Proiect, String> atribut_Data_predare;
    @FXML
    private TableColumn<Proiect, String> atribut_Tematica;
    @FXML
    private TableColumn<Proiect, String> atribut_Nume_proiect;
    @FXML
    private TableColumn<Proiect, String> idstudentP;
    @FXML
    private TableColumn<Proiect, String> iddepartamentP;
    @FXML
    private Button Adauga;
    @FXML
    private Button Sterge;
    @FXML
    private Button Modifica;
    @FXML
    private Button AdaugaDepartament;
    @FXML
    private Button StergeDepartament;
    @FXML
    private Button ModificaDepartament;
    @FXML
    private Button AdaugaProiect;
    @FXML
    private Button StergeProiect;
    @FXML
    private Button ModificaProiect;
    
    
    private ObservableList<Student> dateStudenti;
    private ObservableList<Departament> dateDepartamente;
    private ObservableList<Proiect> dateProiecte;
    private DBOperations jb;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        jb = new DBOperations();
    }    

    @FXML
    private void incarcaStudenti(ActionEvent event) throws SQLException, Exception {
        jb.connect();
        dateStudenti = FXCollections.observableArrayList();

        ResultSet rs = jb.vedeTabel("studenti");
        //jb.afisare(rs);
        //System.out.println("test");
        while (rs.next()) {
        	dateStudenti.add(new Student(rs.getInt("idstudent"), rs.getString("nume_stud"), rs.getString("prenume_stud"), rs.getString("nr_matricol"), rs.getString("email"), rs.getString("an_studiu")));
        }

        atribut_idstudent.setCellValueFactory(new PropertyValueFactory<>("idstudent"));
        atribut_NumeS.setCellValueFactory(new PropertyValueFactory<>("nume_stud"));
        atribut_PrenumeS.setCellValueFactory(new PropertyValueFactory<>("prenume_stud"));
        atribut_Nr_matricolS.setCellValueFactory(new PropertyValueFactory<>("nr_matricol"));
        atribut_EmailS.setCellValueFactory(new PropertyValueFactory<>("email"));
        atribut_AnStudiuS.setCellValueFactory(new PropertyValueFactory<>("an_studiu"));
        
        tabela_Studenti.setItems(null);
        tabela_Studenti.setItems(dateStudenti);
        jb.disconnect();
    }

    @FXML
    private void incarcaDepartamente(ActionEvent event) throws SQLException, Exception {
        jb.connect();
        dateDepartamente = FXCollections.observableArrayList();

        ResultSet rs = jb.vedeTabel("departamente");
        while (rs.next()) {
        	dateDepartamente.add(new Departament(rs.getInt("iddepartament"), rs.getString("nume_departament"), rs.getString("coordonator"), rs.getString("contact"), rs.getString("facultate")));
        }

        atribut_iddepartament.setCellValueFactory(new PropertyValueFactory<>("iddepartament"));
        atribut_Nume_departament.setCellValueFactory(new PropertyValueFactory<>("nume_departament"));
        atribut_Coordonator.setCellValueFactory(new PropertyValueFactory<>("coordonator"));
        atribut_Contact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        atribut_Facultate.setCellValueFactory(new PropertyValueFactory<>("facultate"));
      
        tabela_Departamente.setItems(null);
        tabela_Departamente.setItems(dateDepartamente);
        jb.disconnect();
    }   


	@FXML
	private void incarcaProiecte(ActionEvent event) throws SQLException, Exception {
	    jb.connect();
	    dateProiecte = FXCollections.observableArrayList();
	
	    ResultSet rs = jb.vedeTabel("proiecte");
	    while (rs.next()) {
	    	dateProiecte.add(new Proiect(rs.getInt("idproiect"), rs.getString("data_predare"), rs.getString("tematica"), rs.getString("nume_proiect"), rs.getInt("idstudent"), rs.getInt("iddepartament")));
	    }
	
	    atribut_idproiect.setCellValueFactory(new PropertyValueFactory<>("idproiect"));
	    atribut_Data_predare.setCellValueFactory(new PropertyValueFactory<>("data_predare"));
	    atribut_Tematica.setCellValueFactory(new PropertyValueFactory<>("tematica"));
	    atribut_Nume_proiect.setCellValueFactory(new PropertyValueFactory<>("nume_proiect"));
	    idstudentP.setCellValueFactory(new PropertyValueFactory<>("idstudent"));
	    iddepartamentP.setCellValueFactory(new PropertyValueFactory<>("iddepartament"));
	    
	    tabela_Proiecte.setItems(null);
	    tabela_Proiecte.setItems(dateProiecte);
	    jb.disconnect();
	}  


@FXML
private TextField nume_stud_add;
@FXML
private TextField prenume_stud_add;
@FXML
private TextField nr_matricol_add;
@FXML
private TextField email_add;
@FXML
private TextField an_studiu_add;


@FXML
private void adaugareStudenti(ActionEvent event) throws SQLException, Exception {
    jb.connect();
    jb.adaugaStudent(nume_stud_add.getText(), prenume_stud_add.getText(), nr_matricol_add.getText(), email_add.getText(), an_studiu_add.getText());
    jb.disconnect();
}

@FXML
private TextField nume_departament_add;
@FXML
private TextField coordonator_add;
@FXML
private TextField contact_add;
@FXML
private TextField facultate_add;
@FXML

private void adaugareDepartamente(ActionEvent event) throws SQLException, Exception {
    jb.connect();
    jb.adaugaDepartament(nume_departament_add.getText(),coordonator_add.getText(),contact_add.getText(),facultate_add.getText());
    jb.disconnect();
}




@FXML
private TextField data_predare_add;
@FXML
private TextField tematica_add;
@FXML
private TextField nume_proiect_add;
@FXML
private TextField idstudent_add;
@FXML
private TextField iddepartament_add;


@FXML 
private void adaugareProiecte(ActionEvent event) throws SQLException, Exception {
 jb.connect();
 jb.adaugaProiect(java.lang.Integer.parseInt(idstudent_add.getText()), java.lang.Integer.parseInt(iddepartament_add.getText()),data_predare_add.getText(), tematica_add.getText(), nume_proiect_add.getText());  
 jb.disconnect();	
}


@FXML
private void StergeStudent(ActionEvent event) throws SQLException, Exception {
    jb.connect();
    Student selectedStudent = tabela_Studenti.getSelectionModel().getSelectedItem();
   
    if (selectedStudent != null) {
        jb.stergeTabela("studenti", "idstudent", selectedStudent.getIdStudent());
        tabela_Studenti.getItems().remove(selectedStudent);
    } 
    jb.disconnect();
}

@FXML
private void StergeProiect(ActionEvent event) throws SQLException, Exception {
    jb.connect();
    Proiect selectedProiect = tabela_Proiecte.getSelectionModel().getSelectedItem();
   
    if (selectedProiect != null) {
        jb.stergeTabela("proiecte", "idproiect", selectedProiect.getidproiect());
        tabela_Proiecte.getItems().remove(selectedProiect);
    } 
    jb.disconnect();
}

@FXML
private void StergeDepartament(ActionEvent event) throws SQLException, Exception {
    jb.connect();
    Departament selectedDepartament = tabela_Departamente.getSelectionModel().getSelectedItem();
   
    if (selectedDepartament != null) {
        jb.stergeTabela("departamente", "iddepartament", selectedDepartament.getIddepartament());
        tabela_Departamente.getItems().remove(selectedDepartament);
    } 
    jb.disconnect();
}

@FXML
private TextField idstudent_modif;
@FXML
private TextField nume_stud_modif;
@FXML
private TextField prenume_stud_modif;
@FXML
private TextField nr_matricol_modif;
@FXML
private TextField email_modif;
@FXML
private TextField an_studiu_modif;


@FXML
private void modificaStudent(ActionEvent event) throws SQLException, Exception {
	jb.connect();
	jb.modificaStudent(nume_stud_modif.getText(), prenume_stud_modif.getText(), nr_matricol_modif.getText(), email_modif.getText(), an_studiu_modif.getText(), java.lang.Integer.parseInt(idstudent_modif.getText()));
	jb.disconnect();
}


@FXML
private TextField nume_departament_modif;
@FXML
private TextField coordonator_modif;
@FXML
private TextField contact_modif;
@FXML
private TextField facultate_modif;
@FXML
private TextField iddepartament_modif;

@FXML
private void modificaDepartament(ActionEvent event) throws SQLException, Exception {
	jb.connect();
	jb.modificaDepartament(nume_departament_modif.getText(), coordonator_modif.getText(), contact_modif.getText(), facultate_modif.getText(), java.lang.Integer.parseInt(iddepartament_modif.getText()));
	jb.disconnect();
}

@FXML
private Button pagina_add_student;
@FXML
private Button inapoi1;

@FXML
private void handleButtonAction(ActionEvent event) throws IOException {
    Stage stage;
    Parent root;
    if (event.getSource() == pagina_add_student) {
        // obtinem referinta catre stage-ul butonului         
        stage = (Stage) pagina_add_student.getScene().getWindow();
        // incarcam celalalt document FXML
        root = FXMLLoader.load(getClass().getResource("Adauga_Student.fxml"));
    } else {
        stage = (Stage) inapoi1.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Proiect_Delia.fxml"));
    }
    // cream o noua scena cu un root
    Scene scene = new Scene(root);
    // setam scena
    stage.setScene(scene);
    stage.show();
}

@FXML
private Button pagina_add_departament;
@FXML
private Button inapoi2;

@FXML
private void handleButtonAction1(ActionEvent event) throws IOException {
    Stage stage;
    Parent root;
    if (event.getSource() == pagina_add_departament) {
        // obtinem referinta catre stage-ul butonului         
        stage = (Stage) pagina_add_departament.getScene().getWindow();
        // incarcam celalalt document FXML
        root = FXMLLoader.load(getClass().getResource("Adauga_Departament.fxml"));
    } else {
        stage = (Stage) inapoi2.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Proiect_Delia.fxml"));
    }
    // cream o noua scena cu un root
    Scene scene = new Scene(root);
    // setam scena
    stage.setScene(scene);
    stage.show();
}

@FXML
private Button pagina_modif;
@FXML
private Button inapoi3;

@FXML
private void handleButtonAction2(ActionEvent event) throws IOException {
    Stage stage;
    Parent root;
    if (event.getSource() == pagina_modif) {
        // obtinem referinta catre stage-ul butonului         
        stage = (Stage) pagina_modif.getScene().getWindow();
        // incarcam celalalt document FXML
        root = FXMLLoader.load(getClass().getResource("Modifica_Student.fxml"));
    } else {
        stage = (Stage) inapoi3.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Proiect_Delia.fxml"));
    }
    // cream o noua scena cu un root
    Scene scene = new Scene(root);
    // setam scena
    stage.setScene(scene);
    stage.show();
}

@FXML
private Button pagina_modif1;
@FXML
private Button inapoi4;

@FXML
private void handleButtonAction3(ActionEvent event) throws IOException {
    Stage stage;
    Parent root;
    if (event.getSource() == pagina_modif1) {
        // obtinem referinta catre stage-ul butonului         
        stage = (Stage) pagina_modif1.getScene().getWindow();
        // incarcam celalalt document FXML
        root = FXMLLoader.load(getClass().getResource("Modifica_Departament.fxml"));
    } else {
        stage = (Stage) inapoi4.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Proiect_Delia.fxml"));
    }
    // cream o noua scena cu un root
    Scene scene = new Scene(root);
    // setam scena
    stage.setScene(scene);
    stage.show();
}

@FXML
private Button pagina_add_proiect;
@FXML
private Button inapoi5;

@FXML
private void handleButtonAction4(ActionEvent event) throws IOException {
    Stage stage;
    Parent root;
    if (event.getSource() == pagina_add_proiect) {
        // obtinem referinta catre stage-ul butonului         
        stage = (Stage) pagina_add_proiect.getScene().getWindow();
        // incarcam celalalt document FXML
        root = FXMLLoader.load(getClass().getResource("Adauga_Proiect.fxml"));
    } else {
        stage = (Stage) inapoi5.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Proiect_Delia.fxml"));
    }
    // cream o noua scena cu un root
    Scene scene = new Scene(root);
    // setam scena
    stage.setScene(scene);
    stage.show();
}

@FXML
private TextField idstudentP_modif;
@FXML
private TextField iddepartamentP_modif;
@FXML
private TextField data_predare_modif;
@FXML
private TextField tematica_modif;
@FXML
private TextField nume_proiect_modif;
@FXML
private TextField idproiect_modif;

@FXML
private void modificaProiect(ActionEvent event) throws SQLException, Exception {
	jb.connect();
	jb.modificaProiect(data_predare_modif.getText(), tematica_modif.getText(), nume_proiect_modif.getText(), java.lang.Integer.parseInt(idproiect_modif.getText()), java.lang.Integer.parseInt(idstudentP_modif.getText()),java.lang.Integer.parseInt( iddepartamentP_modif.getText()));
	jb.disconnect();
}

@FXML
private Button pagina_modif2;
@FXML
private Button inapoi6;

@FXML
private void handleButtonAction5(ActionEvent event) throws IOException {
    Stage stage;
    Parent root;
    if (event.getSource() == pagina_modif2) {
        // obtinem referinta catre stage-ul butonului         
        stage = (Stage) pagina_modif2.getScene().getWindow();
        // incarcam celalalt document FXML
        root = FXMLLoader.load(getClass().getResource("Modifica_Proiect.fxml"));
    } else {
        stage = (Stage) inapoi6.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Proiect_Delia.fxml"));
    }
    // cream o noua scena cu un root
    Scene scene = new Scene(root);
    // setam scena
    stage.setScene(scene);
    stage.show();
}
}