package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MAsset;
import org.compiere.model.MAssetClass;
import org.compiere.model.MAssetGroup;
import org.compiere.model.MAssetType;
import org.compiere.model.MCity;
import org.compiere.model.MCurrency;
import org.compiere.model.MIFixedAsset;
import org.compiere.model.MLocator;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
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

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput DocAction_RL;
	 private I_A_AssetInput A_Asset;
	 private I_A_Asset_ClassInput A_Asset_Class;
	 private I_A_Asset_GroupInput A_Asset_Group;
	 private I_A_Asset_TypeInput A_Asset_Type;
	 private I_C_AcctSchemaInput C_AcctSchema;
	 private I_C_BPartnerInput C_BPartnerSR;
	 private I_C_CityInput C_City;
	 private I_C_CurrencyInput C_Currency;
	 private I_C_UOMInput C_UOM;
	 private I_M_LocatorInput M_Locator;
	 private I_M_ProductInput M_Product;

	/**
	 * Standard constructor
	 */
	public X_I_FixedAssetInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Asset class.
	 *
	 * @param A_Asset_Class Asset class
	 */
	public void setA_Asset_Class(I_A_Asset_ClassInput A_Asset_Class) {
		this.A_Asset_Class = A_Asset_Class;
		MAssetClass foreignEntity;
		if (A_Asset_Class != null &&
				(foreignEntity = new Query(getCtx(), MAssetClass.Table_Name, MAssetClass.COLUMNNAME_A_Asset_Class_UU + "=?", get_TrxName())
						.setParameters(A_Asset_Class.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Asset_Class_ID(foreignEntity.get_ID());
		} else {
			this.setA_Asset_Class_ID(0);
		}
	}

	/**
	 * Get Asset class.
	 *
	 * @return Asset class
	 */
	public I_A_Asset_ClassInput getA_Asset_Class() {
		return A_Asset_Class;
	}

	/**
	 * Set Asset Group.
	 *
	 * @param A_Asset_Group Group of Assets
	 */
	public void setA_Asset_Group(I_A_Asset_GroupInput A_Asset_Group) {
		this.A_Asset_Group = A_Asset_Group;
		MAssetGroup foreignEntity;
		if (A_Asset_Group != null &&
				(foreignEntity = new Query(getCtx(), MAssetGroup.Table_Name, MAssetGroup.COLUMNNAME_A_Asset_Group_UU + "=?", get_TrxName())
						.setParameters(A_Asset_Group.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Asset_Group_ID(foreignEntity.get_ID());
		} else {
			this.setA_Asset_Group_ID(0);
		}
	}

	/**
	 * Get Asset Group.
	 *
	 * @return Group of Assets
	 */
	public I_A_Asset_GroupInput getA_Asset_Group() {
		return A_Asset_Group;
	}

	/**
	 * Set Asset.
	 *
	 * @param A_Asset Asset used internally or by customers
	 */
	public void setA_Asset(I_A_AssetInput A_Asset) {
		this.A_Asset = A_Asset;
		MAsset foreignEntity;
		if (A_Asset != null &&
				(foreignEntity = new Query(getCtx(), MAsset.Table_Name, MAsset.COLUMNNAME_A_Asset_UU + "=?", get_TrxName())
						.setParameters(A_Asset.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Asset_ID(foreignEntity.get_ID());
		} else {
			this.setA_Asset_ID(0);
		}
	}

	/**
	 * Get Asset.
	 *
	 * @return Asset used internally or by customers
	 */
	public I_A_AssetInput getA_Asset() {
		return A_Asset;
	}

	/**
	 * Set Asset Type.
	 *
	 * @param A_Asset_Type Asset Type
	 */
	public void setA_Asset_Type(I_A_Asset_TypeInput A_Asset_Type) {
		this.A_Asset_Type = A_Asset_Type;
		MAssetType foreignEntity;
		if (A_Asset_Type != null &&
				(foreignEntity = new Query(getCtx(), MAssetType.Table_Name, MAssetType.COLUMNNAME_A_Asset_Type_UU + "=?", get_TrxName())
						.setParameters(A_Asset_Type.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Asset_Type_ID(foreignEntity.get_ID());
		} else {
			this.setA_Asset_Type_ID(0);
		}
	}

	/**
	 * Get Asset Type.
	 *
	 * @return Asset Type
	 */
	public I_A_Asset_TypeInput getA_Asset_Type() {
		return A_Asset_Type;
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
	 * Set Accounting Schema.
	 *
	 * @param C_AcctSchema Rules for accounting
	 */
	public void setC_AcctSchema(I_C_AcctSchemaInput C_AcctSchema) {
		this.C_AcctSchema = C_AcctSchema;
		MAcctSchema foreignEntity;
		if (C_AcctSchema != null &&
				(foreignEntity = new Query(getCtx(), MAcctSchema.Table_Name, MAcctSchema.COLUMNNAME_C_AcctSchema_UU + "=?", get_TrxName())
						.setParameters(C_AcctSchema.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_AcctSchema_ID(foreignEntity.get_ID());
		} else {
			this.setC_AcctSchema_ID(0);
		}
	}

	/**
	 * Get Accounting Schema.
	 *
	 * @return Rules for accounting
	 */
	public I_C_AcctSchemaInput getC_AcctSchema() {
		return C_AcctSchema;
	}

	/**
	 * Set BPartner (Agent).
	 *
	 * @param C_BPartnerSR Business Partner (Agent or Sales Rep)
	 */
	public void setC_BPartnerSR(I_C_BPartnerInput C_BPartnerSR) {
		this.C_BPartnerSR = C_BPartnerSR;
		MBPartner_BH foreignEntity;
		if (C_BPartnerSR != null &&
				(foreignEntity = new Query(getCtx(), MBPartner_BH.Table_Name, MBPartner_BH.COLUMNNAME_C_BPartner_UU + "=?", get_TrxName())
						.setParameters(C_BPartnerSR.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_BPartnerSR_ID(foreignEntity.get_ID());
		} else {
			this.setC_BPartnerSR_ID(0);
		}
	}

	/**
	 * Get BPartner (Agent).
	 *
	 * @return Business Partner (Agent or Sales Rep)
	 */
	public I_C_BPartnerInput getC_BPartnerSR() {
		return C_BPartnerSR;
	}

	/**
	 * Set City.
	 *
	 * @param C_City City
	 */
	public void setC_City(I_C_CityInput C_City) {
		this.C_City = C_City;
		MCity foreignEntity;
		if (C_City != null &&
				(foreignEntity = new Query(getCtx(), MCity.Table_Name, MCity.COLUMNNAME_C_City_UU + "=?", get_TrxName())
						.setParameters(C_City.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_City_ID(foreignEntity.get_ID());
		} else {
			this.setC_City_ID(0);
		}
	}

	/**
	 * Get City.
	 *
	 * @return City
	 */
	public I_C_CityInput getC_City() {
		return C_City;
	}

	/**
	 * Set Currency.
	 *
	 * @param C_Currency The Currency for this record
	 */
	public void setC_Currency(I_C_CurrencyInput C_Currency) {
		this.C_Currency = C_Currency;
		MCurrency foreignEntity;
		if (C_Currency != null &&
				(foreignEntity = new Query(getCtx(), MCurrency.Table_Name, MCurrency.COLUMNNAME_C_Currency_UU + "=?", get_TrxName())
						.setParameters(C_Currency.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Currency_ID(foreignEntity.get_ID());
		} else {
			this.setC_Currency_ID(0);
		}
	}

	/**
	 * Get Currency.
	 *
	 * @return The Currency for this record
	 */
	public I_C_CurrencyInput getC_Currency() {
		return C_Currency;
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
	 * Set Document Action.
	 *
	 * @param DocAction_RL The targeted status of the document
	 */
	public void setDocAction_RL(I_AD_Ref_ListInput DocAction_RL) {
		this.DocAction_RL = DocAction_RL;
		MRefList foreignEntity;
		if (DocAction_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(DocAction_RL.getID())
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
	public I_AD_Ref_ListInput getDocAction_RL() {
		return DocAction_RL;
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
}
