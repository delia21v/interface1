package proiect_delia;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author delia
 */
public class Student {

    private final IntegerProperty idstudent;
    private final StringProperty nume_stud;
    private final StringProperty prenume_stud;
    private final StringProperty nr_matricol;
    private final StringProperty email;
    private final StringProperty an_studiu;

    public Student(Integer idstudent, String nume_stud, String prenume_stud, String nr_matricol, String email, String an_studiu) {
        this.idstudent = new SimpleIntegerProperty(idstudent);
        this.nume_stud = new SimpleStringProperty(nume_stud);
        this.prenume_stud = new SimpleStringProperty(prenume_stud);
        this.nr_matricol = new SimpleStringProperty(nr_matricol);
        this.email = new SimpleStringProperty(email);
        this.an_studiu = new SimpleStringProperty(an_studiu);
    }

    public Integer getIdStudent() {
        return idstudent.get();
    }

    public String getNume_stud() {
        return nume_stud.get();
    }

    public String getPrenume_stud() {
        return prenume_stud.get();
    }

    public String getNr_matricol() {
        return nr_matricol.get();
    }
    public String getEmail() {
        return email.get();
    }
    public String getAn_studiu() {
        return an_studiu.get();
    }

    public void setIdStudent(Integer valoare) {
    	idstudent.set(valoare);
    }

    public void setNume_stud(String valoare) {
    	nume_stud.set(valoare);
    }

    public void setPrenume_stud(String valoare) {
    	prenume_stud.set(valoare);
    }

    public void setNr_matricol(String valoare) {
    	nr_matricol.set(valoare);
    }
    public void setEmail(String valoare) {
        email.set(valoare);
    }
    public void setAn_studiu(String valoare) {
        an_studiu.set(valoare);
    }

    public IntegerProperty idstudentProperty() {
        return idstudent;
    }

    public StringProperty Nume_studProperty() {
        return nume_stud;
    }

    public StringProperty Prenume_studProperty() {
        return prenume_stud;
    }

    public StringProperty Nr_matricolProperty() {
        return nr_matricol;
    }
    public StringProperty EmailProperty() {
        return email;
    }
    public StringProperty An_studiuProperty() {
        return an_studiu;
    }
}