package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_PostItInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_PostItInput;
import org.compiere.model.MPostIt;

import java.util.List;

/**
 * Generated Query Resolver for AD_PostIt - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_PostItMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_PostItInput.Table_Name;
	}

	public MPostIt AD_PostItSave(I_AD_PostItInput input, DataFetchingEnvironment environment) {
		return (MPostIt) super.save((X_AD_PostItInput) input, environment);
	}

	public boolean AD_PostItDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
