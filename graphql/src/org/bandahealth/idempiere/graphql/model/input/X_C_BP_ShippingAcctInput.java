package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MBPartnerLocation;
import org.compiere.model.MOrg;
import org.compiere.model.MShippingProcessor;
import org.compiere.model.Query;
import org.compiere.model.X_C_BP_ShippingAcct;
import org.compiere.util.Env;

/**
 * Generated Model for C_BP_ShippingAcct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_BP_ShippingAcctInput extends X_C_BP_ShippingAcct implements I_C_BP_ShippingAcctInput {

	 private I_AD_OrgInput mAD_Org;
	 private I_C_BPartnerInput mC_BPartner;
	 private I_C_BPartner_LocationInput mC_BPartner_Location;
	 private I_M_ShippingProcessorInput mM_ShippingProcessor;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_BP_ShippingAcctInput(@JsonProperty("ID") String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(I_AD_OrgInput AD_Org) {
		this.mAD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public I_AD_OrgInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_BP_ShippingAcct_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_BP_ShippingAcct_UU();
	}

	/**
	 * Set Business Partner .
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public void setC_BPartnerInput(I_C_BPartnerInput C_BPartner) {
		this.mC_BPartner = C_BPartner;
		MBPartner_BH foreignEntity;
		if (get_ID() == 0 &&C_BPartner != null &&
				(foreignEntity = new Query(getCtx(), MBPartner_BH.Table_Name, MBPartner_BH.COLUMNNAME_C_BPartner_UU + "=?", get_TrxName())
						.setParameters(C_BPartner.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_BPartner_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Business Partner .
	 *
	 * @return Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public I_C_BPartnerInput C_BPartner() {
		return mC_BPartner;
	}

	/**
	 * Set Partner Location.
	 *
	 * @param C_BPartner_Location Identifies the (ship to) address for this Business Partner
	 */
	@JsonProperty("C_BPartner_Location")
	public void setC_BPartner_LocationInput(I_C_BPartner_LocationInput C_BPartner_Location) {
		this.mC_BPartner_Location = C_BPartner_Location;
		MBPartnerLocation foreignEntity;
		if (C_BPartner_Location != null &&
				(foreignEntity = new Query(getCtx(), MBPartnerLocation.Table_Name, MBPartnerLocation.COLUMNNAME_C_BPartner_Location_UU + "=?", get_TrxName())
						.setParameters(C_BPartner_Location.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_BPartner_Location_ID(foreignEntity.get_ID());
		} else {
			super.setC_BPartner_Location_ID(0);
		}
	}

	/**
	 * Get Partner Location.
	 *
	 * @return Identifies the (ship to) address for this Business Partner
	 */
	@JsonProperty("C_BPartner_Location")
	public I_C_BPartner_LocationInput C_BPartner_Location() {
		return mC_BPartner_Location;
	}

	/**
	 * Set Shipping Processor.
	 *
	 * @param M_ShippingProcessor Shipping Processor
	 */
	@JsonProperty("M_ShippingProcessor")
	public void setM_ShippingProcessorInput(I_M_ShippingProcessorInput M_ShippingProcessor) {
		this.mM_ShippingProcessor = M_ShippingProcessor;
		MShippingProcessor foreignEntity;
		if (M_ShippingProcessor != null &&
				(foreignEntity = new Query(getCtx(), MShippingProcessor.Table_Name, MShippingProcessor.COLUMNNAME_M_ShippingProcessor_UU + "=?", get_TrxName())
						.setParameters(M_ShippingProcessor.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_ShippingProcessor_ID(foreignEntity.get_ID());
		} else {
			super.setM_ShippingProcessor_ID(0);
		}
	}

	/**
	 * Get Shipping Processor.
	 *
	 * @return Shipping Processor
	 */
	@JsonProperty("M_ShippingProcessor")
	public I_M_ShippingProcessorInput M_ShippingProcessor() {
		return mM_ShippingProcessor;
	}
}
