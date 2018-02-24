package com.dataanalysis.builder;

import java.util.ArrayList;
import java.util.List;

import com.dataanalysis.arq.builder.Builder;
import com.dataanalysis.model.Item;
import com.dataanalysis.model.Sales;

public class SalesBuilder extends Builder<Sales> {

	@Override
	public Sales buildANewEntity(String entityAsString) {
		String salesAsVector[] = entityAsString.split("ç");
		Sales sales = new Sales();
		sales.setId(Integer.valueOf(salesAsVector[1]));
		sales.setListOfItems(buildAListOfItems(salesAsVector[2]));
		sales.setNameOfSeller(salesAsVector[3]);
		return sales;
	}

	private List<Item> buildAListOfItems(String itemsAsString) {
		String itemsAsStringWithoutParentheses = itemsAsString.substring(1, itemsAsString.length() - 1);
		String itemsAsVector[] = itemsAsStringWithoutParentheses.split(",");
		List<Item> listOfItems = new ArrayList<Item>();
		for (int row = 0; row < itemsAsVector.length; row++) {
			listOfItems.add(new ItemBuilder().buildANewEntity(itemsAsVector[row]));
		}
		return listOfItems;
	}

}
