package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_InfoRelatedInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_InfoRelatedInput;
import org.compiere.model.X_AD_InfoRelated;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_InfoRelated - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_InfoRelatedMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_InfoRelatedInput.Table_Name;
	}

	public X_AD_InfoRelated AD_InfoRelatedSave(I_AD_InfoRelatedInput entity, DataFetchingEnvironment environment) {
		return (X_AD_InfoRelated) super.save((X_AD_InfoRelatedInput) entity, environment);
	}

	public List<X_AD_InfoRelated> AD_InfoRelatedSaveMany(List<I_AD_InfoRelatedInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_InfoRelatedInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_AD_InfoRelated) entity).collect(Collectors.toList());
	}

	public boolean AD_InfoRelatedDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
