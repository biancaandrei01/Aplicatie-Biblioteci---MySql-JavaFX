package proiect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

public class BiblioteciDialogCon {

	@FXML
	private DialogPane dialogPane ;
	@FXML
	private TextField nume_bibl_mod;
	@FXML
	private TextField adresa_bibl_mod;
	@FXML
	private MenuButton idAutor_mod;
	@FXML
	private MenuButton idCarte_mod;

	private DBOperations dbOperations;
	private ArrayList<MenuItem> items_autoriItems;
	private ArrayList<MenuItem> items_cartiItems;
	private Integer idAutor, idCarte;

	public void showData(Biblioteca bibl) throws SQLException, Exception
	{

		dbOperations = new DBOperations();
		dbOperations.connect();
		nume_bibl_mod.setText(bibl.getNume());
		adresa_bibl_mod.setText(bibl.getAdresa());
		idAutor_mod.getItems().clear();
		idCarte_mod.getItems().clear();

		ResultSet aut = dbOperations.vedeTabel("autori");
		ResultSet cart = dbOperations.vedeTabel("carti");

		items_autoriItems = new ArrayList<MenuItem>();
		items_cartiItems = new ArrayList<MenuItem>();
		MenuItem holderItem;
		idAutor=bibl.getIdAutor();
		idCarte=bibl.getIdCarte();

		while(aut.next())
		{

			holderItem = new MenuItem(aut.getString("Nume")+", id: "+String.valueOf(aut.getInt("idAutor")));
			items_autoriItems.add(holderItem);
			holderItem.setOnAction(new EventHandler<ActionEvent>() {

				public void handle(ActionEvent event)
				{
					String textString = ((MenuItem)event.getSource()).getText();
					idAutor_mod.setText(textString);
					idAutor = Integer.parseInt(textString.split(":")[1].substring(1));
				}

			});		
		}

		while(cart.next())
		{
			holderItem = new MenuItem(cart.getString("Nume")+", id: "+String.valueOf(cart.getInt("idCarte")));
			items_cartiItems.add(holderItem);
			holderItem.setOnAction(new EventHandler<ActionEvent>() {

				public void handle(ActionEvent event)
				{
					String textString = ((MenuItem)event.getSource()).getText();
					idCarte_mod.setText(textString);
					idCarte = Integer.parseInt(textString.split(":")[1].substring(1));

				}

			});		
		}

		idAutor_mod.getItems().addAll(items_autoriItems);
		idCarte_mod.getItems().addAll(items_cartiItems);


		Button applyButton = (Button)dialogPane.lookupButton(ButtonType.APPLY);
		applyButton.setOnAction(event -> {

			try {

				String[] valori = {nume_bibl_mod.getText(), adresa_bibl_mod.getText(), idAutor.toString(), idCarte.toString()};

				String[] campuri = {"Nume", "Adresa", "idAutor","idCarte"};

				dbOperations.modificaTabela("biblioteci", "idBiblioteca", bibl.getIdBiblioteca(), campuri,valori );
				dbOperations.disconnect();
				event.consume();
			} catch (Exception e) {
				e.printStackTrace();
			}


		});

	}

	public void SetMenuButtonText(String t1, String t2)
	{

		idAutor_mod.setText(t1);
		idCarte_mod.setText(t2);
	}

}
