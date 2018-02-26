package com.dataanalysis.controller;

import java.io.IOException;
import java.util.List;

import com.dataanalysis.model.Client;
import com.dataanalysis.model.Sales;
import com.dataanalysis.model.Seller;

import junit.framework.TestCase;

public class FileControllerTest extends TestCase {
	
	private static final String FILEPATH_IN = "\\Users\\jssantos\\data\\in\\";
	private static final String FILEPATH_OUT = "\\Users\\jssantos\\data\\out\\";
	
	public void testIfTheFilepathInAndFilepathOutIsCorrectly() {
		FileController file = FileController.getInstance();
		assertEquals(FILEPATH_IN, file.getFilepathIn());
		assertEquals(FILEPATH_OUT, file.getFilepathOut());
	}
	
	public void testIfReadAFileAndAQuantityOfEntitiesIsCorrect() throws IOException {
		FileController fileController = FileController.getInstance();
		fileController.executeProcess();
		List<Client> clients = fileController.getClients();
		assertEquals(4, clients.size());
	
		List<Seller> sellers = fileController.getSellers();
		assertEquals(4, sellers.size());

		List<Sales> sales = fileController.getSales();
		assertEquals(4, sales.size());
	}
	
}
