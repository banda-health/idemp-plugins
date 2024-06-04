package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ActivityDataLoader;
import org.compiere.model.MActivity;
import org.dataloader.DataLoader;
import org.eevolution.model.X_HR_Department;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for HR_Department - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_HR_DepartmentResolver extends POResolver<X_HR_Department> implements GraphQLResolver<X_HR_Department> {



	/**
	 * Get Activity.
	 *
	 * @return Business Activity
	 */
	public CompletableFuture<MActivity> C_Activity(X_HR_Department entity, DataFetchingEnvironment environment) {
		if (entity.getC_Activity_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MActivity> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ActivityDataLoader.DATALOADER_C_Activity_BY_ID);
		return dataLoader.load(entity.getC_Activity_ID());
	}

}
