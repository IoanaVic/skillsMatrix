--
-- PostgreSQL database dump
--

SET search_path = y_matrix;

CREATE SEQUENCE y_matrix.hibernate_sequence
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
  
ALTER TABLE y_matrix.hibernate_sequence
  OWNER TO postgres;
  
-- Restore the normal search path.
RESET search_path;



