package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrderLandedCost;
import org.compiere.model.MOrderLandedCostAllocation;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for C_OrderLandedCostAllocation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_OrderLandedCostAllocationInput extends MOrderLandedCostAllocation implements I_C_OrderLandedCostAllocationInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_OrderLandedCost;
	private ForeignEntityInput mC_OrderLine;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The C_OrderLandedCostAllocation_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_OrderLandedCostAllocationInput(@JsonProperty("UU") String UU) {
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
	 * Set Estimated Landed Cost Allocation.
	 *
	 * @param C_OrderLandedCostAllocation_ID Estimated Landed Cost Allocation
	 */
	@JsonProperty("C_OrderLandedCostAllocation_ID")
	public void setC_OrderLandedCostAllocation_IDFromJson(int C_OrderLandedCostAllocation_ID) {
		if (get_ID() == 0) {
			super.setC_OrderLandedCostAllocation_ID(C_OrderLandedCostAllocation_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setC_OrderLandedCostAllocation_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getC_OrderLandedCostAllocation_UU();
	}

	/**
	 * Set Estimated Landed Cost.
	 *
	 * @param C_OrderLandedCost Estimated Landed Cost
	 */
	@JsonProperty("C_OrderLandedCost")
	public void setC_OrderLandedCostInput(ForeignEntityInput C_OrderLandedCost) {
		this.mC_OrderLandedCost = C_OrderLandedCost;
		if (!is_new()) {
			return;
		}
		if (C_OrderLandedCost != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrderLandedCost foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_OrderLandedCost", "C_OrderLandedCost_UU=?", get_TrxName())
							.setParameters(C_OrderLandedCost.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_OrderLandedCost_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_OrderLandedCost with UU " + C_OrderLandedCost.getUU());
			}
		} else {
			this.setC_OrderLandedCost_ID(0);
		}
	}

	/**
	 * Get Estimated Landed Cost.
	 *
	 * @return Estimated Landed Cost
	 */
	@JsonProperty("C_OrderLandedCost")
	public ForeignEntityInput C_OrderLandedCost() {
		return mC_OrderLandedCost;
	}

	/**
	 * Set Sales Order Line.
	 *
	 * @param C_OrderLine Sales Order Line
	 */
	@JsonProperty("C_OrderLine")
	public void setC_OrderLineInput(ForeignEntityInput C_OrderLine) {
		this.mC_OrderLine = C_OrderLine;
		if (!is_new()) {
			return;
		}
		if (C_OrderLine != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrderLine_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_OrderLine", "C_OrderLine_UU=?", get_TrxName())
							.setParameters(C_OrderLine.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_OrderLine_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_OrderLine with UU " + C_OrderLine.getUU());
			}
		} else {
			this.setC_OrderLine_ID(0);
		}
	}

	/**
	 * Get Sales Order Line.
	 *
	 * @return Sales Order Line
	 */
	@JsonProperty("C_OrderLine")
	public ForeignEntityInput C_OrderLine() {
		return mC_OrderLine;
	}
}
