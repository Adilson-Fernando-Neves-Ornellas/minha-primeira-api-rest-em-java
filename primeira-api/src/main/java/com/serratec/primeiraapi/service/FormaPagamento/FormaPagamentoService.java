package com.serratec.primeiraapi.service.FormaPagamento;

import java.util.InputMismatchException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serratec.primeiraapi.model.FormaPagamento.FormaPagamentoModel;
import com.serratec.primeiraapi.repository.FormaPagamento.FormaPagamentoRepository;

@Service
public class FormaPagamentoService {
    
    @Autowired 
    private FormaPagamentoRepository formaPagamentoRepositoryAction;

    public List<FormaPagamentoModel> obterTodos(){
        return formaPagamentoRepositoryAction.obterTodos();
    }

    public FormaPagamentoModel obter(Long id){
        FormaPagamentoModel formaPagamento = formaPagamentoRepositoryAction.obter(id);
        if(formaPagamento==null){
            throw new InputMismatchException(id + " da formaPagamento não encontrado");
        }
        return formaPagamento;
    }

    public FormaPagamentoModel adicionar (FormaPagamentoModel formaPagamento){ 
        return formaPagamentoRepositoryAction.adicionar(formaPagamento);
    }

    public FormaPagamentoModel atualizar (long id, FormaPagamentoModel formaPagamento){

        FormaPagamentoModel formaPagamentoEncontrado = formaPagamentoRepositoryAction.obter(id);
        if(formaPagamentoEncontrado == null){
            throw new InputMismatchException("Erro ao tentar atualizar: "+ id + " da formaPagamento não encontrado");
        }
        formaPagamento.setIdFormaPagamento(id);
        return formaPagamentoRepositoryAction.atualizar(formaPagamento);
    }

    public void deletar (Long id){
        formaPagamentoRepositoryAction.deletar(id);
    }

}
