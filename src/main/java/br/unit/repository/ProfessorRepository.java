package br.unit.repository;


public interface ProfessorRepository<DadosPessoais> extends GenericRepository<DadosPessoais> {
	
	public DadosPessoais findByCPF(String cpf);
}
