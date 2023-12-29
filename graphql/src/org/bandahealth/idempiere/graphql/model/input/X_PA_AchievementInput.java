package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAchievement;
import org.compiere.model.MMeasure;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Generated Model for PA_Achievement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_AchievementInput extends MAchievement implements I_PA_AchievementInput {

	 private I_AD_OrgInput AD_Org;
	 private I_PA_MeasureInput PA_Measure;

	/**
	 * Standard constructor
	 */
	public X_PA_AchievementInput(String ID) {
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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setPA_Achievement_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getPA_Achievement_UU();
	}

	/**
	 * Set Measure.
	 *
	 * @param PA_Measure Concrete Performance Measurement
	 */
	public void setPA_Measure(I_PA_MeasureInput PA_Measure) {
		this.PA_Measure = PA_Measure;
		MMeasure foreignEntity;
		if (get_ID() == 0 &&PA_Measure != null &&
				(foreignEntity = new Query(getCtx(), MMeasure.Table_Name, MMeasure.COLUMNNAME_PA_Measure_UU + "=?", get_TrxName())
						.setParameters(PA_Measure.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setPA_Measure_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Measure.
	 *
	 * @return Concrete Performance Measurement
	 */
	public I_PA_MeasureInput getPA_Measure() {
		return PA_Measure;
	}
}
