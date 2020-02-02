package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FilePlain {
	
	private Path path; 
	private String pathFile; 
	private String nameFile; 
	private String separator;
	
	
	public void openFile(){
		path = Paths.get(pathFile+nameFile); 
	}
	
	public String readFile() throws IOException{
		//BufferedReader input = new Files.newBufferedReader(path,Charset.defaultCharset()); 
		BufferedReader input = Files.newBufferedReader(path,Charset.defaultCharset());
		StringBuilder output = new StringBuilder(); 
		String line; 
		while ((line = input.readLine())!=null) {
			output.append(line + "\n"); 
		}
		
		return output.toString();
	}
	
	public void writeFile(String dates) throws IOException{
		BufferedWriter output = Files.newBufferedWriter(path,Charset.defaultCharset(),StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING); 
		output.write(dates,0, dates.length());
		output.close();
	}

	public Path getPath() {
		return path;
	}

	public void setPath(Path path) {
		this.path = path;
	}

	public String getPathFile() {
		return pathFile;
	}

	public void setPathFile(String pathFile) {
		this.pathFile = pathFile;
	}

	public String getNameFile() {
		return nameFile;
	}

	public void setNameFile(String nameFile) {
		this.nameFile = nameFile;
	}

	public String getSeparator() {
		return separator;
	}

	public void setSeparator(String separator) {
		this.separator = separator;
	}
}
