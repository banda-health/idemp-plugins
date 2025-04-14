package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_AllUsers_VInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_AllUsers_VInput;
import org.compiere.model.X_AD_AllUsers_V;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_AllUsers_V - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_AllUsers_VMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_AllUsers_VInput.Table_Name;
	}

	public X_AD_AllUsers_V AD_AllUsers_VSave(I_AD_AllUsers_VInput Entity, DataFetchingEnvironment environment) {
		return (X_AD_AllUsers_V) super.save((X_AD_AllUsers_VInput) Entity, environment);
	}

	public List<X_AD_AllUsers_V> AD_AllUsers_VSaveMany(List<I_AD_AllUsers_VInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_AllUsers_VInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_AD_AllUsers_V) entity).collect(Collectors.toList());
	}

	public boolean AD_AllUsers_VDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
