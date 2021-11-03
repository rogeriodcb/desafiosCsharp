package com.tinova.cadastroveiculo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tinova.cadastroveiculo.DTO.MessageResponseDTO;
import com.tinova.cadastroveiculo.exception.VeiculosException;
import com.tinova.cadastroveiculo.model.Veiculos;
import com.tinova.cadastroveiculo.repository.VeiculosRepository;

@Service
public class VeiculosService {

	private VeiculosRepository veiculosRepository;
	
	// constructor
	@Autowired
	public VeiculosService(VeiculosRepository veiculoRepository) {
	       this.veiculosRepository = veiculoRepository;
	}
	
	// retorna todos os veiculos
	public List<Veiculos> findAll() {
	       return veiculosRepository.findAll();
	}
	
	
    // retorna o veiculo pelo seu Id
    public Veiculos findById(Long id) {
        Optional<Veiculos> findById = veiculosRepository.findById(id);
        if(!findById.isPresent()){
            throw new VeiculosException("Id was not found.");
        }
        return findById.get();
    }
    
	/*
	// retorna o veiculo atraves da procura selecionada ... 
    public Veiculos findById(Long id) {
        Optional<Veiculos> findById = veiculosRepository.findById(id);
        if(!findById.isPresent()){
            throw new VeiculosException("Id was not found.");
        }
        return findById.get();
    }
    */
    
    // salva um registro
    public MessageResponseDTO save(final Veiculos veiculo) {
    	Veiculos savedVeiculo = veiculosRepository.save(veiculo);
		return MessageResponseDTO.builder()
				.message("Registro salvo com o ID " + savedVeiculo.getId())
				.build();
    }

    // atualiza um registro
    public MessageResponseDTO update(Long id,Veiculos veiculo) {
    	
    	Optional<Veiculos> dadosVeiculo = veiculosRepository.findById(id);
        if(dadosVeiculo.isPresent())
        {
        	Veiculos _veiculo = dadosVeiculo.get();
        	_veiculo.setVeiculo(veiculo.getVeiculo());
        	_veiculo.setMarca(veiculo.getMarca());
        	_veiculo.setAno(veiculo.getAno());
        	_veiculo.setDescricao(veiculo.getDescricao());
        	_veiculo.setVendido(veiculo.isVendido());
        	_veiculo.setCreated(veiculo.getCreated());
        	_veiculo.setUpdated(veiculo.getUpdated());
        	veiculosRepository.save(_veiculo);
        	return MessageResponseDTO.builder()
    				.message("Registro atualizado com o ID " + _veiculo.getId())
    				.build();
        }
        else
        {
            throw new VeiculosException("O ID não foi encontrado.");
        }
    }
    
    // atualiza um campo de um registro
    public MessageResponseDTO updateField(Long id,Veiculos veiculo,String field) {
    	
    	Optional<Veiculos> dadosVeiculo = veiculosRepository.findById(id);
        if(dadosVeiculo.isPresent())
        {
        	Veiculos _veiculo = dadosVeiculo.get();
        	
        	switch(field) {
        	case "veiculo":
        		_veiculo.setVeiculo(veiculo.getVeiculo());
        		break;
        	case "marca":
        		_veiculo.setMarca(veiculo.getMarca());
        		break;
        	case "ano":
        		_veiculo.setAno(veiculo.getAno());
        		break;
        	case "descricao":
        		_veiculo.setDescricao(veiculo.getDescricao());
        		break;
        	case "vendido":
        		_veiculo.setVendido(veiculo.isVendido());
        		break;
        	case "created":
            	_veiculo.setCreated(veiculo.getCreated());
            	break;
        	case "updated":
            	_veiculo.setUpdated(veiculo.getUpdated());
            	break;
        	}
        	
        	veiculosRepository.save(_veiculo);
        	return MessageResponseDTO.builder()
    				.message("Registro atualizado com o ID " + _veiculo.getId())
    				.build();
        }
        else
        {
            throw new VeiculosException("O ID não foi encontrado.");
        }
    }
    
    
    // deleta um registro
    public MessageResponseDTO delete(Long id) {
    	Optional<Veiculos> dadosVeiculo = veiculosRepository.findById(id);
        if(dadosVeiculo.isPresent())
        {
        	veiculosRepository.deleteById(id);
        	return MessageResponseDTO.builder()
    				.message("Registro removido com o ID " + id)
    				.build();
        }
        else
        {
        	throw new VeiculosException("O ID não foi encontrado.");
        }
        
    }
	
}
