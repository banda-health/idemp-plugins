package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_HR_DepartmentDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_HR_JobDataLoader;
import org.dataloader.DataLoader;
import org.eevolution.model.X_HR_Department;
import org.eevolution.model.X_HR_Job;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for HR_Job - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_HR_JobResolver extends POResolver<X_HR_Job> implements GraphQLResolver<X_HR_Job> {



	/**
	 * Get Payroll Department.
	 *
	 * @return Payroll Department
	 */
	public CompletableFuture<X_HR_Department> HR_Department(X_HR_Job entity, DataFetchingEnvironment environment) {
		if (entity.getHR_Department_ID() < 1) {
			return null;
		}
		DataLoader<Integer, X_HR_Department> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_HR_DepartmentDataLoader.DATALOADER_HR_Department_BY_ID);
		return dataLoader.load(entity.getHR_Department_ID());
	}

	public Boolean IsParent(X_HR_Job entity, DataFetchingEnvironment environment) {
		return entity.isParent();
	}


	/**
	 * Get Next Job.
	 *
	 * @return Next Job
	 */
	public CompletableFuture<X_HR_Job> Next_Job(X_HR_Job entity, DataFetchingEnvironment environment) {
		if (entity.getNext_Job_ID() < 1) {
			return null;
		}
		DataLoader<Integer, X_HR_Job> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_HR_JobDataLoader.DATALOADER_HR_Job_BY_ID);
		return dataLoader.load(entity.getNext_Job_ID());
	}


	/**
	 * Get Supervisor.
	 *
	 * @return Supervisor for this user/organization - used for escalation and approval
	 */
	public CompletableFuture<MUser_BH> Supervisor(X_HR_Job entity, DataFetchingEnvironment environment) {
		if (entity.getSupervisor_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return dataLoader.load(entity.getSupervisor_ID());
	}

}
