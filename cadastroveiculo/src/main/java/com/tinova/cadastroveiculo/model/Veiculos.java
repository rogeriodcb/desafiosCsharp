package com.tinova.cadastroveiculo.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "veiculo")
public class Veiculos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name="veiculo")
	@NotBlank(message="O nome do veículo é necessário.")
	@Size(max=50)
	private String veiculo;
	
	@Column(name="marca")
	@NotBlank(message="A marca do veículo é necessária.")
	@Size(max=50)
	
	private String marca;
	
	@Column(name="ano")
	private int ano;
	
	@Column(name="descricao")
	@Size(max=200)
	private String descricao;
	
	@Column(name="vendido")
	private boolean vendido;
	
	@Column(name="created")
	private LocalDateTime created;
	
	@Column(name="updated")
	private LocalDateTime updated;

}
