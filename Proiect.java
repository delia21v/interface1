package proiect_delia;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author delia
 */
public class Proiect {

    private final IntegerProperty iddepartament;
    private final IntegerProperty idstudent;
    private final IntegerProperty idproiect;
    private final StringProperty data_predare;
    private final StringProperty tematica;
    private final StringProperty nume_proiect;
    
    public Proiect(Integer idproiect, String data_predare, String tematica, String nume_proiect, Integer idstudent, Integer iddepartament) {
        this.idproiect = new SimpleIntegerProperty(idproiect);
        this.data_predare = new SimpleStringProperty(data_predare);
        this.tematica = new SimpleStringProperty(tematica);
        this.nume_proiect = new SimpleStringProperty(nume_proiect);
        this.idstudent = new SimpleIntegerProperty(idstudent);
        this.iddepartament = new SimpleIntegerProperty(iddepartament);
    }

    public Integer getidproiect() {
        return idproiect.get();
    }

    public String getData_predare() {
        return data_predare.get();
    }

    public String getTematica() {
        return tematica.get();
    }

    public String getNume_proiect() {
        return nume_proiect.get();
    }
    public Integer getIdstudent() {
        return idstudent.get();
    }
    
    public Integer getIddepartament() {
        return iddepartament.get();
    }
 
    public void setidproiect(Integer valoare) {
        idproiect.set(valoare);
    }

    public void setData_predare(String valoare) {
        data_predare.set(valoare);
    }

    public void setTematica(String valoare) {
        tematica.set(valoare);
    }

    public void setNume_proiect(String valoare) {
        nume_proiect.set(valoare);
    }
    public void setIdstudent(Integer valoare) {
        idstudent.set(valoare);
    }
    
    public void setIddepartament(Integer valoare) {
        iddepartament.set(valoare);
    }
    
    public IntegerProperty idproiectProperty() {
        return idproiect;
    }

    public StringProperty Data_predareProperty() {
        return data_predare;
    }

    public StringProperty TematicaProperty() {
        return tematica;
    }
    
    public StringProperty Nume_proiectProperty() {
        return nume_proiect;
    }
    public IntegerProperty idstudentProperty() {
        return idstudent;
    }
    
    public IntegerProperty iddepartamentProperty() {
        return iddepartament;
    }
}
