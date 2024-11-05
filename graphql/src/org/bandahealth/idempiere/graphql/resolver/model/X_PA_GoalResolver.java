package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_RoleDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PA_ColorSchemaDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PA_GoalDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PA_MeasureDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MColorSchema;
import org.compiere.model.MGoal;
import org.compiere.model.MMeasure;
import org.compiere.model.X_AD_Role;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for PA_Goal - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PA_GoalResolver extends POResolver<MGoal> implements GraphQLResolver<MGoal> {



	/**
	 * Get Role.
	 *
	 * @return Responsibility Role
	 */
	public CompletableFuture<X_AD_Role> AD_Role(MGoal entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Role_ID() < 0) {
			return null;
		}
		DataLoader<Integer, X_AD_Role> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_RoleDataLoader.DATALOADER_AD_Role_BY_ID);
		return dataLoader.load(entity.getAD_Role_ID());
	}


	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	public CompletableFuture<MUser_BH> AD_User(MGoal entity, DataFetchingEnvironment environment) {
		if (entity.getAD_User_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return dataLoader.load(entity.getAD_User_ID());
	}

	public static Map<String, String> CHARTTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("BC", "f160cd4f-c7f9-4ba8-95a0-35bfd440f1e0"); // Bar Chart
			put("PC", "272f2d1e-f643-4284-be03-f9f9f71b55be"); // Pie Chart
			put("RC", "af16cc2a-33f0-4888-a407-e2fb7282f676"); // Ring Chart
			put("LC", "76026b6b-b081-4035-ba71-c84d9818a43d"); // Line Chart
			put("AC", "72cd52c5-0269-474d-a123-f3fbc09bc6de"); // Area Chart
			put("WC", "fa5d4a5b-a6d7-4a4c-b54f-3fdf0ffcbee6"); // Waterfall Chart
		}
	};
	public CompletableFuture<MRefList_BH> ChartType(MGoal entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getChartType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(CHARTTYPE_UUIDS_BY_VALUE.get(entity.getChartType()));
	}

	public Boolean IsSummary(MGoal entity, DataFetchingEnvironment environment) {
		return entity.isSummary();
	}

	public static Map<String, String> MEASUREDISPLAY_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("1", "44aeab85-740e-4ed7-b3b2-6bd930bdc265"); // Year
			put("3", "96a41a1f-6ede-409d-a946-15b5ee58f776"); // Quarter
			put("5", "1cc158a2-c6d7-4147-806f-420005c0e556"); // Month
			put("0", "8f0dc105-cdc2-4353-a518-826d53df65fb"); // Total
			put("7", "7a8525b3-255c-4fb9-be46-f88e27c5821b"); // Week
			put("8", "71d8bfc9-fad4-4ac7-b6a1-8ccf83588f1f"); // Day
		}
	};
	public CompletableFuture<MRefList_BH> MeasureDisplay(MGoal entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getMeasureDisplay())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(MEASUREDISPLAY_UUIDS_BY_VALUE.get(entity.getMeasureDisplay()));
	}

	public static Map<String, String> MEASURESCOPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("1", "44aeab85-740e-4ed7-b3b2-6bd930bdc265"); // Year
			put("3", "96a41a1f-6ede-409d-a946-15b5ee58f776"); // Quarter
			put("5", "1cc158a2-c6d7-4147-806f-420005c0e556"); // Month
			put("0", "8f0dc105-cdc2-4353-a518-826d53df65fb"); // Total
			put("7", "7a8525b3-255c-4fb9-be46-f88e27c5821b"); // Week
			put("8", "71d8bfc9-fad4-4ac7-b6a1-8ccf83588f1f"); // Day
		}
	};
	public CompletableFuture<MRefList_BH> MeasureScope(MGoal entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getMeasureScope())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(MEASURESCOPE_UUIDS_BY_VALUE.get(entity.getMeasureScope()));
	}


	/**
	 * Get Color Schema.
	 *
	 * @return Performance Color Schema
	 */
	public CompletableFuture<MColorSchema> PA_ColorSchema(MGoal entity, DataFetchingEnvironment environment) {
		if (entity.getPA_ColorSchema_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MColorSchema> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PA_ColorSchemaDataLoader.DATALOADER_PA_ColorSchema_BY_ID);
		return dataLoader.load(entity.getPA_ColorSchema_ID());
	}


	/**
	 * Get Parent Goal.
	 *
	 * @return Parent Goal
	 */
	public CompletableFuture<MGoal> PA_GoalParent(MGoal entity, DataFetchingEnvironment environment) {
		if (entity.getPA_GoalParent_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MGoal> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PA_GoalDataLoader.DATALOADER_PA_Goal_BY_ID);
		return dataLoader.load(entity.getPA_GoalParent_ID());
	}


	/**
	 * Get Measure.
	 *
	 * @return Concrete Performance Measurement
	 */
	public CompletableFuture<MMeasure> PA_Measure(MGoal entity, DataFetchingEnvironment environment) {
		if (entity.getPA_Measure_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MMeasure> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PA_MeasureDataLoader.DATALOADER_PA_Measure_BY_ID);
		return dataLoader.load(entity.getPA_Measure_ID());
	}

}
