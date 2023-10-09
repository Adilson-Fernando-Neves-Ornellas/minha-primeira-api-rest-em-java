package com.serratec.primeiraapi.controller.Cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    public  ResponseEntity<List<ClienteModel>> obterTodos(){
        List<ClienteModel> ListaClientes = clientesServiceAction.obterTodos();
        return  ResponseEntity.ok(ListaClientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteModel> obter(@PathVariable Long id){
        return ResponseEntity.ok(clientesServiceAction.obter(id));
    }

    @PostMapping
    public ResponseEntity<ClienteModel> adicionar(@RequestBody ClienteModel cliente){ 
        ClienteModel clienteAdicionado = clientesServiceAction.adicionar(cliente);
        return new ResponseEntity<>(clienteAdicionado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteModel> atualizar (@PathVariable long id, @RequestBody ClienteModel cliente){
        ClienteModel clienteAtualizado = clientesServiceAction.atualizar(id,cliente);
        return ResponseEntity.ok(clienteAtualizado);        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>deletar (@PathVariable Long id){
     clientesServiceAction.deletar(id);
     return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
