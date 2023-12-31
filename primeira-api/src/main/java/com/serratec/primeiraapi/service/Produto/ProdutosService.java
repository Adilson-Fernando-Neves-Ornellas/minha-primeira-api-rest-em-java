package com.serratec.primeiraapi.service.Produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serratec.primeiraapi.error.exeptions.ResouceNotFoundExeption;
import com.serratec.primeiraapi.model.Produto.ProdutosModel;
import com.serratec.primeiraapi.repository.Produto.ProdutosRepository;

@Service
public class ProdutosService {
    
    @Autowired 
    private ProdutosRepository produtosRepositoryAction;

    public List<ProdutosModel> obterTodos(){
        return produtosRepositoryAction.obterTodos();
    }

    public ProdutosModel obter(Long id){
        ProdutosModel produto = produtosRepositoryAction.obter(id);
        if(produto==null){
            throw new ResouceNotFoundExeption(id + " do produto não encontrado");
        }
        return produto;
    }

    public ProdutosModel adicionar (ProdutosModel produto){ 
        return produtosRepositoryAction.adicionar(produto);
    }

    public ProdutosModel atualizar (long id, ProdutosModel produto){

        ProdutosModel produtoEncontrado = produtosRepositoryAction.obter(id);
        if(produtoEncontrado == null){
            throw new ResouceNotFoundExeption("Erro ao tentar atualizar: "+ id + " do produto não encontrado");
        }
        produto.setIdProduto(id);
        return produtosRepositoryAction.atualizar(produto);
    }

    public void deletar (Long id){
        produtosRepositoryAction.deletar(id);
    }

}
