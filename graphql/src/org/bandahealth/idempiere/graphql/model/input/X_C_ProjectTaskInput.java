package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MProjectPhase;
import org.compiere.model.MProjectTypeTask;
import org.compiere.model.MRefList;
import org.compiere.model.Query;
import org.compiere.model.X_C_ProjectTask;
import org.compiere.util.Env;

/**
 * Generated Model for C_ProjectTask - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_ProjectTaskInput extends X_C_ProjectTask implements I_C_ProjectTaskInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput ProjInvoiceRule_RL;
	 private I_C_ProjectPhaseInput C_ProjectPhase;
	 private I_C_TaskInput C_Task;
	 private I_M_ProductInput M_Product;

	/**
	 * Standard constructor
	 */
	public X_C_ProjectTaskInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	public void setAD_Org(I_AD_OrgInput AD_Org) {
		this.AD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	public I_AD_OrgInput getAD_Org() {
		return AD_Org;
	}

	/**
	 * Set Project Phase.
	 *
	 * @param C_ProjectPhase Phase of a Project
	 */
	public void setC_ProjectPhase(I_C_ProjectPhaseInput C_ProjectPhase) {
		this.C_ProjectPhase = C_ProjectPhase;
		MProjectPhase foreignEntity;
		if (get_ID() == 0 &&C_ProjectPhase != null &&
				(foreignEntity = new Query(getCtx(), MProjectPhase.Table_Name, MProjectPhase.COLUMNNAME_C_ProjectPhase_UU + "=?", get_TrxName())
						.setParameters(C_ProjectPhase.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_ProjectPhase_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Project Phase.
	 *
	 * @return Phase of a Project
	 */
	public I_C_ProjectPhaseInput getC_ProjectPhase() {
		return C_ProjectPhase;
	}
	/**
	 * Set Project Phase.
	 *
	 * @param C_ProjectPhase_ID Phase of a Project
	 */

	public void setC_ProjectPhase_ID(int C_ProjectPhase_ID) {
		if (get_ID() == 0) {
			super.setC_ProjectPhase_ID(C_ProjectPhase_ID);
		}
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
	public void setC_Task(I_C_TaskInput C_Task) {
		this.C_Task = C_Task;
		MProjectTypeTask foreignEntity;
		if (get_ID() == 0 &&C_Task != null &&
				(foreignEntity = new Query(getCtx(), MProjectTypeTask.Table_Name, MProjectTypeTask.COLUMNNAME_C_Task_UU + "=?", get_TrxName())
						.setParameters(C_Task.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Task_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Standard Task.
	 *
	 * @return Standard Project Type Task
	 */
	public I_C_TaskInput getC_Task() {
		return C_Task;
	}
	/**
	 * Set Standard Task.
	 *
	 * @param C_Task_ID Standard Project Type Task
	 */

	public void setC_Task_ID(int C_Task_ID) {
		if (get_ID() == 0) {
			super.setC_Task_ID(C_Task_ID);
		}
	}

	/**
	 * Set Product/Service.
	 *
	 * @param M_Product Product, Service, Item
	 */
	public void setM_Product(I_M_ProductInput M_Product) {
		this.M_Product = M_Product;
		MProduct_BH foreignEntity;
		if (M_Product != null &&
				(foreignEntity = new Query(getCtx(), MProduct_BH.Table_Name, MProduct_BH.COLUMNNAME_M_Product_UU + "=?", get_TrxName())
						.setParameters(M_Product.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_Product_ID(foreignEntity.get_ID());
		} else {
			this.setM_Product_ID(0);
		}
	}

	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	public I_M_ProductInput getM_Product() {
		return M_Product;
	}

	/**
	 * Set Invoice Rule.
	 *
	 * @param ProjInvoiceRule_RL Invoice Rule for the project
	 */
	public void setProjInvoiceRule_RL(I_AD_Ref_ListInput ProjInvoiceRule_RL) {
		this.ProjInvoiceRule_RL = ProjInvoiceRule_RL;
		MRefList foreignEntity;
		if (ProjInvoiceRule_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(ProjInvoiceRule_RL.getID())
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
	public I_AD_Ref_ListInput getProjInvoiceRule_RL() {
		return ProjInvoiceRule_RL;
	}
}
