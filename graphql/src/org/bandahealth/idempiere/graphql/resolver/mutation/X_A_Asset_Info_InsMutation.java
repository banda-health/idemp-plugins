package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_A_Asset_Info_InsInput;
import org.bandahealth.idempiere.graphql.model.input.X_A_Asset_Info_InsInput;
import org.compiere.model.X_A_Asset_Info_Ins;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for A_Asset_Info_Ins - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_A_Asset_Info_InsMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_A_Asset_Info_InsInput.Table_Name;
	}

	public X_A_Asset_Info_Ins A_Asset_Info_InsSave(I_A_Asset_Info_InsInput Entity, DataFetchingEnvironment environment) {
		return (X_A_Asset_Info_Ins) super.save((X_A_Asset_Info_InsInput) Entity, environment);
	}

	public List<X_A_Asset_Info_Ins> A_Asset_Info_InsSaveMany(List<I_A_Asset_Info_InsInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_A_Asset_Info_InsInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_A_Asset_Info_Ins) entity).collect(Collectors.toList());
	}

	public boolean A_Asset_Info_InsDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
