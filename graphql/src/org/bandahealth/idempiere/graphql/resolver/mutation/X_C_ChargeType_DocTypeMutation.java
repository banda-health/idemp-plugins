package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_ChargeType_DocTypeInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_ChargeType_DocTypeInput;
import org.compiere.model.X_C_ChargeType_DocType;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_ChargeType_DocType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_ChargeType_DocTypeMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_ChargeType_DocTypeInput.Table_Name;
	}

	public X_C_ChargeType_DocType C_ChargeType_DocTypeSave(I_C_ChargeType_DocTypeInput entity, DataFetchingEnvironment environment) {
		return (X_C_ChargeType_DocType) super.save((X_C_ChargeType_DocTypeInput) entity, environment);
	}

	public List<X_C_ChargeType_DocType> C_ChargeType_DocTypeSaveMany(List<I_C_ChargeType_DocTypeInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_ChargeType_DocTypeInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_C_ChargeType_DocType) entity).collect(Collectors.toList());
	}

	public boolean C_ChargeType_DocTypeDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
