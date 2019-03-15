package com.sistemas.embarcados.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.sistemas.embarcados.enums.StatusEnum;

@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames="placa", name="placa_uk"))
public class Veiculo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String placa;
	private StatusEnum status;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="veiculos_seq")
	@SequenceGenerator(allocationSize=1, name="veiculos_seq", sequenceName="veiculos_seq")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	@Enumerated(EnumType.STRING)
	public StatusEnum getStatus() {
		return status;
	}
	public void setStatus(StatusEnum status) {
		this.status = status;
	}
	
	

}
