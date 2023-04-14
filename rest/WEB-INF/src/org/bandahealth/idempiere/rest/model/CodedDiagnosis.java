package org.bandahealth.idempiere.rest.model;

import javax.xml.bind.annotation.XmlRootElement;

import org.bandahealth.idempiere.base.model.MBHCodedDiagnosis;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@XmlRootElement(name = "codedDiagnosis")
@JsonInclude(value = Include.NON_NULL)
public class CodedDiagnosis extends BaseMetadata {

	private static final long serialVersionUID = -2371895179523894294L;
	private String cielName;
	private int cielId;
	private String conceptClass;
	private String icd10;
	private int synomedCT;
	private int synomedNP;
	private String synonyms;
	private String description;
	private String moh705aLessThan5;
	private String moh705bGreaterThan5;
	private String searchTerms;

	public CodedDiagnosis() {
	}

	public CodedDiagnosis(String uuid, String cielName) {
		setUuid(uuid);
		setCielName(cielName);
	}

	public CodedDiagnosis(MBHCodedDiagnosis entity) {
		setUuid(entity.getBH_CodedDiagnosis_UU());
		setCielName(entity.getBH_CielName());
		setCielId(entity.getBH_CielId());
		setConceptClass(entity.getBH_ConceptClass());
		setIcd10(entity.getBH_ICD10());
		setSynomedCT(entity.getBH_SynomedCT());
		setSynomedNP(entity.getBH_SynomedNP());
		setSynonyms(entity.getBH_Synonyms());
		setDescription(entity.getDescription());
		setMoh705aLessThan5(entity.getBH_MoH705ALessThan5());
		setMoh705bGreaterThan5(entity.getBH_MoH705BGreaterThan5());
		setSearchTerms(entity.getBH_SearchTerms());
	}

	public CodedDiagnosis(String uuid, String cielName, String icd10, String synonyms) {
		setUuid(uuid);
		setCielName(cielName);
		setIcd10(icd10);
		setSynonyms(synonyms);
	}

	public String getCielName() {
		return cielName;
	}

	public void setCielName(String cielName) {
		this.cielName = cielName;
	}

	public int getCielId() {
		return cielId;
	}

	public void setCielId(int cielId) {
		this.cielId = cielId;
	}

	public String getConceptClass() {
		return conceptClass;
	}

	public void setConceptClass(String conceptClass) {
		this.conceptClass = conceptClass;
	}

	public String getIcd10() {
		return icd10;
	}

	public void setIcd10(String icd10) {
		this.icd10 = icd10;
	}

	public int getSynomedCT() {
		return synomedCT;
	}

	public void setSynomedCT(int synomedCT) {
		this.synomedCT = synomedCT;
	}

	public int getSynomedNP() {
		return synomedNP;
	}

	public void setSynomedNP(int synomedNP) {
		this.synomedNP = synomedNP;
	}

	public String getSynonyms() {
		return synonyms;
	}

	public void setSynonyms(String synonyms) {
		this.synonyms = synonyms;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMoh705aLessthan5() {
		return moh705aLessThan5;
	}

	public void setMoh705aLessThan5(String moh705aLessthan5) {
		this.moh705aLessThan5 = moh705aLessthan5;
	}

	public String getMoh705bGreaterThan5() {
		return moh705bGreaterThan5;
	}

	public void setMoh705bGreaterThan5(String moh705bGreaterThan5) {
		this.moh705bGreaterThan5 = moh705bGreaterThan5;
	}

	public String getSearchTerms() {
		return searchTerms;
	}

	public void setSearchTerms(String searchTerms) {
		this.searchTerms = searchTerms;
	}
}
