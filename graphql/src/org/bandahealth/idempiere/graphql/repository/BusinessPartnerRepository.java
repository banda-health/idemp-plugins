package org.bandahealth.idempiere.graphql.repository;

import graphql.schema.DataFetchingEnvironment;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.bandahealth.idempiere.graphql.model.PagingInfo;
import org.bandahealth.idempiere.graphql.model.input.BusinessPartnerInput;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;


public class BusinessPartnerRepository extends BaseRepository<MBPartner_BH, BusinessPartnerInput> {

	private final LocationRepository locationRepository;
	private Map<String, String> dynamicJoins = new HashMap<>() {{
		put(MOrder_BH.Table_Name, "LEFT JOIN (" + "SELECT " + MOrder_BH.COLUMNNAME_C_BPartner_ID
				+ ",MAX(" + MOrder_BH.COLUMNNAME_DateOrdered + ") as " + MOrder_BH.COLUMNNAME_DateOrdered + " FROM "
				+ MOrder_BH.Table_Name + " WHERE " + MOrder_BH.COLUMNNAME_IsSOTrx + "='Y' GROUP BY "
				+ MOrder_BH.COLUMNNAME_C_BPartner_ID + ") AS " + MOrder_BH.Table_Name + " ON " + MOrder_BH.Table_Name + "."
				+ MOrder_BH.COLUMNNAME_C_BPartner_ID + "=" + MBPartner_BH.Table_Name + "."
				+ MBPartner_BH.COLUMNNAME_C_BPartner_ID);
	}};

	public BusinessPartnerRepository() {
		locationRepository = new LocationRepository();
	}

	@Override
	public Map<String, String> getDynamicJoins(Properties idempiereContext) {
		return dynamicJoins;
	}

	@Override
	protected MBPartner_BH createModelInstance(Properties idempiereContext) {
		return new MBPartner_BH(idempiereContext, 0, null);
	}

	@Override
	public MBPartner_BH mapInputModelToModel(BusinessPartnerInput entity, Properties idempiereContext) {
		try {
			MBPartner_BH businessPartner = getByUuid(entity.getC_BPartner_UU(), idempiereContext);
			if (businessPartner == null) {
				businessPartner = createModelInstance(idempiereContext);
			}

			businessPartner.setIsCustomer(entity.isCustomer());
			businessPartner.setIsVendor(entity.isVendor());

			ModelUtil.setPropertyIfPresent(entity.getName(), businessPartner::setName);
			ModelUtil.setPropertyIfPresent(entity.getDescription(), businessPartner::setDescription);
			ModelUtil.setPropertyIfPresent(entity.getBH_PatientID(), businessPartner::setBH_PatientID);
			ModelUtil.setPropertyIfPresent(entity.getBH_Birthday(), businessPartner::setBH_Birthday);
			ModelUtil.setPropertyIfPresent(entity.getBH_Phone(), businessPartner::setBH_Phone);

			ModelUtil.setPropertyIfPresent(entity.getbh_gender(), businessPartner::setbh_gender);
			ModelUtil.setPropertyIfPresent(entity.getBH_EMail(), businessPartner::setBH_EMail);
			ModelUtil.setPropertyIfPresent(entity.getNationalID(), businessPartner::setNationalID);
			ModelUtil.setPropertyIfPresent(entity.getbh_occupation(), businessPartner::setbh_occupation);
			ModelUtil.setPropertyIfPresent(entity.getNextOfKin_Name(), businessPartner::setNextOfKin_Name);
			ModelUtil.setPropertyIfPresent(entity.getNextOfKin_Contact(), businessPartner::setNextOfKin_Contact);
			ModelUtil.setPropertyIfPresent(entity.getBH_Local_PatientID(), businessPartner::setBH_Local_PatientID);
			ModelUtil.setPropertyIfPresent(entity.isActive(), businessPartner::setIsActive);

			return businessPartner;
		} catch (Exception ex) {
			throw new AdempiereException(ex.getLocalizedMessage());
		}
	}

	public MBPartner_BH saveCustomer(BusinessPartnerInput businessPartner, Properties idempiereContext) {
		businessPartner.setIsCustomer(true);
		businessPartner.setIsVendor(false);
		return save(businessPartner, idempiereContext);
	}

	public MBPartner_BH saveVendor(BusinessPartnerInput businessPartner, Properties idempiereContext) {
		businessPartner.setIsCustomer(false);
		businessPartner.setIsVendor(true);
		return save(businessPartner, idempiereContext);
	}

	public Connection<MBPartner_BH> getCustomers(String filter, String sort, PagingInfo pagingInfo,
			DataFetchingEnvironment environment) {
		List<Object> parameters = new ArrayList<>();
		parameters.add("Y");

		return super.get(filter, sort, pagingInfo, MBPartner_BH.COLUMNNAME_IsCustomer + "=?", parameters,
				environment);
	}

	public Connection<MBPartner_BH> getVendors(String filter, String sort, PagingInfo pagingInfo,
			DataFetchingEnvironment environment) {
		List<Object> parameters = new ArrayList<>();
		parameters.add("Y");

		return super.get(filter, sort, pagingInfo, MBPartner_BH.COLUMNNAME_IsVendor + "=?", parameters,
				environment);
	}
}
