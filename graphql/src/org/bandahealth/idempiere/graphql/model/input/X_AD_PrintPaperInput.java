package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
import org.compiere.model.Query;
import org.compiere.model.X_AD_PrintPaper;
import org.compiere.util.Env;

/**
 * Generated Model for AD_PrintPaper - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_PrintPaperInput extends X_AD_PrintPaper implements I_AD_PrintPaperInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput DimensionUnits_RL;

	/**
	 * Standard constructor
	 */
	public X_AD_PrintPaperInput(String ID) {
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
	 * Set Print Paper.
	 *
	 * @param AD_PrintPaper_ID Printer paper definition
	 */

	public void setAD_PrintPaper_ID(int AD_PrintPaper_ID) {
		if (get_ID() == 0) {
			super.setAD_PrintPaper_ID(AD_PrintPaper_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_PrintPaper_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_PrintPaper_UU();
	}

	/**
	 * Set Dimension Units.
	 *
	 * @param DimensionUnits_RL Units of Dimension
	 */
	public void setDimensionUnits_RL(I_AD_Ref_ListInput DimensionUnits_RL) {
		this.DimensionUnits_RL = DimensionUnits_RL;
		MRefList foreignEntity;
		if (DimensionUnits_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(DimensionUnits_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setDimensionUnits(foreignEntity.getValue());
		} else {
			this.setDimensionUnits(null);
		}
	}

	/**
	 * Get Dimension Units.
	 *
	 * @return Units of Dimension
	 */
	public I_AD_Ref_ListInput getDimensionUnits_RL() {
		return DimensionUnits_RL;
	}
}
