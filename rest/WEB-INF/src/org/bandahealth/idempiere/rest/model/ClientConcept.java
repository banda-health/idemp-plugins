package org.bandahealth.idempiere.rest.model;

import org.bandahealth.idempiere.base.model.MBHClientConcept;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class ClientConcept extends BaseMetadata {

	private static final long serialVersionUID = -2371895569523894294L;
	private Client mappingClient;
	private Concept concept;
	@JsonIgnore
	private int conceptId;
	private String displayName;

	public ClientConcept() {
	}

	public ClientConcept(MBHClientConcept entity) {
		super(entity);

		setConceptId(entity.getBH_Concept_ID());
		setDisplayName(entity.getBH_Display_Name());
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

	public int getConceptId() {
		return conceptId;
	}

	public void setConceptId(int conceptId) {
		this.conceptId = conceptId;
	}
	
	public String getDisplayName() {
		return displayName;
	}
	
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
}
