package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_AD_PrintPaperResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_PrintPaper;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_PrintPaper - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_PrintPaperInput extends X_AD_PrintPaper implements I_AD_PrintPaperInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mDimensionUnits;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The AD_PrintPaper_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_PrintPaperInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
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
	 * Set Print Paper.
	 *
	 * @param AD_PrintPaper_ID Printer paper definition
	 */
	@JsonProperty("AD_PrintPaper_ID")
	public void setAD_PrintPaper_IDFromJson(int AD_PrintPaper_ID) {
		if (get_ID() == 0) {
			super.setAD_PrintPaper_ID(AD_PrintPaper_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setAD_PrintPaper_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getAD_PrintPaper_UU();
	}

	/**
	 * Set Dimension Units.
	 *
	 * @param DimensionUnits Units of Dimension
	 */
	@JsonProperty("DimensionUnits")
	public void setDimensionUnitsInput(ForeignEntityInput DimensionUnits) {
		this.mDimensionUnits = DimensionUnits;
		if (DimensionUnits != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_PrintPaperResolver.DIMENSIONUNITS_UUIDS_BY_VALUE.containsValue(DimensionUnits.getUU())) {
				throw new AdempiereException("The reference list UU of " + DimensionUnits.getUU() +
						" is not in the list defined for the DimensionUnits column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(DimensionUnits.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setDimensionUnits(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + DimensionUnits.getUU());
			}
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
	public ForeignEntityInput DimensionUnits() {
		return mDimensionUnits;
	}
}
