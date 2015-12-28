package secondweek;

import java.util.Arrays;

public class Computer {
	private String type;
	private int procSpeed;
	private int [] files;
	
	public Computer() {
	    type="unknown";
		procSpeed=0;
		files=new int[1];
	}
	
	public Computer(String type, int procSpeed, int[] files) {
		this.type = type;
		this.procSpeed = procSpeed;
		this.files = files;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public int getProcSpeed() {
		return procSpeed;
	}
	
	public void setProcSpeed(int procSpeed) {
		if(procSpeed<100){
		throw new IllegalArgumentException();
		}
		else{
			this.procSpeed=procSpeed;
		}
	}
		
	public int[] getFiles() {
		return files;
	}
	
	public void setFiles(int[] files) {
		this.files = files;
	}

	@Override
	public String toString() {
		return "Computer [type=" + type + ", procSpeed=" + procSpeed
				+ ", files=" + Arrays.toString(files) + "]";
	}
	
	
	

}
