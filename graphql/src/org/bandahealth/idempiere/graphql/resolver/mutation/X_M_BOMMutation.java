package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_BOMInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_BOMInput;
import org.compiere.model.MBOM;

import java.util.List;

/**
 * Generated Query Resolver for M_BOM - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_BOMMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_BOMInput.Table_Name;
	}

	public MBOM M_BOMSave(I_M_BOMInput input, DataFetchingEnvironment environment) {
		return (MBOM) super.save((X_M_BOMInput) input, environment);
	}

	public boolean M_BOMDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
