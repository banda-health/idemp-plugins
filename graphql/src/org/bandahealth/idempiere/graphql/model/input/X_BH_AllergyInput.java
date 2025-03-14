package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBHAllergy;
import org.bandahealth.idempiere.base.model.MBHConcept;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for BH_Allergy - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_BH_AllergyInput extends MBHAllergy implements I_BH_AllergyInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mBH_Concept;
	private ForeignEntityInput mC_BPartner;
	private ForeignEntityInput mSeverity_Concept;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The BH_Allergy_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_BH_AllergyInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		if (get_ID() != 0) {
			return;
		}
		if (AD_Org != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UU " + AD_Org.getUU());
			}
		} else {
			this.setAD_Org_ID(0);
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
	}
	/**
	 * Set Allergy.
	 *
	 * @param BH_Allergy_ID Allergy
	 */
	@JsonProperty("BH_Allergy_ID")
	public void setBH_Allergy_IDFromJson(int BH_Allergy_ID) {
		if (get_ID() == 0) {
			super.setBH_Allergy_ID(BH_Allergy_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setBH_Allergy_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getBH_Allergy_UU();
	}

	/**
	 * Set Concept.
	 *
	 * @param BH_Concept Concept
	 */
	@JsonProperty("BH_Concept")
	public void setBH_ConceptInput(ForeignEntityInput BH_Concept) {
		this.mBH_Concept = BH_Concept;
		if (BH_Concept != null) {
			// Since an entity was passed, make sure it's in the DB
			MBHConcept foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "BH_Concept", "BH_Concept_UU=?", get_TrxName())
							.setParameters(BH_Concept.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setBH_Concept_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table BH_Concept with UU " + BH_Concept.getUU());
			}
		} else {
			this.setBH_Concept_ID(0);
		}
	}

	/**
	 * Get Concept.
	 *
	 * @return Concept
	 */
	@JsonProperty("BH_Concept")
	public ForeignEntityInput BH_Concept() {
		return mBH_Concept;
	}

	/**
	 * Set Business Partner.
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public void setC_BPartnerInput(ForeignEntityInput C_BPartner) {
		this.mC_BPartner = C_BPartner;
		if (get_ID() != 0) {
			return;
		}
		if (C_BPartner != null) {
			// Since an entity was passed, make sure it's in the DB
			MBPartner_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_BPartner", "C_BPartner_UU=?", get_TrxName())
							.setParameters(C_BPartner.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_BPartner_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BPartner with UU " + C_BPartner.getUU());
			}
		} else {
			this.setC_BPartner_ID(0);
		}
	}

	/**
	 * Get Business Partner.
	 *
	 * @return Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public ForeignEntityInput C_BPartner() {
		return mC_BPartner;
	}

	/**
	 * Set Severity Concept ID.
	 *
	 * @param Severity_Concept Severity Concept ID
	 */
	@JsonProperty("Severity_Concept")
	public void setSeverity_ConceptInput(ForeignEntityInput Severity_Concept) {
		this.mSeverity_Concept = Severity_Concept;
		if (Severity_Concept != null) {
			// Since an entity was passed, make sure it's in the DB
			MBHConcept foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "BH_Concept", "BH_Concept_UU=?", get_TrxName())
							.setParameters(Severity_Concept.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setSeverity_Concept_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table BH_Concept with UU " + Severity_Concept.getUU());
			}
		} else {
			this.setSeverity_Concept_ID(0);
		}
	}

	/**
	 * Get Severity Concept ID.
	 *
	 * @return Severity Concept ID
	 */
	@JsonProperty("Severity_Concept")
	public ForeignEntityInput Severity_Concept() {
		return mSeverity_Concept;
	}
}
