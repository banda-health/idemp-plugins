package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHFieldRule;
import org.dataloader.DataLoader;

/**
 * Generated ModelResolver for BH_Field_Rule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Field_RuleResolver extends POResolver<MBHFieldRule> implements GraphQLResolver<MBHFieldRule> {


	public Boolean BH_Required(MBHFieldRule entity, DataFetchingEnvironment environment) {
		return entity.isBH_Required();
	}

}
