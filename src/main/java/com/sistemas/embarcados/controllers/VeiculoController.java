package com.sistemas.embarcados.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemas.embarcados.entities.Veiculo;
import com.sistemas.embarcados.enums.StatusEnum;
import com.sistemas.embarcados.responses.Response;
import com.sistemas.embarcados.services.VeiculosService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="Monitoramento Veicular")
@RestController
@RequestMapping("/monitoramento")
@CrossOrigin

public class VeiculoController {

	@Autowired
	private VeiculosService veiculoService;

	
	@ApiOperation(value="Retorna todos os veículos cadastrados")
	@GetMapping
	public ResponseEntity<Response<List<Veiculo>>> findAll() {
		Response<List<Veiculo>> response = new Response<>();
		response.setData(veiculoService.findAll());
		return ResponseEntity.ok().body(response);

	}

	
	@ApiOperation(value="Retorna o veículo pela placa informada")
	@GetMapping(value = "{placa}")
	public ResponseEntity<Response<Veiculo>> findByPlaca(@PathVariable("placa") String placa) {
		Response<Veiculo> response = new Response<>();
		Veiculo veiculo = veiculoService.findByPlaca(placa);
		if (veiculo != null) {
			response.setData(veiculo);
			return ResponseEntity.ok().body(response);
		} else {
			veiculo = new Veiculo();
			veiculo.setPlaca(placa);
			veiculo.setStatus(StatusEnum.NAO_LIBERADO);
			response.setData(veiculo);
			return ResponseEntity.ok().body(response);
		}
	}

	
	@ApiOperation(value="Cadastra um veículo")
	@PostMapping
	public ResponseEntity<Response<Veiculo>> create(@RequestBody Veiculo veiculo) {
		Response<Veiculo> response = new Response<>();

		try {
			Veiculo veiculoPersisted = veiculoService.createOrUpdate(veiculo);
			response.setData(veiculoPersisted);
			return ResponseEntity.ok().body(response);
		} catch (Exception e) {
			response.getErrors().add(e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}

	}

	@ApiOperation(value="Atualiza um veículo")
	@PutMapping
	public ResponseEntity<Response<Veiculo>> update(@RequestBody Veiculo veiculo) {
		Response<Veiculo> response = new Response<>();
		try {
			Veiculo veiculoPersisted = veiculoService.createOrUpdate(veiculo);
			response.setData(veiculoPersisted);
			return ResponseEntity.ok().body(response);
		} catch (Exception e) {
			response.getErrors().add(e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}

	}

}
