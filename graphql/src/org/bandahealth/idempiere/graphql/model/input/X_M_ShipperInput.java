package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MShipper;
import org.compiere.model.MShippingProcessor;
import org.compiere.model.Query;
import org.compiere.model.X_M_ShipperCfg;
import org.compiere.util.Env;

/**
 * Generated Model for M_Shipper - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ShipperInput extends MShipper implements I_M_ShipperInput {

	 private I_AD_OrgInput mAD_Org;
	 private I_C_BPartnerInput mC_BPartner;
	 private I_M_ShipperCfgInput mM_ShipperCfg;
	 private I_M_ShippingProcessorInput mM_ShippingProcessor;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_M_ShipperInput(@JsonProperty("ID") String ID) {
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
	 * Set Business Partner .
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public void setC_BPartnerInput(I_C_BPartnerInput C_BPartner) {
		this.mC_BPartner = C_BPartner;
		MBPartner_BH foreignEntity;
		if (C_BPartner != null &&
				(foreignEntity = new Query(getCtx(), MBPartner_BH.Table_Name, MBPartner_BH.COLUMNNAME_C_BPartner_UU + "=?", get_TrxName())
						.setParameters(C_BPartner.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_BPartner_ID(foreignEntity.get_ID());
		} else {
			super.setC_BPartner_ID(0);
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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setM_Shipper_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getM_Shipper_UU();
	}

	/**
	 * Set Shipper Configuration.
	 *
	 * @param M_ShipperCfg Shipper Configuration
	 */
	@JsonProperty("M_ShipperCfg")
	public void setM_ShipperCfgInput(I_M_ShipperCfgInput M_ShipperCfg) {
		this.mM_ShipperCfg = M_ShipperCfg;
		X_M_ShipperCfg foreignEntity;
		if (M_ShipperCfg != null &&
				(foreignEntity = new Query(getCtx(), X_M_ShipperCfg.Table_Name, X_M_ShipperCfg.COLUMNNAME_M_ShipperCfg_UU + "=?", get_TrxName())
						.setParameters(M_ShipperCfg.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_ShipperCfg_ID(foreignEntity.get_ID());
		} else {
			super.setM_ShipperCfg_ID(0);
		}
	}

	/**
	 * Get Shipper Configuration.
	 *
	 * @return Shipper Configuration
	 */
	@JsonProperty("M_ShipperCfg")
	public I_M_ShipperCfgInput M_ShipperCfg() {
		return mM_ShipperCfg;
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
