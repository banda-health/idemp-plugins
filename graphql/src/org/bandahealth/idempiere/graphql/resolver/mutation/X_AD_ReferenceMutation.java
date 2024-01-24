package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.graphql.model.input.I_AD_ReferenceInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_ReferenceInput;

import java.util.List;

/**
 * Generated Query Resolver for AD_Reference - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_ReferenceMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_ReferenceInput.Table_Name;
	}

	public MReference_BH AD_ReferenceSave(I_AD_ReferenceInput input, DataFetchingEnvironment environment) {
		return (MReference_BH) super.save((X_AD_ReferenceInput) input, environment);
	}

	public boolean AD_ReferenceDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
