package de.garden.sensors;

import java.util.Random;

public class WindSensor {
	
//	*******************************************
//	*				  Attributs
//	*******************************************
	
	protected int rpms;
	
	protected boolean wind;
	
//	*******************************************
//	*				Konstruktors
//	*******************************************
	
	public WindSensor(int rpms, boolean wind) {
		super();
		this.rpms = rpms;
		this.wind = wind;
	}
	
	public WindSensor() {
		Random lotto= new Random();
		this.rpms = lotto.nextInt(200);;
		this.wind = lotto.nextBoolean();
	}
	
//	*******************************************
//	*				 Functions
//	*******************************************
	
	public int getRpms() {
		return rpms;
	}

	public void setRpms(int rpms) {
		this.rpms = rpms;
	}

	public boolean isWind() {
		return wind;
	}

	public void setWind(boolean wind) {
		this.wind = wind;
	}

	@Override
	public String toString() {
		return "WindSensor [rpms=" + rpms + ", wind=" + wind + "]";
	}

}
