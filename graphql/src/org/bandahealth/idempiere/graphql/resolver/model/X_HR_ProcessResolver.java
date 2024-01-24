package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_PrintFormatDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_WorkflowDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartnerDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ChargeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_DocTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_PaySelectionDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_HR_DepartmentDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_HR_EmployeeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_HR_JobDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_HR_PayrollDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_HR_PeriodDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_HR_ProcessDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MPaySelection;
import org.compiere.model.X_AD_PrintFormat;
import org.compiere.model.X_AD_Workflow;
import org.dataloader.DataLoader;
import org.eevolution.model.X_HR_Department;
import org.eevolution.model.X_HR_Employee;
import org.eevolution.model.X_HR_Job;
import org.eevolution.model.X_HR_Payroll;
import org.eevolution.model.X_HR_Period;
import org.eevolution.model.X_HR_Process;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for HR_Process - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_HR_ProcessResolver extends POResolver<X_HR_Process> implements GraphQLResolver<X_HR_Process> {



	/**
	 * Get Print Format.
	 *
	 * @return Data Print Format
	 */
	public CompletableFuture<X_AD_PrintFormat> AD_PrintFormat(X_HR_Process entity, DataFetchingEnvironment environment) {
		if (entity.getAD_PrintFormat_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_PrintFormat> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PrintFormatDataLoader.DATALOADER_AD_PrintFormat_BY_ID);
		return dataLoader.load(entity.getAD_PrintFormat_ID());
	}


	/**
	 * Get Workflow.
	 *
	 * @return Workflow or combination of tasks
	 */
	public CompletableFuture<X_AD_Workflow> AD_Workflow(X_HR_Process entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Workflow_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_Workflow> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_WorkflowDataLoader.DATALOADER_AD_Workflow_BY_ID);
		return dataLoader.load(entity.getAD_Workflow_ID());
	}


	/**
	 * Get Business Partner .
	 *
	 * @return Identifies a Business Partner
	 */
	public CompletableFuture<MBPartner_BH> C_BPartner(X_HR_Process entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBPartner_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartnerDataLoader.DATALOADER_C_BPartner_BY_ID);
		return dataLoader.load(entity.getC_BPartner_ID());
	}


	/**
	 * Get Charge.
	 *
	 * @return Additional document charges
	 */
	public CompletableFuture<MCharge_BH> C_Charge(X_HR_Process entity, DataFetchingEnvironment environment) {
		if (entity.getC_Charge_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCharge_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ChargeDataLoader.DATALOADER_C_Charge_BY_ID);
		return dataLoader.load(entity.getC_Charge_ID());
	}


	/**
	 * Get Document Type.
	 *
	 * @return Document type or rules
	 */
	public CompletableFuture<MDocType_BH> C_DocType(X_HR_Process entity, DataFetchingEnvironment environment) {
		if (entity.getC_DocType_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MDocType_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_DocTypeDataLoader.DATALOADER_C_DocType_BY_ID);
		return dataLoader.load(entity.getC_DocType_ID());
	}


	/**
	 * Get Target Document Type.
	 *
	 * @return Target document type for conversing documents
	 */
	public CompletableFuture<MDocType_BH> C_DocTypeTarget(X_HR_Process entity, DataFetchingEnvironment environment) {
		if (entity.getC_DocTypeTarget_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MDocType_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_DocTypeDataLoader.DATALOADER_C_DocType_BY_ID);
		return dataLoader.load(entity.getC_DocTypeTarget_ID());
	}


	/**
	 * Get Payment Selection.
	 *
	 * @return Payment Selection
	 */
	public CompletableFuture<MPaySelection> C_PaySelection(X_HR_Process entity, DataFetchingEnvironment environment) {
		if (entity.getC_PaySelection_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MPaySelection> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_PaySelectionDataLoader.DATALOADER_C_PaySelection_BY_ID);
		return dataLoader.load(entity.getC_PaySelection_ID());
	}

	static Map<String, String> DOCACTION_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("CO", "74a9fe55-28e4-4d3b-98aa-02ad6d1a12da");
			put("AP", "f80665a4-0db1-4609-be56-5d69b762d169");
			put("RJ", "8fffbfd1-560a-4a78-9181-e5b76bbb3354");
			put("PO", "0fe1c0e9-2ca1-48f2-837b-a4ff16c629d9");
			put("VO", "930f9be7-85bc-4002-83a6-fe4e1b8cfce3");
			put("CL", "d0a6de04-9c59-4d37-998d-f8070db820b0");
			put("RC", "597e3e98-f1cd-4157-885a-1fae6424a3a6");
			put("RA", "1a3904b9-86bc-4831-a4af-0281dcafa8f8");
			put("IN", "69ff146b-fe0e-44a0-98d1-80b2f7958edf");
			put("RE", "c8f55635-67a3-42ae-b626-2064acb2e260");
			put("--", "ea523fb8-e21b-4a77-a657-6f5a7d12a591");
			put("PR", "b6f04b4b-6034-4490-83ed-d0f4f9cb5f76");
			put("XL", "b2d93bde-a7e7-43f0-9b1c-82527992f6d5");
			put("WC", "2143c53d-f6a6-4da6-8fe6-4ce4b6dacac0");
		}
	};
	public CompletableFuture<MRefList_BH> DocAction(X_HR_Process entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getDocAction())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(DOCACTION_UUIDS_BY_VALUE.get(entity.getDocAction()));
	}

	static Map<String, String> DOCSTATUS_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("DR", "d27f8a6b-e8b5-4fea-a6b2-3e7049c473ec");
			put("CO", "50702660-bbfc-422a-8acc-5ed3a2dce204");
			put("AP", "a838dad1-b7fc-4b26-9d80-d45f2d8484c5");
			put("NA", "c8c414ee-3e4e-480b-aa0e-bc6c1d100bd2");
			put("VO", "d35dfd1d-1eb2-46ef-ab2f-23973d68a570");
			put("IN", "c2d506ba-1916-4ca2-abde-da3127c11d77");
			put("RE", "029a78cf-d45c-4fb2-a6c9-fb92c2311af6");
			put("CL", "ab9df095-8aa8-4338-98b6-4b09ab9d459e");
			put("??", "0b6ed143-fad9-4ba2-824c-b3a89b9bb2d2");
			put("IP", "9f864275-6135-452f-a5a7-9377d9ed32bc");
			put("WP", "4a9871d9-ec70-489f-aca5-05adb7e61df9");
			put("WC", "56264c44-b530-4a53-b07b-6fb203ff61a6");
		}
	};
	public CompletableFuture<MRefList_BH> DocStatus(X_HR_Process entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getDocStatus())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(DOCSTATUS_UUIDS_BY_VALUE.get(entity.getDocStatus()));
	}


	/**
	 * Get Payroll Department.
	 *
	 * @return Payroll Department
	 */
	public CompletableFuture<X_HR_Department> HR_Department(X_HR_Process entity, DataFetchingEnvironment environment) {
		if (entity.getHR_Department_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_HR_Department> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_HR_DepartmentDataLoader.DATALOADER_HR_Department_BY_ID);
		return dataLoader.load(entity.getHR_Department_ID());
	}


	/**
	 * Get Payroll Employee.
	 *
	 * @return Payroll Employee
	 */
	public CompletableFuture<X_HR_Employee> HR_Employee(X_HR_Process entity, DataFetchingEnvironment environment) {
		if (entity.getHR_Employee_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_HR_Employee> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_HR_EmployeeDataLoader.DATALOADER_HR_Employee_BY_ID);
		return dataLoader.load(entity.getHR_Employee_ID());
	}


	/**
	 * Get Payroll Job.
	 *
	 * @return Payroll Job
	 */
	public CompletableFuture<X_HR_Job> HR_Job(X_HR_Process entity, DataFetchingEnvironment environment) {
		if (entity.getHR_Job_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_HR_Job> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_HR_JobDataLoader.DATALOADER_HR_Job_BY_ID);
		return dataLoader.load(entity.getHR_Job_ID());
	}


	/**
	 * Get Payroll.
	 *
	 * @return Payroll
	 */
	public CompletableFuture<X_HR_Payroll> HR_Payroll(X_HR_Process entity, DataFetchingEnvironment environment) {
		if (entity.getHR_Payroll_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_HR_Payroll> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_HR_PayrollDataLoader.DATALOADER_HR_Payroll_BY_ID);
		return dataLoader.load(entity.getHR_Payroll_ID());
	}


	/**
	 * Get Payroll Period.
	 *
	 * @return Payroll Period
	 */
	public CompletableFuture<X_HR_Period> HR_Period(X_HR_Process entity, DataFetchingEnvironment environment) {
		if (entity.getHR_Period_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_HR_Period> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_HR_PeriodDataLoader.DATALOADER_HR_Period_BY_ID);
		return dataLoader.load(entity.getHR_Period_ID());
	}

	public Boolean Posted(X_HR_Process entity, DataFetchingEnvironment environment) {
		return entity.isPosted();
	}

	public Boolean Processed(X_HR_Process entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

	public Boolean Processing(X_HR_Process entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}


	/**
	 * Get Reversal ID.
	 *
	 * @return ID of document reversal
	 */
	public CompletableFuture<X_HR_Process> Reversal(X_HR_Process entity, DataFetchingEnvironment environment) {
		if (entity.getReversal_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_HR_Process> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_HR_ProcessDataLoader.DATALOADER_HR_Process_BY_ID);
		return dataLoader.load(entity.getReversal_ID());
	}

}
