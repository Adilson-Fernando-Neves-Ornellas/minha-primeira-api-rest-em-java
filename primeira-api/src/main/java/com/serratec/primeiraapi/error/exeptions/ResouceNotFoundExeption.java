package com.serratec.primeiraapi.error.exeptions;

public class ResouceNotFoundExeption extends RuntimeException {
    
    private static final long serialVersionUID = 1L;

    public ResouceNotFoundExeption (String mensagem){
        super(mensagem);
    }

}
