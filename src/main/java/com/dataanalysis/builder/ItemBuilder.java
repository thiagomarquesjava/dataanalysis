package com.dataanalysis.builder;

import com.dataanalysis.arq.builder.Builder;
import com.dataanalysis.model.Item;

public class ItemBuilder extends Builder<Item> {

	@Override
	public Item buildANewEntity(String entityAsString) {
		String itemAsVector[] = entityAsString.split("-");
		Item item = new Item();
		item.setId(Integer.valueOf(itemAsVector[0]));
		item.setQuantity(Integer.valueOf(itemAsVector[1]));
		item.setPrice(Double.valueOf(itemAsVector[2]));
		return item;
	}

}
