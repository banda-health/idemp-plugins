package org.bandahealth.idempiere.rest.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@XmlRootElement(name = "lineitems")
@JsonInclude(value = Include.NON_NULL)
public class MenuGroupLineItem extends BaseEntity {

	private static final long serialVersionUID = 1L;
	private int lineNumber;
	private String iconClassName;
	private String buttonClassName;

	public MenuGroupLineItem(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy,
			String name, String description, int infoWindowId, int windowId, int processId, int formId,
			int includedRoleId, int lineNumber, String buttonText, String iconClassName, String buttonClassName) {
		super(clientId, orgId, uuid, isActive, created, createdBy, name, description);

		this.lineNumber = lineNumber;
		this.iconClassName = iconClassName;
		this.buttonClassName = buttonClassName;
	}

	@XmlElement
	public int getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}

	@XmlElement
	public String getIconClassName() {
		return iconClassName;
	}

	public void setIconClassName(String iconClassName) {
		this.iconClassName = iconClassName;
	}

	@XmlElement
	public String getButtonClassName() {
		return buttonClassName;
	}

	public void setButtonClassName(String buttonClassName) {
		this.buttonClassName = buttonClassName;
	}

}
