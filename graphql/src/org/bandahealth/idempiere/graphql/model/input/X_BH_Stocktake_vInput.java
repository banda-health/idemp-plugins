package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MAttributeSet_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.base.model.X_BH_Stocktake_v;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for BH_Stocktake_v - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_BH_Stocktake_vInput extends X_BH_Stocktake_v implements I_BH_Stocktake_vInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mM_AttributeSet;
	private ForeignEntityInput mM_AttributeSetInstance;
	private ForeignEntityInput mM_Product;
	private ForeignEntityInput mM_Warehouse;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The BH_Stocktake_v_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_BH_Stocktake_vInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new X_BH_Stocktake_v(null, (ResultSet) null, null),
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
	 * Set Instance Attribute.
	 *
	 * @param IsInstanceAttribute The product attribute is specific to the instance (like Serial No, Lot or Guarantee Date)
	 */

	public void setIsInstanceAttribute(boolean IsInstanceAttribute) {
		if (get_ID() == 0) {
			super.setIsInstanceAttribute(IsInstanceAttribute);
		}
	}
	/**
	 * Set location.
	 *
	 * @param location location
	 */

	public void setlocation(String location) {
		if (get_ID() == 0) {
			super.setlocation(location);
		}
	}

	/**
	 * Set Attribute Set.
	 *
	 * @param M_AttributeSet Product Attribute Set
	 */
	@JsonProperty("M_AttributeSet")
	public void setM_AttributeSetInput(ForeignEntityInput M_AttributeSet) {
		this.mM_AttributeSet = M_AttributeSet;
		if (get_ID() != 0) {
			return;
		}
		if (M_AttributeSet != null) {
			// Since an entity was passed, make sure it's in the DB
			MAttributeSet_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_AttributeSet", "M_AttributeSet_UU=?", get_TrxName())
							.setParameters(M_AttributeSet.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_AttributeSet_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_AttributeSet with UUID " + M_AttributeSet.getUUID());
			}
		} else {
			this.setM_AttributeSet_ID(0);
		}
	}

	/**
	 * Get Attribute Set.
	 *
	 * @return Product Attribute Set
	 */
	@JsonProperty("M_AttributeSet")
	public ForeignEntityInput M_AttributeSet() {
		return mM_AttributeSet;
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

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setM_Storage_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getM_Storage_UU();
	}

	/**
	 * Set Warehouse.
	 *
	 * @param M_Warehouse Storage Warehouse and Service Point
	 */
	@JsonProperty("M_Warehouse")
	public void setM_WarehouseInput(ForeignEntityInput M_Warehouse) {
		this.mM_Warehouse = M_Warehouse;
		if (M_Warehouse != null) {
			// Since an entity was passed, make sure it's in the DB
			MWarehouse_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_Warehouse", "M_Warehouse_UU=?", get_TrxName())
							.setParameters(M_Warehouse.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_Warehouse_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Warehouse with UUID " + M_Warehouse.getUUID());
			}
		} else {
			this.setM_Warehouse_ID(0);
		}
	}

	/**
	 * Get Warehouse.
	 *
	 * @return Storage Warehouse and Service Point
	 */
	@JsonProperty("M_Warehouse")
	public ForeignEntityInput M_Warehouse() {
		return mM_Warehouse;
	}
	/**
	 * Set Processed.
	 *
	 * @param Processed The document has been processed
	 */

	public void setProcessed(boolean Processed) {
		if (get_ID() == 0) {
			super.setProcessed(Processed);
		}
	}
	/**
	 * Set Product.
	 *
	 * @param Product Product
	 */

	public void setProduct(String Product) {
		if (get_ID() == 0) {
			super.setProduct(Product);
		}
	}
	/**
	 * Set quantity.
	 *
	 * @param quantity quantity
	 */

	public void setquantity(int quantity) {
		if (get_ID() == 0) {
			super.setquantity(quantity);
		}
	}
	/**
	 * Set Shelf Life Days.
	 *
	 * @param ShelfLifeDays Shelf Life in days based on Product Instance Guarantee Date
	 */

	public void setShelfLifeDays(int ShelfLifeDays) {
		if (get_ID() == 0) {
			super.setShelfLifeDays(ShelfLifeDays);
		}
	}
}
