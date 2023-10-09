package com.serratec.primeiraapi.controller.FormaPagamento;

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

import com.serratec.primeiraapi.model.FormaPagamento.FormaPagamentoModel;
import com.serratec.primeiraapi.service.FormaPagamento.FormaPagamentoService;

@RestController
@RequestMapping("/api/pagamento")
public class FormaPagamentoController {

         
    @Autowired
    private FormaPagamentoService formaPagamentoServiceAction;

    @GetMapping
    public ResponseEntity<List<FormaPagamentoModel>> obterTodos(){
        List<FormaPagamentoModel> listaFormaPag = formaPagamentoServiceAction.obterTodos();
        return  ResponseEntity.ok(listaFormaPag);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FormaPagamentoModel> obter(@PathVariable Long id){
        return ResponseEntity.ok(formaPagamentoServiceAction.obter(id));
    }

    @PostMapping
    public ResponseEntity<FormaPagamentoModel> adicionar (@RequestBody FormaPagamentoModel formaPagamento){ 
        FormaPagamentoModel formaAdicionado = formaPagamentoServiceAction.adicionar(formaPagamento);
        return new ResponseEntity<>(formaAdicionado, HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<FormaPagamentoModel> atualizar (@PathVariable long id, @RequestBody FormaPagamentoModel formaPagamento){
        FormaPagamentoModel formaAtualizado = formaPagamentoServiceAction.atualizar(id, formaPagamento);
        return ResponseEntity.ok(formaAtualizado);        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar (@PathVariable Long id){
        formaPagamentoServiceAction.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
