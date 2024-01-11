package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_HR_ListVersionDataLoader;
import org.dataloader.DataLoader;
import org.eevolution.model.X_HR_ListLine;
import org.eevolution.model.X_HR_ListVersion;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for HR_ListLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_HR_ListLineResolver extends POResolver<X_HR_ListLine> implements GraphQLResolver<X_HR_ListLine> {



	/**
	 * Get Payroll List Version.
	 *
	 * @return Payroll List Version
	 */
	public CompletableFuture<X_HR_ListVersion> HR_ListVersion(X_HR_ListLine entity, DataFetchingEnvironment environment) {
		if (entity.getHR_ListVersion_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_HR_ListVersion> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_HR_ListVersionDataLoader.HR_ListVersion_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getHR_ListVersion_ID());
	}

}
