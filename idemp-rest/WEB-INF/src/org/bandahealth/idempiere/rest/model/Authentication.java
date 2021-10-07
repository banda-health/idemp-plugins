package org.bandahealth.idempiere.rest.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "authentication")
public class Authentication {
	private String username;
	private String password;
	private String newPassword;
	private String securityQuestion;
	private String answer;
	private Integer clientId;
	private Integer roleId;
	private Integer organizationId;
	private String warehouseUuid;
	/**
	 * The language that is stored in the DB as AD_Language (e.g. en_US)
	 */
	private String language;

	public Authentication() {
	}

	@XmlElement
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@XmlElement
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	@XmlElement
	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer adClientId) {
		this.clientId = adClientId;
	}

	@XmlElement
	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer adRoleId) {
		this.roleId = adRoleId;
	}

	@XmlElement
	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer adOrganizationId) {
		this.organizationId = adOrganizationId;
	}

	@XmlElement
	public String getWarehouseUuid() {
		return warehouseUuid;
	}

	public void setWarehouseUuid(String warehouseUuid) {
		this.warehouseUuid = warehouseUuid;
	}

	public String getSecurityQuestion() {
		return securityQuestion;
	}

	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
}
