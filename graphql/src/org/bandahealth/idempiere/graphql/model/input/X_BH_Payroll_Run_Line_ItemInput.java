package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBHPayrollRunLine;
import org.bandahealth.idempiere.base.model.MBHPayrollRunLineItem;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for BH_Payroll_Run_Line_Item - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Payroll_Run_Line_ItemInput extends MBHPayrollRunLineItem implements I_BH_Payroll_Run_Line_ItemInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mBH_Payroll_Run_Line;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The BH_Payroll_Run_Line_Item_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_BH_Payroll_Run_Line_ItemInput(@JsonProperty("UU") String UU) {
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
		if (!is_new()) {
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
	 * Set Payroll Run Line.
	 *
	 * @param BH_Payroll_Run_Line Payroll Run Line
	 */
	@JsonProperty("BH_Payroll_Run_Line")
	public void setBH_Payroll_Run_LineInput(ForeignEntityInput BH_Payroll_Run_Line) {
		this.mBH_Payroll_Run_Line = BH_Payroll_Run_Line;
		if (BH_Payroll_Run_Line != null) {
			// Since an entity was passed, make sure it's in the DB
			MBHPayrollRunLine foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "BH_Payroll_Run_Line", "BH_Payroll_Run_Line_UU=?", get_TrxName())
							.setParameters(BH_Payroll_Run_Line.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setBH_Payroll_Run_Line_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table BH_Payroll_Run_Line with UU " + BH_Payroll_Run_Line.getUU());
			}
		} else {
			this.setBH_Payroll_Run_Line_ID(0);
		}
	}

	/**
	 * Get Payroll Run Line.
	 *
	 * @return Payroll Run Line
	 */
	@JsonProperty("BH_Payroll_Run_Line")
	public ForeignEntityInput BH_Payroll_Run_Line() {
		return mBH_Payroll_Run_Line;
	}

	/**
	 * Set Payroll Run Line Item.
	 *
	 * @param BH_Payroll_Run_Line_Item_ID Payroll Run Line Item
	 */
	@JsonProperty("BH_Payroll_Run_Line_Item_ID")
	public void setBH_Payroll_Run_Line_Item_IDFromJson(int BH_Payroll_Run_Line_Item_ID) {
		if (get_ID() == 0) {
			super.setBH_Payroll_Run_Line_Item_ID(BH_Payroll_Run_Line_Item_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setBH_Payroll_Run_Line_Item_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getBH_Payroll_Run_Line_Item_UU();
	}
}
