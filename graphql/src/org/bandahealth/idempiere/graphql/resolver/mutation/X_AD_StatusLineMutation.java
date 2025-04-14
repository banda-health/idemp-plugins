package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_StatusLineInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_StatusLineInput;
import org.compiere.model.MStatusLine;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_StatusLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_StatusLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_StatusLineInput.Table_Name;
	}

	public MStatusLine AD_StatusLineSave(I_AD_StatusLineInput Entity, DataFetchingEnvironment environment) {
		return (MStatusLine) super.save((X_AD_StatusLineInput) Entity, environment);
	}

	public List<MStatusLine> AD_StatusLineSaveMany(List<I_AD_StatusLineInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_StatusLineInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MStatusLine) entity).collect(Collectors.toList());
	}

	public boolean AD_StatusLineDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
