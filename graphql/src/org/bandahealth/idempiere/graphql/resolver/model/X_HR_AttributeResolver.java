package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MHREmployee_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_RuleDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartnerDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ValidCombinationDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_HR_ConceptDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_HR_DepartmentDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_HR_EmployeeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_HR_JobDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_HR_PayrollDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MAccount;
import org.compiere.model.MRule;
import org.dataloader.DataLoader;
import org.eevolution.model.X_HR_Attribute;
import org.eevolution.model.X_HR_Concept;
import org.eevolution.model.X_HR_Department;
import org.eevolution.model.X_HR_Job;
import org.eevolution.model.X_HR_Payroll;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for HR_Attribute - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_HR_AttributeResolver extends POResolver<X_HR_Attribute> implements GraphQLResolver<X_HR_Attribute> {



	/**
	 * Get Rule.
	 *
	 * @return Rule
	 */
	public CompletableFuture<MRule> AD_Rule(X_HR_Attribute entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Rule_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MRule> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_RuleDataLoader.DATALOADER_AD_Rule_BY_ID);
		return dataLoader.load(entity.getAD_Rule_ID());
	}


	/**
	 * Get Business Partner.
	 *
	 * @return Identifies a Business Partner
	 */
	public CompletableFuture<MBPartner_BH> C_BPartner(X_HR_Attribute entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBPartner_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartnerDataLoader.DATALOADER_C_BPartner_BY_ID);
		return dataLoader.load(entity.getC_BPartner_ID());
	}

	public static Map<String, String> COLUMNTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("A", "46a2b315-1c28-4506-87ae-f00dd7b5f9f4"); // Amount
			put("D", "9e57d0dd-3029-495c-8308-18c4057b54eb"); // Date
			put("Q", "6e737d16-9389-46f0-a70e-29ed51b3262f"); // Quantity
			put("T", "0f97b122-1a18-4aba-b069-11c0ac550e04"); // Text
		}
	};
	public CompletableFuture<MRefList_BH> ColumnType(X_HR_Attribute entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getColumnType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(COLUMNTYPE_UUIDS_BY_VALUE.get(entity.getColumnType()));
	}


	/**
	 * Get Payroll Attribute Account.
	 *
	 * @return Payroll Attribute Account
	 */
	public CompletableFuture<MAccount> HR_Attribute_A(X_HR_Attribute entity, DataFetchingEnvironment environment) {
		if (entity.getHR_Attribute_Acct() < 1) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.DATALOADER_C_ValidCombination_BY_ID);
		return dataLoader.load(entity.getHR_Attribute_Acct());
	}


	/**
	 * Get Payroll Concept.
	 *
	 * @return Payroll Concept
	 */
	public CompletableFuture<X_HR_Concept> HR_Concept(X_HR_Attribute entity, DataFetchingEnvironment environment) {
		if (entity.getHR_Concept_ID() < 1) {
			return null;
		}
		DataLoader<Integer, X_HR_Concept> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_HR_ConceptDataLoader.DATALOADER_HR_Concept_BY_ID);
		return dataLoader.load(entity.getHR_Concept_ID());
	}


	/**
	 * Get Payroll Department.
	 *
	 * @return Payroll Department
	 */
	public CompletableFuture<X_HR_Department> HR_Department(X_HR_Attribute entity, DataFetchingEnvironment environment) {
		if (entity.getHR_Department_ID() < 1) {
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
	public CompletableFuture<MHREmployee_BH> HR_Employee(X_HR_Attribute entity, DataFetchingEnvironment environment) {
		if (entity.getHR_Employee_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MHREmployee_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_HR_EmployeeDataLoader.DATALOADER_HR_Employee_BY_ID);
		return dataLoader.load(entity.getHR_Employee_ID());
	}


	/**
	 * Get Payroll Job.
	 *
	 * @return Payroll Job
	 */
	public CompletableFuture<X_HR_Job> HR_Job(X_HR_Attribute entity, DataFetchingEnvironment environment) {
		if (entity.getHR_Job_ID() < 1) {
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
	public CompletableFuture<X_HR_Payroll> HR_Payroll(X_HR_Attribute entity, DataFetchingEnvironment environment) {
		if (entity.getHR_Payroll_ID() < 1) {
			return null;
		}
		DataLoader<Integer, X_HR_Payroll> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_HR_PayrollDataLoader.DATALOADER_HR_Payroll_BY_ID);
		return dataLoader.load(entity.getHR_Payroll_ID());
	}

	public Boolean IsPrinted(X_HR_Attribute entity, DataFetchingEnvironment environment) {
		return entity.isPrinted();
	}

}
