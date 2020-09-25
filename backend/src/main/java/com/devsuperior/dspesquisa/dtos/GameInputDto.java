package com.devsuperior.dspesquisa.dtos;

import com.devsuperior.dspesquisa.entities.Game;
import com.devsuperior.dspesquisa.entities.enums.Platform;

import java.io.Serializable;

public class GameInputDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String title;
	private Platform platform;

	public GameInputDto() {
	}

	public GameInputDto(Game entity) {
		title = entity.getTitle();
		platform = entity.getPlatform();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Platform getPlatform() {
		return platform;
	}

	public void setPlatform(Platform platform) {
		this.platform = platform;
	}
}
