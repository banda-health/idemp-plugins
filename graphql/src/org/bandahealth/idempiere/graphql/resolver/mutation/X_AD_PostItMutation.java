package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_PostItInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_PostItInput;
import org.compiere.model.MPostIt;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_PostIt - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_PostItMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_PostItInput.Table_Name;
	}

	public MPostIt AD_PostItSave(I_AD_PostItInput entity, DataFetchingEnvironment environment) {
		return (MPostIt) super.save((X_AD_PostItInput) entity, environment);
	}

	public List<MPostIt> AD_PostItSaveMany(List<I_AD_PostItInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_PostItInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MPostIt) entity).collect(Collectors.toList());
	}

	public boolean AD_PostItDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
