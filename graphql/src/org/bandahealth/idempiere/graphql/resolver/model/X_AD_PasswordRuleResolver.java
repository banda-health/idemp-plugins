package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.compiere.model.MPasswordRule;
import org.dataloader.DataLoader;

/**
 * Generated ModelResolver for AD_PasswordRule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_PasswordRuleResolver extends POResolver<MPasswordRule> implements GraphQLResolver<MPasswordRule> {


	public Boolean IsDictMatchBackwards(MPasswordRule entity, DataFetchingEnvironment environment) {
		return entity.isDictMatchBackwards();
	}

	public Boolean IsUserNameRule(MPasswordRule entity, DataFetchingEnvironment environment) {
		return entity.isUserNameRule();
	}

	public Boolean IsUsingDictionary(MPasswordRule entity, DataFetchingEnvironment environment) {
		return entity.isUsingDictionary();
	}

	public Boolean IsWhitespace(MPasswordRule entity, DataFetchingEnvironment environment) {
		return entity.isWhitespace();
	}

}
