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
	private Account account;

	public ExpenseCategory() {
	}

	public ExpenseCategory(String uuid, String name, boolean isLocked, Account account) {
		setUuid(uuid);
		setName(name);
		setAccount(account);
	}

	public ExpenseCategory(String uuid, String name, boolean isLocked, String created, String description,
												 boolean isActive, Account account) {
		setUuid(uuid);
		setName(name);
		setDescription(description);
		setCreated(created);
		setIsActive(isActive);
		setAccount(account);
	}

	public ExpenseCategory(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy, String name,
												 String description, boolean isLocked, Account account) {
		super(clientId, orgId, uuid, isActive, created, createdBy, name, description);
		setAccount(account);
	}

	@XmlElement
	public boolean getIsLocked() {
		return isLocked;
	}

	public void setIsLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}

	@XmlElement
	public Account getAccount() { return account; }

	public void setAccount(Account account) {
		this.account = account;
	}

}
