package org.bandahealth.idempiere.rest.model;

import java.sql.Timestamp;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "menugroupitem")
public class MenuGroupItem extends BaseEntity {

	private static final long serialVersionUID = 1L;
	private int lineNumber;
	private List<MenuGroupLineItem> items;

	public MenuGroupItem(int clientId, int orgId, String uuid, boolean isActive, Timestamp created, int createdBy,
			String name, String description, int lineNumber, List<MenuGroupLineItem> groupLineItems) {
		super(clientId, orgId, uuid, isActive, created, createdBy, name, description);

		this.lineNumber = lineNumber;
		this.items = groupLineItems;
	}

	@XmlElement
	public int getLineNumber() {
		return lineNumber;
	}

	@XmlElement
	public List<MenuGroupLineItem> getGroupLineItems() {
		return items;
	}
}
