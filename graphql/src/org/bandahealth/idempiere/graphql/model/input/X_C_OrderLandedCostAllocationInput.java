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
 * @version Release 8.2 - $Id$
 */
public class X_C_OrderLandedCostAllocationInput extends MOrderLandedCostAllocation implements I_C_OrderLandedCostAllocationInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_OrderLandedCost;
	private ForeignEntityInput mC_OrderLine;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_OrderLandedCostAllocation_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_OrderLandedCostAllocationInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, UUID), null);
		setUUID(UUID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
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
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
		} else {
			this.setAD_Org_ID(0);
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
		if (get_ID() != 0) {
			return;
		}
		if (C_OrderLandedCost != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrderLandedCost foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_OrderLandedCost", "C_OrderLandedCost_UU=?", get_TrxName())
							.setParameters(C_OrderLandedCost.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_OrderLandedCost_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_OrderLandedCost with UUID " + C_OrderLandedCost.getUUID());
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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setC_OrderLandedCostAllocation_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
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
		if (get_ID() != 0) {
			return;
		}
		if (C_OrderLine != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrderLine_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_OrderLine", "C_OrderLine_UU=?", get_TrxName())
							.setParameters(C_OrderLine.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_OrderLine_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_OrderLine with UUID " + C_OrderLine.getUUID());
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
