package com.dataanalysis.arq.forTests;

import com.dataanalysis.controller.FileController;

/**
 * Class for tests
 * 
 * @author Jonathan Souza santos
 */
public class FileControllerStub extends FileController {

	@Override
	public String getFilepathIn() {
		return "D:\\workspace\\tests\\dataanalysis\\src\\test\\resources\\data\\in\\";
	}

	@Override
	public String getFilepathOut() {
		return "D:\\workspace\\tests\\dataanalysis\\src\\test\\resources\\data\\out\\";
	}

}
