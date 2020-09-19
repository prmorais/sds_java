package com.devsuperior.dspesquisa.resources;

import com.devsuperior.dspesquisa.dtos.GameDto;
import com.devsuperior.dspesquisa.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
}
