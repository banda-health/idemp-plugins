package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_ColorInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_ColorInput;
import org.compiere.model.MColor;

import java.util.List;

/**
 * Generated Query Resolver for AD_Color - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_ColorMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_ColorInput.Table_Name;
	}

	public MColor AD_ColorSave(I_AD_ColorInput input, DataFetchingEnvironment environment) {
		return (MColor) super.save((X_AD_ColorInput) input, environment);
	}

	public boolean AD_ColorDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
