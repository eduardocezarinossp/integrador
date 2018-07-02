package telas;


import dao.PessoaDAO;
import entidades.Pessoa;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AdicionarEditarControladorMedico {
	@FXML
	private TextField txtCodigo;
	@FXML
	private TextField txtNome;
	@FXML
	private TextField txtEmail;
	@FXML
	private TextField txtIdade;
	@FXML
	private TextField txtTelefone;
	private Stage palcoDialogo;
	private Pessoa pessoa;
	
	
	@FXML
	private void initialize() {
		
	}
	
	public void setPalcoDialogo(Stage palcoDialogo) {
		this.palcoDialogo = palcoDialogo;
	}
	
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
		txtCodigo.setText(String.valueOf(pessoa.getCodigo()));
		txtNome.setText(pessoa.getNome());
		txtIdade.setText(pessoa.getIdade());
	}
	@FXML
	private void cliqueOk() {
		//pessoa.setCodigo(Integer.parseInt(txtCodigo.getText()));
		pessoa.setEmail(txtEmail.getText());
		pessoa.setIdade(txtIdade.getText());
		pessoa.setNome(txtNome.getText());
		pessoa.setTelefone(txtTelefone.getText());
		pessoa.setCodigoMed("MÉDICO");
		//insere os dados no banco de dados
		PessoaDAO pdao = new PessoaDAO();
		if (pessoa.getCodigo()>0) {
			pdao.alterar(pessoa);
		} else {
			pdao.inserir(pessoa);
		}
		pdao.listar();
		
		palcoDialogo.close();
	}
	@FXML
	private void cliqueCancelar() {
		palcoDialogo.close();
	}
}
