package br.com.obpc.livrariaObpcApi.reponse;



import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.Data;

public @Data class ResponseBuilder {

	protected ResponseDto response;
	
	public ResponseBuilder() {
		response = new ResponseDto();
	}
	
	public ResponseBuilder comSucesso() {
		this.response.setSucesso(true);
		this.response.setStatus(HttpStatus.OK.value());
		return this;
	}
	
	public ResponseBuilder semSucesso(Integer status) {
		this.response.setSucesso(false);
		this.response.setStatus(status);
		return this;
	}
	
	public ResponseBuilder comMensagem(String mensagem) {
		this.response.setMensagem(mensagem);
		return this;
	}
	
	public ResponseBuilder comLista(List<?> lista) {
		this.response.setLista(lista);
		return this;
	}
	
	public ResponseBuilder comItem(Object item) {
		this.response.setItem(item);
		return this;
	}
	
	public ResponseDto build() {
		return response;
	}
	
}
