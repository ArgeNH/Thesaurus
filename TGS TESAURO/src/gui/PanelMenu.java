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
	private JMenu table;
	private JMenuItem tableshow;
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
		
		table=new JMenu("Tabla de terminos");
		table.setFont(font);
		
		tableshow=new JMenuItem("Tabla");
		tableshow.setFont(font);
		tableshow.setActionCommand(ActionsThesaurus.VIEW_TABLE);
		tableshow.addActionListener(window.getControll());
		
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
		add(table);
		
		table.add(tableshow);
		options.add(addWords);
		options.add(showWords);
		
	}

}
