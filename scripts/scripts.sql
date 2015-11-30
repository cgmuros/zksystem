select * from cuenta;


insert into Cuenta values (1, 'cgmuros', 'alfa14', 'Cristian', 'Munoz', 'cgmuros|@gmail.com')


ALTER TABLE cuenta ALTER COLUMN id SET DEFAULT nextval('cuenta_id_seq'::regclass);

select cuenta0_.id as id1_0_, cuenta0_.usuario as usuario2_0_, cuenta0_.password as password3_0_, cuenta0_.nombre as nombre4_0_, cuenta0_.apellido as apellido5_0_, cuenta0_.email as email6_0_ from bd_prestamos.public.cuenta cuenta0_ where cuenta0_.usuario='cgmuros' and cuenta0_.password='alfa14'

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


drop table cuenta;