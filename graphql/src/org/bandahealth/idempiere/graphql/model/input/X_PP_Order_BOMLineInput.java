package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_PP_Order_BOMLineResolver;
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
 * @version Release 12 - $Id$
 */
public class X_PP_Order_BOMLineInput extends X_PP_Order_BOMLine implements I_PP_Order_BOMLineInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_User;
	private ForeignEntityInput mC_UOM;
	private ForeignEntityInput mComponentType;
	private ForeignEntityInput mIssueMethod;
	private ForeignEntityInput mM_AttributeSetInstance;
	private ForeignEntityInput mM_ChangeNotice;
	private ForeignEntityInput mM_Locator;
	private ForeignEntityInput mM_Product;
	private ForeignEntityInput mM_Warehouse;
	private ForeignEntityInput mPP_Order;
	private ForeignEntityInput mPP_Order_BOM;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The PP_Order_BOMLine_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_PP_Order_BOMLineInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		if (!is_new()) {
			return;
		}
		if (AD_Org != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UU " + AD_Org.getUU());
			}
		} else {
			this.setAD_Org_ID(0);
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within tenant
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
		if (AD_User != null) {
			// Since an entity was passed, make sure it's in the DB
			MUser_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
							.setParameters(AD_User.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_User_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_User with UU " + AD_User.getUU());
			}
		} else {
			this.setAD_User_ID(0);
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
	@JsonProperty("Assay")
	public void setAssayFromJson(BigDecimal Assay) {
		if (get_ID() == 0) {
			super.setAssay(Assay);
		}
	}
	/**
	 * Set Backflush Group.
	 *
	 * @param BackflushGroup The Grouping Components to the Backflush
	 */
	@JsonProperty("BackflushGroup")
	public void setBackflushGroupFromJson(String BackflushGroup) {
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
		if (!is_new()) {
			return;
		}
		if (C_UOM != null) {
			// Since an entity was passed, make sure it's in the DB
			MUOM foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_UOM", "C_UOM_UU=?", get_TrxName())
							.setParameters(C_UOM.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_UOM_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_UOM with UU " + C_UOM.getUU());
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
	 * Set Component Type.
	 *
	 * @param ComponentType Component Type for a Bill of Material or Formula
	 */
	@JsonProperty("ComponentType")
	public void setComponentTypeInput(ForeignEntityInput ComponentType) {
		this.mComponentType = ComponentType;
		if (ComponentType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_PP_Order_BOMLineResolver.COMPONENTTYPE_UUIDS_BY_VALUE.containsValue(ComponentType.getUU())) {
				throw new AdempiereException("The reference list UU of " + ComponentType.getUU() +
						" is not in the list defined for the ComponentType column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(ComponentType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setComponentType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + ComponentType.getUU());
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
	public ForeignEntityInput ComponentType() {
		return mComponentType;
	}
	/**
	 * Set Forecast.
	 *
	 * @param Forecast Indicated the % of participation this component into a of the BOM Planning
	 */
	@JsonProperty("Forecast")
	public void setForecastFromJson(BigDecimal Forecast) {
		if (get_ID() == 0) {
			super.setForecast(Forecast);
		}
	}
	/**
	 * Set Is Qty Percentage.
	 *
	 * @param IsQtyPercentage Indicate that this component is based in % Quantity
	 */
	@JsonProperty("IsQtyPercentage")
	public void setIsQtyPercentageFromJson(boolean IsQtyPercentage) {
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
	public void setIssueMethodInput(ForeignEntityInput IssueMethod) {
		this.mIssueMethod = IssueMethod;
		if (IssueMethod != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_PP_Order_BOMLineResolver.ISSUEMETHOD_UUIDS_BY_VALUE.containsValue(IssueMethod.getUU())) {
				throw new AdempiereException("The reference list UU of " + IssueMethod.getUU() +
						" is not in the list defined for the IssueMethod column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(IssueMethod.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setIssueMethod(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + IssueMethod.getUU());
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
	public ForeignEntityInput IssueMethod() {
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
		if (!is_new()) {
			return;
		}
		if (M_AttributeSetInstance != null) {
			// Since an entity was passed, make sure it's in the DB
			MAttributeSetInstance_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_AttributeSetInstance", "M_AttributeSetInstance_UU=?", get_TrxName())
							.setParameters(M_AttributeSetInstance.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setM_AttributeSetInstance_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_AttributeSetInstance with UU " + M_AttributeSetInstance.getUU());
			}
		} else {
			this.setM_AttributeSetInstance_ID(-1);
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
		if (M_ChangeNotice != null) {
			// Since an entity was passed, make sure it's in the DB
			MChangeNotice foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_ChangeNotice", "M_ChangeNotice_UU=?", get_TrxName())
							.setParameters(M_ChangeNotice.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setM_ChangeNotice_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_ChangeNotice with UU " + M_ChangeNotice.getUU());
			}
		} else {
			this.setM_ChangeNotice_ID(0);
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
		if (M_Locator != null) {
			// Since an entity was passed, make sure it's in the DB
			MLocator foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_Locator", "M_Locator_UU=?", get_TrxName())
							.setParameters(M_Locator.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setM_Locator_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Locator with UU " + M_Locator.getUU());
			}
		} else {
			this.setM_Locator_ID(0);
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
		if (!is_new()) {
			return;
		}
		if (M_Product != null) {
			// Since an entity was passed, make sure it's in the DB
			MProduct_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_Product", "M_Product_UU=?", get_TrxName())
							.setParameters(M_Product.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setM_Product_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Product with UU " + M_Product.getUU());
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
		if (M_Warehouse != null) {
			// Since an entity was passed, make sure it's in the DB
			MWarehouse_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_Warehouse", "M_Warehouse_UU=?", get_TrxName())
							.setParameters(M_Warehouse.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setM_Warehouse_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Warehouse with UU " + M_Warehouse.getUU());
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
	 * Set Manufacturing Order BOM.
	 *
	 * @param PP_Order_BOM Manufacturing Order BOM
	 */
	@JsonProperty("PP_Order_BOM")
	public void setPP_Order_BOMInput(ForeignEntityInput PP_Order_BOM) {
		this.mPP_Order_BOM = PP_Order_BOM;
		if (!is_new()) {
			return;
		}
		if (PP_Order_BOM != null) {
			// Since an entity was passed, make sure it's in the DB
			X_PP_Order_BOM foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "PP_Order_BOM", "PP_Order_BOM_UU=?", get_TrxName())
							.setParameters(PP_Order_BOM.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setPP_Order_BOM_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table PP_Order_BOM with UU " + PP_Order_BOM.getUU());
			}
		} else {
			this.setPP_Order_BOM_ID(0);
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
	@JsonProperty("PP_Order_BOMLine_ID")
	public void setPP_Order_BOMLine_IDFromJson(int PP_Order_BOMLine_ID) {
		if (get_ID() == 0) {
			super.setPP_Order_BOMLine_ID(PP_Order_BOMLine_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setPP_Order_BOMLine_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
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
		if (!is_new()) {
			return;
		}
		if (PP_Order != null) {
			// Since an entity was passed, make sure it's in the DB
			X_PP_Order foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "PP_Order", "PP_Order_UU=?", get_TrxName())
							.setParameters(PP_Order.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setPP_Order_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table PP_Order with UU " + PP_Order.getUU());
			}
		} else {
			this.setPP_Order_ID(0);
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
	@JsonProperty("QtyBatch")
	public void setQtyBatchFromJson(BigDecimal QtyBatch) {
		if (get_ID() == 0) {
			super.setQtyBatch(QtyBatch);
		}
	}
	/**
	 * Set Quantity.
	 *
	 * @param QtyBOM Indicate the Quantity use in this BOM
	 */
	@JsonProperty("QtyBOM")
	public void setQtyBOMFromJson(BigDecimal QtyBOM) {
		if (get_ID() == 0) {
			super.setQtyBOM(QtyBOM);
		}
	}
	/**
	 * Set Delivered Quantity.
	 *
	 * @param QtyDelivered Delivered Quantity
	 */
	@JsonProperty("QtyDelivered")
	public void setQtyDeliveredFromJson(BigDecimal QtyDelivered) {
		if (get_ID() == 0) {
			super.setQtyDelivered(QtyDelivered);
		}
	}
	/**
	 * Set Quantity.
	 *
	 * @param QtyEntered The Quantity Entered is based on the selected UoM
	 */
	@JsonProperty("QtyEntered")
	public void setQtyEnteredFromJson(BigDecimal QtyEntered) {
		if (get_ID() == 0) {
			super.setQtyEntered(QtyEntered);
		}
	}
	/**
	 * Set Qty Post.
	 *
	 * @param QtyPost Qty Post
	 */
	@JsonProperty("QtyPost")
	public void setQtyPostFromJson(BigDecimal QtyPost) {
		if (get_ID() == 0) {
			super.setQtyPost(QtyPost);
		}
	}
	/**
	 * Set Qty Reject.
	 *
	 * @param QtyReject Qty Reject
	 */
	@JsonProperty("QtyReject")
	public void setQtyRejectFromJson(BigDecimal QtyReject) {
		if (get_ID() == 0) {
			super.setQtyReject(QtyReject);
		}
	}
	/**
	 * Set Reserved Quantity.
	 *
	 * @param QtyReserved Reserved Quantity
	 */
	@JsonProperty("QtyReserved")
	public void setQtyReservedFromJson(BigDecimal QtyReserved) {
		if (get_ID() == 0) {
			super.setQtyReserved(QtyReserved);
		}
	}
	/**
	 * Set Scrap %.
	 *
	 * @param QtyScrap Scrap % Quantity for this component
	 */
	@JsonProperty("QtyScrap")
	public void setQtyScrapFromJson(BigDecimal QtyScrap) {
		if (get_ID() == 0) {
			super.setQtyScrap(QtyScrap);
		}
	}
	/**
	 * Set Scrap %.
	 *
	 * @param Scrap Indicate the Scrap %  for calculate the Scrap Quantity
	 */
	@JsonProperty("Scrap")
	public void setScrapFromJson(BigDecimal Scrap) {
		if (get_ID() == 0) {
			super.setScrap(Scrap);
		}
	}
}
