package proiect_delia;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author delia
 */
public class Departament {

    private final IntegerProperty iddepartament;
    private final StringProperty nume_departament;
    private final StringProperty coordonator;
    private final StringProperty contact;
    private final StringProperty facultate;

    public Departament(Integer iddepartament, String nume_departament, String coordonator, String contact, String facultate) {
        this.iddepartament = new SimpleIntegerProperty(iddepartament);
        this.nume_departament = new SimpleStringProperty(nume_departament);
        this.coordonator = new SimpleStringProperty(coordonator);
        this.contact = new SimpleStringProperty(contact);
        this.facultate = new SimpleStringProperty(facultate);
        }

    public Integer getIddepartament() {
        return iddepartament.get();
    }

    public String getNume_departament() {
        return nume_departament.get();
    }

    public String getCoordonator() {
        return coordonator.get();
    }

    public String getContact() {
        return contact.get();
    }
    public String getFacultate() {
        return facultate.get();
    }
     public void setIdDepartament(Integer valoare) {
        iddepartament.set(valoare);
    }

    public void setNume_departament(String valoare) {
        nume_departament.set(valoare);
    }

    public void setCoordonator(String valoare) {
        coordonator.set(valoare);
    }

    public void setContact(String valoare) {
        contact.set(valoare);
    }
    public void setFacultate(String valoare) {
        facultate.set(valoare);
    }

    public IntegerProperty iddepartamentProperty() {
        return iddepartament;
    }

    public StringProperty Nume_departamentProperty() {
        return nume_departament;
    }

    public StringProperty CoordonatorProperty() {
        return coordonator;
    }

    public StringProperty ContactProperty() {
        return contact;
    }
    public StringProperty FacultateProperty() {
        return facultate;
    }
}