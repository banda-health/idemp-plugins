package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrderLandedCost;
import org.compiere.model.MOrderLandedCostAllocation;
import org.compiere.model.MOrg;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for C_OrderLandedCostAllocation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_OrderLandedCostAllocationInput extends MOrderLandedCostAllocation implements I_C_OrderLandedCostAllocationInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_OrderLandedCost;
	private ForeignEntityInput mC_OrderLine;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_OrderLandedCostAllocationInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MOrderLandedCostAllocation(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Estimated Landed Cost.
	 *
	 * @param C_OrderLandedCost Estimated Landed Cost
	 */
	@JsonProperty("C_OrderLandedCost")
	public void setC_OrderLandedCostInput(ForeignEntityInput C_OrderLandedCost) {
		this.mC_OrderLandedCost = C_OrderLandedCost;
		MOrderLandedCost foreignEntity;
		if (get_ID() == 0 && C_OrderLandedCost != null &&
				(foreignEntity = new Query(getCtx(), "C_OrderLandedCost", "C_OrderLandedCost_UU=?", get_TrxName())
						.setParameters(C_OrderLandedCost.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_OrderLandedCost_ID(foreignEntity.get_ID());
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
	 * Set Estimated Landed Cost Allocation.
	 *
	 * @param C_OrderLandedCostAllocation_ID Estimated Landed Cost Allocation
	 */

	public void setC_OrderLandedCostAllocation_ID(int C_OrderLandedCostAllocation_ID) {
		if (get_ID() == 0) {
			super.setC_OrderLandedCostAllocation_ID(C_OrderLandedCostAllocation_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_OrderLandedCostAllocation_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_OrderLandedCostAllocation_UU();
	}

	/**
	 * Set Sales Order Line.
	 *
	 * @param C_OrderLine Sales Order Line
	 */
	@JsonProperty("C_OrderLine")
	public void setC_OrderLineInput(ForeignEntityInput C_OrderLine) {
		this.mC_OrderLine = C_OrderLine;
		MOrderLine_BH foreignEntity;
		if (get_ID() == 0 && C_OrderLine != null &&
				(foreignEntity = new Query(getCtx(), "C_OrderLine", "C_OrderLine_UU=?", get_TrxName())
						.setParameters(C_OrderLine.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_OrderLine_ID(foreignEntity.get_ID());
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
