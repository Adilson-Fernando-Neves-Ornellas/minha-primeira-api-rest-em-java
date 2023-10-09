package com.serratec.primeiraapi.service.Cliente;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serratec.primeiraapi.error.exeptions.ResouceNotFoundExeption;
import com.serratec.primeiraapi.model.Cliente.ClienteModel;
import com.serratec.primeiraapi.repository.Cliente.ClienteRepository;

@Service
public class ClienteService {

    @Autowired 
    private ClienteRepository clienteRepositoryAction;

    public List<ClienteModel> obterTodos(){
        return clienteRepositoryAction.obterTodos();
    }

    public ClienteModel obter(Long id){
        ClienteModel cliente = clienteRepositoryAction.obter(id);
        if(cliente==null){
            throw new ResouceNotFoundExeption(id + " do cliente não encontrado");
        }
        return cliente;
    }

    public ClienteModel adicionar (ClienteModel cliente){ 
        return clienteRepositoryAction.adicionar(cliente);
    }

    public ClienteModel atualizar (long id, ClienteModel cliente){

        ClienteModel clienteEncontrado = clienteRepositoryAction.obter(id);
        if(clienteEncontrado == null){
            throw new ResouceNotFoundExeption("Erro ao tentar atualizar: "+ id + " do cliente não encontrado");
        }
        cliente.setIdCliente(id);
        return clienteRepositoryAction.atualizar(cliente);
    }

    public void deletar (Long id){
        clienteRepositoryAction.deletar(id);
    }

}
