package com.dataanalysis.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.dataanalysis.builder.ClientBuilder;
import com.dataanalysis.builder.SalesBuilder;
import com.dataanalysis.builder.SellerBuilder;
import com.dataanalysis.dto.SalesDTO;
import com.dataanalysis.dto.SellerDTO;
import com.dataanalysis.enumeration.LineIdentifierEnum;
import com.dataanalysis.filter.FileFilter;
import com.dataanalysis.model.Client;
import com.dataanalysis.model.Item;
import com.dataanalysis.model.Sales;
import com.dataanalysis.model.Seller;

public class FileController {

	private static final String HOMEPATH = "HOMEPATH";

	private List<File> files;
	
	private List<Client> clients;
	private List<Seller> sellers;
	private List<Sales> sales;
	
	public FileController() {
		super();
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

	public void executeProcess() throws Exception {
		startLists();
		for (File file : readFilesFromPath()) {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
			stepConvert(bufferedReader);
			stepWrite(file.getName());
			bufferedReader.close();
			file.delete();
		}
	}

	private void stepWrite(String fileName) throws Exception {
		StringBuffer buff = new StringBuffer();
		buff.append("Quantidade de clientes no arquivo de entrada: " + getClients().size() + "\n");
		buff.append("Quantidade de vendedor no arquivo de entrada: "+ getSellers().size() + "\n");
		buff.append("ID da venda mais cara: " + getTheBestSale().getId() + "\n");
		buff.append("O pior vendedor já: " + getTheWorstSeller().getName() + "\n");
		byte[] buffAsBytes = buff.toString().getBytes();
		FileOutputStream outputStream = null; 
		File file = new File(getFilepathOut().concat(fileName).replace(".dat", ".done.dat"));
		outputStream = new FileOutputStream(file);
		if (!file.exists()) {
			file.createNewFile();
		}
		outputStream.write(buffAsBytes);
		outputStream.flush();
		outputStream.close();
	}

	private void stepConvert(BufferedReader bufferedReader) throws IOException {
		String line = null;
		while ((line = bufferedReader.readLine()) != null) {
			convertLine(line, line.substring(0, 3));
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
	
	private SalesDTO getTheBestSale() {
		SalesDTO dto = null;
		for (Sales sales : getSales()) {
			if (dto == null) {
				dto = new SalesDTO();
				dto.setId(sales.getId());
				dto.setTotalPrice(getTotalPriceOfSale(sales));
			} else if (dto.getTotalPrice() < getTotalPriceOfSale(sales)) {
				dto.setId(sales.getId());
				dto.setTotalPrice(getTotalPriceOfSale(sales));
			}
		}
		return dto;
	}
	
	private Double getTotalPriceOfSale(Sales sales) {
		Double totalPrice = 0.0;
		for (Item item : sales.getListOfItems()) {
			totalPrice += item.getQuantity() * item.getPrice();
		}
		return totalPrice;
	}

	private SellerDTO getTheWorstSeller() {
		HashMap<String, SellerDTO> worstSeller = defineHashMapToExtractWorstSeller();
		SellerDTO worstSellerDTO = extractWorstSeller(worstSeller);
		return worstSellerDTO;
	}

	private HashMap<String, SellerDTO> defineHashMapToExtractWorstSeller() {
		HashMap<String, SellerDTO> worstSeller = new HashMap<String, SellerDTO>();
		for (Sales sales : getSales()) {
			if (!worstSeller.containsKey(sales.getNameOfSeller())) {
				worstSeller.put(sales.getNameOfSeller(), new SellerDTO(sales.getNameOfSeller(), getTotalPriceOfSale(sales)));
			} else {
				Double priceOfSales = worstSeller.get(sales.getNameOfSeller()).getTotalSales();
				worstSeller.put(sales.getNameOfSeller(), new SellerDTO(sales.getNameOfSeller(), priceOfSales + getTotalPriceOfSale(sales)));
			}
		}
		return worstSeller;
	}

	private SellerDTO extractWorstSeller(HashMap<String, SellerDTO> worstSeller) {
		SellerDTO worstSellerDTO = null;
		for (SellerDTO dto : worstSeller.values()) {
			if (worstSellerDTO == null) {
				worstSellerDTO = new SellerDTO();
				worstSellerDTO.setName(dto.getName());
				worstSellerDTO.setTotalSales(dto.getTotalSales());
			} else if (worstSellerDTO.getTotalSales() > dto.getTotalSales()) {
				worstSellerDTO.setName(dto.getName());
				worstSellerDTO.setTotalSales(dto.getTotalSales());
			}
		}
		return worstSellerDTO;
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
