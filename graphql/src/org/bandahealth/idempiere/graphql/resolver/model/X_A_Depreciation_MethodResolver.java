package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.compiere.model.MDepreciationMethod;
import org.dataloader.DataLoader;

/**
 * Generated ModelResolver for A_Depreciation_Method - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_A_Depreciation_MethodResolver extends POResolver<MDepreciationMethod> implements GraphQLResolver<MDepreciationMethod> {


	public Boolean Processed(MDepreciationMethod entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

}
