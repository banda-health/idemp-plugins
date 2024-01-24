package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MCostDetail;
import org.compiere.model.MCostElement;
import org.compiere.model.MCostType;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_M_CostHistory;
import org.compiere.util.Env;

import java.math.BigDecimal;
import java.sql.ResultSet;

/**
 * Generated Model for M_CostHistory - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_CostHistoryInput extends X_M_CostHistory implements I_M_CostHistoryInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mM_AttributeSetInstance;
	private ForeignEntityInput mM_CostDetail;
	private ForeignEntityInput mM_CostElement;
	private ForeignEntityInput mM_CostType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The M_CostHistory_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_M_CostHistoryInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new X_M_CostHistory(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
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
		MOrg foreignEntity;
		if (get_ID() == 0 && AD_Org != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
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
	 * Set Attribute Set Instance.
	 *
	 * @param M_AttributeSetInstance Product Attribute Set Instance
	 */
	@JsonProperty("M_AttributeSetInstance")
	public void setM_AttributeSetInstanceInput(ForeignEntityInput M_AttributeSetInstance) {
		this.mM_AttributeSetInstance = M_AttributeSetInstance;
		MAttributeSetInstance_BH foreignEntity;
		if (get_ID() == 0 && M_AttributeSetInstance != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "M_AttributeSetInstance", "M_AttributeSetInstance_UU=?", get_TrxName())
							.setParameters(M_AttributeSetInstance.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_AttributeSetInstance_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_AttributeSetInstance with UUID " + M_AttributeSetInstance.getUUID());
			}
		}
	}

	/**
	 * Get Attribute Set Instance.
	 *
	 * @return Product Attribute Set Instance
	 */
	@JsonProperty("M_AttributeSetInstance")
	public ForeignEntityInput M_AttributeSetInstance() {
		return mM_AttributeSetInstance;
	}

	/**
	 * Set Cost Detail.
	 *
	 * @param M_CostDetail Cost Detail Information
	 */
	@JsonProperty("M_CostDetail")
	public void setM_CostDetailInput(ForeignEntityInput M_CostDetail) {
		this.mM_CostDetail = M_CostDetail;
		MCostDetail foreignEntity;
		if (get_ID() == 0 && M_CostDetail != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "M_CostDetail", "M_CostDetail_UU=?", get_TrxName())
							.setParameters(M_CostDetail.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_CostDetail_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_CostDetail with UUID " + M_CostDetail.getUUID());
			}
		}
	}

	/**
	 * Get Cost Detail.
	 *
	 * @return Cost Detail Information
	 */
	@JsonProperty("M_CostDetail")
	public ForeignEntityInput M_CostDetail() {
		return mM_CostDetail;
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
		if (get_ID() == 0 && M_CostElement != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "M_CostElement", "M_CostElement_UU=?", get_TrxName())
							.setParameters(M_CostElement.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_CostElement_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_CostElement with UUID " + M_CostElement.getUUID());
			}
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
	/**
	 * Set Cost History.
	 *
	 * @param M_CostHistory_ID Movement history for M_Cost
	 */

	public void setM_CostHistory_ID(int M_CostHistory_ID) {
		if (get_ID() == 0) {
			super.setM_CostHistory_ID(M_CostHistory_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setM_CostHistory_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getM_CostHistory_UU();
	}

	/**
	 * Set Cost Type.
	 *
	 * @param M_CostType Type of Cost (e.g. Current, Plan, Future)
	 */
	@JsonProperty("M_CostType")
	public void setM_CostTypeInput(ForeignEntityInput M_CostType) {
		this.mM_CostType = M_CostType;
		MCostType foreignEntity;
		if (get_ID() == 0 && M_CostType != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "M_CostType", "M_CostType_UU=?", get_TrxName())
							.setParameters(M_CostType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_CostType_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_CostType with UUID " + M_CostType.getUUID());
			}
		}
	}

	/**
	 * Get Cost Type.
	 *
	 * @return Type of Cost (e.g. Current, Plan, Future)
	 */
	@JsonProperty("M_CostType")
	public ForeignEntityInput M_CostType() {
		return mM_CostType;
	}
	/**
	 * Set New Accumulated Amt.
	 *
	 * @param NewCAmt Accumulated Amt after processing of M_CostDetail
	 */

	public void setNewCAmt(BigDecimal NewCAmt) {
		if (get_ID() == 0) {
			super.setNewCAmt(NewCAmt);
		}
	}
	/**
	 * Set New Cost Price.
	 *
	 * @param NewCostPrice New current cost price after processing of M_CostDetail
	 */

	public void setNewCostPrice(BigDecimal NewCostPrice) {
		if (get_ID() == 0) {
			super.setNewCostPrice(NewCostPrice);
		}
	}
	/**
	 * Set New Accumulated Qty.
	 *
	 * @param NewCQty New Accumulated Qty after processing of M_CostDetail
	 */

	public void setNewCQty(BigDecimal NewCQty) {
		if (get_ID() == 0) {
			super.setNewCQty(NewCQty);
		}
	}
	/**
	 * Set New Current Quantity.
	 *
	 * @param NewQty New current quantity after processing of M_CostDetail
	 */

	public void setNewQty(BigDecimal NewQty) {
		if (get_ID() == 0) {
			super.setNewQty(NewQty);
		}
	}
	/**
	 * Set Old Accumulated Amt.
	 *
	 * @param OldCAmt Old accumulated amt before the processing of M_CostDetail
	 */

	public void setOldCAmt(BigDecimal OldCAmt) {
		if (get_ID() == 0) {
			super.setOldCAmt(OldCAmt);
		}
	}
	/**
	 * Set Old Current Cost Price.
	 *
	 * @param OldCostPrice Old current cost price before the processing of M_CostDetail
	 */

	public void setOldCostPrice(BigDecimal OldCostPrice) {
		if (get_ID() == 0) {
			super.setOldCostPrice(OldCostPrice);
		}
	}
	/**
	 * Set Old Accumulated Qty.
	 *
	 * @param OldCQty Old accumulated qty before the processing of M_CostDetail
	 */

	public void setOldCQty(BigDecimal OldCQty) {
		if (get_ID() == 0) {
			super.setOldCQty(OldCQty);
		}
	}
	/**
	 * Set Old Current Quantity.
	 *
	 * @param OldQty Old current quantity before the processing of M_CostDetail
	 */

	public void setOldQty(BigDecimal OldQty) {
		if (get_ID() == 0) {
			super.setOldQty(OldQty);
		}
	}
}
