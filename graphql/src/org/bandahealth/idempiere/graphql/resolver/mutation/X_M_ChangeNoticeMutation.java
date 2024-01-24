package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_ChangeNoticeInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_ChangeNoticeInput;
import org.compiere.model.MChangeNotice;

import java.util.List;

/**
 * Generated Query Resolver for M_ChangeNotice - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ChangeNoticeMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_ChangeNoticeInput.Table_Name;
	}

	public MChangeNotice M_ChangeNoticeSave(I_M_ChangeNoticeInput input, DataFetchingEnvironment environment) {
		return (MChangeNotice) super.save((X_M_ChangeNoticeInput) input, environment);
	}

	public boolean M_ChangeNoticeDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
