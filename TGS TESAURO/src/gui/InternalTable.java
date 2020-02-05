package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class InternalTable extends JInternalFrame {
	
	private MainWindow window;
	private JDesktopPane desktop;
	
	private JTable table;
	private DefaultTableModel model;
	
	public InternalTable(MainWindow window, JDesktopPane desktop){
		this.window=window;
		this.desktop=desktop;
		setTitle("T�rminos agregados");
		setSize(new Dimension(735, 425));
		setBackground(new Color(231, 230, 177));
		setLayout(new GridLayout(0,1));
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
		
		String[] headings=new String[]{"T�rmino"};
		
		model=new DefaultTableModel(headings,0);
		table=new JTable(model);
		table.setModel(model);
		table.setEnabled(false);
		
	}

	private void addElemtens() {
		add(new JScrollPane(table));
		
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public DefaultTableModel getModel() {
		return model;
	}

	public void setModel(DefaultTableModel model) {
		this.model = model;
	}
}
