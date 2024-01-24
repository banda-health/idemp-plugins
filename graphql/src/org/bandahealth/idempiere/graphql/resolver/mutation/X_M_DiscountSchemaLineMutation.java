package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MDiscountSchemaLine_BH;
import org.bandahealth.idempiere.graphql.model.input.I_M_DiscountSchemaLineInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_DiscountSchemaLineInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_DiscountSchemaLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_DiscountSchemaLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_DiscountSchemaLineInput.Table_Name;
	}

	public MDiscountSchemaLine_BH M_DiscountSchemaLineSave(I_M_DiscountSchemaLineInput entity, DataFetchingEnvironment environment) {
		return (MDiscountSchemaLine_BH) super.save((X_M_DiscountSchemaLineInput) entity, environment);
	}

	public List<MDiscountSchemaLine_BH> M_DiscountSchemaLineSaveMany(List<I_M_DiscountSchemaLineInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_M_DiscountSchemaLineInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MDiscountSchemaLine_BH) entity).collect(Collectors.toList());
	}

	public boolean M_DiscountSchemaLineDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
