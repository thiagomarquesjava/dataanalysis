package com.dataanalysis.arq.builder;

import com.dataanalysis.arq.model.Entity;

public abstract class Builder <T extends Entity> {

	public abstract T buildANewEntity(String entityAsString);
	
}
