package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
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

	 private I_AD_OrgInput mAD_Org;
	 private I_AD_Ref_ListInput mDimensionUnits;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_PrintPaperInput(@JsonProperty("ID") String ID) {
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
	 * @param DimensionUnits Units of Dimension
	 */
	@JsonProperty("DimensionUnits")
	public void setDimensionUnitsInput(I_AD_Ref_ListInput DimensionUnits) {
		this.mDimensionUnits = DimensionUnits;
		MRefList_BH foreignEntity;
		if (DimensionUnits != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(DimensionUnits.getID())
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
	@JsonProperty("DimensionUnits")
	public I_AD_Ref_ListInput DimensionUnits() {
		return mDimensionUnits;
	}
}
