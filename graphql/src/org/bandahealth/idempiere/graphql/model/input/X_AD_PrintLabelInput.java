package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MTable;
import org.compiere.model.Query;
import org.compiere.model.X_AD_LabelPrinter;
import org.compiere.model.X_AD_PrintLabel;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_PrintLabel - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_PrintLabelInput extends X_AD_PrintLabel implements I_AD_PrintLabelInput {

	private ForeignEntityInput mAD_LabelPrinter;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Table;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_PrintLabel_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_PrintLabelInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UUID), null);
		setUUID(UUID);
	}

	/**
	 * Set Label printer.
	 *
	 * @param AD_LabelPrinter Label Printer Definition
	 */
	@JsonProperty("AD_LabelPrinter")
	public void setAD_LabelPrinterInput(ForeignEntityInput AD_LabelPrinter) {
		this.mAD_LabelPrinter = AD_LabelPrinter;
		if (AD_LabelPrinter != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_LabelPrinter foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_LabelPrinter", "AD_LabelPrinter_UU=?", get_TrxName())
							.setParameters(AD_LabelPrinter.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_LabelPrinter_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_LabelPrinter with UUID " + AD_LabelPrinter.getUUID());
			}
		} else {
			this.setAD_LabelPrinter_ID(0);
		}
	}

	/**
	 * Get Label printer.
	 *
	 * @return Label Printer Definition
	 */
	@JsonProperty("AD_LabelPrinter")
	public ForeignEntityInput AD_LabelPrinter() {
		return mAD_LabelPrinter;
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
	 * Set Print Label.
	 *
	 * @param AD_PrintLabel_ID Label Format to print
	 */

	public void setAD_PrintLabel_ID(int AD_PrintLabel_ID) {
		if (get_ID() == 0) {
			super.setAD_PrintLabel_ID(AD_PrintLabel_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setAD_PrintLabel_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getAD_PrintLabel_UU();
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
}
