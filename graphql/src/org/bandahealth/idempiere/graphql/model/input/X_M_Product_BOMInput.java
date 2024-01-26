package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MProductBOM;
import org.compiere.model.Query;
import org.compiere.model.X_M_PartType;
import org.compiere.util.Env;

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
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The M_Product_BOM_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_M_Product_BOMInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, UUID), null);
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
							.setParameters(BOMType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
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
		if (get_ID() != 0) {
			return;
		}
		if (M_PartType != null) {
			// Since an entity was passed, make sure it's in the DB
			X_M_PartType foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_PartType", "M_PartType_UU=?", get_TrxName())
							.setParameters(M_PartType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_PartType_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_PartType with UUID " + M_PartType.getUUID());
			}
		} else {
			this.setM_PartType_ID(0);
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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setM_Product_BOM_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
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
		if (get_ID() != 0) {
			return;
		}
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
