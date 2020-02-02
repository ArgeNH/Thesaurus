package model;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.StringTokenizer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class FileThesaurus extends FilePlain {
	
	public ArrayList<String> reader() throws IOException{
		ArrayList<String> output=new ArrayList<>();
		StringTokenizer tokens=new StringTokenizer(readFile(),"\n");
		while(tokens.hasMoreElements()){
			output.add(tokens.nextToken());
		}
		return output;
	}
	
	public void write(ArrayList<String> records) throws IOException{
		StringBuilder saveFile= new StringBuilder();
		for (String line : records) {
			saveFile.append(line+"\n");
		}
		writeFile(saveFile.toString());
	}
	

	public void pushJson(ArrayList<Thesaurus> cars) throws IOException{
		Gson gson = new GsonBuilder().setPrettyPrinting().create(); 
		String collection = gson.toJson(cars); 
		writeFile(collection);
	}
	
	public ArrayList<Thesaurus> pullJson() throws IOException{
		String json = readFile(); 
		Gson gson = new Gson(); 
		Type type = new TypeToken <ArrayList<Thesaurus>>(){}.getType(); 
		ArrayList<Thesaurus> output = gson.fromJson(json, type); 
		return output; 
	}
	
}
