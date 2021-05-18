package org.bandahealth.idempiere.rest.model;

import javax.xml.bind.annotation.XmlRootElement;

import org.bandahealth.idempiere.base.model.MBHCodedDiagnosis;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@XmlRootElement(name = "codedDiagnosis")
@JsonInclude(value = Include.NON_NULL)
public class CodedDiagnosis extends BaseMetadata {

	private static final long serialVersionUID = -2371895179523894294L;
	private String ceilName;
	private int ceilId;
	private String conceptClass;
	private String icd10;
	private String searchTerms;
	private int synomedCT;
	private int synomedNP;
	private String synonyms;
	private String shortNames;
	private String description;
	private String moh705aLessthan5;
	private String moh705bGreaterthan5;

	public CodedDiagnosis() {
	}

	public CodedDiagnosis(MBHCodedDiagnosis entity) {
		setCeilName(entity.getBH_CeilName());
		setCeilId(entity.getBH_CeilId());
		setConceptClass(entity.getBH_ConceptClass());
		setIcd10(entity.getBH_ICD10());
		setSearchTerms(entity.getBH_SearchTerms());
		setSynomedCT(entity.getBH_SynomedCT());
		setSynomedNP(entity.getBH_SynomedNP());
		setSynonyms(entity.getBH_Synonyms());
		setShortNames(entity.getBH_ShortNames());
		setDescription(entity.getDescription());
		setMoh705aLessthan5(entity.getBH_MoH705ALessThan5());
		setMoh705bGreaterthan5(entity.getBH_MoH705BGreaterThan5());
	}

	public CodedDiagnosis(String uuid, String ceilName, String conceptClass, String description) {
		setUuid(uuid);
		setCeilName(ceilName);
		setConceptClass(conceptClass);
		setDescription(description);
	}

	public String getCeilName() {
		return ceilName;
	}

	public void setCeilName(String ceilName) {
		this.ceilName = ceilName;
	}

	public int getCeilId() {
		return ceilId;
	}

	public void setCeilId(int ceilId) {
		this.ceilId = ceilId;
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

	public String getSearchTerms() {
		return searchTerms;
	}

	public void setSearchTerms(String searchTerms) {
		this.searchTerms = searchTerms;
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

	public String getShortNames() {
		return shortNames;
	}

	public void setShortNames(String shortNames) {
		this.shortNames = shortNames;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMoh705aLessthan5() {
		return moh705aLessthan5;
	}

	public void setMoh705aLessthan5(String moh705aLessthan5) {
		this.moh705aLessthan5 = moh705aLessthan5;
	}

	public String getMoh705bGreaterthan5() {
		return moh705bGreaterthan5;
	}

	public void setMoh705bGreaterthan5(String moh705bGreaterthan5) {
		this.moh705bGreaterthan5 = moh705bGreaterthan5;
	}
}
