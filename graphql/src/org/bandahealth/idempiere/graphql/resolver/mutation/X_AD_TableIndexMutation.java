package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_TableIndexInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_TableIndexInput;
import org.compiere.model.MTableIndex;

import java.util.List;

/**
 * Generated Query Resolver for AD_TableIndex - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_TableIndexMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_TableIndexInput.Table_Name;
	}

	public MTableIndex AD_TableIndexSave(I_AD_TableIndexInput input, DataFetchingEnvironment environment) {
		return (MTableIndex) super.save((X_AD_TableIndexInput) input, environment);
	}

	public boolean AD_TableIndexDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
