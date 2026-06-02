package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHFeatureFlag;
import org.dataloader.DataLoader;

/**
 * Generated ModelResolver for BH_Feature_Flag - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Feature_FlagResolver extends POResolver<MBHFeatureFlag> implements GraphQLResolver<MBHFeatureFlag> {


	public Boolean BH_DefaultEnabled(MBHFeatureFlag entity, DataFetchingEnvironment environment) {
		return entity.isBH_DefaultEnabled();
	}

}
