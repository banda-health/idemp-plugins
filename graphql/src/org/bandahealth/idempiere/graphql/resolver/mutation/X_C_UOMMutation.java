package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_UOMInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_UOMInput;
import org.compiere.model.MUOM;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_UOM - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_UOMMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_UOMInput.Table_Name;
	}

	public MUOM C_UOMSave(I_C_UOMInput Entity, DataFetchingEnvironment environment) {
		return (MUOM) super.save((X_C_UOMInput) Entity, environment);
	}

	public List<MUOM> C_UOMSaveMany(List<I_C_UOMInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_UOMInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MUOM) entity).collect(Collectors.toList());
	}

	public boolean C_UOMDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
