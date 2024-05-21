package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CalendarDataLoader;
import org.compiere.model.MCalendar;
import org.compiere.model.MReportCube;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for PA_ReportCube - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PA_ReportCubeResolver extends POResolver<MReportCube> implements GraphQLResolver<MReportCube> {



	/**
	 * Get Calendar.
	 *
	 * @return Accounting Calendar Name
	 */
	public CompletableFuture<MCalendar> C_Calendar(MReportCube entity, DataFetchingEnvironment environment) {
		if (entity.getC_Calendar_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MCalendar> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CalendarDataLoader.DATALOADER_C_Calendar_BY_ID);
		return dataLoader.load(entity.getC_Calendar_ID());
	}

	public Boolean IsActivityDim(MReportCube entity, DataFetchingEnvironment environment) {
		return entity.isActivityDim();
	}

	public Boolean IsBPartnerDim(MReportCube entity, DataFetchingEnvironment environment) {
		return entity.isBPartnerDim();
	}

	public Boolean IsCampaignDim(MReportCube entity, DataFetchingEnvironment environment) {
		return entity.isCampaignDim();
	}

	public Boolean IsGLBudgetDim(MReportCube entity, DataFetchingEnvironment environment) {
		return entity.isGLBudgetDim();
	}

	public Boolean IsLocFromDim(MReportCube entity, DataFetchingEnvironment environment) {
		return entity.isLocFromDim();
	}

	public Boolean IsLocToDim(MReportCube entity, DataFetchingEnvironment environment) {
		return entity.isLocToDim();
	}

	public Boolean IsOrgTrxDim(MReportCube entity, DataFetchingEnvironment environment) {
		return entity.isOrgTrxDim();
	}

	public Boolean IsProductDim(MReportCube entity, DataFetchingEnvironment environment) {
		return entity.isProductDim();
	}

	public Boolean IsProjectDim(MReportCube entity, DataFetchingEnvironment environment) {
		return entity.isProjectDim();
	}

	public Boolean IsProjectPhaseDim(MReportCube entity, DataFetchingEnvironment environment) {
		return entity.isProjectPhaseDim();
	}

	public Boolean IsProjectTaskDim(MReportCube entity, DataFetchingEnvironment environment) {
		return entity.isProjectTaskDim();
	}

	public Boolean IsSalesRegionDim(MReportCube entity, DataFetchingEnvironment environment) {
		return entity.isSalesRegionDim();
	}

	public Boolean IsSubAcctDim(MReportCube entity, DataFetchingEnvironment environment) {
		return entity.isSubAcctDim();
	}

	public Boolean IsUser1Dim(MReportCube entity, DataFetchingEnvironment environment) {
		return entity.isUser1Dim();
	}

	public Boolean IsUser2Dim(MReportCube entity, DataFetchingEnvironment environment) {
		return entity.isUser2Dim();
	}

	public Boolean IsUserElement1Dim(MReportCube entity, DataFetchingEnvironment environment) {
		return entity.isUserElement1Dim();
	}

	public Boolean IsUserElement2Dim(MReportCube entity, DataFetchingEnvironment environment) {
		return entity.isUserElement2Dim();
	}

	public Boolean Processing(MReportCube entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

}
