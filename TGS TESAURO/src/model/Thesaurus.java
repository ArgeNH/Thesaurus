package model;

import java.util.Comparator;

public class Thesaurus {
	
	private String word;
	private String description;
	private String example;
	
	public static Comparator<Thesaurus> compWord=new Comparator<Thesaurus>() {

		@Override
		public int compare(Thesaurus o1, Thesaurus o2) {
			return o1.getWord().compareTo(o2.getWord());
		}
		
	};
	
	public Thesaurus(String word, String description, String example) {
		this.word = word;
		this.description = description;
		this.example=example;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getExample() {
		return example;
	}

	public void setExample(String example) {
		this.example = example;
	}

	@Override
	public String toString() {
		return "Thesaurus [word=" + word + ", description=" + description + ", example=" + example + "]";
	}
}
