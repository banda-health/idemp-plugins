package org.bandahealth.idempiere.rest.model;

import org.bandahealth.idempiere.base.model.MBHClientConcept;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class ClientConcept extends BaseMetadata {

	private static final long serialVersionUID = -2371895569523894294L;
	private Client mappingClient;
	@JsonIgnore
	private int clientMappingId;
	private Concept concept;
	@JsonIgnore
	private int conceptId;
	private String name;

	public ClientConcept() {
	}

	public ClientConcept(MBHClientConcept entity) {
		super(entity);

		setClientMappingId(entity.getBH_Client_Mapping_ID());
		setConceptId(entity.getBH_Concept_ID());
		setName(entity.getName());
	}

	public Client getMappingClient() {
		return mappingClient;
	}

	public void setMappingClient(Client mappingClient) {
		this.mappingClient = mappingClient;
	}

	public Concept getConcept() {
		return concept;
	}

	public void setConcept(Concept concept) {
		this.concept = concept;
	}

	public int getClientMappingId() {
		return clientMappingId;
	}

	public void setClientMappingId(int clientMappingId) {
		this.clientMappingId = clientMappingId;
	}

	public int getConceptId() {
		return conceptId;
	}

	public void setConceptId(int conceptId) {
		this.conceptId = conceptId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
