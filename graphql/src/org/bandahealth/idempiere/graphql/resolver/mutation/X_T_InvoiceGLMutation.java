package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_T_InvoiceGLInput;
import org.bandahealth.idempiere.graphql.model.input.X_T_InvoiceGLInput;
import org.compiere.model.X_T_InvoiceGL;

import java.util.List;

/**
 * Generated Query Resolver for T_InvoiceGL - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_T_InvoiceGLMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_T_InvoiceGLInput.Table_Name;
	}

	public X_T_InvoiceGL T_InvoiceGLSave(I_T_InvoiceGLInput input, DataFetchingEnvironment environment) {
		return (X_T_InvoiceGL) super.save((X_T_InvoiceGLInput) input, environment);
	}

	public boolean T_InvoiceGLDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
