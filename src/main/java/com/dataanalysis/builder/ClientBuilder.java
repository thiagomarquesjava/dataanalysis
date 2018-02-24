package com.dataanalysis.builder;

import com.dataanalysis.arq.builder.Builder;
import com.dataanalysis.model.Client;

public class ClientBuilder extends Builder<Client> {

	@Override
	public Client buildANewEntity(String entityAsString) {
		String[] clientAsVector = entityAsString.split("ç");
		Client client = new Client();
		client.setCnpj(clientAsVector[1]);
		client.setName(clientAsVector[2]);
		client.setBusinessArea(clientAsVector[3]);
		return client;
	}
	
}
