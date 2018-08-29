package br.com.obpc.livrariaObpcApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.obpc.livrariaObpcApi.dtos.DadosCadastraisDto;
import br.com.obpc.livrariaObpcApi.interfaces.ICadastroUsuario;
import br.com.obpc.livrariaObpcApi.reponse.ResponseBuilder;
import br.com.obpc.livrariaObpcApi.reponse.ResponseDto;

@Controller
@RequestMapping("/cadastro")
public class CadastroController {
	
	@Autowired
	ICadastroUsuario service;
	
	@PostMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseDto cadastroUsuario(@RequestBody DadosCadastraisDto dados) {
		try {
			return service.cadastrarUsuario(dados);
		} catch (Exception e) {
			return new ResponseBuilder().semSucesso(HttpStatus.INTERNAL_SERVER_ERROR.value()).comMensagem("Erro ao cadastrar usuario, ERROR_MSG: "+e.getMessage()).build();
		}
	}

}
