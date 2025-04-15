package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_JobDataLoader;
import org.compiere.model.X_C_Job;
import org.compiere.model.X_C_JobAssignment;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_JobAssignment - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_JobAssignmentResolver extends POResolver<X_C_JobAssignment> implements GraphQLResolver<X_C_JobAssignment> {



	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	public CompletableFuture<MUser_BH> AD_User(X_C_JobAssignment entity, DataFetchingEnvironment environment) {
		if (entity.getAD_User_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return dataLoader.load(entity.getAD_User_ID());
	}


	/**
	 * Get Position.
	 *
	 * @return Job Position
	 */
	public CompletableFuture<X_C_Job> C_Job(X_C_JobAssignment entity, DataFetchingEnvironment environment) {
		if (entity.getC_Job_ID() < 1) {
			return null;
		}
		DataLoader<Integer, X_C_Job> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_JobDataLoader.DATALOADER_C_Job_BY_ID);
		return dataLoader.load(entity.getC_Job_ID());
	}

}
