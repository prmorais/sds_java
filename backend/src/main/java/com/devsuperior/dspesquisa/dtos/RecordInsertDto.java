package com.devsuperior.dspesquisa.dtos;

import com.devsuperior.dspesquisa.entities.Record;

import java.io.Serializable;

public class RecordInsertDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;
	private Integer age;
	private Long gameId;

	public RecordInsertDto() {
	}

	public RecordInsertDto(Record entity) {
		name = entity.getName();
		age = entity.getAge();
		gameId = entity.getGame().getId();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Long getGameId() {
		return gameId;
	}

	public void setGameId(Long gameId) {
		this.gameId = gameId;
	}
}
