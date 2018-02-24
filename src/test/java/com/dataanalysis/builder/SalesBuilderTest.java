package com.dataanalysis.builder;

import java.util.List;

import com.dataanalysis.model.Item;
import com.dataanalysis.model.Sales;

import junit.framework.TestCase;

public class SalesBuilderTest extends TestCase {

	private static final String NEW_SALES = "003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çDiego";
	
	public void testIfANewSalesIsCreatedWithSuccess() {
		Item item01 = new Item(1, 10, 100.0);
		Item item02 = new Item(2, 30, 2.50);
		Item item03 = new Item(3, 40, 3.10);
		Sales expected = new Sales(10, "Diego");
		expected.getListOfItems().add(item01);
		expected.getListOfItems().add(item02);
		expected.getListOfItems().add(item03);
		
		Sales actual = new SalesBuilder().buildANewEntity(NEW_SALES);
		assertEquals(expected.getId(), actual.getId());
		assertEquals(expected.getNameOfSeller(), actual.getNameOfSeller());
		assertEquals(expected.getListOfItems().size(), actual.getListOfItems().size());
		assertEqualsItens(expected.getListOfItems(), actual.getListOfItems());
	}

	private void assertEqualsItens(List<Item> expectedListOfItems, List<Item> actualListOfItems) {
		for (int row = 0; row < expectedListOfItems.size(); row++) {
			Item expected = expectedListOfItems.get(row);
			Item actual = actualListOfItems.get(row);
			assertEquals(expected.getId(), actual.getId());
			assertEquals(expected.getQuantity(), actual.getQuantity());
			assertEquals(expected.getPrice(), actual.getPrice());
		}
	}
	
}
