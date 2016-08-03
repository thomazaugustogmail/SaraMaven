package br.unit.managedbean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.unit.dao.DadosPessoaisDAO;
import br.unit.entity.DadosPessoais;


@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 7765876811740798583L;

	private String cpf;
	private String password;
	private DadosPessoaisDAO dao = new DadosPessoaisDAO();
	private boolean loggedIn;
	private UsuarioWeb usuarioWeb;

	@ManagedProperty(value = "#{navigationBean}")
	private NavigationBean navigationBean;

	/**
	 * Login operation.
	 * 
	 * @return
	 */
	public String doLogin() {
		// Get every user from our sample database :)
		DadosPessoais dp = dao.findByCPF(cpf);

		loggedIn = true;
		if (dp != null) {

			usuarioWeb = new UsuarioWeb(dp.getId(), dp.getNome(), dp.getCpf(), dp.getTipo());

		}

		if (dp != null && usuarioWeb.getCpf().equals(cpf) && dp.getSenha().equals(password) && usuarioWeb.getTipo() == 1) {

			FacesMessage msg = new FacesMessage("Bem vindo ao Sara", usuarioWeb.getNome());
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
			FacesContext.getCurrentInstance().addMessage(null, msg);

			return navigationBean.redirectToTelaCoordenador();

		} else if (dp != null && usuarioWeb.getCpf().equals(cpf) && dp.getSenha().equals(password) && usuarioWeb.getTipo() == 2) {

			FacesMessage msg = new FacesMessage("Bem vindo ao Sara", usuarioWeb.getNome());
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
			FacesContext.getCurrentInstance().addMessage(null, msg);

			return navigationBean.redirectToTelaPaginaInicialProfessor();

		} else if (dp != null && usuarioWeb.getCpf().equals(cpf) && dp.getSenha().equals(password) && usuarioWeb.getTipo() == 3) {

			FacesMessage msg = new FacesMessage("Bem vindo ao Sara", usuarioWeb.getNome());
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return navigationBean.redirectToTelaPaginaInicialAluno();
		}
		// Set login ERROR
		FacesMessage msg = new FacesMessage("Erro!", "Usuario ou senha invalido.");
		msg.setSeverity(FacesMessage.SEVERITY_ERROR);
		FacesContext.getCurrentInstance().addMessage(null, msg);
		// To to login page
		return navigationBean.redirectToLogin();

	}

	/**
	 * Logout operation.
	 * 
	 * @return
	 */
	public String doLogout() {
		// Set the paremeter indicating that user is logged in to false
		loggedIn = false;
		usuarioWeb = null;
		// Set logout message
		FacesMessage msg = new FacesMessage("Obrigado por acessar o Sara.", "Volte logo!" + cpf);
		msg.setSeverity(FacesMessage.SEVERITY_INFO);
		FacesContext.getCurrentInstance().addMessage(null, msg);

		return navigationBean.redirectToLogin();
	}
	// ------------------------------
	// Getters & Setters

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public DadosPessoaisDAO getDao() {
		return dao;
	}

	public void setDao(DadosPessoaisDAO dao) {
		this.dao = dao;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public UsuarioWeb getUsuarioWeb() {
		return usuarioWeb;
	}

	public void setUsuarioWeb(UsuarioWeb usuarioWeb) {
		this.usuarioWeb = usuarioWeb;
	}

	public NavigationBean getNavigationBean() {
		return navigationBean;
	}

	public void setNavigationBean(NavigationBean navigationBean) {
		this.navigationBean = navigationBean;
	}

}
