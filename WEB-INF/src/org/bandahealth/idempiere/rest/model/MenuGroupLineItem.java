package org.bandahealth.idempiere.rest.model;

import java.sql.Timestamp;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "lineitems")
public class MenuGroupLineItem extends BaseEntity {

	private static final long serialVersionUID = 1L;
	private int lineNumber;

	public MenuGroupLineItem(int clientId, int orgId, String uuid, boolean isActive, Timestamp created, int createdBy,
			String name, String description, int infoWindowId, int windowId, int processId, int formId,
			int includedRoleId, int lineNumber, String buttonText) {
		super(clientId, orgId, uuid, isActive, created, createdBy, name, description);

		this.lineNumber = lineNumber;
	}

	@XmlElement
	public int getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}
}
