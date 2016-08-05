package br.unit.managedbean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class NavigationBean implements Serializable {

	private static final long serialVersionUID = 1520318172495977648L;

	/**
	 * Redirect to login page.
	 * 
	 * @return Login page name.
	 */
	public String redirectToLogin() {
		return "/login.xhtml?faces-redirect=true";
	}

	/**
	 * Go to login page.
	 * 
	 * @return Login page name.
	 */
	public String toLogin() {
		return "/login.xhtml";
	}

	/**
	 * Redirect to info page.
	 * 
	 * @return Info page name.
	 */
	public String redirectToInfo() {
		return "/info.xhtml?faces-redirect=true";
	}

	/**
	 * Go to info page.
	 * 
	 * @return Info page name.
	 */
	public String toInfo() {
		return "/info.xhtml";
	}

	/**
	 * Redirect to welcome page.
	 * 
	 * @return Welcome page name.
	 */
	public String redirectToWelcome() {
		return "/pages/welcome.xhtml?faces-redirect=true";
	}

	/**
	 * Rediciona para pagina telaPaginaInicialCoordenador.
	 * 
	 * @return a página telaPaginaInicialCoordenador.
	 */
	public String redirectToTelaCoordenador() {
		return "/pages/coordenador/telaPaginaInicialCoordenador.xhtml?faces-redirect=true";
	}

	/**
	 * Vai para pagina telaPaginaInicialCoordenador
	 * 
	 * @return bem vindo a página telaPaginaInicialCoordenador
	 */
	public String ToTelaCoordenador() {
		return "/pages/coordenador/telaPaginaInicialCoordenador.xhtml";
	}

	/**
	 * Go to welcome page.
	 * 
	 * @return Welcome page name.
	 */
	public String toWelcome() {
		return "/welcome.xhtml";
	}

	/**
	 * 
	 * Redireciona para a tela de cadastro do professor
	 * 
	 * @return
	 */
	public String redirectToCadastroProf() {
		return "/cadastro_prof.xhtml?faces-redirect=true";
	}

	public String redirectToTelaPaginaInicialProfessor() {
		return "/pages/professor/telaPaginaInicialProfessor.xhtml?faces-redirect=true";
	}

	public String redirectToTelaSubmissaoProjeto() {
		return "/pages/professor/TelaSubmissaoProjeto.xhtml?faces-redirect=true";
	}

	public String redirectToTelaPaginaInicialAluno() {
		return "/pages/aluno/telaPaginaInicialAluno.xhtml?faces-redirect=true";
	}

	public String redirectToListagemProjetosCoorde() {
		return "/pages/coordenador/listagemProjetosCoorde.xhtml?faces-redirect=true";
	}

	public String ToListagemProjetosCoorde() {
		return "/pages/coordenador/listagemProjetosCoorde.xhtml";
	}

	public String ToListaDosAvaliadores() {
		return "/pages/coordenador/ListaDosAvaliadores.xhtml";
	}

	public String redirectToListaDosAvaliadores() {
		return "/pages/coordenador/ListaDosAvaliadores.xhtml?faces-redirect=true";
	}

	/**
	 * Vai para o cadastro do professor
	 * 
	 * @return
	 */
	public String toCadastroProf() {
		return "/cadastro_prof.xhtml";
	}

	/**
	 * Vai para o cadastro do professor
	 * 
	 * @return
	 */
	public String ToCadastroAvaliador() {
		return "/pages/coordenador/cadastro_avaliador.xhtml";
	}

	/**
	 * Vai para o cadastro do Avaliador
	 * 
	 * @return
	 */
	public String redirectToCadastroAvaliador() {
		return "/pages/coordenador/cadastro_avaliador.xhtml?faces-redirect=true";
	}
}
