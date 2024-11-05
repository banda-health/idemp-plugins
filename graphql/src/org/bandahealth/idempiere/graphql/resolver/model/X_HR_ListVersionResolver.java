package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_HR_ListDataLoader;
import org.dataloader.DataLoader;
import org.eevolution.model.X_HR_List;
import org.eevolution.model.X_HR_ListVersion;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for HR_ListVersion - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_HR_ListVersionResolver extends POResolver<X_HR_ListVersion> implements GraphQLResolver<X_HR_ListVersion> {



	/**
	 * Get Payroll List.
	 *
	 * @return Payroll List
	 */
	public CompletableFuture<X_HR_List> HR_List(X_HR_ListVersion entity, DataFetchingEnvironment environment) {
		if (entity.getHR_List_ID() < 1) {
			return null;
		}
		DataLoader<Integer, X_HR_List> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_HR_ListDataLoader.DATALOADER_HR_List_BY_ID);
		return dataLoader.load(entity.getHR_List_ID());
	}


	/**
	 * Get Payroll List Base.
	 *
	 * @return Payroll List Base
	 */
	public CompletableFuture<X_HR_List> HR_ListBase(X_HR_ListVersion entity, DataFetchingEnvironment environment) {
		if (entity.getHR_ListBase_ID() < 1) {
			return null;
		}
		DataLoader<Integer, X_HR_List> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_HR_ListDataLoader.DATALOADER_HR_List_BY_ID);
		return dataLoader.load(entity.getHR_ListBase_ID());
	}

}
