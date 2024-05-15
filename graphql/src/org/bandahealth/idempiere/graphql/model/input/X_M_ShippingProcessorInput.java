package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MShippingProcessor;
import org.compiere.model.Query;
import org.compiere.model.X_M_ShippingProcessorCfg;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for M_ShippingProcessor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_ShippingProcessorInput extends MShippingProcessor implements I_M_ShippingProcessorInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mM_ShippingProcessorCfg;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The M_ShippingProcessor_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_M_ShippingProcessorInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		if (get_ID() != 0) {
			return;
		}
		if (AD_Org != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UU " + AD_Org.getUU());
			}
		} else {
			this.setAD_Org_ID(0);
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
	}
	/**
	 * Set Shipping Processor.
	 *
	 * @param M_ShippingProcessor_ID Shipping Processor
	 */

	public void setM_ShippingProcessor_ID(int M_ShippingProcessor_ID) {
		if (get_ID() == 0) {
			super.setM_ShippingProcessor_ID(M_ShippingProcessor_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setM_ShippingProcessor_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getM_ShippingProcessor_UU();
	}

	/**
	 * Set Shipping Processor Configuration.
	 *
	 * @param M_ShippingProcessorCfg Shipping Processor Configuration
	 */
	@JsonProperty("M_ShippingProcessorCfg")
	public void setM_ShippingProcessorCfgInput(ForeignEntityInput M_ShippingProcessorCfg) {
		this.mM_ShippingProcessorCfg = M_ShippingProcessorCfg;
		if (M_ShippingProcessorCfg != null) {
			// Since an entity was passed, make sure it's in the DB
			X_M_ShippingProcessorCfg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_ShippingProcessorCfg", "M_ShippingProcessorCfg_UU=?", get_TrxName())
							.setParameters(M_ShippingProcessorCfg.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setM_ShippingProcessorCfg_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_ShippingProcessorCfg with UU " + M_ShippingProcessorCfg.getUU());
			}
		} else {
			this.setM_ShippingProcessorCfg_ID(0);
		}
	}

	/**
	 * Get Shipping Processor Configuration.
	 *
	 * @return Shipping Processor Configuration
	 */
	@JsonProperty("M_ShippingProcessorCfg")
	public ForeignEntityInput M_ShippingProcessorCfg() {
		return mM_ShippingProcessorCfg;
	}
}
