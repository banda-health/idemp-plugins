package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_R_RequestTypeInput;
import org.bandahealth.idempiere.graphql.model.input.X_R_RequestTypeInput;
import org.compiere.model.MRequestType;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for R_RequestType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_R_RequestTypeMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_R_RequestTypeInput.Table_Name;
	}

	public MRequestType R_RequestTypeSave(I_R_RequestTypeInput Entity, DataFetchingEnvironment environment) {
		return (MRequestType) super.save((X_R_RequestTypeInput) Entity, environment);
	}

	public List<MRequestType> R_RequestTypeSaveMany(List<I_R_RequestTypeInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_R_RequestTypeInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MRequestType) entity).collect(Collectors.toList());
	}

	public boolean R_RequestTypeDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
