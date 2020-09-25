package com.devsuperior.dspesquisa.resources;

import com.devsuperior.dspesquisa.dtos.GameDto;
import com.devsuperior.dspesquisa.dtos.GameInputDto;
import com.devsuperior.dspesquisa.entities.Game;
import com.devsuperior.dspesquisa.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameResource {

	@Autowired
	private GameService gameService;

	@GetMapping
	public ResponseEntity<List<GameDto>> findAll() {
		List<GameDto> list = gameService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("{id}")
	public ResponseEntity<GameDto> findById(@PathVariable() Long id) {
		GameDto gameDto = gameService.findById(id);
		return ResponseEntity.ok().body(gameDto);
	}

	@PostMapping
	public ResponseEntity<GameDto> insert(@RequestBody() GameInputDto data) {
		GameDto gameDto = gameService.insert(data);
		return ResponseEntity.ok().body(gameDto);
	}

	@PutMapping("{id}")
	public ResponseEntity<Game> update(@PathVariable() Long id, @RequestBody() Game data) {
		System.out.println(data.getTitle() + " - " + data.getId() + " - " + data.getPlatform());
		// GameDto gameDto = gameService.update(data);
		return ResponseEntity.ok().body(data);
	}
}
