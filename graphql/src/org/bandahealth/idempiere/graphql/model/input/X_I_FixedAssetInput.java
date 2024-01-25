package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
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

import java.sql.ResultSet;

/**
 * Generated Model for I_FixedAsset - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_I_FixedAssetInput extends MIFixedAsset implements I_I_FixedAssetInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mA_Asset;
	private ForeignEntityInput mA_Asset_Class;
	private ForeignEntityInput mA_Asset_Group;
	private ForeignEntityInput mA_Asset_Type;
	private ForeignEntityInput mC_AcctSchema;
	private ForeignEntityInput mC_BPartnerSR;
	private ForeignEntityInput mC_City;
	private ForeignEntityInput mC_Currency;
	private ForeignEntityInput mC_UOM;
	private ForeignEntityInput mM_Locator;
	private ForeignEntityInput mM_Product;
	private I_AD_Ref_ListInput mDocAction;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The I_FixedAsset_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_I_FixedAssetInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MIFixedAsset(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
		setUUID(UUID);
	}

	/**
	 * Set Asset class.
	 *
	 * @param A_Asset_Class Asset class
	 */
	@JsonProperty("A_Asset_Class")
	public void setA_Asset_ClassInput(ForeignEntityInput A_Asset_Class) {
		this.mA_Asset_Class = A_Asset_Class;
		if (A_Asset_Class != null) {
			// Since an entity was passed, make sure it's in the DB
			MAssetClass foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "A_Asset_Class", "A_Asset_Class_UU=?", get_TrxName())
							.setParameters(A_Asset_Class.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setA_Asset_Class_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table A_Asset_Class with UUID " + A_Asset_Class.getUUID());
			}
		} else {
			this.setA_Asset_Class_ID(0);
		}
	}

	/**
	 * Get Asset class.
	 *
	 * @return Asset class
	 */
	@JsonProperty("A_Asset_Class")
	public ForeignEntityInput A_Asset_Class() {
		return mA_Asset_Class;
	}

	/**
	 * Set Asset Group.
	 *
	 * @param A_Asset_Group Group of Assets
	 */
	@JsonProperty("A_Asset_Group")
	public void setA_Asset_GroupInput(ForeignEntityInput A_Asset_Group) {
		this.mA_Asset_Group = A_Asset_Group;
		if (A_Asset_Group != null) {
			// Since an entity was passed, make sure it's in the DB
			MAssetGroup foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "A_Asset_Group", "A_Asset_Group_UU=?", get_TrxName())
							.setParameters(A_Asset_Group.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setA_Asset_Group_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table A_Asset_Group with UUID " + A_Asset_Group.getUUID());
			}
		} else {
			this.setA_Asset_Group_ID(0);
		}
	}

	/**
	 * Get Asset Group.
	 *
	 * @return Group of Assets
	 */
	@JsonProperty("A_Asset_Group")
	public ForeignEntityInput A_Asset_Group() {
		return mA_Asset_Group;
	}

	/**
	 * Set Asset.
	 *
	 * @param A_Asset Asset used internally or by customers
	 */
	@JsonProperty("A_Asset")
	public void setA_AssetInput(ForeignEntityInput A_Asset) {
		this.mA_Asset = A_Asset;
		if (A_Asset != null) {
			// Since an entity was passed, make sure it's in the DB
			MAsset foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "A_Asset", "A_Asset_UU=?", get_TrxName())
							.setParameters(A_Asset.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setA_Asset_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table A_Asset with UUID " + A_Asset.getUUID());
			}
		} else {
			this.setA_Asset_ID(0);
		}
	}

	/**
	 * Get Asset.
	 *
	 * @return Asset used internally or by customers
	 */
	@JsonProperty("A_Asset")
	public ForeignEntityInput A_Asset() {
		return mA_Asset;
	}

	/**
	 * Set Asset Type.
	 *
	 * @param A_Asset_Type Asset Type
	 */
	@JsonProperty("A_Asset_Type")
	public void setA_Asset_TypeInput(ForeignEntityInput A_Asset_Type) {
		this.mA_Asset_Type = A_Asset_Type;
		if (A_Asset_Type != null) {
			// Since an entity was passed, make sure it's in the DB
			MAssetType foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "A_Asset_Type", "A_Asset_Type_UU=?", get_TrxName())
							.setParameters(A_Asset_Type.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setA_Asset_Type_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table A_Asset_Type with UUID " + A_Asset_Type.getUUID());
			}
		} else {
			this.setA_Asset_Type_ID(0);
		}
	}

	/**
	 * Get Asset Type.
	 *
	 * @return Asset Type
	 */
	@JsonProperty("A_Asset_Type")
	public ForeignEntityInput A_Asset_Type() {
		return mA_Asset_Type;
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
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
	 * Set BPartner (Agent).
	 *
	 * @param C_BPartnerSR Business Partner (Agent or Sales Rep)
	 */
	@JsonProperty("C_BPartnerSR")
	public void setC_BPartnerSRInput(ForeignEntityInput C_BPartnerSR) {
		this.mC_BPartnerSR = C_BPartnerSR;
		if (C_BPartnerSR != null) {
			// Since an entity was passed, make sure it's in the DB
			MBPartner_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_BPartner", "C_BPartner_UU=?", get_TrxName())
							.setParameters(C_BPartnerSR.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_BPartnerSR_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BPartner with UUID " + C_BPartnerSR.getUUID());
			}
		} else {
			this.setC_BPartnerSR_ID(0);
		}
	}

	/**
	 * Get BPartner (Agent).
	 *
	 * @return Business Partner (Agent or Sales Rep)
	 */
	@JsonProperty("C_BPartnerSR")
	public ForeignEntityInput C_BPartnerSR() {
		return mC_BPartnerSR;
	}

	/**
	 * Set City.
	 *
	 * @param C_City City
	 */
	@JsonProperty("C_City")
	public void setC_CityInput(ForeignEntityInput C_City) {
		this.mC_City = C_City;
		if (C_City != null) {
			// Since an entity was passed, make sure it's in the DB
			MCity foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_City", "C_City_UU=?", get_TrxName())
							.setParameters(C_City.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_City_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_City with UUID " + C_City.getUUID());
			}
		} else {
			this.setC_City_ID(0);
		}
	}

	/**
	 * Get City.
	 *
	 * @return City
	 */
	@JsonProperty("C_City")
	public ForeignEntityInput C_City() {
		return mC_City;
	}

	/**
	 * Set Currency.
	 *
	 * @param C_Currency The Currency for this record
	 */
	@JsonProperty("C_Currency")
	public void setC_CurrencyInput(ForeignEntityInput C_Currency) {
		this.mC_Currency = C_Currency;
		if (C_Currency != null) {
			// Since an entity was passed, make sure it's in the DB
			MCurrency_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Currency", "C_Currency_UU=?", get_TrxName())
							.setParameters(C_Currency.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Currency_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Currency with UUID " + C_Currency.getUUID());
			}
		} else {
			this.setC_Currency_ID(0);
		}
	}

	/**
	 * Get Currency.
	 *
	 * @return The Currency for this record
	 */
	@JsonProperty("C_Currency")
	public ForeignEntityInput C_Currency() {
		return mC_Currency;
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
	 * Set Document Action.
	 *
	 * @param DocAction The targeted status of the document
	 */
	@JsonProperty("DocAction")
	public void setDocActionInput(I_AD_Ref_ListInput DocAction) {
		this.mDocAction = DocAction;
		if (DocAction != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(DocAction.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setDocAction(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + DocAction.getUUID());
			}
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
	 * Set Imported Fixed Asset.
	 *
	 * @param I_FixedAsset_ID Imported Fixed Asset
	 */

	public void setI_FixedAsset_ID(int I_FixedAsset_ID) {
		if (get_ID() == 0) {
			super.setI_FixedAsset_ID(I_FixedAsset_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setI_FixedAsset_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getI_FixedAsset_UU();
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
							.setParameters(M_Locator.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_Locator_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Locator with UUID " + M_Locator.getUUID());
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
