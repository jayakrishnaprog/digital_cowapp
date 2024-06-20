package com.bezkoder.spring.datajpa.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "cc10")
@Setter
@Getter
@ToString
public class Cow{
	public Cow() {}
	@Id
	@JsonIgnore
	int sno;
	public Cow(int sno, LocalDateTime timeStamp, String id, int spo2, int bpm, int vib, double temperature,
			BigDecimal x, BigDecimal y, BigDecimal z, BigDecimal mX, BigDecimal mY, BigDecimal mZ, BigDecimal gX,
			BigDecimal gY, BigDecimal gZ) {
		super();
		this.sno = sno;
		this.timeStamp = timeStamp;
		this.id = id;
		this.spo2 = spo2;
		this.bpm = bpm;
		this.vib = vib;
		this.temperature = temperature;
		X = x;
		Y = y;
		Z = z;
		MX = mX;
		MY = mY;
		MZ = mZ;
		GX = gX;
		GY = gY;
		GZ = gZ;
	}




	public int getSno() {
		return sno;
	}
	
	


	@Override
	public String toString() {
		return "Cow [sno=" + sno + ", timeStamp=" + timeStamp + ", id=" + id + ", spo2=" + spo2 + ", bpm=" + bpm
				+ ", vib=" + vib + ", temperature=" + temperature + ", X=" + X + ", Y=" + Y + ", Z=" + Z + ", MX=" + MX
				+ ", MY=" + MY + ", MZ=" + MZ + ", GX=" + GX + ", GY=" + GY + ", GZ=" + GZ + "]";
	}




	public void setSno(int sno) {
		this.sno = sno;
	}
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getSpo2() {
		return spo2;
	}
	public void setSpo2(int spo2) {
		this.spo2 = spo2;
	}
	public int getBpm() {
		return bpm;
	}
	public void setBpm(int bpm) {
		this.bpm = bpm;
	}
	public double getTemperature() {
		return temperature;
	}
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	private LocalDateTime timeStamp;
	private String id;
	private int spo2;
	private int bpm;
	private int vib;
	public int getVib() {
		return vib;
	}


	public void setVib(int vib) {
		this.vib = vib;
	}
	private double temperature;
	private BigDecimal X;
	private BigDecimal Y;
	private BigDecimal Z;
	private BigDecimal MX;
	public BigDecimal getMX() {
		return MX;
	}


	public void setMX(BigDecimal mX) {
		MX = mX;
	}


	public BigDecimal getMY() {
		return MY;
	}


	public void setMY(BigDecimal mY) {
		MY = mY;
	}


	public BigDecimal getMZ() {
		return MZ;
	}


	public void setMZ(BigDecimal mZ) {
		MZ = mZ;
	}


	public BigDecimal getGX() {
		return GX;
	}


	public void setGX(BigDecimal gX) {
		GX = gX;
	}


	public BigDecimal getGY() {
		return GY;
	}


	public void setGY(BigDecimal gY) {
		GY = gY;
	}


	public BigDecimal getGZ() {
		return GZ;
	}


	public void setGZ(BigDecimal gZ) {
		GZ = gZ;
	}
	private BigDecimal MY;
	private BigDecimal MZ;
	private BigDecimal GX;
	private BigDecimal GY;
	private BigDecimal GZ;
	public BigDecimal getX() {
		return X;
	}


	public void setX(BigDecimal x) {
		X = x;
	}


	public BigDecimal getY() {
		return Y;
	}


	public void setY(BigDecimal y) {
		Y = y;
	}


	public BigDecimal getZ() {
		return Z;
	}




	


	public void setZ(BigDecimal z) {
		Z = z;
	}
	
	

	
}
