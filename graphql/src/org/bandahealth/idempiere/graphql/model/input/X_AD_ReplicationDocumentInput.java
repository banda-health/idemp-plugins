package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MReplicationStrategy;
import org.compiere.model.MTable;
import org.compiere.model.Query;
import org.compiere.model.X_AD_ReplicationDocument;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_ReplicationDocument - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_ReplicationDocumentInput extends X_AD_ReplicationDocument implements I_AD_ReplicationDocumentInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_ReplicationStrategy;
	private ForeignEntityInput mAD_Table;
	private ForeignEntityInput mC_DocType;
	private I_AD_Ref_ListInput mReplicationType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_ReplicationDocument_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_ReplicationDocumentInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UUID), null);
		setUUID(UUID);
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
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
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
	 * @return Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
	}
	/**
	 * Set Replication Document.
	 *
	 * @param AD_ReplicationDocument_ID Replication Document
	 */

	public void setAD_ReplicationDocument_ID(int AD_ReplicationDocument_ID) {
		if (get_ID() == 0) {
			super.setAD_ReplicationDocument_ID(AD_ReplicationDocument_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setAD_ReplicationDocument_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getAD_ReplicationDocument_UU();
	}

	/**
	 * Set Replication Strategy.
	 *
	 * @param AD_ReplicationStrategy Data Replication Strategy
	 */
	@JsonProperty("AD_ReplicationStrategy")
	public void setAD_ReplicationStrategyInput(ForeignEntityInput AD_ReplicationStrategy) {
		this.mAD_ReplicationStrategy = AD_ReplicationStrategy;
		if (get_ID() != 0) {
			return;
		}
		if (AD_ReplicationStrategy != null) {
			// Since an entity was passed, make sure it's in the DB
			MReplicationStrategy foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_ReplicationStrategy", "AD_ReplicationStrategy_UU=?", get_TrxName())
							.setParameters(AD_ReplicationStrategy.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_ReplicationStrategy_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_ReplicationStrategy with UUID " + AD_ReplicationStrategy.getUUID());
			}
		} else {
			this.setAD_ReplicationStrategy_ID(0);
		}
	}

	/**
	 * Get Replication Strategy.
	 *
	 * @return Data Replication Strategy
	 */
	@JsonProperty("AD_ReplicationStrategy")
	public ForeignEntityInput AD_ReplicationStrategy() {
		return mAD_ReplicationStrategy;
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
	 * Set Document Type.
	 *
	 * @param C_DocType Document type or rules
	 */
	@JsonProperty("C_DocType")
	public void setC_DocTypeInput(ForeignEntityInput C_DocType) {
		this.mC_DocType = C_DocType;
		if (C_DocType != null) {
			// Since an entity was passed, make sure it's in the DB
			MDocType_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_DocType", "C_DocType_UU=?", get_TrxName())
							.setParameters(C_DocType.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_DocType_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_DocType with UUID " + C_DocType.getUUID());
			}
		} else {
			this.setC_DocType_ID(0);
		}
	}

	/**
	 * Get Document Type.
	 *
	 * @return Document type or rules
	 */
	@JsonProperty("C_DocType")
	public ForeignEntityInput C_DocType() {
		return mC_DocType;
	}

	/**
	 * Set Replication Type.
	 *
	 * @param ReplicationType Type of Data Replication
	 */
	@JsonProperty("ReplicationType")
	public void setReplicationTypeInput(I_AD_Ref_ListInput ReplicationType) {
		this.mReplicationType = ReplicationType;
		if (ReplicationType != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(ReplicationType.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setReplicationType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + ReplicationType.getUUID());
			}
		} else {
			this.setReplicationType(null);
		}
	}

	/**
	 * Get Replication Type.
	 *
	 * @return Type of Data Replication
	 */
	@JsonProperty("ReplicationType")
	public I_AD_Ref_ListInput ReplicationType() {
		return mReplicationType;
	}
}
