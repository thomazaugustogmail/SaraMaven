package br.unit.managedbean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.unit.dao.DadosPessoaisDAO;
import br.unit.entity.DadosPessoais;

@ManagedBean(name = "AvaliadorBean")
@RequestScoped
public class AvaliadorBean implements Serializable {

	private static final long serialVersionUID = -6968536174266750200L;

	private DadosPessoais dP = new DadosPessoais();
	private DadosPessoaisDAO dpDAO = new DadosPessoaisDAO();

	public AvaliadorBean() {
	}

	@ManagedProperty(value = "#{navigationBean}")
	private NavigationBean navigationBean;

	public String cadastrar(DadosPessoais dp) {

		dp.setTipo(4);
		if (dp != null && dpDAO.save(dp)) {
			FacesMessage msg = new FacesMessage("Sucesso", "Cadastro efetuado com sucesso!");
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
			FacesContext.getCurrentInstance().addMessage(null, msg);

			return navigationBean.redirectToTelaCoordenador();
		}
		FacesMessage msg = new FacesMessage("Erro", "Contate o administrador do sistema!");
		msg.setSeverity(FacesMessage.SEVERITY_INFO);
		FacesContext.getCurrentInstance().addMessage(null, msg);

		return navigationBean.toLogin();
	}

	public String remover(DadosPessoais dp) {

		if (dp != null && dpDAO.remover(dP)) {
			FacesMessage msg = new FacesMessage("Erro", "Contate o administrador do sistema!");
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return navigationBean.redirectToLogin();
		}
		FacesMessage msg = new FacesMessage("Sucesso", "Cadastro efetuado com sucesso!");
		msg.setSeverity(FacesMessage.SEVERITY_INFO);
		FacesContext.getCurrentInstance().addMessage(null, msg);

		return navigationBean.toLogin();
	}

	public DadosPessoais getdP() {
		return dP;
	}

	public void setdP(DadosPessoais dP) {
		this.dP = dP;
	}

	public DadosPessoaisDAO getDpDAO() {
		return dpDAO;
	}

	public void setDpDAO(DadosPessoaisDAO dpDAO) {
		this.dpDAO = dpDAO;
	}
}
