package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.compiere.model.MDistributionList;
import org.dataloader.DataLoader;

/**
 * Generated ModelResolver for M_DistributionList - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_DistributionListResolver extends POResolver<MDistributionList> implements GraphQLResolver<MDistributionList> {


	public Boolean Processing(MDistributionList entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

}
