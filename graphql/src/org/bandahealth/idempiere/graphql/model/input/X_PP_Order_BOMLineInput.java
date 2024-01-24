package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MChangeNotice;
import org.compiere.model.MLocator;
import org.compiere.model.MOrg;
import org.compiere.model.MUOM;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.eevolution.model.X_PP_Order;
import org.eevolution.model.X_PP_Order_BOM;
import org.eevolution.model.X_PP_Order_BOMLine;

import java.math.BigDecimal;
import java.sql.ResultSet;

/**
 * Generated Model for PP_Order_BOMLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PP_Order_BOMLineInput extends X_PP_Order_BOMLine implements I_PP_Order_BOMLineInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_User;
	private ForeignEntityInput mC_UOM;
	private ForeignEntityInput mM_AttributeSetInstance;
	private ForeignEntityInput mM_ChangeNotice;
	private ForeignEntityInput mM_Locator;
	private ForeignEntityInput mM_Product;
	private ForeignEntityInput mM_Warehouse;
	private ForeignEntityInput mPP_Order;
	private ForeignEntityInput mPP_Order_BOM;
	private I_AD_Ref_ListInput mComponentType;
	private I_AD_Ref_ListInput mIssueMethod;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The PP_Order_BOMLine_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_PP_Order_BOMLineInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new X_PP_Order_BOMLine(null, (ResultSet) null, null),
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
	 * Set User/Contact.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	@JsonProperty("AD_User")
	public void setAD_UserInput(ForeignEntityInput AD_User) {
		this.mAD_User = AD_User;
		MUser_BH foreignEntity;
		if (AD_User != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
							.setParameters(AD_User.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_User_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_User with UUID " + AD_User.getUUID());
			}
		} else {
			super.setAD_User_ID(0);
		}
	}

	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	@JsonProperty("AD_User")
	public ForeignEntityInput AD_User() {
		return mAD_User;
	}
	/**
	 * Set Quantity Assay.
	 *
	 * @param Assay Indicated the Quantity Assay to use into Quality Order
	 */

	public void setAssay(BigDecimal Assay) {
		if (get_ID() == 0) {
			super.setAssay(Assay);
		}
	}
	/**
	 * Set Backflush Group.
	 *
	 * @param BackflushGroup The Grouping Components to the Backflush
	 */

	public void setBackflushGroup(String BackflushGroup) {
		if (get_ID() == 0) {
			super.setBackflushGroup(BackflushGroup);
		}
	}

	/**
	 * Set UOM.
	 *
	 * @param C_UOM Unit of Measure
	 */
	@JsonProperty("C_UOM")
	public void setC_UOMInput(ForeignEntityInput C_UOM) {
		this.mC_UOM = C_UOM;
		MUOM foreignEntity;
		if (get_ID() == 0 && C_UOM != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_UOM", "C_UOM_UU=?", get_TrxName())
							.setParameters(C_UOM.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_UOM_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_UOM with UUID " + C_UOM.getUUID());
			}
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
	 * Set Component Type.
	 *
	 * @param ComponentType Component Type for a Bill of Material or Formula
	 */
	@JsonProperty("ComponentType")
	public void setComponentTypeInput(I_AD_Ref_ListInput ComponentType) {
		this.mComponentType = ComponentType;
		MRefList_BH foreignEntity;
		if (ComponentType != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(ComponentType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setComponentType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + ComponentType.getUUID());
			}
		} else {
			this.setComponentType(null);
		}
	}

	/**
	 * Get Component Type.
	 *
	 * @return Component Type for a Bill of Material or Formula
	 */
	@JsonProperty("ComponentType")
	public I_AD_Ref_ListInput ComponentType() {
		return mComponentType;
	}
	/**
	 * Set Forecast.
	 *
	 * @param Forecast Indicated the % of participation this component into a of the BOM Planning
	 */

	public void setForecast(BigDecimal Forecast) {
		if (get_ID() == 0) {
			super.setForecast(Forecast);
		}
	}
	/**
	 * Set Is Qty Percentage.
	 *
	 * @param IsQtyPercentage Indicate that this component is based in % Quantity
	 */

	public void setIsQtyPercentage(boolean IsQtyPercentage) {
		if (get_ID() == 0) {
			super.setIsQtyPercentage(IsQtyPercentage);
		}
	}

	/**
	 * Set Issue Method.
	 *
	 * @param IssueMethod There are two methods for issue the components to Manufacturing Order
	 */
	@JsonProperty("IssueMethod")
	public void setIssueMethodInput(I_AD_Ref_ListInput IssueMethod) {
		this.mIssueMethod = IssueMethod;
		MRefList_BH foreignEntity;
		if (IssueMethod != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(IssueMethod.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setIssueMethod(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + IssueMethod.getUUID());
			}
		} else {
			this.setIssueMethod(null);
		}
	}

	/**
	 * Get Issue Method.
	 *
	 * @return There are two methods for issue the components to Manufacturing Order
	 */
	@JsonProperty("IssueMethod")
	public I_AD_Ref_ListInput IssueMethod() {
		return mIssueMethod;
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
	 * Set Change Notice.
	 *
	 * @param M_ChangeNotice Bill of Materials (Engineering) Change Notice (Version)
	 */
	@JsonProperty("M_ChangeNotice")
	public void setM_ChangeNoticeInput(ForeignEntityInput M_ChangeNotice) {
		this.mM_ChangeNotice = M_ChangeNotice;
		MChangeNotice foreignEntity;
		if (M_ChangeNotice != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "M_ChangeNotice", "M_ChangeNotice_UU=?", get_TrxName())
							.setParameters(M_ChangeNotice.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_ChangeNotice_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_ChangeNotice with UUID " + M_ChangeNotice.getUUID());
			}
		} else {
			super.setM_ChangeNotice_ID(0);
		}
	}

	/**
	 * Get Change Notice.
	 *
	 * @return Bill of Materials (Engineering) Change Notice (Version)
	 */
	@JsonProperty("M_ChangeNotice")
	public ForeignEntityInput M_ChangeNotice() {
		return mM_ChangeNotice;
	}

	/**
	 * Set Locator.
	 *
	 * @param M_Locator Warehouse Locator
	 */
	@JsonProperty("M_Locator")
	public void setM_LocatorInput(ForeignEntityInput M_Locator) {
		this.mM_Locator = M_Locator;
		MLocator foreignEntity;
		if (M_Locator != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "M_Locator", "M_Locator_UU=?", get_TrxName())
							.setParameters(M_Locator.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_Locator_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Locator with UUID " + M_Locator.getUUID());
			}
		} else {
			super.setM_Locator_ID(0);
		}
	}

	/**
	 * Get Locator.
	 *
	 * @return Warehouse Locator
	 */
	@JsonProperty("M_Locator")
	public ForeignEntityInput M_Locator() {
		return mM_Locator;
	}

	/**
	 * Set Product/Service.
	 *
	 * @param M_Product Product, Service, Item
	 */
	@JsonProperty("M_Product")
	public void setM_ProductInput(ForeignEntityInput M_Product) {
		this.mM_Product = M_Product;
		MProduct_BH foreignEntity;
		if (get_ID() == 0 && M_Product != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "M_Product", "M_Product_UU=?", get_TrxName())
							.setParameters(M_Product.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_Product_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Product with UUID " + M_Product.getUUID());
			}
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
		MWarehouse_BH foreignEntity;
		if (M_Warehouse != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "M_Warehouse", "M_Warehouse_UU=?", get_TrxName())
							.setParameters(M_Warehouse.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_Warehouse_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Warehouse with UUID " + M_Warehouse.getUUID());
			}
		} else {
			super.setM_Warehouse_ID(0);
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
	 * Set Manufacturing Order BOM.
	 *
	 * @param PP_Order_BOM Manufacturing Order BOM
	 */
	@JsonProperty("PP_Order_BOM")
	public void setPP_Order_BOMInput(ForeignEntityInput PP_Order_BOM) {
		this.mPP_Order_BOM = PP_Order_BOM;
		X_PP_Order_BOM foreignEntity;
		if (get_ID() == 0 && PP_Order_BOM != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "PP_Order_BOM", "PP_Order_BOM_UU=?", get_TrxName())
							.setParameters(PP_Order_BOM.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setPP_Order_BOM_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table PP_Order_BOM with UUID " + PP_Order_BOM.getUUID());
			}
		}
	}

	/**
	 * Get Manufacturing Order BOM.
	 *
	 * @return Manufacturing Order BOM
	 */
	@JsonProperty("PP_Order_BOM")
	public ForeignEntityInput PP_Order_BOM() {
		return mPP_Order_BOM;
	}
	/**
	 * Set Manufacturing Order BOM Line.
	 *
	 * @param PP_Order_BOMLine_ID Manufacturing Order BOM Line
	 */

	public void setPP_Order_BOMLine_ID(int PP_Order_BOMLine_ID) {
		if (get_ID() == 0) {
			super.setPP_Order_BOMLine_ID(PP_Order_BOMLine_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setPP_Order_BOMLine_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getPP_Order_BOMLine_UU();
	}

	/**
	 * Set Manufacturing Order.
	 *
	 * @param PP_Order Manufacturing Order
	 */
	@JsonProperty("PP_Order")
	public void setPP_OrderInput(ForeignEntityInput PP_Order) {
		this.mPP_Order = PP_Order;
		X_PP_Order foreignEntity;
		if (get_ID() == 0 && PP_Order != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "PP_Order", "PP_Order_UU=?", get_TrxName())
							.setParameters(PP_Order.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setPP_Order_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table PP_Order with UUID " + PP_Order.getUUID());
			}
		}
	}

	/**
	 * Get Manufacturing Order.
	 *
	 * @return Manufacturing Order
	 */
	@JsonProperty("PP_Order")
	public ForeignEntityInput PP_Order() {
		return mPP_Order;
	}
	/**
	 * Set Quantity in %.
	 *
	 * @param QtyBatch Indicate the Quantity % use in this Formula
	 */

	public void setQtyBatch(BigDecimal QtyBatch) {
		if (get_ID() == 0) {
			super.setQtyBatch(QtyBatch);
		}
	}
	/**
	 * Set Quantity.
	 *
	 * @param QtyBOM Indicate the Quantity  use in this BOM
	 */

	public void setQtyBOM(BigDecimal QtyBOM) {
		if (get_ID() == 0) {
			super.setQtyBOM(QtyBOM);
		}
	}
	/**
	 * Set Delivered Quantity.
	 *
	 * @param QtyDelivered Delivered Quantity
	 */

	public void setQtyDelivered(BigDecimal QtyDelivered) {
		if (get_ID() == 0) {
			super.setQtyDelivered(QtyDelivered);
		}
	}
	/**
	 * Set Quantity.
	 *
	 * @param QtyEntered The Quantity Entered is based on the selected UoM
	 */

	public void setQtyEntered(BigDecimal QtyEntered) {
		if (get_ID() == 0) {
			super.setQtyEntered(QtyEntered);
		}
	}
	/**
	 * Set Qty Post.
	 *
	 * @param QtyPost Qty Post
	 */

	public void setQtyPost(BigDecimal QtyPost) {
		if (get_ID() == 0) {
			super.setQtyPost(QtyPost);
		}
	}
	/**
	 * Set Qty Reject.
	 *
	 * @param QtyReject Qty Reject
	 */

	public void setQtyReject(BigDecimal QtyReject) {
		if (get_ID() == 0) {
			super.setQtyReject(QtyReject);
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
	 * Set Scrap %.
	 *
	 * @param QtyScrap Scrap % Quantity for this componet
	 */

	public void setQtyScrap(BigDecimal QtyScrap) {
		if (get_ID() == 0) {
			super.setQtyScrap(QtyScrap);
		}
	}
	/**
	 * Set Scrap %.
	 *
	 * @param Scrap Indicate the Scrap %  for calculate the Scrap Quantity
	 */

	public void setScrap(BigDecimal Scrap) {
		if (get_ID() == 0) {
			super.setScrap(Scrap);
		}
	}
}
