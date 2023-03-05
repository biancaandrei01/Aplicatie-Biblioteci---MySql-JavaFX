package proiect;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Biblioteca {
	private final IntegerProperty idBiblioteca;
	private final StringProperty Nume;
	private final StringProperty Adresa;
	private final IntegerProperty idAutor ;
	private final IntegerProperty idCarte ;
	public Biblioteca(Integer idBiblioteca, String Nume, String Adresa, Integer idAutor, Integer idCarte) {
		this.idBiblioteca = new SimpleIntegerProperty(idBiblioteca);
		this.Nume = new SimpleStringProperty(Nume);
		this.Adresa = new SimpleStringProperty(Adresa);
		this.idAutor = new SimpleIntegerProperty(idAutor);
		this.idCarte = new SimpleIntegerProperty(idCarte);
	}
	public Integer getIdBiblioteca() {
		return idBiblioteca.get();
	}

	public String getNume() {
		return Nume.get();
	}
	public String getAdresa() {
		return Adresa.get();
	}
	public Integer getIdAutor() {
		return idAutor.get();
	}
	public Integer getIdCarte() {
		return idCarte.get();
	}

	public void setIdBiblioteca(Integer valoare) {
		idBiblioteca.set(valoare);
	}

	public void setNume(String valoare) {
		Nume.set(valoare);
	}
	public void setAdresa(String valoare) {
		Adresa.set(valoare);
	}
	public void setIdAutor(Integer valoare) {
		idAutor.set(valoare);
	}
	public void setIdCarte(Integer valoare) {
		idCarte.set(valoare);
	}
	
	public IntegerProperty idBibliotecaProperty() {
		return idBiblioteca;
	}
	public StringProperty NumeProperty() {
		return Nume;
	}
	public StringProperty AdresaProperty() {
		return Adresa;
	}
	public IntegerProperty idAutorProperty() {
		return idAutor;
	}
	public IntegerProperty idCarteProperty() {
		return idCarte;
	}
}

