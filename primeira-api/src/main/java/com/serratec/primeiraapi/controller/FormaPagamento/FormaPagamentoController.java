package com.serratec.primeiraapi.controller.FormaPagamento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serratec.primeiraapi.model.FormaPagamento.FormaPagamentoModel;
import com.serratec.primeiraapi.service.FormaPagamento.FormaPagamentoService;

@RestController
@RequestMapping("/api/formaPagamento")
public class FormaPagamentoController {

         
    @Autowired
    private FormaPagamentoService formaPagamentoServiceAction;

    @GetMapping
    public List<FormaPagamentoModel> obterTodos(){
        return formaPagamentoServiceAction.obterTodos();
    }

    @GetMapping("/{id}")
    public FormaPagamentoModel obter(@PathVariable Long id){
        return formaPagamentoServiceAction.obter(id);
    }

    @PostMapping
    public FormaPagamentoModel adicionar (@RequestBody FormaPagamentoModel formaPagamento){ 
        return formaPagamentoServiceAction.adicionar(formaPagamento);
    }

    // @PostMapping
    // public FormaPagamentoModel atualizar (long id, FormaPagamentoModel formaPagamento){
    // }

    @DeleteMapping
    public void deletar (Long id){
     formaPagamentoServiceAction.deletar(id);
    }


}
