package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_PrintLabelInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_PrintLabelInput;
import org.compiere.model.X_AD_PrintLabel;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_PrintLabel - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_PrintLabelMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_PrintLabelInput.Table_Name;
	}

	public X_AD_PrintLabel AD_PrintLabelSave(I_AD_PrintLabelInput Entity, DataFetchingEnvironment environment) {
		return (X_AD_PrintLabel) super.save((X_AD_PrintLabelInput) Entity, environment);
	}

	public List<X_AD_PrintLabel> AD_PrintLabelSaveMany(List<I_AD_PrintLabelInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_PrintLabelInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_AD_PrintLabel) entity).collect(Collectors.toList());
	}

	public boolean AD_PrintLabelDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
