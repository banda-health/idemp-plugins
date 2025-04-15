package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_PrintFontInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_PrintFontInput;
import org.compiere.model.X_AD_PrintFont;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_PrintFont - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_PrintFontMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_PrintFontInput.Table_Name;
	}

	public X_AD_PrintFont AD_PrintFontSave(I_AD_PrintFontInput Entity, DataFetchingEnvironment environment) {
		return (X_AD_PrintFont) super.save((X_AD_PrintFontInput) Entity, environment);
	}

	public List<X_AD_PrintFont> AD_PrintFontSaveMany(List<I_AD_PrintFontInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_PrintFontInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_AD_PrintFont) entity).collect(Collectors.toList());
	}

	public boolean AD_PrintFontDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
