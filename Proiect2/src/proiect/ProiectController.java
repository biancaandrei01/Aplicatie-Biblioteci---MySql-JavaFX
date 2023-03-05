package proiect;

import javafx.scene.*;



import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.control.TextField;

import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;

import java.io.IOException;
import java.lang.StackWalker.Option;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.imageio.plugins.tiff.TIFFImageReadParam;
import javax.swing.event.ChangeEvent;

import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ProiectController implements Initializable {

	@FXML
	private TextField nume_autor;
	@FXML
	private TextField prenume_autor;
	@FXML
	private TextField dataNasterii_autor;

	@FXML
	private TextField nume_carte;
	@FXML
	private TextField gen_carte;
	@FXML
	private TextField dataPublicarii_carte;

	@FXML
	private TextField nume_bibl;
	@FXML
	private TextField adresa_bibl;

	@FXML
	private TableView<Autor> tabela_Autori;
	@FXML
	private Tab tab_autori;
	@FXML
	private Button buton_autor;
	@FXML
	private Button autori;
	@FXML
	private Button modify_autor;
	@FXML
	private TableColumn<Autor, Integer> IDautor;
	@FXML
	private TableColumn<Autor, String> NumeAutor;
	@FXML
	private TableColumn<Autor, String> PrenumeAutor;
	@FXML
	private TableColumn<Autor, String> DataNasterii;


	@FXML
	private TableView<Carte> tabela_Carti;
	@FXML
	private Tab tab_carti;

	@FXML
	private Button buton_carte;
	@FXML
	private Button carti;
	@FXML
	private Button modify_carte;
	@FXML
	private TableColumn<Carte, Integer> IDcarte;
	@FXML
	private TableColumn<Carte, String> NumeCarte;
	@FXML
	private TableColumn<Carte, String> Gen;
	@FXML
	private TableColumn<Carte, String> DataPublicarii;

	@FXML
	private TableView<Biblioteca> tabela_Biblioteci;
	@FXML
	private Tab tab_biblioteci;
	@FXML
	private Button buton_biblioteca;
	@FXML
	private Button biblioteci;
	@FXML
	private Button modify_biblioteca;
	@FXML
	private TableColumn<Biblioteca, Integer> IDbiblioteca;
	@FXML
	private TableColumn<Biblioteca, String> NumeBiblioteca;
	@FXML
	private TableColumn<Biblioteca, String> AdresaBiblioteca;
	@FXML
	private TableColumn<Biblioteca, Integer> idAutor_bibl;
	@FXML
	private TableColumn<Biblioteca, Integer> idCarte_bibl;

	@FXML
	private MenuButton autori_list;
	@FXML
	private MenuButton carti_list;

	private ObservableList<Autor> dateAutori;
	private ObservableList<Carte> dateCarti;
	private ObservableList<Biblioteca> dateBiblioteci;
	private ArrayList<MenuItem> items_autoriItems;
	private ArrayList<MenuItem> items_cartiItems;
	private Integer line_to_remove_id=0;
	private DBOperations jb;
	private Integer idAutor, idCarte;
	private String nume_aut_mod, prenume_mod, dataNasterii_mod;
	private String nume_carte_mod, gen_mod, dataPublicarii_mod;
	private String nume_bibl_mod, adresa_bibl_mod;
	private Integer idAutor_mod, idCarte_mod;
	@Override
	public void initialize(URL url, ResourceBundle rb) {

		jb = new DBOperations();


		tabela_Autori.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event)
			{
				line_to_remove_id = tabela_Autori.getSelectionModel().getSelectedItem().idAutorProperty().getValue();
				nume_aut_mod = tabela_Autori.getSelectionModel().getSelectedItem().NumeProperty().getValue();
				prenume_mod = tabela_Autori.getSelectionModel().getSelectedItem().PrenumeProperty().getValue();
				dataNasterii_mod = tabela_Autori.getSelectionModel().getSelectedItem().DataNasteriiProperty().getValue();
				modify_autor.setDisable(false);
				autori.setDisable(false);
			}

		});
		tabela_Carti.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event)
			{
				line_to_remove_id = tabela_Carti.getSelectionModel().getSelectedItem().idCarteProperty().getValue();
				nume_carte_mod = tabela_Carti.getSelectionModel().getSelectedItem().NumeProperty().getValue();
				gen_mod =tabela_Carti.getSelectionModel().getSelectedItem().GenProperty().getValue();
				dataPublicarii_mod = tabela_Carti.getSelectionModel().getSelectedItem().DataPublicariiProperty().getValue();
				modify_carte.setDisable(false);
				carti.setDisable(false);
			}

		});
		tabela_Biblioteci.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event)
			{
				line_to_remove_id = tabela_Biblioteci.getSelectionModel().getSelectedItem().idBibliotecaProperty().getValue();
				nume_bibl_mod = tabela_Biblioteci.getSelectionModel().getSelectedItem().NumeProperty().getValue();
				adresa_bibl_mod = tabela_Biblioteci.getSelectionModel().getSelectedItem().AdresaProperty().getValue();
				idAutor_mod = tabela_Biblioteci.getSelectionModel().getSelectedItem().idAutorProperty().getValue();
				idCarte_mod = tabela_Biblioteci.getSelectionModel().getSelectedItem().idCarteProperty().getValue();
				modify_biblioteca.setDisable(false);
				biblioteci.setDisable(false);
			}


		});

	}



	@FXML
	public void vezi_autori()  throws SQLException, Exception {
		jb = new DBOperations();
		modify_autor.setDisable(true);
		autori.setDisable(true);
		jb.connect();
		dateAutori = FXCollections.observableArrayList();

		ResultSet rs = jb.vedeTabel("autori");
		while (rs.next()) {
			dateAutori.add(new Autor(rs.getInt("idAutor"), rs.getString("Nume"), rs.getString("Prenume"), rs.getString("DataNasterii")));
		}
		IDautor.setCellValueFactory(new PropertyValueFactory<>("idAutor"));
		NumeAutor.setCellValueFactory(new PropertyValueFactory<>("Nume"));
		PrenumeAutor.setCellValueFactory(new PropertyValueFactory<>("Prenume"));
		DataNasterii.setCellValueFactory(new PropertyValueFactory<>("DataNasterii"));

		tabela_Autori.setItems(null);
		tabela_Autori.setItems(dateAutori);
		jb.disconnect();
	}

	@FXML
	private void vezi_carti() throws SQLException, Exception {
		jb.connect();
		modify_carte.setDisable(true);
		carti.setDisable(true);

		dateCarti = FXCollections.observableArrayList();
		ResultSet rs = jb.vedeTabel("carti");
		while (rs.next()) {
			dateCarti.add(new Carte(rs.getInt("idCarte"), rs.getString("Nume"), rs.getString("Gen"), rs.getString("DataPublicarii")));
		}
		IDcarte.setCellValueFactory(new PropertyValueFactory<>("idCarte"));
		NumeCarte.setCellValueFactory(new PropertyValueFactory<>("Nume"));
		Gen.setCellValueFactory(new PropertyValueFactory<>("Gen"));
		DataPublicarii.setCellValueFactory(new PropertyValueFactory<>("DataPublicarii"));

		tabela_Carti.setItems(null);
		tabela_Carti.setItems(dateCarti);
		jb.disconnect();
	}

	@FXML
	private void vezi_biblioteci() throws SQLException, Exception {
		jb.connect();
		modify_biblioteca.setDisable(true);
		biblioteci.setDisable(true);
		ResultSet aut = jb.vedeTabel("autori");
		ResultSet cart = jb.vedeTabel("carti");

		items_autoriItems = new ArrayList<MenuItem>();
		items_cartiItems = new ArrayList<MenuItem>();
		MenuItem holderItem;


		autori_list.getItems().clear();
		carti_list.getItems().clear();

		dateBiblioteci = FXCollections.observableArrayList();
		ResultSet rs = jb.vedeTabel("biblioteci");
		while (rs.next()) {
			dateBiblioteci.add(new Biblioteca(rs.getInt("idBiblioteca"), rs.getString("Nume"), rs.getString("Adresa"), rs.getInt("idAutor"),rs.getInt("idCarte")));
		}
		IDbiblioteca.setCellValueFactory(new PropertyValueFactory<>("idBiblioteca"));
		NumeBiblioteca.setCellValueFactory(new PropertyValueFactory<>("Nume"));
		AdresaBiblioteca.setCellValueFactory(new PropertyValueFactory<>("Adresa"));
		idAutor_bibl.setCellValueFactory(new PropertyValueFactory<>("idAutor"));
		idCarte_bibl.setCellValueFactory(new PropertyValueFactory<>("idCarte"));

		tabela_Biblioteci.setItems(null);
		tabela_Biblioteci.setItems(dateBiblioteci);


		while(aut.next())
		{
			holderItem = new MenuItem(aut.getString("Nume")+", id: "+String.valueOf(aut.getInt("idAutor")));
			items_autoriItems.add(holderItem);
			holderItem.setOnAction(new EventHandler<ActionEvent>() {

				public void handle(ActionEvent event)
				{
					String textString = ((MenuItem)event.getSource()).getText();
					autori_list.setText(textString);
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
					carti_list.setText(textString);
					idCarte = Integer.parseInt(textString.split(":")[1].substring(1));
				}

			});		
		}

		autori_list.getItems().addAll(items_autoriItems);
		carti_list.getItems().addAll(items_cartiItems);

		jb.disconnect();
	}
	@FXML
	private void del_Line(ActionEvent event) throws SQLException, Exception {

		jb.connect();
		String tabName = ((Button) event.getSource()).getId();
		String idName = tabName;
		if(tabName.equals("biblioteci"))
			idName = "Biblioteca";
		else if(tabName.equals("carti"))
			idName="Carte";
		else
			idName="Autor";

		jb.stergeDinTabela(tabName, "id" + idName, line_to_remove_id);

		ResultSet rs = jb.vedeTabel(tabName);

		if(tabName.equals("autori"))
		{
			vezi_autori();
		}

		if(tabName.equals("carti"))
		{
			vezi_carti();
		}

		if(tabName.equals("biblioteci"))
		{
			vezi_biblioteci();
		}


		jb.disconnect();
	}

	@FXML
	private void addToTable(ActionEvent event) throws SQLException, Exception {

		jb.connect();
		String tabName = ((Button) event.getSource()).getId();
		String idName = tabName;
		tabName = tabName.substring(6,tabName.length());
		idName = tabName;
		if(tabName.equals("biblioteca"))
		{
			if(!nume_bibl.getText().isBlank() && !adresa_bibl.getText().isBlank() && idAutor!=null && idCarte!=null)
			{
				tabName = "biblioteci";
				jb.adaugaBiblioteca(nume_bibl.getText(), adresa_bibl.getText(), idAutor, idCarte);
				vezi_biblioteci();
				nume_bibl.clear();
				adresa_bibl.clear();
				autori_list.setText("Autori");
				carti_list.setText("Carti");
			}

		}
		else if(tabName.equals("carte"))
		{	
			if(!nume_carte.getText().isBlank() && !gen_carte.getText().isBlank() && !dataPublicarii_carte.getText().isBlank())
			{
				tabName = "carti";
				jb.adaugaCarte(nume_carte.getText(), gen_carte.getText(), dataPublicarii_carte.getText());
				vezi_carti();
				nume_carte.clear();
				gen_carte.clear();
				dataPublicarii_carte.clear();
			}
		}
		else 
		{
			if(!nume_autor.getText().isBlank() && !prenume_autor.getText().isBlank() && !dataNasterii_autor.getText().isBlank())
			{
				tabName = "autori";
				jb.adaugaAutor(nume_autor.getText(), prenume_autor.getText(), dataNasterii_autor.getText());
				vezi_autori();
				nume_autor.clear();
				prenume_autor.clear();
				dataNasterii_autor.clear();
			}
		}


	}

	@FXML
	private void OpenModAutor(ActionEvent event) throws IOException
	{
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("ModificaAutor.fxml"));
			DialogPane actDialogPane = loader.load();

			AutoriDialogCon controller = loader.getController();
			controller.showData(new Autor(line_to_remove_id, nume_aut_mod, prenume_mod, dataNasterii_mod));
			Dialog<ButtonType> dialog = new Dialog<>();
			dialog.setDialogPane(actDialogPane);
			dialog.setTitle("Modifica autor");

			Optional <ButtonType> resultOptional = dialog.showAndWait() ;
			if(resultOptional.get()==ButtonType.APPLY)
			{
				vezi_autori();
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}

	}

	@FXML
	private void OpenModCarte(ActionEvent event) throws IOException
	{
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("ModificaCarte.fxml"));
			DialogPane actDialogPane = loader.load();

			CarteDialogCon controller = loader.getController();
			controller.showData(new Carte(line_to_remove_id,nume_carte_mod, gen_mod, dataPublicarii_mod));
			Dialog<ButtonType> dialog = new Dialog<>();
			dialog.setDialogPane(actDialogPane);
			dialog.setTitle("Modifica carte");

			Optional <ButtonType> resultOptional = dialog.showAndWait() ;
			if(resultOptional.get()==ButtonType.APPLY)
			{
				vezi_carti();
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}

	}

	@FXML
	private void OpenModBiblioteca(ActionEvent event) throws IOException, SQLException,Exception
	{

		jb.connect();
		ResultSet autResultSet = jb.vedeNume("autori","idAutor" , idAutor_mod);
		ResultSet cartResultSet = jb.vedeNume("carti","idCarte" , idCarte_mod);
		String numeAutor="", numeCarte="";
		while(autResultSet.next())
		{
			numeAutor =autResultSet.getString("Nume");

		}

		while(cartResultSet.next())
		{
			numeCarte =cartResultSet.getString("Nume");
		}


		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("ModificaBiblioteca.fxml"));
			DialogPane actDialogPane = loader.load();

			BiblioteciDialogCon controller = loader.getController();
			controller.SetMenuButtonText(numeAutor+", id: "+String.valueOf(idAutor_mod), numeCarte+", id: "+String.valueOf(idCarte_mod));
			controller.showData(new Biblioteca(line_to_remove_id,nume_bibl_mod, adresa_bibl_mod, idAutor_mod, idCarte_mod));

			Dialog<ButtonType> dialog = new Dialog<>();
			dialog.setDialogPane(actDialogPane);
			dialog.setTitle("Modifica biblioteca");


			Optional <ButtonType> resultOptional = dialog.showAndWait() ;
			if(resultOptional.get()==ButtonType.APPLY)
			{
				vezi_biblioteci();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		jb.disconnect();

	}




}