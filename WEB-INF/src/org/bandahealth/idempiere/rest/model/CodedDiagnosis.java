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
	}

	public CodedDiagnosis(String ceilName, int ceilId, String conceptClass, String icd10) {
		setCeilName(ceilName);
		setCeilId(ceilId);
		setConceptClass(conceptClass);
		setIcd10(icd10);
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
}
