package br.com.goesbernardo.clientes.model;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.logging.Logger;

@Data
@Entity
@Table(name = "cliente")
public class Cliente {

    private static Logger LOGGER = Logger.getLogger(Cliente.class.getName());

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false,length = 150)
    private String nome;
    @Column(nullable = false,length = 11)
    private String cpf;
    @Column
    private LocalDate dataCadastro;









}
