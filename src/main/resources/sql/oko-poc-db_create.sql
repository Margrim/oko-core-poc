-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2019-07-31 03:54:41.914

-- tables
-- Table: address
CREATE TABLE address (
    id_address bigint  NOT NULL,
    id_institution bigint  NULL,
    id_voivodeship int  NULL,
    county varchar(100)  NULL,
    city varchar(100)  NULL,
    municipality varchar(100)  NULL,
    street varchar(100)  NULL,
    number varchar(20)  NULL,
    flat_number varchar(10)  NULL,
    postal_code varchar(6)  NULL,
    CONSTRAINT address_pk PRIMARY KEY (id_address)
);

-- Table: entity_type
CREATE TABLE entity_type (
    id_entity_type int  NOT NULL,
    entity_type varchar(255)  NULL,
    CONSTRAINT entity_type_pk PRIMARY KEY (id_entity_type)
);

-- Table: institution
CREATE TABLE institution (
    id_institution bigint  NOT NULL,
    name varchar(255)  NULL,
    id_entity_type int  NULL,
    nip varchar(10)  NULL,
    CONSTRAINT institution_pk PRIMARY KEY (id_institution)
);

-- Table: institution_program
CREATE TABLE institution_program (
    id_institution bigint  NOT NULL,
    id_program bigint  NOT NULL,
    CONSTRAINT institution_program_pk PRIMARY KEY (id_institution,id_program)
);

-- Table: program
CREATE TABLE program (
    id_program bigint  NOT NULL,
    name varchar(255)  NULL,
    CONSTRAINT program_pk PRIMARY KEY (id_program)
);

-- Table: voivodeship
CREATE TABLE voivodeship (
    id_voivodeship int  NOT NULL,
    name varchar(20)  NULL,
    CONSTRAINT voivodeship_pk PRIMARY KEY (id_voivodeship)
);

-- foreign keys
-- Reference: address_institution_fk (table: address)
ALTER TABLE address ADD CONSTRAINT address_institution_fk
    FOREIGN KEY (id_institution)
    REFERENCES institution (id_institution)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: address_voivodeship_fk (table: address)
ALTER TABLE address ADD CONSTRAINT address_voivodeship_fk
    FOREIGN KEY (id_voivodeship)
    REFERENCES voivodeship (id_voivodeship)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: institution_entity_type_fk (table: institution)
ALTER TABLE institution ADD CONSTRAINT institution_entity_type_fk
    FOREIGN KEY (id_entity_type)
    REFERENCES entity_type (id_entity_type)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: institution_program_institution_fk (table: institution_program)
ALTER TABLE institution_program ADD CONSTRAINT institution_program_institution_fk
    FOREIGN KEY (id_institution)
    REFERENCES institution (id_institution)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: institution_program_program_fk (table: institution_program)
ALTER TABLE institution_program ADD CONSTRAINT institution_program_program_fk
    FOREIGN KEY (id_program)
    REFERENCES program (id_program)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- End of file.

