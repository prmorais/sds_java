package com.devsuperior.dspesquisa.resources;

import com.devsuperior.dspesquisa.dtos.GameDto;
import com.devsuperior.dspesquisa.dtos.RecordDto;
import com.devsuperior.dspesquisa.dtos.RecordInsertDto;
import com.devsuperior.dspesquisa.services.GameService;
import com.devsuperior.dspesquisa.services.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/records")
public class RecordResource {

    @Autowired
    private RecordService recordService;

    @PostMapping
    public ResponseEntity<RecordDto> insert(@RequestBody() RecordInsertDto data) {
        RecordDto recordDto = recordService.insert(data);
        return ResponseEntity.ok().body(recordDto);
    }
}
