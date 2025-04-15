package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_TaxDeclarationAcctInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_TaxDeclarationAcctInput;
import org.compiere.model.MTaxDeclarationAcct;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_TaxDeclarationAcct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_TaxDeclarationAcctMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_TaxDeclarationAcctInput.Table_Name;
	}

	public MTaxDeclarationAcct C_TaxDeclarationAcctSave(I_C_TaxDeclarationAcctInput Entity, DataFetchingEnvironment environment) {
		return (MTaxDeclarationAcct) super.save((X_C_TaxDeclarationAcctInput) Entity, environment);
	}

	public List<MTaxDeclarationAcct> C_TaxDeclarationAcctSaveMany(List<I_C_TaxDeclarationAcctInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_TaxDeclarationAcctInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MTaxDeclarationAcct) entity).collect(Collectors.toList());
	}

	public boolean C_TaxDeclarationAcctDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
