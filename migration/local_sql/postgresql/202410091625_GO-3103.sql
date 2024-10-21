WITH bp_mapping AS (
	SELECT
		ad_user_id,
		c_bpartner_id,
		ROW_NUMBER() OVER (PARTITION BY c_bpartner_id ORDER BY created DESC) row_num
	FROM
		ad_user
	WHERE
		ad_client_id > 999999
		AND c_bpartner_id IS NOT NULL
)
SELECT
	u1.ad_user_id  AS to_user_id,
	un1.ad_user_id AS from_user_id
INTO TEMP TABLE
	tmp_bp_mapping
FROM
	bp_mapping u1
		JOIN bp_mapping un1
		ON u1.c_bpartner_id = un1.c_bpartner_id AND un1.row_num != 1
WHERE
	u1.row_num = 1;

UPDATE c_order o
SET
	ad_user_id = tbpm.to_user_id
FROM
	tmp_bp_mapping tbpm
WHERE
	o.ad_user_id = tbpm.from_user_id;
UPDATE c_order o
SET
	bill_user_id = tbpm.to_user_id
FROM
	tmp_bp_mapping tbpm
WHERE
	o.bill_user_id = tbpm.from_user_id;
UPDATE c_invoice i
SET
	ad_user_id = tbpm.to_user_id
FROM
	tmp_bp_mapping tbpm
WHERE
	i.ad_user_id = tbpm.from_user_id;
UPDATE m_inout io
SET
	ad_user_id = tbpm.to_user_id
FROM
	tmp_bp_mapping tbpm
WHERE
	io.ad_user_id = tbpm.from_user_id;

ALTER TABLE a_asset
	DROP CONSTRAINT aduser_aasset;
ALTER TABLE a_asset_change
	DROP CONSTRAINT aduser_aassetchange;
ALTER TABLE a_asset_delivery
	DROP CONSTRAINT aduser_aassetdelivery;
ALTER TABLE a_asset_group_trl
	DROP CONSTRAINT createdby_aassetgrouptrl;
ALTER TABLE a_asset_group_trl
	DROP CONSTRAINT updatedby_aassetgrouptrl;
ALTER TABLE a_registration
	DROP CONSTRAINT aduser_aregistration;
ALTER TABLE ad_alertprocessor
	DROP CONSTRAINT aduser_calertprocessor;
ALTER TABLE ad_alertrecipient
	DROP CONSTRAINT aduser_adalertrecipient;
ALTER TABLE ad_attachmentnote
	DROP CONSTRAINT aduser_adattachmentnote;
ALTER TABLE ad_authorizationaccount
	DROP CONSTRAINT aduser_adauthorizationaccount;
ALTER TABLE ad_broadcastmessage
	DROP CONSTRAINT aduser_adbroadcastmessage;
ALTER TABLE ad_broadcastmessage_trl
	DROP CONSTRAINT createdby_adbroadcastmessagetr;
ALTER TABLE ad_broadcastmessage_trl
	DROP CONSTRAINT updatedby_adbroadcastmessagetr;
ALTER TABLE ad_chart_trl
	DROP CONSTRAINT createdby_adcharttrl;
ALTER TABLE ad_chart_trl
	DROP CONSTRAINT updatedby_adcharttrl;
ALTER TABLE ad_color_trl
	DROP CONSTRAINT createdby_adcolortrl;
ALTER TABLE ad_color_trl
	DROP CONSTRAINT updatedby_adcolortrl;
ALTER TABLE ad_ctxhelpsuggestion
	DROP CONSTRAINT aduser_adctxhelpsuggestion;
ALTER TABLE ad_ctxhelpsuggestion
	DROP CONSTRAINT aduserclient_adctxhelpsuggesti;
ALTER TABLE ad_fieldsuggestion
	DROP CONSTRAINT aduser_adfieldsuggestion;
ALTER TABLE ad_fieldsuggestion
	DROP CONSTRAINT aduserclient_adfieldsuggestion;
ALTER TABLE ad_importtemplate
	DROP CONSTRAINT createdby_adimporttemplate;
ALTER TABLE ad_importtemplate
	DROP CONSTRAINT updatedby_adimporttemplate;
ALTER TABLE ad_importtemplateaccess
	DROP CONSTRAINT createdby_adimporttemplateacce;
ALTER TABLE ad_importtemplateaccess
	DROP CONSTRAINT updatedby_adimporttemplateacce;
ALTER TABLE ad_inforelated
	DROP CONSTRAINT createdby_adinforelated;
ALTER TABLE ad_inforelated
	DROP CONSTRAINT updatedby_adinforelated;
ALTER TABLE ad_label_trl
	DROP CONSTRAINT createdby_adlabeltrl;
ALTER TABLE ad_label_trl
	DROP CONSTRAINT updatedby_adlabeltrl;
ALTER TABLE ad_labelcategory_trl
	DROP CONSTRAINT createdby_adlabelcategorytrl;
ALTER TABLE ad_labelcategory_trl
	DROP CONSTRAINT updatedby_adlabelcategorytrl;
ALTER TABLE ad_ldapaccess
	DROP CONSTRAINT aduser_adldapaccess;
ALTER TABLE ad_ldapprocessor
	DROP CONSTRAINT aduser_adldapprocessor;
ALTER TABLE ad_modelgeneratortemplate
	DROP CONSTRAINT createdby_admodelgeneratortemp;
ALTER TABLE ad_modelgeneratortemplate
	DROP CONSTRAINT updatedby_admodelgeneratortemp;
ALTER TABLE ad_note
	DROP CONSTRAINT aduser_adnote;
ALTER TABLE ad_orginfo
	DROP CONSTRAINT aduser_adorginfo;
ALTER TABLE ad_password_history
	DROP CONSTRAINT aduser_adpasswordhistory;
ALTER TABLE ad_password_history
	DROP CONSTRAINT createdby_adpasswordhistory;
ALTER TABLE ad_password_history
	DROP CONSTRAINT updatedby_adpasswordhistory;
ALTER TABLE ad_pinstance
	DROP CONSTRAINT aduser_pinstance;
ALTER TABLE ad_postit
	DROP CONSTRAINT createdby_adpostit;
ALTER TABLE ad_postit
	DROP CONSTRAINT updatedby_adpostit;
ALTER TABLE ad_preference
	DROP CONSTRAINT ad_user_preference;
ALTER TABLE ad_printcolor_trl
	DROP CONSTRAINT createdby_adprintcolortrl;
ALTER TABLE ad_printcolor_trl
	DROP CONSTRAINT updatedby_adprintcolortrl;
ALTER TABLE ad_private_access
	DROP CONSTRAINT aduser_adprivateaccess;
ALTER TABLE ad_recentitem
	DROP CONSTRAINT aduser_adrecentitem;
ALTER TABLE ad_reportview_column
	DROP CONSTRAINT createdby_adreportviewcolumn;
ALTER TABLE ad_reportview_column
	DROP CONSTRAINT updatedby_adreportviewcolumn;
ALTER TABLE ad_role
	DROP CONSTRAINT adusersupervisor_adrole;
ALTER TABLE ad_scheduler
	DROP CONSTRAINT aduser_adscheduler;
ALTER TABLE ad_schedulerrecipient
	DROP CONSTRAINT aduser_adschedulerrecipient;
ALTER TABLE ad_statusline
	DROP CONSTRAINT createdby_adstatusline;
ALTER TABLE ad_statusline
	DROP CONSTRAINT updatedby_adstatusline;
ALTER TABLE ad_statuslineusedin
	DROP CONSTRAINT createdby_adstatuslineusedin;
ALTER TABLE ad_statuslineusedin
	DROP CONSTRAINT updatedby_adstatuslineusedin;
ALTER TABLE ad_tab_customization
	DROP CONSTRAINT aduser_adtabcustomization;
ALTER TABLE ad_tree_favorite
	DROP CONSTRAINT aduser_adtreefavorite;
ALTER TABLE ad_treebar
	DROP CONSTRAINT aduser_adtreebar;
ALTER TABLE ad_user
	DROP CONSTRAINT aduser_supervisor;
ALTER TABLE ad_user
	DROP CONSTRAINT salesrep_aduser;
ALTER TABLE ad_user_orgaccess
	DROP CONSTRAINT aduser_aduserorgaccess;
ALTER TABLE ad_user_roles
	DROP CONSTRAINT aduser_userroles;
ALTER TABLE ad_user_substitute
	DROP CONSTRAINT aduser_adusersub;
ALTER TABLE ad_user_substitute
	DROP CONSTRAINT adusersub_ad_usersub;
ALTER TABLE ad_userbpaccess
	DROP CONSTRAINT aduser_aduserbpaccess;
ALTER TABLE ad_userdef_field
	DROP CONSTRAINT aduserdeftab_aduserdeffield;
ALTER TABLE ad_userdef_info
	DROP CONSTRAINT aduser_aduserdefinfo;
ALTER TABLE ad_userdef_info_column
	DROP CONSTRAINT aduserdefinfo_aduserdefinfocol;
ALTER TABLE ad_userdef_info_related
	DROP CONSTRAINT aduserdefinfo_aduserdefinforel;
ALTER TABLE ad_userdef_proc
	DROP CONSTRAINT aduser_aduserdefproc;
ALTER TABLE ad_userdef_proc_parameter
	DROP CONSTRAINT aduserdefproc_aduserdefprocpar;
ALTER TABLE ad_userdef_tab
	DROP CONSTRAINT aduserdefwin_aduserdeftab;
ALTER TABLE ad_userdef_win
	DROP CONSTRAINT aduser_aduserdefwin;
ALTER TABLE ad_usermail
	DROP CONSTRAINT aduser_adusermail;
ALTER TABLE ad_userpreference
	DROP CONSTRAINT aduser_aduserpreference;
ALTER TABLE ad_userpreference
	DROP CONSTRAINT createdby_aduserpreference;
ALTER TABLE ad_userpreference
	DROP CONSTRAINT updatedby_aduserpreference;
ALTER TABLE ad_userquery
	DROP CONSTRAINT aduser_aduserquery;
ALTER TABLE ad_verifymigration
	DROP CONSTRAINT createdby_adverifymigration;
ALTER TABLE ad_verifymigration
	DROP CONSTRAINT updatedby_adverifymigration;
ALTER TABLE ad_wf_activity
	DROP CONSTRAINT aduser_adwfactivity;
ALTER TABLE ad_wf_activityapprover
	DROP CONSTRAINT aduser_adwfactivityapprover;
ALTER TABLE ad_wf_eventaudit
	DROP CONSTRAINT aduser_adwfeventaudit;
ALTER TABLE ad_wf_process
	DROP CONSTRAINT aduser_adwfprocess;
ALTER TABLE ad_wf_responsible
	DROP CONSTRAINT aduser_adwfresponsible;
ALTER TABLE ad_wizardprocess
	DROP CONSTRAINT aduser_adwizardprocess;
ALTER TABLE ad_wlistbox_customization
	DROP CONSTRAINT aduser_adwlistboxcustomization;
ALTER TABLE ad_workflowprocessor
	DROP CONSTRAINT aduser_adworkflowprocessor;
ALTER TABLE b_bid
	DROP CONSTRAINT aduser_bbid;
ALTER TABLE b_bid
	DROP CONSTRAINT bbuyer_bbid;
ALTER TABLE b_bidcomment
	DROP CONSTRAINT aduser_bidcomment;
ALTER TABLE b_buyer
	DROP CONSTRAINT aduser_bbuyer;
ALTER TABLE b_buyerfunds
	DROP CONSTRAINT aduser_bbuyerfunds;
ALTER TABLE b_buyerfunds
	DROP CONSTRAINT bbuyer_bbuyerfunds;
ALTER TABLE b_offer
	DROP CONSTRAINT aduser_boffer;
ALTER TABLE b_offer
	DROP CONSTRAINT bseller_boffer;
ALTER TABLE b_seller
	DROP CONSTRAINT aduser_bseller;
ALTER TABLE b_sellerfunds
	DROP CONSTRAINT aduser_bsellerfunds;
ALTER TABLE b_sellerfunds
	DROP CONSTRAINT bseller_bsellerfunds;
ALTER TABLE bh_graphqlgeneratortemplate
	DROP CONSTRAINT createdby_bhgraphqlgeneratorte;
ALTER TABLE bh_graphqlgeneratortemplate
	DROP CONSTRAINT updatedby_bhgraphqlgeneratorte;
ALTER TABLE c_acctprocessor
	DROP CONSTRAINT aduser_cacctprocessor;
ALTER TABLE c_activity_trl
	DROP CONSTRAINT createdby_cactivitytrl;
ALTER TABLE c_activity_trl
	DROP CONSTRAINT updatedby_cactivitytrl;
ALTER TABLE c_addresstransaction
	DROP CONSTRAINT createdby_caddresstransaction;
ALTER TABLE c_addresstransaction
	DROP CONSTRAINT updatedby_caddresstransaction;
ALTER TABLE c_addressvalidation
	DROP CONSTRAINT createdby_caddressvalidation;
ALTER TABLE c_addressvalidation
	DROP CONSTRAINT updatedby_caddressvalidation;
ALTER TABLE c_addressvalidationcfg
	DROP CONSTRAINT createdby_caddressvalidationcf;
ALTER TABLE c_addressvalidationcfg
	DROP CONSTRAINT updatedby_caddressvalidationcf;
ALTER TABLE c_bp_bankaccount
	DROP CONSTRAINT aduser_cbpbankaccount;
ALTER TABLE c_bpartner
	DROP CONSTRAINT adusersalesrep_cbpartner;
ALTER TABLE c_campaign_trl
	DROP CONSTRAINT createdby_ccampaigntrl;
ALTER TABLE c_campaign_trl
	DROP CONSTRAINT updatedby_ccampaigntrl;
ALTER TABLE c_contactactivity
	DROP CONSTRAINT aduser_ccontactactivity;
ALTER TABLE c_contactactivity
	DROP CONSTRAINT salesrep_ccontactactivity;
ALTER TABLE c_countrygroup
	DROP CONSTRAINT createdby_ccountrygroup;
ALTER TABLE c_countrygroup
	DROP CONSTRAINT updatedby_ccountrygroup;
ALTER TABLE c_countrygroup_trl
	DROP CONSTRAINT createdby_ccountrygrouptrl;
ALTER TABLE c_countrygroup_trl
	DROP CONSTRAINT updatedby_ccountrygrouptrl;
ALTER TABLE c_countrygroupcountry
	DROP CONSTRAINT createdby_ccountrygroupcountry;
ALTER TABLE c_countrygroupcountry
	DROP CONSTRAINT updatedby_ccountrygroupcountry;
ALTER TABLE c_docbasegroup
	DROP CONSTRAINT createdby_cperioddocgroup;
ALTER TABLE c_docbasegroup
	DROP CONSTRAINT updatedby_cperioddocgroup;
ALTER TABLE c_docbasegroupline
	DROP CONSTRAINT createdby_cperioddocgroupline;
ALTER TABLE c_docbasegroupline
	DROP CONSTRAINT updatedby_cperioddocgroupline;
ALTER TABLE c_dunningrunentry
	DROP CONSTRAINT aduser_cdunningrunentry;
ALTER TABLE c_dunningrunentry
	DROP CONSTRAINT salesrep_cdunningrunentry;
ALTER TABLE c_invoice
	DROP CONSTRAINT aduser_cinvoice;
ALTER TABLE c_invoice
	DROP CONSTRAINT aduser_sr_cinvoice;
ALTER TABLE c_invoicebatch
	DROP CONSTRAINT aduser_cinvoicebatch;
ALTER TABLE c_invoicebatchline
	DROP CONSTRAINT aduser_cinvoicebatchline;
ALTER TABLE c_jobassignment
	DROP CONSTRAINT aduser_cjobassignment;
ALTER TABLE c_opportunity
	DROP CONSTRAINT aduser_copportunity;
ALTER TABLE c_opportunity
	DROP CONSTRAINT salesrep_copportunity;
ALTER TABLE c_order
	DROP CONSTRAINT aduser_corder;
ALTER TABLE c_order
	DROP CONSTRAINT aduser_sr_corder;
ALTER TABLE c_order
	DROP CONSTRAINT aduserbill_corder;
ALTER TABLE c_order
	DROP CONSTRAINT dropshipuser_corder;
ALTER TABLE c_ordersource
	DROP CONSTRAINT aduser1_cordersource;
ALTER TABLE c_ordersource
	DROP CONSTRAINT aduser2_cordersource;
ALTER TABLE c_orgassignment
	DROP CONSTRAINT aduser_corgassignment;
ALTER TABLE c_pos
	DROP CONSTRAINT aduser_cpos;
ALTER TABLE c_project
	DROP CONSTRAINT aduser_cproject;
ALTER TABLE c_project
	DROP CONSTRAINT aduser_sr_cproject;
ALTER TABLE c_recurringgroup
	DROP CONSTRAINT createdby_crecurringgroup;
ALTER TABLE c_recurringgroup
	DROP CONSTRAINT updatedby_crecurringgroup;
ALTER TABLE c_region_trl
	DROP CONSTRAINT createdby_cregiontrl;
ALTER TABLE c_region_trl
	DROP CONSTRAINT updatedby_cregiontrl;
ALTER TABLE c_revenuerecog_service
	DROP CONSTRAINT createdby_crevenuerecogservice;
ALTER TABLE c_revenuerecog_service
	DROP CONSTRAINT updatedby_crevenuerecogservice;
ALTER TABLE c_rfq
	DROP CONSTRAINT aduser_crfq;
ALTER TABLE c_rfq
	DROP CONSTRAINT adusersalesrep_crfq;
ALTER TABLE c_rfq_topicsubscriber
	DROP CONSTRAINT aduser_arfqtopicsubcr;
ALTER TABLE c_rfqresponse
	DROP CONSTRAINT aduser_crfqresponse;
ALTER TABLE c_salesregion
	DROP CONSTRAINT salesrep_csalesregion;
ALTER TABLE c_salesregion_trl
	DROP CONSTRAINT createdby_csalesregiontrl;
ALTER TABLE c_salesregion_trl
	DROP CONSTRAINT updatedby_csalesregiontrl;
ALTER TABLE c_salesstage_trl
	DROP CONSTRAINT createdby_csalesstagetrl;
ALTER TABLE c_salesstage_trl
	DROP CONSTRAINT updatedby_csalesstagetrl;
ALTER TABLE c_taxprovider
	DROP CONSTRAINT createdby_ctaxprovider;
ALTER TABLE c_taxprovider
	DROP CONSTRAINT updatedby_ctaxprovider;
ALTER TABLE c_taxprovidercfg
	DROP CONSTRAINT createdby_adtaxprovider;
ALTER TABLE c_taxprovidercfg
	DROP CONSTRAINT updatedby_adtaxprovider;
ALTER TABLE c_userremuneration
	DROP CONSTRAINT aduser_cuserremuneration;
ALTER TABLE cm_chatentry
	DROP CONSTRAINT aduser_cmchatentry;
ALTER TABLE cm_chattypeupdate
	DROP CONSTRAINT aduser_cmchattypeupdate;
ALTER TABLE cm_chatupdate
	DROP CONSTRAINT aduser_cmchatupdate;
ALTER TABLE cm_webaccesslog
	DROP CONSTRAINT aduser_cmwebaccesslog;
ALTER TABLE dd_order
	DROP CONSTRAINT aduser_ddorder;
ALTER TABLE dd_order
	DROP CONSTRAINT salesrep_ddorder;
ALTER TABLE gl_category_trl
	DROP CONSTRAINT createdby_glcategorytrl;
ALTER TABLE gl_category_trl
	DROP CONSTRAINT updatedby_glcategorytrl;
ALTER TABLE hr_job
	DROP CONSTRAINT supervisor_hrjob;
ALTER TABLE i_bpartner
	DROP CONSTRAINT aduser_ibpartner;
ALTER TABLE i_invoice
	DROP CONSTRAINT aduser_iinvoice;
ALTER TABLE i_invoice
	DROP CONSTRAINT adusersalesrep_iinvoice;
ALTER TABLE i_movement
	DROP CONSTRAINT aduser_imovement;
ALTER TABLE i_order
	DROP CONSTRAINT aduser_iorder;
ALTER TABLE i_order
	DROP CONSTRAINT adusersalesrep_iorder;
ALTER TABLE i_productplanning
	DROP CONSTRAINT planner_iproductplanning;
ALTER TABLE i_productplanning
	DROP CONSTRAINT salesrep_iproductplanning;
ALTER TABLE m_forecastline
	DROP CONSTRAINT salesrep_mforecastline;
ALTER TABLE m_inout
	DROP CONSTRAINT aduser_minout;
ALTER TABLE m_inout
	DROP CONSTRAINT aduser_sr_minout;
ALTER TABLE m_inout
	DROP CONSTRAINT dropshipuser_minout;
ALTER TABLE m_inout
	DROP CONSTRAINT returnuser_minout;
ALTER TABLE m_locatortype
	DROP CONSTRAINT createdby_mlocatortype;
ALTER TABLE m_locatortype
	DROP CONSTRAINT updatedby_mlocatortype;
ALTER TABLE m_movement
	DROP CONSTRAINT aduser_mmovement;
ALTER TABLE m_movement
	DROP CONSTRAINT salesrep_mmovement;
ALTER TABLE m_pricelist_trl
	DROP CONSTRAINT createdby_mpricelisttrl;
ALTER TABLE m_pricelist_trl
	DROP CONSTRAINT updatedby_mpricelisttrl;
ALTER TABLE m_pricelist_version_trl
	DROP CONSTRAINT createdby_mpricelistversiontrl;
ALTER TABLE m_pricelist_version_trl
	DROP CONSTRAINT updatedby_mpricelistversiontrl;
ALTER TABLE m_product
	DROP CONSTRAINT salesrep_mproduct;
ALTER TABLE m_product_category_trl
	DROP CONSTRAINT createdby_mproductcategorytrl;
ALTER TABLE m_product_category_trl
	DROP CONSTRAINT updatedby_mproductcategorytrl;
ALTER TABLE m_requisition
	DROP CONSTRAINT aduser_mrequisition;
ALTER TABLE m_rma
	DROP CONSTRAINT salesrep_mrma;
ALTER TABLE m_shippingtransaction
	DROP CONSTRAINT aduser_mshippingtransaction;
ALTER TABLE m_shippingtransaction
	DROP CONSTRAINT returnuser_mshippingtransactio;
ALTER TABLE m_shippingtransaction
	DROP CONSTRAINT salesrep_mshippingtransaction;
ALTER TABLE m_storagereservationlog
	DROP CONSTRAINT createdby_mstoragereservationl;
ALTER TABLE m_storagereservationlog
	DROP CONSTRAINT updatedby_mstoragereservationl;
ALTER TABLE mfa_registereddevice
	DROP CONSTRAINT aduser_mfaregistereddevice;
ALTER TABLE mfa_registration
	DROP CONSTRAINT aduser_mfaregistration;
ALTER TABLE pa_dashboardcontent
	DROP CONSTRAINT aduser_padashboardcontent;
ALTER TABLE pa_dashboardcontent_access
	DROP CONSTRAINT aduser_padashboardcontentacces;
ALTER TABLE pa_dashboardcontent_access
	DROP CONSTRAINT createdby_padashboardcontentac;
ALTER TABLE pa_dashboardcontent_access
	DROP CONSTRAINT updatedby_padashboardcontentac;
ALTER TABLE pa_dashboardpreference
	DROP CONSTRAINT aduser_padashboardpreference;
ALTER TABLE pa_documentstatus
	DROP CONSTRAINT aduser_padocumentstatus;
ALTER TABLE pa_documentstatusaccess
	DROP CONSTRAINT aduser_padocumentstatusaccess;
ALTER TABLE pa_goal
	DROP CONSTRAINT aduser_pagoal;
ALTER TABLE pp_cost_collector
	DROP CONSTRAINT aduser_ppcostcollector;
ALTER TABLE pp_cost_collector
	DROP CONSTRAINT user1_ppcostcollector;
ALTER TABLE pp_cost_collector
	DROP CONSTRAINT user2_ppcostcollector;
ALTER TABLE pp_mrp
	DROP CONSTRAINT planner_ppmrp;
ALTER TABLE pp_order
	DROP CONSTRAINT planner_pporder;
ALTER TABLE pp_order_bomline
	DROP CONSTRAINT aduser_pporderbomline;
ALTER TABLE pp_product_planning
	DROP CONSTRAINT planner_ppproductplanning;
ALTER TABLE r_categoryupdates
	DROP CONSTRAINT aduser_rcategoryupdates;
ALTER TABLE r_contactinterest
	DROP CONSTRAINT aduser_rcontactinterest;
ALTER TABLE r_groupupdates
	DROP CONSTRAINT aduser_ruserupdates;
ALTER TABLE r_issueuser
	DROP CONSTRAINT aduser_rissueuser;
ALTER TABLE r_request
	DROP CONSTRAINT aduser_rrequest;
ALTER TABLE r_request
	DROP CONSTRAINT adusersr_rrequest;
ALTER TABLE r_requestaction
	DROP CONSTRAINT aduser_rrequestaction;
ALTER TABLE r_requestaction
	DROP CONSTRAINT adusersr_rrequestaction;
ALTER TABLE r_requestprocessor
	DROP CONSTRAINT aduser_rrequestprocessor;
ALTER TABLE r_requestprocessor_route
	DROP CONSTRAINT aduser_rrequestprocessorroute;
ALTER TABLE r_requesttypeupdates
	DROP CONSTRAINT aduser_rrequesttypeupdates;
ALTER TABLE r_requestupdates
	DROP CONSTRAINT aduser_rrequestupdates;
ALTER TABLE s_resource
	DROP CONSTRAINT aduser_sresource;
ALTER TABLE testuu
	DROP CONSTRAINT createdby_testuu;
ALTER TABLE testuu
	DROP CONSTRAINT updatedby_testuu;
ALTER TABLE testuu_trl
	DROP CONSTRAINT createdby_testuutrl;
ALTER TABLE testuu_trl
	DROP CONSTRAINT updatedby_testuutrl;
ALTER TABLE testuudet
	DROP CONSTRAINT createdby_testuudet;
ALTER TABLE testuudet
	DROP CONSTRAINT updatedby_testuudet;
ALTER TABLE u_posterminal
	DROP CONSTRAINT salesrep_uposterminal;
ALTER TABLE w_advertisement
	DROP CONSTRAINT aduser_wadvertisement;
ALTER TABLE w_basket
	DROP CONSTRAINT aduser_wbasket;
ALTER TABLE w_click
	DROP CONSTRAINT aduser_wclick;
ALTER TABLE w_counter
	DROP CONSTRAINT aduser_wcounter;
ALTER TABLE w_store
	DROP CONSTRAINT salesrep_wstore;
ALTER TABLE ad_private_access
	DROP CONSTRAINT ad_private_access_pkey;
ALTER TABLE ad_treebar
	DROP CONSTRAINT ad_treebar_pkey;
ALTER TABLE ad_user
	DROP CONSTRAINT ad_user_pkey;
ALTER TABLE ad_user_orgaccess
	DROP CONSTRAINT ad_user_orgaccess_pkey;
ALTER TABLE ad_user_roles
	DROP CONSTRAINT ad_user_roles_pkey;
ALTER TABLE ad_user_substitute
	DROP CONSTRAINT ad_user_substitute_pkey;
ALTER TABLE ad_userbpaccess
	DROP CONSTRAINT ad_userbpaccess_pkey;
ALTER TABLE ad_userdef_field
	DROP CONSTRAINT ad_userdef_field_pkey;
ALTER TABLE ad_userdef_info
	DROP CONSTRAINT ad_userdef_info_key;
ALTER TABLE ad_userdef_info_column
	DROP CONSTRAINT ad_userdef_info_column_key;
ALTER TABLE ad_userdef_info_related
	DROP CONSTRAINT ad_userdef_info_related_key;
ALTER TABLE ad_userdef_proc
	DROP CONSTRAINT ad_userdef_proc_key;
ALTER TABLE ad_userdef_proc_parameter
	DROP CONSTRAINT ad_userdef_proc_parameter_key;
ALTER TABLE ad_userdef_tab
	DROP CONSTRAINT ad_userdef_tab_pkey;
ALTER TABLE ad_userdef_win
	DROP CONSTRAINT ad_userdef_win_pkey;
ALTER TABLE ad_usermail
	DROP CONSTRAINT ad_usermail_pkey;
ALTER TABLE ad_userpreference
	DROP CONSTRAINT ad_userpreference_key;
ALTER TABLE ad_userquery
	DROP CONSTRAINT ad_userquery_pkey;
ALTER TABLE b_buyer
	DROP CONSTRAINT b_buyer_pkey;
ALTER TABLE b_seller
	DROP CONSTRAINT b_seller_pkey;
ALTER TABLE cm_chattypeupdate
	DROP CONSTRAINT cm_chattypeupdate_pkey;
ALTER TABLE cm_chatupdate
	DROP CONSTRAINT cm_chatupdate_pkey;
ALTER TABLE r_categoryupdates
	DROP CONSTRAINT r_categoryupdates_pkey;
ALTER TABLE r_contactinterest
	DROP CONSTRAINT r_contactinterest_key;
ALTER TABLE r_groupupdates
	DROP CONSTRAINT r_groupupdates_pkey;
ALTER TABLE r_requesttypeupdates
	DROP CONSTRAINT r_requesttypeupdates_pkey;
ALTER TABLE r_requestupdates
	DROP CONSTRAINT r_requestupdates_pkey;
ALTER TABLE ad_user
	DROP CONSTRAINT ad_user_uu_idx;
ALTER TABLE ad_user_orgaccess
	DROP CONSTRAINT ad_user_orgaccess_uu_idx;
ALTER TABLE ad_user_roles
	DROP CONSTRAINT ad_user_roles_uu_idx;
ALTER TABLE ad_user_substitute
	DROP CONSTRAINT ad_user_substitute_uu_idx;
ALTER TABLE ad_userbpaccess
	DROP CONSTRAINT ad_userbpaccess_uu_idx;
ALTER TABLE ad_userdef_field
	DROP CONSTRAINT ad_userdef_field_uu_idx;
ALTER TABLE ad_userdef_info
	DROP CONSTRAINT ad_userdef_info_uu_idx;
ALTER TABLE ad_userdef_info_column
	DROP CONSTRAINT ad_userdef_info_column_uu_idx;
ALTER TABLE ad_userdef_info_related
	DROP CONSTRAINT ad_userdef_info_related_uu_idx;
ALTER TABLE ad_userdef_proc
	DROP CONSTRAINT ad_userdef_proc_uu_idx;
ALTER TABLE ad_userdef_proc_parameter
	DROP CONSTRAINT ad_userdef_proc_parameteruuidx;
ALTER TABLE ad_userdef_tab
	DROP CONSTRAINT ad_userdef_tab_uu_idx;
ALTER TABLE ad_userdef_win
	DROP CONSTRAINT ad_userdef_win_uu_idx;
ALTER TABLE ad_usermail
	DROP CONSTRAINT ad_usermail_uu_idx;
ALTER TABLE ad_userpreference
	DROP CONSTRAINT ad_userpreference_uu_idx;
ALTER TABLE ad_userquery
	DROP CONSTRAINT ad_userquery_uu_idx;

DELETE
FROM
	ad_user
WHERE
	ad_user_id IN (
		SELECT
			t.ad_user_id
		FROM
			(
				SELECT
					ad_user_id,
					ROW_NUMBER() OVER (PARTITION BY c_bpartner_id ORDER BY created DESC) row_num
				FROM
					ad_user
				WHERE
					ad_client_id > 999999
					AND c_bpartner_id IS NOT NULL
			) t
		WHERE
			row_num != 1
	);

ALTER TABLE ad_userquery
	ADD CONSTRAINT ad_userquery_uu_idx UNIQUE (ad_userquery_uu);
ALTER TABLE ad_userpreference
	ADD CONSTRAINT ad_userpreference_uu_idx UNIQUE (ad_userpreference_uu);
ALTER TABLE ad_usermail
	ADD CONSTRAINT ad_usermail_uu_idx UNIQUE (ad_usermail_uu);
ALTER TABLE ad_userdef_win
	ADD CONSTRAINT ad_userdef_win_uu_idx UNIQUE (ad_userdef_win_uu);
ALTER TABLE ad_userdef_tab
	ADD CONSTRAINT ad_userdef_tab_uu_idx UNIQUE (ad_userdef_tab_uu);
ALTER TABLE ad_userdef_proc_parameter
	ADD CONSTRAINT ad_userdef_proc_parameteruuidx UNIQUE (ad_userdef_proc_parameter_uu);
ALTER TABLE ad_userdef_proc
	ADD CONSTRAINT ad_userdef_proc_uu_idx UNIQUE (ad_userdef_proc_uu);
ALTER TABLE ad_userdef_info_related
	ADD CONSTRAINT ad_userdef_info_related_uu_idx UNIQUE (ad_userdef_info_related_uu);
ALTER TABLE ad_userdef_info_column
	ADD CONSTRAINT ad_userdef_info_column_uu_idx UNIQUE (ad_userdef_info_column_uu);
ALTER TABLE ad_userdef_info
	ADD CONSTRAINT ad_userdef_info_uu_idx UNIQUE (ad_userdef_info_uu);
ALTER TABLE ad_userdef_field
	ADD CONSTRAINT ad_userdef_field_uu_idx UNIQUE (ad_userdef_field_uu);
ALTER TABLE ad_userbpaccess
	ADD CONSTRAINT ad_userbpaccess_uu_idx UNIQUE (ad_userbpaccess_uu);
ALTER TABLE ad_user_substitute
	ADD CONSTRAINT ad_user_substitute_uu_idx UNIQUE (ad_user_substitute_uu);
ALTER TABLE ad_user_roles
	ADD CONSTRAINT ad_user_roles_uu_idx UNIQUE (ad_user_roles_uu);
ALTER TABLE ad_user_orgaccess
	ADD CONSTRAINT ad_user_orgaccess_uu_idx UNIQUE (ad_user_orgaccess_uu);
ALTER TABLE ad_user
	ADD CONSTRAINT ad_user_uu_idx UNIQUE (ad_user_uu);
ALTER TABLE r_requestupdates
	ADD CONSTRAINT r_requestupdates_pkey PRIMARY KEY (ad_user_id, r_request_id);
ALTER TABLE r_requesttypeupdates
	ADD CONSTRAINT r_requesttypeupdates_pkey PRIMARY KEY (ad_user_id, r_requesttype_id);
ALTER TABLE r_groupupdates
	ADD CONSTRAINT r_groupupdates_pkey PRIMARY KEY (ad_user_id, r_group_id);
ALTER TABLE r_contactinterest
	ADD CONSTRAINT r_contactinterest_key PRIMARY KEY (ad_user_id, r_interestarea_id);
ALTER TABLE r_categoryupdates
	ADD CONSTRAINT r_categoryupdates_pkey PRIMARY KEY (ad_user_id, r_category_id);
ALTER TABLE cm_chatupdate
	ADD CONSTRAINT cm_chatupdate_pkey PRIMARY KEY (cm_chat_id, ad_user_id);
ALTER TABLE cm_chattypeupdate
	ADD CONSTRAINT cm_chattypeupdate_pkey PRIMARY KEY (cm_chattype_id, ad_user_id);
ALTER TABLE b_seller
	ADD CONSTRAINT b_seller_pkey PRIMARY KEY (ad_user_id);
ALTER TABLE b_buyer
	ADD CONSTRAINT b_buyer_pkey PRIMARY KEY (ad_user_id);
ALTER TABLE ad_userquery
	ADD CONSTRAINT ad_userquery_pkey PRIMARY KEY (ad_userquery_id);
ALTER TABLE ad_userpreference
	ADD CONSTRAINT ad_userpreference_key PRIMARY KEY (ad_userpreference_id);
ALTER TABLE ad_usermail
	ADD CONSTRAINT ad_usermail_pkey PRIMARY KEY (ad_usermail_id);
ALTER TABLE ad_userdef_win
	ADD CONSTRAINT ad_userdef_win_pkey PRIMARY KEY (ad_userdef_win_id);
ALTER TABLE ad_userdef_tab
	ADD CONSTRAINT ad_userdef_tab_pkey PRIMARY KEY (ad_userdef_tab_id);
ALTER TABLE ad_userdef_proc_parameter
	ADD CONSTRAINT ad_userdef_proc_parameter_key PRIMARY KEY (ad_userdef_proc_parameter_id);
ALTER TABLE ad_userdef_proc
	ADD CONSTRAINT ad_userdef_proc_key PRIMARY KEY (ad_userdef_proc_id);
ALTER TABLE ad_userdef_info_related
	ADD CONSTRAINT ad_userdef_info_related_key PRIMARY KEY (ad_userdef_info_related_id);
ALTER TABLE ad_userdef_info_column
	ADD CONSTRAINT ad_userdef_info_column_key PRIMARY KEY (ad_userdef_info_column_id);
ALTER TABLE ad_userdef_info
	ADD CONSTRAINT ad_userdef_info_key PRIMARY KEY (ad_userdef_info_id);
ALTER TABLE ad_userdef_field
	ADD CONSTRAINT ad_userdef_field_pkey PRIMARY KEY (ad_userdef_field_id);
ALTER TABLE ad_userbpaccess
	ADD CONSTRAINT ad_userbpaccess_pkey PRIMARY KEY (ad_userbpaccess_id);
ALTER TABLE ad_user_substitute
	ADD CONSTRAINT ad_user_substitute_pkey PRIMARY KEY (ad_user_substitute_id);
ALTER TABLE ad_user_roles
	ADD CONSTRAINT ad_user_roles_pkey PRIMARY KEY (ad_user_id, ad_role_id);
ALTER TABLE ad_user_orgaccess
	ADD CONSTRAINT ad_user_orgaccess_pkey PRIMARY KEY (ad_user_id, ad_org_id);
ALTER TABLE ad_user
	ADD CONSTRAINT ad_user_pkey PRIMARY KEY (ad_user_id);
ALTER TABLE ad_treebar
	ADD CONSTRAINT ad_treebar_pkey PRIMARY KEY (ad_tree_id, ad_user_id, node_id);
ALTER TABLE ad_private_access
	ADD CONSTRAINT ad_private_access_pkey PRIMARY KEY (ad_user_id, ad_table_id, record_id);
ALTER TABLE w_store
	ADD CONSTRAINT salesrep_wstore FOREIGN KEY (salesrep_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE w_counter
	ADD CONSTRAINT aduser_wcounter FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE w_click
	ADD CONSTRAINT aduser_wclick FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE w_basket
	ADD CONSTRAINT aduser_wbasket FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE w_advertisement
	ADD CONSTRAINT aduser_wadvertisement FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE u_posterminal
	ADD CONSTRAINT salesrep_uposterminal FOREIGN KEY (salesrep_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE testuudet
	ADD CONSTRAINT updatedby_testuudet FOREIGN KEY (updatedby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE testuudet
	ADD CONSTRAINT createdby_testuudet FOREIGN KEY (createdby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE testuu_trl
	ADD CONSTRAINT updatedby_testuutrl FOREIGN KEY (updatedby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE testuu_trl
	ADD CONSTRAINT createdby_testuutrl FOREIGN KEY (createdby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE testuu
	ADD CONSTRAINT updatedby_testuu FOREIGN KEY (updatedby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE testuu
	ADD CONSTRAINT createdby_testuu FOREIGN KEY (createdby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE s_resource
	ADD CONSTRAINT aduser_sresource FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE r_requestupdates
	ADD CONSTRAINT aduser_rrequestupdates FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE r_requesttypeupdates
	ADD CONSTRAINT aduser_rrequesttypeupdates FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE r_requestprocessor_route
	ADD CONSTRAINT aduser_rrequestprocessorroute FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE r_requestprocessor
	ADD CONSTRAINT aduser_rrequestprocessor FOREIGN KEY (supervisor_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE r_requestaction
	ADD CONSTRAINT adusersr_rrequestaction FOREIGN KEY (salesrep_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE r_requestaction
	ADD CONSTRAINT aduser_rrequestaction FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE r_request
	ADD CONSTRAINT adusersr_rrequest FOREIGN KEY (salesrep_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE r_request
	ADD CONSTRAINT aduser_rrequest FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE r_issueuser
	ADD CONSTRAINT aduser_rissueuser FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE r_groupupdates
	ADD CONSTRAINT aduser_ruserupdates FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE r_contactinterest
	ADD CONSTRAINT aduser_rcontactinterest FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE r_categoryupdates
	ADD CONSTRAINT aduser_rcategoryupdates FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE pp_product_planning
	ADD CONSTRAINT planner_ppproductplanning FOREIGN KEY (planner_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE pp_order_bomline
	ADD CONSTRAINT aduser_pporderbomline FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE pp_order
	ADD CONSTRAINT planner_pporder FOREIGN KEY (planner_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE pp_mrp
	ADD CONSTRAINT planner_ppmrp FOREIGN KEY (planner_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE pp_cost_collector
	ADD CONSTRAINT user2_ppcostcollector FOREIGN KEY (user2_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE pp_cost_collector
	ADD CONSTRAINT user1_ppcostcollector FOREIGN KEY (user1_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE pp_cost_collector
	ADD CONSTRAINT aduser_ppcostcollector FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE pa_goal
	ADD CONSTRAINT aduser_pagoal FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE pa_documentstatusaccess
	ADD CONSTRAINT aduser_padocumentstatusaccess FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE pa_documentstatus
	ADD CONSTRAINT aduser_padocumentstatus FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE pa_dashboardpreference
	ADD CONSTRAINT aduser_padashboardpreference FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE pa_dashboardcontent_access
	ADD CONSTRAINT updatedby_padashboardcontentac FOREIGN KEY (updatedby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE pa_dashboardcontent_access
	ADD CONSTRAINT createdby_padashboardcontentac FOREIGN KEY (createdby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE pa_dashboardcontent_access
	ADD CONSTRAINT aduser_padashboardcontentacces FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE pa_dashboardcontent
	ADD CONSTRAINT aduser_padashboardcontent FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE mfa_registration
	ADD CONSTRAINT aduser_mfaregistration FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE mfa_registereddevice
	ADD CONSTRAINT aduser_mfaregistereddevice FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE m_storagereservationlog
	ADD CONSTRAINT updatedby_mstoragereservationl FOREIGN KEY (updatedby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE m_storagereservationlog
	ADD CONSTRAINT createdby_mstoragereservationl FOREIGN KEY (createdby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE m_shippingtransaction
	ADD CONSTRAINT salesrep_mshippingtransaction FOREIGN KEY (salesrep_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE m_shippingtransaction
	ADD CONSTRAINT returnuser_mshippingtransactio FOREIGN KEY (returnuser_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE m_shippingtransaction
	ADD CONSTRAINT aduser_mshippingtransaction FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE m_rma
	ADD CONSTRAINT salesrep_mrma FOREIGN KEY (salesrep_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE m_requisition
	ADD CONSTRAINT aduser_mrequisition FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE m_product_category_trl
	ADD CONSTRAINT updatedby_mproductcategorytrl FOREIGN KEY (updatedby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE m_product_category_trl
	ADD CONSTRAINT createdby_mproductcategorytrl FOREIGN KEY (createdby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE m_product
	ADD CONSTRAINT salesrep_mproduct FOREIGN KEY (salesrep_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE m_pricelist_version_trl
	ADD CONSTRAINT updatedby_mpricelistversiontrl FOREIGN KEY (updatedby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE m_pricelist_version_trl
	ADD CONSTRAINT createdby_mpricelistversiontrl FOREIGN KEY (createdby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE m_pricelist_trl
	ADD CONSTRAINT updatedby_mpricelisttrl FOREIGN KEY (updatedby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE m_pricelist_trl
	ADD CONSTRAINT createdby_mpricelisttrl FOREIGN KEY (createdby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE m_movement
	ADD CONSTRAINT salesrep_mmovement FOREIGN KEY (salesrep_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE m_movement
	ADD CONSTRAINT aduser_mmovement FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE m_locatortype
	ADD CONSTRAINT updatedby_mlocatortype FOREIGN KEY (updatedby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE m_locatortype
	ADD CONSTRAINT createdby_mlocatortype FOREIGN KEY (createdby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE m_inout
	ADD CONSTRAINT returnuser_minout FOREIGN KEY (returnuser_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE m_inout
	ADD CONSTRAINT dropshipuser_minout FOREIGN KEY (dropship_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE m_inout
	ADD CONSTRAINT aduser_sr_minout FOREIGN KEY (salesrep_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE m_inout
	ADD CONSTRAINT aduser_minout FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE m_forecastline
	ADD CONSTRAINT salesrep_mforecastline FOREIGN KEY (salesrep_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE i_productplanning
	ADD CONSTRAINT salesrep_iproductplanning FOREIGN KEY (salesrep_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE i_productplanning
	ADD CONSTRAINT planner_iproductplanning FOREIGN KEY (planner_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE i_order
	ADD CONSTRAINT adusersalesrep_iorder FOREIGN KEY (salesrep_id) REFERENCES ad_user (ad_user_id) ON DELETE SET NULL DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE i_order
	ADD CONSTRAINT aduser_iorder FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) ON DELETE SET NULL DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE i_movement
	ADD CONSTRAINT aduser_imovement FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE i_invoice
	ADD CONSTRAINT adusersalesrep_iinvoice FOREIGN KEY (salesrep_id) REFERENCES ad_user (ad_user_id) ON DELETE SET NULL DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE i_invoice
	ADD CONSTRAINT aduser_iinvoice FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) ON DELETE SET NULL DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE i_bpartner
	ADD CONSTRAINT aduser_ibpartner FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) ON DELETE SET NULL DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE hr_job
	ADD CONSTRAINT supervisor_hrjob FOREIGN KEY (supervisor_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE gl_category_trl
	ADD CONSTRAINT updatedby_glcategorytrl FOREIGN KEY (updatedby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE gl_category_trl
	ADD CONSTRAINT createdby_glcategorytrl FOREIGN KEY (createdby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE dd_order
	ADD CONSTRAINT salesrep_ddorder FOREIGN KEY (salesrep_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE dd_order
	ADD CONSTRAINT aduser_ddorder FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE cm_webaccesslog
	ADD CONSTRAINT aduser_cmwebaccesslog FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE cm_chatupdate
	ADD CONSTRAINT aduser_cmchatupdate FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) ON DELETE CASCADE DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE cm_chattypeupdate
	ADD CONSTRAINT aduser_cmchattypeupdate FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) ON DELETE CASCADE DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE cm_chatentry
	ADD CONSTRAINT aduser_cmchatentry FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_userremuneration
	ADD CONSTRAINT aduser_cuserremuneration FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_taxprovidercfg
	ADD CONSTRAINT updatedby_adtaxprovider FOREIGN KEY (updatedby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_taxprovidercfg
	ADD CONSTRAINT createdby_adtaxprovider FOREIGN KEY (createdby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_taxprovider
	ADD CONSTRAINT updatedby_ctaxprovider FOREIGN KEY (updatedby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_taxprovider
	ADD CONSTRAINT createdby_ctaxprovider FOREIGN KEY (createdby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_salesstage_trl
	ADD CONSTRAINT updatedby_csalesstagetrl FOREIGN KEY (updatedby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_salesstage_trl
	ADD CONSTRAINT createdby_csalesstagetrl FOREIGN KEY (createdby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_salesregion_trl
	ADD CONSTRAINT updatedby_csalesregiontrl FOREIGN KEY (updatedby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_salesregion_trl
	ADD CONSTRAINT createdby_csalesregiontrl FOREIGN KEY (createdby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_salesregion
	ADD CONSTRAINT salesrep_csalesregion FOREIGN KEY (salesrep_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_rfqresponse
	ADD CONSTRAINT aduser_crfqresponse FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_rfq_topicsubscriber
	ADD CONSTRAINT aduser_arfqtopicsubcr FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_rfq
	ADD CONSTRAINT adusersalesrep_crfq FOREIGN KEY (salesrep_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_rfq
	ADD CONSTRAINT aduser_crfq FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_revenuerecog_service
	ADD CONSTRAINT updatedby_crevenuerecogservice FOREIGN KEY (updatedby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_revenuerecog_service
	ADD CONSTRAINT createdby_crevenuerecogservice FOREIGN KEY (createdby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_region_trl
	ADD CONSTRAINT updatedby_cregiontrl FOREIGN KEY (updatedby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_region_trl
	ADD CONSTRAINT createdby_cregiontrl FOREIGN KEY (createdby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_recurringgroup
	ADD CONSTRAINT updatedby_crecurringgroup FOREIGN KEY (updatedby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_recurringgroup
	ADD CONSTRAINT createdby_crecurringgroup FOREIGN KEY (createdby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_project
	ADD CONSTRAINT aduser_sr_cproject FOREIGN KEY (salesrep_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_project
	ADD CONSTRAINT aduser_cproject FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) ON DELETE SET NULL DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_pos
	ADD CONSTRAINT aduser_cpos FOREIGN KEY (salesrep_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_orgassignment
	ADD CONSTRAINT aduser_corgassignment FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_ordersource
	ADD CONSTRAINT aduser2_cordersource FOREIGN KEY (updatedby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_ordersource
	ADD CONSTRAINT aduser1_cordersource FOREIGN KEY (createdby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_order
	ADD CONSTRAINT dropshipuser_corder FOREIGN KEY (dropship_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_order
	ADD CONSTRAINT aduserbill_corder FOREIGN KEY (bill_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_order
	ADD CONSTRAINT aduser_sr_corder FOREIGN KEY (salesrep_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_order
	ADD CONSTRAINT aduser_corder FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_opportunity
	ADD CONSTRAINT salesrep_copportunity FOREIGN KEY (salesrep_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_opportunity
	ADD CONSTRAINT aduser_copportunity FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_jobassignment
	ADD CONSTRAINT aduser_cjobassignment FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_invoicebatchline
	ADD CONSTRAINT aduser_cinvoicebatchline FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_invoicebatch
	ADD CONSTRAINT aduser_cinvoicebatch FOREIGN KEY (salesrep_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_invoice
	ADD CONSTRAINT aduser_sr_cinvoice FOREIGN KEY (salesrep_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_invoice
	ADD CONSTRAINT aduser_cinvoice FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_dunningrunentry
	ADD CONSTRAINT salesrep_cdunningrunentry FOREIGN KEY (salesrep_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_dunningrunentry
	ADD CONSTRAINT aduser_cdunningrunentry FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_docbasegroupline
	ADD CONSTRAINT updatedby_cperioddocgroupline FOREIGN KEY (updatedby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_docbasegroupline
	ADD CONSTRAINT createdby_cperioddocgroupline FOREIGN KEY (createdby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_docbasegroup
	ADD CONSTRAINT updatedby_cperioddocgroup FOREIGN KEY (updatedby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_docbasegroup
	ADD CONSTRAINT createdby_cperioddocgroup FOREIGN KEY (createdby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_countrygroupcountry
	ADD CONSTRAINT updatedby_ccountrygroupcountry FOREIGN KEY (updatedby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_countrygroupcountry
	ADD CONSTRAINT createdby_ccountrygroupcountry FOREIGN KEY (createdby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_countrygroup_trl
	ADD CONSTRAINT updatedby_ccountrygrouptrl FOREIGN KEY (updatedby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_countrygroup_trl
	ADD CONSTRAINT createdby_ccountrygrouptrl FOREIGN KEY (createdby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_countrygroup
	ADD CONSTRAINT updatedby_ccountrygroup FOREIGN KEY (updatedby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_countrygroup
	ADD CONSTRAINT createdby_ccountrygroup FOREIGN KEY (createdby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_contactactivity
	ADD CONSTRAINT salesrep_ccontactactivity FOREIGN KEY (salesrep_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_contactactivity
	ADD CONSTRAINT aduser_ccontactactivity FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_campaign_trl
	ADD CONSTRAINT updatedby_ccampaigntrl FOREIGN KEY (updatedby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_campaign_trl
	ADD CONSTRAINT createdby_ccampaigntrl FOREIGN KEY (createdby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_bpartner
	ADD CONSTRAINT adusersalesrep_cbpartner FOREIGN KEY (salesrep_id) REFERENCES ad_user (ad_user_id) ON DELETE SET NULL DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_bp_bankaccount
	ADD CONSTRAINT aduser_cbpbankaccount FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_addressvalidationcfg
	ADD CONSTRAINT updatedby_caddressvalidationcf FOREIGN KEY (updatedby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_addressvalidationcfg
	ADD CONSTRAINT createdby_caddressvalidationcf FOREIGN KEY (createdby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_addressvalidation
	ADD CONSTRAINT updatedby_caddressvalidation FOREIGN KEY (updatedby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_addressvalidation
	ADD CONSTRAINT createdby_caddressvalidation FOREIGN KEY (createdby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_addresstransaction
	ADD CONSTRAINT updatedby_caddresstransaction FOREIGN KEY (updatedby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_addresstransaction
	ADD CONSTRAINT createdby_caddresstransaction FOREIGN KEY (createdby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_activity_trl
	ADD CONSTRAINT updatedby_cactivitytrl FOREIGN KEY (updatedby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_activity_trl
	ADD CONSTRAINT createdby_cactivitytrl FOREIGN KEY (createdby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE c_acctprocessor
	ADD CONSTRAINT aduser_cacctprocessor FOREIGN KEY (supervisor_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE bh_graphqlgeneratortemplate
	ADD CONSTRAINT updatedby_bhgraphqlgeneratorte FOREIGN KEY (updatedby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE bh_graphqlgeneratortemplate
	ADD CONSTRAINT createdby_bhgraphqlgeneratorte FOREIGN KEY (createdby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE b_sellerfunds
	ADD CONSTRAINT bseller_bsellerfunds FOREIGN KEY (ad_user_id) REFERENCES b_seller (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE b_sellerfunds
	ADD CONSTRAINT aduser_bsellerfunds FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE b_seller
	ADD CONSTRAINT aduser_bseller FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE b_offer
	ADD CONSTRAINT bseller_boffer FOREIGN KEY (ad_user_id) REFERENCES b_seller (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE b_offer
	ADD CONSTRAINT aduser_boffer FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE b_buyerfunds
	ADD CONSTRAINT bbuyer_bbuyerfunds FOREIGN KEY (ad_user_id) REFERENCES b_buyer (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE b_buyerfunds
	ADD CONSTRAINT aduser_bbuyerfunds FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE b_buyer
	ADD CONSTRAINT aduser_bbuyer FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE b_bidcomment
	ADD CONSTRAINT aduser_bidcomment FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE b_bid
	ADD CONSTRAINT bbuyer_bbid FOREIGN KEY (ad_user_id) REFERENCES b_buyer (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE b_bid
	ADD CONSTRAINT aduser_bbid FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_workflowprocessor
	ADD CONSTRAINT aduser_adworkflowprocessor FOREIGN KEY (supervisor_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_wlistbox_customization
	ADD CONSTRAINT aduser_adwlistboxcustomization FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_wizardprocess
	ADD CONSTRAINT aduser_adwizardprocess FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_wf_responsible
	ADD CONSTRAINT aduser_adwfresponsible FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_wf_process
	ADD CONSTRAINT aduser_adwfprocess FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_wf_eventaudit
	ADD CONSTRAINT aduser_adwfeventaudit FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_wf_activityapprover
	ADD CONSTRAINT aduser_adwfactivityapprover FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_wf_activity
	ADD CONSTRAINT aduser_adwfactivity FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) ON DELETE SET NULL DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_verifymigration
	ADD CONSTRAINT updatedby_adverifymigration FOREIGN KEY (updatedby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_verifymigration
	ADD CONSTRAINT createdby_adverifymigration FOREIGN KEY (createdby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_userquery
	ADD CONSTRAINT aduser_aduserquery FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) ON DELETE CASCADE DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_userpreference
	ADD CONSTRAINT updatedby_aduserpreference FOREIGN KEY (updatedby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_userpreference
	ADD CONSTRAINT createdby_aduserpreference FOREIGN KEY (createdby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_userpreference
	ADD CONSTRAINT aduser_aduserpreference FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) ON DELETE CASCADE DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_usermail
	ADD CONSTRAINT aduser_adusermail FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) ON DELETE CASCADE DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_userdef_win
	ADD CONSTRAINT aduser_aduserdefwin FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_userdef_tab
	ADD CONSTRAINT aduserdefwin_aduserdeftab FOREIGN KEY (ad_userdef_win_id) REFERENCES ad_userdef_win (ad_userdef_win_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_userdef_proc_parameter
	ADD CONSTRAINT aduserdefproc_aduserdefprocpar FOREIGN KEY (ad_userdef_proc_id) REFERENCES ad_userdef_proc (ad_userdef_proc_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_userdef_proc
	ADD CONSTRAINT aduser_aduserdefproc FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_userdef_info_related
	ADD CONSTRAINT aduserdefinfo_aduserdefinforel FOREIGN KEY (ad_userdef_info_id) REFERENCES ad_userdef_info (ad_userdef_info_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_userdef_info_column
	ADD CONSTRAINT aduserdefinfo_aduserdefinfocol FOREIGN KEY (ad_userdef_info_id) REFERENCES ad_userdef_info (ad_userdef_info_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_userdef_info
	ADD CONSTRAINT aduser_aduserdefinfo FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_userdef_field
	ADD CONSTRAINT aduserdeftab_aduserdeffield FOREIGN KEY (ad_userdef_tab_id) REFERENCES ad_userdef_tab (ad_userdef_tab_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_userbpaccess
	ADD CONSTRAINT aduser_aduserbpaccess FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) ON DELETE CASCADE DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_user_substitute
	ADD CONSTRAINT adusersub_ad_usersub FOREIGN KEY (substitute_id) REFERENCES ad_user (ad_user_id) ON DELETE CASCADE DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_user_substitute
	ADD CONSTRAINT aduser_adusersub FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) ON DELETE CASCADE DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_user_roles
	ADD CONSTRAINT aduser_userroles FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) ON DELETE CASCADE DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_user_orgaccess
	ADD CONSTRAINT aduser_aduserorgaccess FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_user
	ADD CONSTRAINT salesrep_aduser FOREIGN KEY (salesrep_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_user
	ADD CONSTRAINT aduser_supervisor FOREIGN KEY (supervisor_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_treebar
	ADD CONSTRAINT aduser_adtreebar FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) ON DELETE CASCADE DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_tree_favorite
	ADD CONSTRAINT aduser_adtreefavorite FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_tab_customization
	ADD CONSTRAINT aduser_adtabcustomization FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) ON DELETE CASCADE DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_statuslineusedin
	ADD CONSTRAINT updatedby_adstatuslineusedin FOREIGN KEY (updatedby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_statuslineusedin
	ADD CONSTRAINT createdby_adstatuslineusedin FOREIGN KEY (createdby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_statusline
	ADD CONSTRAINT updatedby_adstatusline FOREIGN KEY (updatedby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_statusline
	ADD CONSTRAINT createdby_adstatusline FOREIGN KEY (createdby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_schedulerrecipient
	ADD CONSTRAINT aduser_adschedulerrecipient FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_scheduler
	ADD CONSTRAINT aduser_adscheduler FOREIGN KEY (supervisor_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_role
	ADD CONSTRAINT adusersupervisor_adrole FOREIGN KEY (supervisor_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_reportview_column
	ADD CONSTRAINT updatedby_adreportviewcolumn FOREIGN KEY (updatedby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_reportview_column
	ADD CONSTRAINT createdby_adreportviewcolumn FOREIGN KEY (createdby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_recentitem
	ADD CONSTRAINT aduser_adrecentitem FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) ON DELETE CASCADE DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_private_access
	ADD CONSTRAINT aduser_adprivateaccess FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_printcolor_trl
	ADD CONSTRAINT updatedby_adprintcolortrl FOREIGN KEY (updatedby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_printcolor_trl
	ADD CONSTRAINT createdby_adprintcolortrl FOREIGN KEY (createdby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_preference
	ADD CONSTRAINT ad_user_preference FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_postit
	ADD CONSTRAINT updatedby_adpostit FOREIGN KEY (updatedby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_postit
	ADD CONSTRAINT createdby_adpostit FOREIGN KEY (createdby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_pinstance
	ADD CONSTRAINT aduser_pinstance FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_password_history
	ADD CONSTRAINT updatedby_adpasswordhistory FOREIGN KEY (updatedby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_password_history
	ADD CONSTRAINT createdby_adpasswordhistory FOREIGN KEY (createdby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_password_history
	ADD CONSTRAINT aduser_adpasswordhistory FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_orginfo
	ADD CONSTRAINT aduser_adorginfo FOREIGN KEY (supervisor_id) REFERENCES ad_user (ad_user_id) ON DELETE SET NULL DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_note
	ADD CONSTRAINT aduser_adnote FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_modelgeneratortemplate
	ADD CONSTRAINT updatedby_admodelgeneratortemp FOREIGN KEY (updatedby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_modelgeneratortemplate
	ADD CONSTRAINT createdby_admodelgeneratortemp FOREIGN KEY (createdby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_ldapprocessor
	ADD CONSTRAINT aduser_adldapprocessor FOREIGN KEY (supervisor_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_ldapaccess
	ADD CONSTRAINT aduser_adldapaccess FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_labelcategory_trl
	ADD CONSTRAINT updatedby_adlabelcategorytrl FOREIGN KEY (updatedby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_labelcategory_trl
	ADD CONSTRAINT createdby_adlabelcategorytrl FOREIGN KEY (createdby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_label_trl
	ADD CONSTRAINT updatedby_adlabeltrl FOREIGN KEY (updatedby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_label_trl
	ADD CONSTRAINT createdby_adlabeltrl FOREIGN KEY (createdby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_inforelated
	ADD CONSTRAINT updatedby_adinforelated FOREIGN KEY (updatedby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_inforelated
	ADD CONSTRAINT createdby_adinforelated FOREIGN KEY (createdby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_importtemplateaccess
	ADD CONSTRAINT updatedby_adimporttemplateacce FOREIGN KEY (updatedby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_importtemplateaccess
	ADD CONSTRAINT createdby_adimporttemplateacce FOREIGN KEY (createdby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_importtemplate
	ADD CONSTRAINT updatedby_adimporttemplate FOREIGN KEY (updatedby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_importtemplate
	ADD CONSTRAINT createdby_adimporttemplate FOREIGN KEY (createdby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_fieldsuggestion
	ADD CONSTRAINT aduserclient_adfieldsuggestion FOREIGN KEY (ad_userclient_id) REFERENCES ad_client (ad_client_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_fieldsuggestion
	ADD CONSTRAINT aduser_adfieldsuggestion FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_ctxhelpsuggestion
	ADD CONSTRAINT aduserclient_adctxhelpsuggesti FOREIGN KEY (ad_userclient_id) REFERENCES ad_client (ad_client_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_ctxhelpsuggestion
	ADD CONSTRAINT aduser_adctxhelpsuggestion FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_color_trl
	ADD CONSTRAINT updatedby_adcolortrl FOREIGN KEY (updatedby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_color_trl
	ADD CONSTRAINT createdby_adcolortrl FOREIGN KEY (createdby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_chart_trl
	ADD CONSTRAINT updatedby_adcharttrl FOREIGN KEY (updatedby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_chart_trl
	ADD CONSTRAINT createdby_adcharttrl FOREIGN KEY (createdby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_broadcastmessage_trl
	ADD CONSTRAINT updatedby_adbroadcastmessagetr FOREIGN KEY (updatedby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_broadcastmessage_trl
	ADD CONSTRAINT createdby_adbroadcastmessagetr FOREIGN KEY (createdby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_broadcastmessage
	ADD CONSTRAINT aduser_adbroadcastmessage FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_authorizationaccount
	ADD CONSTRAINT aduser_adauthorizationaccount FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_attachmentnote
	ADD CONSTRAINT aduser_adattachmentnote FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_alertrecipient
	ADD CONSTRAINT aduser_adalertrecipient FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_alertprocessor
	ADD CONSTRAINT aduser_calertprocessor FOREIGN KEY (supervisor_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE a_registration
	ADD CONSTRAINT aduser_aregistration FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE a_asset_group_trl
	ADD CONSTRAINT updatedby_aassetgrouptrl FOREIGN KEY (updatedby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE a_asset_group_trl
	ADD CONSTRAINT createdby_aassetgrouptrl FOREIGN KEY (createdby) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE a_asset_delivery
	ADD CONSTRAINT aduser_aassetdelivery FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE a_asset_change
	ADD CONSTRAINT aduser_aassetchange FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE a_asset
	ADD CONSTRAINT aduser_aasset FOREIGN KEY (ad_user_id) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;


SELECT
	register_migration_script('202410091625_GO-3103.sql')
FROM
	dual;
