package br.com.obpc.livrariaObpcApi.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity(name="livro")
public @Data class  Livro implements Serializable{
	
	private static final long serialVersionUID = 7159288832244967662L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable=false, insertable=true, unique=true)
	private Integer id;
	
	@Column(nullable=false, length=50)
	private String titulo;
	
	@Column(nullable=false, length=50)
	private String autor;
	
	@Column(nullable=false, length=50)
	private String editora;
	
	@Column(nullable=false, length=4)
	private Integer ano;
	
	@Column(nullable=false, length=500)
	private String resumo;
	
	@Column(nullable=false, length=50)
	private String tema;
	
	@Column(nullable=false)
	private Integer quantidade;
	
	@Column(nullable=false)
	private Integer livrariaId;
	
	
	public boolean isNull() {
		if(this.getId() != null)
			return false;
		
		else if(this.getAno() != null)
			return false;
		
		else if(this.getAutor() != null)
			return false;
		
		else if(this.getEditora() != null)
			return false;
		
		else if(this.getLivrariaId() != null)
			return false;
		
		else if(this.getResumo() != null)
			return false;
		
		else if(this.getTema() != null)
			return false;
		
		else if(this.getTitulo() != null)
			return false;
		
		else
			return true;
		
	}
	 
	
}
