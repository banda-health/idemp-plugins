package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_StyleLineInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_StyleLineInput;
import org.compiere.model.MStyleLine;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_StyleLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_StyleLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_StyleLineInput.Table_Name;
	}

	public MStyleLine AD_StyleLineSave(I_AD_StyleLineInput Entity, DataFetchingEnvironment environment) {
		return (MStyleLine) super.save((X_AD_StyleLineInput) Entity, environment);
	}

	public List<MStyleLine> AD_StyleLineSaveMany(List<I_AD_StyleLineInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_StyleLineInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MStyleLine) entity).collect(Collectors.toList());
	}

	public boolean AD_StyleLineDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
