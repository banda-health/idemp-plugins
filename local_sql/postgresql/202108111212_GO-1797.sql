 INSERT INTO adempiere.bh_coded_diagnosis (ad_client_id, ad_org_id, bh_cielname, bh_ciel_id, bh_coded_diagnosis_id, bh_coded_diagnosis_uu, bh_concept_class, bh_icd10who, bh_searchterms, bh_synomed_ct, bh_synomed_np, bh_synonyms, created, createdby, description, isactive, updated, updatedby, bh_shortnames, bh_moh705a_lessthan5, bh_moh705b_greaterthan5) VALUES (0, 0, 'Bilateral pneumonia', 155296, (SELECT max(bh_coded_diagnosis_id)+1 from bh_coded_diagnosis), 'd39176cf-54b8-4f61-8a90-159b43e6789b', null, 'J18.9', null, 407671000, null, null, '2021-08-11 12:12:25.982661', 0, null, 'Y', '2021-08-11 12:12:25.982661', 0, null, 'Severe pneumonia', 'Pneumonia');
 
  INSERT INTO adempiere.bh_coded_diagnosis (ad_client_id, ad_org_id, bh_cielname, bh_ciel_id, bh_coded_diagnosis_id, bh_coded_diagnosis_uu, bh_concept_class, bh_icd10who, bh_searchterms, bh_synomed_ct, bh_synomed_np, bh_synonyms, created, createdby, description, isactive, updated, updatedby, bh_shortnames, bh_moh705a_lessthan5, bh_moh705b_greaterthan5) VALUES (0, 0, 'Tested for Malaria', null, (SELECT max(bh_coded_diagnosis_id)+1 from bh_coded_diagnosis), '4eb521ff-6a25-4791-9f86-61d088f3e8f9', null, 'B54', null, null, null, null, '2021-08-11 12:12:25.982661', 0, null, 'Y', '2021-08-11 12:12:25.982661', 0, null, 'Tested for malaria', 'Suspected Malaria');
  
SELECT register_migration_script('202108111212_GO-1797.sql') FROM dual;
