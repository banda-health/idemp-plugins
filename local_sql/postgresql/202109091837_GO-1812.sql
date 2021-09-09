create table if not exists bh_i_product_quantity
(
	ad_client_id numeric(10) not null,
	ad_org_id numeric(10) not null,
	bh_buyprice numeric default '0'::numeric not null,
	bh_buyprice_lot2 numeric(10) default NULL::numeric,
	bh_buyprice_lot3 numeric(10) default NULL::numeric,
	bh_guaranteedate_lot2 timestamp,
	bh_guaranteedate_lot3 timestamp,
	bh_hasexpiration char default 'N'::bpchar not null,
	bh_i_product_quantity_id numeric(10) not null,
	bh_i_product_quantity_uu varchar(36) default NULL::character varying,
	bh_initialquantity numeric default '0'::numeric not null,
	bh_initialquantity_lot2 numeric,
	bh_initialquantity_lot3 numeric(10) default NULL::numeric,
	bh_reorder_level numeric(10) default NULL::numeric,
	bh_sellprice numeric default '0'::numeric not null,
	categoryname varchar(60) default 'Pharmacy'::character varying not null,
	created timestamp default statement_timestamp() not null,
	createdby numeric(10) not null,
	description varchar(255) default NULL::character varying,
	guaranteedate timestamp,
	i_errormsg varchar(2000) default NULL::character varying,
	i_isimported char default NULL::bpchar,
	isactive char default 'Y'::bpchar not null,
	name varchar(60) default 'Product'::character varying not null,
	processed char default NULL::bpchar,
	processing char default NULL::bpchar,
	updated timestamp default statement_timestamp() not null,
	updatedby numeric(10) not null,
	m_product_id numeric(10) default NULL::numeric,
	bh_haslot3 char default NULL::bpchar,
	bh_haslot1 char default NULL::bpchar,
	bh_haslot2 char default NULL::bpchar,
	constraint bh_i_product_quantity_key
		primary key (bh_i_product_quantity_id),
	constraint bh_i_product_quantity_uu_idx
		unique (bh_i_product_quantity_uu),
	constraint adclient_bhiproductquantity
		foreign key (ad_client_id) references ad_client
			deferrable initially deferred,
	constraint adorg_bhiproductquantity
		foreign key (ad_org_id) references ad_org
			deferrable initially deferred,
	constraint mproduct_bhiproductquantity
		foreign key (m_product_id) references m_product
			deferrable initially deferred
);

alter table bh_i_product_quantity
	add constraint bh_i_product_quantity_isactive_check
		check (isactive = ANY (ARRAY['Y'::bpchar, 'N'::bpchar]));

alter table bh_i_product_quantity
	add constraint bh_i_product_quantity_processed_check
		check (processed = ANY (ARRAY['Y'::bpchar, 'N'::bpchar]));

alter table bh_i_product_quantity
	add constraint bh_i_product_quantity_bh_haslot3_check
		check (bh_haslot3 = ANY (ARRAY['Y'::bpchar, 'N'::bpchar]));

alter table bh_i_product_quantity
	add constraint bh_i_product_quantity_bh_haslot1_check
		check (bh_haslot1 = ANY (ARRAY['Y'::bpchar, 'N'::bpchar]));

alter table bh_i_product_quantity
	add constraint bh_i_product_quantity_bh_haslot2_check
		check (bh_haslot2 = ANY (ARRAY['Y'::bpchar, 'N'::bpchar]));

alter table bh_i_product_quantity
	add constraint bh_i_product_quantity_bh_hasexpiration_check
		check (bh_hasexpiration = ANY (ARRAY['Y'::bpchar, 'N'::bpchar]));

-- Add a new process
INSERT INTO ad_process (ad_process_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, value, name, description, help, accesslevel, entitytype, procedurename, isreport, isdirectprint, ad_reportview_id, classname, statistic_count, statistic_seconds, ad_printformat_id, workflowvalue, ad_workflow_id, isbetafunctionality, isserverprocess, showhelp, jasperreport, ad_form_id, copyfromprocess, ad_process_uu, ad_ctxhelp_id, executiontype, allowmultipleexecution) VALUES ((SELECT MAX(ad_process_id) + 1 FROM ad_process), 0, 0, 'Y', '2021-09-08 16:30:39.435000', 100, '2021-09-08 16:55:11.499000', 100, 'BH_Import_Product', 'BH Import Products', 'Import Initial Products and Quantities', null, '3', 'U', null, 'N', 'N', null, 'org.bandahealth.idempiere.base.process.ImportProductsProcess', 25, 483, null, null, null, 'N', 'N', 'Y', null, null, null, 'be3382f2-09ad-476b-992b-e30c4a629d55', null, null, 'P') ON CONFLICT DO NOTHING;

SELECT register_migration_script('202109091837_GO-1812.sql') FROM dual;
