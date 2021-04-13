package org.bandahealth.idempiere.rest.model;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@XmlRootElement(name = "response")
@JsonInclude(value = Include.NON_NULL)
public class AccessLevel {

	private boolean canWrite = false;
	private boolean canDeactivate = false;
	
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
}
