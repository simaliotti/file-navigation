package com.aliottisimon.club;

import java.io.Serializable;


public class Club implements Serializable{

	private String name;
	private String adress;
	private String idMembres;
	
	
	
	
	
	public Club() {
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getIdMembres() {
		return idMembres;
	}
	public void setIdMembres(String idMembres) {
		this.idMembres = idMembres;
	}
	@Override
	public String toString() {
		return "Club [name=" + name + ", adress=" + adress + ", idMembres=" + idMembres + "]";
	}
	
	
	
	
	
}


