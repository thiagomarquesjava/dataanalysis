package com.dataanalysis.builder;

import com.dataanalysis.arq.builder.Builder;
import com.dataanalysis.model.Seller;

public class SellerBuilder extends Builder<Seller> {

	@Override
	public Seller buildANewEntity(String entityAsString) {
		String[] sellerAsVector = entityAsString.split("ç");
		Seller seller = new Seller();
		seller.setCpf(sellerAsVector[1]);
		seller.setName(sellerAsVector[2]);
		seller.setSalary(Double.valueOf(sellerAsVector[3]));
		return seller;
	}
	
}
