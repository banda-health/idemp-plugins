package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_HR_AttributeResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAccount;
import org.compiere.model.MOrg;
import org.compiere.model.MRule;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.eevolution.model.X_HR_Attribute;
import org.eevolution.model.X_HR_Concept;
import org.eevolution.model.X_HR_Department;
import org.eevolution.model.X_HR_Employee;
import org.eevolution.model.X_HR_Job;
import org.eevolution.model.X_HR_Payroll;

import java.sql.ResultSet;

/**
 * Generated Model for HR_Attribute - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_HR_AttributeInput extends X_HR_Attribute implements I_HR_AttributeInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Rule;
	private ForeignEntityInput mC_BPartner;
	private ForeignEntityInput mColumnType;
	private ForeignEntityInput mHR_Attribute_A;
	private ForeignEntityInput mHR_Concept;
	private ForeignEntityInput mHR_Department;
	private ForeignEntityInput mHR_Employee;
	private ForeignEntityInput mHR_Job;
	private ForeignEntityInput mHR_Payroll;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The HR_Attribute_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_HR_AttributeInput(@JsonProperty("UU") String UU) {
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
	 * Set Rule.
	 *
	 * @param AD_Rule Rule
	 */
	@JsonProperty("AD_Rule")
	public void setAD_RuleInput(ForeignEntityInput AD_Rule) {
		this.mAD_Rule = AD_Rule;
		if (AD_Rule != null) {
			// Since an entity was passed, make sure it's in the DB
			MRule foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Rule", "AD_Rule_UU=?", get_TrxName())
							.setParameters(AD_Rule.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Rule_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Rule with UU " + AD_Rule.getUU());
			}
		} else {
			this.setAD_Rule_ID(0);
		}
	}

	/**
	 * Get Rule.
	 *
	 * @return Rule
	 */
	@JsonProperty("AD_Rule")
	public ForeignEntityInput AD_Rule() {
		return mAD_Rule;
	}

	/**
	 * Set Business Partner.
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public void setC_BPartnerInput(ForeignEntityInput C_BPartner) {
		this.mC_BPartner = C_BPartner;
		if (C_BPartner != null) {
			// Since an entity was passed, make sure it's in the DB
			MBPartner_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_BPartner", "C_BPartner_UU=?", get_TrxName())
							.setParameters(C_BPartner.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_BPartner_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BPartner with UU " + C_BPartner.getUU());
			}
		} else {
			this.setC_BPartner_ID(0);
		}
	}

	/**
	 * Get Business Partner.
	 *
	 * @return Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public ForeignEntityInput C_BPartner() {
		return mC_BPartner;
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
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_HR_AttributeResolver.COLUMNTYPE_UUIDS_BY_VALUE.containsValue(ColumnType.getUU())) {
				throw new AdempiereException("The reference list UU of " + ColumnType.getUU() +
						" is not in the list defined for the ColumnType column");
			}
			// Now make sure it's in the DB
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
	 * Set Payroll Attribute Account.
	 *
	 * @param HR_Attribute_A Payroll Attribute Account
	 */
	@JsonProperty("HR_Attribute_A")
	public void setHR_Attribute_AInput(ForeignEntityInput HR_Attribute_A) {
		this.mHR_Attribute_A = HR_Attribute_A;
		if (HR_Attribute_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(HR_Attribute_A.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setHR_Attribute_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UU " + HR_Attribute_A.getUU());
			}
		} else {
			this.setHR_Attribute_Acct(0);
		}
	}

	/**
	 * Get Payroll Attribute Account.
	 *
	 * @return Payroll Attribute Account
	 */
	@JsonProperty("HR_Attribute_A")
	public ForeignEntityInput HR_Attribute_A() {
		return mHR_Attribute_A;
	}
	/**
	 * Set Payroll Employee Attribute.
	 *
	 * @param HR_Attribute_ID Payroll Employee Attribute
	 */
	@JsonProperty("HR_Attribute_ID")
	public void setHR_Attribute_IDFromJson(int HR_Attribute_ID) {
		if (get_ID() == 0) {
			super.setHR_Attribute_ID(HR_Attribute_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setHR_Attribute_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getHR_Attribute_UU();
	}

	/**
	 * Set Payroll Concept.
	 *
	 * @param HR_Concept Payroll Concept
	 */
	@JsonProperty("HR_Concept")
	public void setHR_ConceptInput(ForeignEntityInput HR_Concept) {
		this.mHR_Concept = HR_Concept;
		if (get_ID() != 0) {
			return;
		}
		if (HR_Concept != null) {
			// Since an entity was passed, make sure it's in the DB
			X_HR_Concept foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "HR_Concept", "HR_Concept_UU=?", get_TrxName())
							.setParameters(HR_Concept.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setHR_Concept_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table HR_Concept with UU " + HR_Concept.getUU());
			}
		} else {
			this.setHR_Concept_ID(0);
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
	 * Set Payroll Employee.
	 *
	 * @param HR_Employee Payroll Employee
	 */
	@JsonProperty("HR_Employee")
	public void setHR_EmployeeInput(ForeignEntityInput HR_Employee) {
		this.mHR_Employee = HR_Employee;
		if (HR_Employee != null) {
			// Since an entity was passed, make sure it's in the DB
			X_HR_Employee foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "HR_Employee", "HR_Employee_UU=?", get_TrxName())
							.setParameters(HR_Employee.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setHR_Employee_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table HR_Employee with UU " + HR_Employee.getUU());
			}
		} else {
			this.setHR_Employee_ID(0);
		}
	}

	/**
	 * Get Payroll Employee.
	 *
	 * @return Payroll Employee
	 */
	@JsonProperty("HR_Employee")
	public ForeignEntityInput HR_Employee() {
		return mHR_Employee;
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
}
