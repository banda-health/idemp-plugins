package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_GL_Budget;
import org.compiere.model.X_GL_BudgetControl;

import java.sql.ResultSet;

/**
 * Generated Model for GL_BudgetControl - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_GL_BudgetControlInput extends X_GL_BudgetControl implements I_GL_BudgetControlInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_AcctSchema;
	private ForeignEntityInput mGL_Budget;
	private I_AD_Ref_ListInput mBudgetControlScope;
	private I_AD_Ref_ListInput mCommitmentType;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_GL_BudgetControlInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_GL_BudgetControl(null, (ResultSet) null, null), null, Table_Name, ID),
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
		if (AD_Org != null &&
				(foreignEntity = new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Org_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Org_ID(0);
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
	 * Set Control Scope.
	 *
	 * @param BudgetControlScope Scope of the Budget Control
	 */
	@JsonProperty("BudgetControlScope")
	public void setBudgetControlScopeInput(I_AD_Ref_ListInput BudgetControlScope) {
		this.mBudgetControlScope = BudgetControlScope;
		MRefList_BH foreignEntity;
		if (BudgetControlScope != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(BudgetControlScope.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setBudgetControlScope(foreignEntity.getValue());
		} else {
			this.setBudgetControlScope(null);
		}
	}

	/**
	 * Get Control Scope.
	 *
	 * @return Scope of the Budget Control
	 */
	@JsonProperty("BudgetControlScope")
	public I_AD_Ref_ListInput BudgetControlScope() {
		return mBudgetControlScope;
	}

	/**
	 * Set Accounting Schema.
	 *
	 * @param C_AcctSchema Rules for accounting
	 */
	@JsonProperty("C_AcctSchema")
	public void setC_AcctSchemaInput(ForeignEntityInput C_AcctSchema) {
		this.mC_AcctSchema = C_AcctSchema;
		MAcctSchema foreignEntity;
		if (C_AcctSchema != null &&
				(foreignEntity = new Query(getCtx(), "C_AcctSchema", "C_AcctSchema_UU=?", get_TrxName())
						.setParameters(C_AcctSchema.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_AcctSchema_ID(foreignEntity.get_ID());
		} else {
			super.setC_AcctSchema_ID(0);
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
	 * Set Commitment Type.
	 *
	 * @param CommitmentType Create Commitment and/or Reservations for Budget Control
	 */
	@JsonProperty("CommitmentType")
	public void setCommitmentTypeInput(I_AD_Ref_ListInput CommitmentType) {
		this.mCommitmentType = CommitmentType;
		MRefList_BH foreignEntity;
		if (CommitmentType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(CommitmentType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setCommitmentType(foreignEntity.getValue());
		} else {
			this.setCommitmentType(null);
		}
	}

	/**
	 * Get Commitment Type.
	 *
	 * @return Create Commitment and/or Reservations for Budget Control
	 */
	@JsonProperty("CommitmentType")
	public I_AD_Ref_ListInput CommitmentType() {
		return mCommitmentType;
	}

	/**
	 * Set Budget.
	 *
	 * @param GL_Budget General Ledger Budget
	 */
	@JsonProperty("GL_Budget")
	public void setGL_BudgetInput(ForeignEntityInput GL_Budget) {
		this.mGL_Budget = GL_Budget;
		X_GL_Budget foreignEntity;
		if (GL_Budget != null &&
				(foreignEntity = new Query(getCtx(), "GL_Budget", "GL_Budget_UU=?", get_TrxName())
						.setParameters(GL_Budget.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setGL_Budget_ID(foreignEntity.get_ID());
		} else {
			super.setGL_Budget_ID(0);
		}
	}

	/**
	 * Get Budget.
	 *
	 * @return General Ledger Budget
	 */
	@JsonProperty("GL_Budget")
	public ForeignEntityInput GL_Budget() {
		return mGL_Budget;
	}
	/**
	 * Set Budget Control.
	 *
	 * @param GL_BudgetControl_ID Budget Control
	 */

	public void setGL_BudgetControl_ID(int GL_BudgetControl_ID) {
		if (get_ID() == 0) {
			super.setGL_BudgetControl_ID(GL_BudgetControl_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setGL_BudgetControl_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getGL_BudgetControl_UU();
	}
}
