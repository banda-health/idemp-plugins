package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_TaxDeclarationLineInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_TaxDeclarationLineInput;
import org.compiere.model.MTaxDeclarationLine;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_TaxDeclarationLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_TaxDeclarationLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_TaxDeclarationLineInput.Table_Name;
	}

	public MTaxDeclarationLine C_TaxDeclarationLineSave(I_C_TaxDeclarationLineInput entity, DataFetchingEnvironment environment) {
		return (MTaxDeclarationLine) super.save((X_C_TaxDeclarationLineInput) entity, environment);
	}

	public List<MTaxDeclarationLine> C_TaxDeclarationLineSaveMany(List<I_C_TaxDeclarationLineInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_TaxDeclarationLineInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MTaxDeclarationLine) entity).collect(Collectors.toList());
	}

	public boolean C_TaxDeclarationLineDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
