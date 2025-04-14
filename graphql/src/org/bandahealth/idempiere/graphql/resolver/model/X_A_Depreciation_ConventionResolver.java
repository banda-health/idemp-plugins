package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.compiere.model.MDepreciationConvention;
import org.dataloader.DataLoader;

/**
 * Generated ModelResolver for A_Depreciation_Convention - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_A_Depreciation_ConventionResolver extends POResolver<MDepreciationConvention> implements GraphQLResolver<MDepreciationConvention> {


	public Boolean Processed(MDepreciationConvention entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

	public Boolean Processing(MDepreciationConvention entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

}
