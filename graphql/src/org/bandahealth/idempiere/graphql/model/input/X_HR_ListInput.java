package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
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
 * @version Release 8.2 - $Id$
 */
public class X_HR_ListInput extends X_HR_List implements I_HR_ListInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mHR_Department;
	private ForeignEntityInput mHR_Employee;
	private ForeignEntityInput mHR_ListType;
	private ForeignEntityInput mHR_Payroll;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_HR_ListInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_HR_List(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Payroll Department.
	 *
	 * @param HR_Department Payroll Department
	 */
	@JsonProperty("HR_Department")
	public void setHR_DepartmentInput(ForeignEntityInput HR_Department) {
		this.mHR_Department = HR_Department;
		X_HR_Department foreignEntity;
		if (HR_Department != null &&
				(foreignEntity = new Query(getCtx(), "HR_Department", "HR_Department_UU=?", get_TrxName())
						.setParameters(HR_Department.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setHR_Department_ID(foreignEntity.get_ID());
		} else {
			super.setHR_Department_ID(0);
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
		X_HR_Employee foreignEntity;
		if (HR_Employee != null &&
				(foreignEntity = new Query(getCtx(), "HR_Employee", "HR_Employee_UU=?", get_TrxName())
						.setParameters(HR_Employee.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setHR_Employee_ID(foreignEntity.get_ID());
		} else {
			super.setHR_Employee_ID(0);
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

	public void setHR_List_ID(int HR_List_ID) {
		if (get_ID() == 0) {
			super.setHR_List_ID(HR_List_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setHR_List_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
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
		X_HR_ListType foreignEntity;
		if (HR_ListType != null &&
				(foreignEntity = new Query(getCtx(), "HR_ListType", "HR_ListType_UU=?", get_TrxName())
						.setParameters(HR_ListType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setHR_ListType_ID(foreignEntity.get_ID());
		} else {
			super.setHR_ListType_ID(0);
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
		X_HR_Payroll foreignEntity;
		if (HR_Payroll != null &&
				(foreignEntity = new Query(getCtx(), "HR_Payroll", "HR_Payroll_UU=?", get_TrxName())
						.setParameters(HR_Payroll.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setHR_Payroll_ID(foreignEntity.get_ID());
		} else {
			super.setHR_Payroll_ID(0);
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
