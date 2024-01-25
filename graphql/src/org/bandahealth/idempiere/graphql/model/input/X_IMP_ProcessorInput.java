package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_IMP_Processor;
import org.compiere.model.X_IMP_Processor_Type;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for IMP_Processor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_IMP_ProcessorInput extends X_IMP_Processor implements I_IMP_ProcessorInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mIMP_Processor_Type;
	private I_AD_Ref_ListInput mFrequencyType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The IMP_Processor_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_IMP_ProcessorInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new X_IMP_Processor(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
		setUUID(UUID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
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
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
		} else {
			this.setAD_Org_ID(0);
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set Frequency Type.
	 *
	 * @param FrequencyType Frequency of event
	 */
	@JsonProperty("FrequencyType")
	public void setFrequencyTypeInput(I_AD_Ref_ListInput FrequencyType) {
		this.mFrequencyType = FrequencyType;
		if (FrequencyType != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(FrequencyType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setFrequencyType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + FrequencyType.getUUID());
			}
		} else {
			this.setFrequencyType(null);
		}
	}

	/**
	 * Get Frequency Type.
	 *
	 * @return Frequency of event
	 */
	@JsonProperty("FrequencyType")
	public I_AD_Ref_ListInput FrequencyType() {
		return mFrequencyType;
	}
	/**
	 * Set Import Processor.
	 *
	 * @param IMP_Processor_ID Import Processor
	 */

	public void setIMP_Processor_ID(int IMP_Processor_ID) {
		if (get_ID() == 0) {
			super.setIMP_Processor_ID(IMP_Processor_ID);
		}
	}

	/**
	 * Set Import Processor Type.
	 *
	 * @param IMP_Processor_Type Import Processor Type
	 */
	@JsonProperty("IMP_Processor_Type")
	public void setIMP_Processor_TypeInput(ForeignEntityInput IMP_Processor_Type) {
		this.mIMP_Processor_Type = IMP_Processor_Type;
		if (IMP_Processor_Type != null) {
			// Since an entity was passed, make sure it's in the DB
			X_IMP_Processor_Type foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "IMP_Processor_Type", "IMP_Processor_Type_UU=?", get_TrxName())
							.setParameters(IMP_Processor_Type.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setIMP_Processor_Type_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table IMP_Processor_Type with UUID " + IMP_Processor_Type.getUUID());
			}
		} else {
			this.setIMP_Processor_Type_ID(0);
		}
	}

	/**
	 * Get Import Processor Type.
	 *
	 * @return Import Processor Type
	 */
	@JsonProperty("IMP_Processor_Type")
	public ForeignEntityInput IMP_Processor_Type() {
		return mIMP_Processor_Type;
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setIMP_Processor_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getIMP_Processor_UU();
	}
}
