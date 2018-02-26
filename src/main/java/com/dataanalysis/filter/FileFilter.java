package com.dataanalysis.filter;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileFilter {

	private List<File> listOfFiles;
	
	public FileFilter(File[] files) {
		this.listOfFiles = Arrays.asList(files);
	}
	
	public List<File> getAcceptFiles() {
		List<File> returnList = new ArrayList<File>();
		for (File file : listOfFiles) {
			if (file.getName().endsWith(".dat")) {
				returnList.add(file);
			}
		}
		return returnList;
	}
	
}
