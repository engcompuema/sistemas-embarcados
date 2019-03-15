package com.sistemas.embarcados.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemas.embarcados.entities.Veiculo;
import com.sistemas.embarcados.repositories.VeiculosRepository;
import com.sistemas.embarcados.services.VeiculosService;

@Service
public class VeiculoServiceImpl implements VeiculosService {

	@Autowired
	private VeiculosRepository veiculoRepository;
	
	@Override
	public Veiculo findVeiculoByPlaca(String placa) {
		return this.veiculoRepository.findByPlaca(placa);
	}

	@Override
	public List<Veiculo> findAll() {
		return this.veiculoRepository.findAll();
	}

	@Override
	public Veiculo findByPlaca(String placa) {
		return this.veiculoRepository.findByPlaca(placa);
	}



}
