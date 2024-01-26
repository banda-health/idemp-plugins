package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MCostElement;
import org.compiere.model.MCostQueue;
import org.compiere.model.MCostType;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for M_CostQueue - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_CostQueueInput extends MCostQueue implements I_M_CostQueueInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_AcctSchema;
	private ForeignEntityInput mM_AttributeSetInstance;
	private ForeignEntityInput mM_CostElement;
	private ForeignEntityInput mM_CostType;
	private ForeignEntityInput mM_Product;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The M_CostQueue_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_M_CostQueueInput(@JsonProperty("UUID") String UUID) {
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
	 * Set Accounting Schema.
	 *
	 * @param C_AcctSchema Rules for accounting
	 */
	@JsonProperty("C_AcctSchema")
	public void setC_AcctSchemaInput(ForeignEntityInput C_AcctSchema) {
		this.mC_AcctSchema = C_AcctSchema;
		if (get_ID() != 0) {
			return;
		}
		if (C_AcctSchema != null) {
			// Since an entity was passed, make sure it's in the DB
			MAcctSchema foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_AcctSchema", "C_AcctSchema_UU=?", get_TrxName())
							.setParameters(C_AcctSchema.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_AcctSchema_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_AcctSchema with UUID " + C_AcctSchema.getUUID());
			}
		} else {
			this.setC_AcctSchema_ID(0);
		}
	}

	/**
	 * Get Accounting Schema.
	 *
	 * @return Rules for accounting
	 */
	@JsonProperty("C_AcctSchema")
	public ForeignEntityInput C_AcctSchema() {
		return mC_AcctSchema;
	}

	/**
	 * Set Attribute Set Instance.
	 *
	 * @param M_AttributeSetInstance Product Attribute Set Instance
	 */
	@JsonProperty("M_AttributeSetInstance")
	public void setM_AttributeSetInstanceInput(ForeignEntityInput M_AttributeSetInstance) {
		this.mM_AttributeSetInstance = M_AttributeSetInstance;
		if (get_ID() != 0) {
			return;
		}
		if (M_AttributeSetInstance != null) {
			// Since an entity was passed, make sure it's in the DB
			MAttributeSetInstance_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_AttributeSetInstance", "M_AttributeSetInstance_UU=?", get_TrxName())
							.setParameters(M_AttributeSetInstance.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_AttributeSetInstance_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_AttributeSetInstance with UUID " + M_AttributeSetInstance.getUUID());
			}
		} else {
			this.setM_AttributeSetInstance_ID(0);
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
	 * Set Cost Element.
	 *
	 * @param M_CostElement Product Cost Element
	 */
	@JsonProperty("M_CostElement")
	public void setM_CostElementInput(ForeignEntityInput M_CostElement) {
		this.mM_CostElement = M_CostElement;
		if (get_ID() != 0) {
			return;
		}
		if (M_CostElement != null) {
			// Since an entity was passed, make sure it's in the DB
			MCostElement foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_CostElement", "M_CostElement_UU=?", get_TrxName())
							.setParameters(M_CostElement.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_CostElement_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_CostElement with UUID " + M_CostElement.getUUID());
			}
		} else {
			this.setM_CostElement_ID(0);
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
	 * Set Cost Queue.
	 *
	 * @param M_CostQueue_ID FiFo/LiFo Cost Queue
	 */

	public void setM_CostQueue_ID(int M_CostQueue_ID) {
		if (get_ID() == 0) {
			super.setM_CostQueue_ID(M_CostQueue_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setM_CostQueue_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getM_CostQueue_UU();
	}

	/**
	 * Set Cost Type.
	 *
	 * @param M_CostType Type of Cost (e.g. Current, Plan, Future)
	 */
	@JsonProperty("M_CostType")
	public void setM_CostTypeInput(ForeignEntityInput M_CostType) {
		this.mM_CostType = M_CostType;
		if (get_ID() != 0) {
			return;
		}
		if (M_CostType != null) {
			// Since an entity was passed, make sure it's in the DB
			MCostType foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_CostType", "M_CostType_UU=?", get_TrxName())
							.setParameters(M_CostType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_CostType_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_CostType with UUID " + M_CostType.getUUID());
			}
		} else {
			this.setM_CostType_ID(0);
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
	 * Set Product/Service.
	 *
	 * @param M_Product Product, Service, Item
	 */
	@JsonProperty("M_Product")
	public void setM_ProductInput(ForeignEntityInput M_Product) {
		this.mM_Product = M_Product;
		if (get_ID() != 0) {
			return;
		}
		if (M_Product != null) {
			// Since an entity was passed, make sure it's in the DB
			MProduct_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_Product", "M_Product_UU=?", get_TrxName())
							.setParameters(M_Product.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_Product_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Product with UUID " + M_Product.getUUID());
			}
		} else {
			this.setM_Product_ID(0);
		}
	}

	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	@JsonProperty("M_Product")
	public ForeignEntityInput M_Product() {
		return mM_Product;
	}
}
