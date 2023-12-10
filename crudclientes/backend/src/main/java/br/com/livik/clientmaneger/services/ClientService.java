package br.com.livik.clientmaneger.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.livik.clientmaneger.dtos.ClientDTO;
import br.com.livik.clientmaneger.entities.Client;
import br.com.livik.clientmaneger.repositories.ClientRepository;
import br.com.livik.clientmaneger.services.exceptions.EntityNotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;
	
	@Transactional(readOnly = true)
	public ClientDTO getClientById(Long id) {
		Optional<Client> entity = repository.findById(id);
		return new ClientDTO(entity.orElseThrow(()-> new EntityNotFoundException("Cliente nao encontrado")));
	}
	
	@Transactional(readOnly = true)
	public Page<ClientDTO> getAllClientPaged(PageRequest request) {
		Page<Client> page = repository.findAll(request);
		return page.map(entity -> new ClientDTO(entity));
	}
	
	@Transactional
	public ClientDTO insert(ClientDTO dto) {
		Client client = new Client(dto);
		return new ClientDTO(repository.save(client));
	}
	
	@Transactional
	public ClientDTO update(Long id, ClientDTO dto) {
		try {
			Client client = repository.getReferenceById(id);
			client = new Client(dto);
			return new ClientDTO(repository.save(client));
		} catch (jakarta.persistence.EntityNotFoundException e) {
			throw new EntityNotFoundException("ID "+id+" não encontrado");
		}
	}
	
	public void delete(Long id){
		try { repository.deleteById(id); } 
		catch (EmptyResultDataAccessException e) {
			throw new EntityNotFoundException("ID "+id+" não encontrado");
		}
	}
}
