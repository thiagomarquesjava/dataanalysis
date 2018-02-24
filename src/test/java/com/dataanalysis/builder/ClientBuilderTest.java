package com.dataanalysis.builder;

import com.dataanalysis.model.Client;

import junit.framework.TestCase;

public class ClientBuilderTest extends TestCase {

	private static final String NEW_CLIENT = "002ç2345675434544345çJose da SilvaçRural";
	
	public void testIfANewClientIsCreatedWithSuccess() {
		Client expected = new Client("2345675434544345", "Jose da Silva", "Rural");
		Client actual = new ClientBuilder().buildANewEntity(NEW_CLIENT);
		assertEquals(expected.getCnpj(), actual.getCnpj());
		assertEquals(expected.getName(), actual.getName());
		assertEquals(expected.getBusinessArea(), actual.getBusinessArea());
	}
	
}
