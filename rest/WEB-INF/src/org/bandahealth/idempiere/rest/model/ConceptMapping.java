package org.bandahealth.idempiere.rest.model;

import org.bandahealth.idempiere.base.model.MBHConceptMapping;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class ConceptMapping extends BaseMetadata {

	private static final long serialVersionUID = -2371873579523894294L;
	@JsonIgnore
	private int conceptId;
	private String externalId;
	private String fromConceptCode;
	private String fromConceptName;
	private String fromConceptNameResolved;
	private String fromConceptUrl;
	private String mapType;
	private String oclId;
	private String owner;
	private String source;
	private String toConceptCode;
	private String toConceptName;
	private String toConceptNameResolved;
	private String toConceptUrl;

	public ConceptMapping() {
	}

	public ConceptMapping(MBHConceptMapping entity) {
		super(entity);
		setConceptId(entity.getBH_Concept_ID());
		setExternalId(entity.getBH_ExternalID());
		setFromConceptCode(entity.getBH_From_Concept_Code());
		setFromConceptName(entity.getBH_From_Concept_Name());
		setFromConceptNameResolved(entity.getBH_From_Concept_Name_Resolved());
		setFromConceptUrl(entity.getBH_From_Concept_Url());
		setMapType(entity.getBH_Map_Type());
		setOclId(entity.getBH_OclID());
		setOwner(entity.getBH_Owner());
		setSource(entity.getBH_Source());
		setToConceptCode(entity.getBH_To_Concept_Code());
		setToConceptName(entity.getBH_To_Concept_Name());
		setToConceptNameResolved(entity.getBH_To_Concept_Name_Resolved());
		setToConceptUrl(entity.getBH_To_Concept_Url());
	}

	public int getConceptId() {
		return conceptId;
	}

	public void setConceptId(int conceptId) {
		this.conceptId = conceptId;
	}

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public String getFromConceptCode() {
		return fromConceptCode;
	}

	public void setFromConceptCode(String fromConceptCode) {
		this.fromConceptCode = fromConceptCode;
	}

	public String getFromConceptName() {
		return fromConceptName;
	}

	public void setFromConceptName(String fromConceptName) {
		this.fromConceptName = fromConceptName;
	}

	public String getFromConceptNameResolved() {
		return fromConceptNameResolved;
	}

	public void setFromConceptNameResolved(String fromConceptNameResolved) {
		this.fromConceptNameResolved = fromConceptNameResolved;
	}

	public String getFromConceptUrl() {
		return fromConceptUrl;
	}

	public void setFromConceptUrl(String fromConceptUrl) {
		this.fromConceptUrl = fromConceptUrl;
	}

	public String getMapType() {
		return mapType;
	}

	public void setMapType(String mapType) {
		this.mapType = mapType;
	}

	public String getOclId() {
		return oclId;
	}

	public void setOclId(String oclId) {
		this.oclId = oclId;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getToConceptCode() {
		return toConceptCode;
	}

	public void setToConceptCode(String toConceptCode) {
		this.toConceptCode = toConceptCode;
	}

	public String getToConceptName() {
		return toConceptName;
	}

	public void setToConceptName(String toConceptName) {
		this.toConceptName = toConceptName;
	}

	public String getToConceptNameResolved() {
		return toConceptNameResolved;
	}

	public void setToConceptNameResolved(String toConceptNameResolved) {
		this.toConceptNameResolved = toConceptNameResolved;
	}

	public String getToConceptUrl() {
		return toConceptUrl;
	}

	public void setToConceptUrl(String toConceptUrl) {
		this.toConceptUrl = toConceptUrl;
	}

}
