module Proiect2 {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	requires java.desktop;
	
	opens proiect to javafx.graphics, javafx.fxml, javafx.base;
}
