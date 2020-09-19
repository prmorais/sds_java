package com.devsuperior.dspesquisa.services;

import com.devsuperior.dspesquisa.dtos.GameDto;
import com.devsuperior.dspesquisa.entities.Game;
import com.devsuperior.dspesquisa.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {

    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Transactional(readOnly = true)
    public List<GameDto> findAll() {
        List<Game> list = gameRepository.findAll();
        return list.stream().map(GameDto::new).collect(Collectors.toList());
        // return list.stream().map(game -> new GameDto(game)).collect(Collectors.toList());
    }
}
