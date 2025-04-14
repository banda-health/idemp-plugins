package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_AcctSchemaDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ActivityDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartnerDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CampaignDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ElementValueDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_LocationDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_PeriodDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ProjectDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ProjectPhaseDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ProjectTaskDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_SalesRegionDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_SubAcctDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_GL_BudgetDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PA_ReportCubeDataLoader;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MActivity;
import org.compiere.model.MCampaign;
import org.compiere.model.MElementValue;
import org.compiere.model.MLocation;
import org.compiere.model.MPeriod;
import org.compiere.model.MProject;
import org.compiere.model.MProjectPhase;
import org.compiere.model.MProjectTask;
import org.compiere.model.MReportCube;
import org.compiere.model.MSalesRegion;
import org.compiere.model.X_C_SubAcct;
import org.compiere.model.X_Fact_Acct_Summary;
import org.compiere.model.X_GL_Budget;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for Fact_Acct_Summary - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_Fact_Acct_SummaryResolver extends POResolver<X_Fact_Acct_Summary> implements GraphQLResolver<X_Fact_Acct_Summary> {



	/**
	 * Get Account.
	 *
	 * @return Account used
	 */
	public CompletableFuture<MElementValue> Account(X_Fact_Acct_Summary entity, DataFetchingEnvironment environment) {
		if (entity.getAccount_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MElementValue> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ElementValueDataLoader.DATALOADER_C_ElementValue_BY_ID);
		return dataLoader.load(entity.getAccount_ID());
	}


	/**
	 * Get Accounting Schema.
	 *
	 * @return Rules for accounting
	 */
	public CompletableFuture<MAcctSchema> C_AcctSchema(X_Fact_Acct_Summary entity, DataFetchingEnvironment environment) {
		if (entity.getC_AcctSchema_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MAcctSchema> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_AcctSchemaDataLoader.DATALOADER_C_AcctSchema_BY_ID);
		return dataLoader.load(entity.getC_AcctSchema_ID());
	}


	/**
	 * Get Activity.
	 *
	 * @return Business Activity
	 */
	public CompletableFuture<MActivity> C_Activity(X_Fact_Acct_Summary entity, DataFetchingEnvironment environment) {
		if (entity.getC_Activity_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MActivity> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ActivityDataLoader.DATALOADER_C_Activity_BY_ID);
		return dataLoader.load(entity.getC_Activity_ID());
	}


	/**
	 * Get Business Partner.
	 *
	 * @return Identifies a Business Partner
	 */
	public CompletableFuture<MBPartner_BH> C_BPartner(X_Fact_Acct_Summary entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBPartner_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartnerDataLoader.DATALOADER_C_BPartner_BY_ID);
		return dataLoader.load(entity.getC_BPartner_ID());
	}


	/**
	 * Get Campaign.
	 *
	 * @return Marketing Campaign
	 */
	public CompletableFuture<MCampaign> C_Campaign(X_Fact_Acct_Summary entity, DataFetchingEnvironment environment) {
		if (entity.getC_Campaign_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MCampaign> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CampaignDataLoader.DATALOADER_C_Campaign_BY_ID);
		return dataLoader.load(entity.getC_Campaign_ID());
	}


	/**
	 * Get Location From.
	 *
	 * @return Location that inventory was moved from
	 */
	public CompletableFuture<MLocation> C_LocFrom(X_Fact_Acct_Summary entity, DataFetchingEnvironment environment) {
		if (entity.getC_LocFrom_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MLocation> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_LocationDataLoader.DATALOADER_C_Location_BY_ID);
		return dataLoader.load(entity.getC_LocFrom_ID());
	}


	/**
	 * Get Location To.
	 *
	 * @return Location that inventory was moved to
	 */
	public CompletableFuture<MLocation> C_LocTo(X_Fact_Acct_Summary entity, DataFetchingEnvironment environment) {
		if (entity.getC_LocTo_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MLocation> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_LocationDataLoader.DATALOADER_C_Location_BY_ID);
		return dataLoader.load(entity.getC_LocTo_ID());
	}


	/**
	 * Get Period.
	 *
	 * @return Period of the Calendar
	 */
	public CompletableFuture<MPeriod> C_Period(X_Fact_Acct_Summary entity, DataFetchingEnvironment environment) {
		if (entity.getC_Period_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MPeriod> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_PeriodDataLoader.DATALOADER_C_Period_BY_ID);
		return dataLoader.load(entity.getC_Period_ID());
	}


	/**
	 * Get Project.
	 *
	 * @return Financial Project
	 */
	public CompletableFuture<MProject> C_Project(X_Fact_Acct_Summary entity, DataFetchingEnvironment environment) {
		if (entity.getC_Project_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MProject> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ProjectDataLoader.DATALOADER_C_Project_BY_ID);
		return dataLoader.load(entity.getC_Project_ID());
	}


	/**
	 * Get Project Phase.
	 *
	 * @return Phase of a Project
	 */
	public CompletableFuture<MProjectPhase> C_ProjectPhase(X_Fact_Acct_Summary entity, DataFetchingEnvironment environment) {
		if (entity.getC_ProjectPhase_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MProjectPhase> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ProjectPhaseDataLoader.DATALOADER_C_ProjectPhase_BY_ID);
		return dataLoader.load(entity.getC_ProjectPhase_ID());
	}


	/**
	 * Get Project Task.
	 *
	 * @return Actual Project Task in a Phase
	 */
	public CompletableFuture<MProjectTask> C_ProjectTask(X_Fact_Acct_Summary entity, DataFetchingEnvironment environment) {
		if (entity.getC_ProjectTask_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MProjectTask> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ProjectTaskDataLoader.DATALOADER_C_ProjectTask_BY_ID);
		return dataLoader.load(entity.getC_ProjectTask_ID());
	}


	/**
	 * Get Sales Region.
	 *
	 * @return Sales coverage region
	 */
	public CompletableFuture<MSalesRegion> C_SalesRegion(X_Fact_Acct_Summary entity, DataFetchingEnvironment environment) {
		if (entity.getC_SalesRegion_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MSalesRegion> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_SalesRegionDataLoader.DATALOADER_C_SalesRegion_BY_ID);
		return dataLoader.load(entity.getC_SalesRegion_ID());
	}


	/**
	 * Get Sub Account.
	 *
	 * @return Sub account for Element Value
	 */
	public CompletableFuture<X_C_SubAcct> C_SubAcct(X_Fact_Acct_Summary entity, DataFetchingEnvironment environment) {
		if (entity.getC_SubAcct_ID() < 1) {
			return null;
		}
		DataLoader<Integer, X_C_SubAcct> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_SubAcctDataLoader.DATALOADER_C_SubAcct_BY_ID);
		return dataLoader.load(entity.getC_SubAcct_ID());
	}


	/**
	 * Get Budget.
	 *
	 * @return General Ledger Budget
	 */
	public CompletableFuture<X_GL_Budget> GL_Budget(X_Fact_Acct_Summary entity, DataFetchingEnvironment environment) {
		if (entity.getGL_Budget_ID() < 1) {
			return null;
		}
		DataLoader<Integer, X_GL_Budget> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_GL_BudgetDataLoader.DATALOADER_GL_Budget_BY_ID);
		return dataLoader.load(entity.getGL_Budget_ID());
	}


	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	public CompletableFuture<MProduct_BH> M_Product(X_Fact_Acct_Summary entity, DataFetchingEnvironment environment) {
		if (entity.getM_Product_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MProduct_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductDataLoader.DATALOADER_M_Product_BY_ID);
		return dataLoader.load(entity.getM_Product_ID());
	}


	/**
	 * Get Report Cube.
	 *
	 * @return Define reporting cube for pre-calculation of summary accounting data.
	 */
	public CompletableFuture<MReportCube> PA_ReportCube(X_Fact_Acct_Summary entity, DataFetchingEnvironment environment) {
		if (entity.getPA_ReportCube_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MReportCube> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PA_ReportCubeDataLoader.DATALOADER_PA_ReportCube_BY_ID);
		return dataLoader.load(entity.getPA_ReportCube_ID());
	}

	public Boolean PostingType(X_Fact_Acct_Summary entity, DataFetchingEnvironment environment) {
		return entity.isPostingType();
	}


	/**
	 * Get User Element List 1.
	 *
	 * @return User defined list element #1
	 */
	public CompletableFuture<MElementValue> User1(X_Fact_Acct_Summary entity, DataFetchingEnvironment environment) {
		if (entity.getUser1_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MElementValue> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ElementValueDataLoader.DATALOADER_C_ElementValue_BY_ID);
		return dataLoader.load(entity.getUser1_ID());
	}


	/**
	 * Get User Element List 2.
	 *
	 * @return User defined list element #2
	 */
	public CompletableFuture<MElementValue> User2(X_Fact_Acct_Summary entity, DataFetchingEnvironment environment) {
		if (entity.getUser2_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MElementValue> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ElementValueDataLoader.DATALOADER_C_ElementValue_BY_ID);
		return dataLoader.load(entity.getUser2_ID());
	}

}
