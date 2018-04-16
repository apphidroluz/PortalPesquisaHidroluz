package entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/*
 * Classe de Clientes, utilizando Hibernate para mapear o banco 
 */
@Entity
public class Clientes {

	@Id
	@Column
	private Integer codigo;

	@Column
	private Integer emp_cod;

	//Relacionamento com a tabela de contatos
	@OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER)
	private List<Cont_cli> contatos;

	
	@Column(length = 65)
	private String razsoc_nome;

	@Column(length = 65)
	private String nomfant_apel;

	@Column(length = 65)
	private String endereco;

	@Column(length = 30)
	private String bairro;

	@Column(length = 30)
	private String cidade;

	@Column(length = 2)
	private String uf;

	@Column(length = 8)
	private String cep;

	@Column
	private String contato1;
	
	@Column(length = 30)
	private String telefone;

	@Column(length = 30, unique = true)
	private String cnpj_cpf;

	@Column
	private Integer num_contr;

	@Column(length = 150)
	private String email;

	@Column
	private Boolean nao_possui_conta;
	
	@Column
	private Boolean status_pesq;
	
	

	public Boolean getStatus_pesq() {
		return status_pesq;
	}

	public void setStatus_pesq(Boolean status_pesq) {
		this.status_pesq = status_pesq;
	}

	public Boolean getNao_possui_conta() {
		return nao_possui_conta;
	}

	public void setNao_possui_conta(Boolean nao_possui_conta) {
		this.nao_possui_conta = nao_possui_conta;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getEmp_cod() {
		return emp_cod;
	}

	public void setEmp_cod(Integer emp_cod) {
		this.emp_cod = emp_cod;
	}

	public List<Cont_cli> getContatos() {
		return contatos;
	}

	public void setContatos(List<Cont_cli> contatos) {
		this.contatos = contatos;
	}

	public String getRazsoc_nome() {
		return razsoc_nome;
	}



	public void setRazsoc_nome(String razsoc_nome) {
		this.razsoc_nome = razsoc_nome;
	}

	public String getNomfant_apel() {
		return nomfant_apel;
	}

	public void setNomfant_apel(String nomfant_apel) {
		this.nomfant_apel = nomfant_apel;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCnpj_cpf() {
		return cnpj_cpf;
	}

	public void setCnpj_cpf(String cnpj_cpf) {
		this.cnpj_cpf = cnpj_cpf;
	}

	public Integer getNum_contr() {
		return num_contr;
	}

	public void setNum_contr(Integer num_contr) {
		this.num_contr = num_contr;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	



	public String getContato1() {
		return contato1;
	}

	public void setContato1(String contato1) {
		this.contato1 = contato1;
	}

	public Clientes(Integer codigo, Integer emp_cod,  String razsoc_nome,
			String nomfant_apel, String endereco, String bairro, String cidade, String uf, String cep, String telefone,
			String cnpj_cpf, Integer num_contr, String email, Boolean nao_possui_conta) {
		super();
		this.codigo = codigo;
		this.emp_cod = emp_cod;
		this.razsoc_nome = razsoc_nome;
		this.nomfant_apel = nomfant_apel;
		this.endereco = endereco;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
		this.telefone = telefone;
		this.cnpj_cpf = cnpj_cpf;
		this.num_contr = num_contr;
		this.email = email;
		this.nao_possui_conta = nao_possui_conta;
	}

	public Clientes() {
		// TODO Auto-generated constructor stub
	}




	public Clientes(Integer codigo, Integer emp_cod, String razsoc_nome, String nomfant_apel, String endereco,
			String bairro, String cidade, String uf, String cep, String contato1, String telefone, String cnpj_cpf,
			Integer num_contr, String email, Boolean nao_possui_conta, Boolean status_pesq) {
		super();
		this.codigo = codigo;
		this.emp_cod = emp_cod;
		this.razsoc_nome = razsoc_nome;
		this.nomfant_apel = nomfant_apel;
		this.endereco = endereco;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
		this.contato1 = contato1;
		this.telefone = telefone;
		this.cnpj_cpf = cnpj_cpf;
		this.num_contr = num_contr;
		this.email = email;
		this.nao_possui_conta = nao_possui_conta;
		this.status_pesq = status_pesq;
	}

	@Override
	public String toString() {
		return "Clientes [codigo=" + codigo + ", emp_cod=" + emp_cod + ", razsoc_nome="
				+ razsoc_nome + ", nomfant_apel=" + nomfant_apel + ", endereco=" + endereco + ", bairro=" + bairro
				+ ", cidade=" + cidade + ", uf=" + uf + ", cep=" + cep + ", telefone=" + telefone + ", cnpj_cpf="
				+ cnpj_cpf + ", num_contr=" + num_contr + ", email=" + email + ", nao_possui_conta=" + nao_possui_conta
				+ "]";
	}
	
	

}
