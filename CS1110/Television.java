
public class Television {
	//MANUFACTURER
	private String Manufacturer;
	
	//SCREEN_SIZE
	private int ScreenSize;
	
	//powerOn
	private boolean powerOn;
	
	//channel
	private int channel;
	
	//volume
	private int volume;
	
	
	
	
	
	
	
	
	
	//Television
	public Television(String Manufacturer, int ScreenSize){
		this.Manufacturer = Manufacturer;
		this.ScreenSize = ScreenSize;
		powerOn = false;
		volume = 20;
		channel = 2;
	}
	
	
	
	//Manufacturer
	public String getManufacturer() {
		return Manufacturer;
	}

	
	//ScreenSize
	public int getScreenSize() {
		return ScreenSize;
	}
	
	
	//powerOn
	public boolean isPowerOn() {
		return powerOn;
	}
	public void power() {
		this.powerOn = !powerOn;
	}
	
	
	//channel
	public int getChannel() {
		return channel;
	}

	public void setChannel(int channel) {
		this.channel = channel;
	}

	
	//volume
	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}
	
	public void increaseVolume() {
		this.volume += 1;
	}
	
	public void decreaseVolume() {
		this.volume -= 1;
	}
	
	

}
