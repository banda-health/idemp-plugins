package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_T_InvoiceGLInput;
import org.bandahealth.idempiere.graphql.model.input.X_T_InvoiceGLInput;
import org.compiere.model.X_T_InvoiceGL;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for T_InvoiceGL - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_T_InvoiceGLMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_T_InvoiceGLInput.Table_Name;
	}

	public X_T_InvoiceGL T_InvoiceGLSave(I_T_InvoiceGLInput Entity, DataFetchingEnvironment environment) {
		return (X_T_InvoiceGL) super.save((X_T_InvoiceGLInput) Entity, environment);
	}

	public List<X_T_InvoiceGL> T_InvoiceGLSaveMany(List<I_T_InvoiceGLInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_T_InvoiceGLInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_T_InvoiceGL) entity).collect(Collectors.toList());
	}

	public boolean T_InvoiceGLDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
