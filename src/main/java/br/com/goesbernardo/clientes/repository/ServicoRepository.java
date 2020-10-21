package br.com.goesbernardo.clientes.repository;

import br.com.goesbernardo.clientes.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico,Integer> {
}


