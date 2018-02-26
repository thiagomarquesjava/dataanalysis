package com.dataanalysis.arq.builder;

import com.dataanalysis.arq.model.Entity;

/**
 * Class to define a principal methods of Builders
 * @author Jonathan Souza Santos
 * @param <T> Entity
 */
public abstract class Builder <T extends Entity> {

	public abstract T buildANewEntity(String entityAsString);
	
}
