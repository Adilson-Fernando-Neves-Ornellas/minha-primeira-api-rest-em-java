package com.serratec.primeiraapi.error;


public class ErrorResponse {

    private int statusError;
    private String tituloError;
    private String mensagemError;
    private String dataError;


    // constructor 
    public ErrorResponse(int statusError, String tituloError, String mensagemError, String dataError) {
        this.statusError = statusError;
        this.tituloError = tituloError;
        this.mensagemError = mensagemError;
        this.dataError = dataError;
    }
    
    // getters and setters
    public int getStatusError() {
        return statusError;
    }
    public void setStatusError(int statusError) {
        this.statusError = statusError;
    }
    public String getTituloError() {
        return tituloError;
    }
    public void setTituloError(String tituloError) {
        this.tituloError = tituloError;
    }
    public String getMensagemError() {
        return mensagemError;
    }
    public void setMensagemError(String mensagemError) {
        this.mensagemError = mensagemError;
    }
    public String getDataError() {
        return dataError;
    }
    public void setDataError(String dataError) {
        this.dataError = dataError;
    }

    


}
