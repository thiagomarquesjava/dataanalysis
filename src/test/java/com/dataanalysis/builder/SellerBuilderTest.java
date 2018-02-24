package com.dataanalysis.builder;

import com.dataanalysis.model.Seller;

import junit.framework.TestCase;

public class SellerBuilderTest extends TestCase {

	protected static final String NEW_SELLER = "001ç1234567891234çDiegoç50000";
	
	public void testIfANewSellerIsCreatedWithSuccess() {
		Seller expected = new Seller("1234567891234", "Diego", 50000.0);
		Seller actual = new SellerBuilder().buildANewEntity(NEW_SELLER);
		assertEquals(expected.getCpf(), actual.getCpf());
		assertEquals(expected.getName(), actual.getName());
		assertEquals(expected.getSalary(), actual.getSalary());
	}
	
}
