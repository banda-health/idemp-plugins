package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MBHEncounter;
import org.bandahealth.idempiere.base.model.MBHObservation;
import org.bandahealth.idempiere.base.model.MField_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for BH_Observation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_BH_ObservationInput extends MBHObservation implements I_BH_ObservationInput {

	private ForeignEntityInput mAD_Field;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mBH_Encounter;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_BH_ObservationInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MBHObservation(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
	}

	/**
	 * Set Field.
	 *
	 * @param AD_Field Field on a database table
	 */
	@JsonProperty("AD_Field")
	public void setAD_FieldInput(ForeignEntityInput AD_Field) {
		this.mAD_Field = AD_Field;
		MField_BH foreignEntity;
		if (get_ID() == 0 && AD_Field != null &&
				(foreignEntity = new Query(getCtx(), "AD_Field", "AD_Field_UU=?", get_TrxName())
						.setParameters(AD_Field.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Field_ID(foreignEntity.get_ID());
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
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 && AD_Org != null &&
				(foreignEntity = new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
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
		MBHEncounter foreignEntity;
		if (get_ID() == 0 && BH_Encounter != null &&
				(foreignEntity = new Query(getCtx(), "BH_Encounter", "BH_Encounter_UU=?", get_TrxName())
						.setParameters(BH_Encounter.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setBH_Encounter_ID(foreignEntity.get_ID());
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

	public void setBH_Observation_ID(int BH_Observation_ID) {
		if (get_ID() == 0) {
			super.setBH_Observation_ID(BH_Observation_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setBH_Observation_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getBH_Observation_UU();
	}
}
