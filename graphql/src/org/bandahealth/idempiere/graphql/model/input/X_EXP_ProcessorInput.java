package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MEXPProcessor;
import org.compiere.model.MEXPProcessorType;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for EXP_Processor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_EXP_ProcessorInput extends MEXPProcessor implements I_EXP_ProcessorInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mEXP_Processor_Type;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The EXP_Processor_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_EXP_ProcessorInput(@JsonProperty("UU") String UU) {
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
	 * Set Export Processor.
	 *
	 * @param EXP_Processor_ID Export Processor
	 */
	@JsonProperty("EXP_Processor_ID")
	public void setEXP_Processor_IDFromJson(int EXP_Processor_ID) {
		if (get_ID() == 0) {
			super.setEXP_Processor_ID(EXP_Processor_ID);
		}
	}

	/**
	 * Set Export Processor Type.
	 *
	 * @param EXP_Processor_Type Export Processor Type
	 */
	@JsonProperty("EXP_Processor_Type")
	public void setEXP_Processor_TypeInput(ForeignEntityInput EXP_Processor_Type) {
		this.mEXP_Processor_Type = EXP_Processor_Type;
		if (EXP_Processor_Type != null) {
			// Since an entity was passed, make sure it's in the DB
			MEXPProcessorType foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "EXP_Processor_Type", "EXP_Processor_Type_UU=?", get_TrxName())
							.setParameters(EXP_Processor_Type.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setEXP_Processor_Type_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table EXP_Processor_Type with UU " + EXP_Processor_Type.getUU());
			}
		} else {
			this.setEXP_Processor_Type_ID(0);
		}
	}

	/**
	 * Get Export Processor Type.
	 *
	 * @return Export Processor Type
	 */
	@JsonProperty("EXP_Processor_Type")
	public ForeignEntityInput EXP_Processor_Type() {
		return mEXP_Processor_Type;
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setEXP_Processor_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getEXP_Processor_UU();
	}
}
