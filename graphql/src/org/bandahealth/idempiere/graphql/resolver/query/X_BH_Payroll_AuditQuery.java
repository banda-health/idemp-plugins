package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHPayrollAudit;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_Payroll_AuditDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for BH_Payroll_Audit - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Payroll_AuditQuery extends POQuery<MBHPayrollAudit> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBHPayrollAudit.Table_Name;
	}

	public CompletableFuture<MBHPayrollAudit> BH_Payroll_Audit(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MBHPayrollAudit> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_BH_Payroll_AuditDataLoader.DATALOADER_BH_Payroll_Audit_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MBHPayrollAudit> BH_Payroll_AuditGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
