package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MPeriod;
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

	 private I_AD_OrgInput mAD_Org;
	 private I_AD_Ref_ListInput mPeriodType;
	 private I_C_YearInput mC_Year;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_PeriodInput(@JsonProperty("ID") String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(I_AD_OrgInput AD_Org) {
		this.mAD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
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
	public I_AD_OrgInput AD_Org() {
		return mAD_Org;
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
	@JsonProperty("C_Year")
	public void setC_YearInput(I_C_YearInput C_Year) {
		this.mC_Year = C_Year;
		MYear foreignEntity;
		if (get_ID() == 0 &&C_Year != null &&
				(foreignEntity = new Query(getCtx(), MYear.Table_Name, MYear.COLUMNNAME_C_Year_UU + "=?", get_TrxName())
						.setParameters(C_Year.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Year_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Year.
	 *
	 * @return Calendar Year
	 */
	@JsonProperty("C_Year")
	public I_C_YearInput C_Year() {
		return mC_Year;
	}

	/**
	 * Set Period Type.
	 *
	 * @param PeriodType Period Type
	 */
	@JsonProperty("PeriodType")
	public void setPeriodTypeInput(I_AD_Ref_ListInput PeriodType) {
		this.mPeriodType = PeriodType;
		MRefList_BH foreignEntity;
		if (get_ID() == 0 &&PeriodType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(PeriodType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setPeriodType(foreignEntity.getValue());
		}
	}

	/**
	 * Get Period Type.
	 *
	 * @return Period Type
	 */
	@JsonProperty("PeriodType")
	public I_AD_Ref_ListInput PeriodType() {
		return mPeriodType;
	}
}
