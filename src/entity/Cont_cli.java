package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.apache.xerces.dom.TreeWalkerImpl;

/*
 * Classe de contatos, utilizando Hibernate para mapear o banco.
 */
@Entity
public class Cont_cli {

	@Id
	@Column
	private Integer id_Contato;

	// Relacionamento com a tabela de Clientes.
	@ManyToOne
	@JoinColumn(name = "cod_cli")
	private Clientes cliente;

	@Column(length = 150)
	private String nome;

	@Column(length = 150)
	private String telefone;

	public Integer getId_Contato() {
		return id_Contato;
	}

	public void setId_Contato(Integer id_Contato) {
		this.id_Contato = id_Contato;
	}

	public Clientes getCliente() {
		return cliente;
	}

	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}

	public String getNome() {
		return nome;

	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String gettelefone() {
		return telefone;
	}

	public void settelefone(String telefone) {
		this.telefone = telefone;
	}

	public Cont_cli() {
		// TODO Auto-generated constructor stub
	}

	public Cont_cli(Integer id_Contato, Clientes cliente, String nome, String telefone) {
		super();
		this.id_Contato = id_Contato;
		this.cliente = cliente;
		this.nome = nome;
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "Cont_cli [id_Contato=" + id_Contato + ", nome=" + nome.trim() + ", telefone=" + telefone.trim() + "]";
	}

}
