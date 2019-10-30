package org.bandahealth.idempiere.rest.model;

import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "response")
public class AuthResponse {

	private String token;

	private Response.Status status;

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

}
