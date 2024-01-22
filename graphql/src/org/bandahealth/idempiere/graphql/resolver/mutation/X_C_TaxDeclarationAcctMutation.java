package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_TaxDeclarationAcctInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_TaxDeclarationAcctInput;
import org.compiere.model.MTaxDeclarationAcct;

import java.util.List;

/**
 * Generated Query Resolver for C_TaxDeclarationAcct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_TaxDeclarationAcctMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_TaxDeclarationAcctInput.Table_Name;
	}

	public MTaxDeclarationAcct C_TaxDeclarationAcctSave(I_C_TaxDeclarationAcctInput input, DataFetchingEnvironment environment) {
		return (MTaxDeclarationAcct) super.save((X_C_TaxDeclarationAcctInput) input, environment);
	}

	public boolean C_TaxDeclarationAcctDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
