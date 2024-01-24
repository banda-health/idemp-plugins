package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_SerNoCtlExcludeInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_SerNoCtlExcludeInput;
import org.compiere.model.X_M_SerNoCtlExclude;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_SerNoCtlExclude - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_SerNoCtlExcludeMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_SerNoCtlExcludeInput.Table_Name;
	}

	public X_M_SerNoCtlExclude M_SerNoCtlExcludeSave(I_M_SerNoCtlExcludeInput entity, DataFetchingEnvironment environment) {
		return (X_M_SerNoCtlExclude) super.save((X_M_SerNoCtlExcludeInput) entity, environment);
	}

	public List<X_M_SerNoCtlExclude> M_SerNoCtlExcludeSaveMany(List<I_M_SerNoCtlExcludeInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_M_SerNoCtlExcludeInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_M_SerNoCtlExclude) entity).collect(Collectors.toList());
	}

	public boolean M_SerNoCtlExcludeDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
