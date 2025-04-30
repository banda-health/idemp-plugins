package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_AD_PInstance_LogResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MPInstance;
import org.compiere.model.MTable;
import org.compiere.model.Query;
import org.compiere.model.X_AD_PInstance_Log;
import org.compiere.util.Env;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;

/**
 * Generated Model for AD_PInstance_Log - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_PInstance_LogInput extends X_AD_PInstance_Log implements I_AD_PInstance_LogInput {

	private ForeignEntityInput mAD_PInstance;
	private ForeignEntityInput mAD_Table;
	private ForeignEntityInput mPInstanceLogType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The AD_PInstance_Log_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_PInstance_LogInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}

	/**
	 * Set Process Instance.
	 *
	 * @param AD_PInstance Instance of the process
	 */
	@JsonProperty("AD_PInstance")
	public void setAD_PInstanceInput(ForeignEntityInput AD_PInstance) {
		this.mAD_PInstance = AD_PInstance;
		if (!is_new()) {
			return;
		}
		if (AD_PInstance != null) {
			// Since an entity was passed, make sure it's in the DB
			MPInstance foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_PInstance", "AD_PInstance_UU=?", get_TrxName())
							.setParameters(AD_PInstance.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_PInstance_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_PInstance with UU " + AD_PInstance.getUU());
			}
		} else {
			this.setAD_PInstance_ID(0);
		}
	}

	/**
	 * Get Process Instance.
	 *
	 * @return Instance of the process
	 */
	@JsonProperty("AD_PInstance")
	public ForeignEntityInput AD_PInstance() {
		return mAD_PInstance;
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setAD_PInstance_Log_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getAD_PInstance_Log_UU();
	}

	/**
	 * Set Table.
	 *
	 * @param AD_Table Database Table information
	 */
	@JsonProperty("AD_Table")
	public void setAD_TableInput(ForeignEntityInput AD_Table) {
		this.mAD_Table = AD_Table;
		if (AD_Table != null) {
			// Since an entity was passed, make sure it's in the DB
			MTable foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Table", "AD_Table_UU=?", get_TrxName())
							.setParameters(AD_Table.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_Table_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Table with UU " + AD_Table.getUU());
			}
		} else {
			this.setAD_Table_ID(0);
		}
	}

	/**
	 * Get Table.
	 *
	 * @return Database Table information
	 */
	@JsonProperty("AD_Table")
	public ForeignEntityInput AD_Table() {
		return mAD_Table;
	}
	/**
	 * Set Log.
	 *
	 * @param Log_ID Log
	 */
	@JsonProperty("Log_ID")
	public void setLog_IDFromJson(int Log_ID) {
		if (get_ID() == 0) {
			super.setLog_ID(Log_ID);
		}
	}
	/**
	 * Set Process Date.
	 *
	 * @param P_Date Process Parameter
	 */
	@JsonProperty("P_Date")
	public void setP_DateFromJson(Timestamp P_Date) {
		if (get_ID() == 0) {
			super.setP_Date(P_Date);
		}
	}
	/**
	 * Set Process Message.
	 *
	 * @param P_Msg Process Message
	 */
	@JsonProperty("P_Msg")
	public void setP_MsgFromJson(String P_Msg) {
		if (get_ID() == 0) {
			super.setP_Msg(P_Msg);
		}
	}
	/**
	 * Set Process Number.
	 *
	 * @param P_Number Process Parameter
	 */
	@JsonProperty("P_Number")
	public void setP_NumberFromJson(BigDecimal P_Number) {
		if (get_ID() == 0) {
			super.setP_Number(P_Number);
		}
	}

	/**
	 * Set Log Type.
	 *
	 * @param PInstanceLogType Process Audit Log Type
	 */
	@JsonProperty("PInstanceLogType")
	public void setPInstanceLogTypeInput(ForeignEntityInput PInstanceLogType) {
		this.mPInstanceLogType = PInstanceLogType;
		if (PInstanceLogType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_PInstance_LogResolver.PINSTANCELOGTYPE_UUIDS_BY_VALUE.containsValue(PInstanceLogType.getUU())) {
				throw new AdempiereException("The reference list UU of " + PInstanceLogType.getUU() +
						" is not in the list defined for the PInstanceLogType column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(PInstanceLogType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setPInstanceLogType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + PInstanceLogType.getUU());
			}
		} else {
			this.setPInstanceLogType(null);
		}
	}

	/**
	 * Get Log Type.
	 *
	 * @return Process Audit Log Type
	 */
	@JsonProperty("PInstanceLogType")
	public ForeignEntityInput PInstanceLogType() {
		return mPInstanceLogType;
	}
}
