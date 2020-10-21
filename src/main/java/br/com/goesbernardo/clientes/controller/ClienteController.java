package br.com.goesbernardo.clientes.controller;

import br.com.goesbernardo.clientes.model.Cliente;
import br.com.goesbernardo.clientes.repository.ClienteRepository;
import com.sun.xml.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente save(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @GetMapping("{id}")
    public Cliente findById(@PathVariable Integer id){
        //caso não encontre o cliente pelo id informado irá retornar o http status
        return clienteRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){

        clienteRepository.deleteById(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody Cliente clienteAtualizado){

        clienteRepository
                .findById(id)
                .map(cliente ->{
                cliente.setNome(clienteAtualizado.getNome());
                cliente.setCpf(clienteAtualizado.getCpf());
                return clienteRepository.save(clienteAtualizado);
            })
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }
}
