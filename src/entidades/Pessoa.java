package entidades;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Pessoa {
	private IntegerProperty codigo;
	private StringProperty codigo_med;
	private StringProperty nome;
	private StringProperty email;
	private StringProperty idade;
	private StringProperty telefone;
	
	public Pessoa(String nome) {
		this.nome = new SimpleStringProperty(nome);
		this.email = new SimpleStringProperty();
		this.idade = new SimpleStringProperty();
		this.codigo = new SimpleIntegerProperty();
		this.codigo_med = new SimpleStringProperty();
		this.telefone = new SimpleStringProperty();
		
	}
	public final StringProperty telefoneProperty() {
		return this.telefone;
	}
	
	public final String getTelefone() {
		return this.telefoneProperty().get();
	}
	
	public final void setTelefone(final String tel) {
		this.telefoneProperty().set(tel);
	}
	public final StringProperty codigoMedProperty() {
		return this.codigo_med;
	}
	
	public final String getCodigoMed() {
		return this.codigoMedProperty().get();
	}
	
	public final void setCodigoMed(final String codigo) {
		this.codigoMedProperty().set(codigo);
	}
	public final IntegerProperty codigoProperty() {
		return this.codigo;
	}
	
	public final int getCodigo() {
		return this.codigoProperty().get();
	}
	
	public final void setCodigo(final int codigo) {
		this.codigoProperty().set(codigo);
	}
	
	public final StringProperty nomeProperty() {
		return this.nome;
	}
	
	public final String getNome() {
		return this.nomeProperty().get();
	}
	
	public final void setNome(final String nome) {
		this.nomeProperty().set(nome);
	}
	
	public final StringProperty emailProperty() {
		return this.email;
	}
	
	public final String getEmail() {
		return this.emailProperty().get();
	}
	
	public final void setEmail(final String email) {
		this.emailProperty().set(email);
	}
	
	public final StringProperty idadeProperty() {
		return this.idade;
	}
	
	public final String getIdade() {
		return this.idadeProperty().get();
	}
	
	public final void setIdade(final String idade) {
		this.idadeProperty().set(idade);
	}
	
	
	
}
