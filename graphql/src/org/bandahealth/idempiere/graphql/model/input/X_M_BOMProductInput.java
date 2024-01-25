package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MBOM;
import org.compiere.model.MBOMProduct;
import org.compiere.model.MChangeNotice;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_M_BOMAlternative;
import org.compiere.model.X_M_ProductOperation;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for M_BOMProduct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_BOMProductInput extends MBOMProduct implements I_M_BOMProductInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mM_AttributeSetInstance;
	private ForeignEntityInput mM_BOM;
	private ForeignEntityInput mM_BOMAlternative;
	private ForeignEntityInput mM_ChangeNotice;
	private ForeignEntityInput mM_ProductBOM;
	private ForeignEntityInput mM_ProductOperation;
	private I_AD_Ref_ListInput mBOMProductType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The M_BOMProduct_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_M_BOMProductInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MBOMProduct(null, (ResultSet) null, null),
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
	 * Set Component Type.
	 *
	 * @param BOMProductType BOM Product Type
	 */
	@JsonProperty("BOMProductType")
	public void setBOMProductTypeInput(I_AD_Ref_ListInput BOMProductType) {
		this.mBOMProductType = BOMProductType;
		if (BOMProductType != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(BOMProductType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setBOMProductType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + BOMProductType.getUUID());
			}
		} else {
			this.setBOMProductType(null);
		}
	}

	/**
	 * Get Component Type.
	 *
	 * @return BOM Product Type
	 */
	@JsonProperty("BOMProductType")
	public I_AD_Ref_ListInput BOMProductType() {
		return mBOMProductType;
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
							.setParameters(M_AttributeSetInstance.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
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
	 * Set BOM.
	 *
	 * @param M_BOM Bill of Material
	 */
	@JsonProperty("M_BOM")
	public void setM_BOMInput(ForeignEntityInput M_BOM) {
		this.mM_BOM = M_BOM;
		if (get_ID() != 0) {
			return;
		}
		if (M_BOM != null) {
			// Since an entity was passed, make sure it's in the DB
			MBOM foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_BOM", "M_BOM_UU=?", get_TrxName())
							.setParameters(M_BOM.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_BOM_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_BOM with UUID " + M_BOM.getUUID());
			}
		} else {
			this.setM_BOM_ID(0);
		}
	}

	/**
	 * Get BOM.
	 *
	 * @return Bill of Material
	 */
	@JsonProperty("M_BOM")
	public ForeignEntityInput M_BOM() {
		return mM_BOM;
	}

	/**
	 * Set Alternative Group.
	 *
	 * @param M_BOMAlternative Product BOM Alternative Group
	 */
	@JsonProperty("M_BOMAlternative")
	public void setM_BOMAlternativeInput(ForeignEntityInput M_BOMAlternative) {
		this.mM_BOMAlternative = M_BOMAlternative;
		if (M_BOMAlternative != null) {
			// Since an entity was passed, make sure it's in the DB
			X_M_BOMAlternative foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_BOMAlternative", "M_BOMAlternative_UU=?", get_TrxName())
							.setParameters(M_BOMAlternative.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_BOMAlternative_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_BOMAlternative with UUID " + M_BOMAlternative.getUUID());
			}
		} else {
			this.setM_BOMAlternative_ID(0);
		}
	}

	/**
	 * Get Alternative Group.
	 *
	 * @return Product BOM Alternative Group
	 */
	@JsonProperty("M_BOMAlternative")
	public ForeignEntityInput M_BOMAlternative() {
		return mM_BOMAlternative;
	}
	/**
	 * Set BOM Component.
	 *
	 * @param M_BOMProduct_ID Bill of Material Component (Product)
	 */

	public void setM_BOMProduct_ID(int M_BOMProduct_ID) {
		if (get_ID() == 0) {
			super.setM_BOMProduct_ID(M_BOMProduct_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setM_BOMProduct_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getM_BOMProduct_UU();
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
							.setParameters(M_ChangeNotice.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
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
	 * Set BOM Product.
	 *
	 * @param M_ProductBOM Bill of Material Component Product
	 */
	@JsonProperty("M_ProductBOM")
	public void setM_ProductBOMInput(ForeignEntityInput M_ProductBOM) {
		this.mM_ProductBOM = M_ProductBOM;
		if (M_ProductBOM != null) {
			// Since an entity was passed, make sure it's in the DB
			MProduct_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_Product", "M_Product_UU=?", get_TrxName())
							.setParameters(M_ProductBOM.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_ProductBOM_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Product with UUID " + M_ProductBOM.getUUID());
			}
		} else {
			this.setM_ProductBOM_ID(0);
		}
	}

	/**
	 * Get BOM Product.
	 *
	 * @return Bill of Material Component Product
	 */
	@JsonProperty("M_ProductBOM")
	public ForeignEntityInput M_ProductBOM() {
		return mM_ProductBOM;
	}

	/**
	 * Set Product Operation.
	 *
	 * @param M_ProductOperation Product Manufacturing Operation
	 */
	@JsonProperty("M_ProductOperation")
	public void setM_ProductOperationInput(ForeignEntityInput M_ProductOperation) {
		this.mM_ProductOperation = M_ProductOperation;
		if (M_ProductOperation != null) {
			// Since an entity was passed, make sure it's in the DB
			X_M_ProductOperation foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_ProductOperation", "M_ProductOperation_UU=?", get_TrxName())
							.setParameters(M_ProductOperation.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_ProductOperation_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_ProductOperation with UUID " + M_ProductOperation.getUUID());
			}
		} else {
			this.setM_ProductOperation_ID(0);
		}
	}

	/**
	 * Get Product Operation.
	 *
	 * @return Product Manufacturing Operation
	 */
	@JsonProperty("M_ProductOperation")
	public ForeignEntityInput M_ProductOperation() {
		return mM_ProductOperation;
	}
}
