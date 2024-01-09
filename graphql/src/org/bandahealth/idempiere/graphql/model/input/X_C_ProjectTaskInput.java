package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MProjectPhase;
import org.compiere.model.MProjectTask;
import org.compiere.model.MProjectTypeTask;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Generated Model for C_ProjectTask - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_ProjectTaskInput extends MProjectTask implements I_C_ProjectTaskInput {

	 private ForeignEntityInput mAD_Org;
	 private ForeignEntityInput mC_ProjectPhase;
	 private ForeignEntityInput mC_Task;
	 private ForeignEntityInput mM_Product;
	 private I_AD_Ref_ListInput mProjInvoiceRule;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_ProjectTaskInput(@JsonProperty("ID") String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
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
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
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
	 * Set Project Phase.
	 *
	 * @param C_ProjectPhase Phase of a Project
	 */
	@JsonProperty("C_ProjectPhase")
	public void setC_ProjectPhaseInput(ForeignEntityInput C_ProjectPhase) {
		this.mC_ProjectPhase = C_ProjectPhase;
		MProjectPhase foreignEntity;
		if (get_ID() == 0 &&C_ProjectPhase != null &&
				(foreignEntity = new Query(getCtx(), MProjectPhase.Table_Name, MProjectPhase.COLUMNNAME_C_ProjectPhase_UU + "=?", get_TrxName())
						.setParameters(C_ProjectPhase.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_ProjectPhase_ID(foreignEntity.get_ID());
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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_ProjectTask_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
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
		MProjectTypeTask foreignEntity;
		if (get_ID() == 0 &&C_Task != null &&
				(foreignEntity = new Query(getCtx(), MProjectTypeTask.Table_Name, MProjectTypeTask.COLUMNNAME_C_Task_UU + "=?", get_TrxName())
						.setParameters(C_Task.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Task_ID(foreignEntity.get_ID());
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
		MProduct_BH foreignEntity;
		if (M_Product != null &&
				(foreignEntity = new Query(getCtx(), MProduct_BH.Table_Name, MProduct_BH.COLUMNNAME_M_Product_UU + "=?", get_TrxName())
						.setParameters(M_Product.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_Product_ID(foreignEntity.get_ID());
		} else {
			super.setM_Product_ID(0);
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
	public void setProjInvoiceRuleInput(I_AD_Ref_ListInput ProjInvoiceRule) {
		this.mProjInvoiceRule = ProjInvoiceRule;
		MRefList_BH foreignEntity;
		if (ProjInvoiceRule != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(ProjInvoiceRule.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setProjInvoiceRule(foreignEntity.getValue());
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
	public I_AD_Ref_ListInput ProjInvoiceRule() {
		return mProjInvoiceRule;
	}
}
