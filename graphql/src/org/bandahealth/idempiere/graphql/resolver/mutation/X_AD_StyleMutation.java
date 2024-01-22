package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_StyleInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_StyleInput;
import org.compiere.model.MStyle;

import java.util.List;

/**
 * Generated Query Resolver for AD_Style - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_StyleMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_StyleInput.Table_Name;
	}

	public MStyle AD_StyleSave(I_AD_StyleInput input, DataFetchingEnvironment environment) {
		return (MStyle) super.save((X_AD_StyleInput) input, environment);
	}

	public boolean AD_StyleDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
