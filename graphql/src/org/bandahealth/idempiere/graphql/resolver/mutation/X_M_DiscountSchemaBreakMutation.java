package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_DiscountSchemaBreakInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_DiscountSchemaBreakInput;
import org.compiere.model.MDiscountSchemaBreak;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_DiscountSchemaBreak - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_DiscountSchemaBreakMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_DiscountSchemaBreakInput.Table_Name;
	}

	public MDiscountSchemaBreak M_DiscountSchemaBreakSave(I_M_DiscountSchemaBreakInput Entity, DataFetchingEnvironment environment) {
		return (MDiscountSchemaBreak) super.save((X_M_DiscountSchemaBreakInput) Entity, environment);
	}

	public List<MDiscountSchemaBreak> M_DiscountSchemaBreakSaveMany(List<I_M_DiscountSchemaBreakInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_M_DiscountSchemaBreakInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MDiscountSchemaBreak) entity).collect(Collectors.toList());
	}

	public boolean M_DiscountSchemaBreakDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
