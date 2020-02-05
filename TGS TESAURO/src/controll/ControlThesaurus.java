package controll;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

import gui.MainWindow;
import model.ActionsThesaurus;
import model.ManagementTheasures;
import model.Thesaurus;

public class ControlThesaurus implements ActionListener {
	
	public static final String ANSI_RED = "\033[31m";
	public static final String ANSI_RESET = "\u001B[0m";
	
	private ManagementTheasures mng;
	private MainWindow window;
	
	public ControlThesaurus(MainWindow window) throws NoSuchFieldException, IOException {
		this.window=window;
		mng=new ManagementTheasures(Thesaurus.compWord);
		mng.pullJson();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
		case ActionsThesaurus.VIEW_ADD_WORDS:
			window.readInput(ActionsThesaurus.VIEW_ADD_WORDS);
			break;
		case ActionsThesaurus.VIEW_WORDS:
			window.readInput(ActionsThesaurus.VIEW_WORDS);
			break;
		case ActionsThesaurus.VIEW_TABLE:
			window.readInput(ActionsThesaurus.VIEW_TABLE);
			break;
		case ActionsThesaurus.ADD_WORD:
			addWord(window.readInput(ActionsThesaurus.ADD_WORD));
			break;
		case ActionsThesaurus.FIND_WORD:
			findWord(window.readInput(ActionsThesaurus.FIND_WORD));
			break;
		case ActionsThesaurus.SORT_WORDS:
			sort(Thesaurus.compWord);
			break;
		}
	}

	private void sort(Comparator<Thesaurus> compWord) {
		ArrayList<Thesaurus> out=mng.sort(Thesaurus.compWord);
		String [] exit=new String[out.size()];
		int cant=0;
		for (Thesaurus string : out) {
			String word=string.getWord();
			exit[cant++]=word;
		}
		window.writeOuput("order", exit, true);
	}

	private void findWord(String[] dates) {
		if(dates!=null){
			String word=dates[0];
			
			if(mng.findWord(word)!=null){
				System.out.println(mng.findWord(word).toString());
				window.writeOuput(ActionsThesaurus.FIND_WORD, new String [] {word,"Descripcion --->  "+mng.findWord(word).getDescription(),"Ejemplo: ---> "+mng.findWord(word).getExample()}, true);
			}else{
				window.writeOuput(ActionsThesaurus.FIND_WORD, new String [] {word}, false);
			}
		}
	}

	private void addWord(String[] dates) {
		if(dates!=null){
			String word=dates[0];
			String description=dates[1];
			String example=dates[2];
			if(mng.addWord(word, description,example)){
				window.writeOuput(ActionsThesaurus.ADD_WORD, new String [] {word}, true);
				System.out.println("F en el chat");
				persistence();
			}else{
				window.writeOuput(ActionsThesaurus.ADD_WORD, new String [] {word}, false);
				System.out.println("F en el chat2");
			}
		}
		
	}

	public void persistence(){
		try {
			mng.PushJson();
		} catch (NoSuchFieldException | IOException e1) {
			e1.printStackTrace();
		}
	}
	
}
