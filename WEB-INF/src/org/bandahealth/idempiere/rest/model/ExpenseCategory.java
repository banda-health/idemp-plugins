package org.bandahealth.idempiere.rest.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@XmlRootElement(name = "expense")
@JsonInclude(value = Include.NON_NULL)
public class ExpenseCategory extends BaseEntity {

	private static final long serialVersionUID = 1L;
	private boolean isLocked;
	private int accountId;

	public ExpenseCategory() {
	}

	public ExpenseCategory(String uuid, String name, boolean isLocked, int accountId) {
		setUuid(uuid);
		setName(name);
		setIsLocked(isLocked);
		setAccountId(accountId);
	}

	public ExpenseCategory(String uuid, String name, boolean isLocked, String created, String description,
												 boolean isActive, int accountId) {
		setUuid(uuid);
		setName(name);
		setDescription(description);
		setCreated(created);
		setIsActive(isActive);
		setIsLocked(isLocked);
		setAccountId(accountId);
	}

	public ExpenseCategory(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy, String name,
												 String description, boolean isLocked, int accountId) {
		super(clientId, orgId, uuid, isActive, created, createdBy, name, description);
		setIsLocked(isLocked);
		setAccountId(accountId);
	}

	@XmlElement
	public boolean getIsLocked() {
		return isLocked;
	}

	public void setIsLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}

	@XmlElement
	public int getAccountId() { return accountId; }

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

}
