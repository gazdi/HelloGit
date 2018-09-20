package model;

public class MCC {
	private String elavonCode;
	private String mccCode;
	private String mccDescription;

	public MCC(String elavonCode, String mccCode, String mccDescription) {
		this.elavonCode = elavonCode;
		this.mccCode = mccCode;
		this.mccDescription = mccDescription;
	}
	public String getElavonCode() {
		return elavonCode;
	}
	public void setElavonCode(String elavonCode) {
		this.elavonCode = elavonCode;
	}
	public String getMccCode() {
		return mccCode;
	}
	public void setMccCode(String mccCode) {
		this.mccCode = mccCode;
	}
	public String getMccDescription() {
		return mccDescription;
	}
	public void setMccDescription(String mccDescription) {
		this.mccDescription = mccDescription;
	}
	
	@Override
	public String toString() {
		return new String("{\"elavonCode\":\"" + getElavonCode() + "\",\"mccCode\":\"" + getMccCode() + "\",\"mccDescription\":\"" + getMccDescription() + "\"}");
	}
}
