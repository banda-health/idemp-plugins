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

alter table bh_i_product_quantity drop constraint if exists bh_i_product_quantity_isactive_check;
alter table bh_i_product_quantity
	add constraint bh_i_product_quantity_isactive_check
		check (isactive = ANY (ARRAY['Y'::bpchar, 'N'::bpchar]));

alter table bh_i_product_quantity drop constraint if exists bh_i_product_quantity_processed_check;
alter table bh_i_product_quantity
	add constraint bh_i_product_quantity_processed_check
		check (processed = ANY (ARRAY['Y'::bpchar, 'N'::bpchar]));

alter table bh_i_product_quantity drop constraint if exists bh_i_product_quantity_bh_haslot3_check;
alter table bh_i_product_quantity
	add constraint bh_i_product_quantity_bh_haslot3_check
		check (bh_haslot3 = ANY (ARRAY['Y'::bpchar, 'N'::bpchar]));

alter table bh_i_product_quantity drop constraint if exists bh_i_product_quantity_bh_haslot1_check;
alter table bh_i_product_quantity
	add constraint bh_i_product_quantity_bh_haslot1_check
		check (bh_haslot1 = ANY (ARRAY['Y'::bpchar, 'N'::bpchar]));

alter table bh_i_product_quantity drop constraint if exists bh_i_product_quantity_bh_haslot2_check;
alter table bh_i_product_quantity
	add constraint bh_i_product_quantity_bh_haslot2_check
		check (bh_haslot2 = ANY (ARRAY['Y'::bpchar, 'N'::bpchar]));

alter table bh_i_product_quantity drop constraint if exists bh_i_product_quantity_bh_hasexpiration_check;
alter table bh_i_product_quantity
	add constraint bh_i_product_quantity_bh_hasexpiration_check
		check (bh_hasexpiration = ANY (ARRAY['Y'::bpchar, 'N'::bpchar]));

-- Add a new process
INSERT INTO ad_process (ad_process_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, value, name, description, help, accesslevel, entitytype, procedurename, isreport, isdirectprint, ad_reportview_id, classname, statistic_count, statistic_seconds, ad_printformat_id, workflowvalue, ad_workflow_id, isbetafunctionality, isserverprocess, showhelp, jasperreport, ad_form_id, copyfromprocess, ad_process_uu, ad_ctxhelp_id, executiontype, allowmultipleexecution) VALUES ((SELECT MAX(ad_process_id) + 1 FROM ad_process), 0, 0, 'Y', '2021-09-08 16:30:39.435000', 100, '2021-09-08 16:55:11.499000', 100, 'BH_Import_Product', 'BH Import Products', 'Import Initial Products and Quantities', null, '3', 'U', null, 'N', 'N', null, 'org.bandahealth.idempiere.base.process.ImportProductsProcess', 25, 483, null, null, null, 'N', 'N', 'Y', null, null, null, 'be3382f2-09ad-476b-992b-e30c4a629d55', null, null, 'P') ON CONFLICT DO NOTHING;

-- Get the list of clients to update
SELECT ad_client_id
INTO TEMP TABLE tmp_ad_client_id
FROM ad_client
WHERE ad_client_id > 999999;

/************************************************************************************************************/
-- Update all account schemas to use Last PO as Costing Method and Costing Level to be Batch/Lot
-- (this will ensure that the cost of purchasing a product is kept throughout the system to when it's sold
-- to ensure CoGS is calculated correctly)
/************************************************************************************************************/
UPDATE c_acctschema asch SET costinglevel = 'B', costingmethod = 'p'
FROM tmp_ad_client_id c
WHERE asch.ad_client_id = c.ad_client_id;

-- Create a new costing element for the Last PO Price costing method
DROP TABLE IF EXISTS tmp_m_costelement;
create temp table tmp_m_costelement
(
	m_costelement_id serial not null,
	ad_client_id numeric(10) not null,
	ad_org_id numeric(10) default 0 not null,
	createdby numeric(10) default 100 not null,
	updatedby numeric(10) default 100 not null,
	name varchar(60) default 'Last PO Price' not null,
	description varchar(255),
	costelementtype char default 'M' not null,
	costingmethod char default 'p',
	m_costelement_uu uuid default uuid_generate_v4() not null
);

SELECT setval(
	'tmp_m_costelement_m_costelement_id_seq',
	(
		SELECT currentnext
		FROM ad_sequence
		WHERE name = 'M_CostElement'
		LIMIT 1
	)::INT,
	false
);

INSERT INTO tmp_m_costelement (
	ad_client_id
)
SELECT ad_client_id
FROM tmp_ad_client_id;

INSERT INTO m_costelement (
	m_costelement_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	name,
	description,
	costelementtype,
	costingmethod,
	m_costelement_uu
)
SELECT
	m_costelement_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	name,
	description,
	costelementtype,
	costingmethod,
	m_costelement_uu
FROM tmp_m_costelement;

-- Update all products with inventory to have a last PO cost
INSERT INTO m_cost (
	ad_client_id,
	ad_org_id,
	m_product_id,
	m_costtype_id,
	c_acctschema_id,
	m_costelement_id,
	m_attributesetinstance_id,
	createdby,
	updatedby,
	currentcostprice,
	currentqty, -- default 0
	cumulatedamt, -- default 0
	cumulatedqty, -- default 0
	futurecostprice,
	m_cost_uu
)
SELECT
	aci.ad_client_id,
	0,
	p.m_product_id,
	ct.m_costtype_id,
	asch.c_acctschema_id,
	ce.m_costelement_id,
	soh.m_attributesetinstance_id,
	100,
	100,
	COALESCE(cost.priceentered, pp.pricestd),
	soh.qtyonhand,
	COALESCE(cost.priceentered, pp.pricestd) * soh.qtyonhand,
	soh.qtyonhand,
	0, -- futurecostprice
	uuid_generate_v4()
FROM tmp_ad_client_id aci
	JOIN m_product p on p.ad_client_id = aci.ad_client_id
	JOIN (
		SELECT
			m_product_id,
			m_attributesetinstance_id,
			sum(qtyonhand) as qtyonhand
		FROM m_storageonhand
		WHERE qtyonhand != 0
		GROUP BY m_product_id, m_attributesetinstance_id
  ) soh ON soh.m_product_id = p.m_product_id AND qtyonhand != 0
	JOIN m_costtype ct ON ct.ad_client_id = aci.ad_client_id
	JOIN c_acctschema asch ON asch.ad_client_id = aci.ad_client_id
	JOIN m_costelement ce ON ce.ad_client_id = aci.ad_client_id AND ce.name = 'Last PO Price'
	LEFT JOIN (
		SELECT
			m_product_id,
			m_attributesetinstance_id,
			priceentered,
			row_number() OVER (PARTITION BY m_product_id, m_attributesetinstance_id ORDER BY o.dateordered) as row_num
		FROM c_orderline ol
			JOIN c_order o ON ol.c_order_id = o.c_order_id
		WHERE o.issotrx = 'N' AND o.docstatus IN ('CO', 'DR', 'CL')
	) cost ON cost.m_product_id = p.m_product_id AND cost.m_attributesetinstance_id = soh.m_attributesetinstance_id AND row_num = 1
	JOIN m_productprice pp ON p.m_product_id = pp.m_product_id
	JOIN m_pricelist_version plv ON pp.m_pricelist_version_id = plv.m_pricelist_version_id AND plv.isactive = 'Y'
	JOIN m_pricelist pl ON plv.m_pricelist_id = pl.m_pricelist_id AND pl.isactive = 'Y' AND pl.isdefault = 'Y' and pl.issopricelist = 'N'
ON CONFLICT DO NOTHING;

-- Add exclusions to the ASI for clients so they don't get errors when selling products (since we've removed the ability so select expiration date on a visit)
DROP TABLE IF EXISTS tmp_m_attributesetexclude;
create temp table tmp_m_attributesetexclude
(
	m_attributesetexclude_id serial not null,
	ad_client_id numeric(10) not null,
	ad_org_id numeric(10) default 0 not null,
	createdby numeric(10) default 100 not null,
	updatedby numeric(10) default 100 not null,
	m_attributeset_id numeric(10) not null,
	ad_table_id numeric(10) not null,
	m_attributesetexclude_uu varchar(36) default uuid_generate_v4() not null
);

SELECT setval(
	'tmp_m_attributesetexclude_m_attributesetexclude_id_seq',
	(
		SELECT currentnext
		FROM ad_sequence
		WHERE lower(name) = 'm_attributesetexclude'
		LIMIT 1
	)::INT,
	false
);

INSERT INTO tmp_m_attributesetexclude (
	ad_client_id,
	m_attributeset_id,
	ad_table_id
)
SELECT
	aci.ad_client_id,
	attrs.m_attributeset_id,
	t.ad_table_id
FROM tmp_ad_client_id aci
	JOIN m_attributeset attrs ON attrs.ad_client_id = aci.ad_client_id AND attrs.name = 'BandaHealthProductAttributeSet'
	CROSS JOIN (
		SELECT 260 as ad_table_id UNION
		SELECT 320
	) t;

INSERT INTO m_attributesetexclude (
	m_attributesetexclude_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	m_attributeset_id,
	ad_table_id,
	m_attributesetexclude_uu
)
SELECT 
	m_attributesetexclude_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	m_attributeset_id,
	ad_table_id,
	m_attributesetexclude_uu
FROM tmp_m_attributesetexclude;

SELECT register_migration_script('202109091837_GO-1812.sql') FROM dual;
