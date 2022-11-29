INSERT INTO ad_sequence (ad_sequence_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, vformat, isautosequence, incrementno, startno, currentnext, currentnextsys, isaudited, istableid, prefix, suffix, startnewyear, datecolumn, decimalpattern, ad_sequence_uu, startnewmonth, isorglevelsequence, orgcolumn) VALUES ((SELECT MAX(ad_sequence_id) + 1 FROM ad_sequence), 0, 0, 'Y', '2021-05-20 15:39:52.570000', 100, '2021-05-20 15:39:52.570000', 100, 'BH_Coded_Diagnosis', 'Table BH_Coded_Diagnsosis', null, 'Y', 1, 1000000, 1000000, 200000, 'N', 'Y', null, null, 'N', null, null, 'c717f4cf-c601-45bc-a80c-fb1a1c235862', 'N', 'N', null)
ON CONFLICT DO NOTHING;

SELECT register_migration_script('202109171559_GO-1798.sql') FROM dual;
