package gui;

import java.awt.Color;
import java.awt.Desktop.Action;
import java.awt.Dimension;
import java.awt.Font;
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

public class PanelFind extends JInternalFrame{

	private MainWindow window;
	private JDesktopPane desktop;
	
	private JTextField txtWordFind;
	private JTextArea show;
	
	private JLabel image;
	private JLabel imageTwo;
	
	private JButton btnFindWord; 
	
	public PanelFind(MainWindow window, JDesktopPane desktop){
		this.window=window;
		this.desktop=desktop;
		setTitle("Busqueda de término individual");
		setSize(new Dimension(600, 230));
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
		
		Font f = new Font("Century", Font.BOLD, 14);
		Font font = new Font("Calibri", Font.BOLD, 25);
		
		txtWordFind=new JTextField();
		txtWordFind.setForeground(Color.red);
		txtWordFind.setFont(font);
		
		
		
		show=new JTextArea();
		show.setLineWrap(true);
		show.setWrapStyleWord(true);
		show.setEditable(false);
		show.setFont(f);
		
		btnFindWord=new JButton("Buscar Termino");
		btnFindWord.setActionCommand(ActionsThesaurus.FIND_WORD);
		btnFindWord.addActionListener(window.getControll());
		btnFindWord.setFont(font);
		
		image=new JLabel(new ImageIcon("resources/icons/research.png"));
		imageTwo=new JLabel(new ImageIcon("resources/icons/products.png"));
	}

	private void addElemtens() {
		Font font = new Font("Century", Font.BOLD, 25);
		GridBagConstraints gbc=new GridBagConstraints();
		
		gbc.weightx=1.0;
		
		//lbl
				gbc.gridx=0;
				gbc.gridy=0;
				gbc.fill=GridBagConstraints.NONE;
				JLabel lblT=new JLabel("Término");
				lblT.setFont(font);
				add(lblT,gbc);
				
				//txtwords
				gbc.gridx=1;
				gbc.gridwidth=2;
				gbc.fill=GridBagConstraints.HORIZONTAL;
				add(txtWordFind,gbc);
				
				gbc.gridx=5;
				gbc.gridwidth=1;
				gbc.fill=GridBagConstraints.NONE;
				add(btnFindWord,gbc);
				
				gbc.gridx=1;
				gbc.gridy=1;
				gbc.fill=GridBagConstraints.HORIZONTAL;
				add(new JLabel(" "),gbc);
				
				gbc.gridx=0;
				
				/*gbc.fill=GridBagConstraints.NONE;
				JLabel desc=new JLabel("Descripción");
				desc.setFont(font);
				add(desc,gbc);*/
				
				gbc.gridy=2;
				gbc.gridx=0;
				gbc.gridwidth=4;
				gbc.gridheight=7;
				gbc.fill=GridBagConstraints.BOTH;
				add(new JScrollPane(show),gbc);
				
				gbc.gridx=5;
				gbc.gridwidth=1;
				gbc.gridheight=1;
				add(image,gbc);
				
				gbc.gridy=6;
				add(imageTwo,gbc);
		
		
	}

	public JTextField getTxtWordFind() {
		return txtWordFind;
	}

	public void setTxtWordFind(JTextField txtWordFind) {
		this.txtWordFind = txtWordFind;
	}

	public JTextArea getShow() {
		return show;
	}

	public void setShow(JTextArea show) {
		this.show = show;
	}

}
