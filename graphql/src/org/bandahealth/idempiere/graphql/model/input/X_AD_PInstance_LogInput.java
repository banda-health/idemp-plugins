package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
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
 * @version Release 11 - $Id$
 */
public class X_AD_PInstance_LogInput extends X_AD_PInstance_Log implements I_AD_PInstance_LogInput {

	private ForeignEntityInput mAD_PInstance;
	private ForeignEntityInput mAD_Table;
	private I_AD_Ref_ListInput mPInstanceLogType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_PInstance_Log_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_PInstance_LogInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new X_AD_PInstance_Log(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
		setUUID(UUID);
	}

	/**
	 * Set Process Instance.
	 *
	 * @param AD_PInstance Instance of the process
	 */
	@JsonProperty("AD_PInstance")
	public void setAD_PInstanceInput(ForeignEntityInput AD_PInstance) {
		this.mAD_PInstance = AD_PInstance;
		if (get_ID() != 0) {
			return;
		}
		if (AD_PInstance != null) {
			// Since an entity was passed, make sure it's in the DB
			MPInstance foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_PInstance", "AD_PInstance_UU=?", get_TrxName())
							.setParameters(AD_PInstance.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_PInstance_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_PInstance with UUID " + AD_PInstance.getUUID());
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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setAD_PInstance_Log_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
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
							.setParameters(AD_Table.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Table_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Table with UUID " + AD_Table.getUUID());
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

	public void setLog_ID(int Log_ID) {
		if (get_ID() == 0) {
			super.setLog_ID(Log_ID);
		}
	}
	/**
	 * Set Process Date.
	 *
	 * @param P_Date Process Parameter
	 */

	public void setP_Date(Timestamp P_Date) {
		if (get_ID() == 0) {
			super.setP_Date(P_Date);
		}
	}
	/**
	 * Set Process Message.
	 *
	 * @param P_Msg Process Message
	 */

	public void setP_Msg(String P_Msg) {
		if (get_ID() == 0) {
			super.setP_Msg(P_Msg);
		}
	}
	/**
	 * Set Process Number.
	 *
	 * @param P_Number Process Parameter
	 */

	public void setP_Number(BigDecimal P_Number) {
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
	public void setPInstanceLogTypeInput(I_AD_Ref_ListInput PInstanceLogType) {
		this.mPInstanceLogType = PInstanceLogType;
		if (PInstanceLogType != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(PInstanceLogType.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setPInstanceLogType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + PInstanceLogType.getUUID());
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
	public I_AD_Ref_ListInput PInstanceLogType() {
		return mPInstanceLogType;
	}
}
