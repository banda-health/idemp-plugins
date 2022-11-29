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
	private String accountUuid;

	public ExpenseCategory() {
	}
	public ExpenseCategory(String uuid, String name, boolean isLocked, String accountUuid) {
		setUuid(uuid);
		setName(name);
		setIsLocked(isLocked);
		setAccountUuid(accountUuid);
	}

	public ExpenseCategory(String uuid, String name, boolean isLocked, String created, String description,
												 boolean isActive, String accountUuid) {
		setUuid(uuid);
		setName(name);
		setDescription(description);
		setCreated(created);
		setIsActive(isActive);
		setIsLocked(isLocked);
		setAccountUuid(accountUuid);
	}

	public ExpenseCategory(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy, String name,
												 String description, boolean isLocked, String accountUuid) {
		super(clientId, orgId, uuid, isActive, created, createdBy, name, description);
		setIsLocked(isLocked);
		setAccountUuid(accountUuid);
	}

	public boolean getIsLocked() {
		return isLocked;
	}

	public void setIsLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}

	public String getAccountUuid() { return accountUuid; }

	public void setAccountUuid(String accountUuid) {
		this.accountUuid = accountUuid;
	}

}
