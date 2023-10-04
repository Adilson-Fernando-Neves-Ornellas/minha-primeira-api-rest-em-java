package com.serratec.primeiraapi.repository.FormaPagamento;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.serratec.primeiraapi.model.FormaPagamento.FormaPagamentoModel;

@Repository
public class FormaPagamentoRepository {
    
    private List<FormaPagamentoModel> listaFormaPagamento = new ArrayList<>();
    private long ultimoId = 0; 

    public List<FormaPagamentoModel> obterTodos(){
        return listaFormaPagamento;
    }

    public FormaPagamentoModel obter(Long id){
        
        FormaPagamentoModel formaPagamentoEncontrado = null;

        // for (int i=0 ;i < produtos.size(); i++){

        for (FormaPagamentoModel formaPagamento : listaFormaPagamento){
            if(formaPagamento.getIdFormaPagamento() == id){
                formaPagamentoEncontrado = formaPagamento ;
            } 
        }

        return formaPagamentoEncontrado;
    }

    public FormaPagamentoModel adicionar (FormaPagamentoModel formaPagamento){

        ultimoId++;
        formaPagamento.setIdFormaPagamento(ultimoId);
        listaFormaPagamento.add(formaPagamento);

        return formaPagamento; 
    }

    public FormaPagamentoModel atualizar (FormaPagamentoModel formaPagamento){

       listaFormaPagamento.removeIf(p -> p.getIdFormaPagamento() == formaPagamento.getIdFormaPagamento());

      listaFormaPagamento.add(formaPagamento);

        
        return formaPagamento; 
    }

    public void deletar (Long id){
        listaFormaPagamento.removeIf(p -> p.getIdFormaPagamento() == id);
    }

}
