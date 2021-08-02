package de.garden.sensors;

public class WindSensor {
	
	protected int rpms;
	
	protected boolean wind;

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

}
