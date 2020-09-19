package com.devsuperior.dspesquisa.services;

import com.devsuperior.dspesquisa.dtos.RecordDto;
import com.devsuperior.dspesquisa.dtos.RecordInsertDto;
import com.devsuperior.dspesquisa.entities.Game;
import com.devsuperior.dspesquisa.entities.Record;
import com.devsuperior.dspesquisa.repositories.GameRepository;
import com.devsuperior.dspesquisa.repositories.RecordRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class RecordService {

    private final RecordRepository recordRepository;
    private final GameRepository gameRepository;

    public RecordService(
        RecordRepository recordRepository,
        GameRepository gameRepository
    ) {
        this.recordRepository = recordRepository;
        this.gameRepository = gameRepository;
    }

    @Transactional()
    public RecordDto insert(RecordInsertDto data) {
        Game game = gameRepository.getOne(data.getGameId());
        Record entity = new Record(null, data.getName(), data.getAge(), Instant.now(), game);
        entity = recordRepository.save(entity);
        return new RecordDto(entity);
    }
}
