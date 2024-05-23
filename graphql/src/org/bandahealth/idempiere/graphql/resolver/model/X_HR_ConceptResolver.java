package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ReferenceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_HR_Concept_CategoryDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_HR_DepartmentDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_HR_JobDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_HR_PayrollDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.dataloader.DataLoader;
import org.eevolution.model.X_HR_Concept;
import org.eevolution.model.X_HR_Concept_Category;
import org.eevolution.model.X_HR_Department;
import org.eevolution.model.X_HR_Job;
import org.eevolution.model.X_HR_Payroll;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for HR_Concept - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_HR_ConceptResolver extends POResolver<X_HR_Concept> implements GraphQLResolver<X_HR_Concept> {


	static Map<String, String> ACCOUNTSIGN_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("N", "546f7a30-b932-4a00-81c1-6f7cb6fdcbb6");
			put("D", "f494267a-f7e6-49a7-913e-c51e3e093623");
			put("C", "8c58849d-0535-4df8-85a1-508818db6386");
		}
	};
	public CompletableFuture<MRefList_BH> AccountSign(X_HR_Concept entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getAccountSign())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(ACCOUNTSIGN_UUIDS_BY_VALUE.get(entity.getAccountSign()));
	}


	/**
	 * Get Reference.
	 *
	 * @return System Reference and Validation
	 */
	public CompletableFuture<MReference_BH> AD_Reference(X_HR_Concept entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Reference_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MReference_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ReferenceDataLoader.DATALOADER_AD_Reference_BY_ID);
		return dataLoader.load(entity.getAD_Reference_ID());
	}

	static Map<String, String> COLUMNTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("A", "46a2b315-1c28-4506-87ae-f00dd7b5f9f4");
			put("D", "9e57d0dd-3029-495c-8308-18c4057b54eb");
			put("Q", "6e737d16-9389-46f0-a70e-29ed51b3262f");
			put("T", "0f97b122-1a18-4aba-b069-11c0ac550e04");
		}
	};
	public CompletableFuture<MRefList_BH> ColumnType(X_HR_Concept entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getColumnType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(COLUMNTYPE_UUIDS_BY_VALUE.get(entity.getColumnType()));
	}


	/**
	 * Get Payroll Concept Category.
	 *
	 * @return Payroll Concept Category
	 */
	public CompletableFuture<X_HR_Concept_Category> HR_Concept_Category(X_HR_Concept entity, DataFetchingEnvironment environment) {
		if (entity.getHR_Concept_Category_ID() < 0) {
			return null;
		}
		DataLoader<Integer, X_HR_Concept_Category> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_HR_Concept_CategoryDataLoader.DATALOADER_HR_Concept_Category_BY_ID);
		return dataLoader.load(entity.getHR_Concept_Category_ID());
	}


	/**
	 * Get Payroll Department.
	 *
	 * @return Payroll Department
	 */
	public CompletableFuture<X_HR_Department> HR_Department(X_HR_Concept entity, DataFetchingEnvironment environment) {
		if (entity.getHR_Department_ID() < 0) {
			return null;
		}
		DataLoader<Integer, X_HR_Department> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_HR_DepartmentDataLoader.DATALOADER_HR_Department_BY_ID);
		return dataLoader.load(entity.getHR_Department_ID());
	}


	/**
	 * Get Payroll Job.
	 *
	 * @return Payroll Job
	 */
	public CompletableFuture<X_HR_Job> HR_Job(X_HR_Concept entity, DataFetchingEnvironment environment) {
		if (entity.getHR_Job_ID() < 0) {
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
	public CompletableFuture<X_HR_Payroll> HR_Payroll(X_HR_Concept entity, DataFetchingEnvironment environment) {
		if (entity.getHR_Payroll_ID() < 0) {
			return null;
		}
		DataLoader<Integer, X_HR_Payroll> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_HR_PayrollDataLoader.DATALOADER_HR_Payroll_BY_ID);
		return dataLoader.load(entity.getHR_Payroll_ID());
	}

	public Boolean IsDefault(X_HR_Concept entity, DataFetchingEnvironment environment) {
		return entity.isDefault();
	}

	public Boolean IsEmployee(X_HR_Concept entity, DataFetchingEnvironment environment) {
		return entity.isEmployee();
	}

	public Boolean IsPaid(X_HR_Concept entity, DataFetchingEnvironment environment) {
		return entity.isPaid();
	}

	public Boolean IsPrinted(X_HR_Concept entity, DataFetchingEnvironment environment) {
		return entity.isPrinted();
	}

	public Boolean IsReadWrite(X_HR_Concept entity, DataFetchingEnvironment environment) {
		return entity.isReadWrite();
	}

	public Boolean IsReceipt(X_HR_Concept entity, DataFetchingEnvironment environment) {
		return entity.isReceipt();
	}

	public Boolean IsRegistered(X_HR_Concept entity, DataFetchingEnvironment environment) {
		return entity.isRegistered();
	}

	static Map<String, String> TYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("C", "88c43475-159c-4c6d-92e6-d084ce4e4b7e");
			put("E", "84c7f0b8-39a3-41c6-9e75-1f66775d2a79");
			put("I", "7dc1dfee-4aa3-407f-addf-b467e1853006");
			put("R", "e462d931-e643-4f36-b8ac-e429a872046c");
		}
	};
	public CompletableFuture<MRefList_BH> Type(X_HR_Concept entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(TYPE_UUIDS_BY_VALUE.get(entity.getType()));
	}

}
