package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_GL_Budget;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for GL_Budget - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_GL_BudgetInput extends X_GL_Budget implements I_GL_BudgetInput {

	private ForeignEntityInput mAD_Org;
	private I_AD_Ref_ListInput mBudgetStatus;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The GL_Budget_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_GL_BudgetInput(@JsonProperty("UU") String UU) {
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
	 * Set Budget Status.
	 *
	 * @param BudgetStatus Indicates the current status of this budget
	 */
	@JsonProperty("BudgetStatus")
	public void setBudgetStatusInput(I_AD_Ref_ListInput BudgetStatus) {
		this.mBudgetStatus = BudgetStatus;
		if (BudgetStatus != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(BudgetStatus.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setBudgetStatus(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + BudgetStatus.getUU());
			}
		} else {
			this.setBudgetStatus(null);
		}
	}

	/**
	 * Get Budget Status.
	 *
	 * @return Indicates the current status of this budget
	 */
	@JsonProperty("BudgetStatus")
	public I_AD_Ref_ListInput BudgetStatus() {
		return mBudgetStatus;
	}
	/**
	 * Set Budget.
	 *
	 * @param GL_Budget_ID General Ledger Budget
	 */

	public void setGL_Budget_ID(int GL_Budget_ID) {
		if (get_ID() == 0) {
			super.setGL_Budget_ID(GL_Budget_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setGL_Budget_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getGL_Budget_UU();
	}
}
