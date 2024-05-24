package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_C_ProjectTaskResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MProjectPhase;
import org.compiere.model.MProjectTask;
import org.compiere.model.MProjectTypeTask;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for C_ProjectTask - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_ProjectTaskInput extends MProjectTask implements I_C_ProjectTaskInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_ProjectPhase;
	private ForeignEntityInput mC_Task;
	private ForeignEntityInput mM_Product;
	private ForeignEntityInput mProjInvoiceRule;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The C_ProjectTask_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_ProjectTaskInput(@JsonProperty("UU") String UU) {
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
	 * Set Project Phase.
	 *
	 * @param C_ProjectPhase Phase of a Project
	 */
	@JsonProperty("C_ProjectPhase")
	public void setC_ProjectPhaseInput(ForeignEntityInput C_ProjectPhase) {
		this.mC_ProjectPhase = C_ProjectPhase;
		if (get_ID() != 0) {
			return;
		}
		if (C_ProjectPhase != null) {
			// Since an entity was passed, make sure it's in the DB
			MProjectPhase foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ProjectPhase", "C_ProjectPhase_UU=?", get_TrxName())
							.setParameters(C_ProjectPhase.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_ProjectPhase_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ProjectPhase with UU " + C_ProjectPhase.getUU());
			}
		} else {
			this.setC_ProjectPhase_ID(0);
		}
	}

	/**
	 * Get Project Phase.
	 *
	 * @return Phase of a Project
	 */
	@JsonProperty("C_ProjectPhase")
	public ForeignEntityInput C_ProjectPhase() {
		return mC_ProjectPhase;
	}
	/**
	 * Set Project Task.
	 *
	 * @param C_ProjectTask_ID Actual Project Task in a Phase
	 */

	public void setC_ProjectTask_ID(int C_ProjectTask_ID) {
		if (get_ID() == 0) {
			super.setC_ProjectTask_ID(C_ProjectTask_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setC_ProjectTask_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getC_ProjectTask_UU();
	}

	/**
	 * Set Standard Task.
	 *
	 * @param C_Task Standard Project Type Task
	 */
	@JsonProperty("C_Task")
	public void setC_TaskInput(ForeignEntityInput C_Task) {
		this.mC_Task = C_Task;
		if (get_ID() != 0) {
			return;
		}
		if (C_Task != null) {
			// Since an entity was passed, make sure it's in the DB
			MProjectTypeTask foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Task", "C_Task_UU=?", get_TrxName())
							.setParameters(C_Task.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_Task_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Task with UU " + C_Task.getUU());
			}
		} else {
			this.setC_Task_ID(0);
		}
	}

	/**
	 * Get Standard Task.
	 *
	 * @return Standard Project Type Task
	 */
	@JsonProperty("C_Task")
	public ForeignEntityInput C_Task() {
		return mC_Task;
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
	 * Set Invoice Rule.
	 *
	 * @param ProjInvoiceRule Invoice Rule for the project
	 */
	@JsonProperty("ProjInvoiceRule")
	public void setProjInvoiceRuleInput(ForeignEntityInput ProjInvoiceRule) {
		this.mProjInvoiceRule = ProjInvoiceRule;
		if (ProjInvoiceRule != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_C_ProjectTaskResolver.PROJINVOICERULE_UUIDS_BY_VALUE.containsValue(ProjInvoiceRule.getUU())) {
				throw new AdempiereException("The reference list UU of " + ProjInvoiceRule.getUU() +
						" is not in the list defined for the ProjInvoiceRule column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(ProjInvoiceRule.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setProjInvoiceRule(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + ProjInvoiceRule.getUU());
			}
		} else {
			this.setProjInvoiceRule(null);
		}
	}

	/**
	 * Get Invoice Rule.
	 *
	 * @return Invoice Rule for the project
	 */
	@JsonProperty("ProjInvoiceRule")
	public ForeignEntityInput ProjInvoiceRule() {
		return mProjInvoiceRule;
	}
}
