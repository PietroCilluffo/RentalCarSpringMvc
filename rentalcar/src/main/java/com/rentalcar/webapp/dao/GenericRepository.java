package com.rentalcar.webapp.dao;

import java.io.Serializable;
import java.util.List;


//strato di persistenza
// I le entità, E la chiave primaria
public interface GenericRepository <I extends Serializable, E extends Serializable>{
	//query che ci sono in tutte le web application
	
	
	List<I> SelTutti();
	
	void Inserisci( I entity);
	void Aggiorna( I entity);
	void Elimina( I entity);
	void EliminaById( E id);
	I SelById(E id);
	
}
