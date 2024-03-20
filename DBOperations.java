package proiect_delia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 *
 * @author delia
 */
public class DBOperations {

	String error;
	Connection con;
	// Conectarea la baza de date

	public DBOperations() {
	}

	public void connect() throws ClassNotFoundException, SQLException, Exception {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect_pibd?useSSL=false", "root", "02182113a.DD");
		} catch (ClassNotFoundException cnfe) {
			error = "ClassNotFoundException: Nu s-a gasit driverul bazei de date.";
			throw new ClassNotFoundException(error);
		} catch (SQLException cnfe) {
			error = "SQLException: Nu se poate conecta la baza de date.";
			throw new SQLException(error);
		} catch (Exception e) {
			error = "Exception: A aparut o exceptie neprevazuta in timp ce se stabilea legatura la baza de date.";
			throw new Exception(error);
		}
	}
	// end connect()

	public ResultSet vedeTabel(String tabel) throws SQLException, Exception {
		ResultSet rs = null;
		try {
			String queryString = ("select * from `proiect_pibd`.`" + tabel + "`;");
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(queryString);
		} catch (SQLException sqle) {
			error = "SQLException: Interogarea nu a fost posibila.";
			throw new SQLException(error);
		} catch (Exception e) {
			error = "A aparut o exceptie in timp ce se extrageau datele.";
			throw new Exception(error);
		}
		return rs;
	}
	// end vedeTabel()

	public void disconnect() throws SQLException {
		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException sqle) {
			error = ("SQLException: Nu se poate inchide conexiunea la baza de date.");
			throw new SQLException(error);
		}
	} // disconnect()

	public void adaugaStudent(String nume_stud, String prenume_stud, String nr_matricol,String email, String an_studiu) throws SQLException {
		try {
			// create a prepared SQL statement
			Statement stmt;
			stmt = con.createStatement();
			stmt.executeUpdate("insert into `proiect_pibd`.`studenti`(nume_stud, prenume_stud, nr_matricol, email, an_studiu) values('" + nume_stud + "', '" + prenume_stud + "','" + nr_matricol + "','" + email + "', '" + an_studiu + "');");
		} catch (SQLException sqle) {
			error = "ExceptieSQL: Reactualizare nereusita; este posibil sa existe duplicate.";
			throw new SQLException(error);
		}
	}
	// end adaugaStudent()

	public void adaugaDepartament(String nume_departament, String coordonator, String contact, String facultate) throws SQLException {
		try {
			// create a prepared SQL statement
			Statement stmt;
			stmt = con.createStatement();
			stmt.executeUpdate("insert into `proiect_pibd`.`departamente`(nume_departament, coordonator, contact, facultate) values('" + nume_departament + "', '" + coordonator + "', '" + contact + "', '" + facultate + "');");
		} catch (SQLException sqle) {
			error = "ExceptieSQL: Reactualizare nereusita; este posibil sa existe duplicate.";
			throw new SQLException(error);
		}
	}
	// end adaugaDepartament()
	
	public void adaugaProiect(int idstudent, int iddepartament, String data_predare, String tematica, String nume_proiect) throws SQLException {
		try {
			 Statement stmt;
			 stmt = con.createStatement();
			 stmt.executeUpdate("insert into `proiect_pibd`. `proiecte`(idstudent, iddepartament, data_predare, tematica, nume_proiect) values('" + idstudent + "' , '" + iddepartament + "', '" + data_predare + "', '" + tematica + "', '" + nume_proiect + "');");
		} catch (SQLException sqle) {
			error = "ExceptieSQL: Reactualizare nereusita; este posibil sa existe duplicate.";
			throw new SQLException(error);
		}
	}
	//end adaugaProiect
	
	public void stergeTabela(String tabela, String denumirePK, long id) throws SQLException, Exception {
		if (con != null) {
			try {
				// create a prepared SQL statement
				Statement stmt;
				stmt = con.createStatement();
				stmt.executeUpdate("delete from " + tabela + " where " + denumirePK + " = '" + id + "';");
			} catch (SQLException sqle) {
				error = "ExceptieSQL: Stergere nereusita; este posibil sa existe duplicate.";
				throw new SQLException(error);
			}
		} else {
			error = "Exceptie: Conexiunea cu baza de date a fost pierduta.";
			throw new Exception(error);
		}
	} // end of stergeTabela()

	public void modificaTabela(String tabela, String primarykey, long ID, String[] campuri, String[] valori)
			throws SQLException, Exception {
		String update = "update " + tabela + " set ";
		String temp = "";
		if (con != null) {
			try {
				for (int i = 0; i < campuri.length; i++) {
					if (i != (campuri.length - 1)) {
						temp = temp + campuri[i] + "='" + valori[i] + "', ";
					} else {
						temp = temp + campuri[i] + "='" + valori[i] + "' where " + primarykey + " = '" + ID + "';";
					}
				}
				update = update + temp;
				// create a prepared SQL statement
				Statement stmt;
				stmt = con.createStatement();

				stmt.executeUpdate(update);
			} catch (SQLException sqle) {
				error = "ExceptieSQL: Reactualizare nereusita; este posibil sa existe duplicate.";
				throw new SQLException(error);
			}
		} else {
			error = "Exceptie: Conexiunea cu baza de date a fost pierduta.";
			throw new Exception(error);
		}
	} // end of modificaTabela()


	
	public void modificaStudent(String nume_stud, String prenume_stud, String nr_matricol, String email, String an_studiu, int idstudent) throws SQLException {
		try {
			// create a prepared SQL statement
			Statement stmt;
			stmt = con.createStatement();
			stmt.executeUpdate("UPDATE studenti SET nume_stud='" + nume_stud + "', prenume_stud='" + prenume_stud + "', nr_matricol='" + nr_matricol + "', email='" + email + "', an_studiu= '" + an_studiu + "' WHERE (idstudent='"+ idstudent +"');");
		} catch (SQLException sqle) {
			error = "ExceptieSQL: Reactualizare nereusita; este posibil sa existe duplicate.";
			throw new SQLException(error);
		}
	}
		
	
	public void modificaDepartament(String nume_departament, String coordonator, String contact, String facultate, int iddepartament) throws SQLException {
		try {
			// create a prepared SQL statement
			Statement stmt;
			stmt = con.createStatement();
			stmt.executeUpdate("UPDATE departamente SET nume_departament='" + nume_departament + "', coordonator='" + coordonator + "', contact='" +contact + "', facultate='" + facultate + "' WHERE (iddepartament='"+ iddepartament +"');");
		} catch (SQLException sqle) {
			error = "ExceptieSQL: Reactualizare nereusita; este posibil sa existe duplicate.";
			throw new SQLException(error);
		}
	}
	
	public void modificaProiect(String data_predare, String tematica, String nume_proiect,int idproiect,int idstudent, int iddepartament) throws SQLException {
		try {
			// create a prepared SQL statement
			Statement stmt;
			stmt = con.createStatement();
			stmt.executeUpdate("UPDATE proiecte SET data_predare='" + data_predare + "', tematica='" + tematica + "', nume_proiect='" + nume_proiect + "' WHERE (iddepartament='"+ iddepartament +"' AND idstudent= '" + idstudent + "'AND idproiect='" + idproiect + "');");
		} catch (SQLException sqle) {
			error = "ExceptieSQL: Reactualizare nereusita; este posibil sa existe duplicate.";
			throw new SQLException(error);
		}
	}
	
	
	public void afisare(ResultSet rs) throws ClassNotFoundException, SQLException, Exception{
		int idstudent;
		String nume_stud, prenume_stud, nr_matricol, email, an_studiu;
		while(rs.next()){
			idstudent = rs.getInt("idstudent");
			nume_stud = rs.getString("nume_stud");
			prenume_stud = rs.getString("prenume_stud");
			nr_matricol = rs.getString("nr_matricol");
			email = rs.getString("email");
			an_studiu = rs.getString("an_studiu");
			
			System.out.println("idstudent = " + idstudent + ", nume_stud = " + nume_stud + ", prenume_stud = " + prenume_stud + ", nr_matricol = " + nr_matricol + ", email = " + email + ", an_studiu = " + an_studiu);
		}
	}
	
	
}