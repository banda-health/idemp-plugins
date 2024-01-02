package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MAsset;
import org.compiere.model.MAssetClass;
import org.compiere.model.MAssetGroup;
import org.compiere.model.MAssetType;
import org.compiere.model.MCity;
import org.compiere.model.MIFixedAsset;
import org.compiere.model.MLocator;
import org.compiere.model.MOrg;
import org.compiere.model.MUOM;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Generated Model for I_FixedAsset - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_I_FixedAssetInput extends MIFixedAsset implements I_I_FixedAssetInput {

	 private I_AD_OrgInput mAD_Org;
	 private I_AD_Ref_ListInput mDocAction;
	 private I_A_AssetInput mA_Asset;
	 private I_A_Asset_ClassInput mA_Asset_Class;
	 private I_A_Asset_GroupInput mA_Asset_Group;
	 private I_A_Asset_TypeInput mA_Asset_Type;
	 private I_C_AcctSchemaInput mC_AcctSchema;
	 private I_C_BPartnerInput mC_BPartnerSR;
	 private I_C_CityInput mC_City;
	 private I_C_CurrencyInput mC_Currency;
	 private I_C_UOMInput mC_UOM;
	 private I_M_LocatorInput mM_Locator;
	 private I_M_ProductInput mM_Product;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_I_FixedAssetInput(@JsonProperty("ID") String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Asset class.
	 *
	 * @param A_Asset_Class Asset class
	 */
	@JsonProperty("A_Asset_Class")
	public void setA_Asset_ClassInput(I_A_Asset_ClassInput A_Asset_Class) {
		this.mA_Asset_Class = A_Asset_Class;
		MAssetClass foreignEntity;
		if (A_Asset_Class != null &&
				(foreignEntity = new Query(getCtx(), MAssetClass.Table_Name, MAssetClass.COLUMNNAME_A_Asset_Class_UU + "=?", get_TrxName())
						.setParameters(A_Asset_Class.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setA_Asset_Class_ID(foreignEntity.get_ID());
		} else {
			super.setA_Asset_Class_ID(0);
		}
	}

	/**
	 * Get Asset class.
	 *
	 * @return Asset class
	 */
	@JsonProperty("A_Asset_Class")
	public I_A_Asset_ClassInput A_Asset_Class() {
		return mA_Asset_Class;
	}

	/**
	 * Set Asset Group.
	 *
	 * @param A_Asset_Group Group of Assets
	 */
	@JsonProperty("A_Asset_Group")
	public void setA_Asset_GroupInput(I_A_Asset_GroupInput A_Asset_Group) {
		this.mA_Asset_Group = A_Asset_Group;
		MAssetGroup foreignEntity;
		if (A_Asset_Group != null &&
				(foreignEntity = new Query(getCtx(), MAssetGroup.Table_Name, MAssetGroup.COLUMNNAME_A_Asset_Group_UU + "=?", get_TrxName())
						.setParameters(A_Asset_Group.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setA_Asset_Group_ID(foreignEntity.get_ID());
		} else {
			super.setA_Asset_Group_ID(0);
		}
	}

	/**
	 * Get Asset Group.
	 *
	 * @return Group of Assets
	 */
	@JsonProperty("A_Asset_Group")
	public I_A_Asset_GroupInput A_Asset_Group() {
		return mA_Asset_Group;
	}

	/**
	 * Set Asset.
	 *
	 * @param A_Asset Asset used internally or by customers
	 */
	@JsonProperty("A_Asset")
	public void setA_AssetInput(I_A_AssetInput A_Asset) {
		this.mA_Asset = A_Asset;
		MAsset foreignEntity;
		if (A_Asset != null &&
				(foreignEntity = new Query(getCtx(), MAsset.Table_Name, MAsset.COLUMNNAME_A_Asset_UU + "=?", get_TrxName())
						.setParameters(A_Asset.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setA_Asset_ID(foreignEntity.get_ID());
		} else {
			super.setA_Asset_ID(0);
		}
	}

	/**
	 * Get Asset.
	 *
	 * @return Asset used internally or by customers
	 */
	@JsonProperty("A_Asset")
	public I_A_AssetInput A_Asset() {
		return mA_Asset;
	}

	/**
	 * Set Asset Type.
	 *
	 * @param A_Asset_Type Asset Type
	 */
	@JsonProperty("A_Asset_Type")
	public void setA_Asset_TypeInput(I_A_Asset_TypeInput A_Asset_Type) {
		this.mA_Asset_Type = A_Asset_Type;
		MAssetType foreignEntity;
		if (A_Asset_Type != null &&
				(foreignEntity = new Query(getCtx(), MAssetType.Table_Name, MAssetType.COLUMNNAME_A_Asset_Type_UU + "=?", get_TrxName())
						.setParameters(A_Asset_Type.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setA_Asset_Type_ID(foreignEntity.get_ID());
		} else {
			super.setA_Asset_Type_ID(0);
		}
	}

	/**
	 * Get Asset Type.
	 *
	 * @return Asset Type
	 */
	@JsonProperty("A_Asset_Type")
	public I_A_Asset_TypeInput A_Asset_Type() {
		return mA_Asset_Type;
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(I_AD_OrgInput AD_Org) {
		this.mAD_Org = AD_Org;
		MOrg foreignEntity;
		if (AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Org_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Org_ID(0);
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public I_AD_OrgInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set Accounting Schema.
	 *
	 * @param C_AcctSchema Rules for accounting
	 */
	@JsonProperty("C_AcctSchema")
	public void setC_AcctSchemaInput(I_C_AcctSchemaInput C_AcctSchema) {
		this.mC_AcctSchema = C_AcctSchema;
		MAcctSchema foreignEntity;
		if (C_AcctSchema != null &&
				(foreignEntity = new Query(getCtx(), MAcctSchema.Table_Name, MAcctSchema.COLUMNNAME_C_AcctSchema_UU + "=?", get_TrxName())
						.setParameters(C_AcctSchema.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_AcctSchema_ID(foreignEntity.get_ID());
		} else {
			super.setC_AcctSchema_ID(0);
		}
	}

	/**
	 * Get Accounting Schema.
	 *
	 * @return Rules for accounting
	 */
	@JsonProperty("C_AcctSchema")
	public I_C_AcctSchemaInput C_AcctSchema() {
		return mC_AcctSchema;
	}

	/**
	 * Set BPartner (Agent).
	 *
	 * @param C_BPartnerSR Business Partner (Agent or Sales Rep)
	 */
	@JsonProperty("C_BPartnerSR")
	public void setC_BPartnerSRInput(I_C_BPartnerInput C_BPartnerSR) {
		this.mC_BPartnerSR = C_BPartnerSR;
		MBPartner_BH foreignEntity;
		if (C_BPartnerSR != null &&
				(foreignEntity = new Query(getCtx(), MBPartner_BH.Table_Name, MBPartner_BH.COLUMNNAME_C_BPartner_UU + "=?", get_TrxName())
						.setParameters(C_BPartnerSR.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_BPartnerSR_ID(foreignEntity.get_ID());
		} else {
			super.setC_BPartnerSR_ID(0);
		}
	}

	/**
	 * Get BPartner (Agent).
	 *
	 * @return Business Partner (Agent or Sales Rep)
	 */
	@JsonProperty("C_BPartnerSR")
	public I_C_BPartnerInput C_BPartnerSR() {
		return mC_BPartnerSR;
	}

	/**
	 * Set City.
	 *
	 * @param C_City City
	 */
	@JsonProperty("C_City")
	public void setC_CityInput(I_C_CityInput C_City) {
		this.mC_City = C_City;
		MCity foreignEntity;
		if (C_City != null &&
				(foreignEntity = new Query(getCtx(), MCity.Table_Name, MCity.COLUMNNAME_C_City_UU + "=?", get_TrxName())
						.setParameters(C_City.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_City_ID(foreignEntity.get_ID());
		} else {
			super.setC_City_ID(0);
		}
	}

	/**
	 * Get City.
	 *
	 * @return City
	 */
	@JsonProperty("C_City")
	public I_C_CityInput C_City() {
		return mC_City;
	}

	/**
	 * Set Currency.
	 *
	 * @param C_Currency The Currency for this record
	 */
	@JsonProperty("C_Currency")
	public void setC_CurrencyInput(I_C_CurrencyInput C_Currency) {
		this.mC_Currency = C_Currency;
		MCurrency_BH foreignEntity;
		if (C_Currency != null &&
				(foreignEntity = new Query(getCtx(), MCurrency_BH.Table_Name, MCurrency_BH.COLUMNNAME_C_Currency_UU + "=?", get_TrxName())
						.setParameters(C_Currency.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Currency_ID(foreignEntity.get_ID());
		} else {
			super.setC_Currency_ID(0);
		}
	}

	/**
	 * Get Currency.
	 *
	 * @return The Currency for this record
	 */
	@JsonProperty("C_Currency")
	public I_C_CurrencyInput C_Currency() {
		return mC_Currency;
	}

	/**
	 * Set UOM.
	 *
	 * @param C_UOM Unit of Measure
	 */
	@JsonProperty("C_UOM")
	public void setC_UOMInput(I_C_UOMInput C_UOM) {
		this.mC_UOM = C_UOM;
		MUOM foreignEntity;
		if (C_UOM != null &&
				(foreignEntity = new Query(getCtx(), MUOM.Table_Name, MUOM.COLUMNNAME_C_UOM_UU + "=?", get_TrxName())
						.setParameters(C_UOM.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_UOM_ID(foreignEntity.get_ID());
		} else {
			super.setC_UOM_ID(0);
		}
	}

	/**
	 * Get UOM.
	 *
	 * @return Unit of Measure
	 */
	@JsonProperty("C_UOM")
	public I_C_UOMInput C_UOM() {
		return mC_UOM;
	}

	/**
	 * Set Document Action.
	 *
	 * @param DocAction The targeted status of the document
	 */
	@JsonProperty("DocAction")
	public void setDocActionInput(I_AD_Ref_ListInput DocAction) {
		this.mDocAction = DocAction;
		MRefList_BH foreignEntity;
		if (DocAction != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(DocAction.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setDocAction(foreignEntity.getValue());
		} else {
			this.setDocAction(null);
		}
	}

	/**
	 * Get Document Action.
	 *
	 * @return The targeted status of the document
	 */
	@JsonProperty("DocAction")
	public I_AD_Ref_ListInput DocAction() {
		return mDocAction;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setI_FixedAsset_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getI_FixedAsset_UU();
	}

	/**
	 * Set Locator.
	 *
	 * @param M_Locator Warehouse Locator
	 */
	@JsonProperty("M_Locator")
	public void setM_LocatorInput(I_M_LocatorInput M_Locator) {
		this.mM_Locator = M_Locator;
		MLocator foreignEntity;
		if (M_Locator != null &&
				(foreignEntity = new Query(getCtx(), MLocator.Table_Name, MLocator.COLUMNNAME_M_Locator_UU + "=?", get_TrxName())
						.setParameters(M_Locator.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_Locator_ID(foreignEntity.get_ID());
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
	public I_M_LocatorInput M_Locator() {
		return mM_Locator;
	}

	/**
	 * Set Product/Service.
	 *
	 * @param M_Product Product, Service, Item
	 */
	@JsonProperty("M_Product")
	public void setM_ProductInput(I_M_ProductInput M_Product) {
		this.mM_Product = M_Product;
		MProduct_BH foreignEntity;
		if (M_Product != null &&
				(foreignEntity = new Query(getCtx(), MProduct_BH.Table_Name, MProduct_BH.COLUMNNAME_M_Product_UU + "=?", get_TrxName())
						.setParameters(M_Product.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_Product_ID(foreignEntity.get_ID());
		} else {
			super.setM_Product_ID(0);
		}
	}

	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	@JsonProperty("M_Product")
	public I_M_ProductInput M_Product() {
		return mM_Product;
	}
}
