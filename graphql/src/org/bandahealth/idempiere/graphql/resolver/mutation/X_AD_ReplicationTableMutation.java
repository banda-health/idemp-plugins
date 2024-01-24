package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_ReplicationTableInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_ReplicationTableInput;
import org.compiere.model.X_AD_ReplicationTable;

import java.util.List;

/**
 * Generated Query Resolver for AD_ReplicationTable - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_ReplicationTableMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_ReplicationTableInput.Table_Name;
	}

	public X_AD_ReplicationTable AD_ReplicationTableSave(I_AD_ReplicationTableInput input, DataFetchingEnvironment environment) {
		return (X_AD_ReplicationTable) super.save((X_AD_ReplicationTableInput) input, environment);
	}

	public boolean AD_ReplicationTableDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
