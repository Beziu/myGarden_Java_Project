package de.garden.sensors;

import java.util.Objects;

/**
 * Stering the water pump for plants the garden<br><br>
 * 
 * Can switch on and off pump for watering garden 
 * and check the switch status<br><br>
 *  
 * @author grzeg
 *
 */
public class WaterPump {
	
	/**
	 * State of the water pump
	 */
	protected boolean state;

	/**
	 * Standard toString function
	 * @return string ON/OFF water pump state
	 */
	@Override
	public String toString() {
		String stateName;
		if (state) {
			stateName = "ON";
		} else {
			stateName = "OFF";
		}
		return stateName;
	}
	
	/**
	 * ToString in Console view
	 * @return string ON/OFF water pump state in console
	 */
	public String toStringConsole() {
		String stateName;
		if (state) {
			stateName = "ON";
		} else {
			stateName = "OFF";
		}
		return "WaterPump state: " + stateName;
	}

	/**
	 * @return the state
	 */
	public boolean isState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(boolean state) {
		this.state = state;
	}

	@Override
	public int hashCode() {
		return Objects.hash(state);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		WaterPump other = (WaterPump) obj;
		return state == other.state;
	}

}
