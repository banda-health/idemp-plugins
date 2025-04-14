package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.eevolution.model.X_HR_Department;
import org.eevolution.model.X_HR_Employee;
import org.eevolution.model.X_HR_List;
import org.eevolution.model.X_HR_ListType;
import org.eevolution.model.X_HR_Payroll;

import java.sql.ResultSet;

/**
 * Generated Model for HR_List - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_HR_ListInput extends X_HR_List implements I_HR_ListInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mHR_Department;
	private ForeignEntityInput mHR_Employee;
	private ForeignEntityInput mHR_ListType;
	private ForeignEntityInput mHR_Payroll;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The HR_List_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_HR_ListInput(@JsonProperty("UU") String UU) {
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
							.setParameters(HR_Department.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
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
							.setParameters(HR_Employee.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
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
	 * Set Payroll List.
	 *
	 * @param HR_List_ID Payroll List
	 */
	@JsonProperty("HR_List_ID")
	public void setHR_List_IDFromJson(int HR_List_ID) {
		if (get_ID() == 0) {
			super.setHR_List_ID(HR_List_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setHR_List_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getHR_List_UU();
	}

	/**
	 * Set Payroll List Type.
	 *
	 * @param HR_ListType Payroll List Type
	 */
	@JsonProperty("HR_ListType")
	public void setHR_ListTypeInput(ForeignEntityInput HR_ListType) {
		this.mHR_ListType = HR_ListType;
		if (HR_ListType != null) {
			// Since an entity was passed, make sure it's in the DB
			X_HR_ListType foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "HR_ListType", "HR_ListType_UU=?", get_TrxName())
							.setParameters(HR_ListType.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setHR_ListType_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table HR_ListType with UU " + HR_ListType.getUU());
			}
		} else {
			this.setHR_ListType_ID(0);
		}
	}

	/**
	 * Get Payroll List Type.
	 *
	 * @return Payroll List Type
	 */
	@JsonProperty("HR_ListType")
	public ForeignEntityInput HR_ListType() {
		return mHR_ListType;
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
							.setParameters(HR_Payroll.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
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
