package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import model.ActionsThesaurus;

public class PanelWords extends JInternalFrame{
	
	private MainWindow window;
	private JDesktopPane desktop;
	
	private JTextField txtWord;
	private JTextArea description;
	private JTextArea example;
	
	private JLabel image;
	private JLabel imageTwo;
	
	private JButton btnAddWord;
	
	
	public PanelWords(MainWindow window, JDesktopPane desktop) {	
		this.window=window;
		this.desktop=desktop;
		setTitle("Adicionar Nuevos Términos");
		setSize(new Dimension(735, 425));
		setBackground(new Color(231, 230, 177));
		setLayout(new GridBagLayout());
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setResizable(true);
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		beginElements();
		addElemtens();
		desktop.add(this);
	}

	private void beginElements() {
		txtWord=new JTextField();
		txtWord.setForeground(Color.red);
		
		description=new JTextArea();
		description.setLineWrap(true);
		description.setWrapStyleWord(true);
		
		example=new JTextArea();
		example.setLineWrap(true);
		example.setWrapStyleWord(true);
		
		image=new JLabel(new ImageIcon("resources/icons/research.png"));
		imageTwo=new JLabel(new ImageIcon("resources/icons/products.png"));
		
		btnAddWord=new JButton("Agregar Término");
		btnAddWord.setActionCommand(ActionsThesaurus.ADD_WORD);
		btnAddWord.addActionListener(window.getControll());
	}

	private void addElemtens() {
			
		GridBagConstraints gbc=new GridBagConstraints();
		
		gbc.weightx=1.0;
		
		//lbl
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.fill=GridBagConstraints.NONE;
		add(new JLabel("Término"),gbc);
		
		//txtwords
		gbc.gridx=1;
		gbc.fill=GridBagConstraints.HORIZONTAL;
		add(txtWord,gbc);
		
		gbc.gridx=0;
		gbc.gridy=1;
		gbc.fill=GridBagConstraints.NONE;
		add(new JLabel("Descripción"),gbc);
		
		gbc.gridx=1;
		gbc.gridwidth=3;
		gbc.gridheight=3;
		gbc.fill=GridBagConstraints.BOTH;
		add(new JScrollPane(description),gbc);
		
		gbc.gridx=4;
		add(image,gbc);
		
		gbc.gridx=0;
		gbc.gridy=4;
		gbc.gridwidth=1;
		gbc.gridheight=1;
		gbc.fill=GridBagConstraints.NONE;
		add(new JLabel("Ejemplo"),gbc);
		
		gbc.gridx=1;
		gbc.gridwidth=3;
		gbc.gridheight=3;
		gbc.fill=GridBagConstraints.BOTH;
		add(new JScrollPane(example),gbc);
		
		gbc.gridx=4;
		add(imageTwo,gbc);
		
		gbc.gridwidth=1;
		gbc.gridheight=1;
		gbc.gridx=1;
		gbc.gridy=7;
		add(btnAddWord,gbc);
		
	}

	public MainWindow getWindow() {
		return window;
	}

	public void setWindow(MainWindow window) {
		this.window = window;
	}

	public JTextField getTxtWord() {
		return txtWord;
	}

	public void setTxtWord(JTextField txtWord) {
		this.txtWord = txtWord;
	}

	public JTextArea getDescription() {
		return description;
	}

	public void setDescription(JTextArea description) {
		this.description = description;
	}

	public JTextArea getExample() {
		return example;
	}

	public void setExample(JTextArea example) {
		this.example = example;
	}

	public JLabel getImage() {
		return image;
	}

	public void setImage(JLabel image) {
		this.image = image;
	}

	public JLabel getImageTwo() {
		return imageTwo;
	}

	public void setImageTwo(JLabel imageTwo) {
		this.imageTwo = imageTwo;
	}

	public JButton getBtnAddWord() {
		return btnAddWord;
	}

	public void setBtnAddWord(JButton btnAddWord) {
		this.btnAddWord = btnAddWord;
	}

}
