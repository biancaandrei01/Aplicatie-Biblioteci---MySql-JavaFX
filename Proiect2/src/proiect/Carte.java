package proiect;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Carte {
	private final IntegerProperty idCarte;
	private final StringProperty Nume;
	private final StringProperty Gen;
	private final StringProperty DataPublicarii;
	public Carte(Integer idCarte, String Nume, String Gen, String DataPublicarii) {
		this.idCarte = new SimpleIntegerProperty(idCarte);
		this.Nume = new SimpleStringProperty(Nume);
		this.Gen = new SimpleStringProperty(Gen);
		this.DataPublicarii = new SimpleStringProperty(DataPublicarii);
	}
	public Integer getIdCarte() {
		return idCarte.get();
	}
	public String getNume() {
		return Nume.get();
	}
	public String getGen() {
		return Gen.get();
	}
	public String getDataPublicarii() {
		return DataPublicarii.get();
	}

	public void setIdCarte(Integer valoare) {
		idCarte.set(valoare);
	}
	public void setNume(String valoare) {
		Nume.set(valoare);
	}
	public void setGen(String valoare) {
		Gen.set(valoare);
	}
	public void setDataPublicarii(String valoare) {
		DataPublicarii.set(valoare);
	}

	public IntegerProperty idCarteProperty() {
		return idCarte;
	}
	public StringProperty NumeProperty() {
		return Nume;
	}
	public StringProperty GenProperty() {
		return Gen;
	}
	public StringProperty DataPublicariiProperty() {
		return DataPublicarii;
	}

}
