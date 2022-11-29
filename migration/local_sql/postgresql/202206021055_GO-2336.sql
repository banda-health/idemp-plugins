--Get m_storageonhand records that have a quantity > 0 and no ASI
CREATE temp table if not exists tmp_m_storageonhand
(
	ad_client_id numeric(10) not null,
	ad_org_id numeric(10) default 0 not null,
	m_product_id numeric(10) not null,
	m_storageonhand_uu varchar(255)
);

INSERT INTO tmp_m_storageonhand (
	ad_client_id,
	ad_org_id,
	m_product_id,
	m_storageonhand_uu
)
SELECT ad_client_id,
	ad_org_id,
	m_product_id,
	m_storageonhand_uu
FROM m_storageonhand WHERE m_attributesetinstance_id = 0 and qtyonhand > 0;

-- create temp m_attributesetinstance table
create temp table if not exists tmp_m_attributesetinstance
(
	m_attributesetinstance_id serial not null,
	ad_client_id numeric(10) not null,
	ad_org_id numeric(10) default 0 not null,
	isactive char default 'Y'::bpchar not null,
	created timestamp default now() not null,
	createdby numeric(10) default 100 not null,
	updated timestamp default now() not null,
	updatedby numeric(10) default 100 not null,
	m_attributeset_id numeric(10),
	serno varchar(40) default '100',
	-- lot varchar(40),
	-- guaranteedate timestamp,
	description varchar(255) default '#100',
	-- m_lot_id numeric(10),
	m_attributesetinstance_uu uuid default uuid_generate_v4(),
	-- bh_update_reason varchar(10)
	m_product_id numeric(10) not null,
	m_storageonhand_uu varchar(255)
);

-- Update the serial sequences
SELECT setval(
	'tmp_m_attributesetinstance_m_attributesetinstance_id_seq',
	(
		SELECT currentnext
		FROM ad_sequence
		WHERE lower(name) = 'm_attributesetinstance'
		LIMIT 1
	)::INT,
	false
);

-- Create an ASI for each product in the list
INSERT INTO tmp_m_attributesetinstance (
	ad_client_id,
	ad_org_id,
	m_attributeset_id,
	m_product_id,
	m_storageonhand_uu
)
SELECT
	m.ad_client_id,
	m.ad_org_id,
	attrs.m_attributeset_id,
	m.m_product_id,
	m.m_storageonhand_uu
FROM tmp_m_storageonhand m
	JOIN m_product p ON m.m_product_id = p.m_product_id
	JOIN m_attributeset attrs ON attrs.ad_client_id = m.ad_client_id AND attrs.ad_org_id = m.ad_org_id;

INSERT INTO m_attributesetinstance (
	m_attributesetinstance_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	m_attributeset_id,
	serno,
	description,
	m_attributesetinstance_uu
)
SELECT
	m_attributesetinstance_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	m_attributeset_id,
	serno,
	description,
	m_attributesetinstance_uu
FROM tmp_m_attributesetinstance;

-- Update m_storageonhand with missing ASIs
UPDATE m_storageonhand soh
SET m_attributesetinstance_id = asi.m_attributesetinstance_id
FROM tmp_m_attributesetinstance asi
WHERE soh.m_storageonhand_uu = asi.m_storageonhand_uu;

SELECT register_migration_script('202206021055_GO-2336.sql') FROM dual;
