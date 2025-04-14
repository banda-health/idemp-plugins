package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_ColorInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_ColorInput;
import org.compiere.model.MColor;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_Color - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_ColorMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_ColorInput.Table_Name;
	}

	public MColor AD_ColorSave(I_AD_ColorInput Entity, DataFetchingEnvironment environment) {
		return (MColor) super.save((X_AD_ColorInput) Entity, environment);
	}

	public List<MColor> AD_ColorSaveMany(List<I_AD_ColorInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_ColorInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MColor) entity).collect(Collectors.toList());
	}

	public boolean AD_ColorDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
