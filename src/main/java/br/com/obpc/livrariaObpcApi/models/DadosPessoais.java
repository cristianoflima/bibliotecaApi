package br.com.obpc.livrariaObpcApi.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity(name="dados_pessoais")
public @Data class DadosPessoais implements Serializable{
	
	private static final long serialVersionUID = -5727388405712084440L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable=false, insertable=true, unique=true)
	private Integer id;
	
	@Column(nullable=false, length=50)
	private String nome; 
	
	@Column(nullable=false, length=50)
	private String logradouro;
	
	@Column(nullable=false)
	private Integer numero;
	
	@Column(nullable=false, length=20)
	private String complemento;
	
	@Column(nullable=false, length=50)
	private String bairro;
	
	@Column(nullable=false, length=20)
	private String cidade;
	
	@Column(nullable=false, length=2)
	private String uf;
	
	@Column(nullable=false, length=14)
	private String telefone;
	
	@Column(nullable=false)
	private Integer cep;
	
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private Usuario user;

}
