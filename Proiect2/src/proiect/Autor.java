package proiect;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Autor {
	private final IntegerProperty idAutor;
	private final StringProperty Nume;
	private final StringProperty Prenume;
	private final StringProperty DataNasterii;
	public Autor(Integer idAutor, String Nume, String Prenume, String DataNasterii) {
		this.idAutor = new SimpleIntegerProperty(idAutor);
		this.Nume = new SimpleStringProperty(Nume);
		this.Prenume = new SimpleStringProperty(Prenume);
		this.DataNasterii = new SimpleStringProperty(DataNasterii);
	}
	public Integer getIdAutor() {
		return idAutor.get();
	}
	public String getNume() {
		return Nume.get();
	}
	public String getPrenume() {
			return Prenume.get();
	}
	public String getDataNasterii() {
		return DataNasterii.get();
	}
	public void setIdAutor(Integer valoare) {
		idAutor.set(valoare);
	}
	public void setNume(String valoare) {
		Nume.set(valoare);
	}
	public void setPrenume(String valoare) {
		Prenume.set(valoare);
	}
	public void setDataNasterii(String valoare) {
		DataNasterii.set(valoare);
	}
	public IntegerProperty idAutorProperty() {
		return idAutor;
	}
	public StringProperty NumeProperty() {
		return Nume;
	}
	public StringProperty PrenumeProperty() {
		return Prenume;
	}
	public StringProperty DataNasteriiProperty() {
		return DataNasterii;
	}
}
