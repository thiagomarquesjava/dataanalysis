package com.dataanalysis.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.dataanalysis.builder.ClientBuilder;
import com.dataanalysis.builder.SalesBuilder;
import com.dataanalysis.builder.SellerBuilder;
import com.dataanalysis.enumeration.LineIdentifierEnum;
import com.dataanalysis.filter.FileFilter;
import com.dataanalysis.model.Client;
import com.dataanalysis.model.Sales;
import com.dataanalysis.model.Seller;

public class FileController {

	private static final String HOMEPATH = "HOMEPATH";
	private static FileController fileController;

	private List<File> files;
	
	private List<Client> clients;
	private List<Seller> sellers;
	private List<Sales> sales;
	
	protected FileController() {
		super();
	}
	
	public static FileController getInstance() {
		if (fileController == null) {
			fileController = new FileController();
		}
		return fileController;
	}

	public String getFilepathFromSystem() {
		return System.getenv(HOMEPATH);
	}
	
	public String getFilepathIn() {
		return getFilepathFromSystem().concat("\\data\\in\\");
	}

	public String getFilepathOut() {
		return getFilepathFromSystem().concat("\\data\\out\\");
	}

	public List<File> readFilesFromPath() {
		File file = new File(getFilepathIn());
		files = new FileFilter(Arrays.asList(file.listFiles())).getAcceptFiles();
		return files;
	}

	public void executeProcess() throws IOException {
		startLists();
		for (File file : readFilesFromPath()) {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				convertLine(line, line.substring(0, 3));
			}
			
			
			bufferedReader.close();
			file.delete();
		}
	}

	private void startLists() {
		this.sellers = new ArrayList<Seller>();
		this.clients = new ArrayList<Client>();
		this.sales = new ArrayList<Sales>();
	}

	private void convertLine(String line, String lineIdentifier) {
		if (lineIdentifier.equals(LineIdentifierEnum.SELLER.getCode())) {
			sellers.add(new SellerBuilder().buildANewEntity(line));
		} else if (lineIdentifier.equals(LineIdentifierEnum.CLIENT.getCode())) {
			clients.add(new ClientBuilder().buildANewEntity(line));
		} else if (lineIdentifier.equals(LineIdentifierEnum.SALES.getCode())) {
			sales.add(new SalesBuilder().buildANewEntity(line));
		}
	}

	public List<Seller> getSellers() {
		return this.sellers;
	}
	
	public List<Client> getClients() {
		return this.clients;
	}
	
	public List<Sales> getSales() {
		return this.sales;
	}
	
}
