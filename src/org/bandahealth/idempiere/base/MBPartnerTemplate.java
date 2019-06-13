package org.bandahealth.idempiere.base;

import java.util.Properties;

import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.compiere.model.Query;

public class MBPartnerTemplate extends BaseModelTemplate<MBPartner_BH> {

	private int orgId;
	private String patientId;
	private boolean isPatient;
	private String name = "Test Business Partner";
	private boolean isSalesRep;
	private int salesRepId;

	public MBPartnerTemplate(String transactionName, Properties context, int orgId, String patientId, boolean isPatient,
			String name, boolean isSalesRep, int salesRepId) {
		super(transactionName, context);

		this.orgId = orgId;
		this.patientId = patientId;
		this.isPatient = isPatient;
		this.isSalesRep = isSalesRep;
		this.salesRepId = salesRepId;
		if (name != null) {
			this.name = name;
		}
	}

	@Override
	protected MBPartner_BH createInstance() {
		MBPartner_BH bpartner = new MBPartner_BH(getContext(), 0, getTransactionName());
		bpartner.setName(this.name);
		bpartner.setAD_Org_ID(orgId);
		if (patientId != null) {
			bpartner.setBH_PatientID(patientId);
		}

		bpartner.setBH_IsPatient(isPatient);
		bpartner.setIsSalesRep(isSalesRep);
		if (isSalesRep) {
			bpartner.setSalesRep_ID(salesRepId);
		}

		bpartner.saveEx();

		return bpartner;
	}

	@Override
	protected MBPartner_BH findInstance() {
		return new Query(getContext(), MBPartner_BH.Table_Name, MBPartner_BH.COLUMNNAME_Name + " = '" + this.name + "'",
				getTransactionName()).first();
	}
}