package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.compiere.model.MEntityType;
import org.dataloader.DataLoader;

/**
 * Generated ModelResolver for AD_EntityType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_EntityTypeResolver extends POResolver<MEntityType> implements GraphQLResolver<MEntityType> {


	public Boolean Processing(MEntityType entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

}
