package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_PrintPaperInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_PrintPaperInput;
import org.compiere.model.X_AD_PrintPaper;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_PrintPaper - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_PrintPaperMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_PrintPaperInput.Table_Name;
	}

	public X_AD_PrintPaper AD_PrintPaperSave(I_AD_PrintPaperInput Entity, DataFetchingEnvironment environment) {
		return (X_AD_PrintPaper) super.save((X_AD_PrintPaperInput) Entity, environment);
	}

	public List<X_AD_PrintPaper> AD_PrintPaperSaveMany(List<I_AD_PrintPaperInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_PrintPaperInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_AD_PrintPaper) entity).collect(Collectors.toList());
	}

	public boolean AD_PrintPaperDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
