package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.eevolution.model.X_PP_Cost_Collector;
import org.eevolution.model.X_PP_Cost_CollectorMA;

import java.sql.ResultSet;

/**
 * Generated Model for PP_Cost_CollectorMA - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PP_Cost_CollectorMAInput extends X_PP_Cost_CollectorMA implements I_PP_Cost_CollectorMAInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mM_AttributeSetInstance;
	private ForeignEntityInput mPP_Cost_Collector;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The PP_Cost_CollectorMA_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_PP_Cost_CollectorMAInput(@JsonProperty("UU") String UU) {
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
	 * Set Attribute Set Instance.
	 *
	 * @param M_AttributeSetInstance Product Attribute Set Instance
	 */
	@JsonProperty("M_AttributeSetInstance")
	public void setM_AttributeSetInstanceInput(ForeignEntityInput M_AttributeSetInstance) {
		this.mM_AttributeSetInstance = M_AttributeSetInstance;
		if (M_AttributeSetInstance != null) {
			// Since an entity was passed, make sure it's in the DB
			MAttributeSetInstance_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_AttributeSetInstance", "M_AttributeSetInstance_UU=?", get_TrxName())
							.setParameters(M_AttributeSetInstance.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setM_AttributeSetInstance_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_AttributeSetInstance with UU " + M_AttributeSetInstance.getUU());
			}
		} else {
			this.setM_AttributeSetInstance_ID(0);
		}
	}

	/**
	 * Get Attribute Set Instance.
	 *
	 * @return Product Attribute Set Instance
	 */
	@JsonProperty("M_AttributeSetInstance")
	public ForeignEntityInput M_AttributeSetInstance() {
		return mM_AttributeSetInstance;
	}

	/**
	 * Set Manufacturing Cost Collector.
	 *
	 * @param PP_Cost_Collector Manufacturing Cost Collector
	 */
	@JsonProperty("PP_Cost_Collector")
	public void setPP_Cost_CollectorInput(ForeignEntityInput PP_Cost_Collector) {
		this.mPP_Cost_Collector = PP_Cost_Collector;
		if (PP_Cost_Collector != null) {
			// Since an entity was passed, make sure it's in the DB
			X_PP_Cost_Collector foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "PP_Cost_Collector", "PP_Cost_Collector_UU=?", get_TrxName())
							.setParameters(PP_Cost_Collector.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setPP_Cost_Collector_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table PP_Cost_Collector with UU " + PP_Cost_Collector.getUU());
			}
		} else {
			this.setPP_Cost_Collector_ID(0);
		}
	}

	/**
	 * Get Manufacturing Cost Collector.
	 *
	 * @return Manufacturing Cost Collector
	 */
	@JsonProperty("PP_Cost_Collector")
	public ForeignEntityInput PP_Cost_Collector() {
		return mPP_Cost_Collector;
	}
	/**
	 * Set Manufacturing Order MA.
	 *
	 * @param PP_Cost_CollectorMA_ID Manufacturing Order MA
	 */
	@JsonProperty("PP_Cost_CollectorMA_ID")
	public void setPP_Cost_CollectorMA_IDFromJson(int PP_Cost_CollectorMA_ID) {
		if (get_ID() == 0) {
			super.setPP_Cost_CollectorMA_ID(PP_Cost_CollectorMA_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setPP_Cost_CollectorMA_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getPP_Cost_CollectorMA_UU();
	}
}
