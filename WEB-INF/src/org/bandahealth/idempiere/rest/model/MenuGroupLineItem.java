package org.bandahealth.idempiere.rest.model;

import java.sql.Timestamp;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "menugrouplineitem")
public class MenuGroupLineItem extends BaseEntity {

	private static final long serialVersionUID = 1L;
	private int infoWindowId;
	private int windowId;
	private int processId;
	private int formId;
	private int includedRoleId;
	private int lineNumber;
	private String buttonText;

	public MenuGroupLineItem(int clientId, int orgId, String uuid, boolean isActive, Timestamp created, int createdBy,
			String name, String description, int infoWindowId, int windowId, int processId, int formId,
			int includedRoleId, int lineNumber, String buttonText) {
		super(clientId, orgId, uuid, isActive, created, createdBy, name, description);

		this.infoWindowId = infoWindowId;
		this.windowId = windowId;
		this.processId = processId;
		this.formId = formId;
		this.includedRoleId = includedRoleId;
		this.lineNumber = lineNumber;
		this.buttonText = buttonText;
	}

	@XmlElement
	public int getInfoWindowId() {
		return infoWindowId;
	}

	public void setInfoWindowId(int infoWindowId) {
		this.infoWindowId = infoWindowId;
	}

	@XmlElement
	public int getWindowId() {
		return windowId;
	}

	public void setWindowId(int windowId) {
		this.windowId = windowId;
	}

	@XmlElement
	public int getProcessId() {
		return processId;
	}

	public void setProcessId(int processId) {
		this.processId = processId;
	}

	@XmlElement
	public int getFormId() {
		return formId;
	}

	public void setFormId(int formId) {
		this.formId = formId;
	}

	@XmlElement
	public int getIncludedRoleId() {
		return includedRoleId;
	}

	public void setIncludedRoleId(int includedRoleId) {
		this.includedRoleId = includedRoleId;
	}

	@XmlElement
	public int getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}

	@XmlElement
	public String getButtonText() {
		return buttonText;
	}

	public void setButtonText(String buttonText) {
		this.buttonText = buttonText;
	}
}
