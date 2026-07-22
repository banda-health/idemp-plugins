package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBHEmployeeComponent;
import org.bandahealth.idempiere.base.model.MBHPayrollComponent;
import org.bandahealth.idempiere.base.model.MHREmployee_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for BH_Employee_Component - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Employee_ComponentInput extends MBHEmployeeComponent implements I_BH_Employee_ComponentInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mBH_Payroll_Component;
	private ForeignEntityInput mHR_Employee;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The BH_Employee_Component_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_BH_Employee_ComponentInput(@JsonProperty("UU") String UU) {
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
		if (!is_new()) {
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
	 * Set Payroll Component.
	 *
	 * @param BH_Payroll_Component Payroll Component
	 */
	@JsonProperty("BH_Payroll_Component")
	public void setBH_Payroll_ComponentInput(ForeignEntityInput BH_Payroll_Component) {
		this.mBH_Payroll_Component = BH_Payroll_Component;
		if (BH_Payroll_Component != null) {
			// Since an entity was passed, make sure it's in the DB
			MBHPayrollComponent foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "BH_Payroll_Component", "BH_Payroll_Component_UU=?", get_TrxName())
							.setParameters(BH_Payroll_Component.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setBH_Payroll_Component_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table BH_Payroll_Component with UU " + BH_Payroll_Component.getUU());
			}
		} else {
			this.setBH_Payroll_Component_ID(0);
		}
	}

	/**
	 * Get Payroll Component.
	 *
	 * @return Payroll Component
	 */
	@JsonProperty("BH_Payroll_Component")
	public ForeignEntityInput BH_Payroll_Component() {
		return mBH_Payroll_Component;
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
			MHREmployee_BH foreignEntity;
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
	 * Set Employee Payroll Component.
	 *
	 * @param BH_Employee_Component_ID Employee Payroll Component
	 */
	@JsonProperty("BH_Employee_Component_ID")
	public void setBH_Employee_Component_IDFromJson(int BH_Employee_Component_ID) {
		if (get_ID() == 0) {
			super.setBH_Employee_Component_ID(BH_Employee_Component_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setBH_Employee_Component_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getBH_Employee_Component_UU();
	}
}
