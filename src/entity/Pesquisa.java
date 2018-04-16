package entity;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Pesquisa{

	@Id
	@Column
	@SequenceGenerator(name = "pesq_id_seq", sequenceName = "pesq_id_seq")
	@GeneratedValue(generator = "pesq_id_seq", strategy = GenerationType.AUTO)
	private Integer idPesquisa;
	@Column
	private String nome;
	@Column
	private String cargo;
	@Column
	private Boolean resp1;
	@Column
	private String obs_resp1;
	@Column
	private Boolean resp2;
	@Column
	private String obs_resp2;
	@Column
	private Boolean resp3;
	@Column
	private String obs_resp3;
	@Column
	private Boolean resp4;
	@Column
	private Boolean obs_resp4_cons_equi;
	@Column
	private Boolean obs_resp4_ent_med;
	@Column
	private Boolean obs_resp4_pro_med;
	@Column
	private Integer resp5_1;
	@Column
	private Integer resp5_2;
	@Column
	private Integer resp5_3;
	@Column
	private Integer resp5_4;
	@Column
	private String resp6;

	@ManyToOne
	@JoinColumn(name = "id_funcionario")
	private Funcionario funcionario;

	@OneToOne
	@JoinColumn(name = "cod_cli")
	private Clientes clientes;

	


	public Pesquisa() {
		
	}

	public Integer getIdPesquisa() {
		return idPesquisa;
	}

	
	public Boolean getResp2() {
		return resp2;
	}

	public void setResp2(Boolean resp2) {
		this.resp2 = resp2;
	}

	public String getObs_resp2() {
		return obs_resp2;
	}

	public void setObs_resp2(String obs_resp2) {
		this.obs_resp2 = obs_resp2;
	}

	public Boolean getResp3() {
		return resp3;
	}

	public void setResp3(Boolean resp3) {
		this.resp3 = resp3;
	}

	public String getObs_resp3() {
		return obs_resp3;
	}

	public void setObs_resp3(String obs_resp3) {
		this.obs_resp3 = obs_resp3;
	}

	public Boolean getResp4() {
		return resp4;
	}

	public void setResp4(Boolean resp4) {
		this.resp4 = resp4;
	}



	public Integer getResp5_1() {
		return resp5_1;
	}

	public void setResp5_1(Integer resp5_1) {
		this.resp5_1 = resp5_1;
	}

	public Integer getResp5_2() {
		return resp5_2;
	}

	public void setResp5_2(Integer resp5_2) {
		this.resp5_2 = resp5_2;
	}

	public Integer getResp5_3() {
		return resp5_3;
	}

	public void setResp5_3(Integer resp5_3) {
		this.resp5_3 = resp5_3;
	}

	public Integer getResp5_4() {
		return resp5_4;
	}

	public void setResp5_4(Integer resp5_4) {
		this.resp5_4 = resp5_4;
	}
	

	public String getResp6() {
		return resp6;
	}

	public void setResp6(String resp6) {
		this.resp6 = resp6;
	}

	public void setIdPesquisa(Integer idPesquisa) {
		this.idPesquisa = idPesquisa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Boolean getResp1() {
		return resp1;
	}

	public void setResp1(Boolean resp1) {
		this.resp1 = resp1;
	}

	public String getObs_resp1() {
		return obs_resp1;
	}

	public void setObs_resp1(String obs_resp1) {
		this.obs_resp1 = obs_resp1;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public Clientes getClientes() {
		return clientes;
	}

	public void setClientes(Clientes clientes) {
		this.clientes = clientes;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Boolean getObs_resp4_cons_equi() {
		return obs_resp4_cons_equi;
	}

	public void setObs_resp4_cons_equi(Boolean obs_resp4_cons_equi) {
		this.obs_resp4_cons_equi = obs_resp4_cons_equi;
	}

	public Boolean getObs_resp4_ent_med() {
		return obs_resp4_ent_med;
	}

	public void setObs_resp4_ent_med(Boolean obs_resp4_ent_med) {
		this.obs_resp4_ent_med = obs_resp4_ent_med;
	}

	public Boolean getObs_resp4_pro_med() {
		return obs_resp4_pro_med;
	}

	public void setObs_resp4_pro_med(Boolean obs_resp4_pro_med) {
		this.obs_resp4_pro_med = obs_resp4_pro_med;
	}


	

}
