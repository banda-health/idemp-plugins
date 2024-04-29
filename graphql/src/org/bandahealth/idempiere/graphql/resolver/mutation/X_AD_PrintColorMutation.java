package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_PrintColorInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_PrintColorInput;
import org.compiere.model.X_AD_PrintColor;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_PrintColor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_PrintColorMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_PrintColorInput.Table_Name;
	}

	public X_AD_PrintColor AD_PrintColorSave(I_AD_PrintColorInput Entity, DataFetchingEnvironment environment) {
		return (X_AD_PrintColor) super.save((X_AD_PrintColorInput) Entity, environment);
	}

	public List<X_AD_PrintColor> AD_PrintColorSaveMany(List<I_AD_PrintColorInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_PrintColorInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_AD_PrintColor) entity).collect(Collectors.toList());
	}

	public boolean AD_PrintColorDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
