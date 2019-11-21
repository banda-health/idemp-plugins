package org.bandahealth.idempiere.rest.model;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "response")
public class AuthResponse {

	private String token;

	private Response.Status status;

	private int userId;

	private List<Client> clients = new ArrayList<>();

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

}
