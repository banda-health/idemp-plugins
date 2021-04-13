package org.bandahealth.idempiere.rest.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import org.bandahealth.idempiere.rest.utils.*;

@XmlRootElement(name = "response")
@JsonInclude(value = Include.NON_NULL)
public class AuthResponse {

	private String token;
	private Response.Status status;
	private int userId;
	private String username;
	private List<Client> clients = new ArrayList<>();
	private boolean hasAcceptedTermsOfUse;
	private int roleId;
	private boolean needsToResetPassword;
	private List<String> securityQuestions;
	private boolean hasAccessToReports;
	private boolean isAdministrator;
	private Map<String, AccessLevel> windowAccessLevel;

	public AuthResponse() {
	}

	public AuthResponse(Response.Status status) {
		this.status = status;
	}

	public AuthResponse(String token, Status status, int userId) {
		this.token = token;
		this.status = status;
		this.userId = userId;
	}

	public AuthResponse(String token, Response.Status status) {
		this.token = token;
		this.status = status;
	}

	@XmlElement
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@XmlElement
	public Response.Status getStatus() {
		return status;
	}

	public void setStatus(Response.Status status) {
		this.status = status;
	}

	@XmlElement
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@XmlElement
	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	@XmlElement
	public boolean isHasAcceptedTermsOfUse() {
		return hasAcceptedTermsOfUse;
	}

	public void setHasAcceptedTermsOfUse(boolean hasAcceptedTermsOfUse) {
		this.hasAcceptedTermsOfUse = hasAcceptedTermsOfUse;
	}

	@XmlElement
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public boolean getNeedsToResetPassword() {
		return needsToResetPassword;
	}

	public void setNeedsToResetPassword(boolean needsToResetPassword) {
		this.needsToResetPassword = needsToResetPassword;
	}

	public List<String> getSecurityQuestions() {
		return securityQuestions;
	}

	public void setSecurityQuestions(List<String> securityQuestions) {
		this.securityQuestions = securityQuestions;
	}

	@XmlElement
	public boolean isHasAccessToReports() {
		return hasAccessToReports;
	}

	public void setHasAccessToReports(boolean hasAccessToReports) {
		this.hasAccessToReports = hasAccessToReports;
	}

	@XmlElement
	public boolean isIsAdministrator() {
		return isAdministrator;
	}

	public void setIsAdministrator(boolean isAdministrator) {
		this.isAdministrator = isAdministrator;
	}

	public Map<String, AccessLevel> getWindowAccessLevel() {
		return windowAccessLevel;
	}

	public void setWindowAccessLevel(Map<String, AccessLevel> windowAccessLevel) {
		this.windowAccessLevel = windowAccessLevel;
	}
	
	
}
