package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MCostElement;
import org.compiere.model.MOrderLandedCost;
import org.compiere.model.MOrg;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for C_OrderLandedCost - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_OrderLandedCostInput extends MOrderLandedCost implements I_C_OrderLandedCostInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_Order;
	private ForeignEntityInput mM_CostElement;
	private I_AD_Ref_ListInput mLandedCostDistribution;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_OrderLandedCostInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MOrderLandedCost(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Order.
	 *
	 * @param C_Order Order
	 */
	@JsonProperty("C_Order")
	public void setC_OrderInput(ForeignEntityInput C_Order) {
		this.mC_Order = C_Order;
		MOrder_BH foreignEntity;
		if (get_ID() == 0 && C_Order != null &&
				(foreignEntity = new Query(getCtx(), "C_Order", "C_Order_UU=?", get_TrxName())
						.setParameters(C_Order.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Order_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Order.
	 *
	 * @return Order
	 */
	@JsonProperty("C_Order")
	public ForeignEntityInput C_Order() {
		return mC_Order;
	}
	/**
	 * Set Estimated Landed Cost.
	 *
	 * @param C_OrderLandedCost_ID Estimated Landed Cost
	 */

	public void setC_OrderLandedCost_ID(int C_OrderLandedCost_ID) {
		if (get_ID() == 0) {
			super.setC_OrderLandedCost_ID(C_OrderLandedCost_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_OrderLandedCost_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_OrderLandedCost_UU();
	}

	/**
	 * Set Cost Distribution.
	 *
	 * @param LandedCostDistribution Landed Cost Distribution
	 */
	@JsonProperty("LandedCostDistribution")
	public void setLandedCostDistributionInput(I_AD_Ref_ListInput LandedCostDistribution) {
		this.mLandedCostDistribution = LandedCostDistribution;
		MRefList_BH foreignEntity;
		if (LandedCostDistribution != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(LandedCostDistribution.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setLandedCostDistribution(foreignEntity.getValue());
		} else {
			this.setLandedCostDistribution(null);
		}
	}

	/**
	 * Get Cost Distribution.
	 *
	 * @return Landed Cost Distribution
	 */
	@JsonProperty("LandedCostDistribution")
	public I_AD_Ref_ListInput LandedCostDistribution() {
		return mLandedCostDistribution;
	}

	/**
	 * Set Cost Element.
	 *
	 * @param M_CostElement Product Cost Element
	 */
	@JsonProperty("M_CostElement")
	public void setM_CostElementInput(ForeignEntityInput M_CostElement) {
		this.mM_CostElement = M_CostElement;
		MCostElement foreignEntity;
		if (M_CostElement != null &&
				(foreignEntity = new Query(getCtx(), "M_CostElement", "M_CostElement_UU=?", get_TrxName())
						.setParameters(M_CostElement.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_CostElement_ID(foreignEntity.get_ID());
		} else {
			super.setM_CostElement_ID(0);
		}
	}

	/**
	 * Get Cost Element.
	 *
	 * @return Product Cost Element
	 */
	@JsonProperty("M_CostElement")
	public ForeignEntityInput M_CostElement() {
		return mM_CostElement;
	}
}
