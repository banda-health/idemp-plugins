package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
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

import java.sql.ResultSet;

/**
 * Generated Model for M_BOMProduct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
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
	 * Standard constructor
	 */
	@JsonCreator
	public X_M_BOMProductInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MBOMProduct(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
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
		if (get_ID() == 0 && AD_Org != null &&
				(foreignEntity = new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Org_ID(foreignEntity.get_ID());
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
		MRefList_BH foreignEntity;
		if (BOMProductType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(BOMProductType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setBOMProductType(foreignEntity.getValue());
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
		MAttributeSetInstance_BH foreignEntity;
		if (M_AttributeSetInstance != null &&
				(foreignEntity = new Query(getCtx(), "M_AttributeSetInstance", "M_AttributeSetInstance_UU=?", get_TrxName())
						.setParameters(M_AttributeSetInstance.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_AttributeSetInstance_ID(foreignEntity.get_ID());
		} else {
			super.setM_AttributeSetInstance_ID(0);
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
		MBOM foreignEntity;
		if (get_ID() == 0 && M_BOM != null &&
				(foreignEntity = new Query(getCtx(), "M_BOM", "M_BOM_UU=?", get_TrxName())
						.setParameters(M_BOM.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_BOM_ID(foreignEntity.get_ID());
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
		X_M_BOMAlternative foreignEntity;
		if (M_BOMAlternative != null &&
				(foreignEntity = new Query(getCtx(), "M_BOMAlternative", "M_BOMAlternative_UU=?", get_TrxName())
						.setParameters(M_BOMAlternative.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_BOMAlternative_ID(foreignEntity.get_ID());
		} else {
			super.setM_BOMAlternative_ID(0);
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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setM_BOMProduct_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
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
		MChangeNotice foreignEntity;
		if (M_ChangeNotice != null &&
				(foreignEntity = new Query(getCtx(), "M_ChangeNotice", "M_ChangeNotice_UU=?", get_TrxName())
						.setParameters(M_ChangeNotice.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_ChangeNotice_ID(foreignEntity.get_ID());
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
	 * Set BOM Product.
	 *
	 * @param M_ProductBOM Bill of Material Component Product
	 */
	@JsonProperty("M_ProductBOM")
	public void setM_ProductBOMInput(ForeignEntityInput M_ProductBOM) {
		this.mM_ProductBOM = M_ProductBOM;
		MProduct_BH foreignEntity;
		if (M_ProductBOM != null &&
				(foreignEntity = new Query(getCtx(), "M_Product", "M_Product_UU=?", get_TrxName())
						.setParameters(M_ProductBOM.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_ProductBOM_ID(foreignEntity.get_ID());
		} else {
			super.setM_ProductBOM_ID(0);
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
		X_M_ProductOperation foreignEntity;
		if (M_ProductOperation != null &&
				(foreignEntity = new Query(getCtx(), "M_ProductOperation", "M_ProductOperation_UU=?", get_TrxName())
						.setParameters(M_ProductOperation.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_ProductOperation_ID(foreignEntity.get_ID());
		} else {
			super.setM_ProductOperation_ID(0);
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
