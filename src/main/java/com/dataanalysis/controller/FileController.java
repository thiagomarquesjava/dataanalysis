package com.dataanalysis.controller;

import java.io.File;
import java.util.List;

import com.dataanalysis.filter.FileFilter;


public class FileController {

	private static final String HOMEPATH = "HOMEPATH";
	private static FileController fileController;

	private List<File> files;
	
	private FileController() {
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
		files = new FileFilter(file.listFiles()).getAcceptFiles();
		return files;
	}
	
}
