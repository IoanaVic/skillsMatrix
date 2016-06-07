--
-- EnterpriseDB database dump
--

SET statement_timeout = 0;
--SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: y_matrix; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA y_matrix;


ALTER SCHEMA y_matrix OWNER TO postgres;

SET search_path = y_matrix, pg_catalog, sys;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: y_matrix; Owner: postgres;
--

CREATE SEQUENCE y_matrix.hibernate_sequence
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
  
  
ALTER TABLE y_matrix.hibernate_sequence
  OWNER TO postgres;

--
-- Name: matrix; Type: TABLE; Schema: y_matrix; Owner: postgres; Tablespace: 
--

CREATE TABLE matrix (
    id integer NOT NULL,
    area character varying(255),
    details character varying(255),
    grade integer NOT NULL,
    phase character varying(255),
    priority integer NOT NULL,
    topic character varying(255),
    user_id integer
);


ALTER TABLE y_matrix.matrix OWNER TO postgres;

--
-- Name: revinfo; Type: TABLE; Schema: y_matrix; Owner: postgres; Tablespace: 
--

--CREATE TABLE revinfo (
--    rev integer NOT NULL,
--    revtstmp bigint
--);


--ALTER TABLE y_matrix.revinfo OWNER TO postgres;

--
-- Name: users; Type: TABLE; Schema: y_matrix; Owner: postgres; Tablespace: 
--

CREATE TABLE users (
    id integer NOT NULL,
    email character varying(255),
    role character varying(255),
    username character varying(255)
);


ALTER TABLE y_matrix.users OWNER TO postgres;

--
-- Name: matrix_pkey; Type: CONSTRAINT; Schema: y_matrix; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY matrix
    ADD CONSTRAINT matrix_pkey PRIMARY KEY (id);


--
-- Name: revinfo_pkey; Type: CONSTRAINT; Schema: y_matrix; Owner: postgres; Tablespace: 
--

--ALTER TABLE ONLY revinfo
--    ADD CONSTRAINT revinfo_pkey PRIMARY KEY (rev);


--
-- Name: users_email_key; Type: CONSTRAINT; Schema: y_matrix; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY users
    ADD CONSTRAINT users_email_key UNIQUE (email);


--
-- Name: users_pkey; Type: CONSTRAINT; Schema: y_matrix; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- Name: fk88f283e1906d1804; Type: FK CONSTRAINT; Schema: y_matrix; Owner: postgres
--

ALTER TABLE ONLY matrix
    ADD CONSTRAINT fk88f283e1906d1804 FOREIGN KEY (user_id) REFERENCES users(id);


--
-- EnterpriseDB database dump complete
--

