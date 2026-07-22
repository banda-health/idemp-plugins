package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHPayrollAudit;
import org.bandahealth.idempiere.base.model.MBHPayrollRun;
import org.bandahealth.idempiere.base.model.MHREmployee_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_RoleDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_Payroll_RunDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_HR_EmployeeDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.X_AD_Role;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for BH_Payroll_Audit - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Payroll_AuditResolver extends POResolver<MBHPayrollAudit> implements GraphQLResolver<MBHPayrollAudit> {


	public static Map<String, String> BH_ACTIONTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("PERIOD_LOCK", "eae528e0-0848-43bf-92eb-0cf452865877"); // Period locked
			put("PERIOD_UNLOCK", "541fa9d9-5bb0-402b-9364-7196b6c9ef9c"); // Period unlocked
			put("COMPONENT_CHANGE", "91a02eec-0df1-436b-b080-b7c5811eca29"); // Component changed
			put("EMPLOYEE_ADD", "68aea2ae-9fce-434c-9a76-124dccd51b7c"); // Employee added
			put("EMPLOYEE_EDIT", "8e160eb1-e2ad-40ab-8677-ccb227522931"); // Employee edited
			put("EMPLOYEE_DEACTIVATE", "9c3b07a9-e5ce-42de-89a0-dc260ca52a98"); // Employee deactivated
			put("EMPLOYEE_REACTIVATE", "1cd1726d-28cc-4320-920b-1e6de1d48cb4"); // Employee reactivated
			put("FILING_PAID", "60484350-7c2e-45f7-b087-67f510ab7e3d"); // Filing paid
			put("FILING_REVERSED", "0d28ac84-9cc5-41a8-85a4-e30cbee5740b"); // Filing payment reversed
			put("SETTINGS_CHANGE", "296c4b6f-10cf-47b1-8379-ccda9b2a448e"); // Settings changed
		}
	};

	/**
	 * Get Action Type.
	 *
	 * @return Action Type
	 */
	public CompletableFuture<MRefList_BH> BH_ActionType(MBHPayrollAudit entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getBH_ActionType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(BH_ACTIONTYPE_UUIDS_BY_VALUE.get(entity.getBH_ActionType()));
	}

	/**
	 * Get Role.
	 *
	 * @return Responsibility Role
	 */
	public CompletableFuture<X_AD_Role> AD_Role(MBHPayrollAudit entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Role_ID() < 1) {
			return null;
		}
		DataLoader<Integer, X_AD_Role> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_RoleDataLoader.DATALOADER_AD_Role_BY_ID);
		return dataLoader.load(entity.getAD_Role_ID());
	}

	/**
	 * Get Payroll Run.
	 *
	 * @return Payroll Run
	 */
	public CompletableFuture<MBHPayrollRun> BH_Payroll_Run(MBHPayrollAudit entity, DataFetchingEnvironment environment) {
		if (entity.getBH_Payroll_Run_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBHPayrollRun> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_BH_Payroll_RunDataLoader.DATALOADER_BH_Payroll_Run_BY_ID);
		return dataLoader.load(entity.getBH_Payroll_Run_ID());
	}

	/**
	 * Get Payroll Employee.
	 *
	 * @return Payroll Employee
	 */
	public CompletableFuture<MHREmployee_BH> HR_Employee(MBHPayrollAudit entity, DataFetchingEnvironment environment) {
		if (entity.getHR_Employee_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MHREmployee_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_HR_EmployeeDataLoader.DATALOADER_HR_Employee_BY_ID);
		return dataLoader.load(entity.getHR_Employee_ID());
	}
}
