package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_LotCtlExcludeInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_LotCtlExcludeInput;
import org.compiere.model.X_M_LotCtlExclude;

import java.util.List;

/**
 * Generated Query Resolver for M_LotCtlExclude - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_LotCtlExcludeMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_LotCtlExcludeInput.Table_Name;
	}

	public X_M_LotCtlExclude M_LotCtlExcludeSave(I_M_LotCtlExcludeInput input, DataFetchingEnvironment environment) {
		return (X_M_LotCtlExclude) super.save((X_M_LotCtlExcludeInput) input, environment);
	}

	public boolean M_LotCtlExcludeDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
