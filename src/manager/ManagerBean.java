package manager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import entity.Clientes;
import entity.Funcionario;
import entity.Pesquisa;
import persistence.ClienteDao;
import persistence.FuncionarioDao;
import persistence.PesquisaDao;

/*
 * Classe reponsável pela operações entre a tela e o servidor.
 */
@ManagedBean(name = "mb")
@SessionScoped
public class ManagerBean {

	private Clientes clientes;
	private Clientes buscado;
	private ClienteDataModel clientesPendentes;
	private List<Funcionario> funcionarios;
	private Funcionario func_selec;
	private Pesquisa pesquisa;
	private String nome;


	public List<Funcionario> getFuncionarios() {

		funcionarios = new FuncionarioDao().findAll();
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public String BuscarPendentes() throws Exception {
		return "Perguntas.jsf";
	}

	public void retornarPendentes() throws Exception {

		try {
			clientesPendentes = new ClienteDataModel(new ClienteDao().findPendente());

		} catch (Exception e) {
			System.out.println("eroo");

		}
	}

	@PostConstruct
	public void init() {
		clientes = new Clientes();
		pesquisa = new Pesquisa();
		func_selec = new Funcionario();
		funcionarios = new ArrayList<Funcionario>();
		List<Pesquisa> p = new ArrayList<>();
		funcionarios.addAll(Arrays.asList(new Funcionario(null,"",p),new Funcionario(null,"",p)));

		try {
			retornarPendentes();
		} catch (Exception e) {
		
			e.printStackTrace();
		}

	}

	public Clientes getClientes() {
		return clientes;
	}

	public void setClientes(Clientes clientes) {
		this.clientes = clientes;
	}

	public Clientes getBuscado() {
		return buscado;
	}

	public void setBuscado(Clientes buscado) {
		this.buscado = buscado;
	}
	

	public ClienteDataModel getClientesPendentes() {
		return clientesPendentes;
	}

	public void setClientesPendentes(ClienteDataModel clientesPendentes) {
		this.clientesPendentes = clientesPendentes;
	}

	public Funcionario getFunc_selec() {
		return func_selec;
	}

	public void setFunc_selec(Funcionario func_selec) {
		this.func_selec = func_selec;
	}

	public Pesquisa getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(Pesquisa pesquisa) {
		this.pesquisa = pesquisa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void gravar() {
		FacesContext fc = FacesContext.getCurrentInstance();
		
		try {
			HttpSession session = (HttpSession) fc.getExternalContext().getSession(true);
			buscado.setStatus_pesq(true);

			pesquisa.setClientes(buscado);
			pesquisa.setFuncionario(func_selec);
	
			
			new PesquisaDao().create(pesquisa);
			
			
			new ClienteDao().update(buscado);
			
			init();
			
			session = (HttpSession) fc.getExternalContext().getSession(false);
			
			fc.addMessage(null, new FacesMessage("Pesquisa gravada com sucesso!"));
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
	}
	
	public void cancelar() {
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
			
			init();
			
			fc.addMessage(null, new FacesMessage("Pesquisa cancelada!"));
			
			fc.getExternalContext().redirect("Pendencias.jsf");
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}

	// Garda o cliente na sessao e redireciona para página da pesquisa
	public void buscareIniciarPesq() {

		FacesContext fc = FacesContext.getCurrentInstance();

		try {

			HttpSession session = (HttpSession) fc.getExternalContext().getSession(true);

			// Recebe o valor digitado na tela e faz a busca das informações do
			// Cliente.
			Clientes resp = new ClienteDao().findByCode(clientes.getCodigo());

			// Se encontrar
			if (resp != null) {

				// Preenche a variavél
				buscado = resp;

				FacesContext.getCurrentInstance().getExternalContext().redirect("Perguntas.jsf");

			} else {

				// Não achou cliente zera as variaveis e da uma msg.
				clientes = new Clientes();
				buscado = null;
				fc.addMessage("form1", new FacesMessage("Este código de cliente não existe"));
			}

		} catch (Exception e) {

			fc.addMessage("form1", new FacesMessage("ERROR", e.getMessage()));
		}

	}
	
	public String getClasseEscolhida(){
        return func_selec!=null && func_selec.getIdFuncionario()!=null ? func_selec.toString():"Classe não escolhida";
    }
	

}
