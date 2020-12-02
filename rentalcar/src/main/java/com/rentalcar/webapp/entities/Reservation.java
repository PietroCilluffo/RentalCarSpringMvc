package com.rentalcar.webapp.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "reservation")

public class Reservation implements Serializable {
	 private static final long serialVersionUID = 1L;
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)

	 @Column(name = "id")
	 private long id;
	 

	
	 @Column(name = "dataInizio", columnDefinition="TIMESTAMP")
	 @DateTimeFormat(pattern="dd/MM/yyyy")
	 private LocalDate dataInizio;
	 
	 
	 @Column(name = "dataFine", columnDefinition="TIMESTAMP")
	 @DateTimeFormat(pattern="dd/MM/yyyy")
	 private LocalDate dataFine;
	
	
	 @Column(name = "approvazione")
	 private boolean approvazione;
	 
	 @ManyToOne(cascade = { CascadeType.REMOVE})
	 @JoinColumn(name = "idUser",referencedColumnName = "id")
	 private User user;
	 
	 
	 @ManyToOne
	 @JoinColumn(name = "idVehicle",referencedColumnName = "id")
	 private Vehicle vehicle;
	 
		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}
		public Vehicle getVehicle() {
			return vehicle;
		}

		public void setVehicle(Vehicle vehicle) {
			this.vehicle = vehicle;
		}
	
	
	 public Reservation( User user, LocalDate dataInizio,LocalDate dataFine, Vehicle vehicle) {
		 this.user = user;
		 this.dataInizio = dataInizio;
		 this.dataFine = dataFine;
		 this.vehicle = vehicle;
		 this.approvazione = false;

		 
	 }

    public Reservation() {
    	
    }
  public Reservation(LocalDate dataInizio, LocalDate dataFine) {
	  this.dataFine = dataFine;
		 this.dataInizio = dataInizio;
    }
    
    
  
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public LocalDate getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(LocalDate dataInizio) {
		this.dataInizio = dataInizio;
	}

	public LocalDate getDataFine() {
		return dataFine;
	}

	public void setDataFine(LocalDate dataFine) {
		this.dataFine = dataFine;
	}


	public boolean getApprovazione() {
		return approvazione;
	}

	public void setApprovazione(boolean approvazione) {
		this.approvazione = approvazione;
	}
	

	 
}