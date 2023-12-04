package de.gfn.messageboard;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML // Verbindet diese Eigenschaft mit der View
    private TextField name;

    @FXML
    private TextField message;

    @FXML
    private TextArea output;

    @FXML
    private Label error;

    private StringBuilder messages = new StringBuilder();

    @FXML // Macht diese Methode aufrufbar für die View
    public void save() {

        String n = name.getText();
        String m = message.getText();

        try {
            if (n.length() == 0)
                throw new RuntimeException("Name darf nicht leer sein");

            if (m.length() == 0)
                throw new RuntimeException("Nachricht darf nicht leer sein");

            messages.append(n)
                    .append(": ")
                    .append(message.getText())
                    .append("\n");

            clearFlields();
            printOutput();
        }
        catch(RuntimeException e) {
            error.setText(e.getMessage());
        }
    }

    private void clearFlields() {
        name.clear(); // Formularfeld wird geleert
        message.clear();
        error.setText(""); // Setzt ein Label zurück
    }

    private void printOutput() {
        output.setText(messages.toString()); // Inhalt des StringBuilders wird ins Formularfeld eingesetzt
    }
}