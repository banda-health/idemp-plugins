package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_TreeNodeU3Input;
import org.bandahealth.idempiere.graphql.model.input.X_AD_TreeNodeU3Input;
import org.compiere.model.X_AD_TreeNodeU3;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_TreeNodeU3 - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_TreeNodeU3Mutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_TreeNodeU3Input.Table_Name;
	}

	public X_AD_TreeNodeU3 AD_TreeNodeU3Save(I_AD_TreeNodeU3Input entity, DataFetchingEnvironment environment) {
		return (X_AD_TreeNodeU3) super.save((X_AD_TreeNodeU3Input) entity, environment);
	}

	public List<X_AD_TreeNodeU3> AD_TreeNodeU3SaveMany(List<I_AD_TreeNodeU3Input> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_TreeNodeU3Input) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_AD_TreeNodeU3) entity).collect(Collectors.toList());
	}

	public boolean AD_TreeNodeU3Delete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
