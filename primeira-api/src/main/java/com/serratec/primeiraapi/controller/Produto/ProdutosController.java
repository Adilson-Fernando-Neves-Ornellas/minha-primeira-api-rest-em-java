package com.serratec.primeiraapi.controller.Produto;

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
import com.serratec.primeiraapi.model.Produto.ProdutosModel;
import com.serratec.primeiraapi.service.Produto.ProdutosService;

@RestController
@RequestMapping("/api/produtos")
public class ProdutosController {
     
    @Autowired
    private ProdutosService produtosServiceAction;

    @GetMapping
    public ResponseEntity<List<ProdutosModel>> obterTodos(){
        List<ProdutosModel> listaProd = produtosServiceAction.obterTodos();
        return  ResponseEntity.ok(listaProd);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutosModel> obter(@PathVariable Long id){
        return ResponseEntity.ok(produtosServiceAction.obter(id));
    }

    @PostMapping
    public ResponseEntity<ProdutosModel> adicionar (@RequestBody ProdutosModel produto){ 
        ProdutosModel prodAdicionado = produtosServiceAction.adicionar(produto);
        return new ResponseEntity<>(prodAdicionado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutosModel> atualizar (@PathVariable long id, @RequestBody ProdutosModel produto){
        ProdutosModel produAtualizado = produtosServiceAction.atualizar(id, produto);
        return ResponseEntity.ok(produAtualizado);        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar (@PathVariable Long id){
        produtosServiceAction.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
