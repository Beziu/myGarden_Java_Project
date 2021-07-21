package de.garden.sensors;

import java.util.Objects;

/**
 * Stering the water pump for plants the garden
 * 
 * Can switch on and off pump for watering garden 
 * and check the switch status
 *  
 * @author grzeg
 *
 */
public class WaterPump {
	
	private boolean state;

	@Override
	public String toString() {
		return "WaterPump [state=" + state + "]";
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
