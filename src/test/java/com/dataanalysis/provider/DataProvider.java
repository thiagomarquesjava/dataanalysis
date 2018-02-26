package com.dataanalysis.provider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataProvider {

	public static void buildANewFilesToTest(String filePathIn) throws Exception {
		prepareFilesToTest(filePathIn.concat("file_1.dat"), buildAFirstFile());
	}
	
	public static List<String> readResultFiles(String filepathOut) throws Exception {
		return prepareLinesToReturn(filepathOut.concat("file_1.done.dat"));
	}
	
	private static StringBuffer buildAFirstFile() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("001ç1234567891234çDiegoç50000\n");
		buffer.append("001ç3245678865434çRenatoç40000.99\n"); 
		buffer.append("002ç2345675434544345çJose da SilvaçRural\n");
		buffer.append("002ç2345675433444345çEduardo PereiraçRural\n"); 
		buffer.append("003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çDiego\n");
		buffer.append("003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çRenato");
		return buffer;
	}
	
	private static void prepareFilesToTest(String filename, StringBuffer buffer) throws Exception {
		buffer.toString().getBytes();
		FileOutputStream outputStream = buildAFile(filename);
		byte[] bufferAsBytes  = buffer.toString().getBytes();
		outputStream.write(bufferAsBytes);
		outputStream.flush();
		outputStream.close();
	}

	private static FileOutputStream buildAFile(String filename) throws FileNotFoundException, IOException {
		File file = new File(filename);
		FileOutputStream outputStream = new FileOutputStream(file);
		if (!file.exists()) {
			file.createNewFile();
		}
		return outputStream;
	}
	
	private static List<String> prepareLinesToReturn(String filename) throws Exception {
		File file = new File(filename);
		BufferedReader buff = new BufferedReader(new FileReader(file));
		List<String> lines = new ArrayList<String>();
		lines.add(buff.readLine());
		lines.add(buff.readLine());
		lines.add(buff.readLine());
		lines.add(buff.readLine());
		buff.close();
		file.delete();
		return lines;
	}

}