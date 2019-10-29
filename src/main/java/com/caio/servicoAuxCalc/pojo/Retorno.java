package com.caio.servicoAuxCalc.pojo;

public class Retorno {
	
	private int retorno;
	private String servidor;

	public Retorno(int i, String s) {
		this.retorno = i;
		this.servidor = s;
	}
	
	public Retorno() {

	}

	public int getRetorno() {
		return retorno;
	}

	public void setRetorno(int retorno) {
		this.retorno = retorno;
	}

	public String getServidor() {
		return servidor;
	}

	public void setServidor(String servidor) {
		this.servidor = servidor;
	}

}
