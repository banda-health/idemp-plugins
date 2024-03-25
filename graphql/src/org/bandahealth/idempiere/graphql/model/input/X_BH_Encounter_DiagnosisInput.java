package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBHCodedDiagnosis;
import org.bandahealth.idempiere.base.model.MBHEncounter;
import org.bandahealth.idempiere.base.model.MBHEncounterDiagnosis;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for BH_Encounter_Diagnosis - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_BH_Encounter_DiagnosisInput extends MBHEncounterDiagnosis implements I_BH_Encounter_DiagnosisInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mBH_Coded_Diagnosis;
	private ForeignEntityInput mBH_Encounter;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The BH_Encounter_Diagnosis_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_BH_Encounter_DiagnosisInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, UUID), null);
		setUUID(UUID);
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
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
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
	 * Set Coded Diagnosis.
	 *
	 * @param BH_Coded_Diagnosis Coded Diagnosis
	 */
	@JsonProperty("BH_Coded_Diagnosis")
	public void setBH_Coded_DiagnosisInput(ForeignEntityInput BH_Coded_Diagnosis) {
		this.mBH_Coded_Diagnosis = BH_Coded_Diagnosis;
		if (get_ID() != 0) {
			return;
		}
		if (BH_Coded_Diagnosis != null) {
			// Since an entity was passed, make sure it's in the DB
			MBHCodedDiagnosis foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "BH_Coded_Diagnosis", "BH_Coded_Diagnosis_UU=?", get_TrxName())
							.setParameters(BH_Coded_Diagnosis.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setBH_Coded_Diagnosis_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table BH_Coded_Diagnosis with UUID " + BH_Coded_Diagnosis.getUUID());
			}
		} else {
			this.setBH_Coded_Diagnosis_ID(0);
		}
	}

	/**
	 * Get Coded Diagnosis.
	 *
	 * @return Coded Diagnosis
	 */
	@JsonProperty("BH_Coded_Diagnosis")
	public ForeignEntityInput BH_Coded_Diagnosis() {
		return mBH_Coded_Diagnosis;
	}
	/**
	 * Set Encounter Diagnosis.
	 *
	 * @param BH_Encounter_Diagnosis_ID Encounter Diagnosis
	 */

	public void setBH_Encounter_Diagnosis_ID(int BH_Encounter_Diagnosis_ID) {
		if (get_ID() == 0) {
			super.setBH_Encounter_Diagnosis_ID(BH_Encounter_Diagnosis_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setBH_Encounter_Diagnosis_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getBH_Encounter_Diagnosis_UU();
	}

	/**
	 * Set Encounter.
	 *
	 * @param BH_Encounter Encounter
	 */
	@JsonProperty("BH_Encounter")
	public void setBH_EncounterInput(ForeignEntityInput BH_Encounter) {
		this.mBH_Encounter = BH_Encounter;
		if (BH_Encounter != null) {
			// Since an entity was passed, make sure it's in the DB
			MBHEncounter foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "BH_Encounter", "BH_Encounter_UU=?", get_TrxName())
							.setParameters(BH_Encounter.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setBH_Encounter_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table BH_Encounter with UUID " + BH_Encounter.getUUID());
			}
		} else {
			this.setBH_Encounter_ID(0);
		}
	}

	/**
	 * Get Encounter.
	 *
	 * @return Encounter
	 */
	@JsonProperty("BH_Encounter")
	public ForeignEntityInput BH_Encounter() {
		return mBH_Encounter;
	}
}
