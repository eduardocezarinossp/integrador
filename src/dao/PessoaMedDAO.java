package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import entidades.Pessoa;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PessoaMedDAO {
	// Estrutura de Dados
	private ObservableList<Pessoa> listaPessoas=FXCollections.observableArrayList();;
	
	public PessoaMedDAO() {
		//listaPessoas=FXCollections.observableArrayList();
	}
	
	public void inserir(Pessoa p) {
		Conexao con = new Conexao();
		try {
			String sql = "INSERT INTO pessoa "
					+ "(nome, email, idade) "
					+ "VALUES (?,?,?)";
			PreparedStatement prep = con.getConexao().prepareStatement(sql);
			prep.setString(1, p.getNome());
			prep.setString(2, p.getEmail());
			prep.setString(3, p.getIdade());
			prep.executeUpdate();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		con.desconecta();
	}
	public void alterar(Pessoa p) {
		Conexao con = new Conexao();
		try {
			String sql = "UPDATE pessoa SET "
					+ "nome = ?, email = ?, idade = ? "
					+ "WHERE codigo = ?";
			PreparedStatement prep = con.getConexao().prepareStatement(sql);
			prep.setString(1, p.getNome());
			prep.setString(2, p.getEmail());
			prep.setString(3, p.getIdade());
			prep.setInt(4, p.getCodigo());
			prep.executeUpdate();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		con.desconecta();
	}
	public void excluir(Pessoa p) {
		Conexao con = new Conexao();
		try {
			String sql = "DELETE FROM pessoa "
					+ "WHERE codigo = ?";
			PreparedStatement prep = con.getConexao().prepareStatement(sql);
			prep.setInt(1, p.getCodigo());
			prep.executeUpdate();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		con.desconecta();
	}
	public ObservableList<Pessoa> listar() {
		Conexao con = new Conexao();
		try {
			String sql = "SELECT * FROM pessoa "
					+ "ORDER BY nome";
			Statement prep = con.getConexao().createStatement();
			ResultSet res = prep.executeQuery(sql);
			while (res.next()) {
				//instancia o objeto pessoa pegando o seu nome do bd
				Pessoa p = new Pessoa(res.getString("nome"));
				//atribui os valores ao objeto de entidade buscando os dados no bd 
				p.setCodigo(res.getInt("codigo"));
				p.setEmail(res.getString("email"));
				p.setIdade(res.getString("idade"));
				listaPessoas.add(p);
			}
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		con.desconecta();
		
		return listaPessoas;
	}
	
	
	// SIMULAR CONSULTA DE ELEMENTOS
	public ObservableList<Pessoa> getListaPessoas(){
		//criaPessoas();
		listar();
		return listaPessoas;
	}
	/*
	private void criaPessoas() {
		Pessoa p1 = new Pessoa("Maria");
		p1.setCodigo(1);
		p1.setEmail("maria@libertas.edu.br");
		p1.setIdade("20");
		
		Pessoa p2 = new Pessoa("José");
		p2.setCodigo(2);
		p2.setEmail("jose@libertas.edu.br");
		p2.setIdade("22");
		listaPessoas.add(p1);
		listaPessoas.add(p2);
	}*/
}
