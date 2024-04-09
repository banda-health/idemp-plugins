package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_U_Web_PropertiesInput;
import org.bandahealth.idempiere.graphql.model.input.X_U_Web_PropertiesInput;
import org.compiere.model.MWebProperties;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for U_Web_Properties - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_U_Web_PropertiesMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_U_Web_PropertiesInput.Table_Name;
	}

	public MWebProperties U_Web_PropertiesSave(I_U_Web_PropertiesInput Entity, DataFetchingEnvironment environment) {
		return (MWebProperties) super.save((X_U_Web_PropertiesInput) Entity, environment);
	}

	public List<MWebProperties> U_Web_PropertiesSaveMany(List<I_U_Web_PropertiesInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_U_Web_PropertiesInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MWebProperties) entity).collect(Collectors.toList());
	}

	public boolean U_Web_PropertiesDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
