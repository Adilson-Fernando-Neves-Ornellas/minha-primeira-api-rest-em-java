package com.serratec.primeiraapi.repository.Cliente;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.serratec.primeiraapi.model.Cliente.ClienteModel;

@Repository
public class ClienteRepository {

    private List<ClienteModel> listaClientes = new ArrayList<>();
    private long ultimoId = 0; 

    public List<ClienteModel> obterTodos(){
        return listaClientes;
    }

    public ClienteModel obter(Long id){
        
        ClienteModel clienteEncontrado = null;

        // for (int i=0 ;i < produtos.size(); i++){

        for (ClienteModel cliente : listaClientes){
            if(cliente.getIdCliente() == id){
                clienteEncontrado = cliente ;
            } 
        }

        return clienteEncontrado;
    }

    public ClienteModel adicionar (ClienteModel cliente){

        ultimoId++;
        cliente.setIdCliente(ultimoId);
        listaClientes.add(cliente);

        return cliente; 
    }

    public ClienteModel atualizar (ClienteModel cliente){

       listaClientes.removeIf(p -> p.getIdCliente() == cliente.getIdCliente());

      listaClientes.add(cliente);

        
        return cliente; 
    }

    public void deletar (Long id){
        listaClientes.removeIf(p -> p.getIdCliente() == id);
    }

}
