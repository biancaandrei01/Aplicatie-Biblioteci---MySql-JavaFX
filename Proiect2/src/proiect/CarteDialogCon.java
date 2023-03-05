package proiect;

import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;

public class CarteDialogCon {

	@FXML
	private DialogPane dialogPane ;
	@FXML
	private TextField nume_carte_mod;
	@FXML
	private TextField gen_mod;
	@FXML
	private TextField dataPublicarii_mod;

	private DBOperations dbOperations;



	public void showData(Carte carte) throws SQLException, Exception
	{
		dbOperations = new DBOperations();
		dbOperations.connect();
		nume_carte_mod.setText(carte.getNume());
		gen_mod.setText(carte.getGen());
		dataPublicarii_mod.setText(carte.getDataPublicarii());

		Button applyButton = (Button)dialogPane.lookupButton(ButtonType.APPLY);
		applyButton.setOnAction(event -> {

			try {
				String[] valori = {nume_carte_mod.getText(), gen_mod.getText(), dataPublicarii_mod.getText()};

				String[] campuri = {"Nume", "Gen", "DataPublicarii"};

				dbOperations.modificaTabela("carti", "idCarte", carte.getIdCarte(), campuri,valori );
				dbOperations.disconnect();
				event.consume();
			} catch (Exception e) {
				e.printStackTrace();
			}


		});

	}

}
