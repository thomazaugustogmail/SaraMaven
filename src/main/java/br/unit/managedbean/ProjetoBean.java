package br.unit.managedbean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FlowEvent;

import br.unit.dao.ProjetoDAO;
import br.unit.entity.Projeto;


@ManagedBean(name = "projetobean")
@SessionScoped
public class ProjetoBean implements Serializable {

	private static final long serialVersionUID = 1505000299199425018L;
	private boolean skip;
	private Projeto p = new Projeto();
	private ProjetoDAO pDAO = new ProjetoDAO();

	public ProjetoBean() {
	}

	@ManagedProperty(value = "#{navigationBean}")
	private NavigationBean navigationBean;
	
	public String cadastrar(Projeto p , LoginBean lb) {
		
		p.setCpf(lb.getCpf());
		p.setAprovado(false);
		
		if (p != null && pDAO.save(p)) {
			FacesMessage msg = new FacesMessage("Sucesso", "Cadastro efetuado com sucesso!");
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
			FacesContext.getCurrentInstance().addMessage(null, msg);

			return navigationBean.toTelaPaginaInicialProfessor();
		}
		FacesMessage msg = new FacesMessage("Erro", "Contate o administrador do sistema!");
		msg.setSeverity(FacesMessage.SEVERITY_INFO);
		FacesContext.getCurrentInstance().addMessage("Erro!", msg);

		return navigationBean.toLogin();
	}

	public String remove(Projeto p) {
		if (p != null && pDAO.remover(p)) {
			FacesMessage msg = new FacesMessage("Sucesso", "Projeto removido com sucesso");
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
			FacesContext.getCurrentInstance().addMessage("Sucesso", msg);
			return navigationBean.toTelaPaginaInicialProfessor();
		}
		FacesMessage msg = new FacesMessage("Erro", "Contate o administrador do sistema!");
		msg.setSeverity(FacesMessage.SEVERITY_INFO);
		FacesContext.getCurrentInstance().addMessage("Erro!", msg);
		return navigationBean.toTelaPaginaInicialProfessor();
	}

	public List<Projeto> listAll() {

		List<Projeto> list = pDAO.listaTodos();
		if (list != null) {
			FacesMessage msg = new FacesMessage("Sucesso", "Listagem efetuado com sucesso!");
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}else{
		FacesMessage msg = new FacesMessage("Falha", "Projetos não encontrador");
		msg.setSeverity(FacesMessage.SEVERITY_INFO);
		FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		
		return list;
	}

	public List<Projeto> findByCPF(String cpf) {
		
		cpf = "111.111.111-11";
		cpf = "222.222.222-22";
		
		if (cpf != null) {
			FacesMessage msg = new FacesMessage("Sucesso", "Projetos encontrado");
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		
		}
		
		return pDAO.projetoByProf(cpf);
		/*else{
			
		FacesMessage msg = new FacesMessage("Erro", "Proejto não encontrado!");
		msg.setSeverity(FacesMessage.SEVERITY_INFO);
		FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		return null;*/		
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

}
