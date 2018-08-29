package br.com.obpc.livrariaObpcApi.reponse;

import java.util.List;

import lombok.Data;

public @Data class ResponseDto {
	
	private String mensagem;
	private int status;
	private List<?> lista;
	private boolean sucesso;
	private Object item;

}
