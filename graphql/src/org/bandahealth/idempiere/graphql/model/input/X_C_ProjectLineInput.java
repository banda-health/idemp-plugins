package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MProductCategory_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MProduction;
import org.compiere.model.MProject;
import org.compiere.model.MProjectIssue;
import org.compiere.model.MProjectLine;
import org.compiere.model.MProjectPhase;
import org.compiere.model.MProjectTask;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for C_ProjectLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_ProjectLineInput extends MProjectLine implements I_C_ProjectLineInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_Order;
	private ForeignEntityInput mC_OrderPO;
	private ForeignEntityInput mC_Project;
	private ForeignEntityInput mC_ProjectIssue;
	private ForeignEntityInput mC_ProjectPhase;
	private ForeignEntityInput mC_ProjectTask;
	private ForeignEntityInput mM_Product;
	private ForeignEntityInput mM_Product_Category;
	private ForeignEntityInput mM_Production;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_ProjectLineInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MProjectLine(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Order.
	 *
	 * @param C_Order Order
	 */
	@JsonProperty("C_Order")
	public void setC_OrderInput(ForeignEntityInput C_Order) {
		this.mC_Order = C_Order;
		MOrder_BH foreignEntity;
		if (get_ID() == 0 && C_Order != null &&
				(foreignEntity = new Query(getCtx(), "C_Order", "C_Order_UU=?", get_TrxName())
						.setParameters(C_Order.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Order_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Order.
	 *
	 * @return Order
	 */
	@JsonProperty("C_Order")
	public ForeignEntityInput C_Order() {
		return mC_Order;
	}

	/**
	 * Set Purchase Order.
	 *
	 * @param C_OrderPO Purchase Order
	 */
	@JsonProperty("C_OrderPO")
	public void setC_OrderPOInput(ForeignEntityInput C_OrderPO) {
		this.mC_OrderPO = C_OrderPO;
		MOrder_BH foreignEntity;
		if (get_ID() == 0 && C_OrderPO != null &&
				(foreignEntity = new Query(getCtx(), "C_Order", "C_Order_UU=?", get_TrxName())
						.setParameters(C_OrderPO.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_OrderPO_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Purchase Order.
	 *
	 * @return Purchase Order
	 */
	@JsonProperty("C_OrderPO")
	public ForeignEntityInput C_OrderPO() {
		return mC_OrderPO;
	}

	/**
	 * Set Project.
	 *
	 * @param C_Project Financial Project
	 */
	@JsonProperty("C_Project")
	public void setC_ProjectInput(ForeignEntityInput C_Project) {
		this.mC_Project = C_Project;
		MProject foreignEntity;
		if (get_ID() == 0 && C_Project != null &&
				(foreignEntity = new Query(getCtx(), "C_Project", "C_Project_UU=?", get_TrxName())
						.setParameters(C_Project.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Project_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Project.
	 *
	 * @return Financial Project
	 */
	@JsonProperty("C_Project")
	public ForeignEntityInput C_Project() {
		return mC_Project;
	}

	/**
	 * Set Project Issue.
	 *
	 * @param C_ProjectIssue Project Issues (Material, Labor)
	 */
	@JsonProperty("C_ProjectIssue")
	public void setC_ProjectIssueInput(ForeignEntityInput C_ProjectIssue) {
		this.mC_ProjectIssue = C_ProjectIssue;
		MProjectIssue foreignEntity;
		if (get_ID() == 0 && C_ProjectIssue != null &&
				(foreignEntity = new Query(getCtx(), "C_ProjectIssue", "C_ProjectIssue_UU=?", get_TrxName())
						.setParameters(C_ProjectIssue.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_ProjectIssue_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Project Issue.
	 *
	 * @return Project Issues (Material, Labor)
	 */
	@JsonProperty("C_ProjectIssue")
	public ForeignEntityInput C_ProjectIssue() {
		return mC_ProjectIssue;
	}
	/**
	 * Set Project Line.
	 *
	 * @param C_ProjectLine_ID Task or step in a project
	 */

	public void setC_ProjectLine_ID(int C_ProjectLine_ID) {
		if (get_ID() == 0) {
			super.setC_ProjectLine_ID(C_ProjectLine_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_ProjectLine_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_ProjectLine_UU();
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
		if (C_ProjectPhase != null &&
				(foreignEntity = new Query(getCtx(), "C_ProjectPhase", "C_ProjectPhase_UU=?", get_TrxName())
						.setParameters(C_ProjectPhase.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_ProjectPhase_ID(foreignEntity.get_ID());
		} else {
			super.setC_ProjectPhase_ID(0);
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
	 * @param C_ProjectTask Actual Project Task in a Phase
	 */
	@JsonProperty("C_ProjectTask")
	public void setC_ProjectTaskInput(ForeignEntityInput C_ProjectTask) {
		this.mC_ProjectTask = C_ProjectTask;
		MProjectTask foreignEntity;
		if (C_ProjectTask != null &&
				(foreignEntity = new Query(getCtx(), "C_ProjectTask", "C_ProjectTask_UU=?", get_TrxName())
						.setParameters(C_ProjectTask.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_ProjectTask_ID(foreignEntity.get_ID());
		} else {
			super.setC_ProjectTask_ID(0);
		}
	}

	/**
	 * Get Project Task.
	 *
	 * @return Actual Project Task in a Phase
	 */
	@JsonProperty("C_ProjectTask")
	public ForeignEntityInput C_ProjectTask() {
		return mC_ProjectTask;
	}

	/**
	 * Set Product Category.
	 *
	 * @param M_Product_Category Category of a Product
	 */
	@JsonProperty("M_Product_Category")
	public void setM_Product_CategoryInput(ForeignEntityInput M_Product_Category) {
		this.mM_Product_Category = M_Product_Category;
		MProductCategory_BH foreignEntity;
		if (M_Product_Category != null &&
				(foreignEntity = new Query(getCtx(), "M_Product_Category", "M_Product_Category_UU=?", get_TrxName())
						.setParameters(M_Product_Category.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_Product_Category_ID(foreignEntity.get_ID());
		} else {
			super.setM_Product_Category_ID(0);
		}
	}

	/**
	 * Get Product Category.
	 *
	 * @return Category of a Product
	 */
	@JsonProperty("M_Product_Category")
	public ForeignEntityInput M_Product_Category() {
		return mM_Product_Category;
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
				(foreignEntity = new Query(getCtx(), "M_Product", "M_Product_UU=?", get_TrxName())
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
	 * Set Production.
	 *
	 * @param M_Production Plan for producing a product
	 */
	@JsonProperty("M_Production")
	public void setM_ProductionInput(ForeignEntityInput M_Production) {
		this.mM_Production = M_Production;
		MProduction foreignEntity;
		if (get_ID() == 0 && M_Production != null &&
				(foreignEntity = new Query(getCtx(), "M_Production", "M_Production_UU=?", get_TrxName())
						.setParameters(M_Production.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_Production_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Production.
	 *
	 * @return Plan for producing a product
	 */
	@JsonProperty("M_Production")
	public ForeignEntityInput M_Production() {
		return mM_Production;
	}
}
