package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MChangeNotice;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
import org.compiere.model.MUOM;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.eevolution.model.X_PP_Order;
import org.eevolution.model.X_PP_Order_BOM;

/**
 * Generated Model for PP_Order_BOM - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PP_Order_BOMInput extends X_PP_Order_BOM implements I_PP_Order_BOMInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput BOMType_RL;
	 private I_AD_Ref_ListInput BOMUse_RL;
	 private I_C_UOMInput C_UOM;
	 private I_M_AttributeSetInstanceInput M_AttributeSetInstance;
	 private I_M_ChangeNoticeInput M_ChangeNotice;
	 private I_M_ProductInput M_Product;
	 private I_PP_OrderInput PP_Order;

	/**
	 * Standard constructor
	 */
	public X_PP_Order_BOMInput(String ID) {
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
		if (AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Org_ID(foreignEntity.get_ID());
		} else {
			this.setAD_Org_ID(0);
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
	 * Set BOM Type.
	 *
	 * @param BOMType_RL Type of BOM
	 */
	public void setBOMType_RL(I_AD_Ref_ListInput BOMType_RL) {
		this.BOMType_RL = BOMType_RL;
		MRefList foreignEntity;
		if (BOMType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(BOMType_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setBOMType(foreignEntity.getValue());
		} else {
			this.setBOMType(null);
		}
	}

	/**
	 * Get BOM Type.
	 *
	 * @return Type of BOM
	 */
	public I_AD_Ref_ListInput getBOMType_RL() {
		return BOMType_RL;
	}

	/**
	 * Set BOM Use.
	 *
	 * @param BOMUse_RL The use of the Bill of Material
	 */
	public void setBOMUse_RL(I_AD_Ref_ListInput BOMUse_RL) {
		this.BOMUse_RL = BOMUse_RL;
		MRefList foreignEntity;
		if (BOMUse_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(BOMUse_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setBOMUse(foreignEntity.getValue());
		} else {
			this.setBOMUse(null);
		}
	}

	/**
	 * Get BOM Use.
	 *
	 * @return The use of the Bill of Material
	 */
	public I_AD_Ref_ListInput getBOMUse_RL() {
		return BOMUse_RL;
	}

	/**
	 * Set UOM.
	 *
	 * @param C_UOM Unit of Measure
	 */
	public void setC_UOM(I_C_UOMInput C_UOM) {
		this.C_UOM = C_UOM;
		MUOM foreignEntity;
		if (C_UOM != null &&
				(foreignEntity = new Query(getCtx(), MUOM.Table_Name, MUOM.COLUMNNAME_C_UOM_UU + "=?", get_TrxName())
						.setParameters(C_UOM.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_UOM_ID(foreignEntity.get_ID());
		} else {
			this.setC_UOM_ID(0);
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
	 * Set Attribute Set Instance.
	 *
	 * @param M_AttributeSetInstance Product Attribute Set Instance
	 */
	public void setM_AttributeSetInstance(I_M_AttributeSetInstanceInput M_AttributeSetInstance) {
		this.M_AttributeSetInstance = M_AttributeSetInstance;
		MAttributeSetInstance_BH foreignEntity;
		if (M_AttributeSetInstance != null &&
				(foreignEntity = new Query(getCtx(), MAttributeSetInstance_BH.Table_Name, MAttributeSetInstance_BH.COLUMNNAME_M_AttributeSetInstance_UU + "=?", get_TrxName())
						.setParameters(M_AttributeSetInstance.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_AttributeSetInstance_ID(foreignEntity.get_ID());
		} else {
			this.setM_AttributeSetInstance_ID(0);
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
	 * Set Product/Service.
	 *
	 * @param M_Product Product, Service, Item
	 */
	public void setM_Product(I_M_ProductInput M_Product) {
		this.M_Product = M_Product;
		MProduct_BH foreignEntity;
		if (M_Product != null &&
				(foreignEntity = new Query(getCtx(), MProduct_BH.Table_Name, MProduct_BH.COLUMNNAME_M_Product_UU + "=?", get_TrxName())
						.setParameters(M_Product.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_Product_ID(foreignEntity.get_ID());
		} else {
			this.setM_Product_ID(0);
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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setPP_Order_BOM_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getPP_Order_BOM_UU();
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
}
