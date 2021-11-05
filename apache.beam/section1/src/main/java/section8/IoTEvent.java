package section8;

import java.io.Serializable;

public class IoTEvent implements Serializable{

	private String deviceId;
	private String name;
	private double temperature;
	
	public IoTEvent(){
		
	}

	public IoTEvent(String deviceId, String name, double temperature) {
		super();
		this.deviceId = deviceId;
		this.name = name;
		this.temperature = temperature;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	@Override
	public String toString() {
		return "IoTEvent [deviceId=" + deviceId + ", name=" + name + ", temperature=" + temperature + "]";
	}
	
}
