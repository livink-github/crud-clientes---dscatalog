package br.com.livik.clientmaneger.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.livik.clientmaneger.dtos.ClientDTO;
import br.com.livik.clientmaneger.services.ClientService;

@RestController 
@RequestMapping (value = "/clients")
public class ClientResource {

	@Autowired
	private ClientService service;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<ClientDTO> getClientById(@PathVariable Long id){
		return ResponseEntity.ok(service.getClientById(id));
	}
	
	@GetMapping
	public ResponseEntity<Page<ClientDTO>> getAllClientPaged(
			@RequestParam(value = "pageNumber",     defaultValue = "0")    Integer pageNumber,
			@RequestParam(value = "pageSize",       defaultValue = "3")    Integer pageSize,
			@RequestParam(value = "sort",           defaultValue = "ASC")  String direction,
			@RequestParam(value = "sortBy",         defaultValue = "name") String sortBy) {
		return ResponseEntity.ok(service.getAllClientPaged(PageRequest.of(pageNumber, pageSize, Direction.valueOf(direction), sortBy)));
	}
	
	@PostMapping
	public ResponseEntity<ClientDTO> insert(@RequestBody ClientDTO dto) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(service.insert(dto));
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<ClientDTO> update(@PathVariable Long id, @RequestBody ClientDTO dto) {
		return ResponseEntity.ok().body(service.update(id, dto));
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}




















