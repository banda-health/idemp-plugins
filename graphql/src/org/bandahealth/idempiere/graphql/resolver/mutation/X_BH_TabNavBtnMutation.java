package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MTabNavBtn;
import org.bandahealth.idempiere.graphql.model.input.I_BH_TabNavBtnInput;
import org.bandahealth.idempiere.graphql.model.input.X_BH_TabNavBtnInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for BH_TabNavBtn - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_BH_TabNavBtnMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_BH_TabNavBtnInput.Table_Name;
	}

	public MTabNavBtn BH_TabNavBtnSave(I_BH_TabNavBtnInput entity, DataFetchingEnvironment environment) {
		return (MTabNavBtn) super.save((X_BH_TabNavBtnInput) entity, environment);
	}

	public List<MTabNavBtn> BH_TabNavBtnSaveMany(List<I_BH_TabNavBtnInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_BH_TabNavBtnInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MTabNavBtn) entity).collect(Collectors.toList());
	}

	public boolean BH_TabNavBtnDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
