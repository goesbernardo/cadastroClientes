package br.com.goesbernardo.clientes.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.logging.Logger;

@Data
@Entity(name = "cliente")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false,length = 150)
    private String nome;
    @Column(nullable = false,length = 11)
    private String cpf;
    @Column(name = "data_cadastro")
    private LocalDate dataCadastro;

    @PrePersist
    public void prePersit(){
        setDataCadastro(LocalDate.now());
    }









}
