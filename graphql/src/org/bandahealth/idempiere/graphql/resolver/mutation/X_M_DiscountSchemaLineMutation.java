package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_DiscountSchemaLineInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_DiscountSchemaLineInput;
import org.compiere.model.MDiscountSchemaLine;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_DiscountSchemaLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_DiscountSchemaLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_DiscountSchemaLineInput.Table_Name;
	}

	public MDiscountSchemaLine M_DiscountSchemaLineSave(I_M_DiscountSchemaLineInput Entity, DataFetchingEnvironment environment) {
		return (MDiscountSchemaLine) super.save((X_M_DiscountSchemaLineInput) Entity, environment);
	}

	public List<MDiscountSchemaLine> M_DiscountSchemaLineSaveMany(List<I_M_DiscountSchemaLineInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_M_DiscountSchemaLineInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MDiscountSchemaLine) entity).collect(Collectors.toList());
	}

	public boolean M_DiscountSchemaLineDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
