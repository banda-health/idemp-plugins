package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ActivityDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartnerDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CampaignDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CurrencyDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_InvoiceLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_OrderLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ProjectDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ProjectPhaseDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ProjectTaskDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_UOMDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_S_ResourceAssignmentDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_S_TimeExpenseDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_S_TimeTypeDataLoader;
import org.compiere.model.MActivity;
import org.compiere.model.MCampaign;
import org.compiere.model.MInvoiceLine;
import org.compiere.model.MProject;
import org.compiere.model.MProjectPhase;
import org.compiere.model.MProjectTask;
import org.compiere.model.MResourceAssignment;
import org.compiere.model.MTimeExpense;
import org.compiere.model.MTimeExpenseLine;
import org.compiere.model.MUOM;
import org.compiere.model.X_S_TimeType;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for S_TimeExpenseLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_S_TimeExpenseLineResolver extends POResolver<MTimeExpenseLine> implements GraphQLResolver<MTimeExpenseLine> {



	/**
	 * Get Activity.
	 *
	 * @return Business Activity
	 */
	public CompletableFuture<MActivity> C_Activity(MTimeExpenseLine entity, DataFetchingEnvironment environment) {
		if (entity.getC_Activity_ID() <= 0) {
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
	public CompletableFuture<MBPartner_BH> C_BPartner(MTimeExpenseLine entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_ID() <= 0) {
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
	public CompletableFuture<MCampaign> C_Campaign(MTimeExpenseLine entity, DataFetchingEnvironment environment) {
		if (entity.getC_Campaign_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCampaign> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CampaignDataLoader.DATALOADER_C_Campaign_BY_ID);
		return dataLoader.load(entity.getC_Campaign_ID());
	}


	/**
	 * Get Currency.
	 *
	 * @return The Currency for this record
	 */
	public CompletableFuture<MCurrency_BH> C_Currency(MTimeExpenseLine entity, DataFetchingEnvironment environment) {
		if (entity.getC_Currency_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCurrency_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CurrencyDataLoader.DATALOADER_C_Currency_BY_ID);
		return dataLoader.load(entity.getC_Currency_ID());
	}


	/**
	 * Get Invoice Line.
	 *
	 * @return Invoice Detail Line
	 */
	public CompletableFuture<MInvoiceLine> C_InvoiceLine(MTimeExpenseLine entity, DataFetchingEnvironment environment) {
		if (entity.getC_InvoiceLine_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MInvoiceLine> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_InvoiceLineDataLoader.DATALOADER_C_InvoiceLine_BY_ID);
		return dataLoader.load(entity.getC_InvoiceLine_ID());
	}


	/**
	 * Get Sales Order Line.
	 *
	 * @return Sales Order Line
	 */
	public CompletableFuture<MOrderLine_BH> C_OrderLine(MTimeExpenseLine entity, DataFetchingEnvironment environment) {
		if (entity.getC_OrderLine_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MOrderLine_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_OrderLineDataLoader.DATALOADER_C_OrderLine_BY_ID);
		return dataLoader.load(entity.getC_OrderLine_ID());
	}


	/**
	 * Get Project.
	 *
	 * @return Financial Project
	 */
	public CompletableFuture<MProject> C_Project(MTimeExpenseLine entity, DataFetchingEnvironment environment) {
		if (entity.getC_Project_ID() <= 0) {
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
	public CompletableFuture<MProjectPhase> C_ProjectPhase(MTimeExpenseLine entity, DataFetchingEnvironment environment) {
		if (entity.getC_ProjectPhase_ID() <= 0) {
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
	public CompletableFuture<MProjectTask> C_ProjectTask(MTimeExpenseLine entity, DataFetchingEnvironment environment) {
		if (entity.getC_ProjectTask_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProjectTask> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ProjectTaskDataLoader.DATALOADER_C_ProjectTask_BY_ID);
		return dataLoader.load(entity.getC_ProjectTask_ID());
	}


	/**
	 * Get UOM.
	 *
	 * @return Unit of Measure
	 */
	public CompletableFuture<MUOM> C_UOM(MTimeExpenseLine entity, DataFetchingEnvironment environment) {
		if (entity.getC_UOM_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MUOM> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_UOMDataLoader.DATALOADER_C_UOM_BY_ID);
		return dataLoader.load(entity.getC_UOM_ID());
	}

	public Boolean IsInvoiced(MTimeExpenseLine entity, DataFetchingEnvironment environment) {
		return entity.isInvoiced();
	}

	public Boolean IsTimeReport(MTimeExpenseLine entity, DataFetchingEnvironment environment) {
		return entity.isTimeReport();
	}


	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	public CompletableFuture<MProduct_BH> M_Product(MTimeExpenseLine entity, DataFetchingEnvironment environment) {
		if (entity.getM_Product_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProduct_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductDataLoader.DATALOADER_M_Product_BY_ID);
		return dataLoader.load(entity.getM_Product_ID());
	}

	public Boolean Processed(MTimeExpenseLine entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}


	/**
	 * Get Resource Assignment.
	 *
	 * @return Resource Assignment
	 */
	public CompletableFuture<MResourceAssignment> S_ResourceAssignment(MTimeExpenseLine entity, DataFetchingEnvironment environment) {
		if (entity.getS_ResourceAssignment_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MResourceAssignment> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_S_ResourceAssignmentDataLoader.DATALOADER_S_ResourceAssignment_BY_ID);
		return dataLoader.load(entity.getS_ResourceAssignment_ID());
	}


	/**
	 * Get Expense Report.
	 *
	 * @return Time and Expense Report
	 */
	public CompletableFuture<MTimeExpense> S_TimeExpense(MTimeExpenseLine entity, DataFetchingEnvironment environment) {
		if (entity.getS_TimeExpense_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MTimeExpense> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_S_TimeExpenseDataLoader.DATALOADER_S_TimeExpense_BY_ID);
		return dataLoader.load(entity.getS_TimeExpense_ID());
	}


	/**
	 * Get Time Type.
	 *
	 * @return Type of time recorded
	 */
	public CompletableFuture<X_S_TimeType> S_TimeType(MTimeExpenseLine entity, DataFetchingEnvironment environment) {
		if (entity.getS_TimeType_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_S_TimeType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_S_TimeTypeDataLoader.DATALOADER_S_TimeType_BY_ID);
		return dataLoader.load(entity.getS_TimeType_ID());
	}

}
