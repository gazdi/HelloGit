package model;

import java.util.List;

public class GetMCCCodesSuccessResponse {
	List<MCC> MCCs;

	public GetMCCCodesSuccessResponse(List<MCC> mCCs) {
		this.MCCs = mCCs;
	}

	public List<MCC> getMCCs() {
		return MCCs;
	}

	public void setMCCs(List<MCC> mCCs) {
		MCCs = mCCs;
	}
	
	@Override
	public String toString() {
		return getMCCs().toString();
		
	}
}
