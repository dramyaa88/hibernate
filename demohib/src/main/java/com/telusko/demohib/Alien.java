package com.telusko.demohib;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "alien_table")
public class Alien {
	
	@Id
	
	private int aid;
	//@Transient-drop column
	private AlienName aname;
	
	public void setAname(AlienName aname) {
		this.aname = aname;
	}
	//@Column(name = "alien_color")
	private String colour;
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	@Override
	public String toString() {
		return "Alien [aid=" + aid + ", aname=" + aname + ", colour=" + colour + "]";
	}
	
	

}
