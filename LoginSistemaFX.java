import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginSistemaFX extends Application {

    private final String SENHA_DO_SISTEMA = "senhaTeste!";

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Login do Sistema");

        Label label = new Label("Digite a senha do sistema:");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Digite sua senha aqui");

        Button loginButton = new Button("Entrar");

        loginButton.setOnAction(e -> {
            String senhaDigitada = passwordField.getText();

            if (senhaDigitada.equals(SENHA_DO_SISTEMA)) {
                showAlert(Alert.AlertType.INFORMATION, "Sucesso", "Acesso ao sistema garantido!");
            } else {
                showAlert(Alert.AlertType.ERROR, "Erro de Login", "Senha incorreta. Acesso negado.");
            }
        });

        VBox root = new VBox(10);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(label, passwordField, loginButton);

        Scene scene = new Scene(root, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}