select * from cuenta;

-- Table: cuenta

-- DROP TABLE cuenta;

CREATE TABLE cuenta
(
  id serial NOT NULL,
  usuario character varying(45),
  password character varying(45),
  nombre character varying(45),
  apellido character varying(45),
  email character varying(45),
  CONSTRAINT pk_cuenta PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE cuenta
  OWNER TO lkjpmpjfwhfpcx;


