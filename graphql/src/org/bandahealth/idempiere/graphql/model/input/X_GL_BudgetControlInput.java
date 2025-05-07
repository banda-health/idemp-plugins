package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_GL_BudgetControlResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_GL_Budget;
import org.compiere.model.X_GL_BudgetControl;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for GL_BudgetControl - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_GL_BudgetControlInput extends X_GL_BudgetControl implements I_GL_BudgetControlInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mBudgetControlScope;
	private ForeignEntityInput mC_AcctSchema;
	private ForeignEntityInput mCommitmentType;
	private ForeignEntityInput mGL_Budget;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The GL_BudgetControl_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_GL_BudgetControlInput(@JsonProperty("UU") String UU) {
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
	 * Set Control Scope.
	 *
	 * @param BudgetControlScope Scope of the Budget Control
	 */
	@JsonProperty("BudgetControlScope")
	public void setBudgetControlScopeInput(ForeignEntityInput BudgetControlScope) {
		this.mBudgetControlScope = BudgetControlScope;
		if (BudgetControlScope != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_GL_BudgetControlResolver.BUDGETCONTROLSCOPE_UUIDS_BY_VALUE.containsValue(BudgetControlScope.getUU())) {
				throw new AdempiereException("The reference list UU of " + BudgetControlScope.getUU() +
						" is not in the list defined for the BudgetControlScope column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(BudgetControlScope.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setBudgetControlScope(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + BudgetControlScope.getUU());
			}
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
	public ForeignEntityInput BudgetControlScope() {
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
		if (C_AcctSchema != null) {
			// Since an entity was passed, make sure it's in the DB
			MAcctSchema foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_AcctSchema", "C_AcctSchema_UU=?", get_TrxName())
							.setParameters(C_AcctSchema.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
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
	 * Set Commitment Type.
	 *
	 * @param CommitmentType Create Commitment and/or Reservations for Budget Control
	 */
	@JsonProperty("CommitmentType")
	public void setCommitmentTypeInput(ForeignEntityInput CommitmentType) {
		this.mCommitmentType = CommitmentType;
		if (CommitmentType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_GL_BudgetControlResolver.COMMITMENTTYPE_UUIDS_BY_VALUE.containsValue(CommitmentType.getUU())) {
				throw new AdempiereException("The reference list UU of " + CommitmentType.getUU() +
						" is not in the list defined for the CommitmentType column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(CommitmentType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setCommitmentType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + CommitmentType.getUU());
			}
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
	public ForeignEntityInput CommitmentType() {
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
		if (GL_Budget != null) {
			// Since an entity was passed, make sure it's in the DB
			X_GL_Budget foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "GL_Budget", "GL_Budget_UU=?", get_TrxName())
							.setParameters(GL_Budget.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setGL_Budget_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table GL_Budget with UU " + GL_Budget.getUU());
			}
		} else {
			this.setGL_Budget_ID(0);
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
	@JsonProperty("GL_BudgetControl_ID")
	public void setGL_BudgetControl_IDFromJson(int GL_BudgetControl_ID) {
		if (get_ID() == 0) {
			super.setGL_BudgetControl_ID(GL_BudgetControl_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setGL_BudgetControl_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getGL_BudgetControl_UU();
	}
}
