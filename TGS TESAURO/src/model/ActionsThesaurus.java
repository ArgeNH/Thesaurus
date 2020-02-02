package model;

import controll.ControlThesaurus;

public interface ActionsThesaurus {
	
	//interfaces
	String VIEW_ADD_WORDS="Interfaz añadir words";
	String VIEW_WORDS="Interfaz words";
	
	//Acciones
	String ADD_WORD="Añadir Palabra";
	String FIND_WORD="Buscar Palabra";
	String UPDATE_WORD="Actualizar palabra";
	String DELETE_WORD="Borrar Palabra";
	
	void exit();
	void begin();
	String[] readInput(String option);
	void writeOuput(String option,String[] output, boolean state);
	void setControll(ControlThesaurus controll);

}
