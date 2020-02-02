package model;

import controll.ControlThesaurus;

public interface ActionsThesaurus {
	
	String VIEW_ADD_WORDS="Interfaz a�adir words";
	String VIEW_WORDS="Interfaz words";
	
	String ADD_WORD="A�adir Palabra";
	String FIND_WORD="Buscar Palabra";
	String UPDATE_WORD="Actualizar palabra";
	String DELETE_WORD="Borrar Palabra";
	
	void exit();
	void begin();
	String[] readInput(String option);
	void writeOuput(String option,String[] output, boolean state);
	void setControll(ControlThesaurus controll);

}
