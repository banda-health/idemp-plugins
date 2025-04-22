package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBPGroup_BH;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MProductCategory_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MTax;
import org.compiere.model.MTaxCategory;
import org.compiere.model.Query;
import org.compiere.model.X_AD_OrgType;
import org.compiere.util.Env;
import org.eevolution.model.X_C_TaxBase;
import org.eevolution.model.X_C_TaxDefinition;
import org.eevolution.model.X_C_TaxGroup;
import org.eevolution.model.X_C_TaxType;

import java.sql.ResultSet;

/**
 * Generated Model for C_TaxDefinition - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_TaxDefinitionInput extends X_C_TaxDefinition implements I_C_TaxDefinitionInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_OrgType;
	private ForeignEntityInput mC_BP_Group;
	private ForeignEntityInput mC_BPartner;
	private ForeignEntityInput mC_Tax;
	private ForeignEntityInput mC_TaxBase;
	private ForeignEntityInput mC_TaxCategory;
	private ForeignEntityInput mC_TaxGroup;
	private ForeignEntityInput mC_TaxType;
	private ForeignEntityInput mM_Product;
	private ForeignEntityInput mM_Product_Category;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The C_TaxDefinition_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_TaxDefinitionInput(@JsonProperty("UU") String UU) {
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
		if (get_ID() != 0) {
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
	 * Set Organization Type.
	 *
	 * @param AD_OrgType Organization Type
	 */
	@JsonProperty("AD_OrgType")
	public void setAD_OrgTypeInput(ForeignEntityInput AD_OrgType) {
		this.mAD_OrgType = AD_OrgType;
		if (AD_OrgType != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_OrgType foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_OrgType", "AD_OrgType_UU=?", get_TrxName())
							.setParameters(AD_OrgType.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_OrgType_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_OrgType with UU " + AD_OrgType.getUU());
			}
		} else {
			this.setAD_OrgType_ID(0);
		}
	}

	/**
	 * Get Organization Type.
	 *
	 * @return Organization Type
	 */
	@JsonProperty("AD_OrgType")
	public ForeignEntityInput AD_OrgType() {
		return mAD_OrgType;
	}

	/**
	 * Set Business Partner Group.
	 *
	 * @param C_BP_Group Business Partner Group
	 */
	@JsonProperty("C_BP_Group")
	public void setC_BP_GroupInput(ForeignEntityInput C_BP_Group) {
		this.mC_BP_Group = C_BP_Group;
		if (C_BP_Group != null) {
			// Since an entity was passed, make sure it's in the DB
			MBPGroup_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_BP_Group", "C_BP_Group_UU=?", get_TrxName())
							.setParameters(C_BP_Group.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_BP_Group_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BP_Group with UU " + C_BP_Group.getUU());
			}
		} else {
			this.setC_BP_Group_ID(0);
		}
	}

	/**
	 * Get Business Partner Group.
	 *
	 * @return Business Partner Group
	 */
	@JsonProperty("C_BP_Group")
	public ForeignEntityInput C_BP_Group() {
		return mC_BP_Group;
	}

	/**
	 * Set Business Partner.
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public void setC_BPartnerInput(ForeignEntityInput C_BPartner) {
		this.mC_BPartner = C_BPartner;
		if (C_BPartner != null) {
			// Since an entity was passed, make sure it's in the DB
			MBPartner_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_BPartner", "C_BPartner_UU=?", get_TrxName())
							.setParameters(C_BPartner.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_BPartner_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BPartner with UU " + C_BPartner.getUU());
			}
		} else {
			this.setC_BPartner_ID(0);
		}
	}

	/**
	 * Get Business Partner.
	 *
	 * @return Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public ForeignEntityInput C_BPartner() {
		return mC_BPartner;
	}

	/**
	 * Set Tax.
	 *
	 * @param C_Tax Tax identifier
	 */
	@JsonProperty("C_Tax")
	public void setC_TaxInput(ForeignEntityInput C_Tax) {
		this.mC_Tax = C_Tax;
		if (C_Tax != null) {
			// Since an entity was passed, make sure it's in the DB
			MTax foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Tax", "C_Tax_UU=?", get_TrxName())
							.setParameters(C_Tax.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_Tax_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Tax with UU " + C_Tax.getUU());
			}
		} else {
			this.setC_Tax_ID(0);
		}
	}

	/**
	 * Get Tax.
	 *
	 * @return Tax identifier
	 */
	@JsonProperty("C_Tax")
	public ForeignEntityInput C_Tax() {
		return mC_Tax;
	}

	/**
	 * Set Tax Base.
	 *
	 * @param C_TaxBase Tax Base
	 */
	@JsonProperty("C_TaxBase")
	public void setC_TaxBaseInput(ForeignEntityInput C_TaxBase) {
		this.mC_TaxBase = C_TaxBase;
		if (C_TaxBase != null) {
			// Since an entity was passed, make sure it's in the DB
			X_C_TaxBase foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_TaxBase", "C_TaxBase_UU=?", get_TrxName())
							.setParameters(C_TaxBase.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_TaxBase_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_TaxBase with UU " + C_TaxBase.getUU());
			}
		} else {
			this.setC_TaxBase_ID(0);
		}
	}

	/**
	 * Get Tax Base.
	 *
	 * @return Tax Base
	 */
	@JsonProperty("C_TaxBase")
	public ForeignEntityInput C_TaxBase() {
		return mC_TaxBase;
	}

	/**
	 * Set Tax Category.
	 *
	 * @param C_TaxCategory Tax Category
	 */
	@JsonProperty("C_TaxCategory")
	public void setC_TaxCategoryInput(ForeignEntityInput C_TaxCategory) {
		this.mC_TaxCategory = C_TaxCategory;
		if (C_TaxCategory != null) {
			// Since an entity was passed, make sure it's in the DB
			MTaxCategory foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_TaxCategory", "C_TaxCategory_UU=?", get_TrxName())
							.setParameters(C_TaxCategory.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_TaxCategory_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_TaxCategory with UU " + C_TaxCategory.getUU());
			}
		} else {
			this.setC_TaxCategory_ID(0);
		}
	}

	/**
	 * Get Tax Category.
	 *
	 * @return Tax Category
	 */
	@JsonProperty("C_TaxCategory")
	public ForeignEntityInput C_TaxCategory() {
		return mC_TaxCategory;
	}
	/**
	 * Set Tax Definition.
	 *
	 * @param C_TaxDefinition_ID Tax Definition
	 */
	@JsonProperty("C_TaxDefinition_ID")
	public void setC_TaxDefinition_IDFromJson(int C_TaxDefinition_ID) {
		if (get_ID() == 0) {
			super.setC_TaxDefinition_ID(C_TaxDefinition_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setC_TaxDefinition_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getC_TaxDefinition_UU();
	}

	/**
	 * Set Tax Group.
	 *
	 * @param C_TaxGroup Tax Group
	 */
	@JsonProperty("C_TaxGroup")
	public void setC_TaxGroupInput(ForeignEntityInput C_TaxGroup) {
		this.mC_TaxGroup = C_TaxGroup;
		if (C_TaxGroup != null) {
			// Since an entity was passed, make sure it's in the DB
			X_C_TaxGroup foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_TaxGroup", "C_TaxGroup_UU=?", get_TrxName())
							.setParameters(C_TaxGroup.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_TaxGroup_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_TaxGroup with UU " + C_TaxGroup.getUU());
			}
		} else {
			this.setC_TaxGroup_ID(0);
		}
	}

	/**
	 * Get Tax Group.
	 *
	 * @return Tax Group
	 */
	@JsonProperty("C_TaxGroup")
	public ForeignEntityInput C_TaxGroup() {
		return mC_TaxGroup;
	}

	/**
	 * Set Tax Type.
	 *
	 * @param C_TaxType Tax Type
	 */
	@JsonProperty("C_TaxType")
	public void setC_TaxTypeInput(ForeignEntityInput C_TaxType) {
		this.mC_TaxType = C_TaxType;
		if (C_TaxType != null) {
			// Since an entity was passed, make sure it's in the DB
			X_C_TaxType foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_TaxType", "C_TaxType_UU=?", get_TrxName())
							.setParameters(C_TaxType.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_TaxType_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_TaxType with UU " + C_TaxType.getUU());
			}
		} else {
			this.setC_TaxType_ID(0);
		}
	}

	/**
	 * Get Tax Type.
	 *
	 * @return Tax Type
	 */
	@JsonProperty("C_TaxType")
	public ForeignEntityInput C_TaxType() {
		return mC_TaxType;
	}

	/**
	 * Set Product Category.
	 *
	 * @param M_Product_Category Category of a Product
	 */
	@JsonProperty("M_Product_Category")
	public void setM_Product_CategoryInput(ForeignEntityInput M_Product_Category) {
		this.mM_Product_Category = M_Product_Category;
		if (M_Product_Category != null) {
			// Since an entity was passed, make sure it's in the DB
			MProductCategory_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_Product_Category", "M_Product_Category_UU=?", get_TrxName())
							.setParameters(M_Product_Category.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setM_Product_Category_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Product_Category with UU " + M_Product_Category.getUU());
			}
		} else {
			this.setM_Product_Category_ID(0);
		}
	}

	/**
	 * Get Product Category.
	 *
	 * @return Category of a Product
	 */
	@JsonProperty("M_Product_Category")
	public ForeignEntityInput M_Product_Category() {
		return mM_Product_Category;
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
}
