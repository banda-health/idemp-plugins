package org.bandahealth.idempiere.rest.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class AccessLevel {
	

	private String windowUuid;
	private boolean canWrite;
	private boolean canDeactivate;
	
	public AccessLevel() { } 

	public boolean isCanWrite() {
		return canWrite;
	}

	public boolean isCanDeactivate() {
		return canDeactivate;
	}

	public void setCanWrite(boolean canWrite) {
		this.canWrite = canWrite;
	}

	public void setCanDeactivate(boolean canDeactivate) {
		this.canDeactivate = canDeactivate;
	}

	public String getWindowUuid() {
		return windowUuid;
	}

	public void setWindowUuid(String windowUuid) {
		this.windowUuid = windowUuid;
	}
}
