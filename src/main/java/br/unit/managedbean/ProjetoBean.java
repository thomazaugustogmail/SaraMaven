package br.unit.managedbean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.event.FlowEvent;

import br.unit.dao.ProjetoDAO;
import br.unit.entity.Projeto;

@ManagedBean(name = "projetobean")
@RequestScoped
public class ProjetoBean implements Serializable {

	private static final long serialVersionUID = 1505000299199425018L;
	private boolean skip;
	private Projeto p = new Projeto();
	private ProjetoDAO pDAO = new ProjetoDAO();

	public ProjetoBean() {
	}

	@ManagedProperty(value = "#{navigationBean}")
	private NavigationBean navigationBean;

	public String cadastrar(Projeto p, ServletRequest request) {
		LoginBean loginBean = (LoginBean) ((HttpServletRequest) request).getSession().getAttribute("loginBean");
		p.setCpf(loginBean.getCpf());
		p.setAprovado(false);
		if (p != null && pDAO.save(p)) {
			FacesMessage msg = new FacesMessage("Sucesso", "Cadastro efetuado com sucesso!");
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
			FacesContext.getCurrentInstance().addMessage(null, msg);

			return navigationBean.redirectToTelaPaginaInicialProfessor();
		}
		FacesMessage msg = new FacesMessage("Erro", "Contate o administrador do sistema!");
		msg.setSeverity(FacesMessage.SEVERITY_INFO);
		FacesContext.getCurrentInstance().addMessage(null, msg);

		return navigationBean.toLogin();
	}

	public String remove(Projeto p) {

		return null;
	}

	public List<Projeto> listAll() {

		List<Projeto> list = pDAO.listAll();

		return list;
	}

	public List<Projeto> findByCPF(String cpf) {

		if (cpf != null) {
			FacesMessage msg = new FacesMessage("Sucesso", "Listagem efetuado com sucesso!");
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return pDAO.projetoByProf(cpf);
		}

		FacesMessage msg = new FacesMessage("Erro", "Contate o administrador do sistema!");
		msg.setSeverity(FacesMessage.SEVERITY_INFO);
		FacesContext.getCurrentInstance().addMessage(null, msg);
		return null;
	}

	public Projeto getP() {
		return p;
	}

	public void setP(Projeto p) {
		this.p = p;
	}

	public NavigationBean getNavigationBean() {
		return navigationBean;
	}

	public void setNavigationBean(NavigationBean navigationBean) {
		this.navigationBean = navigationBean;
	}

	public ProjetoDAO getpDAO() {
		return pDAO;
	}

	public void setpDAO(ProjetoDAO pDAO) {
		this.pDAO = pDAO;
	}

	public String onFlowProcess(FlowEvent event) {
		if (skip) {
			skip = false; // reset in case user goes back
			return "confirm";
		} else {
			return event.getNewStep();
		}
	}

	public boolean isSkip() {
		return skip;
	}

	public void setSkip(boolean skip) {
		this.skip = skip;
	}

	/*
	 * public LoginBean getLoginBean() { return loginBean; }
	 * 
	 * public void setLoginBean(LoginBean loginBean) { this.loginBean =
	 * loginBean; }
	 */
}
