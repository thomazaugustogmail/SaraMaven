package br.unit.managedbean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.unit.dao.DadosPessoaisDAO;
import br.unit.entity.DadosPessoais;

@ManagedBean(name = "ProfessorBean")
@RequestScoped
public class ProfessorBean implements Serializable {

	private static final long serialVersionUID = -7470206337508559708L;

	private DadosPessoais dP = new DadosPessoais();
	private DadosPessoaisDAO dpDAO = new DadosPessoaisDAO();
	

	
	public ProfessorBean() {
	}

	@ManagedProperty(value = "#{navigationBean}")
	private NavigationBean navigationBean;

	/**
	 * Método para cadastro dos professor
	 * 
	 * @param dp
	 *            <- Objeto que vem da View cadastro_prof.jsf com os dados
	 *            preenchidos
	 * @return Retorna para tela de login
	 */
	public String cadastrar(DadosPessoais dp) {

		dp.setTipo(2);
		if (dp != null && dpDAO.save(dp)) {
			FacesMessage msg = new FacesMessage("Sucesso", "Cadastro efetuado com sucesso!");
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
			FacesContext.getCurrentInstance().addMessage(null, msg);

			return navigationBean.redirectToLogin();
		}
		FacesMessage msg = new FacesMessage("Erro", "Contate o administrador do sistema!");
		msg.setSeverity(FacesMessage.SEVERITY_INFO);
		FacesContext.getCurrentInstance().addMessage(null, msg);

		return navigationBean.toLogin();
	}	
	

	public String remover(DadosPessoais dp) {
		/*
		 * if (dp != null && dpDAO.remover(dP)) { FacesContext context =
		 * FacesContext.getCurrentInstance(); context.addMessage(null, new
		 * FacesMessage("Sucesso", "Remoção efetuada com sucesso!")); return
		 * navigationBean.redirectToLogin(); }
		 */
		return navigationBean.toLogin();
	}

	public DadosPessoais getProfessor(String cpf) {
		// if (cpf != null) {return dpDAO.findByCPF(cpf);}
		return null;
	}

	public DadosPessoaisDAO getDpDAO() {
		return dpDAO;
	}

	public void setDpDAO(DadosPessoaisDAO dpDAO) {
		this.dpDAO = dpDAO;
	}

	public DadosPessoais getdP() {
		return dP;
	}

	public void setdP(DadosPessoais dP) {
		this.dP = dP;
	}

	public NavigationBean getNavigationBean() {
		return navigationBean;
	}

	public void setNavigationBean(NavigationBean navigationBean) {
		this.navigationBean = navigationBean;
	}	
}
