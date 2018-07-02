package telas;

import aplicacao.MainApp;
import dao.PessoaDAO;
import entidades.Pessoa;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class PrimeiraTelaControlador {
	@FXML
	private TableView<Pessoa> tabelaPessoa;
	@FXML
	private TableColumn<Pessoa, Number> colunaCodigo;
	@FXML
	private TableColumn<Pessoa, String> colunaNome;
	@FXML	
	private TableColumn<Pessoa, String> colunaIdade;
	@FXML
	private TableColumn<Pessoa, String> colunaCodigoMed;
	@FXML
	private TableColumn<Pessoa, String> colunaTelefone;
	@FXML
	private TableColumn<Pessoa, String> colunaEmail;
	private MainApp mainApp;
	
	public PrimeiraTelaControlador() {
		
	}
	
	@FXML
	private void initialize() {
		colunaCodigo.setCellValueFactory(c->c.getValue().codigoProperty());
		colunaNome.setCellValueFactory(c->c.getValue().nomeProperty());
		colunaIdade.setCellValueFactory(c->c.getValue().idadeProperty());
		colunaCodigoMed.setCellValueFactory(c->c.getValue().codigoMedProperty());
		colunaTelefone.setCellValueFactory(c->c.getValue().telefoneProperty());
		colunaEmail.setCellValueFactory(c->c.getValue().emailProperty());
		// limpar os detalhes
		//mostraDetalhes(null);
		
		// detectar mudanças na seleção
		//tabelaPessoa.getSelectionModel().
		//selectedItemProperty().
		//addListener((observando,valorAntigo, novoValor)->
		//mostraDetalhes(novoValor));
	}


	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;		
		PessoaDAO dao = new PessoaDAO();
		
		tabelaPessoa.setItems(dao.getListaPessoas());	
		
	}
	
	@FXML
	private void deletarPessoa() {
	
		int indiceSelecionado = tabelaPessoa.getSelectionModel()
				.getSelectedIndex();
		if(indiceSelecionado>=0) {
			//remove a pessoa do banco de dados
			PessoaDAO pdao = new PessoaDAO();
			pdao.excluir( tabelaPessoa.getItems().get(indiceSelecionado));
			
			tabelaPessoa.getItems().remove(indiceSelecionado);
		}else {
			Alert alerta = new Alert(AlertType.WARNING);
			alerta.setTitle("Nenhum registro selecionado");
			alerta.setHeaderText("Nenhuma pessoa selecionada");
			alerta.setContentText("Você deve selecionar um registro na tabela");
			alerta.showAndWait();
		}
		
	}
	
	
	@FXML
	private void cliqueNovaPessoa() {
		Pessoa pessoa = new Pessoa("");
		mainApp.mostrarAdicionarEditarPessoa(pessoa);
		//mainApp.getLista().add(pessoa);
		tabelaPessoa.getItems().add(pessoa);
		
		//recarrega os dados do BD
		PessoaDAO dao = new PessoaDAO();
		tabelaPessoa.setItems(dao.getListaPessoas());	
	//	mostraDetalhes(pessoa);
		
	}
	@FXML
	private void cliqueNovoMedico() {
		Pessoa pessoa = new Pessoa("");
		mainApp.mostrarAdicionarEditarPessoaMedico(pessoa);
		//mainApp.getLista().add(pessoa);
		tabelaPessoa.getItems().add(pessoa);
		
		//recarrega os dados do BD
		PessoaDAO dao = new PessoaDAO();
		tabelaPessoa.setItems(dao.getListaPessoas());	
		//mostraDetalhes(pessoa);
		
	}
	
	@FXML
	private void cliqueEditarPessoa() {
		Pessoa pessoa = tabelaPessoa.getSelectionModel().getSelectedItem();
		if(pessoa!=null) {
			mainApp.mostrarAdicionarEditarPessoa(pessoa);
			//mostraDetalhes(pessoa);
		}
	}
	

}
