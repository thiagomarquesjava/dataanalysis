package com.dataanalysis.controller;

import java.util.List;

import com.dataanalysis.arq.forTests.FileControllerStub;
import com.dataanalysis.model.Client;
import com.dataanalysis.model.Sales;
import com.dataanalysis.model.Seller;
import com.dataanalysis.provider.DataProvider;

import junit.framework.TestCase;

public class FileControllerTest extends TestCase {
	
	private static final String FILEPATH_IN = "D:\\workspace\\tests\\dataanalysis\\src\\test\\resources\\data\\in\\";
	private static final String FILEPATH_OUT = "D:\\workspace\\tests\\dataanalysis\\src\\test\\resources\\data\\out\\";
	
	public void testIfTheFilepathInAndFilepathOutIsCorrectly() {
		FileController file = new FileControllerStub();
		assertEquals(FILEPATH_IN, file.getFilepathIn());
		assertEquals(FILEPATH_OUT, file.getFilepathOut());
	}
	
	public void testIfReadAFileAndAQuantityOfEntitiesIsCorrect() throws Exception {
		DataProvider.buildANewFilesToTest(FILEPATH_IN);
		FileController fileController = new FileControllerStub();
		fileController.executeProcess();
		List<Client> clients = fileController.getClients();
		assertEquals(2, clients.size());
		List<Seller> sellers = fileController.getSellers();
		assertEquals(2, sellers.size());
		List<Sales> sales = fileController.getSales();
		assertEquals(2, sales.size());
	}
	
	public void testIfReadAFileAndShowTheCorrectlyResult() throws Exception {
		DataProvider.buildANewFilesToTest(FILEPATH_IN);
		FileController fileController = new FileControllerStub();
		fileController.executeProcess();
		List<String> lines = DataProvider.readResultFiles(FILEPATH_OUT);
		validateOutput(lines);
		
	}

	private void validateOutput(List<String> lines) throws Exception {
		assertEquals("Quantidade de clientes no arquivo de entrada: " + 2, lines.get(0));
		assertEquals("Quantidade de vendedor no arquivo de entrada: " + 2, lines.get(1));
		assertEquals("ID da venda mais cara: " + 10, lines.get(2));
		assertEquals("O pior vendedor já: Renato", lines.get(3));
	}
	
}
