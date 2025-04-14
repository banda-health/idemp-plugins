package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_JobCategoryDataLoader;
import org.compiere.model.X_C_Job;
import org.compiere.model.X_C_JobCategory;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_Job - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_JobResolver extends POResolver<X_C_Job> implements GraphQLResolver<X_C_Job> {



	/**
	 * Get Position Category.
	 *
	 * @return Job Position Category
	 */
	public CompletableFuture<X_C_JobCategory> C_JobCategory(X_C_Job entity, DataFetchingEnvironment environment) {
		if (entity.getC_JobCategory_ID() < 1) {
			return null;
		}
		DataLoader<Integer, X_C_JobCategory> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_JobCategoryDataLoader.DATALOADER_C_JobCategory_BY_ID);
		return dataLoader.load(entity.getC_JobCategory_ID());
	}

	public Boolean IsEmployee(X_C_Job entity, DataFetchingEnvironment environment) {
		return entity.isEmployee();
	}

}
