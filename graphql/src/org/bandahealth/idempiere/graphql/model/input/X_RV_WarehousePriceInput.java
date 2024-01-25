package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.compiere.model.MOrg;
import org.compiere.model.MPriceListVersion;
import org.compiere.model.MUOM;
import org.compiere.model.MWarehousePrice;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.math.BigDecimal;
import java.sql.ResultSet;

/**
 * Generated Model for RV_WarehousePrice - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_RV_WarehousePriceInput extends MWarehousePrice implements I_RV_WarehousePriceInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_UOM;
	private ForeignEntityInput mM_PriceList_Version;
	private ForeignEntityInput mM_Product;
	private ForeignEntityInput mM_Warehouse;

	/**
	 * Standard constructor
	 */
	public X_RV_WarehousePriceInput() {
		super(Env.getCtx(), (ResultSet) null, null);
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
	 * Set UOM.
	 *
	 * @param C_UOM Unit of Measure
	 */
	@JsonProperty("C_UOM")
	public void setC_UOMInput(ForeignEntityInput C_UOM) {
		this.mC_UOM = C_UOM;
		if (get_ID() != 0) {
			return;
		}
		if (C_UOM != null) {
			// Since an entity was passed, make sure it's in the DB
			MUOM foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_UOM", "C_UOM_UU=?", get_TrxName())
							.setParameters(C_UOM.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_UOM_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_UOM with UUID " + C_UOM.getUUID());
			}
		} else {
			this.setC_UOM_ID(0);
		}
	}

	/**
	 * Get UOM.
	 *
	 * @return Unit of Measure
	 */
	@JsonProperty("C_UOM")
	public ForeignEntityInput C_UOM() {
		return mC_UOM;
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
	 * Set Price List Version.
	 *
	 * @param M_PriceList_Version Identifies a unique instance of a Price List
	 */
	@JsonProperty("M_PriceList_Version")
	public void setM_PriceList_VersionInput(ForeignEntityInput M_PriceList_Version) {
		this.mM_PriceList_Version = M_PriceList_Version;
		if (get_ID() != 0) {
			return;
		}
		if (M_PriceList_Version != null) {
			// Since an entity was passed, make sure it's in the DB
			MPriceListVersion foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_PriceList_Version", "M_PriceList_Version_UU=?", get_TrxName())
							.setParameters(M_PriceList_Version.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_PriceList_Version_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_PriceList_Version with UUID " + M_PriceList_Version.getUUID());
			}
		} else {
			this.setM_PriceList_Version_ID(0);
		}
	}

	/**
	 * Get Price List Version.
	 *
	 * @return Identifies a unique instance of a Price List
	 */
	@JsonProperty("M_PriceList_Version")
	public ForeignEntityInput M_PriceList_Version() {
		return mM_PriceList_Version;
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
	 * Set Warehouse.
	 *
	 * @param M_Warehouse Storage Warehouse and Service Point
	 */
	@JsonProperty("M_Warehouse")
	public void setM_WarehouseInput(ForeignEntityInput M_Warehouse) {
		this.mM_Warehouse = M_Warehouse;
		if (get_ID() != 0) {
			return;
		}
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
	 * Set Margin %.
	 *
	 * @param Margin Margin for a product as a percentage
	 */

	public void setMargin(BigDecimal Margin) {
		if (get_ID() == 0) {
			super.setMargin(Margin);
		}
	}
	/**
	 * Set Name.
	 *
	 * @param Name Alphanumeric identifier of the entity
	 */

	public void setName(String Name) {
		if (get_ID() == 0) {
			super.setName(Name);
		}
	}
	/**
	 * Set Limit Price.
	 *
	 * @param PriceLimit Lowest price for a product
	 */

	public void setPriceLimit(BigDecimal PriceLimit) {
		if (get_ID() == 0) {
			super.setPriceLimit(PriceLimit);
		}
	}
	/**
	 * Set List Price.
	 *
	 * @param PriceList List Price
	 */

	public void setPriceList(BigDecimal PriceList) {
		if (get_ID() == 0) {
			super.setPriceList(PriceList);
		}
	}
	/**
	 * Set Standard Price.
	 *
	 * @param PriceStd Standard Price
	 */

	public void setPriceStd(BigDecimal PriceStd) {
		if (get_ID() == 0) {
			super.setPriceStd(PriceStd);
		}
	}
	/**
	 * Set Available Quantity.
	 *
	 * @param QtyAvailable Available Quantity (On Hand - Reserved)
	 */

	public void setQtyAvailable(BigDecimal QtyAvailable) {
		if (get_ID() == 0) {
			super.setQtyAvailable(QtyAvailable);
		}
	}
	/**
	 * Set On Hand Quantity.
	 *
	 * @param QtyOnHand On Hand Quantity
	 */

	public void setQtyOnHand(BigDecimal QtyOnHand) {
		if (get_ID() == 0) {
			super.setQtyOnHand(QtyOnHand);
		}
	}
	/**
	 * Set Ordered Quantity.
	 *
	 * @param QtyOrdered Ordered Quantity
	 */

	public void setQtyOrdered(BigDecimal QtyOrdered) {
		if (get_ID() == 0) {
			super.setQtyOrdered(QtyOrdered);
		}
	}
	/**
	 * Set Reserved Quantity.
	 *
	 * @param QtyReserved Reserved Quantity
	 */

	public void setQtyReserved(BigDecimal QtyReserved) {
		if (get_ID() == 0) {
			super.setQtyReserved(QtyReserved);
		}
	}
	/**
	 * Set SKU.
	 *
	 * @param SKU Stock Keeping Unit
	 */

	public void setSKU(String SKU) {
		if (get_ID() == 0) {
			super.setSKU(SKU);
		}
	}
	/**
	 * Set Symbol.
	 *
	 * @param UOMSymbol Symbol for a Unit of Measure
	 */

	public void setUOMSymbol(String UOMSymbol) {
		if (get_ID() == 0) {
			super.setUOMSymbol(UOMSymbol);
		}
	}
	/**
	 * Set UPC/EAN.
	 *
	 * @param UPC Bar Code (Universal Product Code or its superset European Article Number)
	 */

	public void setUPC(String UPC) {
		if (get_ID() == 0) {
			super.setUPC(UPC);
		}
	}
	/**
	 * Set Search Key.
	 *
	 * @param Value Search key for the record in the format required - must be unique
	 */

	public void setValue(String Value) {
		if (get_ID() == 0) {
			super.setValue(Value);
		}
	}
	/**
	 * Set Warehouse.
	 *
	 * @param WarehouseName Warehouse Name
	 */

	public void setWarehouseName(String WarehouseName) {
		if (get_ID() == 0) {
			super.setWarehouseName(WarehouseName);
		}
	}
}
