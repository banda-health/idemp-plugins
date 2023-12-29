package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.MBHVisit;
import org.bandahealth.idempiere.base.model.X_BH_Encounter;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Generated Model for BH_Encounter - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_BH_EncounterInput extends X_BH_Encounter implements I_BH_EncounterInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput BH_Encounter_Type_RL;
	 private I_BH_VisitInput BH_Visit;

	/**
	 * Standard constructor
	 */
	public X_BH_EncounterInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	public void setAD_Org(I_AD_OrgInput AD_Org) {
		this.AD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	public I_AD_OrgInput getAD_Org() {
		return AD_Org;
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
	 * @param BH_Encounter_Type_RL Encounter Type
	 */
	public void setBH_Encounter_Type_RL(I_AD_Ref_ListInput BH_Encounter_Type_RL) {
		this.BH_Encounter_Type_RL = BH_Encounter_Type_RL;
		MRefList foreignEntity;
		if (get_ID() == 0 &&BH_Encounter_Type_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(BH_Encounter_Type_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setBH_Encounter_Type(foreignEntity.getValue());
		}
	}

	/**
	 * Get Encounter Type.
	 *
	 * @return Encounter Type
	 */
	public I_AD_Ref_ListInput getBH_Encounter_Type_RL() {
		return BH_Encounter_Type_RL;
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
	public void setBH_Visit(I_BH_VisitInput BH_Visit) {
		this.BH_Visit = BH_Visit;
		MBHVisit foreignEntity;
		if (BH_Visit != null &&
				(foreignEntity = new Query(getCtx(), MBHVisit.Table_Name, MBHVisit.COLUMNNAME_BH_Visit_UU + "=?", get_TrxName())
						.setParameters(BH_Visit.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setBH_Visit_ID(foreignEntity.get_ID());
		} else {
			this.setBH_Visit_ID(0);
		}
	}

	/**
	 * Get Visit.
	 *
	 * @return Visit
	 */
	public I_BH_VisitInput getBH_Visit() {
		return BH_Visit;
	}
}
