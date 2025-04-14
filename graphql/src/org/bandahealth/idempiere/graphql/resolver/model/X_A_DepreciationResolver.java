package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.compiere.model.MDepreciation;
import org.dataloader.DataLoader;

/**
 * Generated ModelResolver for A_Depreciation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_A_DepreciationResolver extends POResolver<MDepreciation> implements GraphQLResolver<MDepreciation> {


	public Boolean Processed(MDepreciation entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

}
