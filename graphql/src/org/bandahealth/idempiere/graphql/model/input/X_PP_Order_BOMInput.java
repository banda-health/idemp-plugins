package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MChangeNotice;
import org.compiere.model.MOrg;
import org.compiere.model.MUOM;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.eevolution.model.X_PP_Order;
import org.eevolution.model.X_PP_Order_BOM;

import java.sql.ResultSet;

/**
 * Generated Model for PP_Order_BOM - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PP_Order_BOMInput extends X_PP_Order_BOM implements I_PP_Order_BOMInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_UOM;
	private ForeignEntityInput mM_AttributeSetInstance;
	private ForeignEntityInput mM_ChangeNotice;
	private ForeignEntityInput mM_Product;
	private ForeignEntityInput mPP_Order;
	private I_AD_Ref_ListInput mBOMType;
	private I_AD_Ref_ListInput mBOMUse;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The PP_Order_BOM_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_PP_Order_BOMInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UUID), null);
		setUUID(UUID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		if (AD_Org != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
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
	 * @return Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set BOM Type.
	 *
	 * @param BOMType Type of BOM
	 */
	@JsonProperty("BOMType")
	public void setBOMTypeInput(I_AD_Ref_ListInput BOMType) {
		this.mBOMType = BOMType;
		if (BOMType != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(BOMType.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setBOMType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + BOMType.getUUID());
			}
		} else {
			this.setBOMType(null);
		}
	}

	/**
	 * Get BOM Type.
	 *
	 * @return Type of BOM
	 */
	@JsonProperty("BOMType")
	public I_AD_Ref_ListInput BOMType() {
		return mBOMType;
	}

	/**
	 * Set BOM Use.
	 *
	 * @param BOMUse The use of the Bill of Material
	 */
	@JsonProperty("BOMUse")
	public void setBOMUseInput(I_AD_Ref_ListInput BOMUse) {
		this.mBOMUse = BOMUse;
		if (BOMUse != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(BOMUse.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setBOMUse(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + BOMUse.getUUID());
			}
		} else {
			this.setBOMUse(null);
		}
	}

	/**
	 * Get BOM Use.
	 *
	 * @return The use of the Bill of Material
	 */
	@JsonProperty("BOMUse")
	public I_AD_Ref_ListInput BOMUse() {
		return mBOMUse;
	}

	/**
	 * Set UOM.
	 *
	 * @param C_UOM Unit of Measure
	 */
	@JsonProperty("C_UOM")
	public void setC_UOMInput(ForeignEntityInput C_UOM) {
		this.mC_UOM = C_UOM;
		if (C_UOM != null) {
			// Since an entity was passed, make sure it's in the DB
			MUOM foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_UOM", "C_UOM_UU=?", get_TrxName())
							.setParameters(C_UOM.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
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
	 * Set Attribute Set Instance.
	 *
	 * @param M_AttributeSetInstance Product Attribute Set Instance
	 */
	@JsonProperty("M_AttributeSetInstance")
	public void setM_AttributeSetInstanceInput(ForeignEntityInput M_AttributeSetInstance) {
		this.mM_AttributeSetInstance = M_AttributeSetInstance;
		if (M_AttributeSetInstance != null) {
			// Since an entity was passed, make sure it's in the DB
			MAttributeSetInstance_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_AttributeSetInstance", "M_AttributeSetInstance_UU=?", get_TrxName())
							.setParameters(M_AttributeSetInstance.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
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
							.setParameters(M_ChangeNotice.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setM_ChangeNotice_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_ChangeNotice with UUID " + M_ChangeNotice.getUUID());
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
	 * Set Product/Service.
	 *
	 * @param M_Product Product, Service, Item
	 */
	@JsonProperty("M_Product")
	public void setM_ProductInput(ForeignEntityInput M_Product) {
		this.mM_Product = M_Product;
		if (M_Product != null) {
			// Since an entity was passed, make sure it's in the DB
			MProduct_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_Product", "M_Product_UU=?", get_TrxName())
							.setParameters(M_Product.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setPP_Order_BOM_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getPP_Order_BOM_UU();
	}

	/**
	 * Set Manufacturing Order.
	 *
	 * @param PP_Order Manufacturing Order
	 */
	@JsonProperty("PP_Order")
	public void setPP_OrderInput(ForeignEntityInput PP_Order) {
		this.mPP_Order = PP_Order;
		if (get_ID() != 0) {
			return;
		}
		if (PP_Order != null) {
			// Since an entity was passed, make sure it's in the DB
			X_PP_Order foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "PP_Order", "PP_Order_UU=?", get_TrxName())
							.setParameters(PP_Order.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setPP_Order_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table PP_Order with UUID " + PP_Order.getUUID());
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
}
