package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_JobDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_RemunerationDataLoader;
import org.compiere.model.X_C_Job;
import org.compiere.model.X_C_JobRemuneration;
import org.compiere.model.X_C_Remuneration;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_JobRemuneration - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_JobRemunerationResolver extends POResolver<X_C_JobRemuneration> implements GraphQLResolver<X_C_JobRemuneration> {



	/**
	 * Get Position.
	 *
	 * @return Job Position
	 */
	public CompletableFuture<X_C_Job> C_Job(X_C_JobRemuneration entity, DataFetchingEnvironment environment) {
		if (entity.getC_Job_ID() < 0) {
			return null;
		}
		DataLoader<Integer, X_C_Job> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_JobDataLoader.DATALOADER_C_Job_BY_ID);
		return dataLoader.load(entity.getC_Job_ID());
	}


	/**
	 * Get Remuneration.
	 *
	 * @return Wage or Salary
	 */
	public CompletableFuture<X_C_Remuneration> C_Remuneration(X_C_JobRemuneration entity, DataFetchingEnvironment environment) {
		if (entity.getC_Remuneration_ID() < 0) {
			return null;
		}
		DataLoader<Integer, X_C_Remuneration> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_RemunerationDataLoader.DATALOADER_C_Remuneration_BY_ID);
		return dataLoader.load(entity.getC_Remuneration_ID());
	}

}
