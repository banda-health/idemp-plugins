package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_BOMInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_BOMInput;
import org.compiere.model.MBOM;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_BOM - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_BOMMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_BOMInput.Table_Name;
	}

	public MBOM M_BOMSave(I_M_BOMInput Entity, DataFetchingEnvironment environment) {
		return (MBOM) super.save((X_M_BOMInput) Entity, environment);
	}

	public List<MBOM> M_BOMSaveMany(List<I_M_BOMInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_M_BOMInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MBOM) entity).collect(Collectors.toList());
	}

	public boolean M_BOMDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
