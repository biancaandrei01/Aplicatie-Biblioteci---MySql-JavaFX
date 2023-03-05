package proiect;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class AutoriDialogCon {

	@FXML
	private DialogPane dialogPane ;
	@FXML
	private TextField nume_aut_mod;
	@FXML
	private TextField prenume_mod;
	@FXML
	private TextField dataNasterii_mod;

	private DBOperations dbOperations;



	public void showData(Autor aut) throws SQLException, Exception
	{
		dbOperations = new DBOperations();
		dbOperations.connect();
		nume_aut_mod.setText(aut.getNume());

		prenume_mod.setText(aut.getPrenume());
		dataNasterii_mod.setText(aut.getDataNasterii());
		Button applyButton = (Button)dialogPane.lookupButton(ButtonType.APPLY);
		applyButton.setOnAction(event -> {

			try {
				String[] valori = {nume_aut_mod.getText(), prenume_mod.getText(), dataNasterii_mod.getText()};

				String[] campuri = {"Nume", "Prenume", "DataNasterii"};

				dbOperations.modificaTabela("autori", "idAutor", aut.getIdAutor(), campuri,valori );
				dbOperations.disconnect();
				event.consume();
			} catch (Exception e) {
				e.printStackTrace();
			}


		});

	}


}
