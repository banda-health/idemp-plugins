package org.bandahealth.idempiere.rest.model;

import java.util.ArrayList;
import java.util.List;

import org.bandahealth.idempiere.base.model.MBHConcept;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class Concept extends BaseMetadata {

	private static final long serialVersionUID = -2371895569523894294L;
	private String conceptClass;
	private String conceptType;
	private String displayLocale;
	private String displayName;
	private String externalId;
	private String oclId;
	private String owner;
	private String source;
	private String dataType;
	private String description;
	private String url;
	private List<ConceptMapping> toConceptMappings = new ArrayList<>();
	private List<ConceptExtra> conceptExtras = new ArrayList<>();
	private List<Concept> fromConceptMappings = new ArrayList<>();

	
	public Concept() {
	}

	public Concept(MBHConcept entity) {
		super(entity);
		setUuid(entity.getBH_Concept_UU());
		setConceptClass(entity.getbh_concept_class());
		setConceptType(entity.getBH_Concept_Type());
		setDisplayLocale(entity.getBH_Display_Locale());
		setDisplayName(entity.getBH_Display_Name());
		setExternalId(entity.getBH_ExternalID());
		setOclId(entity.getBH_OclID());
		setOwner(entity.getBH_Owner());
		setSource(entity.getBH_Source());
		setDataType(entity.getBH_Data_Type());
		setDescription(entity.getDescription());
		setUrl(entity.getURL());
	}

	public String getConceptClass() {
		return conceptClass;
	}

	public void setConceptClass(String conceptClass) {
		this.conceptClass = conceptClass;
	}

	public String getConceptType() {
		return conceptType;
	}

	public void setConceptType(String conceptType) {
		this.conceptType = conceptType;
	}

	public String getDisplayLocale() {
		return displayLocale;
	}

	public void setDisplayLocale(String displayLocale) {
		this.displayLocale = displayLocale;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public List<ConceptMapping> getToConceptMappings() {
		return toConceptMappings;
	}

	public void setToConceptMappings(List<ConceptMapping> conceptMappings) {
		this.toConceptMappings = conceptMappings;
	}

	public List<ConceptExtra> getConceptExtras() {
		return conceptExtras;
	}

	public void setConceptExtras(List<ConceptExtra> conceptExtras) {
		this.conceptExtras = conceptExtras;
	}

	public List<Concept> getFromConceptMappings() {
		return fromConceptMappings;
	}

	public void setFromConceptMappings(List<Concept> fromConceptMappings) {
		this.fromConceptMappings = fromConceptMappings;
	}
}
