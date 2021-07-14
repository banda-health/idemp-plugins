package org.bandahealth.idempiere.rest.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@XmlRootElement(name = "nhif")
@JsonInclude(value = Include.NON_NULL)
public class NHIF implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String COLUMNNAME_BH_CLAIM_NUMBER = "bh_nhif_claim_number";

	private NHIFType type;
	private NHIFRelationship relationship;
	private String claimNumber;
	private String memberId;
	private String number;
	private String memberName;

	public NHIF() {
	}

	public NHIF(NHIFType type, NHIFRelationship relationship, String claimNumber, String memberId, String number,
			String memberName) {
		this.type = type;
		this.relationship = relationship;
		this.claimNumber = claimNumber;
		this.memberId = memberId;
		this.number = number;
		this.memberName = memberName;
	}

	public NHIFType getType() {
		return type;
	}

	public void setType(NHIFType type) {
		this.type = type;
	}

	public NHIFRelationship getRelationship() {
		return relationship;
	}

	public void setRelationship(NHIFRelationship relationship) {
		this.relationship = relationship;
	}

	public String getClaimNumber() {
		return claimNumber;
	}

	public void setClaimNumber(String claimNumber) {
		this.claimNumber = claimNumber;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
