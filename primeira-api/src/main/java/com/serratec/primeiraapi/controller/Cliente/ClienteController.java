package com.serratec.primeiraapi.controller.Cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serratec.primeiraapi.model.Cliente.ClienteModel;
import com.serratec.primeiraapi.service.Cliente.ClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
         
    @Autowired
    private ClienteService clientesServiceAction;

    @GetMapping
    public List<ClienteModel> obterTodos(){
        return clientesServiceAction.obterTodos();
    }

    @GetMapping("/{id}")
    public ClienteModel obter(@PathVariable Long id){
        return clientesServiceAction.obter(id);
    }

    @PostMapping
    public ClienteModel adicionar(@RequestBody ClienteModel cliente){ 
        return clientesServiceAction.adicionar(cliente);
    }

    // @PostMapping
    // public ClienteModel atualizar (long id, ClienteModel cliente){
    // }

    @DeleteMapping
    public void deletar (Long id){
     clientesServiceAction.deletar(id);
    }

}
