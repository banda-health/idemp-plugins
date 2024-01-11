package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MBPGroup_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAccount;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MElementValue;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.eevolution.model.X_HR_Concept;
import org.eevolution.model.X_HR_Concept_Acct;

import java.sql.ResultSet;

/**
 * Generated Model for HR_Concept_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_HR_Concept_AcctInput extends X_HR_Concept_Acct implements I_HR_Concept_AcctInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_AcctSchema;
	private ForeignEntityInput mC_BP_Group;
	private ForeignEntityInput mHR_Concept;
	private ForeignEntityInput mHR_Expense_A;
	private ForeignEntityInput mHR_Revenue_A;
	private ForeignEntityInput mUser1;
	private ForeignEntityInput mUser2;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_HR_Concept_AcctInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_HR_Concept_Acct(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Business Partner Group.
	 *
	 * @param C_BP_Group Business Partner Group
	 */
	@JsonProperty("C_BP_Group")
	public void setC_BP_GroupInput(ForeignEntityInput C_BP_Group) {
		this.mC_BP_Group = C_BP_Group;
		MBPGroup_BH foreignEntity;
		if (C_BP_Group != null &&
				(foreignEntity = new Query(getCtx(), "C_BP_Group", "C_BP_Group_UU=?", get_TrxName())
						.setParameters(C_BP_Group.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_BP_Group_ID(foreignEntity.get_ID());
		} else {
			super.setC_BP_Group_ID(0);
		}
	}

	/**
	 * Get Business Partner Group.
	 *
	 * @return Business Partner Group
	 */
	@JsonProperty("C_BP_Group")
	public ForeignEntityInput C_BP_Group() {
		return mC_BP_Group;
	}
	/**
	 * Set Payroll Concept Account.
	 *
	 * @param HR_Concept_Acct_ID Payroll Concept Account
	 */

	public void setHR_Concept_Acct_ID(int HR_Concept_Acct_ID) {
		if (get_ID() == 0) {
			super.setHR_Concept_Acct_ID(HR_Concept_Acct_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setHR_Concept_Acct_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getHR_Concept_Acct_UU();
	}

	/**
	 * Set Payroll Concept.
	 *
	 * @param HR_Concept Payroll Concept
	 */
	@JsonProperty("HR_Concept")
	public void setHR_ConceptInput(ForeignEntityInput HR_Concept) {
		this.mHR_Concept = HR_Concept;
		X_HR_Concept foreignEntity;
		if (get_ID() == 0 && HR_Concept != null &&
				(foreignEntity = new Query(getCtx(), "HR_Concept", "HR_Concept_UU=?", get_TrxName())
						.setParameters(HR_Concept.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setHR_Concept_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Payroll Concept.
	 *
	 * @return Payroll Concept
	 */
	@JsonProperty("HR_Concept")
	public ForeignEntityInput HR_Concept() {
		return mHR_Concept;
	}

	/**
	 * Set Payroll Expense Account.
	 *
	 * @param HR_Expense_A Payroll Expense Account
	 */
	@JsonProperty("HR_Expense_A")
	public void setHR_Expense_AInput(ForeignEntityInput HR_Expense_A) {
		this.mHR_Expense_A = HR_Expense_A;
		MAccount foreignEntity;
		if (HR_Expense_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
						.setParameters(HR_Expense_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setHR_Expense_Acct(foreignEntity.get_ID());
		} else {
			super.setHR_Expense_Acct(0);
		}
	}

	/**
	 * Get Payroll Expense Account.
	 *
	 * @return Payroll Expense Account
	 */
	@JsonProperty("HR_Expense_A")
	public ForeignEntityInput HR_Expense_A() {
		return mHR_Expense_A;
	}

	/**
	 * Set Payroll Revenue Account.
	 *
	 * @param HR_Revenue_A Payroll Revenue Account
	 */
	@JsonProperty("HR_Revenue_A")
	public void setHR_Revenue_AInput(ForeignEntityInput HR_Revenue_A) {
		this.mHR_Revenue_A = HR_Revenue_A;
		MAccount foreignEntity;
		if (HR_Revenue_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
						.setParameters(HR_Revenue_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setHR_Revenue_Acct(foreignEntity.get_ID());
		} else {
			super.setHR_Revenue_Acct(0);
		}
	}

	/**
	 * Get Payroll Revenue Account.
	 *
	 * @return Payroll Revenue Account
	 */
	@JsonProperty("HR_Revenue_A")
	public ForeignEntityInput HR_Revenue_A() {
		return mHR_Revenue_A;
	}

	/**
	 * Set User Element List 1.
	 *
	 * @param User1 User defined list element #1
	 */
	@JsonProperty("User1")
	public void setUser1Input(ForeignEntityInput User1) {
		this.mUser1 = User1;
		MElementValue foreignEntity;
		if (User1 != null &&
				(foreignEntity = new Query(getCtx(), "C_ElementValue", "C_ElementValue_UU=?", get_TrxName())
						.setParameters(User1.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setUser1_ID(foreignEntity.get_ID());
		} else {
			super.setUser1_ID(0);
		}
	}

	/**
	 * Get User Element List 1.
	 *
	 * @return User defined list element #1
	 */
	@JsonProperty("User1")
	public ForeignEntityInput User1() {
		return mUser1;
	}

	/**
	 * Set User Element List 2.
	 *
	 * @param User2 User defined list element #2
	 */
	@JsonProperty("User2")
	public void setUser2Input(ForeignEntityInput User2) {
		this.mUser2 = User2;
		MAccount foreignEntity;
		if (User2 != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
						.setParameters(User2.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setUser2_ID(foreignEntity.get_ID());
		} else {
			super.setUser2_ID(0);
		}
	}

	/**
	 * Get User Element List 2.
	 *
	 * @return User defined list element #2
	 */
	@JsonProperty("User2")
	public ForeignEntityInput User2() {
		return mUser2;
	}
}
