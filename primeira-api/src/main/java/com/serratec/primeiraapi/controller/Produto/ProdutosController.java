package com.serratec.primeiraapi.controller.Produto;

import java.util.InputMismatchException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serratec.primeiraapi.model.Produto.ProdutosModel;
import com.serratec.primeiraapi.service.Produto.ProdutosService;

@RestController
@RequestMapping("/api/produtos")
public class ProdutosController {
     
    @Autowired
    private ProdutosService produtosServiceAction;

    @GetMapping
    public List<ProdutosModel> obterTodos(){
        return produtosServiceAction.obterTodos();
    }

    @GetMapping("/{id}")
    public ProdutosModel obter(@PathVariable Long id){
        return produtosServiceAction.obter(id);
    }

    @PostMapping
    public ProdutosModel adicionar (@RequestBody ProdutosModel produto){ 
        return produtosServiceAction.adicionar(produto);
    }

    // @PostMapping
    // public ProdutosModel atualizar (long id, ProdutosModel produto){
        
    // }

    @DeleteMapping
    public void deletar (Long id){
     produtosServiceAction.deletar(id);
    }

}
