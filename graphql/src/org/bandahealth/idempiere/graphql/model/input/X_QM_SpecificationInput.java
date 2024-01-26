package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MAttributeSet_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_Workflow;
import org.compiere.util.Env;
import org.eevolution.model.MPPProductBOM;
import org.eevolution.model.X_QM_Specification;

import java.sql.ResultSet;

/**
 * Generated Model for QM_Specification - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_QM_SpecificationInput extends X_QM_Specification implements I_QM_SpecificationInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Workflow;
	private ForeignEntityInput mM_AttributeSet;
	private ForeignEntityInput mM_Product;
	private ForeignEntityInput mPP_Product_BOM;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The QM_Specification_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_QM_SpecificationInput(@JsonProperty("UUID") String UUID) {
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
	 * Set Workflow.
	 *
	 * @param AD_Workflow Workflow or combination of tasks
	 */
	@JsonProperty("AD_Workflow")
	public void setAD_WorkflowInput(ForeignEntityInput AD_Workflow) {
		this.mAD_Workflow = AD_Workflow;
		if (AD_Workflow != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_Workflow foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Workflow", "AD_Workflow_UU=?", get_TrxName())
							.setParameters(AD_Workflow.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Workflow_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Workflow with UUID " + AD_Workflow.getUUID());
			}
		} else {
			this.setAD_Workflow_ID(0);
		}
	}

	/**
	 * Get Workflow.
	 *
	 * @return Workflow or combination of tasks
	 */
	@JsonProperty("AD_Workflow")
	public ForeignEntityInput AD_Workflow() {
		return mAD_Workflow;
	}

	/**
	 * Set Attribute Set.
	 *
	 * @param M_AttributeSet Product Attribute Set
	 */
	@JsonProperty("M_AttributeSet")
	public void setM_AttributeSetInput(ForeignEntityInput M_AttributeSet) {
		this.mM_AttributeSet = M_AttributeSet;
		if (M_AttributeSet != null) {
			// Since an entity was passed, make sure it's in the DB
			MAttributeSet_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_AttributeSet", "M_AttributeSet_UU=?", get_TrxName())
							.setParameters(M_AttributeSet.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_AttributeSet_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_AttributeSet with UUID " + M_AttributeSet.getUUID());
			}
		} else {
			this.setM_AttributeSet_ID(0);
		}
	}

	/**
	 * Get Attribute Set.
	 *
	 * @return Product Attribute Set
	 */
	@JsonProperty("M_AttributeSet")
	public ForeignEntityInput M_AttributeSet() {
		return mM_AttributeSet;
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

	/**
	 * Set BOM & Formula.
	 *
	 * @param PP_Product_BOM BOM & Formula
	 */
	@JsonProperty("PP_Product_BOM")
	public void setPP_Product_BOMInput(ForeignEntityInput PP_Product_BOM) {
		this.mPP_Product_BOM = PP_Product_BOM;
		if (PP_Product_BOM != null) {
			// Since an entity was passed, make sure it's in the DB
			MPPProductBOM foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "PP_Product_BOM", "PP_Product_BOM_UU=?", get_TrxName())
							.setParameters(PP_Product_BOM.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setPP_Product_BOM_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table PP_Product_BOM with UUID " + PP_Product_BOM.getUUID());
			}
		} else {
			this.setPP_Product_BOM_ID(0);
		}
	}

	/**
	 * Get BOM & Formula.
	 *
	 * @return BOM & Formula
	 */
	@JsonProperty("PP_Product_BOM")
	public ForeignEntityInput PP_Product_BOM() {
		return mPP_Product_BOM;
	}
	/**
	 * Set Quality Specification.
	 *
	 * @param QM_Specification_ID Quality Specification
	 */

	public void setQM_Specification_ID(int QM_Specification_ID) {
		if (get_ID() == 0) {
			super.setQM_Specification_ID(QM_Specification_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setQM_Specification_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getQM_Specification_UU();
	}
}
