package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_PrintLabelLineInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_PrintLabelLineInput;
import org.compiere.model.X_AD_PrintLabelLine;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_PrintLabelLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_PrintLabelLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_PrintLabelLineInput.Table_Name;
	}

	public X_AD_PrintLabelLine AD_PrintLabelLineSave(I_AD_PrintLabelLineInput entity, DataFetchingEnvironment environment) {
		return (X_AD_PrintLabelLine) super.save((X_AD_PrintLabelLineInput) entity, environment);
	}

	public List<X_AD_PrintLabelLine> AD_PrintLabelLineSaveMany(List<I_AD_PrintLabelLineInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_PrintLabelLineInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_AD_PrintLabelLine) entity).collect(Collectors.toList());
	}

	public boolean AD_PrintLabelLineDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
