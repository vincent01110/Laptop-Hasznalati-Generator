module com.main.laptop_hasznanalti {
    requires javafx.controls;
    requires javafx.fxml;
    requires kernel;
    requires layout;
    requires io;


    opens com.main.laptop_hasznalati to javafx.fxml;
    exports com.main.laptop_hasznalati;
}