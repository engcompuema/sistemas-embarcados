package com.sistemas.embarcados.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistemas.embarcados.entities.Veiculo;


@Repository
public interface VeiculosRepository extends JpaRepository<Veiculo, Long>{
	
	Veiculo findByPlaca(String placa);

}
