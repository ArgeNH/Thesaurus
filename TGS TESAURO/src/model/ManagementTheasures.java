package model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ManagementTheasures {
	
	private ArrayList<Thesaurus> words;
	private Comparator<Thesaurus> comp;
	private FileThesaurus file;
	
	public ManagementTheasures(Comparator<Thesaurus> comp) {
		this.comp=comp;
		words=new ArrayList<>();
		file = new FileThesaurus(); 
		file.setPathFile("resources/files/");
		file.setNameFile("theasurus.json");
		file.openFile();
	}
	
	public Thesaurus findWord(String word){
		for (Thesaurus thesaurus : words) {
			if(thesaurus.getWord().equals(word)){
				return thesaurus;
			}
		}
		return null;
	}
	
	private int find(ArrayList<Thesaurus> vector, String nit, int begin, int end){		
		if(begin<=end){
			int medium=(begin+end)/2;
			if(vector.get(medium).getWord().equals(nit)){
				return medium;
				
			}else if(vector.get(medium).getWord().compareTo(nit)>0){
				return find(vector,nit,begin,medium-1);
			}else{
				return find(vector, nit,medium+1,end);
			}
		}
		return -1;
	}
	
	public ArrayList<Thesaurus> sort(Comparator<Thesaurus> comp){
		ArrayList<Thesaurus> clon= (ArrayList<Thesaurus>) words.clone();
		Collections.sort(clon,comp);
		return clon;
	}
	
	public int findWord1(String word){
		ArrayList<Thesaurus> clon=sort(comp);
		return find(clon, word, 0, clon.size()-1);
	}
	
	public boolean addWord(String word, String description,String example){
		if(findWord(word)==null){
			words.add(new Thesaurus(word, description,example));
			return true;
		}
		return false;
	}
	
	public Thesaurus updateWord(String word, Thesaurus obj){
		for (int i = 0; i < words.size(); i++) {
			if(findWord(word).getWord().equals(word)){
				return words.set(findWord1(word), obj);
			}
		}
		return null;
	}
	
	public Thesaurus deleteWord(String word){
		for (int i = 0; i < words.size(); i++) {
			if(words.get(i).getWord().equals(word)){
				return words.remove(i);
			}
		}
		return null;
	}
	
	public void PushJson() throws IOException, NoSuchFieldException{
		file = new FileThesaurus(); 
		file.setPathFile("resources/files/");
		file.setNameFile("theasurus.json");
		file.openFile();
		file.pushJson(words);
	}
	
	
	public void pullJson() throws IOException, NoSuchFieldException{
		file = new FileThesaurus(); 
		file.setPathFile("resources/files/");
		file.setNameFile("theasurus.json");
		file.openFile();
		words=file.pullJson(); 
	}

	public ArrayList<Thesaurus> getWords() {
		return (ArrayList<Thesaurus>) words.clone();
	}

}