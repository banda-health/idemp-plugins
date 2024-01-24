package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_LotCtlExcludeInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_LotCtlExcludeInput;
import org.compiere.model.MLotCtlExclude;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_LotCtlExclude - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_LotCtlExcludeMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_LotCtlExcludeInput.Table_Name;
	}

	public MLotCtlExclude M_LotCtlExcludeSave(I_M_LotCtlExcludeInput entity, DataFetchingEnvironment environment) {
		return (MLotCtlExclude) super.save((X_M_LotCtlExcludeInput) entity, environment);
	}

	public List<MLotCtlExclude> M_LotCtlExcludeSaveMany(List<I_M_LotCtlExcludeInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_M_LotCtlExcludeInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MLotCtlExclude) entity).collect(Collectors.toList());
	}

	public boolean M_LotCtlExcludeDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
