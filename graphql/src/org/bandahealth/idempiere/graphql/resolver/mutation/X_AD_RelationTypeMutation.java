package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_RelationTypeInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_RelationTypeInput;
import org.compiere.model.X_AD_RelationType;

import java.util.List;

/**
 * Generated Query Resolver for AD_RelationType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_RelationTypeMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_RelationTypeInput.Table_Name;
	}

	public X_AD_RelationType AD_RelationTypeSave(I_AD_RelationTypeInput input, DataFetchingEnvironment environment) {
		return (X_AD_RelationType) super.save((X_AD_RelationTypeInput) input, environment);
	}

	public boolean AD_RelationTypeDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
