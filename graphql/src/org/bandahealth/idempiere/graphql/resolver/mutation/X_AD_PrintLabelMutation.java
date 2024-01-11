package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_PrintLabelInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_PrintLabelInput;
import org.compiere.model.X_AD_PrintLabel;

import java.util.List;

/**
 * Generated Query Resolver for AD_PrintLabel - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_PrintLabelMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_PrintLabelInput.Table_Name;
	}

	public X_AD_PrintLabel AD_PrintLabelSave(I_AD_PrintLabelInput input, DataFetchingEnvironment environment) {
		return (X_AD_PrintLabel) super.save((X_AD_PrintLabelInput) input, environment);
	}

	public boolean AD_PrintLabelDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
