package com.dataanalysis.filter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

public class FileFilterTest extends TestCase {

	public void testIfJustReadADatFiles() {
		List<File> filesToFilter = new ArrayList<File>();
		filesToFilter.add(new File("File01.dat"));
		filesToFilter.add(new File("File02.dat"));
		filesToFilter.add(new File("File03.txt"));
		filesToFilter.add(new File("File04.txt"));
		filesToFilter.add(new File("File05.dat"));
		filesToFilter.add(new File("File06.csv"));
		FileFilter filter = new FileFilter(filesToFilter);
		List<File> files = filter.getAcceptFiles();
		assertNotNull(files);
		assertEquals(3, files.size());
	}
	
}
