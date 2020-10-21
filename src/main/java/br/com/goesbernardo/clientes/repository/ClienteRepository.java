package br.com.goesbernardo.clientes.repository;

import br.com.goesbernardo.clientes.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Integer> {
}


