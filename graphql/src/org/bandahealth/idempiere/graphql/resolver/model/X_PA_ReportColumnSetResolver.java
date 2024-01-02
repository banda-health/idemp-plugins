package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.compiere.model.X_PA_ReportColumnSet;
import org.dataloader.DataLoader;

/**
 * Generated ModelResolver for PA_ReportColumnSet - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_ReportColumnSetResolver extends POResolver<X_PA_ReportColumnSet> implements GraphQLResolver<X_PA_ReportColumnSet> {


	public Boolean Processing(X_PA_ReportColumnSet entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

}
