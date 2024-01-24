package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MTable_BH;
import org.bandahealth.idempiere.graphql.model.input.I_AD_TableInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_TableInput;

import java.util.List;

/**
 * Generated Query Resolver for AD_Table - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_TableMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_TableInput.Table_Name;
	}

	public MTable_BH AD_TableSave(I_AD_TableInput input, DataFetchingEnvironment environment) {
		return (MTable_BH) super.save((X_AD_TableInput) input, environment);
	}

	public boolean AD_TableDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
