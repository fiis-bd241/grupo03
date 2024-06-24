
```sql
BEGIN;

DROP TABLE IF EXISTS public."PreCarga" CASCADE;
DROP TABLE IF EXISTS public."Campo" CASCADE;
DROP TABLE IF EXISTS public."CampoAsegurado" CASCADE;
DROP TABLE IF EXISTS public."Algoritmo" CASCADE;
DROP TABLE IF EXISTS public."Ambiente" CASCADE;
DROP TABLE IF EXISTS public."Migracion" CASCADE;
DROP TABLE IF EXISTS public."Area" CASCADE;
DROP TABLE IF EXISTS public."CargaPreCarga" CASCADE;
DROP TABLE IF EXISTS public."ReglaDeCargaFuncional" CASCADE;
DROP TABLE IF EXISTS public."ReglaDeCargaTecnica" CASCADE;
DROP TABLE IF EXISTS public."Cargo" CASCADE;
DROP TABLE IF EXISTS public."ConceptosNegocio" CASCADE;
DROP TABLE IF EXISTS public."DefinicionesTecnicas" CASCADE;
DROP TABLE IF EXISTS public."Dominio" CASCADE;
DROP TABLE IF EXISTS public."Subdominio" CASCADE;
DROP TABLE IF EXISTS public."Empleado" CASCADE;
DROP TABLE IF EXISTS public."Esquema" CASCADE;
DROP TABLE IF EXISTS public."Estado" CASCADE;
DROP TABLE IF EXISTS public."on" CASCADE;
DROP TABLE IF EXISTS public."Modelado" CASCADE;
DROP TABLE IF EXISTS public."Notificacion" CASCADE;
DROP TABLE IF EXISTS public."Participa_en" CASCADE;
DROP TABLE IF EXISTS public."Participante" CASCADE;
DROP TABLE IF EXISTS public."Pedido" CASCADE;
DROP TABLE IF EXISTS public."Pertenece" CASCADE;
DROP TABLE IF EXISTS public."Prioridad" CASCADE;
DROP TABLE IF EXISTS public."Programacion" CASCADE;
DROP TABLE IF EXISTS public."Recordatorio" CASCADE;
DROP TABLE IF EXISTS public."Recordatorio_Enviado" CASCADE;
DROP TABLE IF EXISTS public."RegistroErrores" CASCADE;
DROP TABLE IF EXISTS public."Reporte" CASCADE;
DROP TABLE IF EXISTS public."Reporte_Conformidad" CASCADE;
DROP TABLE IF EXISTS public."Reunion" CASCADE;
DROP TABLE IF EXISTS public."Reunion_Reporte_Conformidad" CASCADE;
DROP TABLE IF EXISTS public."Roles" CASCADE;
DROP TABLE IF EXISTS public."Squad" CASCADE;
DROP TABLE IF EXISTS public."Tarea" CASCADE;
DROP TABLE IF EXISTS public."Tecnologia" CASCADE;
DROP TABLE IF EXISTS public."TipoDato" CASCADE;
DROP TABLE IF EXISTS public."TipoError" CASCADE;
DROP TABLE IF EXISTS public."Tipo_Recordatorio" CASCADE;
DROP TABLE IF EXISTS public."Tipo_Reunion" CASCADE;

CREATE TABLE IF NOT EXISTS public."Algoritmo"
(
    id_algoritmo serial NOT NULL,
    nombre_algoritmo character varying(200) COLLATE pg_catalog."default",
    descripcion text COLLATE pg_catalog."default",
    "longClave" character varying(200) COLLATE pg_catalog."default",
    tipo character varying(200) COLLATE pg_catalog."default",
    CONSTRAINT "Algoritmo_pkey" PRIMARY KEY (id_algoritmo)
);

CREATE TABLE IF NOT EXISTS public."Ambiente"
(
    id_ambiente serial NOT NULL,
    nombre_ambiente character varying(100) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT "Ambiente_pkey" PRIMARY KEY (id_ambiente)
);

CREATE TABLE IF NOT EXISTS public."Area"
(
    "Area_Id" serial NOT NULL,
    "Area_Nombre" character varying(100) COLLATE pg_catalog."default",
    "Area_Descripcion" character varying(100) COLLATE pg_catalog."default",
    "Area_Direccion" character varying(50) COLLATE pg_catalog."default",
    CONSTRAINT "Area_pkey" PRIMARY KEY ("Area_Id")
);

CREATE TABLE IF NOT EXISTS public."Campo"
(
    id_campo serial NOT NULL,
    "ID_Modelo" serial NOT NULL,
    "id_TipodeDato" serial NOT NULL,
    valor character varying(100) COLLATE pg_catalog."default",
    propiedades character varying(250) COLLATE pg_catalog."default",
    "id_AlgoritmoEnc" serial NOT NULL,
    "id_AlgoritmoEnm" serial NOT NULL,
    CONSTRAINT "Campo_pkey" PRIMARY KEY (id_campo)
);
ALTER TABLE "Campo"
ALTER COLUMN "id_AlgoritmoEnc" DROP NOT NULL;
ALTER TABLE "Campo"
ALTER COLUMN "id_AlgoritmoEnm" DROP NOT NULL;
CREATE TABLE IF NOT EXISTS public."CampoAsegurado"
(
    "id_CampoAsegurado" serial NOT NULL,
    id_admin serial NOT NULL,
    id_campo serial NOT NULL,
    CONSTRAINT "CampoAsegurado_pkey" PRIMARY KEY ("id_CampoAsegurado")
);


CREATE TABLE IF NOT EXISTS public."Cargo"
(
    id_cargo serial NOT NULL,
    nombre_cargo character varying(50) COLLATE pg_catalog."default",
    CONSTRAINT "Cargo_pkey" PRIMARY KEY (id_cargo)
);

CREATE TABLE IF NOT EXISTS public."Dominio"
(
    id_dominio serial NOT NULL,
    tipo_dominio character varying(50) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT "Dominio_pkey" PRIMARY KEY (id_dominio)
);

CREATE TABLE IF NOT EXISTS public."Subdominio"
(
    id_subdominio serial NOT NULL,
    nombre_subdominio character varying(100) COLLATE pg_catalog."default" NOT NULL,
    id_dominio integer NOT NULL,
    CONSTRAINT "Subdominio_pkey" PRIMARY KEY (id_subdominio),
    CONSTRAINT "FK_Dominio_Subdominio" FOREIGN KEY (id_dominio)
        REFERENCES public."Dominio" (id_dominio) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TABLE IF NOT EXISTS public."Migracion"
(
    "Migracion_Id" serial NOT NULL,
    "Pedido_Id" integer NOT NULL,
    "Id_Tecnologia" integer NOT NULL,
    "AmbienteId" integer NOT NULL,
    "Fecha_migracion" date,
    "Valido" boolean,
    "Ultimo" boolean,
    CONSTRAINT "Migracion_pkey" PRIMARY KEY ("Migracion_Id")
);
CREATE TABLE IF NOT EXISTS public."ConceptosNegocio"
(
    "id_CN" serial NOT NULL,
    "id_subdominio" integer NOT NULL,
    id_referencia integer NOT NULL,
    "DefinicionTabla" text COLLATE pg_catalog."default",
    "DefinicionCampo" text COLLATE pg_catalog."default",
    "MigracionId" integer NOT NULL,
    CONSTRAINT "ConceptosNegocio_pkey" PRIMARY KEY ("id_CN"),
    CONSTRAINT "FK_Subdominio_ConceptosNegocio" FOREIGN KEY ("id_subdominio")
        REFERENCES public."Subdominio" (id_subdominio) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
	CONSTRAINT "FK_Migracion_ConceptosNegocio" FOREIGN KEY ("MigracionId")
        REFERENCES public."Migracion" ("Migracion_Id") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TABLE IF NOT EXISTS public."DefinicionesTecnicas"
(
    "id_DT" serial NOT NULL,
    "EquivalenciaId" integer,
    "EsquemaId" integer NOT NULL,
    "Tabla" character varying(200) COLLATE pg_catalog."default",
    "Campo" character varying(100) COLLATE pg_catalog."default",
    CONSTRAINT "DefinicionesTecnicas_pkey" PRIMARY KEY ("id_DT")
);

CREATE TABLE IF NOT EXISTS public."Empleado"
(
    id_empleado serial NOT NULL,
    nombre character varying(50) COLLATE pg_catalog."default",
    correo character varying(50) COLLATE pg_catalog."default",
    "contraseña" character varying(50) COLLATE pg_catalog."default",
    telefono character varying(20) COLLATE pg_catalog."default",
    dni character varying(8) COLLATE pg_catalog."default",
    rol_id integer,
    CONSTRAINT "Empleado_pkey" PRIMARY KEY (id_empleado)
);

CREATE TABLE IF NOT EXISTS public."Esquema"
(
    id_esquema serial NOT NULL,
    "AmbienteId" integer NOT NULL,
    nombre_esquema character varying(100) COLLATE pg_catalog."default",
    CONSTRAINT "Esquema_pkey" PRIMARY KEY (id_esquema)
);

CREATE TABLE IF NOT EXISTS public."Estado"
(
    "Estado_Id" serial NOT NULL,
    "Estado_Tipo" character varying(10) COLLATE pg_catalog."default",
    CONSTRAINT "Estado_pkey" PRIMARY KEY ("Estado_Id")
);



CREATE TABLE IF NOT EXISTS public."Tarea"
(
    id_tarea serial NOT NULL,
    id_empleado integer NOT NULL,
	id_migracion integer NOT NULL,
    descripcion text COLLATE pg_catalog."default",
    fecha_fin date,
    fecha_inicio date,
	fecha_fin_real date,
    calidad integer,
    estadoId integer,
    CONSTRAINT "Tarea_pkey" PRIMARY KEY (id_tarea),
	CONSTRAINT "FK_Tarea_Migracion" FOREIGN KEY (id_migracion) REFERENCES public."Migracion" ("Migracion_Id"),
	CONSTRAINT "FK_Tarea_Estado" FOREIGN KEY (estadoId) REFERENCES public."Estado" ("Estado_Id")
);

CREATE TABLE IF NOT EXISTS public."Modelado"
(
    "ID_Modelo" serial NOT NULL,
	"id_referencia" integer,
    "EsquemaDDV" character varying(200) COLLATE pg_catalog."default",
    "TablaDDV" character varying(200) COLLATE pg_catalog."default",
    "CampoDDV" character varying(200) COLLATE pg_catalog."default",
    "CampoLlave" boolean,
    "Campo_Descarta" boolean,
    CONSTRAINT "Modelado_pkey" PRIMARY KEY ("ID_Modelo")
);

CREATE TABLE IF NOT EXISTS public."Participa_en"
(
    "Id_Participa_en" serial NOT NULL,
    "Reunion_Id" serial NOT NULL,
    "Participante_Id" serial NOT NULL,
    CONSTRAINT "Participa_en_pkey" PRIMARY KEY ("Id_Participa_en")
);

CREATE TABLE IF NOT EXISTS public."Participante"
(
    "Participante_Id" serial NOT NULL,
    "Area_Id" serial NOT NULL,
    "Nombre" character varying(100) COLLATE pg_catalog."default",
    "Apellido" character varying(100) COLLATE pg_catalog."default",
    "Correo" character varying(100) COLLATE pg_catalog."default",
    CONSTRAINT "Participante_pkey" PRIMARY KEY ("Participante_Id")
);

CREATE TABLE IF NOT EXISTS public."Pedido"
(
    "Pedido_Id" serial NOT NULL,
    "Area_Id" integer NOT NULL,
    "Prioridad_Id" integer NOT NULL,
    "Estado_Id" integer NOT NULL,
    "Id_Squad" integer NOT NULL,
    "Pedido_Fecha" date,
    "Pedido_FechaLimite" date,
    CONSTRAINT "Pedido_pkey" PRIMARY KEY ("Pedido_Id")
);

CREATE TABLE IF NOT EXISTS public."Pertenece"
(
    id_pertenece serial NOT NULL,
    "SquadId" bigint NOT NULL,
    "EmpleadoId" bigint NOT NULL,
    "CargoId" bigint NOT NULL,
    CONSTRAINT "Pertenece_pkey" PRIMARY KEY (id_pertenece)
);



CREATE TABLE IF NOT EXISTS public."Prioridad"
(
    "Prioridad_Id" serial NOT NULL,
    "Prioridad_Tipo" character varying(5) COLLATE pg_catalog."default",
    "Prioridad_Detalle" character varying(250) COLLATE pg_catalog."default",
    CONSTRAINT "Prioridad_pkey" PRIMARY KEY ("Prioridad_Id")
);

CREATE TABLE IF NOT EXISTS public."Programacion"
(
    "Programacion_Id" serial NOT NULL,
    "Migracion_Id" serial NOT NULL,
    "FrecuenciaEjecucion" character varying COLLATE pg_catalog."default",
    "DiaInicio" character varying(50) COLLATE pg_catalog."default",
    "DiaFin" character varying(50) COLLATE pg_catalog."default",
    "ConsideracionFrecuencia" character varying(50) COLLATE pg_catalog."default",
    CONSTRAINT "Programacion_pkey" PRIMARY KEY ("Programacion_Id")
);

CREATE TABLE IF NOT EXISTS public."Recordatorio"
(
    "Recordatorio_Id" serial NOT NULL,
    "Reunion_Id" serial NOT NULL,
    "TipoRecordatorio_Id" serial NOT NULL,
    "Hora" time with time zone,
    "Fecha" date,
    CONSTRAINT "Recordatorio_pkey" PRIMARY KEY ("Recordatorio_Id")
);

CREATE TABLE IF NOT EXISTS public."Recordatorio_Enviado"
(
    "Id_RecordatorioEnviado" serial NOT NULL,
    "Recordatorio_Id" serial NOT NULL,
    "Participante_Id" serial NOT NULL,
    CONSTRAINT "Recordatorio_Enviado_pkey" PRIMARY KEY ("Id_RecordatorioEnviado")
);

CREATE TABLE IF NOT EXISTS public."RegistroErrores"
(
    "Id_registro_errores" serial NOT NULL,
    "Migracion_Id" serial NOT NULL,
    "Id_error" serial NOT NULL,
    "Id_Empleado" serial,
    "Correcion_error" character varying(50) COLLATE pg_catalog."default",
    "Fecha_registro" date,
    "Causa_error" character varying(50) COLLATE pg_catalog."default",
    CONSTRAINT "RegistroErrores_pkey" PRIMARY KEY ("Id_registro_errores")
);

ALTER TABLE public."RegistroErrores" ALTER COLUMN  "Id_Empleado" DROP NOT NULL;

CREATE TABLE IF NOT EXISTS public."Universo"
(
    "ID_Universo" serial NOT NULL,
    "Pedido_Id" serial,
    "Codigo" text,
    "Fecha_Creacion" DATE,
    CONSTRAINT "Universo_pkey" PRIMARY KEY ("ID_Universo")
);

CREATE TABLE IF NOT EXISTS public."PreCarga"
(
    "ID_Precarga" integer NOT NULL,
    "Nombre_Regla" character varying(100) COLLATE pg_catalog."default",
    "Descripcion" character varying(200) COLLATE pg_catalog."default",
    "Obligatorio" boolean,
    CONSTRAINT "PreCarga_pkey" PRIMARY KEY ("ID_Precarga")
);

CREATE TABLE IF NOT EXISTS public."CargaPreCarga"
(
    "ID_CargaPrecarga" serial NOT NULL,
    "ID_ReglaCarga" serial NOT NULL,
    "ID_Precarga" Integer NOT NULL,
    CONSTRAINT "CargaPreCarga_pkey" PRIMARY KEY ("ID_CargaPrecarga")
);

CREATE TABLE IF NOT EXISTS public."ReglaDeCargaFuncional"
(
    "ID_ReglaCargaFunc" serial NOT NULL,
    "id_migracion" serial NOT NULL,
    "id_tecnologia" serial NOT NULL,
    "Logica" text COLLATE pg_catalog."default",
    "Fecha" DATE,
    CONSTRAINT "ReglaDeCargaFuncionales_pkey" PRIMARY KEY ("ID_ReglaCargaFunc")
);


CREATE TABLE IF NOT EXISTS public."ReglaDeCargaTecnica"
(
    "ID_ReglaCargaTecn" serial NOT NULL,
    "regla_funcional" serial NOT NULL,
    "Codigo" text COLLATE pg_catalog."default",
    "Finalizado" boolean,
    "Comentario" text,
    "Fecha" DATE,
    CONSTRAINT "ReglaDeCargaTecnica_pkey" PRIMARY KEY ("ID_ReglaCargaTecn")
);

CREATE TABLE IF NOT EXISTS public."Reporte"
(
    id_reporte serial NOT NULL,
    id_admin serial NOT NULL,
    id_usuario serial NOT NULL,
    detalles character varying(50) COLLATE pg_catalog."default",
    fecha date,
    formato character varying(15) COLLATE pg_catalog."default",
    CONSTRAINT "Reporte_pkey" PRIMARY KEY (id_reporte)
);

CREATE TABLE IF NOT EXISTS public."Reporte_Conformidad"
(
    "Reporte_Id" serial NOT NULL,
    "Estado" character varying(50) COLLATE pg_catalog."default",
    "Fecha" date,
    "Pedido_Id" integer,
    "Tipo_Reporte" character varying(15) COLLATE pg_catalog."default",
    CONSTRAINT "Reporte_Conformidad_pkey" PRIMARY KEY ("Reporte_Id")
);

CREATE TABLE IF NOT EXISTS public."Reunion"
(
    "Reunion_Id" serial NOT NULL,
    "Id_Empleado" serial NOT NULL,
    "Pedido_Id" serial NOT NULL,
    "TipoReunion_Id" serial NOT NULL,
    "HoraInicio" time with time zone,
    "HoraFin" time with time zone,
    "Plataforma" character varying(50) COLLATE pg_catalog."default",
    "Fecha" date,
    "Estado" character varying(20) COLLATE pg_catalog."default",
    "Agenda" text COLLATE pg_catalog."default",
    "Acuerdos" text COLLATE pg_catalog."default",
    "HoraProgramacion" time with time zone,
    "FechaProgramacion" date,
    CONSTRAINT "Reunion_pkey" PRIMARY KEY ("Reunion_Id")
);

CREATE TABLE IF NOT EXISTS public."Reunion_Reporte_Conformidad"
(
    "Id_Reu_Rep" serial NOT NULL,
    "Reporte_Id" serial NOT NULL,
    "Reunion_Id" serial NOT NULL,
    CONSTRAINT "Reunion_Reporte_Conformidad_pkey" PRIMARY KEY ("Id_Reu_Rep")
);

CREATE TABLE IF NOT EXISTS public."Roles"
(
    id_rol serial NOT NULL,
    nombre_rol character varying(50) COLLATE pg_catalog."default",
    nivel_acceso character varying(50) COLLATE pg_catalog."default",
    CONSTRAINT "Roles_pkey" PRIMARY KEY (id_rol)
);

CREATE TABLE IF NOT EXISTS public."Squad"
(
    id_squad serial NOT NULL,
    nombre_squad character varying(50) COLLATE pg_catalog."default",
    CONSTRAINT "Squad_pkey" PRIMARY KEY (id_squad)
);

CREATE TABLE IF NOT EXISTS public."Tecnologia"
(
    id_tecnologia serial NOT NULL,
    nombre_tecnologia character varying(50) COLLATE pg_catalog."default",
    CONSTRAINT "Tecnologia_pkey" PRIMARY KEY (id_tecnologia)
);

CREATE TABLE IF NOT EXISTS public."TipoDato"
(
    "id_TipoDeDato" serial NOT NULL,
    "Nombre" character varying(200) COLLATE pg_catalog."default",
    "Nivel de acceso" character varying(200) COLLATE pg_catalog."default",
    "Enmascarado" boolean,
    "Encriptación" boolean,
    CONSTRAINT "TipoDato_pkey" PRIMARY KEY ("id_TipoDeDato")
);

CREATE TABLE IF NOT EXISTS public."TipoError"
(
    "Id_error" serial NOT NULL,
    "Nombre_error" character varying(50) COLLATE pg_catalog."default",
    CONSTRAINT "TipoError_pkey" PRIMARY KEY ("Id_error")
);

CREATE TABLE IF NOT EXISTS public."Tipo_Recordatorio"
(
    "TipoRecordatorio_Id" serial NOT NULL,
    "Nombre" character varying(50) COLLATE pg_catalog."default",
    "Descripcion" text COLLATE pg_catalog."default",
    "Mensaje" text COLLATE pg_catalog."default",
    CONSTRAINT "Tipo_Recordatorio_pkey" PRIMARY KEY ("TipoRecordatorio_Id")
);

CREATE TABLE IF NOT EXISTS public."Tipo_Reunion"
(
    "TipoReunion_Id" serial NOT NULL,
    "Nombre" character varying(50) COLLATE pg_catalog."default",
    "Descripcion" text COLLATE pg_catalog."default",
    CONSTRAINT "Tipo_Reunion_pkey" PRIMARY KEY ("TipoReunion_Id")
);

ALTER TABLE IF EXISTS public."Campo"
    ADD CONSTRAINT "Campo_ID_Modelo_fkey" FOREIGN KEY ("ID_Modelo")
    REFERENCES public."Modelado" ("ID_Modelo") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."Campo"
    ADD CONSTRAINT "Campo_id_AlgoritmoEnc_fkey" FOREIGN KEY ("id_AlgoritmoEnc")
    REFERENCES public."Algoritmo" (id_algoritmo) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."Campo"
    ADD CONSTRAINT "Campo_id_AlgoritmoEnm_fkey" FOREIGN KEY ("id_AlgoritmoEnm")
    REFERENCES public."Algoritmo" (id_algoritmo) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."Campo"
    ADD CONSTRAINT "Campo_id_TipodeDato_fkey" FOREIGN KEY ("id_TipodeDato")
    REFERENCES public."TipoDato" ("id_TipoDeDato") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."CampoAsegurado"
    ADD CONSTRAINT "CampoAsegurado_id_admin_fkey" FOREIGN KEY (id_admin)
    REFERENCES public."Empleado" (id_empleado) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."CampoAsegurado"
    ADD CONSTRAINT "CampoAsegurado_id_campo_fkey" FOREIGN KEY (id_campo)
    REFERENCES public."Campo" (id_campo) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;



ALTER TABLE IF EXISTS public."Universo"
    ADD CONSTRAINT "Universo_Pedido_fk" FOREIGN KEY ("Pedido_Id")
    REFERENCES public."Pedido" ("Pedido_Id") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;

ALTER TABLE IF EXISTS public."ReglaDeCargaTecnica"
    ADD CONSTRAINT "ReglaDeCargaTecnica_id_ReglaDeCargaFuncional_fkey" FOREIGN KEY (regla_funcional)
    REFERENCES public."ReglaDeCargaFuncional" ("ID_ReglaCargaFunc") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."ReglaDeCargaFuncional"
    ADD CONSTRAINT "ReglaDeCargaFuncional_id_migracion_fkey" FOREIGN KEY (id_migracion)
    REFERENCES public."Migracion" ("Migracion_Id") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;

ALTER TABLE IF EXISTS public."ReglaDeCargaFuncional"
    ADD CONSTRAINT "ReglaDeCargaFuncional_id_tecnologia_fkey" FOREIGN KEY (id_tecnologia)
    REFERENCES public."Tecnologia" (id_tecnologia) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;

ALTER TABLE IF EXISTS public."CargaPreCarga"
    ADD CONSTRAINT "CargaPreCarga_ID_Precarga_fkey" FOREIGN KEY ("ID_Precarga")
    REFERENCES public."PreCarga" ("ID_Precarga") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."CargaPreCarga"
    ADD CONSTRAINT "CargaPreCarga_ID_ReglaDeCargaTecnica_fkey" FOREIGN KEY ("ID_ReglaCarga")
    REFERENCES public."ReglaDeCargaTecnica" ("ID_ReglaCargaTecn") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;

ALTER TABLE IF EXISTS public."ConceptosNegocio"
    ADD CONSTRAINT "ConceptosNegocio_id_referencia_fkey" FOREIGN KEY (id_referencia)
    REFERENCES public."DefinicionesTecnicas" ("id_DT") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;

ALTER TABLE IF EXISTS public."DefinicionesTecnicas"
    ADD CONSTRAINT "DefinicionesTecnicas_EquivalenciaId_fkey" FOREIGN KEY ("EquivalenciaId")
    REFERENCES public."DefinicionesTecnicas" ("id_DT") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."DefinicionesTecnicas"
    ADD CONSTRAINT "DefinicionesTecnicas_EsquemaId_fkey" FOREIGN KEY ("EsquemaId")
    REFERENCES public."Esquema" (id_esquema) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;

ALTER TABLE IF EXISTS public."Empleado"
    ADD CONSTRAINT "Empleado_rol_id_fkey" FOREIGN KEY (rol_id)
    REFERENCES public."Roles" (id_rol) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public."Empleado"
    ADD CONSTRAINT "Empleado_rol_id_fkey1" FOREIGN KEY (rol_id)
    REFERENCES public."Roles" (id_rol) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."Esquema"
    ADD CONSTRAINT "Esquema_AmbienteId_fkey" FOREIGN KEY ("AmbienteId")
    REFERENCES public."Ambiente" (id_ambiente) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;

ALTER TABLE IF EXISTS public."Tarea"
    ADD CONSTRAINT "Tarea_id_empleado_fkey" FOREIGN KEY (id_empleado)
    REFERENCES public."Empleado" (id_empleado) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;

ALTER TABLE IF EXISTS public."Pedido"
    ADD CONSTRAINT "Migracion_Id_Squad_fkey" FOREIGN KEY ("Id_Squad")
    REFERENCES public."Squad" (id_squad) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."Migracion"
    ADD CONSTRAINT "Migracion_Id_Tecnologia_fkey" FOREIGN KEY ("Id_Tecnologia")
    REFERENCES public."Tecnologia" (id_tecnologia) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."Migracion"
    ADD CONSTRAINT "Migracion_Pedido_Id_fkey" FOREIGN KEY ("Pedido_Id")
    REFERENCES public."Pedido" ("Pedido_Id") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;

ALTER TABLE IF EXISTS public."Migracion"
    ADD CONSTRAINT "Migracion_AmbienteId_fkey" FOREIGN KEY ("AmbienteId")
    REFERENCES public."Ambiente" (id_ambiente) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."Participa_en"
    ADD CONSTRAINT "Participa_en_Participante_Id_fkey" FOREIGN KEY ("Participante_Id")
    REFERENCES public."Participante" ("Participante_Id") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."Participa_en"
    ADD CONSTRAINT "Participa_en_Reunion_Id_fkey" FOREIGN KEY ("Reunion_Id")
    REFERENCES public."Reunion" ("Reunion_Id") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."Participante"
    ADD CONSTRAINT "Participante_Area_Id_fkey" FOREIGN KEY ("Area_Id")
    REFERENCES public."Area" ("Area_Id") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."Pedido"
    ADD CONSTRAINT "Pedido_Area_Id_fkey" FOREIGN KEY ("Area_Id")
    REFERENCES public."Area" ("Area_Id") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."Pedido"
    ADD CONSTRAINT "Pedido_Estado_Id_fkey" FOREIGN KEY ("Estado_Id")
    REFERENCES public."Estado" ("Estado_Id") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."Pedido"
    ADD CONSTRAINT "Pedido_Prioridad_Id_fkey" FOREIGN KEY ("Prioridad_Id")
    REFERENCES public."Prioridad" ("Prioridad_Id") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."Pertenece"
    ADD CONSTRAINT "Pertenece_CargoId_fkey" FOREIGN KEY ("CargoId")
    REFERENCES public."Cargo" (id_cargo) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."Pertenece"
    ADD CONSTRAINT "Pertenece_EmpleadoId_fkey" FOREIGN KEY ("EmpleadoId")
    REFERENCES public."Empleado" (id_empleado) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."Pertenece"
    ADD CONSTRAINT "Pertenece_SquadId_fkey" FOREIGN KEY ("SquadId")
    REFERENCES public."Squad" (id_squad) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."Programacion"
    ADD CONSTRAINT "Programacion_Migracion_Id_fkey" FOREIGN KEY ("Migracion_Id")
    REFERENCES public."Migracion" ("Migracion_Id") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."Recordatorio"
    ADD CONSTRAINT "Recordatorio_Reunion_Id_fkey" FOREIGN KEY ("Reunion_Id")
    REFERENCES public."Reunion" ("Reunion_Id") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."Recordatorio"
    ADD CONSTRAINT "Recordatorio_TipoRecordatorio_Id_fkey" FOREIGN KEY ("TipoRecordatorio_Id")
    REFERENCES public."Tipo_Recordatorio" ("TipoRecordatorio_Id") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."Recordatorio_Enviado"
    ADD CONSTRAINT "Recordatorio_Enviado_Participante_Id_fkey" FOREIGN KEY ("Participante_Id")
    REFERENCES public."Participante" ("Participante_Id") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."Recordatorio_Enviado"
    ADD CONSTRAINT "Recordatorio_Enviado_Recordatorio_Id_fkey" FOREIGN KEY ("Recordatorio_Id")
    REFERENCES public."Recordatorio" ("Recordatorio_Id") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."RegistroErrores"
    ADD CONSTRAINT "RegistroErrores_Id_Empleado_fkey" FOREIGN KEY ("Id_Empleado")
    REFERENCES public."Empleado" (id_empleado) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."RegistroErrores"
    ADD CONSTRAINT "RegistroErrores_Id_error_fkey" FOREIGN KEY ("Id_error")
    REFERENCES public."TipoError" ("Id_error") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."RegistroErrores"
    ADD CONSTRAINT "RegistroErrores_Migracion_Id_fkey" FOREIGN KEY ("Migracion_Id")
    REFERENCES public."Migracion" ("Migracion_Id") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."ReglasDeCarga"
    ADD CONSTRAINT "ReglasDeCarga_id_campo_fkey" FOREIGN KEY (id_campo)
    REFERENCES public."Campo" (id_campo) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."ReglasDeCarga"
    ADD CONSTRAINT "ReglasDeCarga_id_tecnologia_fkey" FOREIGN KEY (id_tecnologia)
    REFERENCES public."Tecnologia" (id_tecnologia) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."Reporte"
    ADD CONSTRAINT "Reporte_id_admin_fkey" FOREIGN KEY (id_admin)
    REFERENCES public."Empleado" (id_empleado) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."Reporte"
    ADD CONSTRAINT "Reporte_id_usuario_fkey" FOREIGN KEY (id_usuario)
    REFERENCES public."Empleado" (id_empleado) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."Reporte_Conformidad"
    ADD CONSTRAINT "Reporte_Conformidad_Pedido_Id_fkey" FOREIGN KEY ("Pedido_Id")
    REFERENCES public."Pedido" ("Pedido_Id") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public."Reunion"
    ADD CONSTRAINT "Reunion_Id_Empleado_fkey" FOREIGN KEY ("Id_Empleado")
    REFERENCES public."Empleado" (id_empleado) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."Reunion"
    ADD CONSTRAINT "Reunion_Pedido_Id_fkey" FOREIGN KEY ("Pedido_Id")
    REFERENCES public."Pedido" ("Pedido_Id") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."Reunion"
    ADD CONSTRAINT "Reunion_TipoReunion_Id_fkey" FOREIGN KEY ("TipoReunion_Id")
    REFERENCES public."Tipo_Reunion" ("TipoReunion_Id") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."Reunion_Reporte_Conformidad"
    ADD CONSTRAINT "Reunion_Reporte_Conformidad_Reporte_Id_fkey" FOREIGN KEY ("Reporte_Id")
    REFERENCES public."Reporte_Conformidad" ("Reporte_Id") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."Reunion_Reporte_Conformidad"
    ADD CONSTRAINT "Reunion_Reporte_Conformidad_Reunion_Id_fkey" FOREIGN KEY ("Reunion_Id")
    REFERENCES public."Reunion" ("Reunion_Id") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;
	
ALTER TABLE IF EXISTS public."Modelado"
    ADD CONSTRAINT "Modelado_id_referencia_fkey" FOREIGN KEY ("id_referencia")
    REFERENCES public."DefinicionesTecnicas" ("id_DT") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;
	
-- Insertar datos en la tabla Prioridad
INSERT INTO public."Prioridad"("Prioridad_Id", "Prioridad_Tipo", "Prioridad_Detalle")
VALUES
    (1, 'Alta', 'Pedidos urgentes que requieren atención inmediata'),
    (2, 'Media', 'Pedidos importantes pero que no son urgentes'),
    (3, 'Baja', 'Pedidos que pueden ser atendidos en un plazo más amplio');

-- Insertar datos en la tabla Área
INSERT INTO public."Area"("Area_Id", "Area_Nombre", "Area_Descripcion", "Area_Direccion") VALUES
(1, 'CONTABILIDAD GENERAL', 'Área encargada de la contabilidad financiera de la empresa.', 'contabilidadgeneral@bcp.com'),
(2, 'TESORERÍA Y CAMBIOS', 'Área responsable de la gestión de la tesorería y las operaciones de cambio.', 'tesoreriaycambios@bcp.com'),
(3, 'PLANEAMIENTO CONTROL FINANCIERO', 'Área encargada del planeamiento y control financiero de la empresa.', 'planeamientoycontrolfinanciero@bcp.com'),
(4, 'GESTIÓN FINANCIERA', 'Área que se encarga de la gestión financiera de la empresa.', 'gestionfinanciera@bcp.com'),
(5, 'PROYECTOS CORPORATIVOS', 'Área responsable de la ejecución de proyectos corporativos.', 'proyectoscorporativos@bcp.com'),
(6, 'BANCA EMPRESARIAL', 'Área dedicada a la atención y gestión de clientes empresariales.', 'bancaempresarial@bcp.com'),
(7, 'BANCA CORPORATIVA', 'Área encargada de la gestión de relaciones con clientes corporativos.', 'bancacorporativa@bcp.com'),
(8, 'NEGOCIOS INTERNACIONALES', 'Área especializada en la gestión de negocios internacionales.', 'negociosinternacionales@bcp.com'),
(9, 'LEASING', 'Área responsable de la gestión de contratos de leasing.', 'leasing@bcp.com'),
(10, 'PLANEAMIENTO ESTRATEGICO Y DESARROLLO', 'Área encargada del planeamiento estratégico y desarrollo empresarial.', 'planeamientoestrategicoydesarrollo@bcp.com'),
(11, 'GESTIÓN DE INVERSIONES', 'Área especializada en la gestión de inversiones financieras.', 'gestiondeinversiones@bcp.com'),
(12, 'ESTRATEGIA DE INV. Y ESTUDIOS ECONOMICOS', 'Área encargada del análisis estratégico de inversiones y estudios económicos.', 'estrategiadeinversionesyestudios@bcp.com'),
(13, 'GESTIÓN DE PATRIMONIOS', 'Área dedicada a la gestión de patrimonios y activos financieros.', 'gestiondepatrimonios@bcp.com'),
(14, 'GESTION DE PRODUCTOS DE INVERSION', 'Área encargada de la gestión y desarrollo de productos de inversión.', 'gestiondeproductosdeinversion@bcp.com'),
(15, 'GESTION DE PRODUCCION Y TECNOLOGIA', 'Área responsable de la gestión de producción y tecnología.', 'gestiondeproduccionytecnologia@bcp.com'),
(16, 'NEGOCIOS FIDUCIARIOS', 'Área dedicada a la gestión de negocios fiduciarios.', 'negociosfiduciarios@bcp.com'),
(17, 'COMERCIAL', 'Área encargada de las actividades comerciales y ventas.', 'comercial@bcp.com'),
(18, 'SISTEMA Y ORGANIZACIÓN', 'Área responsable del diseño y gestión de sistemas y organización.', 'sistemayorganizacion@bcp.com'),
(19, 'ADMINISTRACIÓN Y PROCESOS', 'Área encargada de la administración y optimización de procesos.', 'administracionyprocesos@bcp.com'),
(20, 'MARKETING', 'Área dedicada a la planificación y ejecución de estrategias de marketing.', 'marketing@bcp.com');

-- Insertar datos en la tabla Estado
INSERT INTO public."Estado"("Estado_Id", "Estado_Tipo")
VALUES
    (1, 'Pendiente'),
    (2, 'En proceso'),
    (3, 'Completado'),
    (4, 'Cancelado');

-- Insertar datos en la tabla Squad
INSERT INTO public."Squad"(
    nombre_squad)
VALUES
    ('Alexandría'),
    ('AlphaMLpos'),
    ('Berlin'),
	('Canales'),
	('CRMA Datatichiq'),
	('CRMO'),
    ('Darwin'),
	('DATA & ANALYTICS'),
    ('Data Racoons'),
	('Descentralización'),
	('Dominio-ADR'),
	('Dominio-Creditos'),
	('Dominio-Rdt'),
	('Estrategia y adopción migración'),
	('Estrategia y migración integral'),
    ('Fenix'),
	('For Analytics DDV'),
	('For Analytics Migración'),
	('IFRS9'),
    ('Illary'),
	('In Advance +'),
    ('Insigthers'),
	('Migración Cloud'),
	('Migración Tercerizada'),
    ('PBM'),
	('Pucará'),
	('RBM-DataLake'),
	('RBM-Pyme'),
	('Riesgos Negocios, Mayorista y Parámetros'),
	('Riesgos Persona'),
	('Riesgo PYME'),
	('Soluciones de Migración Cloud'),
	('SpeedUP'),
	('Tribu RNF'),
	('TukuyWari'),
	('Yaku'),
	('YAPE');


-- Insertar datos en la tabla Pedido
INSERT INTO public."Pedido"("Area_Id", "Prioridad_Id", "Estado_Id", "Id_Squad", "Pedido_Fecha", "Pedido_FechaLimite")
VALUES 
(1, 2, 3, 17, '2022-01-05', '2022-02-15'),
(2, 1, 1, 24, '2022-02-10', '2022-03-20'),
(3, 3, 4, 10, '2022-03-15', '2022-04-25'),
(1, 2, 3, 5, '2022-01-05', '2022-02-15'),
(2, 1, 2, 29, '2022-02-10', '2022-03-20'),
(3, 3, 4, 13, '2022-03-15', '2022-04-25'),
(1, 1, 1, 21, '2022-04-20', '2022-05-30'),
(1, 2, 3, 8, '2022-01-05', '2022-02-15'),
(2, 1, 2, 33, '2022-02-10', '2022-03-20'),
(3, 3, 4, 25, '2022-03-15', '2022-04-25'),
(1, 1, 1, 36, '2022-04-20', '2022-05-30'),
(2, 2, 3, 4, '2022-05-25', '2022-06-05'),
(3, 1, 2, 19, '2022-06-30', '2022-08-10'),
(1, 2, 3, 14, '2022-08-05', '2022-09-15'),
(2, 1, 1, 11, '2022-09-10', '2022-10-20'),
(3, 3, 4, 7, '2022-10-15', '2022-11-25'),
(1, 1, 2, 32, '2022-11-20', '2022-12-30'),
(2, 2, 3, 1, '2022-05-25', '2022-06-05'),
(3, 1, 2, 23, '2022-06-30', '2022-08-10'),
(1, 2, 3, 3, '2022-08-05', '2022-09-15'),
(2, 1, 1, 15, '2022-09-10', '2022-10-20'),
(3, 3, 4, 22, '2022-10-15', '2022-11-25'),
(1, 1, 2, 6, '2022-11-20', '2022-12-30'),
(1, 1, 2, 9, '2022-04-20', '2022-05-30'),
(2, 2, 3, 18, '2022-05-25', '2022-06-05'),
(3, 1, 1, 30, '2022-06-30', '2022-08-10'),
(1, 3, 4, 34, '2022-08-05', '2022-09-15'),
(2, 2, 3, 35, '2022-09-10', '2022-10-20'),
(3, 1, 1, 12, '2022-10-15', '2022-11-25'),
(1, 2, 3, 16, '2022-11-20', '2022-12-30'),
(1, 1, 2, 2, '2022-01-05', '2022-02-15'),
(2, 2, 3, 28, '2022-02-10', '2022-03-20'),
(3, 3, 4, 26, '2022-03-15', '2022-04-25'),
(1, 1, 1, 20, '2022-04-20', '2022-05-30'),
(2, 3, 4, 31, '2022-05-25', '2022-06-05'),
(3, 2, 3, 37, '2022-06-30', '2022-08-10'),
(1, 1, 2, 27, '2022-08-05', '2022-09-15'),
(2, 2, 3, 9, '2022-09-10', '2022-10-20'),
(3, 3, 4, 16, '2022-10-15', '2022-11-25'),
(1, 1, 1, 25, '2022-11-20', '2022-12-30'),
(2, 2, 3, 3, '2023-01-05', '2023-02-15'),
(3, 1, 2, 11, '2023-02-10', '2023-03-20'),
(1, 3, 4, 18, '2023-03-15', '2023-04-25'),
(2, 1, 1, 7, '2023-04-20', '2023-05-30'),
(3, 2, 3, 14, '2023-05-25', '2023-06-05'),
(1, 1, 2, 10, '2023-06-30', '2023-08-10'),
(2, 2, 3, 5, '2023-08-05', '2023-09-15'),
(3, 1, 1, 22, '2023-09-10', '2023-10-20'),
(1, 3, 4, 27, '2023-10-15', '2023-11-25'),
(2, 1, 2, 36, '2023-11-20', '2023-12-30'),
(2, 2, 3, 8, '2023-01-05', '2023-02-15'),
(3, 1, 1, 13, '2023-02-10', '2023-03-20'),
(1, 3, 4, 2, '2023-03-15', '2023-04-25'),
(2, 1, 2, 21, '2023-04-20', '2023-05-30'),
(2, 1, 2, 17, '2023-01-05', '2023-02-15'),
(3, 3, 4, 24, '2023-02-10', '2023-03-20'),
(1, 2, 3, 33, '2023-03-15', '2023-04-25'),
(2, 1, 1, 35, '2023-04-20', '2023-05-30'),
(3, 3, 4, 6, '2023-05-25', '2023-06-05'),
(1, 1, 1, 15, '2023-06-30', '2023-08-10'),
(2, 2, 3, 19, '2023-08-05', '2023-09-15'),
(3, 1, 2, 1, '2023-09-10', '2023-10-20'),
(1, 2, 3, 29, '2023-10-15', '2023-11-25'),
(2, 1, 1, 34, '2023-11-20', '2023-12-30'),
(3, 2, 3, 30, '2023-05-25', '2023-06-05'),
(1, 1, 1, 12, '2023-06-30', '2023-08-10'),
(2, 2, 3, 26, '2023-08-05', '2023-09-15'),
(3, 1, 2, 16, '2023-09-10', '2023-10-20'),
(1, 2, 3, 20, '2023-10-15', '2023-11-25'),
(2, 1, 1, 28, '2023-11-20', '2023-12-30'),
(3, 3, 4, 5, '2024-01-05', '2024-02-15'),
(3, 3, 4, 31, '2024-01-05', '2024-02-15'),
(1, 1, 2, 18, '2024-02-10', '2024-03-20'),
(2, 2, 3, 20, '2024-03-15', '2024-04-25'),
(3, 2, 3, 32, '2024-01-05', '2024-02-15'),
(1, 1, 1, 25, '2024-02-10', '2024-03-20'),
(2, 3, 4, 9, '2024-03-15', '2024-04-25'),
(3, 2, 3, 23, '2024-04-20', '2024-05-30'),
(1, 1, 2, 22, '2024-05-25', '2024-06-05'),
(2, 2, 3, 4, '2024-06-30', '2024-08-10'),
(3, 3, 4, 7, '2024-08-05', '2024-09-15'),
(1, 1, 1, 36, '2024-09-10', '2024-10-20'),
(2, 2, 3, 14, '2024-10-15', '2024-11-25'),
(3, 3, 4, 19, '2024-11-20', '2024-12-30'),
(3, 1, 1, 18, '2024-04-20', '2024-05-30'),
(1, 2, 3, 1, '2024-05-25', '2024-06-05'),
(2, 1, 2, 13, '2024-06-30', '2024-08-10'),
(3, 3, 4, 9, '2024-08-05', '2024-09-15'),
(1, 2, 3, 21, '2024-09-10', '2024-10-20'),
(2, 1, 1, 26, '2024-10-15', '2024-11-25'),
(3, 3, 4, 35, '2024-11-20', '2024-12-30'),
(1, 1, 2, 18, '2024-02-10', '2024-03-20'),
(2, 2, 3, 27, '2024-03-15', '2024-04-25'),
(3, 1, 1, 6, '2024-04-20', '2024-05-30'),
(1, 2, 3, 28, '2024-05-25', '2024-06-05'),
(2, 1, 2, 22, '2024-06-30', '2024-08-10'),
(3, 3, 4, 4, '2024-08-05', '2024-09-15'),
(1, 2, 3, 31, '2024-09-10', '2024-10-20'),
(2, 1, 1, 3, '2024-10-15', '2024-11-25'),
(3, 3, 4, 24, '2024-11-20', '2024-12-30');

-- Insertar datos en la tabla Tecnologia
INSERT INTO public."Tecnologia" (id_tecnologia, nombre_tecnologia)
VALUES (1, 'Pyspark'),
       (2, 'Bashsrc'),
       (3, 'Hsqldb'),
       (4, 'Kafka'),
       (5, 'MFRM'),
       (6, 'Spkscal'),
       (7, 'pl/SQL'),
       (8, 'Pseudocodigo');
	   
INSERT INTO public."Roles" (id_rol,nombre_rol, nivel_acceso) VALUES
(1,'Data Modeler', 'medio'),
(2,'Data Engineer', 'alto'),
(3,'Data Governance Expert', 'muy alto'),
(4,'Data Steward', 'medio'),
(5,'Data Steward Senior', 'alto'),
(6,'Custodio Técnico', 'alto'),
(7,'Product Owner', 'muy alto'),
(8,'System Admin', 'muy alto');

-- Insertar datos en la tabla Empleado
INSERT INTO public."Empleado" (
    id_empleado,nombre, correo, "contraseña", telefono, dni, rol_id)
VALUES
(1,'Juan Perez', 'juanp@bcp.pe', 'juanp3r3z', '987654321', '12345678', 8),
(2,'Rosita Rojas', 'rositar@bcp.pe', 'r0sit4r0j4s', '987654322', '23456789', 2),
(3,'Yin Mendoza', 'yinm@bcp.pe', 'y1nm3nd0z4', '987654323', '34567890', 3),
(4,'Carolina Cavero', 'carolinac@bcp.pe', 'c4r0l1n4c4v3r0', '987654324', '45678901', 4),
(5,'Alexander Ramirez', 'alexanderr@bcp.pe', 'al3x4nd3r', '987654325', '56789012', 5),
(6,'Bruno Roldan', 'brunor@bcp.pe', 'brun0r0ld4n', '987654326', '67890123', 6),
(7,'Jorge Hinostroza', 'jorgh@bc.pe', 'j0rg3hin0str0z4', '987654327', '78901234', 7),
(8, 'Ana López', 'analopez@bcp.pe', '498dacaa11', '987654328', '12345679', 1),
(9, 'Carlos Sánchez', 'carlossanchez@bcp.pe', 'd32e6acba', '987654329', '23456780', 2),
(10, 'Beatriz Martínez', 'beatrizmartinez@bcp.pe', 'cb78c2be7', '987654330', '34567891', 3),
(11, 'David Gómez', 'davidgomez@bcp.pe', '7f8773721', '987654331', '45678902', 4),
(12, 'Elena Torres', 'elenatorres@bcp.pe', '3cb46e763', '987654332', '56789013', 5),
(13, 'Francisco Ruiz', 'franciscoruiz@bcp.pe', '47bfa4256', '987654333', '67890124', 6),
(14, 'Gabriela Fernández', 'gabrielafernandez@bcp.pe', 'c9d68315e', '987654334', '78901235', 7),
(15, 'Hugo Morales', 'hugomorales@bcp.pe', '05c784f28', '987654335', '89012346', 8),
(16, 'Isabel Rojas', 'isabelrojas@bcp.pe', '22f483fe2', '987654336', '90123457', 1),
(17, 'Javier Castro', 'javiercastro@bcp.pe', '3d10996cd', '987654337', '12345680', 2),
(18, 'Karen Jiménez', 'karenjimenez@bcp.pe', '7f67914c1', '987654338', '23456781', 3),
(19, 'Luis Pérez', 'luisperez@bcp.pe', '301d7e354', '987654339', '34567892', 4),
(20, 'Marta Herrera', 'martaherrera@bcp.pe', '2fb148e06', '987654340', '45678903', 5),
(21, 'Nicolás Castro', 'nicolascastro@bcp.pe', '6f5b3fc94', '987654341', '56789014', 6),
(22, 'Olga Vega', 'olgavega@bcp.pe', '83a7c33e2', '987654342', '67890125', 7),
(23, 'Pedro Navarro', 'pedronavarro@bcp.pe', 'f36021552', '987654343', '78901236', 8),
(24, 'Quintín Maldonado', 'quintinmaldonado@bcp.pe', '1c9f4a5e2', '987654344', '89012347', 1),
(25, 'Raquel Ramírez', 'raquelramirez@bcp.pe', '3dae52bf0', '987654345', '90123458', 2),
(26, 'Sergio Ortiz', 'sergioortiz@bcp.pe', '8e580f6f1', '987654346', '12345681', 3),
(27, 'Tatiana Paredes', 'tatianaparedes@bcp.pe', '592a330a0', '987654347', '23456782', 4),
(28, 'Ulises Rivera', 'ulisesrivera@bcp.pe', 'c27786d58', '987654348', '34567893', 5),
(29, 'Verónica Aguilar', 'veronicaaguilar@bcp.pe', 'a8939a786', '987654349', '45678904', 6),
(30, 'Wilfredo Díaz', 'wilfredodiaz@bcp.pe', '6ed9da01f', '987654350', '56789015', 7),
(31, 'Ximena Santos', 'ximenasantos@bcp.pe', '53ddcdfe7', '987654351', '67890126', 8);


-- Insertar datos en la tabla Cargo
INSERT INTO public."Cargo"(
    id_cargo, nombre_cargo)
VALUES
    (1, 'Data Modeler'),
    (2, 'Data Engieneer'),
    (3, 'Data Governance Expert'),
    (4, 'Data Steward'),
    (5, 'Data Steward Senior'),
    (6, 'Custodio Tecnico'),
    (7, 'Producto Owner');

	
-- Insertar datos en la tabla Pertenece
INSERT INTO public."Pertenece"(
    id_pertenece, "SquadId", "EmpleadoId", "CargoId")
VALUES
    (1, 1, 1, 1),
    (2, 1, 2, 2),
    (3, 1, 3, 3),
    (4, 1, 4, 4),
    (5, 1, 5, 5),
    (6, 1, 6, 6),
    (7, 1, 7, 7);

-- Insertar datos en la tabla Ambiente
INSERT INTO public."Ambiente"(
    nombre_ambiente)
VALUES
    ('DWH'),
    ('SandBox'),
    ('SAS');

--Insertar Datos en la tabla Migracion
INSERT INTO public."Migracion"(
	"Pedido_Id", "Id_Tecnologia", "AmbienteId", "Fecha_migracion", "Valido", "Ultimo")
VALUES
    (1, 1, 1, '10/04/24', true, false),
    (1, 1, 2, '10/04/24', true, true),
    (1, 2, 3, '11/04/24', false, false),
    (1, 1, 1, '10/04/24', false, false),
    (1, 1, 2, '9/04/24', false, false),
    (1, 2, 3, '9/04/24', true, false),
    (1, 2, 1, '10/04/24', true, false),
    (2, 1, 2, '2022-03-15', true, false),
    (2, 2, 3, '2022-03-20', false, true),
    (2, 1, 1, '2022-03-25', true, false),
    (3, 2, 2, '2022-04-10', false, false),
    (3, 1, 3, '2022-04-15', true, false),
    (3, 1, 1, '2022-04-20', true, false),
    (4, 2, 2, '2022-05-05', true, true),
    (4, 2, 3, '2022-05-10', false, false),
    (4, 1, 1, '2022-05-15', true, false),
    (5, 1, 2, '2022-06-20', true, false),
    (5, 1, 3, '2022-06-25', false, false),
    (5, 2, 1, '2022-06-30', true, true),
    (6, 2, 2, '2022-07-10', true, false),
    (6, 1, 3, '2022-07-15', false, false),
    (6, 1, 1, '2022-07-20', true, false),
    (7, 2, 2, '2022-08-05', false, false),
    (7, 1, 3, '2022-08-10', true, false),
    (7, 1, 1, '2022-08-15', true, false),
    (8, 2, 2, '2022-09-20', true, true),
    (8, 2, 3, '2022-09-25', false, false),
    (8, 1, 1, '2022-09-30', true, false),
    (9, 1, 2, '2022-10-10', false, false),
    (9, 2, 3, '2022-10-15', true, false),
    (9, 2, 1, '2022-10-20', true, false),
    (10, 1, 2, '2022-11-05', true, true),
    (10, 1, 3, '2022-11-10', false, false),
    (10, 2, 1, '2022-11-15', true, false),
    (11, 2, 2, '2022-12-20', false, false),
    (11, 1, 3, '2022-12-25', true, false),
    (11, 1, 1, '2022-12-30', true, false),
    (12, 2, 2, '2023-01-10', true, false),
    (12, 1, 3, '2023-01-15', false, false),
    (12, 1, 1, '2023-01-20', true, false),
    (13, 2, 2, '2023-02-05', true, true),
    (13, 1, 3, '2023-02-10', false, false),
    (13, 1, 1, '2023-02-15', true, false),
    (14, 1, 2, '2023-03-20', true, false),
    (14, 2, 3, '2023-03-25', false, false),
    (14, 2, 1, '2023-03-30', true, false),
    (15, 1, 2, '2023-04-05', false, true),
    (15, 1, 3, '2023-04-10', true, false),
    (15, 2, 1, '2023-04-15', true, false),
    (16, 2, 2, '2023-05-20', true, false),
    (16, 1, 3, '2023-05-25', false, false),
    (16, 1, 1, '2023-05-30', true, false),
    (17, 2, 2, '2023-06-05', true, true),
    (17, 2, 3, '2023-06-10', false, false),
    (17, 1, 1, '2023-06-15', true, false),
    (18, 1, 2, '2023-07-20', true, false),
    (18, 1, 3, '2023-07-25', false, false),
    (18, 2, 1, '2023-07-30', true, false),
    (19, 2, 2, '2023-08-05', false, true),
    (19, 1, 3, '2023-08-10', true, false),
    (19, 1, 1, '2023-08-15', true, false),
    (20, 1, 2, '2023-09-20', true, false),
    (20, 2, 3, '2023-09-25', false, false),
    (20, 2, 1, '2023-09-30', true, false),
    (21, 1, 2, '2023-10-05', true, true),
    (21, 1, 3, '2023-10-10', false, false),
    (21, 2, 1, '2023-10-15', true, false),
    (22, 2, 2, '2023-11-20', true, false),
    (22, 1, 3, '2023-11-25', false, false),
    (22, 1, 1, '2023-11-30', true, false),
    (23, 1, 2, '2023-12-05', true, true),
    (23, 2, 3, '2023-12-10', false, false),
    (23, 2, 1, '2023-12-15', true, false),
    (24, 1, 2, '2024-01-20', true, false),
    (24, 1, 3, '2024-01-25', false, false),
    (24, 2, 1, '2024-01-30', true, false),
    (25, 2, 2, '2024-02-05', true, true),
    (25, 1, 3, '2024-02-10', false, false),
    (25, 1, 1, '2024-02-15', true, false),
    (26, 1, 2, '2024-03-20', true, false),
    (26, 2, 3, '2024-03-25', false, false),
    (26, 2, 1, '2024-03-30', true, false),
    (27, 2, 2, '2024-04-05', true, true),
    (27, 1, 3, '2024-04-10', false, false),
    (27, 1, 1, '2024-04-15', true, false),
    (28, 2, 2, '2024-05-20', true, false),
    (28, 1, 3, '2024-05-25', false, false),
    (28, 1, 1, '2024-05-30', true, false),
    (29, 1, 2, '2024-06-05', true, true),
    (29, 2, 3, '2024-06-10', false, false),
    (29, 2, 1, '2024-06-15', true, false),
    (30, 1, 2, '2024-07-20', true, false),
    (30, 2, 3, '2024-07-25', false, false),
    (30, 2, 1, '2024-07-30', true, false),
    (31, 2, 2, '2024-08-05', true, true),
    (31, 1, 3, '2024-08-10', false, false),
    (31, 1, 1, '2024-08-15', true, false),
    (32, 1, 2, '2024-09-20', true, false),
    (32, 2, 3, '2024-09-25', false, false),
    (32, 2, 1, '2024-09-30', true, false),
    (33, 2, 2, '2024-10-05', true, true),
    (33, 1, 3, '2024-10-10', false, false),
    (33, 1, 1, '2024-10-15', true, false),
    (34, 2, 2, '2024-11-20', true, false),
    (34, 1, 3, '2024-11-25', false, false),
    (34, 1, 1, '2024-11-30', true, false),
    (35, 1, 2, '2024-12-05', true, true);



--Insertar datos en la tabla Tarea
INSERT INTO public."Tarea" ("id_empleado", "id_migracion", "descripcion", "fecha_inicio", "fecha_fin", "fecha_fin_real", "calidad", estadoId) VALUES
(4, 1, 'Agregar Concepto de Negocio', '2024-06-01', '2024-06-10', '2024-06-04', 90, 3),
(4, 1, 'Agregar Equivalencia', '2024-06-01', '2024-06-02', '2024-06-11', 90, 3),
(8, 1, 'Insertar Modelo DDV', '2024-06-01', '2024-06-02', NULL, 90, 1),
(2, 1, 'Formalizar las reglas de carga', '2024-06-01', '2024-06-02', '2024-06-02', 90, 1),
(3, 1, 'Verificación de la gobernanza de datos', '2024-06-02', '2024-06-03', '2024-06-03', 85, 1),
(6, 1, 'Implementación de control de acceso', '2024-06-01', '2024-06-04', NULL, 88, 2),
(7, 1, 'Programar reuniones con stakeholders', '2024-06-03', '2024-06-05', NULL, 92, 2),
(8, 1, 'Modelado de datos para el nuevo proyecto', '2024-06-01', '2024-06-02', '2024-06-02', 87, 1),
(9, 1, 'Desarrollo de scripts de automatización', '2024-06-02', '2024-06-03', '2024-06-03', 89, 1),
(10, 1, 'Revisión y actualización de políticas de seguridad', '2024-06-01', '2024-06-02', '2024-06-02', 90, 1),
(11, 1, 'Evaluación de calidad de datos', '2024-06-03', '2024-06-05', NULL, 85, 2),
(12, 1, 'Desarrollo de nuevas reglas de carga', '2024-06-01', '2024-06-03', '2024-06-03', 86, 1),
(13, 1, 'Configuración avanzada de la base de datos', '2024-06-02', '2024-06-04', '2024-06-04', 88, 1),
(14, 1, 'Soporte técnico avanzado a usuarios', '2024-06-01', '2024-06-02', '2024-06-02', 90, 1),
(15, 1, 'Documentación de las políticas de datos', '2024-06-03', '2024-06-05', NULL, 84, 2),
(16, 1, 'Optimización del rendimiento del sistema', '2024-06-01', '2024-06-02', '2024-06-02', 89, 1),
(17, 1, 'Análisis de calidad de datos', '2024-06-02', '2024-06-03', '2024-06-03', 87, 1),
(18, 1, 'Soporte en la implementación de nuevas políticas', '2024-06-01', '2024-06-04', NULL, 85, 2),
(19, 1, 'Revisión de la estructura de datos', '2024-06-03', '2024-06-05', NULL, 88, 2),
(20, 1, 'Desarrollo de pruebas de integración', '2024-06-01', '2024-06-02', '2024-06-02', 90, 1),
(21, 1, 'Implementación de mejoras en la seguridad de datos', '2024-06-02', '2024-06-04', '2024-06-04', 86, 1),
(22, 1, 'Actualización de la documentación del sistema', '2024-06-01', '2024-06-02', '2024-06-02', 88, 1),
(23, 1, 'Desarrollo de nuevos módulos de seguridad', '2024-06-03', '2024-06-05', NULL, 89, 2),
(24, 1, 'Evaluación y reporte de cumplimiento de políticas', '2024-06-01', '2024-06-02', '2024-06-02', 90, 1),
(25, 1, 'Implementación de scripts de mantenimiento', '2024-06-02', '2024-06-04', '2024-06-04', 87, 1);

-- Insertar datos en la tabla Dominio
INSERT INTO public."Dominio"(
    tipo_dominio)
VALUES
    ('ADR'),
    ('AHORROS, INVERSIONES Y TRANSACCIONALES'),
    ('AUDITORÍA'),
    ('CANALES MAYORISTA'),
    ('CANALES MINORISTA'),
    ('CATALOGO PRODUCTOS CREDITICIOS PARA EMPRESAS'),
    ('CATALOGO PRODUCTO PERSONAS'),
    ('CATALOGO PRODUCTO TRANSACCIONALES PARA EMPRESA'),
    ('CLIENTES CONTENTOS'),
	('CLIENTES MAYORISTA'),
	('CLIENTES PPNN'),
	('CLIENTES PYME Y NEGOCIOS'),
	('COBRANZA MINORISTA'),
	('COLABORADORES'),
	('CONTABILIDAD'),
	('CRÉDITOS'),
	('CRM'),
	('CUMPLIMIENTO'),
	('DATA & ANALYTICS'),
	('EFICIENCIA'),
	('HIPOTECARIOS'),
	('LEGAL'),
	('MEDIOS DE PAGO'),
	('NUEVOS NEGOCIOS'),
	('PLANEAMIENTO FINANCIERO'),
	('PLANEAMIENTO MAYORISTA'),
	('PLANEAMIENTO MINORISTA'),
	('PRÉSTAMOS MINORISTA'),
	('RECONECTA'),
	('RIESGOS BANCOS MINORISTA'),
	('RIESGOS DE TESORERIA'),
	('RIESGOS NO FINANCIEROS'),
	('SEGUROS'),
	('SOLUCIONES DE PAGO'),
	('TESORERÍA'),
	('TI'),
	('YAPE');
	
INSERT INTO "Subdominio"(
	nombre_subdominio, id_dominio)
VALUES 
	('Gestión de Riesgos ADR',1),
	('Control de Fraude ADR',1),
	('Cumplimiento Normativo ADR',1),
	('Planificacion Financiera',2),
	('Gestión de Cartera de Inversiones',2),
	('Transacciones Bancarias',2),
	('Auditoría Interna',3),
	('Auditoría Externa',3),
	('Auditoría de Procesos',3),
	('Banca Mayorista',4),
	('Banca Corporativa',4),
	('Banca de Inversión',4),
	('Banca Minorista',5),
	('Banca Personal',5),
	('Banca Digital',5),
	('Prestamos Corporativos',6),
	('Líneas de Crédito Empresarial',6),
	('Factoring Empresarial',6),
	('Cuentas de Ahorro', 7),
    ('Tarjetas de Crédito', 7),
    ('Préstamos Personales', 7),
    ('Plataforma de Pagos Empresariales', 8),
    ('Banca Digital Empresarial', 8),
    ('Herramientas de Gestión Financiera Empresarial', 8),
    ('Encuestas de Satisfacción', 9),
    ('Programas de Fidelización', 9),
    ('Gestión de Reclamos y Quejas', 9),
    ('Asesoramiento Financiero Corporativo', 10),
    ('Servicios de Tesorería Empresarial', 10),
    ('Soluciones de Financiamiento Corporativo', 10),
	('Clientes Particulares', 11),
    ('Clientes Personas Naturales', 11),
    ('Clientes Individuales', 11),
    ('Clientes PYME', 12),
    ('Clientes Pequeñas y Medianas Empresas', 12),
    ('Clientes Negocios', 12),
    ('Cobranza de Préstamos Personales', 13),
    ('Cobranza de Tarjetas de Crédito', 13),
    ('Cobranza de Créditos Hipotecarios', 13),
    ('Gestión de Talento', 14),
    ('Desarrollo Organizacional', 14),
    ('Bienestar Laboral', 14),
    ('Contabilidad General', 15),
    ('Contabilidad Financiera', 15),
    ('Contabilidad de Costos', 15),
    ('Créditos Personales', 16),
    ('Créditos Empresariales', 16),
    ('Créditos Hipotecarios', 16),
    ('Gestión de Relaciones con Clientes', 17),
    ('Automatización de Marketing', 17),
    ('Análisis de Clientes', 17),
    ('Normativas Regulatorias', 18),
    ('Políticas Internas', 18),
    ('Auditorías de Cumplimiento', 18),
    ('Análisis de Datos', 19),
    ('Business Intelligence', 19),
    ('Big Data', 19),
    ('Optimización de Procesos', 20),
    ('Automatización de Tareas', 20),
    ('Reducción de Costos', 20),
    ('Créditos Hipotecarios Residenciales', 21),
    ('Créditos Hipotecarios Comerciales', 21),
    ('Hipotecas Inversas', 21),
    ('Asesoría Legal Interna', 22),
    ('Asesoría Legal Externa', 22),
    ('Cumplimiento Legal', 22),
    ('Tarjetas de Débito', 23),
    ('Tarjetas de Crédito', 23),
    ('Transferencias Electrónicas', 23),
    ('Investigación de Mercado', 24),
    ('Desarrollo de Productos', 24),
    ('Estrategia de Expansión', 24),
    ('Asesoría Financiera Personal', 25),
    ('Planificación de Inversiones', 25),
    ('Planificación de Jubilación', 25),
    ('Planificación de Ventas Mayoristas', 26),
    ('Planificación de Inventario Mayorista', 26),
    ('Planificación de Precios Mayoristas', 26),
    ('Planificación de Ventas Minoristas', 27),
    ('Planificación de Inventario Minorista', 27),
    ('Planificación de Precios Minoristas', 27),
    ('Préstamos Personales', 28),
    ('Préstamos para Vivienda', 28),
    ('Préstamos para Automóviles', 28),
    ('Reconexión con Clientes', 29),
    ('Reconexión con Colaboradores', 29),
    ('Reconexión con la Comunidad', 29),
	('Riesgos de Crédito', 30),
    ('Riesgos Operativos', 30),
    ('Riesgos de Liquidez', 30),
	('Riesgos de Mercado', 31),
    ('Riesgos de Tasa de Interés', 31),
    ('Riesgos de Cambio', 31),
	('Riesgos Ambientales', 32),
    ('Riesgos de Reputación', 32),
    ('Riesgos de Seguridad', 32),
	('Seguros de Vida', 33),
    ('Seguros de Salud', 33),
    ('Seguros de Automóviles', 33),
	('PrestamosTarjeteros', 34),
    ('Plataformas Pago Electrónico', 34),
    ('Carteras Digitales', 34),
	('Gestión de Tesorería', 35),
    ('Gestión de Riesgos Financieros', 35),
    ('Planificación de Efectivo', 35),
	('Desarrollo de Software', 36),
    ('Infraestructura Tecnológica', 36),
    ('Ciberseguridad', 36),
	('Pagos entre Personas', 37),
    ('Pagos en Establecimientos', 37),
    ('Retiros en Cajeros', 37);
	

-- Insertar datos en la tabla Esquema
INSERT INTO public."Esquema"(
   "AmbienteId", nombre_esquema)
VALUES
    (1, 'ODS'),
    (1, 'EDS'),
    (1, 'BDS'),
    (1, 'SDS'),
    (2, 'U98675'),
    (3, '/SAS/path/to/resource'),
    (1, 'catalog_lhcl_prod_bcp.bcp_ddv_dyadata_dataenrichment'),
	(1,'catalog_lhcl_prod_bcp.bcp_ddv_dyadata_dataprofiler'),
	(1,'catalog_lhcl_prod_bcp.bcp_ddv_dyadata_dataanalyzer'),
	(1, 'catalog_lhcl_prod_bcp.bcp_ddv_dyadata_datareporter'),
	(2,'U98675EQ'),
	(3,'/SAS/eq/path/to/resource');

-- Insertar datos en la tabla DefinicionesTecnicas
INSERT INTO public."DefinicionesTecnicas"(
    "EquivalenciaId", "EsquemaId", "Tabla", "Campo")
VALUES
    (NULL, 1, 'MD_DIRECCIONCLIENTE', 'DIRECCION'),
    (1, 7, 'md_direccioncontacto', 'CODCLAVEDESDIRESTANDARIZADO'),
    (NULL, 1, 'MD_DIRECCIONCLIENTE', 'CODDEPARTAMENTO'),
    (3, 7, 'md_direccioncontacto', 'CODDEPARTAMENTOX'),
    (NULL, 1, 'MD_DIRECCIONCLIENTE', 'CODPROVINCIA'),
    (5, 7, 'md_direccioncontacto', 'CODPROVINCIAX'),
    (NULL, 1, 'MD_DIRECCIONCLIENTE', 'CODDISTRITO'),
    (7, 7, 'md_direccioncontacto', 'CODDISTRITOX'),
    (NULL, 1, 'MD_DIRECCIONCLIENTE', 'CODUBIGEO'),
    (9, 7, 'md_direccioncontacto', 'CODUBIGEOX'),
    (NULL, 1, 'HM_DEUDORRSBSDETALLERCC', 'TIP_CLASIF_CLIENTE_SBS'),
    (11, 7, 'h_deudorsbsdetalle', 'TIPCLASIFRIESGO'),
    (NULL, 1, 'UM_DEUDORRSBSDETALLERCC', 'SCORESBS'),
    (13, 7, 'h_deudorsbsdetalle', 'DESTIPCLASIFRIESGO'),
    (NULL, 2, 'MD_CLIENTE', 'NOMBRECLIENTE'),
    (15, 8, 'md_clientecontacto', 'NOMBRES'),
    (NULL, 2, 'MD_CLIENTE', 'APELLIDOCLIENTE'),
    (17, 8, 'md_clientecontacto', 'APELLIDOS'),
    (NULL, 2, 'MD_CLIENTE', 'DNICLIENTE'),
    (19, 8, 'md_clientecontacto', 'DNI'),
    (NULL, 2, 'MD_CLIENTE', 'EDAD'),
    (21, 8, 'md_clientecontacto', 'EDADX'),
    (NULL, 2, 'MD_CLIENTE', 'SEXO'),
    (23, 8, 'md_clientecontacto', 'SEXOX'),
    (NULL, 2, 'MD_CLIENTE', 'FECHANACIMIENTO'),
    (25, 8, 'md_clientecontacto', 'FECHANACIMIENTODES'),
    (NULL, 3, 'MD_CUENTA', 'NUMEROCUENTA'),
    (27, 9, 'md_cuentacontacto', 'NUMCUENTAX'),
    (NULL, 3, 'MD_CUENTA', 'TIPOCUENTA'),
    (29, 9, 'md_cuentacontacto', 'TIPOCUENTAX'),
    (NULL, 3, 'MD_CUENTA', 'SALDO'),
    (31, 9, 'md_cuentacontacto', 'SALDOX'),
    (NULL, 3, 'MD_CUENTA', 'FECHAAPERTURA'),
    (33, 9, 'md_cuentacontacto', 'FECHAAPERTURAX'),
    (NULL, 3, 'MD_CUENTA', 'ESTADO'),
    (35, 9, 'md_cuentacontacto', 'ESTADOX'),
    (NULL, 4, 'MD_PRESTAMO', 'IDPRESTAMO'),
    (37, 10, 'md_prestamocontacto', 'IDPRESTAMOX'),
    (NULL, 4, 'MD_PRESTAMO', 'MONTO'),
    (39, 10, 'md_prestamocontacto', 'MONTOX'),
    (NULL, 4, 'MD_PRESTAMO', 'FECHA'),
    (41, 10, 'md_prestamocontacto', 'FECHAX'),
    (NULL, 4, 'MD_PRESTAMO', 'PLAZO'),
    (43, 10, 'md_prestamocontacto', 'PLAZOX'),
    (NULL, 4, 'MD_PRESTAMO', 'TASAINTERES'),
    (45, 10, 'md_prestamocontacto', 'TASAINTERESX'),
    (NULL, 5, 'MD_TARJETA', 'NUMEROTARJETA'),
    (47, 11, 'md_tarjetacontacto', 'NUMEROTARJETAX'),
    (NULL, 5, 'MD_TARJETA', 'FECHAVENCIMIENTO'),
    (49, 11, 'md_tarjetacontacto', 'FECHAVENCIMIENTOX'),
    (NULL, 5, 'MD_TARJETA', 'CODIGOSEGURIDAD'),
    (51, 11, 'md_tarjetacontacto', 'CODIGOSEGURIDADX'),
    (NULL, 5, 'MD_TARJETA', 'TIPO'),
    (53, 11, 'md_tarjetacontacto', 'TIPOX'),
    (NULL, 5, 'MD_TARJETA', 'LIMITECREDITO'),
    (55, 11, 'md_tarjetacontacto', 'LIMITECREDITODES'),
    (NULL, 6, 'MD_TRANSACCION', 'IDTRANSACCION'),
    (57, 12, 'md_transaccioncontacto', 'IDTRANSACCIONDES'),
    (NULL, 6, 'MD_TRANSACCION', 'FECHATRANSACCION'),
    (59, 12, 'md_transaccioncontacto', 'FECHATRANSACCIONDES'),
    (NULL, 6, 'MD_TRANSACCION', 'MONTO'),
    (61, 12, 'md_transaccioncontacto', 'MONTOX'),
    (NULL, 6, 'MD_TRANSACCION', 'DESCRIPCION'),
    (63, 12, 'md_transaccioncontacto', 'DESCRIPCIONX'),
    (NULL, 6, 'MD_TRANSACCION', 'TIPO'),
    (65, 12, 'md_transaccioncontacto', 'TIPOX'),
    (NULL, 7, 'MD_SEGURO', 'IDSEGURO'),
    (67, 1, 'md_segurocontacto', 'IDSEGUROX'),
    (NULL, 7, 'MD_SEGURO', 'TIPOSEGURO'),
    (69, 1, 'md_segurocontacto', 'TIPOSEGUROX'),
    (NULL, 7, 'MD_SEGURO', 'COBERTURA'),
    (71, 1, 'md_segurocontacto', 'COBERTURAX'),
    (NULL, 7, 'MD_SEGURO', 'COSTO'),
	(73, 1, 'md_segurocontacto', 'COSTOX'),
    (NULL, 8, 'MD_INVERSION', 'IDINVERSION'),
    (75, 2, 'md_inversioncontacto', 'IDINVERSIONX'),
    (NULL, 8, 'MD_INVERSION', 'MONTOINVERTIDO'),
    (77, 2, 'md_inversioncontacto', 'MONTOINVERTIDOX'),
    (NULL, 8, 'MD_INVERSION', 'FECHAINVERSION'),
    (79, 2, 'md_inversioncontacto', 'FECHAINVERSIONDES'),
    (NULL, 8, 'MD_INVERSION', 'PLAZO'),
    (81, 2, 'md_inversioncontacto', 'PLAZOX'),
    (NULL, 8, 'MD_INVERSION', 'TASARENABILIDAD'),
    (83, 2, 'md_inversioncontacto', 'TASARENABILIDADDES'),
    (NULL, 9, 'MD_DEPOSITO', 'IDDEPOSITO'),
    (85, 3, 'md_depositocontacto', 'IDDEPOSITOX'),
    (NULL, 9, 'MD_DEPOSITO', 'MONTO'),
    (87, 3, 'md_depositocontacto', 'MONTOX'),
    (NULL, 9, 'MD_DEPOSITO', 'FECHA'),
    (89, 3, 'md_depositocontacto', 'FECHAX'),
    (NULL, 9, 'MD_DEPOSITO', 'TIPO'),
    (91, 3, 'md_depositocontacto', 'TIPOX'),
    (NULL, 10, 'MD_PAGO', 'IDPAGO'),
    (93, 4, 'md_pagocontacto', 'IDPAGOX'),
    (NULL, 10, 'MD_PAGO', 'MONTO'),
    (95, 4, 'md_pagocontacto', 'MONTOX'),
    (NULL, 10, 'MD_PAGO', 'FECHA'),
    (97, 4, 'md_pagocontacto', 'FECHAX'),
    (NULL, 10, 'MD_PAGO', 'TIPO'),
    (99, 4, 'md_pagocontacto', 'TIPOX');


-- Insertar datos en la tabla Modelado
INSERT INTO public."Modelado"(
    "id_referencia", "EsquemaDDV", "TablaDDV", "CampoDDV", "CampoLlave", "Campo_Descarta")
VALUES
    (2, 'BCP_DDV_SDP_PRESTAMOSTARJETEROS', 'HD_LISTAGESTIONCLIENTESDP', 'DIRECCION', FALSE, FALSE),
    (4, 'BCP_DDV_SDP_PRESTAMOSTARJETEROS', 'HD_LISTAGESTIONCLIENTESDP', 'CODCLAVEDESDIRESTANDARIZADO', TRUE, FALSE),
    (6, 'BCP_DDV_SDP_PRESTAMOSTARJETEROS', 'HD_LISTAGESTIONCLIENTESDP', 'CODDEPARTAMENTO', FALSE, FALSE),
    (8, 'BCP_DDV_SDP_PRESTAMOSTARJETEROS', 'HD_LISTAGESTIONCLIENTESDP', 'CODPROVINCIA', FALSE, FALSE),
    (10, 'BCP_DDV_SDP_PRESTAMOSTARJETEROS', 'HD_LISTAGESTIONCLIENTESDP', 'CODDISTRITO', FALSE, FALSE),
    (12, 'BCP_DDV_SDP_PRESTAMOSTARJETEROS', 'HD_LISTAGESTIONCLIENTESDP', 'CODUBIGEO', FALSE, FALSE),
    (14, 'BCP_DDV_SDP_PRESTAMOSTARJETEROS', 'HD_LISTAGESTIONCLIENTESDP', 'TIP_CLASIF_CLIENTE_SBS', FALSE, FALSE),
    (16, 'BCP_DDV_SDP_PRESTAMOSTARJETEROS', 'MD_CLIENTECONTACTO', 'NOMBRECLIENTE', FALSE, FALSE),
    (18, 'BCP_DDV_SDP_PRESTAMOSTARJETEROS', 'MD_CLIENTECONTACTO', 'APELLIDOCLIENTE', FALSE, FALSE),
    (20, 'BCP_DDV_SDP_PRESTAMOSTARJETEROS', 'MD_CLIENTECONTACTO', 'DNICLIENTE', FALSE, FALSE),
    (22, 'BCP_DDV_SDP_PRESTAMOSTARJETEROS', 'MD_CLIENTECONTACTO', 'EDAD', FALSE, FALSE),
    (24, 'BCP_DDV_SDP_PRESTAMOSTARJETEROS', 'MD_CLIENTECONTACTO', 'SEXO', FALSE, FALSE),
    (26, 'BCP_DDV_SDP_PRESTAMOSTARJETEROS', 'MD_CLIENTECONTACTO', 'FECHANACIMIENTO', FALSE, FALSE),
    (28, 'BCP_DDV_SDP_PRESTAMOSTARJETEROS', 'HM_CUENTASCONTACTO', 'NUMEROCUENTAX', FALSE, FALSE),
    (30, 'BCP_DDV_SDP_PRESTAMOSTARJETEROS', 'HM_CUENTASCONTACTO', 'TIPOCUENTAX', FALSE, FALSE),
    (32, 'BCP_DDV_SDP_PRESTAMOSTARJETEROS', 'HM_CUENTASCONTACTO', 'SALDOX', FALSE, FALSE),
    (34, 'BCP_DDV_SDP_PRESTAMOSTARJETEROS', 'UM_TRANSACCIONESCONTACTO', 'IDTRANSACCIONX', FALSE, FALSE),
    (36, 'BCP_DDV_SDP_PRESTAMOSTARJETEROS', 'UM_TRANSACCIONESCONTACTO', 'FECHATRANSACCIONX', FALSE, FALSE),
    (38, 'BCP_DDV_SDP_PRESTAMOSTARJETEROS', 'UM_TRANSACCIONESCONTACTO', 'MONTOX', FALSE, FALSE),
    (40, 'BCP_DDV_SDP_PRESTAMOSTARJETEROS', 'HM_PRESTAMOSCONTACTO', 'IDPRESTAMOX', FALSE, FALSE),
    (42, 'BCP_DDV_SDP_PRESTAMOSTARJETEROS', 'HM_PRESTAMOSCONTACTO', 'MONTOPRESTAMOX', FALSE, FALSE),
    (44, 'BCP_DDV_SDP_PRESTAMOSTARJETEROS', 'HM_PRESTAMOSCONTACTO', 'FECHAVENCIMIENTOX', FALSE, FALSE),
    (46, 'BCP_DDV_SDP_PRESTAMOSTARJETEROS', 'UM_TARJETASCONTACTO', 'NUMEROTARJETAX', FALSE, FALSE),
    (48, 'BCP_DDV_SDP_PRESTAMOSTARJETEROS', 'UM_TARJETASCONTACTO', 'FECHAEXPIRACIONX', FALSE, FALSE),
    (50, 'BCP_DDV_SDP_PRESTAMOSTARJETEROS', 'UM_TARJETASCONTACTO', 'CODIGOSEGURIDADX', FALSE, FALSE),
    (52, 'BCP_DDV_SDP_PRESTAMOSTARJETEROS', 'HM_CLIENTESEGMENTOCONTACTO', 'SEGMENTOX', FALSE, FALSE),
    (54, 'BCP_DDV_SDP_PRESTAMOSTARJETEROS', 'HM_CLIENTESEGMENTOCONTACTO', 'SUBSEGMENTOX', FALSE, FALSE),
    (56, 'BCP_DDV_SDP_PRESTAMOSTARJETEROS', 'UM_CREDITOHISTORICOCONTACTO', 'CREDITOIDX', FALSE, FALSE),
    (58, 'BCP_DDV_SDP_PRESTAMOSTARJETEROS', 'UM_CREDITOHISTORICOCONTACTO', 'FECHACREDITOX', FALSE, FALSE),
    (60, 'BCP_DDV_SDP_PRESTAMOSTARJETEROS', 'UM_CREDITOHISTORICOCONTACTO', 'TIPOCREDITOX', FALSE, FALSE),
    (62, 'BCP_DDV_SDP_PRESTAMOSTARJETEROS', 'HM_INVERSIONESCONTACTO', 'INVERSIONIDX', FALSE, FALSE),
    (64, 'BCP_DDV_SDP_PRESTAMOSTARJETEROS', 'HM_INVERSIONESCONTACTO', 'TIPOINVERSIONX', FALSE, FALSE),
    (66, 'BCP_DDV_SDP_PRESTAMOSTARJETEROS', 'HM_INVERSIONESCONTACTO', 'MONTOINVERSIONX', FALSE, FALSE),
    (68, 'BCP_DDV_SDP_PRESTAMOSTARJETEROS', 'UM_SEGUROSCONTACTO', 'SEGUROIDX', FALSE, FALSE),
    (70, 'BCP_DDV_SDP_PRESTAMOSTARJETEROS', 'UM_SEGUROSCONTACTO', 'TIPOSEGUROX', FALSE, FALSE),
    (72, 'BCP_DDV_SDP_PRESTAMOSTARJETEROS', 'UM_SEGUROSCONTACTO', 'MONTOSEGUROX', FALSE, FALSE),
    (74, 'BCP_DDV_DDV_SDP_PRESTAMOSTARJETEROS', 'HM_PAGOSCONTACTO', 'PAGOIDX', FALSE, FALSE),
    (76, 'BCP_DDV_SDP_PRESTAMOSTARJETEROS', 'HM_PAGOSCONTACTO', 'FECHAPAGOX', FALSE, FALSE),
    (78, 'BCP_DDV_SDP_PRESTAMOSTARJETEROS', 'HM_PAGOSCONTACTO', 'MONTOPAGOX', FALSE, FALSE),
    (80, 'BCP_DDV_SDP_PRESTAMOSTARJETEROS', 'UM_GARANTIASCONTACTO', 'GARANTIAIDX', FALSE, FALSE),
    (82, 'BCP_DDV_SDP_PRESTAMOSTARJETEROS', 'UM_GARANTIASCONTACTO', 'TIPOGARANTIAX', FALSE, FALSE),
    (84, 'BCP_DDV_SDP_PRESTAMOSTARJETEROS', 'UM_GARANTIASCONTACTO', 'VALORGARANTIAX', FALSE, FALSE),
    (86, 'BCP_DDV_SDP_PRESTAMOSTARJETEROS', 'HM_TIPO_CAMBIOCONTACTO', 'MONEDAORIGENX', FALSE, FALSE),
    (88, 'BCP_DDV_SDP_PRESTAMOSTARJETEROS', 'HM_TIPO_CAMBIOCONTACTO', 'MONEDADESTINOX', FALSE, FALSE),
    (90, 'BCP_DDV_SDP_PRESTAMOSTARJETEROS', 'HM_TIPO_CAMBIOCONTACTO', 'TIPOCAMBIOX', FALSE, FALSE),
    (92, 'BCP_DDV_SDP_PRESTAMOSTARJETEROS', 'UM_DEPOSITOSCONTACTO', 'DEPOSITOIDX', FALSE, FALSE),
    (94, 'BCP_DDV_SDP_PRESTAMOSTARJETEROS', 'UM_DEPOSITOSCONTACTO', 'MONTODEPOSITOX', FALSE, FALSE),
    (96, 'BCP_DDV_SDP_PRESTAMOSTARJETEROS', 'UM_DEPOSITOSCONTACTO', 'FECHA_DEPOSITOX', FALSE, FALSE),
    (98, 'BCP_DDV_SDP_PRESTAMOSTARJETEROS', 'UM_DEPOSITOSCONTACTO', 'TIPODEPOSITOX', FALSE, FALSE);


-- Insertar datos en la tabla ConceptosNegocio
INSERT INTO public."ConceptosNegocio"(
   "id_subdominio", "id_referencia", "DefinicionCampo", "DefinicionTabla", "MigracionId")
VALUES
    (1, 1, 'Dirección del cliente', 'Tabla que contiene la información de clientes que solicitan su prestamo tarjetero', 1),
    (1, 3, 'Código del Departamento. De acuerdo a INEI, el Departamento corresponde al ámbito de mayor nivel de las circunscripciones territoriales de la República (división de primer orden) y se constituye sobre la base del sistema geo-económico y político administrativo conformado por provincias y distritos.', 'Tabla que contiene la información de clientes que solicitan su prestamo tarjetero', 1),
    (1, 5, 'Código de la Provincia. De acuerdo a INEI, la Provincia es la circunscripción territorial de segundo nivel en el sistema político administrativo, conformada para la administración del desarrollo de un ámbito que agrupa distritos; conforma un sistema geo-económico, que posee recursos humanos y naturales que le permiten establecer una base productiva adecuada para su desarrollo.', 'Tabla que contiene la información de clientes que solicitan su prestamo tarjetero', 1),
    (1, 7, 'Código de Distrito. De acuerdo a INEI, el Distrito es la unidad territorial base del sistema político administrativo, cuyo ámbito es una unidad geográfica con recursos humanos, económicos, financieros apta para el ejercicio de gobierno, administración, integración y desarrollo; con una población caracterizada por tener identidad histórico, cultural y capacidad de demandar y mantener servicios.', 'Tabla que contiene la información de clientes que solicitan su prestamo tarjetero', 1),
    (1, 9, 'Código de UBIGEO: El Ubigeo es el nombre que se le da oficialmente al código de ubicación geográfica del establecimiento en el Perú, y que es empleado para codificar las divisiones territoriales del país.', 'Tabla que contiene la información de clientes que solicitan su prestamo tarjetero', 1),
    (1, 11, 'Clasificación de riesgo del cliente en la empresa del sistema financiero', 'Tabla que contiene la información de clientes deudores', 1),
    (1, 13, 'Descripción de la clasificación de riesgo del cliente en la empresa del sistema financiero', 'Tabla que contiene la información de clientes deudores', 1),
    (2, 15, 'Código de Identificación del Cliente', 'Tabla que contiene la información de los clientes', 2),
    (2, 17, 'Número de Documento del Cliente', 'Tabla que contiene la información de los clientes', 2),
    (2, 19, 'Fecha de Nacimiento del Cliente', 'Tabla que contiene la información de los clientes', 2),
    (2, 21, 'Dirección de Correo Electrónico del Cliente', 'Tabla que contiene la información de los clientes', 2),
    (2, 23, 'Número de Teléfono del Cliente', 'Tabla que contiene la información de los clientes', 2),
    (2, 25, 'Fecha de Registro del Cliente', 'Tabla que contiene la información de los clientes', 2),
    (2, 27, 'Género del Cliente', 'Tabla que contiene la información de los clientes', 2),
    (3, 29, 'Saldo de la Cuenta del Cliente', 'Tabla que contiene la información de las cuentas de los clientes', 3),
    (3, 31, 'Número de Cuenta del Cliente', 'Tabla que contiene la información de las cuentas de los clientes', 3),
    (3, 33, 'Tipo de Cuenta del Cliente', 'Tabla que contiene la información de las cuentas de los clientes', 3),
    (3, 35, 'Fecha de Apertura de la Cuenta del Cliente', 'Tabla que contiene la información de las cuentas de los clientes', 3),
    (3, 37, 'Estado de la Cuenta del Cliente', 'Tabla que contiene la información de las cuentas de los clientes', 3),
    (3, 39, 'Fecha de Cierre de la Cuenta del Cliente', 'Tabla que contiene la información de las cuentas de los clientes', 3),
    (3, 41, 'Historial de Transacciones de la Cuenta del Cliente', 'Tabla que contiene la información de las cuentas de los clientes', 3),
    (4, 43, 'Monto de la Transacción', 'Tabla que contiene la información de las transacciones de los clientes', 4),
    (4, 45, 'Fecha de la Transacción', 'Tabla que contiene la información de las transacciones de los clientes', 4),
    (4, 47, 'Descripción de la Transacción', 'Tabla que contiene la información de las transacciones de los clientes', 4),
    (4, 49, 'Número de la Transacción', 'Tabla que contiene la información de las transacciones de los clientes', 4),
    (4, 51, 'Tipo de Transacción', 'Tabla que contiene la información de las transacciones de los clientes', 4),
    (4, 53, 'Estado de la Transacción', 'Tabla que contiene la información de las transacciones de los clientes', 4),
    (4, 55, 'Destino de la Transacción', 'Tabla que contiene la información de las transacciones de los clientes', 4),
    (5, 57, 'Número de Préstamo', 'Tabla que contiene la información de los préstamos de los clientes', 5),
    (5, 59, 'Monto del Préstamo', 'Tabla que contiene la información de los préstamos de los clientes', 5),
    (5, 61, 'Fecha de Desembolso del Préstamo', 'Tabla que contiene la información de los préstamos de los clientes', 5),
    (5, 63, 'Fecha de Vencimiento del Préstamo', 'Tabla que contiene la información de los préstamos de los clientes', 5),
    (5, 65, 'Interés del Préstamo', 'Tabla que contiene la información de los préstamos de los clientes', 5),
    (5, 67, 'Estado del Préstamo', 'Tabla que contiene la información de los préstamos de los clientes', 5),
    (5, 69, 'Tipo de Préstamo', 'Tabla que contiene la información de los préstamos de los clientes', 5),
    (6, 71, 'Número de Tarjeta', 'Tabla que contiene la información de las tarjetas de los clientes', 6),
    (6, 73, 'Fecha de Expiración de la Tarjeta', 'Tabla que contiene la información de las tarjetas de los clientes', 6),
    (6, 75, 'Código de Seguridad de la Tarjeta', 'Tabla que contiene la información de las tarjetas de los clientes', 6),
    (6, 77, 'Límite de Crédito de la Tarjeta', 'Tabla que contiene la información de las tarjetas de los clientes', 6),
    (6, 79, 'Saldo de la Tarjeta', 'Tabla que contiene la información de las tarjetas de los clientes', 6),
    (6, 81, 'Estado de la Tarjeta', 'Tabla que contiene la información de las tarjetas de los clientes', 6),
    (7, 83, 'Segmento del Cliente', 'Tabla que contiene la información del segmento de los clientes', 7),
    (7, 85, 'Subsegmento del Cliente', 'Tabla que contiene la información del segmento de los clientes', 7),
    (7, 87, 'Rango de Ingresos del Cliente', 'Tabla que contiene la información del segmento de los clientes', 7),
    (7, 89, 'Perfil de Riesgo del Cliente', 'Tabla que contiene la información del segmento de los clientes', 7),
    (7, 91, 'Preferencias del Cliente', 'Tabla que contiene la información del segmento de los clientes', 7),
    (7, 93, 'Historial de Contacto del Cliente', 'Tabla que contiene la información del segmento de los clientes', 7),
    (7, 95, 'Plan de Servicios del Cliente', 'Tabla que contiene la información del segmento de los clientes', 7),
    (8, 97, 'Identificación de Crédito', 'Tabla que contiene la información del historial crediticio de los clientes', 8),
    (8, 99, 'Fecha de Crédito', 'Tabla que contiene la información del historial crediticio de los clientes', 8);

-- Insertar datos en la tabla PreCarga
INSERT INTO public."PreCarga"(
    "ID_Precarga", "Nombre_Regla", "Descripcion", "Obligatorio")
VALUES
    (200001, 'Validacion Unicidad', 'Validacion no hay registros duplicados',true),
    (200002, 'Validacion Integridad Universal', 'Clave Foranea coincide con la principal en la tabla que está referenciando en todo momento',false),
    (200003, 'Validacion de Estructura o Expresion Regular', 'Formato de los campos correspondiente a lo que espera el negocio',false),
    (200004, 'Validacion Nulidad', 'No debe haber ningún campo obligatorio para el negocio en blanco',false),
    (200005, 'Regla de Limpieza y Estadarización', 'Identificar datos incorrectos',false),
    (200006, 'Regla de Enriquecimiento', 'Aumento de datos para mejorar la información existente',false);

-- Insertar datos en la tabla Algoritmo
INSERT INTO public."Algoritmo"(
    id_algoritmo, nombre_algoritmo, descripcion, "longClave", tipo)
VALUES
    (1, 'SHA2', 'SHA-512 es un algoritmo de hash criptográfico que produce un resumen único y fijo de 512 bits para cualquier entrada de datos. Utiliza operaciones matemáticas complejas para generar este resumen, lo que lo hace altamente resistente a colisiones y ataques de fuerza bruta. Es ampliamente utilizado en aplicaciones de seguridad y criptografía para proteger la integridad de los datos.', '512', 'Algoritmo de encriptación'),
    (2, 'AES256', 'AES-256 es un algoritmo de encriptación simétrica que utiliza una clave de 256 bits. Es ampliamente utilizado para proteger datos sensibles en aplicaciones y sistemas de información. Proporciona una seguridad sólida y se considera uno de los estándares de encriptación más fuertes disponibles actualmente.', '256', 'Algoritmo de enmascaramiento'),
    (3, 'RSA2048', 'RSA-2048 es un algoritmo de encriptación asimétrica que utiliza una clave de 2048 bits. Es ampliamente utilizado para el intercambio seguro de datos, como la autenticación y el establecimiento de conexiones seguras en internet.', '2048', 'Algoritmo de encriptación'),
    (4, 'Blowfish', 'Blowfish es un algoritmo de encriptación simétrica diseñado para ser rápido y eficiente en una amplia gama de plataformas. Aunque ha sido reemplazado por algoritmos más nuevos en muchos casos, aún se utiliza en aplicaciones donde la velocidad y la eficiencia son prioritarias.', '448', 'Algoritmo de enmascaramiento'),
    (5, 'MD5', 'MD5 es un algoritmo de hash criptográfico que produce un resumen de 128 bits para cualquier entrada de datos. Aunque ha sido encontrado vulnerable a colisiones, aún se utiliza en algunas aplicaciones para verificación de integridad de datos.', '128', 'Algoritmo de encriptación'),
    (6, 'Twofish', 'Twofish es un algoritmo de encriptación simétrica que utiliza claves de hasta 256 bits. Es conocido por su velocidad y flexibilidad en aplicaciones de hardware y software.', '256', 'Algoritmo de enmascaramiento'),
    (7, 'Serpent', 'Serpent es un algoritmo de encriptación simétrica que utiliza una clave de 256 bits. Fue finalista en la competencia AES y es conocido por su alta seguridad, aunque es más lento que AES.', '256', 'Algoritmo de encriptación'),
    (8, 'TripleDES', 'TripleDES es una versión más segura del algoritmo DES, aplicando el algoritmo tres veces a cada bloque de datos con diferentes claves. Es ampliamente utilizado en aplicaciones financieras y otros sectores.', '168', 'Algoritmo de enmascaramiento'),
    (9, 'ChaCha20', 'ChaCha20 es un algoritmo de encriptación simétrica diseñado para ser seguro y rápido en software. Utiliza una clave de 256 bits y es ampliamente utilizado en aplicaciones de comunicación segura.', '256', 'Algoritmo de encriptación'),
    (10, 'Salsa20', 'Salsa20 es un algoritmo de encriptación simétrica que utiliza una clave de 256 bits. Es conocido por su alta velocidad y eficiencia en aplicaciones de software.', '256', 'Algoritmo de enmascaramiento');

-- Insertar datos en la tabla TipoDato
INSERT INTO public."TipoDato"(
    "id_TipoDeDato", "Nombre", "Nivel de acceso", "Enmascarado", "Encriptación")
VALUES
    (1, 'RestringidoDAC', 'Muy Alto', true, true),
    (2, 'RestringidoNODAC', 'Alto', false, true),
    (3, 'Interno', 'Medio', false, false),
    (4, 'Publico', 'Bajo', false, false);

-- Insertar datos en la tabla Campo

INSERT INTO public."Campo"(
    id_campo, valor, propiedades, "id_TipodeDato", "id_AlgoritmoEnc", "id_AlgoritmoEnm", "ID_Modelo")
VALUES
    (1, '74844166', '{"nombre": "dni", "fecha_registro": "2024-04-24T12:00:00", "creador_id": "3"}', 2, 1, 2, 1),
    (2, 'Perez Gonzales', '{"nombre": "Apellido", "fecha_registro": "2024-04-24T12:00:00", "creador_id": "102"}', 3, 1, 2, 1),
    (3, '5000.00', '{"nombre": "Balance", "fecha_registro": "2024-04-24T12:00:00", "creador_id": "3"}', 2, 1, 2, 2),
    (4, '74844166', '{"nombre": "Juan Perez", "fecha_registro": "2024-04-24T12:00:00", "creador_id": "1"}', 2, 1, 2, 1),
    (5, 'Marco Antonio', '{"nombre": "Apellido", "fecha_registro": "2024-04-24T12:00:00", "creador_id": "2"}', 2, 1, 2, 1),
    (6, '5000.00', '{"nombre": "Balance", "fecha_registro": "2024-04-24T12:00:00", "creador_id": "4"}', 2, 1, 2, 4),
    (7, 'Juan', '{"nombre": "Nombre", "fecha_registro": "2024-04-25T12:00:00", "creador_id": "3"}', 2, 1, 2, 1),
    (8, '25', '{"nombre": "Edad", "fecha_registro": "2024-04-25T12:00:00", "creador_id": "5"}', 2, 1, 2, 3),
    (9, 'brayanrojastx@gmail.com', '{"nombre": "Correo Electrónico", "fecha_registro": "2024-04-26T12:00:00", "creador_id": "6"}', 2, 1, 2, 1),
    (10, '967823465', '{"nombre": "Teléfono", "fecha_registro": "2024-04-26T12:00:00", "creador_id": "7"}', 2, 1, 2, 1),
    (11, 'Casado', '{"nombre": "Estado Civil", "fecha_registro": "2024-04-27T12:00:00", "creador_id": "1"}', 2, 1, 2, 3),
    (12, '1234-5678-9012-3456', '{"nombre": "Número de Tarjeta de Crédito", "fecha_registro": "2024-04-27T12:00:00", "creador_id": "2"}', 2, 1, 2, 1),
    (13, 'Perú', '{"nombre": "Nacionalidad", "fecha_registro": "2024-04-28T12:00:00", "creador_id": "3"}', 2, 1, 2, 3),
    (14, 'Av. Principal 123', '{"nombre": "Dirección", "fecha_registro": "2024-04-28T12:00:00", "creador_id": "4"}', 2, 1, 2, 1),
    (15, '987654321', '{"nombre": "Teléfono", "fecha_registro": "2024-04-29T12:00:00", "creador_id": "5"}', 2, 1, 2, 1),
    (16, 'juan@example.com', '{"nombre": "Correo Electrónico", "fecha_registro": "2024-04-30T12:00:00", "creador_id": "6"}', 2, 1, 2, 1),
    (17, 'Gerente', '{"nombre": "Puesto de Trabajo", "fecha_registro": "2024-04-30T12:00:00", "creador_id": "7"}', 2, 1, 2, 1),
    (18, '50000.00', '{"nombre": "Salario", "fecha_registro": "2024-05-01T12:00:00", "creador_id": "1"}', 2, 1, 2, 2),
    (19, 'Ingeniería de Sistemas', '{"nombre": "Carrera", "fecha_registro": "2024-05-01T12:00:00", "creador_id": "2"}', 2, 1, 2, 1),
    (20, 'MSc', '{"nombre": "Grado Académico", "fecha_registro": "2024-05-02T12:00:00", "creador_id": "3"}', 2, 1, 2, 1),
    (21, 'Lima', '{"nombre": "Ciudad", "fecha_registro": "2024-05-03T12:00:00", "creador_id": "4"}', 2, 1, 2, 1),
    (22, 'Peruano', '{"nombre": "Nacionalidad", "fecha_registro": "2024-05-04T12:00:00", "creador_id": "5"}', 2, 1, 2, 3),
    (23, 'Masculino', '{"nombre": "Género", "fecha_registro": "2024-05-05T12:00:00", "creador_id": "6"}', 2, 1, 2, 1),
    (24, '1990-05-12', '{"nombre": "Fecha de Nacimiento", "fecha_registro": "2024-05-06T12:00:00", "creador_id": "7"}', 2, 1, 2, 1),
    (25, 'CAS', '{"nombre": "Estado Civil", "fecha_registro": "2024-05-07T12:00:00", "creador_id": "1"}', 2, 1, 2, 3),
    (26, 'Primaria Completa', '{"nombre": "Nivel de Estudios", "fecha_registro": "2024-05-08T12:00:00", "creador_id": "2"}', 2, 1, 2, 1),
    (27, 'Secundaria Completa', '{"nombre": "Nivel de Estudios", "fecha_registro": "2024-05-09T12:00:00", "creador_id": "3"}', 2, 1, 2, 1),
    (28, 'Técnico', '{"nombre": "Nivel de Estudios", "fecha_registro": "2024-05-10T12:00:00", "creador_id": "4"}', 2, 1, 2, 1),
    (29, 'Bachiller', '{"nombre": "Nivel de Estudios", "fecha_registro": "2024-05-11T12:00:00", "creador_id": "5"}', 2, 1, 2, 1),
    (30, 'Licenciado', '{"nombre": "Nivel de Estudios", "fecha_registro": "2024-05-12T12:00:00", "creador_id": "6"}', 2, 1, 2, 1);

-- Insertar datos en la tabla TipoError
INSERT INTO public."TipoError"(
    "Id_error", "Nombre_error")
VALUES
    (1, 'Modelado'),
    (2, 'Sintaxis'),
    (3, 'Formato'),
    (4, 'Tamaño'),
    (5, 'Equivalencia');

-- Insertar datos en la tabla Reporte

INSERT INTO public."Reporte"(
    id_reporte, id_admin, id_usuario, detalles, fecha, formato)
VALUES
    (1, 1, 1, 'Reporte de rendimiento del usuario', '2024-05-01', 'pdf'),
    (2, 1, 2, 'Reporte de actividades del mes', '2024-05-02', 'xlsx'),
    (3, 1, 1, 'Reporte de seguridad del sistema', '2024-05-03', 'docx'),
    (4, 1, 1, 'Reporte de uso de recursos', '2024-05-04', 'pdf'),
    (5, 1, 3, 'Reporte de cumplimiento de tareas', '2024-05-05', 'xlsx'),
    (6, 1, 4, 'Reporte de incidencias', '2024-05-06', 'pdf'),
    (7, 1, 1, 'Reporte de accesos', '2024-05-07', 'docx'),
    (8, 1, 1, 'Reporte de backups', '2024-05-08', 'pdf'),
    (9, 1, 5, 'Reporte de actualizaciones', '2024-05-09', 'xlsx'),
    (10, 1, 1, 'Reporte de integridad de datos', '2024-05-10', 'pdf'),
    (11, 1, 6, 'Reporte de estado de proyectos', '2024-05-11', 'pdf'),
    (12, 1, 1, 'Reporte de auditoría interna', '2024-05-12', 'xlsx'),
    (13, 1, 7, 'Reporte de cumplimiento normativo', '2024-05-13', 'docx'),
    (14, 1, 8, 'Reporte de análisis de riesgos', '2024-05-14', 'pdf'),
    (15, 1, 1, 'Reporte de desempeño financiero', '2024-05-15', 'xlsx'),
    (16, 1, 9, 'Reporte de satisfacción del cliente', '2024-05-16', 'docx'),
    (17, 1, 1, 'Reporte de mantenimiento de sistemas', '2024-05-17', 'pdf'),
    (18, 1, 10, 'Reporte de seguimiento de ventas', '2024-05-18', 'xlsx'),
    (19, 1, 1, 'Reporte de análisis de mercado', '2024-05-19', 'docx'),
    (20, 1, 11, 'Reporte de operaciones diarias', '2024-05-20', 'pdf');

-- Insertar datos en la tabla CampoAsegurado

INSERT INTO public."CampoAsegurado"(
    id_admin, id_campo)
VALUES
    (1, 1),
    (1, 2),
    (1, 3),
    (1, 4),
    (1, 5),
    (1, 6),
    (1, 7),
    (1, 8),
    (1, 9),
    (1, 10),
    (1, 11),
    (1, 12),
    (1, 13),
    (1, 14),
    (1, 15),
    (1, 16),
    (1, 17),
    (1, 18),
    (1, 19),
    (1, 20),
    (1, 21),
    (1, 22),
    (1, 23),
    (1, 24),
    (1, 25),
    (1, 26),
    (1, 27),
    (1, 28),
    (1, 29),
    (1, 30);

-- Insertar datos en la tabla ReglaDeCargaFuncional
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (1, 1, 8, null, '03/04/2022');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (2, 2, 1, null, '05/01/2022');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (3, 3, 8, null, '31/03/2023');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (4, 4, 1, null, '22/07/2022');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (5, 5, 1, null, '07/09/2023');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (6, 6, 8, null, '23/05/2023');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (7, 7, 7, null, '23/04/2023');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (8, 8, 8, null, '19/02/2023');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (9, 9, 8, null, '27/04/2023');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (10, 10, 7, null, '10/10/2023');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (11, 11, 8, null, '01/03/2022');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (12, 12, 8, null, '24/07/2023');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (13, 13, 8, null, '25/04/2023');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (14, 14, 7, null, '20/01/2022');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (15, 15, 8, null, '22/03/2022');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (16, 16, 8, null, '01/10/2023');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (17, 17, 8, null, '31/01/2024');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (18, 18, 8, null, '19/08/2023');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (19, 19, 8, null, '13/04/2022');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (20, 20, 7, null, '05/09/2022');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (21, 21, 8, null, '13/08/2022');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (22, 22, 8, null, '23/04/2023');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (23, 23, 1, null, '08/04/2022');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (24, 24, 7, null, '01/12/2022');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (25, 25, 8, null, '29/04/2022');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (26, 26, 8, null, '09/02/2024');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (27, 27, 8, null, '03/03/2024');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (28, 28, 7, null, '20/09/2022');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (29, 29, 8, null, '04/07/2023');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (30, 30, 8, null, '13/12/2023');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (31, 31, 7, null, '04/05/2023');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (32, 32, 8, null, '27/04/2023');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (33, 33, 8, null, '12/05/2022');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (34, 34, 1, null, '19/09/2022');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (35, 35, 7, null, '16/02/2022');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (36, 36, 8, null, '01/03/2023');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (37, 37, 8, null, '15/06/2024');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (38, 38, 8, null, '20/03/2022');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (39, 39, 8, null, '06/02/2022');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (40, 40, 7, null, '29/10/2022');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (41, 41, 8, null, '07/04/2024');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (42, 42, 8, null, '17/01/2022');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (43, 43, 8, null, '10/12/2023');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (44, 44, 7, null, '31/05/2023');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (45, 45, 7, null, '10/01/2022');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (46, 46, 8, null, '15/06/2022');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (47, 47, 7, null, '31/01/2024');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (48, 48, 8, null, '11/11/2023');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (49, 49, 7, null, '22/01/2022');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (50, 50, 8, null, '05/10/2022');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (51, 51, 7, null, '03/04/2023');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (52, 52, 8, null, '21/09/2023');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (53, 53, 8, null, '01/08/2023');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (54, 54, 7, null, '12/03/2022');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (55, 55, 8, null, '02/02/2024');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (56, 56, 7, null, '26/04/2023');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (57, 57, 8, null, '08/05/2023');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (58, 58, 8, null, '09/06/2022');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (59, 59, 8, null, '15/09/2022');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (60, 60, 8, null, '19/09/2022');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (61, 61, 8, null, '25/09/2022');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (62, 62, 7, null, '27/05/2023');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (63, 63, 8, null, '07/04/2024');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (64, 64, 7, null, '26/05/2024');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (65, 65, 8, null, '08/05/2022');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (66, 66, 8, null, '30/12/2023');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (67, 67, 7, null, '12/03/2022');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (68, 68, 8, null, '07/07/2023');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (69, 69, 8, null, '19/12/2023');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (70, 70, 8, null, '19/03/2024');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (71, 71, 8, null, '26/02/2022');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (72, 72, 8, null, '16/12/2023');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (73, 73, 1, null, '04/11/2023');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (74, 74, 7, null, '25/10/2022');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (75, 75, 8, null, '09/03/2023');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (76, 76, 8, null, '31/05/2022');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (77, 77, 8, null, '03/03/2022');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (78, 78, 8, null, '14/11/2022');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (79, 79, 7, null, '05/01/2023');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (80, 80, 8, null, '19/01/2022');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (81, 81, 1, null, '10/02/2022');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (82, 82, 1, null, '19/03/2024');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (83, 83, 7, null, '07/12/2023');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (84, 84, 8, null, '28/04/2022');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (85, 85, 8, null, '05/08/2023');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (86, 86, 7, null, '06/11/2023');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (87, 87, 8, null, '12/03/2024');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (88, 88, 8, null, '03/03/2023');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (89, 89, 7, null, '19/06/2024');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (90, 90, 7, null, '03/02/2022');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (91, 91, 8, null, '13/06/2024');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (92, 92, 8, null, '08/07/2022');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (93, 93, 8, null, '08/08/2022');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (94, 94, 8, null, '21/09/2022');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (95, 95, 7, null, '29/12/2022');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (96, 96, 8, null, '25/06/2022');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (97, 97, 7, null, '01/05/2024');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (98, 98, 7, null, '09/03/2022');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (99, 99, 8, null, '07/05/2024');
insert into "ReglaDeCargaFuncional" ("ID_ReglaCargaFunc", id_migracion, id_tecnologia, "Logica", "Fecha") values (100, 100, 7, null, '27/11/2023');

-- Insertar datos en la tabla ReglaDeCargaTecnica
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (1, 1, null, false, 'Simplify the WHERE clause for better readability', '26/08/2023');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (2, 2, null, false, 'Add comments to explain complex logic', '18/03/2022');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (3, 3, null, false, 'Add comments to explain complex logic', '30/06/2023');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (4, 4, null, true, 'Use indexes to improve query performance', '23/10/2022');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (5, 5, null, true, 'Simplify the WHERE clause for better readability', '04/01/2022');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (6, 6, null, true, 'Simplify the WHERE clause for better readability', '20/05/2023');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (7, 7, null, false, 'Add comments to explain complex logic', '02/04/2024');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (8, 8, null, true, 'Consider optimizing the JOIN operation', '08/08/2023');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (9, 9, null, false, 'Consider optimizing the JOIN operation', '25/02/2024');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (10, 10, null, true, 'Consider optimizing the JOIN operation', '30/10/2022');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (11, 11, null, false, 'Simplify the WHERE clause for better readability', '29/09/2023');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (12, 12, null, false, 'Use indexes to improve query performance', '23/06/2022');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (13, 13, null, false, 'Use indexes to improve query performance', '23/02/2024');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (14, 14, null, false, 'Consider optimizing the JOIN operation', '13/11/2023');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (15, 15, null, true, 'Consider optimizing the JOIN operation', '11/03/2022');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (16, 16, null, false, 'Use indexes to improve query performance', '08/03/2022');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (17, 17, null, true, 'Add comments to explain complex logic', '31/10/2022');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (18, 18, null, false, 'Simplify the WHERE clause for better readability', '21/06/2024');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (19, 19, null, false, 'Use indexes to improve query performance', '11/03/2024');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (20, 20, null, true, 'Simplify the WHERE clause for better readability', '14/08/2023');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (21, 21, null, false, 'Simplify the WHERE clause for better readability', '29/03/2022');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (22, 22, null, true, 'Add comments to explain complex logic', '31/03/2023');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (23, 23, null, false, 'Consider optimizing the JOIN operation', '07/04/2022');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (24, 24, null, true, 'Simplify the WHERE clause for better readability', '05/06/2023');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (25, 25, null, true, 'Add comments to explain complex logic', '12/04/2023');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (26, 26, null, false, 'Use indexes to improve query performance', '27/12/2023');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (27, 27, null, true, 'Use indexes to improve query performance', '21/05/2022');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (28, 28, null, true, 'Simplify the WHERE clause for better readability', '18/11/2022');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (29, 29, null, true, 'Consider optimizing the JOIN operation', '07/03/2024');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (30, 30, null, false, 'Simplify the WHERE clause for better readability', '26/06/2022');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (31, 31, null, false, 'Consider optimizing the JOIN operation', '20/07/2022');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (32, 32, null, false, 'Use indexes to improve query performance', '30/06/2024');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (33, 33, null, false, 'Use indexes to improve query performance', '09/09/2023');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (34, 34, null, true, 'Simplify the WHERE clause for better readability', '19/04/2024');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (35, 35, null, false, 'Add comments to explain complex logic', '21/08/2023');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (36, 36, null, false, 'Consider optimizing the JOIN operation', '04/03/2024');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (37, 37, null, true, 'Consider optimizing the JOIN operation', '28/11/2022');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (38, 38, null, false, 'Consider optimizing the JOIN operation', '05/02/2023');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (39, 39, null, false, 'Use indexes to improve query performance', '12/02/2022');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (40, 40, null, true, 'Consider optimizing the JOIN operation', '15/03/2024');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (41, 41, null, true, 'Consider optimizing the JOIN operation', '04/06/2022');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (42, 42, null, false, 'Consider optimizing the JOIN operation', '15/06/2022');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (43, 43, null, true, 'Use indexes to improve query performance', '16/06/2023');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (44, 44, null, false, 'Simplify the WHERE clause for better readability', '19/02/2024');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (45, 45, null, false, 'Consider optimizing the JOIN operation', '08/05/2024');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (46, 46, null, false, 'Add comments to explain complex logic', '17/02/2022');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (47, 47, null, true, 'Simplify the WHERE clause for better readability', '28/03/2024');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (48, 48, null, true, 'Add comments to explain complex logic', '05/03/2024');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (49, 49, null, false, 'Use indexes to improve query performance', '06/06/2023');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (50, 50, null, true, 'Use indexes to improve query performance', '24/07/2023');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (51, 51, null, false, 'Use indexes to improve query performance', '10/02/2022');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (52, 52, null, true, 'Consider optimizing the JOIN operation', '29/06/2022');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (53, 53, null, true, 'Simplify the WHERE clause for better readability', '18/09/2022');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (54, 54, null, true, 'Add comments to explain complex logic', '12/09/2022');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (55, 55, null, false, 'Simplify the WHERE clause for better readability', '26/11/2022');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (56, 56, null, false, 'Use indexes to improve query performance', '27/04/2022');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (57, 57, null, false, 'Simplify the WHERE clause for better readability', '01/11/2022');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (58, 58, null, true, 'Add comments to explain complex logic', '14/06/2022');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (59, 59, null, true, 'Use indexes to improve query performance', '08/05/2022');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (60, 60, null, false, 'Consider optimizing the JOIN operation', '14/01/2023');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (61, 61, null, true, 'Consider optimizing the JOIN operation', '07/03/2022');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (62, 62, null, true, 'Use indexes to improve query performance', '02/12/2022');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (63, 63, null, true, 'Simplify the WHERE clause for better readability', '07/12/2023');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (64, 64, null, false, 'Consider optimizing the JOIN operation', '20/04/2023');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (65, 65, null, false, 'Add comments to explain complex logic', '20/12/2023');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (66, 66, null, true, 'Use indexes to improve query performance', '01/06/2023');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (67, 67, null, true, 'Simplify the WHERE clause for better readability', '06/09/2023');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (68, 68, null, false, 'Add comments to explain complex logic', '06/11/2022');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (69, 69, null, true, 'Add comments to explain complex logic', '08/08/2022');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (70, 70, null, false, 'Consider optimizing the JOIN operation', '02/06/2024');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (71, 71, null, true, 'Consider optimizing the JOIN operation', '19/11/2022');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (72, 72, null, false, 'Consider optimizing the JOIN operation', '26/09/2023');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (73, 73, null, false, 'Use indexes to improve query performance', '30/04/2024');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (74, 74, null, true, 'Simplify the WHERE clause for better readability', '22/09/2022');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (75, 75, null, true, 'Use indexes to improve query performance', '21/12/2022');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (76, 76, null, true, 'Use indexes to improve query performance', '16/03/2024');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (77, 77, null, true, 'Add comments to explain complex logic', '03/05/2024');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (78, 78, null, false, 'Use indexes to improve query performance', '01/02/2024');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (79, 79, null, false, 'Simplify the WHERE clause for better readability', '12/10/2022');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (80, 80, null, false, 'Add comments to explain complex logic', '22/09/2022');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (81, 81, null, true, 'Consider optimizing the JOIN operation', '25/05/2024');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (82, 82, null, false, 'Use indexes to improve query performance', '30/09/2022');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (83, 83, null, true, 'Consider optimizing the JOIN operation', '06/03/2024');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (84, 84, null, true, 'Use indexes to improve query performance', '04/02/2024');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (85, 85, null, true, 'Add comments to explain complex logic', '22/10/2023');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (86, 86, null, true, 'Add comments to explain complex logic', '27/04/2024');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (87, 87, null, false, 'Use indexes to improve query performance', '20/10/2022');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (88, 88, null, false, 'Consider optimizing the JOIN operation', '25/04/2024');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (89, 89, null, true, 'Consider optimizing the JOIN operation', '22/08/2023');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (90, 90, null, true, 'Use indexes to improve query performance', '11/04/2024');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (91, 91, null, true, 'Use indexes to improve query performance', '23/10/2022');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (92, 92, null, true, 'Consider optimizing the JOIN operation', '19/03/2022');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (93, 93, null, false, 'Consider optimizing the JOIN operation', '13/05/2024');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (94, 94, null, false, 'Simplify the WHERE clause for better readability', '25/07/2023');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (95, 95, null, true, 'Add comments to explain complex logic', '23/12/2023');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (96, 96, null, false, 'Add comments to explain complex logic', '25/01/2024');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (97, 97, null, false, 'Add comments to explain complex logic', '29/09/2022');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (98, 98, null, true, 'Add comments to explain complex logic', '03/03/2022');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (99, 99, null, false, 'Simplify the WHERE clause for better readability', '25/10/2022');
insert into "ReglaDeCargaTecnica" ("ID_ReglaCargaTecn", regla_funcional, "Codigo", "Finalizado", "Comentario", "Fecha") values (100, 100, null, true, 'Simplify the WHERE clause for better readability', '05/01/2023');


-- Insertar datos en la tabla RegistroErrores
INSERT INTO public."RegistroErrores"(
    "Id_registro_errores", "Fecha_registro", "Migracion_Id", "Id_error", "Id_Empleado", "Correcion_error", "Causa_error")
VALUES
    (10001, '2024-04-06', 1, 1, NULL, 'El campo DDV debe ser DESPROVINCIA', 'Campo DDV no debe ser Fedcide'),
    (10002, '2024-04-07', 1, 2, NULL, 'se escribe bash', 'Puso bach'),
    (10003, '2024-04-05', 1, 3, NULL, 'Formato de números debe estar sin decimales', 'El formato está con decimales'),
    (10004, '2024-04-04', 1, 4, NULL, 'El tamaño de campo debe estar máximo 50 caracteres', 'El campo estaba con tamaño de 100 caracteres'),
    (10005, '2024-04-04', 1, 2, NULL, 'se escribe jock', 'Escribió josk'),
    (10006, '2024-04-03', 1, 1, NULL, 'El campo DDV debe ser DESNUMERO', 'Campo DDV no debe ser nomet'),
    (10007, '2024-03-30', 1, 5, NULL, 'La equivalencia de clave es claveparty', 'La equivalencia de clave estaba como clavepart'),
    (10008, '2024-03-28', 1, 3, NULL, 'El formato fecha debe estar DD/MM/AAAA', 'El formato estaba AAAA/MM/DD'),
    (10009, '2023-01-20', 1, 1, NULL, 'El campo DDV debe ser PRESTAMO', 'Campo DDV no debe ser Noprestamo'),
    (10010, '2023-01-25', 1, 5, NULL, 'La equivalencia de dni es dniyok', 'La equivalencia de dni estaba como dnikol');


-- Insertar datos en la tabla Programacion
INSERT INTO public."Programacion"(
    "Programacion_Id", "Migracion_Id", "FrecuenciaEjecucion", "DiaInicio", "DiaFin", "ConsideracionFrecuencia")
VALUES
    (10001, 1, 'Diario', 'lunes', 'domingo', 'feriado'),
    (10002, 1, 'Semanal', 'Domingo', 'domingo', 'Noferiado'),
    (10003, 1, 'Quincenal', 'Martes', 'Lunes', 'feriado'),
    (10004, 1, 'Mensual', 'Miercoles', 'Martes', 'Noferiado'),
    (10005, 1, 'Trimestral', 'Domingo', 'domingo', 'feriado'),
    (10006, 1, 'Semestral', 'lunes', 'domingo', 'feriado'),
    (10007, 1, 'Semanal', 'Jueves', 'domingo', 'feriado'),
    (10008, 1, 'Quincenal', 'lunes', 'Martes', 'Diario'),
    (10009, 1, 'Mensual', 'Viernes', 'Sabado', 'feriado'),
    (10010, 1, 'Diario', 'lunes', 'domingo', 'feriado');

-- Insertando datos en la tabla Tipo_Reunion

INSERT INTO public."Tipo_Reunion"("TipoReunion_Id", "Nombre", "Descripcion") VALUES
    (1, 'Entrada', 'Reunión inicial para discutir los detalles del pedido de migración.'),
    (2, 'Salida', 'Reunión final para verificar la migración y obtener la aprobación del usuario.');
	
-- Insertando datos en la tabla Tipo_Recordatorio

INSERT INTO public."Tipo_Recordatorio" ("TipoRecordatorio_Id", "Nombre", "Descripcion", "Mensaje") VALUES
(1, 'Cancelación de Reunión', 'Notificación de cancelación de una reunión', 'La reunión programada ha sido cancelada.'),
(2, 'Modificación de Reunión', 'Notificación de cambios en una reunión', 'Se han realizado cambios en la reunión programada. Por favor, revíselos.'),
(3, 'Inicio de Reunión', 'Recordatorio de inicio de la reunión', 'La reunión está a punto de comenzar. Por favor, únase a tiempo.'),
(4, 'Finalización de Reunión', 'Notificación de finalización de la reunión', 'La reunión ha finalizado. Gracias por su participación.'),
(5, 'Programación de Reunión', 'Notificación de programación de una nueva reunión', 'Se ha programado una nueva reunión. Por favor, revísela.'),
(6, 'Disponibilidad de Reporte de Conformidad', 'Notificación de disponibilidad del reporte de conformidad asociado a una reunión completada.', 'El reporte de conformidad correspondiente a la reunión ha sido generado. Por favor, revíselos.');

-- Insertando datos en la tabla Reunion
INSERT INTO public."Reunion" ("Reunion_Id", "Id_Empleado", "Pedido_Id", "TipoReunion_Id", "HoraInicio", "HoraFin", "Plataforma", "Fecha", "Estado", "Agenda", "Acuerdos", "HoraProgramacion", "FechaProgramacion") VALUES 
(1, 7, 1, 1, '09:00:00-05:00', '11:00:00-05:00', 'Slack', '2022-01-06', 'completada', 'Revisión del diccionario de datos. Validación de unicidad y nulidad de campos. Identificación de datos sensibles.', '1. Validar unicidad y nulidad de "ID_Cliente". 2. Identificar datos sensibles como "DNI, Dirección".', '21:00:00-05:00', '2022-01-05'), 
(2, 7, 1, 2, '10:00:00-05:00', '15:00:00-05:00', 'Slack', '2022-02-14', 'completada', 'Ratificación de datos entre origen y destino. Presentación del diccionario de datos y script.', '1. Ratificar datos sin discrepancias. 2. Entregar diccionario de datos y script.', '09:00:00-05:00', '2022-02-13'),

(3, 7, 2, 1, '08:00:00-05:00', '09:00:00-05:00', 'Zoom', '2024-02-11', 'completada', 'Reunirse con el usuario origen para brindar información detallada sobre el diccionario de datos.', '1. Brindar información detallada sobre el diccionario de datos.', '09:00:00-05:00', '2024-02-10'),
(4, 7, 2, 1, '08:00:00-05:00', '10:00:00-05:00', 'Zoom', '2024-02-12', 'completada', 'Validar la unicidad y nulidad de los campos llave.', '1. Validar la unicidad y nulidad de los campos llave.', '22:00:00-05:00', '2024-02-11'),
(5, 7, 2, 2, '08:00:00-05:00', '10:30:00-05:00', 'Zoom', '2022-03-20', 'completada', 'Hacer ratificación (origen vs destino) de información entre la tabla de salida con la tabla que se está dejando en el repositorio.', '1. Ratificar información entre las tablas.', '15:00:00-05:00', '2022-03-18'),

(6, 7, 3, 1, '11:00:00-05:00', '11:40:00-05:00', 'Slack', '2022-03-15', 'completada', 'Reunirse con el usuario origen para obtener información detallada del diccionario de datos.', '1. Obtener diccionario de datos.', '18:00:00-05:00', '2022-03-14'),
(7, 7, 3, 1, '09:00:00-05:00', '09:50:00-05:00', 'Slack', '2022-03-16', 'completada', 'Validar la unicidad y nulidad de los campos llave con el usuario origen.', '1. Validar unicidad y nulidad de campos llave.', '12:00:00-05:00', '2022-03-15'),
(8, 7, 3, 1, '09:00:00-05:00', '10:00:00-05:00', 'Slack', '2022-03-17', 'completada', 'Identificar y socializar los campos DAC con el equipo de Data Engineering.', '1. Identificar campos DAC. 2. Socializar con Data Engineering.', '16:00:00-05:00', '2022-03-16'),

(9, 7, 3, 2, '14:00:00-05:00', '14:40:00-05:00', 'Slack', '2022-04-23', 'completada', 'Ratificar información entre la tabla de salida y la tabla en el repositorio.', '1. Ratificar información. 2. Revisar tabla en el repositorio.', '09:00:00-05:00', '2022-04-23'),
(10, 7, 3, 2, '09:00:00-05:00', '09:50:00-05:00', 'Zoom', '2022-04-24', 'completada', 'Reunirse con el usuario destino para brindar información detallada del diccionario de datos.', '1. Brindar información detallada del diccionario de datos.', '15:00:00-05:00', '2022-04-23'),
(11, 7, 3, 2, '15:00:00-05:00', '16:00:00-05:00', 'Zoom', '2022-04-24', 'completada', 'Enviar correo de conformidad al usuario destino.', '1. Enviar correo de conformidad.', '10:00:00-05:00', '2022-04-24'),

(12, 7, 11, 1, '09:00:00-05:00', '12:30:00-05:00', 'Slack', '2022-04-20', 'completada', 'Reunirse con el usuario origen para brindar información detallada del diccionario de datos.', '1. Brindar información detallada del diccionario de datos.', '22:00:00-05:00', '2022-04-19'),
(13, 7, 11, 2, '10:00:00-05:00', '14:10:00-05:00', 'Slack', '2022-05-29', 'completada', 'Ratificar información entre la tabla de salida y la tabla en el repositorio.', '1. Ratificar información. 2. Revisar tabla en el repositorio.', '19:00:00-05:00', '2024-06-28'),

(14, 7, 25, 1, '14:00:00-05:00', '17:15:00-05:00', 'Zoom', '2022-05-26', 'completada', 'Reunirse con el usuario origen para brindar información detallada del diccionario de datos.', '1. Brindar información detallada del diccionario de datos.', '15:00:00-05:00', '2022-05-25'), 
(15, 7, 25, 2, '14:30:00-05:00', '15:30:00-05:00', 'Zoom', '2022-06-03', 'completada', 'Ratificar información entre la tabla de salida y la tabla en el repositorio.', '1. Ratificar información entre las tablas. 2. Revisar consistencia de datos.', '18:00:00-05:00', '2022-06-02'),
(16, 7, 25, 2, '15:00:00-05:00', '17:00:00-05:00', 'Zoom', '2022-06-04', 'completada', 'Reunirse con el usuario destino para brindar información detallada del diccionario de datos e información técnica.', '1. Brindar información detallada del diccionario de datos. 2. Brindar información técnica (script, Jobs, etc).', '21:00:00-05:00', '2022-06-03'),

(17, 7, 26, 1, '09:00:00-05:00', '12:00:00-05:00', 'Slack', '2022-07-01', 'completada', 'Reunirse con el usuario origen para que brinde información detallada sobre el diccionario de datos.', '1. Brindar información detallada sobre el diccionario de datos. 2. Validar la unicidad y nulidad de los campos llave. 3. Identificar campos DAC (datos sensibles del cliente). 4. Socializarlo con el data engineer para crear la tabla en una capa de data lake cloud.', '15:00:00-05:00', '2022-06-30'),
(18, 7, 26, 2, '08:00:00-05:00', '10:00:00-05:00', 'Slack', '2022-08-10', 'completada', 'Hacer ratificación (origen vs destino) de información entre la tabla de salida con la tabla que se está dejando en el repositorio.', '1. Ratificar información entre las tablas. 2. Reunirse con el usuario destino para brindarle información detallada del diccionario de datos e información técnica (script, Jobs, etc).', '16:00:00-05:00', '2022-08-09'),

(19, 7, 27, 1, '11:30:00-05:00', '13:00:00-05:00', 'Zoom', '2022-08-06', 'completada', 'Reunirse con el usuario origen para brindar información detallada sobre el diccionario de datos.', '1. Brindar información detallada sobre el diccionario de datos.', '19:00:00-05:00', '2022-08-05'),
(20, 7, 27, 2, '14:00:00-05:00', '16:00:00-05:00', 'Zoom', '2022-09-15', 'completada', 'Hacer ratificación (origen vs destino) de información entre la tabla de salida con la tabla que se está dejando en el repositorio.', '1. Ratificar información entre las tablas.', '18:00:00-05:00', '2022-09-14'),

(21, 7, 38, 1, '09:00:00-05:00', '11:00:00-05:00', 'Zoom', '2022-09-11', 'completada', 'AGENDA 381', 'ACUERDOS 381', '11:00:00-05:00', '2022-09-10'),
(22, 7, 38, 2, '10:00:00-05:00', '13:00:00-05:00', 'Zoom', '2022-10-19', 'completada', 'AGENDA 382', 'ACUERDOS 382', '21:46:00-05:00', '2022-10-18'),

(23, 7, 22, 1, '08:00:00-05:00', '09:30:00-05:00', 'Zoom', '2022-10-16', 'completada', 'Reunirse con el usuario origen para brindar información detallada sobre el diccionario de datos.', 'Brindar información detallada sobre el diccionario de datos.', '17:00:00-05:00', '2022-10-15'),
(24, 7, 22, 1, '10:00:00-05:00', '11:00:00-05:00', 'Zoom', '2022-10-17', 'completada', 'Validar la unicidad y nulidad de los campos llave.', 'Validar campos llave.', '15:00:00-05:00', '2022-10-16'), 
(25, 7, 22, 2, '09:00:00-05:00', '10:00:00-05:00', 'Slack', '2022-11-24', 'completada', 'Hacer ratificación (origen vs destino) de información entre la tabla de salida con la tabla que se está dejando en el repositorio.', 'Ratificar información entre las tablas.', '22:00:00-05:00', '2022-11-23'),
(26, 7, 22, 2, '14:00:00-05:00', '15:00:00-05:00', 'Slack', '2022-11-25', 'completada', 'Socializar con el data engineer para crear la tabla en una capa de data lake cloud.', 'Crear tabla en data lake cloud.', '14:00:00-05:00', '2022-11-24'),

(27, 7, 56, 1, '09:00:00-05:00', '11:00:00-05:00', 'Zoom', '2023-03-16', 'completada', 'Reunirse con el usuario origen para brindar información detallada sobre el diccionario de datos.', 'Brindar información detallada sobre el diccionario de datos.', '23:00:00-05:00', '2023-03-15'),
(28, 7, 56, 2, '09:00:00-05:00', '11:00:00-05:00', 'Slack', '2023-04-24', 'completada', 'Hacer ratificación (origen vs destino) de información entre la tabla de salida con la tabla que se está dejando en el repositorio.', 'Ratificar información entre las tablas.', '15:00:00-05:00', '2023-04-23'),

(29, 7, 46, 1, '13:00:00-05:00', '15:00:00-05:00', 'Zoom', '2023-07-01', 'completada', 'Reunirse con el usuario origen para brindar información detallada sobre el diccionario de datos.', 'Brindar información detallada sobre el diccionario de datos.', '09:00:00-05:00', '2023-06-30'),
(30, 7, 46, 2, '09:00:00-05:00', '11:15:00-05:00', 'Zoom', '2023-08-10', 'completada', 'Hacer ratificación (origen vs destino) de información entre la tabla de salida con la tabla que se está dejando en el repositorio.', 'Ratificar información entre las tablas.', '21:00:00-05:00', '2023-08-09'),

(31, 7, 68, 1, '09:00:00-05:00', '10:00:00-05:00', 'Zoom', '2023-09-11', 'completada', 'Validación Inicial de Datos', 'Revisión de la integridad y consistencia de los datos a migrar.', '20:00:00-05:00', '2023-09-10'),
(32, 7, 68, 2, '11:00:00-05:00', '13:00:00-05:00', 'Zoom', '2023-10-20', 'completada', 'Ratificación de Datos Migrados', 'Confirmación y revisión final de los datos migrados.', '22:00:00-05:00', '2023-10-19'),

(33, 7, 50, 1, '09:00:00-05:00', '11:00:00-05:00', 'Slack', '2023-11-21', 'completada', 'Validación de Datos Iniciales', 'Revisión de la calidad y estructura de los datos iniciales.', '09:00:00-05:00', '2023-11-20'),
(34, 7, 50, 2, '08:00:00-05:00', '10:00:00-05:00', 'Slack', '2023-12-30', 'completada', 'Ratificación de Datos Migrados', 'Confirmación final de los datos migrados y cierre del proceso.', '20:46:00-05:00', '2023-12-29'),

(35, 7, 73, 1, '09:00:00-05:00', '09:40:00-05:00', 'Zoom', '2024-02-11', 'completada', 'Reunirse con el usuario origen para que brinde información detallada sobre el diccionario de datos.', '1. Obtener información detallada sobre el diccionario de datos.', '21:30:00-05:00', '2024-02-10'),
(36, 7, 73, 1, '11:00:00-05:00', '12:00:00-05:00', 'Zoom', '2024-02-12', 'completada', 'Validar la unicidad y nulidad de los campos llave con el usuario origen.', '1. Validar unicidad y nulidad de campos llave.', '11:00:00-05:00', '2024-02-11'),
(37, 7, 73, 2, '12:00:00-05:00', '13:00:00-05:00', 'Zoom', '2024-03-19', 'completada', 'Hacer ratificación de información entre la tabla de salida con la tabla que se está dejando en el repositorio.', '1. Ratificar información entre tablas.', '22:00:00-05:00', '2024-03-18'),
(38, 7, 73, 2, '11:00:00-05:00', '12:00:00-05:00', 'Slack', '2024-03-20', 'completada', 'Reunirse con el usuario destino para brindarle información detallada del diccionario de datos e información técnica.', '1. Brindar información detallada del diccionario de datos e información técnica.', '15:00:00-05:00', '2024-03-19'),
 
(39, 7, 78, 1, '09:00:00-05:00', '11:00:00-05:00', 'Slack', '2024-04-21', 'completada', 'Reunirse con el usuario origen para brindar información detallada del diccionario de datos.', '1. Brindar información detallada del diccionario de datos.', '22:00:00-05:00', '2024-04-20'),
(40, 7, 78, 2, '11:00:00-05:00', '13:00:00-05:00', 'Slack', '2023-11-21', 'completada', 'Hacer ratificación de información entre la tabla de salida con la tabla que se está dejando en el repositorio.', '1. Ratificar información entre tablas.', '15:00:00-05:00', '2023-11-20'),

(41, 7, 86, 1, '08:00:00-05:00', '10:00:00-05:00', 'Zoom', '2024-05-26', 'completada', 'Reunirse con el usuario origen para brindar información detallada del diccionario de datos.', '1. Brindar información detallada del diccionario de datos.', '18:00:00-05:00', '2024-05-25'), 
(42, 7, 86, 2, '10:00:00-05:00', '11:30:00-05:00', 'Zoom', '2024-06-05', 'completada', 'Hacer ratificación de información entre la tabla de salida con la tabla que se está dejando en el repositorio.', '1. Ratificar información entre tablas.', '15:00:00-05:00', '2024-06-04'),

(43, 7, 96, 1, '10:00:00-05:00', '11:30:00-05:00', 'Zoom', '2024-06-30', 'pendiente', 'Revisión de datos antes de la migración', '', '01:39:14.791653-05:00', '2024-06-05'),
 
(44, 7, 88, 1, '08:00:00-05:00', '10:00:00-05:00', 'Zoom', '2024-08-05', 'pendiente', 'Revisión y validación de los datos a migrar', '', '01:42:40.864687-05:00', '2024-06-05'),

(45, 7, 89, 1, '09:00:00-05:00', '11:00:00-05:00', 'Zoom', '2024-09-10', 'pendiente', 'Revisión y validación de los datos a migrar', '', '01:43:56.881663-05:00', '2024-06-05'),

(46, 7, 99, 1, '08:00:00-05:00', '10:00:00-05:00', 'Zoom', '2024-10-15', 'pendiente', 'Revisión y validación de datos previa a la migración', '', '01:45:34.120313-05:00', '2024-06-05'),

(47, 7, 91, 1, '09:00:00-05:00', '10:30:00-05:00', 'Zoom', '2024-11-20', 'pendiente', 'Revisión de requerimientos de datos', '', '01:46:55.080301-05:00', '2024-06-05'),

(48, 7, 71, 1, '09:00:00-05:00', '09:40:00-05:00', 'Zoom', '2024-01-06', 'completada', 'Revisión de datos previa a la migración', '', '21:30:00-05:00', '2024-01-05');

-- Insertando datos en la tabla Participante
INSERT INTO public."Participante"("Participante_Id", "Area_Id", "Nombre", "Apellido", "Correo")VALUES 
(1, 1, 'Carlos', 'Sanchez', 'carloss@bcp.pe'),
(2, 1, 'Lucia', 'Hernandez', 'luciah@bcp.pe'),
(3, 1, 'Diego', 'Mendoza', 'diegom@bcp.pe'),
(4, 2, 'Marta', 'Gomez', 'martag@bcp.pe'),
(5, 2, 'Ricardo', 'Diaz', 'ricardod@bcp.pe'),
(6, 2, 'Sofia', 'Torres', 'sofiat@bcp.pe'),
(7, 3, 'Luis', 'Gutierrez', 'luisg@bcp.pe'),
(8, 3, 'Elena', 'Perez', 'elenap@bcp.pe'),
(9, 3, 'Mario', 'Lopez', 'mariol@bcp.pe'),
(10, 1, 'Ana', 'Martinez', 'anam@bcp.pe'),
(11, 1, 'Jorge', 'Ramirez', 'jorger@bcp.pe'),
(12, 2, 'Camila', 'Fernandez', 'camilaf@bcp.pe'),
(13, 2, 'David', 'Morales', 'davidm@bcp.pe'),
(14, 3, 'Paula', 'Castro', 'paulac@bcp.pe'),
(15, 3, 'Andres', 'Vargas', 'andresv@bcp.pe'),
(16, 4, 'Rosa', 'Silva', 'rosas@bcp.pe'),
(17, 4, 'Miguel', 'Ortega', 'miguelo@bcp.pe'),
(18, 5, 'Laura', 'Navarro', 'lauran@bcp.pe'),
(19, 5, 'Jose', 'Rojas', 'joser@bcp.pe'),
(20, 6, 'Patricia', 'Iglesias', 'patriciai@bcp.pe'),
(21, 6, 'Fernando', 'Garcia', 'fernandog@bcp.pe'),
(22, 7, 'Valeria', 'Soto', 'valerias@bcp.pe'),
(23, 7, 'Antonio', 'Mejia', 'antoniom@bcp.pe'),
(24, 8, 'Isabel', 'Espinoza', 'isabele@bcp.pe'),
(25, 8, 'Juan', 'Palacios', 'juanp@bcp.pe'),
(26, 9, 'Mariana', 'Vega', 'marianav@bcp.pe'),
(27, 9, 'Hector', 'Nieto', 'hectorn@bcp.pe'),
(28, 10, 'Luciana', 'Cabrera', 'lucianac@bcp.pe'),
(29, 10, 'Francisco', 'Herrera', 'franciscoh@bcp.pe'),
(30, 11, 'Teresa', 'Molina', 'teresam@bcp.pe'),
(31, 11, 'Alberto', 'Munoz', 'albertom@bcp.pe'),
(32, 12, 'Julia', 'Rivera', 'juliar@bcp.pe'),
(33, 12, 'Gabriel', 'Fuentes', 'gabrielf@bcp.pe'),
(34, 13, 'Natalia', 'Ramos', 'nataliaR@bcp.pe'),
(35, 13, 'Sebastian', 'Leon', 'sebastianl@bcp.pe'),
(36, 14, 'Adriana', 'Cortez', 'adrianac@bcp.pe'),
(37, 14, 'Victor', 'Carrillo', 'victorc@bcp.pe'),
(38, 15, 'Flor', 'Salazar', 'flors@bcp.pe'),
(39, 15, 'Gustavo', 'Cruz', 'gustavoc@bcp.pe'),
(40, 16, 'Lorena', 'Flores', 'lorenaf@bcp.pe'),
(41, 16, 'Raul', 'Reyes', 'raulr@bcp.pe'),
(42, 17, 'Emma', 'Castillo', 'emmac@bcp.pe'),
(43, 17, 'Carlos', 'Valdez', 'carlosv@bcp.pe'),
(44, 18, 'Sara', 'Campos', 'sarac@bcp.pe'),
(45, 18, 'Eduardo', 'Lozano', 'eduardol@bcp.pe'),
(46, 19, 'Andrea', 'Gil', 'andreag@bcp.pe'),
(47, 19, 'Manuel', 'Ibanez', 'manueli@bcp.pe'),
(48, 20, 'Claudia', 'Paredes', 'claudiap@bcp.pe'),
(49, 20, 'Felipe', 'Herrera', 'felipeh@bcp.pe');

-- Insertando datos en la tabla Participa_en
INSERT INTO public."Participa_en"("Id_Participa_en", "Reunion_Id", "Participante_Id") VALUES 
(1, 1, 2),
(2, 1, 3),
(3, 2, 1),
(4, 2, 10),
(5, 3, 4),
(6, 3, 13),
(7, 4, 4),
(8, 4, 12),
(9, 5, 5),
(10, 5, 6),
(11, 6, 9),
(12, 6, 14),
(13, 6, 15),
(14, 7, 7),
(15, 7, 8),
(16, 7, 15),
(17, 8, 9),
(18, 8, 14),
(19, 8, 15),
(20, 9, 8),
(21, 9, 14),
(22, 9, 15),
(23, 10, 8),
(24, 10, 14),
(25, 10, 9),
(26, 11, 7),
(27, 11, 9),
(28, 11, 15),
(29, 12, 3),
(30, 12, 10),
(31, 12, 11),
(32, 13, 1),
(33, 13, 3),
(34, 13, 2),
(35, 14, 4),
(36, 14, 6),
(37, 14, 12),
(38, 15, 5),
(39, 15, 12),
(40, 16, 6),
(41, 16, 12),
(42, 16, 13),
(43, 17, 7),
(44, 17, 8),
(45, 17, 14),
(46, 18, 9),
(47, 18, 15),
(48, 18, 14),
(49, 19, 1),
(50, 19, 3),
(51, 19, 10),
(52, 19, 11),
(53, 20, 1),
(54, 20, 2),
(55, 20, 11),
(56, 21, 6),
(57, 21, 12),
(58, 21, 13),
(59, 22, 4),
(60, 22, 12),
(61, 22, 5),
(62, 23, 7),
(63, 23, 14),
(64, 24, 7),
(65, 24, 9),
(66, 25, 8),
(67, 25, 15),
(68, 26, 7),
(69, 26, 9),
(70, 27, 7),
(71, 27, 8),
(72, 27, 14),
(73, 28, 9),
(74, 28, 15),
(75, 28, 14),
(76, 29, 1),
(77, 29, 11),
(78, 29, 3),
(79, 30, 1),
(80, 30, 11),
(81, 30, 10),
(82, 31, 8),
(83, 31, 9),
(84, 32, 14),
(85, 32, 9),
(86, 34, 6),
(87, 34, 13),
(88, 34, 12),
(89, 35, 10),
(90, 35, 3),
(91, 35, 11),
(92, 36, 2),
(93, 36, 3),
(94, 37, 1),
(95, 37, 3),
(96, 38, 3),
(97, 38, 10),
(98, 40, 7),
(99, 40, 9),
(100, 40, 15),
(101, 41, 10),
(102, 41, 11),
(103, 41, 2),
(104, 42, 10),
(105, 42, 1),
(106, 42, 2),
(107, 43, 5),
(108, 43, 12),
(109, 43, 13),
(110, 44, 14),
(111, 44, 15),
(112, 45, 11),
(113, 45, 10),
(114, 46, 4),
(115, 46, 12),
(116, 46, 13),
(117, 47, 9),
(118, 47, 15),
(119, 47, 14),
(123, 48, 7),
(124, 48, 9);

-- Insertando datos en la tabla Recordatorio
INSERT INTO public."Recordatorio"("Recordatorio_Id", "Reunion_Id", "TipoRecordatorio_Id", "Hora", "Fecha")VALUES
(1, 1, 5, '21:00:00-05:00', '2022-01-05'),
(3, 1, 4, '11:00:00-05:00', '2022-01-06'),
(4, 1, 6, '11:00:00-05:00', '2022-01-06'),
(5, 2, 5, '09:00:00-05:00', '2022-02-13'),
(7, 2, 4, '15:00:00-05:00', '2022-02-14'),
(8, 2, 6, '15:00:00-05:00', '2022-02-14'),
(9, 3, 5, '09:00:00-05:00', '2024-02-10'),
(11, 3, 4, '09:00:00-05:00', '2024-02-11'),
(12, 3, 6, '09:00:00-05:00', '2024-02-11'),
(13, 4, 5, '22:00:00-05:00', '2024-02-11'),
(15, 4, 4, '10:00:00-05:00', '2024-02-12'),
(16, 4, 6, '10:00:00-05:00', '2024-02-12'),
(17, 5, 5, '15:00:00-05:00', '2022-03-18'),
(19, 5, 4, '10:30:00-05:00', '2022-03-20'),
(20, 5, 6, '10:30:00-05:00', '2022-03-20'),
(21, 6, 5, '18:00:00-05:00', '2022-03-14'),
(23, 6, 4, '11:40:00-05:00', '2022-03-15'),
(24, 6, 6, '11:40:00-05:00', '2022-03-15'),
(25, 7, 5, '12:00:00-05:00', '2022-03-15'),
(27, 7, 4, '09:50:00-05:00', '2022-03-16'),
(28, 7, 6, '09:50:00-05:00', '2022-03-16'),
(29, 8, 5, '16:00:00-05:00', '2022-03-16'),
(31, 8, 4, '10:00:00-05:00', '2022-03-17'),
(32, 8, 6, '10:00:00-05:00', '2022-03-17'),
(33, 9, 5, '09:00:00-05:00', '2022-04-23'),
(35, 9, 4, '14:40:00-05:00', '2022-04-23'),
(36, 9, 6, '14:40:00-05:00', '2022-04-23'),
(37, 10, 5, '15:00:00-05:00', '2022-04-23'),
(39, 10, 4, '09:50:00-05:00', '2022-04-24'),
(40, 10, 6, '09:50:00-05:00', '2022-04-24'),
(41, 11, 5, '10:00:00-05:00', '2022-04-24'),
(43, 11, 4, '16:00:00-05:00', '2022-04-24'),
(44, 11, 6, '16:00:00-05:00', '2022-04-24'),
(45, 12, 5, '22:00:00-05:00', '2022-04-19'),
(47, 12, 4, '12:30:00-05:00', '2022-04-20'),
(48, 12, 6, '12:30:00-05:00', '2022-04-20'),
(49, 13, 5, '19:00:00-05:00', '2024-06-28'),
(51, 13, 4, '14:10:00-05:00', '2022-05-29'),
(52, 13, 6, '14:10:00-05:00', '2022-05-29'),
(53, 14, 5, '15:00:00-05:00', '2022-05-25'),
(55, 14, 4, '17:15:00-05:00', '2022-05-26'),
(56, 14, 6, '17:15:00-05:00', '2022-05-26'),
(57, 15, 5, '18:00:00-05:00', '2022-06-02'),
(59, 15, 4, '15:30:00-05:00', '2022-06-03'),
(60, 15, 6, '15:30:00-05:00', '2022-06-03'),
(61, 16, 5, '21:00:00-05:00', '2022-06-03'),
(63, 16, 4, '17:00:00-05:00', '2022-06-04'),
(64, 16, 6, '17:00:00-05:00', '2022-06-04'),
(65, 17, 5, '15:00:00-05:00', '2022-06-30'),
(67, 17, 4, '12:00:00-05:00', '2022-07-01'),
(68, 17, 6, '12:00:00-05:00', '2022-07-01'),
(69, 18, 5, '16:00:00-05:00', '2022-08-09'),
(71, 18, 4, '10:00:00-05:00', '2022-08-10'),
(72,18, 6, '10:00:00-05:00', '2022-08-10'),
(73, 19, 5, '19:00:00-05:00', '2022-08-05'),
(75, 19, 4, '13:00:00-05:00', '2022-08-06'),
(76, 19, 6, '13:00:00-05:00', '2022-08-06'),
(77, 20, 5, '18:00:00-05:00', '2022-09-14'),
(79, 20, 4, '16:00:00-05:00', '2022-09-15'),
(80, 20, 6, '16:00:00-05:00', '2022-09-15'),
(81, 21, 5, '11:00:00-05:00', '2022-09-10'),
(83, 21, 4, '11:00:00-05:00', '2022-09-11'),
(84, 21, 6, '11:00:00-05:00', '2022-09-11'),
(85, 22, 5, '21:46:00-05:00', '2022-10-18'),
(87, 22, 4, '13:00:00-05:00', '2022-10-19'),
(88, 22, 6, '13:00:00-05:00', '2022-10-19'),
(89, 23, 5, '17:00:00-05:00', '2022-10-15'),
(91, 23, 4, '09:30:00-05:00', '2022-10-16'),
(92, 23, 6, '09:30:00-05:00', '2022-10-16'),
(93, 24, 5, '15:00:00-05:00', '2022-10-16'),
(95, 24, 4, '11:00:00-05:00', '2022-10-17'),
(96, 24, 6, '11:00:00-05:00', '2022-10-17'),
(97, 25, 5, '22:00:00-05:00', '2022-11-23'),
(99, 25, 4, '10:00:00-05:00', '2022-11-24'),
(100, 25, 6, '10:00:00-05:00', '2022-11-24'),
(101, 26, 5, '14:00:00-05:00', '2022-11-24'),
(103, 26, 4, '15:00:00-05:00', '2022-11-25'),
(104, 26, 6, '15:00:00-05:00', '2022-11-25'),
(105, 27, 5, '23:00:00-05:00', '2023-03-15'),
(107, 27, 4, '11:00:00-05:00', '2023-03-16'),
(108, 27, 6, '11:00:00-05:00', '2023-03-16'),
(109, 28, 5, '15:00:00-05:00', '2023-04-23'),
(111, 28, 4, '11:00:00-05:00', '2023-04-24'),
(112, 28, 6, '11:00:00-05:00', '2023-04-24'),
(113, 29, 5, '09:00:00-05:00', '2023-06-30'),
(115, 29, 4, '15:00:00-05:00', '2023-07-01'),
(116, 29, 6, '15:00:00-05:00', '2023-07-01'),
(117, 30, 5, '21:00:00-05:00', '2023-08-09'),
(119, 30, 4, '11:15:00-05:00', '2023-08-10'),
(120, 30, 6, '11:15:00-05:00', '2023-08-10'),
(121, 31, 5, '20:00:00-05:00', '2023-09-10'),
(123, 31, 4, '10:00:00-05:00', '2023-09-11'),
(124, 31, 6, '10:00:00-05:00', '2023-09-11'),
(125, 32, 5, '22:00:00-05:00', '2023-10-19'),
(127, 32, 4, '13:00:00-05:00', '2023-10-20'),
(128, 32, 6, '13:00:00-05:00', '2023-10-20'),
(129, 33, 5, '09:00:00-05:00', '2023-11-20'),
(131, 33, 4, '11:00:00-05:00', '2023-11-21'),
(132, 33, 6, '11:00:00-05:00', '2023-11-21'),
(133, 34, 5, '20:46:00-05:00', '2023-12-29'),
(135, 34, 4, '10:00:00-05:00', '2023-12-30'),
(6, 2, 3, '10:00:00-05:00', '2022-02-14'),
(14, 4, 3, '08:00:00-05:00', '2024-02-12'),
(18, 5, 3, '08:00:00-05:00', '2022-03-20'),
(22, 6, 3, '11:00:00-05:00', '2022-03-15'),
(26, 7, 3, '09:00:00-05:00', '2022-03-16'),
(30, 8, 3, '09:00:00-05:00', '2022-03-17'),
(34, 9, 3, '14:00:00-05:00', '2022-04-23'),
(38, 10, 3, '09:00:00-05:00', '2022-04-24'),
(42, 11, 3, '15:00:00-05:00', '2022-04-24'),
(46, 12, 3, '09:00:00-05:00', '2022-04-20'),
(50, 13, 3, '10:00:00-05:00', '2022-05-29'),
(54, 14, 3, '14:00:00-05:00', '2022-05-26'),
(58, 15, 3, '14:30:00-05:00', '2022-06-03'),
(62, 16, 3, '15:00:00-05:00', '2022-06-04'),
(66, 17, 3, '09:00:00-05:00', '2022-07-01'),
(74, 19, 3, '11:30:00-05:00', '2022-08-06'),
(78, 20, 3, '14:00:00-05:00', '2022-09-15'),
(82, 21, 3, '09:00:00-05:00', '2022-09-11'),
(86, 22, 3, '10:00:00-05:00', '2022-10-19'),
(90, 23, 3, '08:00:00-05:00', '2022-10-16'),
(94, 24, 3, '10:00:00-05:00', '2022-10-17'),
(98, 25, 3, '09:00:00-05:00', '2022-11-24'),
(102, 26, 3, '14:00:00-05:00', '2022-11-25'),
(106, 27, 3, '09:00:00-05:00', '2023-03-16'),
(110, 28, 3, '09:00:00-05:00', '2023-04-24'),
(114, 29, 3, '13:00:00-05:00', '2023-07-01'),
(118, 30, 3, '09:00:00-05:00', '2023-08-10'),
(122, 31, 3, '09:00:00-05:00', '2023-09-11'),
(126, 32, 3, '11:00:00-05:00', '2023-10-20'),
(134, 34, 3, '08:00:00-05:00', '2023-12-30'),
(136, 34, 6, '10:00:00-05:00', '2023-12-30'),
(137, 35, 5, '21:30:00-05:00', '2024-02-10'),
(139, 35, 4, '09:40:00-05:00', '2024-02-11'),
(140, 35, 6, '09:40:00-05:00', '2024-02-11'),
(141, 36, 5, '11:00:00-05:00', '2024-02-11'),
(143, 36, 4, '12:00:00-05:00', '2024-02-12'),
(144, 36, 6, '12:00:00-05:00', '2024-02-12'),
(145, 37, 5, '22:00:00-05:00', '2024-03-18'),
(147, 37, 4, '13:00:00-05:00', '2024-03-19'),
(148, 37, 6, '13:00:00-05:00', '2024-03-19'),
(149, 38, 5, '15:00:00-05:00', '2024-03-19'),
(151, 38, 4, '12:00:00-05:00', '2024-03-20'),
(152, 38, 6, '12:00:00-05:00', '2024-03-20'),
(153, 39, 5, '22:00:00-05:00', '2024-04-20'),
(155, 39, 4, '11:00:00-05:00', '2024-04-21'),
(156, 39, 6, '11:00:00-05:00', '2024-04-21'),
(157, 40, 5, '15:00:00-05:00', '2023-11-20'),
(159, 40, 4, '13:00:00-05:00', '2023-11-21'),
(160, 40, 6, '13:00:00-05:00', '2023-11-21'),
(161, 41, 5, '18:00:00-05:00', '2024-05-25'),
(163, 41, 4, '10:00:00-05:00', '2024-05-26'),
(164, 41, 6, '10:00:00-05:00', '2024-05-26'),
(165, 42,5, '15:00:00-05:00', '2024-06-04'),
(167, 42, 4, '11:30:00-05:00', '2024-06-05'),
(168, 42, 6, '11:30:00-05:00', '2024-06-05'),
(169, 43, 5, '01:39:14.791653-05:00', '2024-06-05'),
(170, 44, 5, '01:42:40.864687-05:00', '2024-06-05'),
(171, 45, 5, '01:43:56.881663-05:00', '2024-06-05'),
(172, 46, 5, '01:45:34.120313-05:00', '2024-06-05'),
(173, 47, 5, '01:46:55.080301-05:00', '2024-06-05'),
(2, 1, 3, '09:00:00-05:00', '2022-01-06'),
(10, 3, 3, '08:00:00-05:00', '2024-02-11'),
(70, 18, 3, '08:00:00-05:00', '2022-08-10'),
(130, 33, 3, '09:00:00-05:00', '2023-11-21'),
(138, 35, 3, '09:00:00-05:00', '2024-02-11'),
(142, 36, 3, '11:00:00-05:00', '2024-02-12'),
(146, 37, 3, '12:00:00-05:00', '2024-03-19'),
(150, 38, 3, '11:00:00-05:00', '2024-03-20'),
(154, 39, 3, '09:00:00-05:00', '2024-04-21'),
(158, 40, 3, '11:00:00-05:00', '2023-11-21'),
(162, 41, 3, '08:00:00-05:00', '2024-05-26'),
(166, 42, 3, '10:00:00-05:00', '2024-06-05'),
(176, 48, 5, '21:30:00-05:00', '2024-01-05'),
(177, 48, 3, '09:00:00-05:00', '2024-01-06'),
(178, 18, 6, '13:34:49.588175-05:00', '2024-06-05'),
(179, 48, 6, '13:35:00.472874-05:00', '2024-06-05');

---- Insertando datos en la tabla Recordatorio_Enviado

INSERT INTO public."Recordatorio_Enviado"("Id_RecordatorioEnviado", "Recordatorio_Id", "Participante_Id") VALUES
(1, 1, 2),
(2, 1, 3),
(3, 2, 2),
(4, 2, 3),
(5, 4, 2),
(6, 4, 3),
(7, 5, 1),
(8, 5, 10),
(9, 6, 1),
(10, 6, 10),
(11, 8, 1),
(12, 8, 10),
(13, 9, 4),
(14, 9, 13),
(15, 10, 4),
(16, 10, 13),
(17, 12, 4),
(18, 12, 13),
(19, 13, 4),
(20, 13, 12),
(21, 14, 4),
(22, 14, 12),
(23, 16, 4),
(24, 16, 12),
(25, 17, 5),
(26, 17, 6),
(27, 18, 5),
(28, 18, 6),
(29, 20, 5),
(30, 20, 6),
(31, 21, 9),
(32, 21, 14),
(33, 21, 15),
(34, 22, 9),
(35, 22, 14),
(36, 22, 15),
(37, 24, 9),
(38, 24, 14),
(39, 24, 15),
(40, 29, 9),
(41, 29, 14),
(42, 29, 15),
(43, 30, 9),
(44, 30, 14),
(45, 30, 15),
(46, 32, 9),
(47, 32, 14),
(48, 32, 15),
(49, 33, 8),
(50, 33, 14),
(51, 33, 15),
(52, 34, 8),
(53, 34, 14),
(54, 34, 15),
(55, 36, 8),
(56, 36, 14),
(57, 36, 15),
(58, 37, 8),
(59, 37, 9),
(60, 37, 14),
(61, 38, 8),
(62, 38, 9),
(63, 38, 14),
(64, 40, 8),
(65, 40, 14),
(66, 40, 9),
(67, 41, 7),
(68, 41, 9),
(69, 41, 15),
(70, 42, 7),
(71, 42, 9),
(72, 42, 15),
(73, 44, 7),
(74, 44, 9),
(75, 44, 15),
(76, 45, 3),
(77, 45, 10),
(78, 45, 11),
(79, 46, 3),
(80, 46, 10),
(81, 46, 11),
(82, 48, 3),
(83, 48, 10),
(84, 48, 11),
(85, 49, 1),
(86, 49, 3),
(87, 49, 2),
(88, 50, 1),
(89, 50, 3),
(90, 50, 2),
(91, 52, 1),
(92, 52, 3),
(93, 52, 2),
(94, 53, 4),
(95, 53, 6),
(96, 53, 12),
(97, 54, 4),
(98, 54, 6),
(99, 54, 12),
(100, 56, 4),
(101, 56, 6),
(102, 56, 12),
(103, 57, 5),
(104, 57, 12),
(105, 58, 5),
(106, 58, 12),
(107, 60, 5),
(108, 60, 12),
(109, 61, 6),
(110, 61, 12),
(111, 61, 13),
(112, 62, 6),
(113, 62, 12),
(114, 62, 13),
(115, 64, 6),
(116, 64, 12),
(117, 64, 13),
(118, 65, 7),
(119, 65, 8),
(120, 65, 14),
(121, 66, 7),
(122, 66, 8),
(123, 66, 14),
(124, 68, 7),
(125, 68, 8),
(126, 68, 14),
(127, 69, 9),
(128, 69, 15),
(129, 69, 14),
(130, 70, 9),
(131, 70, 15),
(132, 70, 14),
(133, 72, 9),
(134, 72, 15),
(135, 72, 14),
(136, 73, 1),
(137, 73, 3),
(138, 73, 10),
(139, 73, 11),
(140, 74, 1),
(141, 74, 3),
(142, 74, 10),
(143, 74, 11),
(144, 76, 1),
(145, 76, 3),
(146, 76, 10),
(147, 76, 11),
(148, 77, 1),
(149, 77, 2),
(150, 77, 11),
(151, 78, 1),
(152, 78, 2),
(153, 78, 11),
(154, 80, 1),
(155, 80, 2),
(156, 80, 11),
(157, 81, 6),
(158, 81, 12),
(159, 81, 14),
(160, 82, 6),
(161, 82, 12),
(162, 82, 14),
(163, 84, 6),
(164, 84, 12),
(165, 84, 14),
(166, 85, 4),
(167, 85, 12),
(168, 85, 5),
(169, 86, 4),
(170, 86, 12),
(171, 86, 5),
(172, 88, 4),
(173, 88, 12),
(174, 88, 5),
(175, 89, 7),
(176, 89, 14),
(177, 90, 7),
(178, 90, 14),
(179, 92, 7),
(180, 92, 14),
(181, 93, 7),
(182, 93, 9),
(183, 94, 7),
(184, 94, 9),
(185, 96, 7),
(186, 96, 9),
(187, 97, 8),
(188, 97, 15),
(189, 98, 8),
(190, 98, 15),
(191, 100, 8),
(192, 100, 15),
(193, 101, 7),
(194, 101, 9),
(195, 102, 7),
(196, 102, 9),
(197, 104, 7),
(198, 104, 9),
(199, 105, 7),
(200, 105, 8),
(201, 105, 14),
(202, 106, 7),
(203, 106, 8),
(204, 106, 14),
(205, 108, 7),
(206, 108, 8),
(207, 108, 14),
(208, 109, 9),
(209, 109, 15),
(210, 109, 14),
(211, 110, 9),
(212, 110, 15),
(213, 110, 14),
(214, 112, 9),
(215, 112, 15),
(216, 112, 14),
(217, 113, 1),
(218, 113, 11),
(219, 113, 3),
(220, 114, 1),
(221, 114, 11),
(222, 114, 3),
(223, 116, 1),
(224, 116, 11),
(225, 116, 3),
(226, 117, 1),
(227, 117, 11),
(228, 117, 10),
(229, 118, 1),
(230, 118, 11),
(231, 118, 10),
(232, 120, 1),
(233, 120, 11),
(234, 120, 10),
(235, 121, 8),
(236, 121, 9),
(237, 122, 8),
(238, 122, 9),
(239, 124, 8),
(240, 124, 9),
(241, 125, 14),
(242, 125, 9),
(243, 126, 14),
(244, 126, 9),
(245, 128, 14),
(246, 128, 9),
(247, 133, 6),
(248, 133, 13),
(249, 133, 12),
(250, 134, 6),
(251, 134, 13),
(252, 134, 12),
(253, 136, 6),
(254, 136, 13),
(255, 136, 12),
(256, 137, 10),
(257, 137, 3),
(258, 137, 11),
(259, 138, 10),
(260, 138, 3),
(261, 138, 11),
(262, 140, 10),
(263, 140, 3),
(264, 140, 11),
(265, 141, 2),
(266, 141, 3),
(267, 142, 2),
(268, 142, 3),
(269, 144, 2),
(270, 144, 3),
(271, 145, 1),
(272, 145, 3),
(273, 146, 1),
(274, 146, 3),
(275, 148, 1),
(276, 148, 3),
(277, 149, 3),
(278, 149, 10),
(279, 150, 3),
(280, 150, 10),
(281, 152, 3),
(282, 152, 10),
(283, 157, 7),
(284, 157, 9),
(285, 157, 15),
(286, 158, 7),
(287, 158, 9),
(288, 158, 15),
(289, 160, 7),
(290, 160, 9),
(291, 160, 15),
(292, 161, 10),
(293, 161, 11),
(294, 161, 2),
(295, 162, 10),
(296, 162, 11),
(297, 162, 2),
(298, 164, 10),
(299, 164, 11),
(300, 164, 2),
(301, 165, 10),
(302, 165, 1),
(303, 165, 2),
(304, 166, 10),
(305, 166, 1),
(306, 166, 2),
(307, 168, 10),
(308, 168, 1),
(309, 168, 2),
(310, 169, 5),
(311, 169, 12),
(312, 169, 13),
(313, 170, 14),
(314, 170, 15),
(315, 171, 11),
(316, 171, 10),
(317, 172, 4),
(318, 172, 12),
(319, 172, 13),
(320, 173, 9),
(321, 173, 15),
(322, 173, 14),
(323, 176, 7),
(324, 176, 9),
(325, 177, 7),
(326, 177, 9),
(327, 179, 7),
(328, 179, 9);

-----Insertando datos en la tabla Reporte conformidad
INSERT INTO public."Reporte_Conformidad"("Reporte_Id", "Estado", "Fecha", "Pedido_Id", "Tipo_Reporte")VALUES 
(1, 'completado', '2022-01-06', 1, 'Entrada'),
(2, 'completado', '2022-02-14', 1, 'Salida'),
(3, 'completado', '2024-02-12', 2, 'Entrada'),
(4, 'completado', '2022-03-20', 2, 'Salida'),
(5, 'completado', '2022-03-17', 3, 'Entrada'),
(6, 'completado', '2022-04-24', 3, 'Salida'),
(7, 'completado', '2022-04-20', 11, 'Entrada'),
(8, 'completado', '2022-05-29', 11, 'Salida'),
(9, 'completado', '2022-05-26', 25, 'Entrada'),
(10, 'completado', '2022-06-04', 25, 'Salida'),
(11, 'completado', '2022-07-01', 26, 'Entrada'),
(12, 'completado', '2022-08-10', 26, 'Salida'),
(13, 'completado', '2022-08-06', 27, 'Entrada'),
(14, 'completado', '2022-09-15', 27, 'Salida'),
(15, 'completado', '2022-09-11', 38, 'Entrada'),
(16, 'completado', '2022-10-19', 38, 'Salida'),
(17, 'completado', '2022-10-17', 22, 'Entrada'),
(18, 'completado', '2022-11-25', 22, 'Salida'),
(19, 'completado', '2023-03-16', 56, 'Entrada'),
(20, 'completado', '2023-04-24', 56, 'Salida'),
(21, 'completado', '2023-07-01', 46, 'Entrada'),
(22, 'completado', '2023-08-10', 46, 'Salida'),
(23, 'completado', '2023-09-11', 68, 'Entrada'),
(24, 'completado', '2023-10-20', 68, 'Salida'),
(25, 'completado', '2023-11-21', 50, 'Entrada'),
(26, 'completado', '2023-12-30', 50, 'Salida'),
(27, 'completado', '2024-06-05', 73, 'Entrada'),
(28, 'completado', '2024-03-20', 73, 'Salida'),
(29, 'completado', '2024-04-21', 78, 'Entrada'),
(30, 'completado', '2023-11-21', 78, 'Salida'),
(31, 'completado', '2024-05-26', 86, 'Entrada'),
(32, 'completado', '2024-06-05', 86, 'Salida'),
(33, 'pendiente', '2024-06-05', 96, 'Entrada'),
(34, 'pendiente', '2024-06-05', 88, 'Entrada'),
(35, 'pendiente', '2024-06-05', 89, 'Entrada'),
(36, 'pendiente', '2024-06-05', 99, 'Entrada'),
(37, 'pendiente', '2024-06-05', 91, 'Entrada'),
(38, 'pendiente', '2024-06-05', 73, 'Entrada'),
(39, 'completado', '2024-06-05', 71, 'Entrada');

---- Insertando datos en la tabla Reunion_Reporte_Conformidad
INSERT INTO public."Reunion_Reporte_Conformidad"("Id_Reu_Rep", "Reporte_Id", "Reunion_Id") VALUES 
(1, 1, 1),
(2, 2, 2),
(3, 3, 3),
(4, 3, 4),
(5, 4, 5),
(6, 5, 6),
(7, 5, 7),
(8, 5, 8),
(9, 6, 9),
(10, 6, 10),
(11, 6, 11),
(12, 7, 12),
(13, 8, 13),
(14, 9, 14),
(15, 10, 15),
(16, 10, 16),
(17, 11, 17),
(18, 12, 18),
(19, 13, 19),
(20, 14, 20),
(21, 15, 21),
(22, 16, 22),
(23, 17, 23),
(24, 17, 24),
(25, 18, 25),
(26, 18, 26),
(27, 19, 27),
(28, 20, 28),
(29, 21, 29),
(30, 22, 30),
(31, 23, 31),
(32, 24, 32),
(33, 25, 33),
(34, 26, 34),
(35, 27, 35),
(36, 27, 36),
(37, 28, 37),
(38, 28, 38),
(39, 29, 39),
(40, 30, 40),
(41, 31, 41),
(42, 32, 42),
(43, 33, 43),
(44, 34, 44),
(45, 35, 45),
(46, 36, 46),
(47, 37, 47),
(49, 39, 48);

END;
```
