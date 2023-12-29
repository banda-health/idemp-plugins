package org.bandahealth.idempiere.graphql.model.input;

import java.math.BigDecimal;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MChangeNotice;
import org.compiere.model.MLocator;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
import org.compiere.model.MUOM;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.eevolution.model.X_PP_Order;
import org.eevolution.model.X_PP_Order_BOM;
import org.eevolution.model.X_PP_Order_BOMLine;

/**
 * Generated Model for PP_Order_BOMLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PP_Order_BOMLineInput extends X_PP_Order_BOMLine implements I_PP_Order_BOMLineInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput ComponentType_RL;
	 private I_AD_Ref_ListInput IssueMethod_RL;
	 private I_AD_UserInput AD_User;
	 private I_C_UOMInput C_UOM;
	 private I_M_AttributeSetInstanceInput M_AttributeSetInstance;
	 private I_M_ChangeNoticeInput M_ChangeNotice;
	 private I_M_LocatorInput M_Locator;
	 private I_M_ProductInput M_Product;
	 private I_M_WarehouseInput M_Warehouse;
	 private I_PP_OrderInput PP_Order;
	 private I_PP_Order_BOMInput PP_Order_BOM;

	/**
	 * Standard constructor
	 */
	public X_PP_Order_BOMLineInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	public void setAD_Org(I_AD_OrgInput AD_Org) {
		this.AD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	public I_AD_OrgInput getAD_Org() {
		return AD_Org;
	}

	/**
	 * Set User/Contact.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	public void setAD_User(I_AD_UserInput AD_User) {
		this.AD_User = AD_User;
		MUser_BH foreignEntity;
		if (AD_User != null &&
				(foreignEntity = new Query(getCtx(), MUser_BH.Table_Name, MUser_BH.COLUMNNAME_AD_User_UU + "=?", get_TrxName())
						.setParameters(AD_User.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_User_ID(foreignEntity.get_ID());
		} else {
			this.setAD_User_ID(0);
		}
	}

	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	public I_AD_UserInput getAD_User() {
		return AD_User;
	}
	/**
	 * Set User/Contact.
	 *
	 * @param AD_User_ID User within the system - Internal or Business Partner Contact
	 */

	public void setAD_User_ID(int AD_User_ID) {
		if (get_ID() == 0) {
			super.setAD_User_ID(AD_User_ID);
		}
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
	public void setC_UOM(I_C_UOMInput C_UOM) {
		this.C_UOM = C_UOM;
		MUOM foreignEntity;
		if (get_ID() == 0 &&C_UOM != null &&
				(foreignEntity = new Query(getCtx(), MUOM.Table_Name, MUOM.COLUMNNAME_C_UOM_UU + "=?", get_TrxName())
						.setParameters(C_UOM.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_UOM_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get UOM.
	 *
	 * @return Unit of Measure
	 */
	public I_C_UOMInput getC_UOM() {
		return C_UOM;
	}
	/**
	 * Set UOM.
	 *
	 * @param C_UOM_ID Unit of Measure
	 */

	public void setC_UOM_ID(int C_UOM_ID) {
		if (get_ID() == 0) {
			super.setC_UOM_ID(C_UOM_ID);
		}
	}

	/**
	 * Set Component Type.
	 *
	 * @param ComponentType_RL Component Type for a Bill of Material or Formula
	 */
	public void setComponentType_RL(I_AD_Ref_ListInput ComponentType_RL) {
		this.ComponentType_RL = ComponentType_RL;
		MRefList foreignEntity;
		if (ComponentType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(ComponentType_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setComponentType(foreignEntity.getValue());
		} else {
			this.setComponentType(null);
		}
	}

	/**
	 * Get Component Type.
	 *
	 * @return Component Type for a Bill of Material or Formula
	 */
	public I_AD_Ref_ListInput getComponentType_RL() {
		return ComponentType_RL;
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
	 * @param IssueMethod_RL There are two methods for issue the components to Manufacturing Order
	 */
	public void setIssueMethod_RL(I_AD_Ref_ListInput IssueMethod_RL) {
		this.IssueMethod_RL = IssueMethod_RL;
		MRefList foreignEntity;
		if (IssueMethod_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(IssueMethod_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setIssueMethod(foreignEntity.getValue());
		} else {
			this.setIssueMethod(null);
		}
	}

	/**
	 * Get Issue Method.
	 *
	 * @return There are two methods for issue the components to Manufacturing Order
	 */
	public I_AD_Ref_ListInput getIssueMethod_RL() {
		return IssueMethod_RL;
	}

	/**
	 * Set Attribute Set Instance.
	 *
	 * @param M_AttributeSetInstance Product Attribute Set Instance
	 */
	public void setM_AttributeSetInstance(I_M_AttributeSetInstanceInput M_AttributeSetInstance) {
		this.M_AttributeSetInstance = M_AttributeSetInstance;
		MAttributeSetInstance_BH foreignEntity;
		if (get_ID() == 0 &&M_AttributeSetInstance != null &&
				(foreignEntity = new Query(getCtx(), MAttributeSetInstance_BH.Table_Name, MAttributeSetInstance_BH.COLUMNNAME_M_AttributeSetInstance_UU + "=?", get_TrxName())
						.setParameters(M_AttributeSetInstance.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_AttributeSetInstance_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Attribute Set Instance.
	 *
	 * @return Product Attribute Set Instance
	 */
	public I_M_AttributeSetInstanceInput getM_AttributeSetInstance() {
		return M_AttributeSetInstance;
	}
	/**
	 * Set Attribute Set Instance.
	 *
	 * @param M_AttributeSetInstance_ID Product Attribute Set Instance
	 */

	public void setM_AttributeSetInstance_ID(int M_AttributeSetInstance_ID) {
		if (get_ID() == 0) {
			super.setM_AttributeSetInstance_ID(M_AttributeSetInstance_ID);
		}
	}

	/**
	 * Set Change Notice.
	 *
	 * @param M_ChangeNotice Bill of Materials (Engineering) Change Notice (Version)
	 */
	public void setM_ChangeNotice(I_M_ChangeNoticeInput M_ChangeNotice) {
		this.M_ChangeNotice = M_ChangeNotice;
		MChangeNotice foreignEntity;
		if (M_ChangeNotice != null &&
				(foreignEntity = new Query(getCtx(), MChangeNotice.Table_Name, MChangeNotice.COLUMNNAME_M_ChangeNotice_UU + "=?", get_TrxName())
						.setParameters(M_ChangeNotice.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_ChangeNotice_ID(foreignEntity.get_ID());
		} else {
			this.setM_ChangeNotice_ID(0);
		}
	}

	/**
	 * Get Change Notice.
	 *
	 * @return Bill of Materials (Engineering) Change Notice (Version)
	 */
	public I_M_ChangeNoticeInput getM_ChangeNotice() {
		return M_ChangeNotice;
	}

	/**
	 * Set Locator.
	 *
	 * @param M_Locator Warehouse Locator
	 */
	public void setM_Locator(I_M_LocatorInput M_Locator) {
		this.M_Locator = M_Locator;
		MLocator foreignEntity;
		if (M_Locator != null &&
				(foreignEntity = new Query(getCtx(), MLocator.Table_Name, MLocator.COLUMNNAME_M_Locator_UU + "=?", get_TrxName())
						.setParameters(M_Locator.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_Locator_ID(foreignEntity.get_ID());
		} else {
			this.setM_Locator_ID(0);
		}
	}

	/**
	 * Get Locator.
	 *
	 * @return Warehouse Locator
	 */
	public I_M_LocatorInput getM_Locator() {
		return M_Locator;
	}

	/**
	 * Set Product/Service.
	 *
	 * @param M_Product Product, Service, Item
	 */
	public void setM_Product(I_M_ProductInput M_Product) {
		this.M_Product = M_Product;
		MProduct_BH foreignEntity;
		if (get_ID() == 0 &&M_Product != null &&
				(foreignEntity = new Query(getCtx(), MProduct_BH.Table_Name, MProduct_BH.COLUMNNAME_M_Product_UU + "=?", get_TrxName())
						.setParameters(M_Product.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_Product_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	public I_M_ProductInput getM_Product() {
		return M_Product;
	}
	/**
	 * Set Product/Service.
	 *
	 * @param M_Product_ID Product, Service, Item
	 */

	public void setM_Product_ID(int M_Product_ID) {
		if (get_ID() == 0) {
			super.setM_Product_ID(M_Product_ID);
		}
	}

	/**
	 * Set Warehouse.
	 *
	 * @param M_Warehouse Storage Warehouse and Service Point
	 */
	public void setM_Warehouse(I_M_WarehouseInput M_Warehouse) {
		this.M_Warehouse = M_Warehouse;
		MWarehouse_BH foreignEntity;
		if (M_Warehouse != null &&
				(foreignEntity = new Query(getCtx(), MWarehouse_BH.Table_Name, MWarehouse_BH.COLUMNNAME_M_Warehouse_UU + "=?", get_TrxName())
						.setParameters(M_Warehouse.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_Warehouse_ID(foreignEntity.get_ID());
		} else {
			this.setM_Warehouse_ID(0);
		}
	}

	/**
	 * Get Warehouse.
	 *
	 * @return Storage Warehouse and Service Point
	 */
	public I_M_WarehouseInput getM_Warehouse() {
		return M_Warehouse;
	}

	/**
	 * Set Manufacturing Order BOM.
	 *
	 * @param PP_Order_BOM Manufacturing Order BOM
	 */
	public void setPP_Order_BOM(I_PP_Order_BOMInput PP_Order_BOM) {
		this.PP_Order_BOM = PP_Order_BOM;
		X_PP_Order_BOM foreignEntity;
		if (get_ID() == 0 &&PP_Order_BOM != null &&
				(foreignEntity = new Query(getCtx(), X_PP_Order_BOM.Table_Name, X_PP_Order_BOM.COLUMNNAME_PP_Order_BOM_UU + "=?", get_TrxName())
						.setParameters(PP_Order_BOM.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setPP_Order_BOM_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Manufacturing Order BOM.
	 *
	 * @return Manufacturing Order BOM
	 */
	public I_PP_Order_BOMInput getPP_Order_BOM() {
		return PP_Order_BOM;
	}
	/**
	 * Set Manufacturing Order BOM.
	 *
	 * @param PP_Order_BOM_ID Manufacturing Order BOM
	 */

	public void setPP_Order_BOM_ID(int PP_Order_BOM_ID) {
		if (get_ID() == 0) {
			super.setPP_Order_BOM_ID(PP_Order_BOM_ID);
		}
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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setPP_Order_BOMLine_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getPP_Order_BOMLine_UU();
	}

	/**
	 * Set Manufacturing Order.
	 *
	 * @param PP_Order Manufacturing Order
	 */
	public void setPP_Order(I_PP_OrderInput PP_Order) {
		this.PP_Order = PP_Order;
		X_PP_Order foreignEntity;
		if (get_ID() == 0 &&PP_Order != null &&
				(foreignEntity = new Query(getCtx(), X_PP_Order.Table_Name, X_PP_Order.COLUMNNAME_PP_Order_UU + "=?", get_TrxName())
						.setParameters(PP_Order.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setPP_Order_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Manufacturing Order.
	 *
	 * @return Manufacturing Order
	 */
	public I_PP_OrderInput getPP_Order() {
		return PP_Order;
	}
	/**
	 * Set Manufacturing Order.
	 *
	 * @param PP_Order_ID Manufacturing Order
	 */

	public void setPP_Order_ID(int PP_Order_ID) {
		if (get_ID() == 0) {
			super.setPP_Order_ID(PP_Order_ID);
		}
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
