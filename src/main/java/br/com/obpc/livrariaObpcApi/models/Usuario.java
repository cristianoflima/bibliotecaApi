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

@Entity(name="user")
public @Data class Usuario implements Serializable{

	private static final long serialVersionUID = -6151314253311566676L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable=false, insertable=true, unique=true)
	private Integer id;
	
	@Column(nullable=false, unique=true, length=255)
	private String email;
	
	@Column(nullable=false, length=255)
	private String password;
	
	@Column(nullable=false)
	private Integer status;
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	private DadosPessoais dadosPessoais;

}
