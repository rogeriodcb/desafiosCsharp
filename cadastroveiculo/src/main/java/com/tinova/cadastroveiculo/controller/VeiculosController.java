package com.tinova.cadastroveiculo.controller;

import com.tinova.cadastroveiculo.DTO.MessageResponseDTO;
import com.tinova.cadastroveiculo.model.Veiculos;
import com.tinova.cadastroveiculo.service.VeiculosService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/cadastroveiculos-api/v1")
@Api(value="API REST Cooperative vote service - Vote Topic")
@CrossOrigin(origins="*")
public class VeiculosController {

	private VeiculosService veiculosService;
	
	// constructor
	@Autowired
	public VeiculosController(VeiculosService veiculosService) {
		this.veiculosService = veiculosService;
	}
	
	// Rest mappings
	@GetMapping("/veiculos")
	@ApiOperation(value = "Este método retorna todos os veículos cadastrados.")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Veiculos> all() {
		return veiculosService.findAll();
	}
	
	@GetMapping("/veiculos/{id}")
	@ApiOperation(value = "Este método retorna o veículo cujo ID foi passado.")
	@ResponseStatus(code = HttpStatus.OK)
	public Veiculos findById(@PathVariable Long id) {
		return veiculosService.findById(id);
	}
	
	/*
	@GetMapping("/votetopic/find/{q}")
	@ApiOperation(value = "Este método retorna os veículos de acordo com o parâmetro de procura passado.")
	@ResponseStatus(code = HttpStatus.OK)
	public Veiculos findBy(@PathVariable Long id) {
		return voteTopicService.findById(id);
	}
	*/

	@PostMapping("/veiculos")
	@ApiOperation(value = "Este método cria um novo registro de veiculo.")
	@ResponseStatus(code = HttpStatus.CREATED)
	public MessageResponseDTO create(@RequestBody @Valid Veiculos veiculo) {
		return veiculosService.save(veiculo);
	}

	
	@PutMapping("/veiculos/{id}")
	@ApiOperation(value = "Este método atualiza um registro de veiculo.")
	@ResponseStatus(code = HttpStatus.OK)
    public MessageResponseDTO update(@PathVariable("id") long id, @RequestBody Veiculos veiculo) throws ExecutionException, InterruptedException {

		return veiculosService.update(id,veiculo);
    }
	
	@PatchMapping("/veiculos/{id}")
	@ApiOperation(value = "Este método atualiza um registro de veiculo mas somente um campo especifico.")
	@ResponseStatus(code = HttpStatus.OK)
    public MessageResponseDTO updateField(@PathVariable("id") long id, @RequestBody Veiculos veiculo, @RequestBody String field) throws ExecutionException, InterruptedException {

		return veiculosService.updateField(id,veiculo, field);
    }

    @DeleteMapping("/veiculos/{id}")
    @ApiOperation(value = "Este método deleta um registro de veiculo.")
	@ResponseStatus(code = HttpStatus.OK)
    public MessageResponseDTO delete(@PathVariable("id") long id) throws ExecutionException, InterruptedException {

    	return veiculosService.delete(id);
    }
	
}
