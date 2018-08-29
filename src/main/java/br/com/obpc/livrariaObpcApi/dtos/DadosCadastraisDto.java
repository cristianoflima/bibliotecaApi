package br.com.obpc.livrariaObpcApi.dtos;

import java.io.Serializable;

import lombok.Data;

public @Data class DadosCadastraisDto implements Serializable{

	private static final long serialVersionUID = -3181775598947278667L;

	private String email;
	private String senha;
	private String nome;
	private String fone;
	private String logradouro;
	private Integer numero;
	private String complemento;
	private Integer cep; 
	private String bairro;
	private String cidade;
	private String uf;
	private Integer status;
	
}
