package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_SerNoCtlExcludeInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_SerNoCtlExcludeInput;
import org.compiere.model.MSerNoCtlExclude;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_SerNoCtlExclude - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_SerNoCtlExcludeMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_SerNoCtlExcludeInput.Table_Name;
	}

	public MSerNoCtlExclude M_SerNoCtlExcludeSave(I_M_SerNoCtlExcludeInput Entity, DataFetchingEnvironment environment) {
		return (MSerNoCtlExclude) super.save((X_M_SerNoCtlExcludeInput) Entity, environment);
	}

	public List<MSerNoCtlExclude> M_SerNoCtlExcludeSaveMany(List<I_M_SerNoCtlExcludeInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_M_SerNoCtlExcludeInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MSerNoCtlExclude) entity).collect(Collectors.toList());
	}

	public boolean M_SerNoCtlExcludeDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
