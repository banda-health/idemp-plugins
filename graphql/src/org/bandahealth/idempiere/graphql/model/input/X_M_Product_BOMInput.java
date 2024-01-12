package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MProductBOM;
import org.compiere.model.Query;
import org.compiere.model.X_M_PartType;

import java.math.BigDecimal;
import java.sql.ResultSet;

/**
 * Generated Model for M_Product_BOM - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_Product_BOMInput extends MProductBOM implements I_M_Product_BOMInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mM_PartType;
	private ForeignEntityInput mM_Product;
	private ForeignEntityInput mM_ProductBOM;
	private I_AD_Ref_ListInput mBOMType;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_M_Product_BOMInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MProductBOM(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set BOM Type.
	 *
	 * @param BOMType Type of BOM
	 */
	@JsonProperty("BOMType")
	public void setBOMTypeInput(I_AD_Ref_ListInput BOMType) {
		this.mBOMType = BOMType;
		MRefList_BH foreignEntity;
		if (BOMType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(BOMType.getID())
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
	@JsonProperty("BOMType")
	public I_AD_Ref_ListInput BOMType() {
		return mBOMType;
	}
	/**
	 * Set Standard Cost.
	 *
	 * @param CostStandard Standard Costs
	 */

	public void setCostStandard(BigDecimal CostStandard) {
		if (get_ID() == 0) {
			super.setCostStandard(CostStandard);
		}
	}
	/**
	 * Set Std Cost Amount Sum.
	 *
	 * @param CostStandardCumAmt Standard Cost Invoice Amount Sum (internal)
	 */

	public void setCostStandardCumAmt(BigDecimal CostStandardCumAmt) {
		if (get_ID() == 0) {
			super.setCostStandardCumAmt(CostStandardCumAmt);
		}
	}
	/**
	 * Set Bill of Materials.
	 *
	 * @param IsBillOfMaterial Bill of Materials
	 */

	public void setIsBillOfMaterial(boolean IsBillOfMaterial) {
		if (get_ID() == 0) {
			super.setIsBillOfMaterial(IsBillOfMaterial);
		}
	}

	/**
	 * Set Part Type.
	 *
	 * @param M_PartType Part Type
	 */
	@JsonProperty("M_PartType")
	public void setM_PartTypeInput(ForeignEntityInput M_PartType) {
		this.mM_PartType = M_PartType;
		X_M_PartType foreignEntity;
		if (get_ID() == 0 && M_PartType != null &&
				(foreignEntity = new Query(getCtx(), "M_PartType", "M_PartType_UU=?", get_TrxName())
						.setParameters(M_PartType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_PartType_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Part Type.
	 *
	 * @return Part Type
	 */
	@JsonProperty("M_PartType")
	public ForeignEntityInput M_PartType() {
		return mM_PartType;
	}
	/**
	 * Set BOM Line.
	 *
	 * @param M_Product_BOM_ID BOM Line
	 */

	public void setM_Product_BOM_ID(int M_Product_BOM_ID) {
		if (get_ID() == 0) {
			super.setM_Product_BOM_ID(M_Product_BOM_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setM_Product_BOM_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getM_Product_BOM_UU();
	}

	/**
	 * Set Product/Service.
	 *
	 * @param M_Product Product, Service, Item
	 */
	@JsonProperty("M_Product")
	public void setM_ProductInput(ForeignEntityInput M_Product) {
		this.mM_Product = M_Product;
		MProduct_BH foreignEntity;
		if (get_ID() == 0 && M_Product != null &&
				(foreignEntity = new Query(getCtx(), "M_Product", "M_Product_UU=?", get_TrxName())
						.setParameters(M_Product.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_Product_ID(foreignEntity.get_ID());
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
	 * Set Search Key.
	 *
	 * @param Value Search key for the record in the format required - must be unique
	 */

	public void setValue(String Value) {
		if (get_ID() == 0) {
			super.setValue(Value);
		}
	}
}
