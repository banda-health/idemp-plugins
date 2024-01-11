package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MBHEncounter;
import org.bandahealth.idempiere.base.model.MBHVisit;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for BH_Encounter - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_BH_EncounterInput extends MBHEncounter implements I_BH_EncounterInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mBH_Visit;
	private I_AD_Ref_ListInput mBH_Encounter_Type;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_BH_EncounterInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MBHEncounter(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
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
	 * @param BH_Encounter_ID Encounter
	 */

	public void setBH_Encounter_ID(int BH_Encounter_ID) {
		if (get_ID() == 0) {
			super.setBH_Encounter_ID(BH_Encounter_ID);
		}
	}

	/**
	 * Set Encounter Type.
	 *
	 * @param BH_Encounter_Type Encounter Type
	 */
	@JsonProperty("BH_Encounter_Type")
	public void setBH_Encounter_TypeInput(I_AD_Ref_ListInput BH_Encounter_Type) {
		this.mBH_Encounter_Type = BH_Encounter_Type;
		MRefList_BH foreignEntity;
		if (get_ID() == 0 &&BH_Encounter_Type != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(BH_Encounter_Type.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setBH_Encounter_Type(foreignEntity.getValue());
		}
	}

	/**
	 * Get Encounter Type.
	 *
	 * @return Encounter Type
	 */
	@JsonProperty("BH_Encounter_Type")
	public I_AD_Ref_ListInput BH_Encounter_Type() {
		return mBH_Encounter_Type;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setBH_Encounter_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getBH_Encounter_UU();
	}

	/**
	 * Set Visit.
	 *
	 * @param BH_Visit Visit
	 */
	@JsonProperty("BH_Visit")
	public void setBH_VisitInput(ForeignEntityInput BH_Visit) {
		this.mBH_Visit = BH_Visit;
		MBHVisit foreignEntity;
		if (BH_Visit != null &&
				(foreignEntity = new Query(getCtx(), "BH_Visit", "BH_Visit_UU=?", get_TrxName())
						.setParameters(BH_Visit.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setBH_Visit_ID(foreignEntity.get_ID());
		} else {
			super.setBH_Visit_ID(0);
		}
	}

	/**
	 * Get Visit.
	 *
	 * @return Visit
	 */
	@JsonProperty("BH_Visit")
	public ForeignEntityInput BH_Visit() {
		return mBH_Visit;
	}
}
