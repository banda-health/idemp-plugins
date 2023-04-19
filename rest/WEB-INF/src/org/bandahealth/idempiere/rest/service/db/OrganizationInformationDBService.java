package org.bandahealth.idempiere.rest.service.db;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MOrgInfo_BH;
import org.bandahealth.idempiere.rest.exceptions.NotImplementedException;
import org.bandahealth.idempiere.rest.model.Image;
import org.bandahealth.idempiere.rest.model.Location;
import org.bandahealth.idempiere.rest.model.OrganizationInformation;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.model.MImage;
import org.compiere.model.MLocation;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrganizationInformationDBService extends BaseDBService<OrganizationInformation, MOrgInfo_BH> {
	@Autowired
	private LocationDBService locationDBService;
	@Autowired
	private ImageDBService imageDBService;

	/**
	 * Updates the OrganizationInfo object that's nested in Organization.
	 * 
	 */
	@Override
	public OrganizationInformation saveEntity(OrganizationInformation entity) {
		// get organization information
		MOrgInfo_BH organizationInfo = new Query(Env.getCtx(), MOrg.Table_Name,
				MOrgInfo_BH.COLUMNNAME_AD_OrgInfo_UU + " =?", null).setParameters(entity.getUuid()).first();
		if (organizationInfo == null) {
			throw new AdempiereException("Missing organization information.");
		}

		// safe check in the event the implementation logic doesn't set this as a
		// required field
		if (entity != null) {
			if (StringUtil.isNotNullAndEmpty(entity.getHeaderMessage())) {
				organizationInfo.setBH_Header(entity.getHeaderMessage());
			}

			if (StringUtil.isNotNullAndEmpty(entity.getFacilityNumber())) {
				organizationInfo.setBH_FacilityNumber(entity.getFacilityNumber());
			}

			if (StringUtil.isNotNullAndEmpty(entity.getPaymentInformation())) {
				organizationInfo.setBH_PaymentInformation(entity.getPaymentInformation());
			}

			if (StringUtil.isNotNullAndEmpty(entity.getPhone())) {
				organizationInfo.setPhone(entity.getPhone());
			}

			if (StringUtil.isNotNullAndEmpty(entity.getReceiptFooterMessage())) {
				organizationInfo.setReceiptFooterMsg(entity.getReceiptFooterMessage());
			}

			// set location
			Location locationEntity = entity.getLocation();
			if (locationEntity != null) {
				locationEntity = locationDBService.saveEntity(locationEntity);
				MLocation location = new Query(Env.getCtx(), MLocation.Table_Name,
						MLocation.COLUMNNAME_C_Location_UU + " =?", null).setParameters(locationEntity.getUuid())
								.first();
				organizationInfo.setC_Location_ID(location.get_ID());
			}

			// set logo
			if (entity.getLogo() != null && StringUtil.isNotNullAndEmpty(entity.getLogo().getBinaryData())) {
				Image imageEntity = imageDBService.saveEntity(entity.getLogo());
				MImage image = new Query(Env.getCtx(), MImage.Table_Name, MImage.COLUMNNAME_AD_Image_UU + " =?", null)
						.setParameters(imageEntity.getUuid()).first();

				organizationInfo.setLogo_ID(image.get_ID());
			}

			organizationInfo.saveEx();
		}

		return createInstanceWithAllFields(organizationInfo);
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new NotImplementedException();
	}

	@Override
	protected OrganizationInformation createInstanceWithDefaultFields(MOrgInfo_BH instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected OrganizationInformation createInstanceWithAllFields(MOrgInfo_BH instance) {
		return transformData(Collections.singletonList(instance)).get(0);
	}

	@Override
	protected OrganizationInformation createInstanceWithSearchFields(MOrgInfo_BH instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	public List<OrganizationInformation> transformData(List<MOrgInfo_BH> dbModels) {
		// Batch call to get images
		Map<Integer, MImage> imagesById = imageDBService
				.getByIds(dbModels.stream().map(MOrgInfo_BH::getLogo_ID).collect(Collectors.toSet()));

		// Batch call to get locations
		Map<Integer, MLocation> locationsById = locationDBService
				.getByIds(dbModels.stream().map(MOrgInfo_BH::getC_Location_ID).collect(Collectors.toSet()));

		return dbModels.stream().map(mOrganizationInformation -> {
			OrganizationInformation organizationInfo = new OrganizationInformation(mOrganizationInformation);
			if (mOrganizationInformation.getLogo_ID() > 0) {
				Image image = imageDBService
						.transformData(Collections.singletonList(imagesById.get(mOrganizationInformation.getLogo_ID())))
						.get(0);
				organizationInfo.setLogo(image);
			}

			if (mOrganizationInformation.getC_Location_ID() > 0) {
				Location location = locationDBService.transformData(
						Collections.singletonList(locationsById.get(mOrganizationInformation.getC_Location_ID())))
						.get(0);
				organizationInfo.setLocation(location);
			}

			return organizationInfo;

		}).collect(Collectors.toList());
	}

	@Override
	protected MOrgInfo_BH getModelInstance() {
		return new MOrgInfo_BH(Env.getCtx(), null, null);
	}
}
