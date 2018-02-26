package com.dataanalysis.controller;

import java.io.File;
import java.util.List;

import junit.framework.TestCase;

public class FileControllerTest extends TestCase {
	
	private static final String FILEPATH_IN = "\\Users\\jssantos\\data\\in\\";
	private static final String FILEPATH_OUT = "\\Users\\jssantos\\data\\out\\";
	
	public void testIfTheFilepathInAndFilepathOutIsCorrectly() {
		FileController file = FileController.getInstance();
		assertEquals(FILEPATH_IN, file.getFilepathIn());
		assertEquals(FILEPATH_OUT, file.getFilepathOut());
	}
	
	public void testIfJustReadADatFiles() {
		FileController fileController = FileController.getInstance();
		List<File> files = fileController.readFilesFromPath();
		assertNotNull(files);
		assertEquals(2, files.size());
	}
	
}
