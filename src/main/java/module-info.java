module de.gfn.messageboard {
    requires javafx.controls;
    requires javafx.fxml;


    opens de.gfn.messageboard to javafx.fxml;
    exports de.gfn.messageboard;
}