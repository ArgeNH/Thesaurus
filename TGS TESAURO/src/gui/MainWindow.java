package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import controll.ControlThesaurus;
import model.ActionsThesaurus;

public class MainWindow extends JFrame implements ActionsThesaurus{
	
	private ControlThesaurus controll;
	
	
	
	private JDesktopPane desktop;
	private PanelTitle panelTitle;
	private PanelMenu panelMenu;
	private PanelWords panelWords;
	private PanelFind panelFind;
	private InternalTable internalTable;
	
	public MainWindow(){
		setTitle("TGS ~ Tesauro | Arge Niño");
		setSize(new Dimension(740,480));
		setLocationRelativeTo(this);
		setResizable(false);
		setLayout(new BorderLayout());
		setIconImage(new ImageIcon("resources/icons/logo.png").getImage());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void begin() {
		beginElemets();
		addElements();
		this.setVisible(true);
	}

	private void beginElemets() {
		
		desktop=new JDesktopPane();
		desktop.setBackground(new Color(208, 211, 212));
		
		panelTitle=new PanelTitle();
		panelMenu=new PanelMenu(this);
		panelWords=new PanelWords(this,desktop);
		panelFind=new PanelFind(this,desktop);
		internalTable=new InternalTable(this, desktop);
	}

	private void addElements() {
		//add(panelTitle,BorderLayout.SOUTH);
		this.setJMenuBar(panelMenu);
		add(desktop,BorderLayout.CENTER);
		add(panelWords,BorderLayout.CENTER);
		add(panelFind,BorderLayout.CENTER);
		add(internalTable,BorderLayout.CENTER);
	}

	@Override
	public String[] readInput(String option) {
		switch(option){
		case ActionsThesaurus.VIEW_ADD_WORDS:
			panelFind.setVisible(false);
			panelWords.setVisible(true);
			break;
		case ActionsThesaurus.VIEW_WORDS:
			panelFind.setVisible(true);
			panelWords.setVisible(false);
			break;
		case ActionsThesaurus.VIEW_TABLE:
			internalTable.setVisible(true);
			panelFind.setVisible(false);
			panelWords.setVisible(false);
			controll.actionPerformed(new ActionEvent(this, 0, ActionsThesaurus.SORT_WORDS));
			break;
		case ActionsThesaurus.ADD_WORD:
			return addWord();
		case ActionsThesaurus.FIND_WORD:
			return findWord();
		}
		return null;
	}

	private String[] findWord() {
		String word=panelFind.getTxtWordFind().getText();
		return new String [] {word};
	}

	private String[] addWord() {
		String word=panelWords.getTxtWord().getText();
		String description=panelWords.getDescription().getText();
		String example=panelWords.getExample().getText();
		return new String [] {word,description,example};
	}

	@Override
	public void writeOuput(String option, String[] output, boolean state) {
		switch(option){
			case ActionsThesaurus.ADD_WORD:
				if(state==true){
					JOptionPane.showMessageDialog(null, "Se agrego el término, con exito");
					cleanFields();
				}else{
					JOptionPane.showMessageDialog(null, "Este término ya existe, o no se puede agregar");
				}
				break;
			case ActionsThesaurus.FIND_WORD:
				if(state==true){
					JOptionPane.showMessageDialog(null, "Término encontrado con exito");
					System.out.println(output[1].toString());
					panelFind.getShow().setText(output[1]+"\n\n"+output[2]);
				}else{
					JOptionPane.showMessageDialog(null, "No Existe el termino buscado");
				}
				break;
			case "order":
				tableWords(output);
				controll.actionPerformed(new ActionEvent(this, 0, ActionsThesaurus.SORT_WORDS));
			break;
		}
		
	}
	
	private void tableWords(String[] output) {
		DefaultTableModel dtm=internalTable.getModel();
		while(dtm.getRowCount()>0 ){
			dtm.removeRow(0);
		}
		for (String chain : output) {
			StringTokenizer tokens=new StringTokenizer(chain, ";");
			String termino=tokens.nextToken();
			Object[] list=new Object[]{termino};
			dtm.addRow(list);
		}
	}

	

	@Override
	public void setControll(ControlThesaurus controll) {
		this.controll=controll;
	}
	
	public ControlThesaurus getControll() {
		return controll;
	}

	@Override
	public void exit() {
		
		
	}
	
	public void cleanFields(){
		panelWords.getTxtWord().setText("");
		panelWords.getDescription().setText("");
		panelWords.getExample().setText("");
	}

}
