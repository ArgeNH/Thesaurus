package runner;

/*
Autor: Arge Darley Niño Vianchá
*/

import java.io.IOException;

import controll.ControlThesaurus;
import gui.MainWindow;
import model.ActionsThesaurus;

public class Runner {

	public static void main(String[] args) throws NoSuchFieldException, IOException {
		
		
		MainWindow window=new MainWindow();
		
		ControlThesaurus controll=new ControlThesaurus(window);
		window.setControll(controll);
		window.begin();

	}

}
