package com.devsuperior.dspesquisa.resources;

import com.devsuperior.dspesquisa.dtos.RecordDto;
import com.devsuperior.dspesquisa.dtos.RecordInsertDto;
import com.devsuperior.dspesquisa.services.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

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

	@GetMapping
	public ResponseEntity<Page<RecordDto>> findAll(@RequestParam(value = "min", defaultValue = "") String min,
			@RequestParam(value = "max", defaultValue = "") String max,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "0") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "moment") String orderBy,
			@RequestParam(value = "direction", defaultValue = "DESC") String direction) {
		Instant minDate = ("".equals(min)) ? null : Instant.parse(min);
		Instant maxDate = ("".equals(max)) ? null : Instant.parse(max);

		if (linesPerPage == 0) {
			linesPerPage = Integer.MAX_VALUE;
		}

		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);

		Page<RecordDto> list = recordService.findByMoments(minDate, maxDate, pageRequest);
		return ResponseEntity.ok().body(list);
	}
}
