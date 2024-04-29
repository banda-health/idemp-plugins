package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.eevolution.model.X_HR_Concept;
import org.eevolution.model.X_HR_Concept_Category;
import org.eevolution.model.X_HR_Department;
import org.eevolution.model.X_HR_Job;
import org.eevolution.model.X_HR_Payroll;

import java.sql.ResultSet;

/**
 * Generated Model for HR_Concept - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_HR_ConceptInput extends X_HR_Concept implements I_HR_ConceptInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Reference;
	private ForeignEntityInput mAccountSign;
	private ForeignEntityInput mColumnType;
	private ForeignEntityInput mHR_Concept_Category;
	private ForeignEntityInput mHR_Department;
	private ForeignEntityInput mHR_Job;
	private ForeignEntityInput mHR_Payroll;
	private ForeignEntityInput mType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The HR_Concept_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_HR_ConceptInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}

	/**
	 * Set Account Sign.
	 *
	 * @param AccountSign Indicates the Natural Sign of the Account as a Debit or Credit
	 */
	@JsonProperty("AccountSign")
	public void setAccountSignInput(ForeignEntityInput AccountSign) {
		this.mAccountSign = AccountSign;
		if (AccountSign != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(AccountSign.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAccountSign(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + AccountSign.getUU());
			}
		} else {
			this.setAccountSign(null);
		}
	}

	/**
	 * Get Account Sign.
	 *
	 * @return Indicates the Natural Sign of the Account as a Debit or Credit
	 */
	@JsonProperty("AccountSign")
	public ForeignEntityInput AccountSign() {
		return mAccountSign;
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
	 * Set Reference.
	 *
	 * @param AD_Reference System Reference and Validation
	 */
	@JsonProperty("AD_Reference")
	public void setAD_ReferenceInput(ForeignEntityInput AD_Reference) {
		this.mAD_Reference = AD_Reference;
		if (AD_Reference != null) {
			// Since an entity was passed, make sure it's in the DB
			MReference_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Reference", "AD_Reference_UU=?", get_TrxName())
							.setParameters(AD_Reference.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Reference_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Reference with UU " + AD_Reference.getUU());
			}
		} else {
			this.setAD_Reference_ID(0);
		}
	}

	/**
	 * Get Reference.
	 *
	 * @return System Reference and Validation
	 */
	@JsonProperty("AD_Reference")
	public ForeignEntityInput AD_Reference() {
		return mAD_Reference;
	}

	/**
	 * Set Column Type.
	 *
	 * @param ColumnType Column Type
	 */
	@JsonProperty("ColumnType")
	public void setColumnTypeInput(ForeignEntityInput ColumnType) {
		this.mColumnType = ColumnType;
		if (ColumnType != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(ColumnType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setColumnType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + ColumnType.getUU());
			}
		} else {
			this.setColumnType(null);
		}
	}

	/**
	 * Get Column Type.
	 *
	 * @return Column Type
	 */
	@JsonProperty("ColumnType")
	public ForeignEntityInput ColumnType() {
		return mColumnType;
	}

	/**
	 * Set Payroll Concept Category.
	 *
	 * @param HR_Concept_Category Payroll Concept Category
	 */
	@JsonProperty("HR_Concept_Category")
	public void setHR_Concept_CategoryInput(ForeignEntityInput HR_Concept_Category) {
		this.mHR_Concept_Category = HR_Concept_Category;
		if (HR_Concept_Category != null) {
			// Since an entity was passed, make sure it's in the DB
			X_HR_Concept_Category foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "HR_Concept_Category", "HR_Concept_Category_UU=?", get_TrxName())
							.setParameters(HR_Concept_Category.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setHR_Concept_Category_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table HR_Concept_Category with UU " + HR_Concept_Category.getUU());
			}
		} else {
			this.setHR_Concept_Category_ID(0);
		}
	}

	/**
	 * Get Payroll Concept Category.
	 *
	 * @return Payroll Concept Category
	 */
	@JsonProperty("HR_Concept_Category")
	public ForeignEntityInput HR_Concept_Category() {
		return mHR_Concept_Category;
	}
	/**
	 * Set Payroll Concept.
	 *
	 * @param HR_Concept_ID Payroll Concept
	 */

	public void setHR_Concept_ID(int HR_Concept_ID) {
		if (get_ID() == 0) {
			super.setHR_Concept_ID(HR_Concept_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setHR_Concept_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getHR_Concept_UU();
	}

	/**
	 * Set Payroll Department.
	 *
	 * @param HR_Department Payroll Department
	 */
	@JsonProperty("HR_Department")
	public void setHR_DepartmentInput(ForeignEntityInput HR_Department) {
		this.mHR_Department = HR_Department;
		if (HR_Department != null) {
			// Since an entity was passed, make sure it's in the DB
			X_HR_Department foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "HR_Department", "HR_Department_UU=?", get_TrxName())
							.setParameters(HR_Department.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setHR_Department_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table HR_Department with UU " + HR_Department.getUU());
			}
		} else {
			this.setHR_Department_ID(0);
		}
	}

	/**
	 * Get Payroll Department.
	 *
	 * @return Payroll Department
	 */
	@JsonProperty("HR_Department")
	public ForeignEntityInput HR_Department() {
		return mHR_Department;
	}

	/**
	 * Set Payroll Job.
	 *
	 * @param HR_Job Payroll Job
	 */
	@JsonProperty("HR_Job")
	public void setHR_JobInput(ForeignEntityInput HR_Job) {
		this.mHR_Job = HR_Job;
		if (HR_Job != null) {
			// Since an entity was passed, make sure it's in the DB
			X_HR_Job foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "HR_Job", "HR_Job_UU=?", get_TrxName())
							.setParameters(HR_Job.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setHR_Job_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table HR_Job with UU " + HR_Job.getUU());
			}
		} else {
			this.setHR_Job_ID(0);
		}
	}

	/**
	 * Get Payroll Job.
	 *
	 * @return Payroll Job
	 */
	@JsonProperty("HR_Job")
	public ForeignEntityInput HR_Job() {
		return mHR_Job;
	}

	/**
	 * Set Payroll.
	 *
	 * @param HR_Payroll Payroll
	 */
	@JsonProperty("HR_Payroll")
	public void setHR_PayrollInput(ForeignEntityInput HR_Payroll) {
		this.mHR_Payroll = HR_Payroll;
		if (HR_Payroll != null) {
			// Since an entity was passed, make sure it's in the DB
			X_HR_Payroll foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "HR_Payroll", "HR_Payroll_UU=?", get_TrxName())
							.setParameters(HR_Payroll.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setHR_Payroll_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table HR_Payroll with UU " + HR_Payroll.getUU());
			}
		} else {
			this.setHR_Payroll_ID(0);
		}
	}

	/**
	 * Get Payroll.
	 *
	 * @return Payroll
	 */
	@JsonProperty("HR_Payroll")
	public ForeignEntityInput HR_Payroll() {
		return mHR_Payroll;
	}

	/**
	 * Set Type.
	 *
	 * @param Type Type of Validation (SQL, Java Script, Java Language)
	 */
	@JsonProperty("Type")
	public void setTypeInput(ForeignEntityInput Type) {
		this.mType = Type;
		if (Type != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(Type.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + Type.getUU());
			}
		} else {
			this.setType(null);
		}
	}

	/**
	 * Get Type.
	 *
	 * @return Type of Validation (SQL, Java Script, Java Language)
	 */
	@JsonProperty("Type")
	public ForeignEntityInput Type() {
		return mType;
	}
}
