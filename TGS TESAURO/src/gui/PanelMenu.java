package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import model.ActionsThesaurus;

public class PanelMenu extends JMenuBar {
	
	private MainWindow window;
	private JMenu options;
	private JMenuItem addWords;
	private JMenuItem showWords;
	
	public PanelMenu(MainWindow window) {
		this.window=window;
		beginElements();
		addElements();
		setBackground(new Color(138, 152, 218));
		setBorder(BorderFactory.createRaisedBevelBorder());
	}

	private void beginElements() {
		
		Font font=new Font("Calibri", Font.BOLD, 16);
		
		options=new JMenu("Opciones");
		options.setFont(font);
		
		addWords=new JMenuItem("Añadir conceptos");
		addWords.setFont(font);
		addWords.setActionCommand(ActionsThesaurus.VIEW_ADD_WORDS);
		addWords.addActionListener(window.getControll());
		
		showWords=new JMenuItem("Buscar Terminos");
		showWords.setFont(font);
		showWords.setActionCommand(ActionsThesaurus.VIEW_WORDS);
		showWords.addActionListener(window.getControll());
		
	}

	private void addElements() {
		add(options);
		
		options.add(addWords);
		options.add(showWords);
		
	}

}
