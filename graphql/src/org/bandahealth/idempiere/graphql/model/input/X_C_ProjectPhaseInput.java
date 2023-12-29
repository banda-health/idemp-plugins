package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MProject;
import org.compiere.model.MProjectTypePhase;
import org.compiere.model.MRefList;
import org.compiere.model.Query;
import org.compiere.model.X_C_ProjectPhase;
import org.compiere.util.Env;

/**
 * Generated Model for C_ProjectPhase - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_ProjectPhaseInput extends X_C_ProjectPhase implements I_C_ProjectPhaseInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput ProjInvoiceRule_RL;
	 private I_C_OrderInput C_Order;
	 private I_C_PhaseInput C_Phase;
	 private I_C_ProjectInput C_Project;
	 private I_M_ProductInput M_Product;

	/**
	 * Standard constructor
	 */
	public X_C_ProjectPhaseInput(String ID) {
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
	 * Set Order.
	 *
	 * @param C_Order Order
	 */
	public void setC_Order(I_C_OrderInput C_Order) {
		this.C_Order = C_Order;
		MOrder_BH foreignEntity;
		if (get_ID() == 0 &&C_Order != null &&
				(foreignEntity = new Query(getCtx(), MOrder_BH.Table_Name, MOrder_BH.COLUMNNAME_C_Order_UU + "=?", get_TrxName())
						.setParameters(C_Order.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Order_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Order.
	 *
	 * @return Order
	 */
	public I_C_OrderInput getC_Order() {
		return C_Order;
	}
	/**
	 * Set Order.
	 *
	 * @param C_Order_ID Order
	 */

	public void setC_Order_ID(int C_Order_ID) {
		if (get_ID() == 0) {
			super.setC_Order_ID(C_Order_ID);
		}
	}

	/**
	 * Set Standard Phase.
	 *
	 * @param C_Phase Standard Phase of the Project Type
	 */
	public void setC_Phase(I_C_PhaseInput C_Phase) {
		this.C_Phase = C_Phase;
		MProjectTypePhase foreignEntity;
		if (get_ID() == 0 &&C_Phase != null &&
				(foreignEntity = new Query(getCtx(), MProjectTypePhase.Table_Name, MProjectTypePhase.COLUMNNAME_C_Phase_UU + "=?", get_TrxName())
						.setParameters(C_Phase.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Phase_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Standard Phase.
	 *
	 * @return Standard Phase of the Project Type
	 */
	public I_C_PhaseInput getC_Phase() {
		return C_Phase;
	}
	/**
	 * Set Standard Phase.
	 *
	 * @param C_Phase_ID Standard Phase of the Project Type
	 */

	public void setC_Phase_ID(int C_Phase_ID) {
		if (get_ID() == 0) {
			super.setC_Phase_ID(C_Phase_ID);
		}
	}

	/**
	 * Set Project.
	 *
	 * @param C_Project Financial Project
	 */
	public void setC_Project(I_C_ProjectInput C_Project) {
		this.C_Project = C_Project;
		MProject foreignEntity;
		if (get_ID() == 0 &&C_Project != null &&
				(foreignEntity = new Query(getCtx(), MProject.Table_Name, MProject.COLUMNNAME_C_Project_UU + "=?", get_TrxName())
						.setParameters(C_Project.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Project_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Project.
	 *
	 * @return Financial Project
	 */
	public I_C_ProjectInput getC_Project() {
		return C_Project;
	}
	/**
	 * Set Project.
	 *
	 * @param C_Project_ID Financial Project
	 */

	public void setC_Project_ID(int C_Project_ID) {
		if (get_ID() == 0) {
			super.setC_Project_ID(C_Project_ID);
		}
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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_ProjectPhase_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_ProjectPhase_UU();
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
