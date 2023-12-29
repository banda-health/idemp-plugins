package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MPeriod;
import org.compiere.model.MRefList;
import org.compiere.model.MYear;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Generated Model for C_Period - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_PeriodInput extends MPeriod implements I_C_PeriodInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput PeriodType_RL;
	 private I_C_YearInput C_Year;

	/**
	 * Standard constructor
	 */
	public X_C_PeriodInput(String ID) {
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
		setC_Period_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_Period_UU();
	}

	/**
	 * Set Year.
	 *
	 * @param C_Year Calendar Year
	 */
	public void setC_Year(I_C_YearInput C_Year) {
		this.C_Year = C_Year;
		MYear foreignEntity;
		if (get_ID() == 0 &&C_Year != null &&
				(foreignEntity = new Query(getCtx(), MYear.Table_Name, MYear.COLUMNNAME_C_Year_UU + "=?", get_TrxName())
						.setParameters(C_Year.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Year_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Year.
	 *
	 * @return Calendar Year
	 */
	public I_C_YearInput getC_Year() {
		return C_Year;
	}

	/**
	 * Set Period Type.
	 *
	 * @param PeriodType_RL Period Type
	 */
	public void setPeriodType_RL(I_AD_Ref_ListInput PeriodType_RL) {
		this.PeriodType_RL = PeriodType_RL;
		MRefList foreignEntity;
		if (get_ID() == 0 &&PeriodType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(PeriodType_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setPeriodType(foreignEntity.getValue());
		}
	}

	/**
	 * Get Period Type.
	 *
	 * @return Period Type
	 */
	public I_AD_Ref_ListInput getPeriodType_RL() {
		return PeriodType_RL;
	}
}
