package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_TreeNodeU4Input;
import org.bandahealth.idempiere.graphql.model.input.X_AD_TreeNodeU4Input;
import org.compiere.model.X_AD_TreeNodeU4;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_TreeNodeU4 - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_TreeNodeU4Mutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_TreeNodeU4Input.Table_Name;
	}

	public X_AD_TreeNodeU4 AD_TreeNodeU4Save(I_AD_TreeNodeU4Input Entity, DataFetchingEnvironment environment) {
		return (X_AD_TreeNodeU4) super.save((X_AD_TreeNodeU4Input) Entity, environment);
	}

	public List<X_AD_TreeNodeU4> AD_TreeNodeU4SaveMany(List<I_AD_TreeNodeU4Input> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_TreeNodeU4Input) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_AD_TreeNodeU4) entity).collect(Collectors.toList());
	}

	public boolean AD_TreeNodeU4Delete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
