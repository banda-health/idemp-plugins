package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPGroup_BH;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_RuleDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ActivityDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BP_BankAccountDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BP_GroupDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartnerDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CampaignDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ElementValueDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ProjectDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ProjectPhaseDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ProjectTaskDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_HR_ConceptDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_HR_Concept_CategoryDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_HR_DepartmentDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_HR_JobDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_HR_ProcessDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PP_Cost_CollectorDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MActivity;
import org.compiere.model.MBPBankAccount;
import org.compiere.model.MCampaign;
import org.compiere.model.MElementValue;
import org.compiere.model.MProject;
import org.compiere.model.MProjectPhase;
import org.compiere.model.MProjectTask;
import org.compiere.model.MRule;
import org.dataloader.DataLoader;
import org.eevolution.model.X_HR_Concept;
import org.eevolution.model.X_HR_Concept_Category;
import org.eevolution.model.X_HR_Department;
import org.eevolution.model.X_HR_Job;
import org.eevolution.model.X_HR_Movement;
import org.eevolution.model.X_HR_Process;
import org.eevolution.model.X_PP_Cost_Collector;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for HR_Movement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_HR_MovementResolver extends POResolver<X_HR_Movement> implements GraphQLResolver<X_HR_Movement> {


	static Map<String, String> ACCOUNTSIGN_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("N", "546f7a30-b932-4a00-81c1-6f7cb6fdcbb6");
			put("D", "f494267a-f7e6-49a7-913e-c51e3e093623");
			put("C", "8c58849d-0535-4df8-85a1-508818db6386");
		}
	};
	public CompletableFuture<MRefList_BH> AccountSign(X_HR_Movement entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getAccountSign())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(ACCOUNTSIGN_UUIDS_BY_VALUE.get(entity.getAccountSign()));
	}


	/**
	 * Get Rule.
	 *
	 * @return Rule
	 */
	public CompletableFuture<MRule> AD_Rule(X_HR_Movement entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Rule_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MRule> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_RuleDataLoader.AD_Rule_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_Rule_ID());
	}


	/**
	 * Get Activity.
	 *
	 * @return Business Activity
	 */
	public CompletableFuture<MActivity> C_Activity(X_HR_Movement entity, DataFetchingEnvironment environment) {
		if (entity.getC_Activity_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MActivity> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ActivityDataLoader.C_Activity_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Activity_ID());
	}


	/**
	 * Get Partner Bank Account.
	 *
	 * @return Bank Account of the Business Partner
	 */
	public CompletableFuture<MBPBankAccount> C_BP_BankAccount(X_HR_Movement entity, DataFetchingEnvironment environment) {
		if (entity.getC_BP_BankAccount_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBPBankAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BP_BankAccountDataLoader.C_BP_BankAccount_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_BP_BankAccount_ID());
	}


	/**
	 * Get Business Partner Group.
	 *
	 * @return Business Partner Group
	 */
	public CompletableFuture<MBPGroup_BH> C_BP_Group(X_HR_Movement entity, DataFetchingEnvironment environment) {
		if (entity.getC_BP_Group_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBPGroup_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BP_GroupDataLoader.C_BP_Group_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_BP_Group_ID());
	}


	/**
	 * Get Business Partner .
	 *
	 * @return Identifies a Business Partner
	 */
	public CompletableFuture<MBPartner_BH> C_BPartner(X_HR_Movement entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBPartner_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartnerDataLoader.C_BPartner_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_BPartner_ID());
	}


	/**
	 * Get Campaign.
	 *
	 * @return Marketing Campaign
	 */
	public CompletableFuture<MCampaign> C_Campaign(X_HR_Movement entity, DataFetchingEnvironment environment) {
		if (entity.getC_Campaign_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCampaign> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CampaignDataLoader.C_Campaign_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Campaign_ID());
	}


	/**
	 * Get Project.
	 *
	 * @return Financial Project
	 */
	public CompletableFuture<MProject> C_Project(X_HR_Movement entity, DataFetchingEnvironment environment) {
		if (entity.getC_Project_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProject> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ProjectDataLoader.C_Project_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Project_ID());
	}


	/**
	 * Get Project Phase.
	 *
	 * @return Phase of a Project
	 */
	public CompletableFuture<MProjectPhase> C_ProjectPhase(X_HR_Movement entity, DataFetchingEnvironment environment) {
		if (entity.getC_ProjectPhase_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProjectPhase> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ProjectPhaseDataLoader.C_ProjectPhase_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_ProjectPhase_ID());
	}


	/**
	 * Get Project Task.
	 *
	 * @return Actual Project Task in a Phase
	 */
	public CompletableFuture<MProjectTask> C_ProjectTask(X_HR_Movement entity, DataFetchingEnvironment environment) {
		if (entity.getC_ProjectTask_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProjectTask> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ProjectTaskDataLoader.C_ProjectTask_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_ProjectTask_ID());
	}

	static Map<String, String> COLUMNTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("A", "46a2b315-1c28-4506-87ae-f00dd7b5f9f4");
			put("D", "9e57d0dd-3029-495c-8308-18c4057b54eb");
			put("Q", "6e737d16-9389-46f0-a70e-29ed51b3262f");
			put("T", "0f97b122-1a18-4aba-b069-11c0ac550e04");
		}
	};
	public CompletableFuture<MRefList_BH> ColumnType(X_HR_Movement entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getColumnType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(COLUMNTYPE_UUIDS_BY_VALUE.get(entity.getColumnType()));
	}


	/**
	 * Get Payroll Concept Category.
	 *
	 * @return Payroll Concept Category
	 */
	public CompletableFuture<X_HR_Concept_Category> HR_Concept_Category(X_HR_Movement entity, DataFetchingEnvironment environment) {
		if (entity.getHR_Concept_Category_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_HR_Concept_Category> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_HR_Concept_CategoryDataLoader.HR_Concept_Category_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getHR_Concept_Category_ID());
	}


	/**
	 * Get Payroll Concept.
	 *
	 * @return Payroll Concept
	 */
	public CompletableFuture<X_HR_Concept> HR_Concept(X_HR_Movement entity, DataFetchingEnvironment environment) {
		if (entity.getHR_Concept_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_HR_Concept> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_HR_ConceptDataLoader.HR_Concept_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getHR_Concept_ID());
	}


	/**
	 * Get Payroll Department.
	 *
	 * @return Payroll Department
	 */
	public CompletableFuture<X_HR_Department> HR_Department(X_HR_Movement entity, DataFetchingEnvironment environment) {
		if (entity.getHR_Department_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_HR_Department> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_HR_DepartmentDataLoader.HR_Department_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getHR_Department_ID());
	}


	/**
	 * Get Payroll Job.
	 *
	 * @return Payroll Job
	 */
	public CompletableFuture<X_HR_Job> HR_Job(X_HR_Movement entity, DataFetchingEnvironment environment) {
		if (entity.getHR_Job_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_HR_Job> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_HR_JobDataLoader.HR_Job_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getHR_Job_ID());
	}


	/**
	 * Get Payroll Process.
	 *
	 * @return Payroll Process
	 */
	public CompletableFuture<X_HR_Process> HR_Process(X_HR_Movement entity, DataFetchingEnvironment environment) {
		if (entity.getHR_Process_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_HR_Process> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_HR_ProcessDataLoader.HR_Process_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getHR_Process_ID());
	}

	public Boolean IsPrinted(X_HR_Movement entity, DataFetchingEnvironment environment) {
		return entity.isPrinted();
	}

	public Boolean IsRegistered(X_HR_Movement entity, DataFetchingEnvironment environment) {
		return entity.isRegistered();
	}


	/**
	 * Get Manufacturing Cost Collector.
	 *
	 * @return Manufacturing Cost Collector
	 */
	public CompletableFuture<X_PP_Cost_Collector> PP_Cost_Collector(X_HR_Movement entity, DataFetchingEnvironment environment) {
		if (entity.getPP_Cost_Collector_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_PP_Cost_Collector> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PP_Cost_CollectorDataLoader.PP_Cost_Collector_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getPP_Cost_Collector_ID());
	}

	public Boolean Processed(X_HR_Movement entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}


	/**
	 * Get User Element List 1.
	 *
	 * @return User defined list element #1
	 */
	public CompletableFuture<MElementValue> User1(X_HR_Movement entity, DataFetchingEnvironment environment) {
		if (entity.getUser1_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MElementValue> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ElementValueDataLoader.C_ElementValue_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getUser1_ID());
	}


	/**
	 * Get User Element List 2.
	 *
	 * @return User defined list element #2
	 */
	public CompletableFuture<MElementValue> User2(X_HR_Movement entity, DataFetchingEnvironment environment) {
		if (entity.getUser2_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MElementValue> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ElementValueDataLoader.C_ElementValue_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getUser2_ID());
	}

}
