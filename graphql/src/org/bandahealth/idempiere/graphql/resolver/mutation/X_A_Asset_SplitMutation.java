package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_A_Asset_SplitInput;
import org.bandahealth.idempiere.graphql.model.input.X_A_Asset_SplitInput;
import org.compiere.model.X_A_Asset_Split;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for A_Asset_Split - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_A_Asset_SplitMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_A_Asset_SplitInput.Table_Name;
	}

	public X_A_Asset_Split A_Asset_SplitSave(I_A_Asset_SplitInput Entity, DataFetchingEnvironment environment) {
		return (X_A_Asset_Split) super.save((X_A_Asset_SplitInput) Entity, environment);
	}

	public List<X_A_Asset_Split> A_Asset_SplitSaveMany(List<I_A_Asset_SplitInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_A_Asset_SplitInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_A_Asset_Split) entity).collect(Collectors.toList());
	}

	public boolean A_Asset_SplitDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
