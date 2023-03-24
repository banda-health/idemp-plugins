package org.bandahealth.idempiere.rest.service.db;

import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MOrgInfo_BH;
import org.bandahealth.idempiere.rest.model.Image;
import org.bandahealth.idempiere.rest.model.Location;
import org.bandahealth.idempiere.rest.model.Organization;
import org.bandahealth.idempiere.rest.model.OrganizationInfo;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.model.ImageFileStorageImpl;
import org.compiere.model.MImage;
import org.compiere.model.MLocation;
import org.compiere.model.MOrg;
import org.compiere.model.MStorageProvider;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.springframework.stereotype.Component;

@Component
public class OrganizationDBService extends BaseDBService<Organization, MOrg> {

	private final LocationDBService locationDBService = new LocationDBService();
	private MStorageProvider imageProvider;
	private ImageFileStorageImpl fileStorage;

	/**
	 * Updates the OrganizationInfo object that's nested in Organization. Updating
	 * the Organization object is not yet supported.
	 * 
	 */
	@Override
	public Organization saveEntity(Organization entity) {
		// get org
		MOrg org = new Query(Env.getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + " =?", null)
				.setParameters(entity.getUuid()).first();
		if (org == null) {
			throw new AdempiereException("Organization not found.");
		}

		// utilize cache
		MOrgInfo_BH organizationInfo = (MOrgInfo_BH) MOrgInfo_BH.get(Env.getCtx(), org.get_ID(), null);
		if (organizationInfo == null) {
			throw new AdempiereException("Missing organization information");
		}

		OrganizationInfo organizationInfoEntity = entity.getOrganizationInfo();
		// safe check in the event the implementation logic doesn't set this as a
		// required field
		if (organizationInfoEntity != null) {
			if (StringUtil.isNotNullAndEmpty(organizationInfoEntity.getHeaderMessage())) {
				organizationInfo.setBH_Header(organizationInfoEntity.getHeaderMessage());
			}

			if (StringUtil.isNotNullAndEmpty(organizationInfoEntity.getFacilityNumber())) {
				organizationInfo.setBH_FacilityNumber(organizationInfoEntity.getFacilityNumber());
			}

			if (StringUtil.isNotNullAndEmpty(organizationInfoEntity.getPaymentInformation())) {
				organizationInfo.setBH_PaymentInformation(organizationInfoEntity.getPaymentInformation());
			}

			if (StringUtil.isNotNullAndEmpty(organizationInfoEntity.getPhone())) {
				organizationInfo.setPhone(organizationInfoEntity.getPhone());
			}

			if (StringUtil.isNotNullAndEmpty(organizationInfoEntity.getReceiptFooterMessage())) {
				organizationInfo.setReceiptFooterMsg(organizationInfoEntity.getReceiptFooterMessage());
			}

			// set location
			Location locationEntity = organizationInfoEntity.getLocation();
			if (locationEntity != null) {
				MLocation location = MLocation.get(Env.getCtx(), organizationInfo.getC_Location_ID(), null);
				if (location == null) {
					location = new MLocation(Env.getCtx(), 0, null);
				}

				if (StringUtil.isNotNullAndEmpty(locationEntity.getAddress1())) {
					location.setAddress1(locationEntity.getAddress1());
				}

				if (StringUtil.isNotNullAndEmpty(locationEntity.getAddress2())) {
					location.setAddress2(locationEntity.getAddress2());
				}

				if (StringUtil.isNotNullAndEmpty(locationEntity.getAddress3())) {
					location.setAddress3(locationEntity.getAddress3());
				}

				location.saveEx();

				organizationInfo.setC_Location_ID(location.get_ID());
			}

			// set logo
			if (organizationInfoEntity.getLogo() != null
					&& StringUtil.isNotNullAndEmpty(organizationInfoEntity.getLogo().getBinaryData())) {
				Image imageEntity = organizationInfoEntity.getLogo();

				MImage image = new Query(Env.getCtx(), MImage.Table_Name, MImage.COLUMNNAME_AD_Image_UU + " =?", null)
						.setParameters(imageEntity.getUuid()).first();
				if (image == null) {
					image = new MImage(Env.getCtx(), 0, null);
					image.saveEx(); // an existing image is required inorder to save the image in the file storage.
				}

				image.setName(imageEntity.getName());

				getFileStorage().save(image, getImageProvider(),
						Base64.getDecoder().decode(imageEntity.getBinaryData()));

				image.saveEx();

				organizationInfo.setLogo_ID(image.get_ID());
			}

			organizationInfo.saveEx();
		}

		return createInstanceWithAllFields(org);
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new UnsupportedOperationException("Operation Not Supported");
	}

	@Override
	protected Organization createInstanceWithDefaultFields(MOrg instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected Organization createInstanceWithAllFields(MOrg instance) {
		return transformData(Collections.singletonList(instance)).get(0);
	}

	@Override
	protected Organization createInstanceWithSearchFields(MOrg instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	public List<Organization> transformData(List<MOrg> dbModels) {
		return dbModels.stream().map(organization -> {
			Organization result = new Organization(organization);

			MOrgInfo_BH mOrgInfo = (MOrgInfo_BH) organization.getInfo();
			OrganizationInfo orgInfo = new OrganizationInfo(mOrgInfo);
			if (mOrgInfo.getLogo_ID() > 0) {
				MImage mImage = MImage.get(Env.getCtx(), mOrgInfo.getLogo_ID());
				Image image = new Image(mImage);
				try {
					// load image from drive and encode to string.
					byte[] imageBytes = getFileStorage().load(mImage, getImageProvider());
					if (imageBytes != null) {
						image.setBinaryData(Base64.getEncoder().encodeToString(imageBytes));
						orgInfo.setLogo(image);
					}
				} catch (Exception ex) {
					log.severe(ex.getMessage());
				}
			}

			if (mOrgInfo.getC_Location_ID() > 0) {
				MLocation mLocation = MLocation.get(Env.getCtx(), mOrgInfo.getC_Location_ID(), null);
				orgInfo.setLocation(new Location(mLocation));
			}

			result.setOrganizationInfo(orgInfo);

			return result;

		}).collect(Collectors.toList());
	}

	@Override
	protected MOrg getModelInstance() {
		return new MOrg(Env.getCtx(), 0, null);
	}

	private MStorageProvider getImageProvider() {
		if (imageProvider != null) {
			return imageProvider;
		}

		imageProvider = new Query(Env.getCtx(), MStorageProvider.Table_Name,
				MStorageProvider.COLUMNNAME_AD_StorageProvider_UU + " =?", null)
						.setParameters(MOrgInfo_BH.LOGO_STORAGEPROVIDER_UU).first();

		return imageProvider;
	}

	private ImageFileStorageImpl getFileStorage() {
		if (fileStorage != null) {
			return fileStorage;
		}

		return fileStorage = new ImageFileStorageImpl();
	}
}
