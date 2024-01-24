package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_TreeNodeU2Input;
import org.bandahealth.idempiere.graphql.model.input.X_AD_TreeNodeU2Input;
import org.compiere.model.X_AD_TreeNodeU2;

import java.util.List;

/**
 * Generated Query Resolver for AD_TreeNodeU2 - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_TreeNodeU2Mutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_TreeNodeU2Input.Table_Name;
	}

	public X_AD_TreeNodeU2 AD_TreeNodeU2Save(I_AD_TreeNodeU2Input input, DataFetchingEnvironment environment) {
		return (X_AD_TreeNodeU2) super.save((X_AD_TreeNodeU2Input) input, environment);
	}

	public boolean AD_TreeNodeU2Delete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
