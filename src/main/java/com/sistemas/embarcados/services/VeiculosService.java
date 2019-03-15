package com.sistemas.embarcados.services;

import java.util.List;

import com.sistemas.embarcados.entities.Veiculo;

public interface VeiculosService {
	Veiculo findVeiculoByPlaca(String placa);
	
	List<Veiculo> findAll();
	
	Veiculo findByPlaca(String placa);

	Veiculo createOrUpdate(Veiculo veiculo);

}
