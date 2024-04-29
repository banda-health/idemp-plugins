package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MCostElement;
import org.compiere.model.MOrg;
import org.compiere.model.MPInstance;
import org.compiere.model.Query;
import org.compiere.model.X_T_BOM_Indented;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for T_BOM_Indented - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_T_BOM_IndentedInput extends X_T_BOM_Indented implements I_T_BOM_IndentedInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_PInstance;
	private ForeignEntityInput mC_AcctSchema;
	private ForeignEntityInput mM_CostElement;
	private ForeignEntityInput mM_Product;
	private ForeignEntityInput mSel_Product;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The T_BOM_Indented_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_T_BOM_IndentedInput(@JsonProperty("UU") String UU) {
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
	 * Set Process Instance.
	 *
	 * @param AD_PInstance Instance of the process
	 */
	@JsonProperty("AD_PInstance")
	public void setAD_PInstanceInput(ForeignEntityInput AD_PInstance) {
		this.mAD_PInstance = AD_PInstance;
		if (AD_PInstance != null) {
			// Since an entity was passed, make sure it's in the DB
			MPInstance foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_PInstance", "AD_PInstance_UU=?", get_TrxName())
							.setParameters(AD_PInstance.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_PInstance_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_PInstance with UU " + AD_PInstance.getUU());
			}
		} else {
			this.setAD_PInstance_ID(0);
		}
	}

	/**
	 * Get Process Instance.
	 *
	 * @return Instance of the process
	 */
	@JsonProperty("AD_PInstance")
	public ForeignEntityInput AD_PInstance() {
		return mAD_PInstance;
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
							.setParameters(C_AcctSchema.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_AcctSchema_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_AcctSchema with UU " + C_AcctSchema.getUU());
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
	 * Set Cost Element.
	 *
	 * @param M_CostElement Product Cost Element
	 */
	@JsonProperty("M_CostElement")
	public void setM_CostElementInput(ForeignEntityInput M_CostElement) {
		this.mM_CostElement = M_CostElement;
		if (M_CostElement != null) {
			// Since an entity was passed, make sure it's in the DB
			MCostElement foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_CostElement", "M_CostElement_UU=?", get_TrxName())
							.setParameters(M_CostElement.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setM_CostElement_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_CostElement with UU " + M_CostElement.getUU());
			}
		} else {
			this.setM_CostElement_ID(0);
		}
	}

	/**
	 * Get Cost Element.
	 *
	 * @return Product Cost Element
	 */
	@JsonProperty("M_CostElement")
	public ForeignEntityInput M_CostElement() {
		return mM_CostElement;
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
							.setParameters(M_Product.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
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
	 * Set Selected Product.
	 *
	 * @param Sel_Product Selected Product
	 */
	@JsonProperty("Sel_Product")
	public void setSel_ProductInput(ForeignEntityInput Sel_Product) {
		this.mSel_Product = Sel_Product;
		if (Sel_Product != null) {
			// Since an entity was passed, make sure it's in the DB
			MProduct_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_Product", "M_Product_UU=?", get_TrxName())
							.setParameters(Sel_Product.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setSel_Product_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Product with UU " + Sel_Product.getUU());
			}
		} else {
			this.setSel_Product_ID(0);
		}
	}

	/**
	 * Get Selected Product.
	 *
	 * @return Selected Product
	 */
	@JsonProperty("Sel_Product")
	public ForeignEntityInput Sel_Product() {
		return mSel_Product;
	}
	/**
	 * Set Indented BOM Report.
	 *
	 * @param T_BOM_Indented_ID Indented BOM Report
	 */

	public void setT_BOM_Indented_ID(int T_BOM_Indented_ID) {
		if (get_ID() == 0) {
			super.setT_BOM_Indented_ID(T_BOM_Indented_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setT_BOM_Indented_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getT_BOM_Indented_UU();
	}
}
