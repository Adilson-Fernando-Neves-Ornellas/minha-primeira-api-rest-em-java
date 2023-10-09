package com.serratec.primeiraapi.error.exeptions;

public class ResouceBadRequestExeption extends RuntimeException {
    
    private static final long serialVersionUID = 1L;

    public ResouceBadRequestExeption (String mensagem){
        super(mensagem);
    }

}
