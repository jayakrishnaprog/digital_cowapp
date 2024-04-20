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
@Table(name = "cc2")
@Setter
@Getter
@ToString
public class Cow{
	public Cow() {}
	@Id
	@JsonIgnore
	int sno;
	public int getSno() {
		return sno;
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
	private double temperature;
	private BigDecimal X;
	private BigDecimal Y;
	private BigDecimal Z;
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


	public Cow(int sno, LocalDateTime timeStamp, String id, int spo2, int bpm, double temperature, BigDecimal x,
			BigDecimal y, BigDecimal z) {
		super();
		this.sno = sno;
		this.timeStamp = timeStamp;
		this.id = id;
		this.spo2 = spo2;
		this.bpm = bpm;
		this.temperature = temperature;
		X = x;
		Y = y;
		Z = z;
	}


	@Override
	public String toString() {
		return "Cow [sno=" + sno + ", timeStamp=" + timeStamp + ", id=" + id + ", spo2=" + spo2 + ", bpm=" + bpm
				+ ", temperature=" + temperature + ", X=" + X + ", Y=" + Y + ", Z=" + Z + "]";
	}


	public void setZ(BigDecimal z) {
		Z = z;
	}
	
	

	
}
