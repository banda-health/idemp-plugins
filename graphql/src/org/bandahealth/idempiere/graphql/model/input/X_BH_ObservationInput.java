package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBHEncounter;
import org.bandahealth.idempiere.base.model.MBHObservation;
import org.bandahealth.idempiere.base.model.MField_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for BH_Observation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_BH_ObservationInput extends MBHObservation implements I_BH_ObservationInput {

	private ForeignEntityInput mAD_Field;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mBH_Encounter;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The BH_Observation_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_BH_ObservationInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}

	/**
	 * Set Field.
	 *
	 * @param AD_Field Field on a database table
	 */
	@JsonProperty("AD_Field")
	public void setAD_FieldInput(ForeignEntityInput AD_Field) {
		this.mAD_Field = AD_Field;
		if (get_ID() != 0) {
			return;
		}
		if (AD_Field != null) {
			// Since an entity was passed, make sure it's in the DB
			MField_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Field", "AD_Field_UU=?", get_TrxName())
							.setParameters(AD_Field.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_Field_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Field with UU " + AD_Field.getUU());
			}
		} else {
			this.setAD_Field_ID(0);
		}
	}

	/**
	 * Get Field.
	 *
	 * @return Field on a database table
	 */
	@JsonProperty("AD_Field")
	public ForeignEntityInput AD_Field() {
		return mAD_Field;
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
	 * Set Encounter.
	 *
	 * @param BH_Encounter Encounter
	 */
	@JsonProperty("BH_Encounter")
	public void setBH_EncounterInput(ForeignEntityInput BH_Encounter) {
		this.mBH_Encounter = BH_Encounter;
		if (get_ID() != 0) {
			return;
		}
		if (BH_Encounter != null) {
			// Since an entity was passed, make sure it's in the DB
			MBHEncounter foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "BH_Encounter", "BH_Encounter_UU=?", get_TrxName())
							.setParameters(BH_Encounter.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setBH_Encounter_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table BH_Encounter with UU " + BH_Encounter.getUU());
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
	/**
	 * Set Observation.
	 *
	 * @param BH_Observation_ID Observation
	 */
	@JsonProperty("BH_Observation_ID")
	public void setBH_Observation_IDFromJson(int BH_Observation_ID) {
		if (get_ID() == 0) {
			super.setBH_Observation_ID(BH_Observation_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setBH_Observation_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getBH_Observation_UU();
	}
}
