package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MBPartnerLocation;
import org.compiere.model.MDistributionList;
import org.compiere.model.MDistributionListLine;
import org.compiere.model.MDistributionRun;
import org.compiere.model.MDistributionRunDetail;
import org.compiere.model.MDistributionRunLine;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for T_DistributionRunDetail - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_T_DistributionRunDetailInput extends MDistributionRunDetail implements I_T_DistributionRunDetailInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_BPartner;
	private ForeignEntityInput mC_BPartner_Location;
	private ForeignEntityInput mM_DistributionList;
	private ForeignEntityInput mM_DistributionListLine;
	private ForeignEntityInput mM_DistributionRun;
	private ForeignEntityInput mM_DistributionRunLine;
	private ForeignEntityInput mM_Product;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The T_DistributionRunDetail_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_T_DistributionRunDetailInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MDistributionRunDetail(null, (ResultSet) null, null),
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
	 * Set Business Partner .
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public void setC_BPartnerInput(ForeignEntityInput C_BPartner) {
		this.mC_BPartner = C_BPartner;
		if (C_BPartner != null) {
			// Since an entity was passed, make sure it's in the DB
			MBPartner_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_BPartner", "C_BPartner_UU=?", get_TrxName())
							.setParameters(C_BPartner.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_BPartner_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BPartner with UUID " + C_BPartner.getUUID());
			}
		} else {
			this.setC_BPartner_ID(0);
		}
	}

	/**
	 * Get Business Partner .
	 *
	 * @return Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public ForeignEntityInput C_BPartner() {
		return mC_BPartner;
	}

	/**
	 * Set Partner Location.
	 *
	 * @param C_BPartner_Location Identifies the (ship to) address for this Business Partner
	 */
	@JsonProperty("C_BPartner_Location")
	public void setC_BPartner_LocationInput(ForeignEntityInput C_BPartner_Location) {
		this.mC_BPartner_Location = C_BPartner_Location;
		if (C_BPartner_Location != null) {
			// Since an entity was passed, make sure it's in the DB
			MBPartnerLocation foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_BPartner_Location", "C_BPartner_Location_UU=?", get_TrxName())
							.setParameters(C_BPartner_Location.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_BPartner_Location_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BPartner_Location with UUID " + C_BPartner_Location.getUUID());
			}
		} else {
			this.setC_BPartner_Location_ID(0);
		}
	}

	/**
	 * Get Partner Location.
	 *
	 * @return Identifies the (ship to) address for this Business Partner
	 */
	@JsonProperty("C_BPartner_Location")
	public ForeignEntityInput C_BPartner_Location() {
		return mC_BPartner_Location;
	}

	/**
	 * Set Distribution List.
	 *
	 * @param M_DistributionList Distribution Lists allow to distribute products to a selected list of partners
	 */
	@JsonProperty("M_DistributionList")
	public void setM_DistributionListInput(ForeignEntityInput M_DistributionList) {
		this.mM_DistributionList = M_DistributionList;
		if (get_ID() != 0) {
			return;
		}
		if (M_DistributionList != null) {
			// Since an entity was passed, make sure it's in the DB
			MDistributionList foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_DistributionList", "M_DistributionList_UU=?", get_TrxName())
							.setParameters(M_DistributionList.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_DistributionList_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_DistributionList with UUID " + M_DistributionList.getUUID());
			}
		} else {
			this.setM_DistributionList_ID(0);
		}
	}

	/**
	 * Get Distribution List.
	 *
	 * @return Distribution Lists allow to distribute products to a selected list of partners
	 */
	@JsonProperty("M_DistributionList")
	public ForeignEntityInput M_DistributionList() {
		return mM_DistributionList;
	}

	/**
	 * Set Distribution List Line.
	 *
	 * @param M_DistributionListLine Distribution List Line with Business Partner and Quantity/Percentage
	 */
	@JsonProperty("M_DistributionListLine")
	public void setM_DistributionListLineInput(ForeignEntityInput M_DistributionListLine) {
		this.mM_DistributionListLine = M_DistributionListLine;
		if (get_ID() != 0) {
			return;
		}
		if (M_DistributionListLine != null) {
			// Since an entity was passed, make sure it's in the DB
			MDistributionListLine foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_DistributionListLine", "M_DistributionListLine_UU=?", get_TrxName())
							.setParameters(M_DistributionListLine.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_DistributionListLine_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_DistributionListLine with UUID " + M_DistributionListLine.getUUID());
			}
		} else {
			this.setM_DistributionListLine_ID(0);
		}
	}

	/**
	 * Get Distribution List Line.
	 *
	 * @return Distribution List Line with Business Partner and Quantity/Percentage
	 */
	@JsonProperty("M_DistributionListLine")
	public ForeignEntityInput M_DistributionListLine() {
		return mM_DistributionListLine;
	}

	/**
	 * Set Distribution Run.
	 *
	 * @param M_DistributionRun Distribution Run create Orders to distribute products to a selected list of partners
	 */
	@JsonProperty("M_DistributionRun")
	public void setM_DistributionRunInput(ForeignEntityInput M_DistributionRun) {
		this.mM_DistributionRun = M_DistributionRun;
		if (get_ID() != 0) {
			return;
		}
		if (M_DistributionRun != null) {
			// Since an entity was passed, make sure it's in the DB
			MDistributionRun foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_DistributionRun", "M_DistributionRun_UU=?", get_TrxName())
							.setParameters(M_DistributionRun.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_DistributionRun_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_DistributionRun with UUID " + M_DistributionRun.getUUID());
			}
		} else {
			this.setM_DistributionRun_ID(0);
		}
	}

	/**
	 * Get Distribution Run.
	 *
	 * @return Distribution Run create Orders to distribute products to a selected list of partners
	 */
	@JsonProperty("M_DistributionRun")
	public ForeignEntityInput M_DistributionRun() {
		return mM_DistributionRun;
	}

	/**
	 * Set Distribution Run Line.
	 *
	 * @param M_DistributionRunLine Distribution Run Lines define Distribution List, the Product and Quantities
	 */
	@JsonProperty("M_DistributionRunLine")
	public void setM_DistributionRunLineInput(ForeignEntityInput M_DistributionRunLine) {
		this.mM_DistributionRunLine = M_DistributionRunLine;
		if (get_ID() != 0) {
			return;
		}
		if (M_DistributionRunLine != null) {
			// Since an entity was passed, make sure it's in the DB
			MDistributionRunLine foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_DistributionRunLine", "M_DistributionRunLine_UU=?", get_TrxName())
							.setParameters(M_DistributionRunLine.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_DistributionRunLine_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_DistributionRunLine with UUID " + M_DistributionRunLine.getUUID());
			}
		} else {
			this.setM_DistributionRunLine_ID(0);
		}
	}

	/**
	 * Get Distribution Run Line.
	 *
	 * @return Distribution Run Lines define Distribution List, the Product and Quantities
	 */
	@JsonProperty("M_DistributionRunLine")
	public ForeignEntityInput M_DistributionRunLine() {
		return mM_DistributionRunLine;
	}

	/**
	 * Set Product/Service.
	 *
	 * @param M_Product Product, Service, Item
	 */
	@JsonProperty("M_Product")
	public void setM_ProductInput(ForeignEntityInput M_Product) {
		this.mM_Product = M_Product;
		if (M_Product != null) {
			// Since an entity was passed, make sure it's in the DB
			MProduct_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_Product", "M_Product_UU=?", get_TrxName())
							.setParameters(M_Product.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_Product_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Product with UUID " + M_Product.getUUID());
			}
		} else {
			this.setM_Product_ID(0);
		}
	}

	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	@JsonProperty("M_Product")
	public ForeignEntityInput M_Product() {
		return mM_Product;
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setT_DistributionRunDetail_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getT_DistributionRunDetail_UU();
	}
}
