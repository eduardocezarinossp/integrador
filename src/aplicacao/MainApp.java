package aplicacao;




import dao.PessoaDAO;
import entidades.Pessoa;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import telas.AdicionarEditarControlador;
import telas.AdicionarEditarControladorMedico;
import telas.PrimeiraTelaControlador;

public class MainApp extends Application {
	private Stage palcoPrincipal;
	private BorderPane layoutRaiz;

	@Override
	public void start(Stage primaryStage) {
		// Stage é o palco...
		this.palcoPrincipal = primaryStage;
		this.palcoPrincipal.setTitle("Aplicação ED2");
		iniciaLayoutRaiz();  // exibir o Layout Raiz
		iniciaPrimeiraTela();
	}

	private Pane carregaLayout(String url) {
		//instanciar o carregador de fxml
		try {	
			FXMLLoader carregador = new FXMLLoader();
			carregador.setLocation(MainApp.class.getResource(url));
			return carregador.load();
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}	
	public void iniciaLayoutRaiz() {
		//instanciar o carregador de fxml
		layoutRaiz = (BorderPane)carregaLayout("../telas/LayoutRaiz.fxml");
		// criar a cena
		Scene cena = new Scene(layoutRaiz);
		palcoPrincipal.setScene(cena);
		palcoPrincipal.show();
	}
	
	public void iniciaPrimeiraTela() {
		try {
			FXMLLoader carregador = new FXMLLoader();
			String url = "../telas/PrirmeiraTela.fxml";
			carregador.setLocation(MainApp.class.getResource(url));
			
			AnchorPane primeiraTela = carregador.load();
			layoutRaiz.setCenter(primeiraTela);
			
			PrimeiraTelaControlador controlador = carregador.getController();
			controlador.setMainApp(this);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public ObservableList<Pessoa> getLista(){
		PessoaDAO dao = new PessoaDAO();
		return dao.getListaPessoas();
	}
	
	public boolean mostrarAdicionarEditarPessoa(Pessoa pessoa) {
		try {
			FXMLLoader carregador = new FXMLLoader();
			String url = "../telas/AdicionarEditarPessoa.fxml";
			carregador.setLocation(MainApp.class.getResource(url));
			
			AnchorPane dialogo = carregador.load();
			Stage palcoDialogo = new Stage();
			palcoDialogo.setTitle("Editar Pessoa");
			palcoDialogo.initModality(Modality.WINDOW_MODAL);
			palcoDialogo.initOwner(palcoPrincipal);
			
			Scene cena = new Scene(dialogo);
			palcoDialogo.setScene(cena);
			
			// Definir a pessoa no controlador
			AdicionarEditarControlador controlador = carregador.getController();
			controlador.setPalcoDialogo(palcoDialogo);
			controlador.setPessoa(pessoa);
			
			palcoDialogo.showAndWait();
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	public boolean mostrarAdicionarEditarPessoaMedico(Pessoa pessoa) {
		try {
			FXMLLoader carregador = new FXMLLoader();
			String url = "../telas/AdicionarEditarPessoaMedico.fxml";
			carregador.setLocation(MainApp.class.getResource(url));
			
			AnchorPane dialogo = carregador.load();
			Stage palcoDialogo = new Stage();
			palcoDialogo.setTitle("Editar Médico");
			palcoDialogo.initModality(Modality.WINDOW_MODAL);
			palcoDialogo.initOwner(palcoPrincipal);
			
			Scene cena = new Scene(dialogo);
			palcoDialogo.setScene(cena);
			
			// Definir a pessoa no controlador
			AdicionarEditarControladorMedico controlador = carregador.getController();
			controlador.setPalcoDialogo(palcoDialogo);
			controlador.setPessoa(pessoa);
			
			palcoDialogo.showAndWait();
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	public void alerta() {
		Alert alerta = new Alert(AlertType.INFORMATION);
		alerta.setTitle("JANELA DE ALERTA");
		alerta.setHeaderText("Cabeçalho");
		alerta.setContentText("conteúdo");
		alerta.showAndWait();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
