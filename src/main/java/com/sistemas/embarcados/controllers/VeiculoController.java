package com.sistemas.embarcados.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemas.embarcados.entities.Veiculo;
import com.sistemas.embarcados.responses.Response;
import com.sistemas.embarcados.services.VeiculosService;

@RestController
@RequestMapping("/monitoramento")
@CrossOrigin
public class VeiculoController {

	@Autowired
	private VeiculosService veiculoService;

	@GetMapping
	public ResponseEntity<Response<List<Veiculo>>> findAll() {
		Response<List<Veiculo>> response = new Response<>();
		response.setData(veiculoService.findAll());
		return ResponseEntity.ok().body(response);

	}
	
	@GetMapping(value="{placa}")
	public ResponseEntity<Response<Veiculo>> findByPlaca(@PathVariable("placa") String placa) {
		Response<Veiculo> response = new Response<>();
		Veiculo veiculo = veiculoService.findByPlaca(placa);
		if(veiculo != null) {
			response.setData(veiculo);
			return ResponseEntity.ok().body(response);
		}else {
			response.getErrors().add("Veículo não Encontrado");
			return ResponseEntity.badRequest().body(response);
		}
	}

}
