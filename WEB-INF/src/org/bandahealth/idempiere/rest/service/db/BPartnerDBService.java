package org.bandahealth.idempiere.rest.service.db;

import java.util.ArrayList;
import java.util.List;

import org.bandahealth.idempiere.rest.model.BPartner;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.Paging;
import org.compiere.model.MBPartner;
import org.compiere.model.Query;
import org.compiere.util.CLogger;
import org.compiere.util.Env;

public class BPartnerDBService {

	private static CLogger log = CLogger.getCLogger(BPartnerDBService.class);

	public static BaseListResponse<BPartner> getAll(Paging pagingInfo) {
		try {
			List<BPartner> results = new ArrayList<>();

			Query query = new Query(Env.getCtx(), MBPartner.Table_Name, null, null).setClient_ID()
					.setOnlyActiveRecords(true);

			// get total count without pagination parameters
			pagingInfo.setTotalRecordCount(query.count());

			// set pagination params
			query = query.setPage(pagingInfo.getPageSize(), pagingInfo.getPage());
			List<MBPartner> bpartners = query.list();

			if (!bpartners.isEmpty()) {
				for (MBPartner bpartner : bpartners) {
					results.add(createBPartnerInstance(bpartner));
				}
			}

			return new BaseListResponse<BPartner>(results, pagingInfo);

		} catch (Exception ex) {
			ex.printStackTrace();
			log.severe(ex.getMessage());
		}

		return null;
	}

	public static BPartner getBPartner(String uuid) {
		try {
			MBPartner bpartner = new Query(Env.getCtx(), MBPartner.Table_Name,
					MBPartner.COLUMNNAME_C_BPartner_UU + "=?", null).setOnlyActiveRecords(true).setParameters(uuid)
							.first();

			if (bpartner != null) {
				return createBPartnerInstance(bpartner);
			}
		} catch (Exception ex) {
			log.severe(ex.getMessage());
		}

		return null;
	}

	private static BPartner createBPartnerInstance(MBPartner bpartner) {
		try {
			return new BPartner(bpartner.getAD_Client_ID(), bpartner.getAD_Org_ID(), bpartner.getC_BPartner_UU(),
					bpartner.isActive(), bpartner.getCreated(), bpartner.getCreatedBy(), bpartner.getDescription(),
					bpartner.getName(), bpartner.getTotalOpenBalance());
		} catch (Exception ex) {
			log.severe(ex.getMessage());
		}

		return null;
	}
}
