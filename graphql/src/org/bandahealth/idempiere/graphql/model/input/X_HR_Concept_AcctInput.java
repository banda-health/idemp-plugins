package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBPGroup_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAccount;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MElementValue;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.eevolution.model.X_HR_Concept;
import org.eevolution.model.X_HR_Concept_Acct;

import java.sql.ResultSet;

/**
 * Generated Model for HR_Concept_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
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
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The HR_Concept_Acct_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_HR_Concept_AcctInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new X_HR_Concept_Acct(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
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
		MOrg foreignEntity;
		if (get_ID() == 0 && AD_Org != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
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
		if (C_AcctSchema != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_AcctSchema", "C_AcctSchema_UU=?", get_TrxName())
							.setParameters(C_AcctSchema.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_AcctSchema_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_AcctSchema with UUID " + C_AcctSchema.getUUID());
			}
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
		if (C_BP_Group != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_BP_Group", "C_BP_Group_UU=?", get_TrxName())
							.setParameters(C_BP_Group.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_BP_Group_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BP_Group with UUID " + C_BP_Group.getUUID());
			}
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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setHR_Concept_Acct_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
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
		if (get_ID() == 0 && HR_Concept != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "HR_Concept", "HR_Concept_UU=?", get_TrxName())
							.setParameters(HR_Concept.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setHR_Concept_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table HR_Concept with UUID " + HR_Concept.getUUID());
			}
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
		if (HR_Expense_A != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(HR_Expense_A.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setHR_Expense_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + HR_Expense_A.getUUID());
			}
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
		if (HR_Revenue_A != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(HR_Revenue_A.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setHR_Revenue_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + HR_Revenue_A.getUUID());
			}
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
		if (User1 != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_ElementValue", "C_ElementValue_UU=?", get_TrxName())
							.setParameters(User1.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setUser1_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ElementValue with UUID " + User1.getUUID());
			}
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
		if (User2 != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(User2.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setUser2_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + User2.getUUID());
			}
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
