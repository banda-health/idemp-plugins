package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHGraphqlGeneratorTemplate extends X_BH_GraphQLGeneratorTemplate {
	public MBHGraphqlGeneratorTemplate(Properties ctx, int BH_GraphQLGeneratorTemplate_ID, String trxName) {
		super(ctx, BH_GraphQLGeneratorTemplate_ID, trxName);
	}

	public MBHGraphqlGeneratorTemplate(Properties ctx, int BH_GraphQLGeneratorTemplate_ID, String trxName,
			String... virtualColumns) {
		super(ctx, BH_GraphQLGeneratorTemplate_ID, trxName, virtualColumns);
	}

	public MBHGraphqlGeneratorTemplate(Properties ctx, String BH_GraphQLGeneratorTemplate_UU, String trxName) {
		super(ctx, BH_GraphQLGeneratorTemplate_UU, trxName);
	}

	public MBHGraphqlGeneratorTemplate(Properties ctx, String BH_GraphQLGeneratorTemplate_UU, String trxName,
			String... virtualColumns) {
		super(ctx, BH_GraphQLGeneratorTemplate_UU, trxName, virtualColumns);
	}

	public MBHGraphqlGeneratorTemplate(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
