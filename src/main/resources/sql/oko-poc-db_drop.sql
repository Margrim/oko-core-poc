-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2019-07-25 11:57:42.936

foreign keys
ALTER TABLE address
    DROP CONSTRAINT address_institution_fk;

ALTER TABLE institution
    DROP CONSTRAINT institution_entity_type_fk;

ALTER TABLE institution_program
    DROP CONSTRAINT institution_program_institution_fk;

ALTER TABLE institution_program
    DROP CONSTRAINT institution_program_program_fk;

-- tables
DROP TABLE address;

DROP TABLE entity_type;

DROP TABLE institution;

DROP TABLE institution_program;

DROP TABLE program;

DROP TABLE voivodeship;

-- End of file.

