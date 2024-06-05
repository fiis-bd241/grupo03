```sql
BEGIN;

DROP TABLE IF EXISTS public."Campo" CASCADE;
DROP TABLE IF EXISTS public."CampoAsegurado" CASCADE;
DROP TABLE IF EXISTS public."Algoritmo" CASCADE;
DROP TABLE IF EXISTS public."Ambiente" CASCADE;
DROP TABLE IF EXISTS public."Area" CASCADE;
DROP TABLE IF EXISTS public."CargaPreCarga" CASCADE;
DROP TABLE IF EXISTS public."Cargo" CASCADE;
DROP TABLE IF EXISTS public."ConceptosNegocio" CASCADE;
DROP TABLE IF EXISTS public."DefinicionesTecnicas" CASCADE;
DROP TABLE IF EXISTS public."Dominio" CASCADE;
DROP TABLE IF EXISTS public."Empleado" CASCADE;
DROP TABLE IF EXISTS public."Esquema" CASCADE;
DROP TABLE IF EXISTS public."Estado" CASCADE;
DROP TABLE IF EXISTS public."Migracion" CASCADE;
DROP TABLE IF EXISTS public."Modelado" CASCADE;
DROP TABLE IF EXISTS public."Notificacion" CASCADE;
DROP TABLE IF EXISTS public."Participa_en" CASCADE;
DROP TABLE IF EXISTS public."Participante" CASCADE;
DROP TABLE IF EXISTS public."Pedido" CASCADE;
DROP TABLE IF EXISTS public."Pertenece" CASCADE;
DROP TABLE IF EXISTS public."PreCarga" CASCADE;
DROP TABLE IF EXISTS public."Prioridad" CASCADE;
DROP TABLE IF EXISTS public."Programacion" CASCADE;
DROP TABLE IF EXISTS public."Recordatorio" CASCADE;
DROP TABLE IF EXISTS public."Recordatorio_Enviado" CASCADE;
DROP TABLE IF EXISTS public."RegistroErrores" CASCADE;
DROP TABLE IF EXISTS public."ReglasDeCarga" CASCADE;
DROP TABLE IF EXISTS public."Reporte" CASCADE;
DROP TABLE IF EXISTS public."Reporte_Conformidad" CASCADE;
DROP TABLE IF EXISTS public."Reunion" CASCADE;
DROP TABLE IF EXISTS public."Reunion_Reporte_Conformidad" CASCADE;
DROP TABLE IF EXISTS public."Roles" CASCADE;
DROP TABLE IF EXISTS public."Squad" CASCADE;
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

CREATE TABLE IF NOT EXISTS public."CampoAsegurado"
(
    "id_CampoAsegurado" serial NOT NULL,
    id_admin serial NOT NULL,
    id_campo serial NOT NULL,
    CONSTRAINT "CampoAsegurado_pkey" PRIMARY KEY ("id_CampoAsegurado")
);

CREATE TABLE IF NOT EXISTS public."CargaPreCarga"
(
    "ID_CargaPrecarga" serial NOT NULL,
    "ID_ReglaCarga" serial NOT NULL,
    "ID_Precarga" serial NOT NULL,
    CONSTRAINT "CargaPreCarga_pkey" PRIMARY KEY ("ID_CargaPrecarga")
);

CREATE TABLE IF NOT EXISTS public."Cargo"
(
    id_cargo serial NOT NULL,
    nombre_cargo character varying(50) COLLATE pg_catalog."default",
    CONSTRAINT "Cargo_pkey" PRIMARY KEY (id_cargo)
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

ALTER TABLE public."DefinicionesTecnicas" ALTER COLUMN "EquivalenciaId" DROP NOT NULL;

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

CREATE TABLE IF NOT EXISTS public."Migracion"
(
    "Migracion_Id" serial NOT NULL,
    "Pedido_Id" serial NOT NULL,
    "Id_Squad" serial NOT NULL,
    "Id_Tecnologia" serial NOT NULL,
    "Entorno" character varying(50) COLLATE pg_catalog."default",
    "Fecha_migracion" date,
    "Valido" boolean,
    "Ultimo" boolean,
    CONSTRAINT "Migracion_pkey" PRIMARY KEY ("Migracion_Id")
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

CREATE TABLE IF NOT EXISTS public."Notificacion"
(
    "Notificacion_Id" serial NOT NULL,
    "Pedido_Id" serial NOT NULL,
    "Squad_Id" serial NOT NULL,
    "Notificacion_Fecha" date,
    "Notificacion_Hora" time with time zone,
    "Notificacion_Asunto" character varying(50) COLLATE pg_catalog."default",
    "Notificacion_Contenido" character varying(250) COLLATE pg_catalog."default",
    CONSTRAINT "Notificacion_pkey" PRIMARY KEY ("Notificacion_Id")
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
    "Area_Id" serial NOT NULL,
    "Prioridad_Id" serial NOT NULL,
    "Estado_Id" serial NOT NULL,
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

CREATE TABLE IF NOT EXISTS public."PreCarga"
(
    "ID_Precarga" serial NOT NULL,
    "Nombre_Regla" character varying(200) COLLATE pg_catalog."default",
    "Detalle_Precarga" character varying(200) COLLATE pg_catalog."default",
    CONSTRAINT "PreCarga_pkey" PRIMARY KEY ("ID_Precarga")
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

CREATE TABLE IF NOT EXISTS public."ReglasDeCarga"
(
    "ID_ReglaCarga" serial NOT NULL,
    id_campo serial NOT NULL,
    id_tecnologia serial NOT NULL,
    detalle_carga text COLLATE pg_catalog."default",
    CONSTRAINT "ReglasDeCarga_pkey" PRIMARY KEY ("ID_ReglaCarga")
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


ALTER TABLE IF EXISTS public."CargaPreCarga"
    ADD CONSTRAINT "CargaPreCarga_ID_Precarga_fkey" FOREIGN KEY ("ID_Precarga")
    REFERENCES public."PreCarga" ("ID_Precarga") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."CargaPreCarga"
    ADD CONSTRAINT "CargaPreCarga_ID_ReglaCarga_fkey" FOREIGN KEY ("ID_ReglaCarga")
    REFERENCES public."ReglasDeCarga" ("ID_ReglaCarga") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."ConceptosNegocio"
    ADD CONSTRAINT "ConceptosNegocio_MigracionId_fkey" FOREIGN KEY ("MigracionId")
    REFERENCES public."Migracion" ("Migracion_Id") MATCH SIMPLE
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


ALTER TABLE IF EXISTS public."Migracion"
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


ALTER TABLE IF EXISTS public."Notificacion"
    ADD CONSTRAINT "Notificacion_Pedido_Id_fkey" FOREIGN KEY ("Pedido_Id")
    REFERENCES public."Pedido" ("Pedido_Id") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."Notificacion"
    ADD CONSTRAINT "Notificacion_Squad_Id_fkey" FOREIGN KEY ("Squad_Id")
    REFERENCES public."Squad" (id_squad) MATCH SIMPLE
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

    
-- Insertar datos en la tabla Pedido
INSERT INTO public."Pedido"("Area_Id", "Prioridad_Id", "Estado_Id", "Pedido_Fecha", "Pedido_FechaLimite")
VALUES 
(1, 2, 3, '2022-01-05', '2022-02-15'),
(2, 1, 1, '2022-02-10', '2022-03-20'),
(3, 3, 4, '2022-03-15', '2022-04-25'),
(1, 2, 3, '2022-01-05', '2022-02-15'),
(2, 1, 2, '2022-02-10', '2022-03-20'),
(3, 3, 4, '2022-03-15', '2022-04-25'),
(1, 1, 1, '2022-04-20', '2022-05-30'),
(1, 2, 3, '2022-01-05', '2022-02-15'),
(2, 1, 2, '2022-02-10', '2022-03-20'),
(3, 3, 4, '2022-03-15', '2022-04-25'),
(1, 1, 1, '2022-04-20', '2022-05-30'),
(2, 2, 3, '2022-05-25', '2022-06-05'),
(3, 1, 2, '2022-06-30', '2022-08-10'),
(1, 2, 3, '2022-08-05', '2022-09-15'),
(2, 1, 1, '2022-09-10', '2022-10-20'),
(3, 3, 4, '2022-10-15', '2022-11-25'),
(1, 1, 2, '2022-11-20', '2022-12-30'),
(2, 2, 3, '2022-05-25', '2022-06-05'),
(3, 1, 2, '2022-06-30', '2022-08-10'),
(1, 2, 3, '2022-08-05', '2022-09-15'),
(2, 1, 1, '2022-09-10', '2022-10-20'),
(3, 3, 4, '2022-10-15', '2022-11-25'),
(1, 1, 2, '2022-11-20', '2022-12-30'),
(1, 1, 2, '2022-04-20', '2022-05-30'),
(2, 2, 3, '2022-05-25', '2022-06-05'),
(3, 1, 1, '2022-06-30', '2022-08-10'),
(1, 3, 4, '2022-08-05', '2022-09-15'),
(2, 2, 3, '2022-09-10', '2022-10-20'),
(3, 1, 1, '2022-10-15', '2022-11-25'),
(1, 2, 3, '2022-11-20', '2022-12-30'),
(1, 1, 2, '2022-01-05', '2022-02-15'),
(2, 2, 3, '2022-02-10', '2022-03-20'),
(3, 3, 4, '2022-03-15', '2022-04-25'),
(1, 1, 1, '2022-04-20', '2022-05-30'),
(2, 3, 4, '2022-05-25', '2022-06-05'),
(3, 2, 3, '2022-06-30', '2022-08-10'),
(1, 1, 2, '2022-08-05', '2022-09-15'),
(2, 2, 3, '2022-09-10', '2022-10-20'),
(3, 3, 4, '2022-10-15', '2022-11-25'),
(1, 1, 1, '2022-11-20', '2022-12-30'),
(2, 2, 3, '2023-01-05', '2023-02-15'),
(3, 1, 2, '2023-02-10', '2023-03-20'),
(1, 3, 4, '2023-03-15', '2023-04-25'),
(2, 1, 1, '2023-04-20', '2023-05-30'),
(3, 2, 3, '2023-05-25', '2023-06-05'),
(1, 1, 2, '2023-06-30', '2023-08-10'),
(2, 2, 3, '2023-08-05', '2023-09-15'),
(3, 1, 1, '2023-09-10', '2023-10-20'),
(1, 3, 4, '2023-10-15', '2023-11-25'),
(2, 1, 2, '2023-11-20', '2023-12-30'),
(2, 2, 3, '2023-01-05', '2023-02-15'),
(3, 1, 1, '2023-02-10', '2023-03-20'),
(1, 3, 4, '2023-03-15', '2023-04-25'),
(2, 1, 2, '2023-04-20', '2023-05-30'),
(2, 1, 2, '2023-01-05', '2023-02-15'),
(3, 3, 4, '2023-02-10', '2023-03-20'),
(1, 2, 3, '2023-03-15', '2023-04-25'),
(2, 1, 1, '2023-04-20', '2023-05-30'),
(3, 3, 4, '2023-05-25', '2023-06-05'),
(1, 1, 1, '2023-06-30', '2023-08-10'),
(2, 2, 3, '2023-08-05', '2023-09-15'),
(3, 1, 2, '2023-09-10', '2023-10-20'),
(1, 2, 3, '2023-10-15', '2023-11-25'),
(2, 1, 1, '2023-11-20', '2023-12-30'),
(3, 2, 3, '2023-05-25', '2023-06-05'),
(1, 1, 1, '2023-06-30', '2023-08-10'),
(2, 2, 3, '2023-08-05', '2023-09-15'),
(3, 1, 2, '2023-09-10', '2023-10-20'),
(1, 2, 3, '2023-10-15', '2023-11-25'),
(2, 1, 1, '2023-11-20', '2023-12-30'),
(3, 3, 4, '2024-01-05', '2024-02-15'),
(3, 3, 4, '2024-01-05', '2024-02-15'),
(1, 1, 2, '2024-02-10', '2024-03-20'),
(2, 2, 3, '2024-03-15', '2024-04-25'),
(3, 2, 3, '2024-01-05', '2024-02-15'),
(1, 1, 1, '2024-02-10', '2024-03-20'),
(2, 3, 4, '2024-03-15', '2024-04-25'),
(3, 2, 3, '2024-04-20', '2024-05-30'),
(1, 1, 2, '2024-05-25', '2024-06-05'),
(2, 2, 3, '2024-06-30', '2024-08-10'),
(3, 3, 4, '2024-08-05', '2024-09-15'),
(1, 1, 1, '2024-09-10', '2024-10-20'),
(2, 2, 3, '2024-10-15', '2024-11-25'),
(3, 3, 4, '2024-11-20', '2024-12-30'),
(3, 1, 1, '2024-04-20', '2024-05-30'),
(1, 2, 3, '2024-05-25', '2024-06-05'),
(2, 1, 2, '2024-06-30', '2024-08-10'),
(3, 3, 4, '2024-08-05', '2024-09-15'),
(1, 2, 3, '2024-09-10', '2024-10-20'),
(2, 1, 1, '2024-10-15', '2024-11-25'),
(3, 3, 4, '2024-11-20', '2024-12-30'),
(1, 1, 2, '2024-02-10', '2024-03-20'),
(2, 2, 3, '2024-03-15', '2024-04-25'),
(3, 1, 1, '2024-04-20', '2024-05-30'),
(1, 2, 3, '2024-05-25', '2024-06-05'),
(2, 1, 2, '2024-06-30', '2024-08-10'),
(3, 3, 4, '2024-08-05', '2024-09-15'),
(1, 2, 3, '2024-09-10', '2024-10-20'),
(2, 1, 1, '2024-10-15', '2024-11-25'),
(3, 3, 4, '2024-11-20', '2024-12-30');

-- Insertar datos en la tabla Tecnologia
INSERT INTO public."Tecnologia"("id_tecnologia", "nombre_tecnologia")
VALUES
    (1, 'Pyspark'),
    (2, 'Bashsrc'),
    (3, 'Hsqldb'),
    (4, 'Kafka'),
    (5, 'MFRM'),
    (6, 'Spkscal');

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

--Insertar Datos en la tabla Migracion
INSERT INTO public."Migracion"(
	"Pedido_Id", "Id_Squad", "Id_Tecnologia", "Entorno", "Fecha_migracion", "Valido", "Ultimo")
	VALUES   (1, 2, 1,'DWH', '10/04/24', true, false),
    (1, 3, 1, 'DWH', '10/04/24', true, true),
    (1, 4, 2, 'DWH', '11/04/24', false, false),
    (1, 5, 1, 'DWH', '10/04/24', false, false),
    (1, 6, 1, 'DWH', '9/04/24', false, false),
    (1, 7, 2, 'DWH', '9/04/24', true, false),
    (1, 8, 2, 'DWH', '10/04/24', true, false),
	(2, 3, 1, 'DWH', '2022-03-15', true, false),
	(2, 4, 2, 'SandBox', '2022-03-20', false, true),
	(2, 5, 1, 'SAS', '2022-03-25', true, false),
	(3, 2, 2, 'DWH', '2022-04-10', false, false),
	(3, 3, 1, 'SandBox', '2022-04-15', true, false),
	(3, 4, 1, 'SAS', '2022-04-20', true, false),
	(4, 5, 2, 'DWH', '2022-05-05', true, true),
	(4, 6, 2, 'SandBox', '2022-05-10', false, false),
	(4, 7, 1, 'SAS', '2022-05-15', true, false),
	(5, 2, 1, 'DWH', '2022-06-20', true, false),
	(5, 3, 1, 'SandBox', '2022-06-25', false, false),
	(5, 4, 2, 'SAS', '2022-06-30', true, true),
	(6, 5, 2, 'DWH', '2022-07-10', true, false),
	(6, 6, 1, 'SandBox', '2022-07-15', false, false),
	(6, 7, 1, 'SAS', '2022-07-20', true, false),
	(7, 3, 2, 'DWH', '2022-08-05', false, false),
	(7, 4, 1, 'SandBox', '2022-08-10', true, false),
	(7, 5, 1, 'SAS', '2022-08-15', true, false),
	(8, 6, 2, 'DWH', '2022-09-20', true, true),
	(8, 7, 2, 'SandBox', '2022-09-25', false, false),
	(8, 8, 1, 'SAS', '2022-09-30', true, false),
	(9, 4, 1, 'DWH', '2022-10-10', false, false),
	(9, 5, 2, 'SandBox', '2022-10-15', true, false),
	(9, 6, 2, 'SAS', '2022-10-20', true, false),
	(10, 7, 1, 'DWH', '2022-11-05', true, true),
	(10, 8, 1, 'SandBox', '2022-11-10', false, false),
	(10, 9, 2, 'SAS', '2022-11-15', true, false),
	(11, 5, 2, 'DWH', '2022-12-20', false, false),
	(11, 6, 1, 'SandBox', '2022-12-25', true, false),
	(11, 7, 1, 'SAS', '2022-12-30', true, false),
	(12, 6, 2, 'DWH', '2023-01-10', true, false),
	(12, 7, 1, 'SandBox', '2023-01-15', false, false),
	(12, 8, 1, 'SAS', '2023-01-20', true, false),
	(13, 9, 2, 'DWH', '2023-02-05', true, true),
	(13, 10, 1, 'SandBox', '2023-02-10', false, false),
	(13, 6, 1, 'SAS', '2023-02-15', true, false),
	(14, 7, 1, 'DWH', '2023-03-20', true, false),
	(14, 8, 2, 'SandBox', '2023-03-25', false, false),
	(14, 9, 2, 'SAS', '2023-03-30', true, false),
	(15, 10, 1, 'DWH', '2023-04-05', false, true),
	(15, 6, 1, 'SandBox', '2023-04-10', true, false),
	(15, 5, 2, 'SAS', '2023-04-15', true, false),
	(16, 8, 2, 'DWH', '2023-05-20', true, false),
	(16, 9, 1, 'SandBox', '2023-05-25', false, false),
	(16, 10, 1, 'SAS', '2023-05-30', true, false),
	(17, 4, 2, 'DWH', '2023-06-05', true, true),
	(17, 4, 2, 'SandBox', '2023-06-10', false, false),
	(17, 3, 1, 'SAS', '2023-06-15', true, false),
	(18, 9, 1, 'DWH', '2023-07-20', true, false),
	(18, 10, 1, 'SandBox', '2023-07-25', false, false),
	(18, 2, 2, 'SAS', '2023-07-30', true, false),
	(19, 2, 2, 'DWH', '2023-08-05', false, true),
	(19, 3, 1, 'SandBox', '2023-08-10', true, false),
	(19, 4, 1, 'SAS', '2023-08-15', true, false),
	(20, 10, 1, 'DWH', '2023-09-20', true, false),
	(20, 1, 2, 'SandBox', '2023-09-25', false, false),
	(20, 2, 2, 'SAS', '2023-09-30', true, false),
	(21, 3, 1, 'DWH', '2023-10-05', true, true),
	(21, 4, 1, 'SandBox', '2023-10-10', false, false),
	(21, 5, 2, 'SAS', '2023-10-15', true, false),
	(22, 1, 2, 'DWH', '2023-11-20', true, false),
	(22, 2, 1, 'SandBox', '2023-11-25', false, false),
	(22, 3, 1, 'SAS', '2023-11-30', true, false),
	(23, 4, 1, 'DWH', '2023-12-05', true, true),
	(23, 5, 2, 'SandBox', '2023-12-10', false, false),
	(23, 6, 2, 'SAS', '2023-12-15', true, false),
	(24, 2, 1, 'DWH', '2024-01-20', true, false),
	(24, 3, 1, 'SandBox', '2024-01-25', false, false),
	(24, 4, 2, 'SAS', '2024-01-30', true, false),
	(25, 5, 2, 'DWH', '2024-02-05', true, true),
	(25, 6, 1, 'SandBox', '2024-02-10', false, false),
	(25, 7, 1, 'SAS', '2024-02-15', true, false),
	(26, 3, 1, 'DWH', '2024-03-20', true, false),
	(26, 4, 2, 'SandBox', '2024-03-25', false, false),
	(26, 5, 2, 'SAS', '2024-03-30', true, false),
	(27, 6, 2, 'DWH', '2024-04-05', true, true),
	(27, 7, 1, 'SandBox', '2024-04-10', false, false),
	(27, 8, 1, 'SAS', '2024-04-15', true, false),
	(28, 4, 2, 'DWH', '2024-05-20', true, false),
	(28, 5, 1, 'SandBox', '2024-05-25', false, false),
	(28, 6, 1, 'SAS', '2024-05-30', true, false),
	(29, 7, 1, 'DWH', '2024-06-05', true, true),
	(29, 8, 2, 'SandBox', '2024-06-10', false, false),
	(29, 9, 2, 'SAS', '2024-06-15', true, false),
	(30, 5, 1, 'DWH', '2024-07-20', true, false),
	(30, 6, 2, 'SandBox', '2024-07-25', false, false),
	(30, 7, 2, 'SAS', '2024-07-30', true, false),
	(31, 8, 2, 'DWH', '2024-08-05', true, true),
	(31, 9, 1, 'SandBox', '2024-08-10', false, false),
	(31, 2, 1, 'SAS', '2024-08-15', true, false),
	(32, 6, 1, 'DWH', '2024-09-20', true, false),
	(32, 7, 2, 'SandBox', '2024-09-25', false, false),
	(32, 8, 2, 'SAS', '2024-09-30', true, false),
	(33, 9, 2, 'DWH', '2024-10-05', true, true),
	(33, 2, 1, 'SandBox', '2024-10-10', false, false),
	(33, 2, 1, 'SAS', '2024-10-15', true, false),
	(34, 7, 2, 'DWH', '2024-11-20', true, false),
	(34, 8, 1, 'SandBox', '2024-11-25', false, false),
	(34, 9, 1, 'SAS', '2024-11-30', true, false),
	(35, 2, 1, 'DWH', '2024-12-05', true, true);

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
	

-- Insertar datos en la tabla Ambiente
INSERT INTO public."Ambiente"(
    nombre_ambiente)
VALUES
    ('DWH'),
    ('SandBox'),
    ('SAS');

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
    "ID_Precarga", "Nombre_Regla", "Detalle_Precarga")
VALUES
    (200001, 'Validacion Unicidad', 'Validacion registros duplicados'),
    (200002, 'Validacion Integridad Universal', 'Clave Foranea coincide con la principal'),
    (200003, 'Validacion de Registro', 'Validar Integridad en tablas especiales'),
    (200004, 'Validacion Dominio de Valores', 'Verificar dominio de valores'),
    (200005, 'Validacion de Estructura o Expresion Regular', 'Formato correspondiente'),
    (200006, 'Validacion Nulidad', 'Campo Obligatorio en Blanco'),
    (200007, 'Regla de Limpieza y Estadarización', 'Datos no estadarizados'),
    (200008, 'Regla de Enriquecimiento', 'Nuevos datos para mejorar los existentes');

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

-- Insertar datos en la tabla ReglasDeCarga
INSERT INTO public."ReglasDeCarga"(
    "ID_ReglaCarga", id_campo, id_tecnologia, detalle_carga)
VALUES
    (100001, 1, 1, 'SELECT A.TIPROLCLI FROM catalog_lhcl_prod_bcp.bcp_udv_int.m_cuentafinanciera A INNER JOIN UNIVERSO_OUTSOURCING_CLI B ON A.CODCLAVEPARTYCLI = B.CODCLAVEPARTYCLI WHERE B.flgregeliminadofuente = ''N'''),
    (100002, 2, 1, 'SELECT B.DESUBIGEO FROM UNIVERSO_OUTSOURCING_CLI A LEFT JOIN catalog_lhcl_prod_bcp.bcp_ddv_dyadata_dataenrichment.md_direccioncontacto B ON A.codclavepartycli = B.codclavepartycli WHERE A.flgregeliminado = ''N'' AND B.flgregeliminadofuente = ''N'''),
    (100003, 3, 1, 'SELECT B.CODINTERNOCOMPUTACIONAL FROM UNIVERSO_OUTSOURCING_CLI A LEFT JOIN catalog_lhcl_prod_bcp.bcp_udv_int.M_CLIENTE B ON A.codclavepartycli = B.codclavepartycli WHERE B.flgregeliminadofuente = ''N'''),
    (100004, 4, 1, 'SELECT B.CODCLAVEDESDIRESTANDARIZADO FROM UNIVERSO_OUTSOURCING_CLI A LEFT JOIN catalog_lhcl_prod_bcp.bcp_ddv_dyadata_dataenrichment.MD_DIRECCIONCONTACTO B ON A.codclavepartycli = B.codclavepartycli WHERE B.flgregeliminado = ''N'''),
    (100005, 5, 1, 'SELECT B.CODDEPARTAMENTO FROM UNIVERSO_OUTSOURCING_CLI A LEFT JOIN catalog_lhcl_prod_bcp.bcp_ddv_dyadata_dataenrichment.md_direccioncontacto B ON A.codclavepartycli = B.codclavepartycli WHERE B.flgregeliminado = ''N'''),
    (100006, 6, 1, 'CREATE TABLE TMP_DESDEPARTAMENTO (Ejemplo TEXT); SELECT A.codclavepartycli, B.desdepartamento FROM catalog_lhcl_prod_bcp.bcp_ddv_dyadata_dataenrichment.md_direccioncontacto A LEFT JOIN catalog_lhcl_prod_bcp.bcp_udv_int.m_departamento B ON TRIM(A.coddepartamento) = TRIM(B.coddepartamento) WHERE A.flgregeliminado = ''N'' AND B.flgregeliminadofuente = ''N''; SELECT B.desdepartamento FROM UNIVERSO_OUTSOURCING_CLI A LEFT JOIN TMP_DESDEPARTAMENTO B ON A.codclavepartycli = B.codclavepartycli'),
    (100007, 7, 1, 'SELECT B.codprovincia FROM UNIVERSO_OUTSOURCING_CLI A LEFT JOIN catalog_lhcl_prod_bcp.bcp_ddv_dyadata_dataenrichment.md_direccioncontacto B ON A.codclavepartycli = B.codclavepartycli WHERE A.flgregeliminado = ''N'' AND B.flgregeliminadofuente = ''N'''),
    (100008, 8, 1, 'CREATE TABLE TMP_DESPROVINCIA (Ejemplo TEXT); SELECT A.codclavepartycli, B.desprovincia FROM catalog_lhcl_prod_bcp.bcp_ddv_dyadata_dataenrichment.md_direccioncontacto A LEFT JOIN catalog_lhcl_prod_bcp.bcp_udv_int.m_provincia B ON TRIM(A.CODPROVINCIA) = TRIM(B.CODPROVINCIA) WHERE A.flgregeliminado = ''N'' AND B.flgregeliminadofuente = ''N''; SELECT B.desprovincia FROM UNIVERSO_OUTSOURCING_CLI A LEFT JOIN TMP_DESPROVINCIA B ON A.codclavepartycli = B.codclavepartycli'),
    (100009, 9, 1, 'SELECT B.coddistrito FROM UNIVERSO_OUTSOURCING_CLI A LEFT JOIN catalog_lhcl_prod_bcp.bcp_ddv_dyadata_dataenrichment.md_direccioncontacto B ON A.codclavepartycli = B.codclavepartycli WHERE A.flgregeliminado = ''N'' AND B.flgregeliminadofuente = ''N'''),
    (100010, 10, 1, 'CREATE TABLE TMP_DESDISTRITO (Ejemplo TEXT); SELECT A.codclavepartycli, B.desdistrito FROM catalog_lhcl_prod_bcp.bcp_ddv_dyadata_dataenrichment.md_direccioncontacto A LEFT JOIN catalog_lhcl_prod_bcp.bcp_udv_int.m_distrito B ON TRIM(A.coddistrito) = TRIM(B.coddistrito) WHERE A.flgregeliminado = ''N'' AND B.flgregeliminadofuente = ''N''; SELECT B.desdistrito FROM UNIVERSO_OUTSOURCING_CLI A LEFT JOIN TMP_DESDISTRITO B ON A.codclavepartycli = B.codclavepartycli');

-- Insertar datos en la tabla CargaPreCarga
INSERT INTO public."CargaPreCarga"(
    "ID_CargaPrecarga", "ID_ReglaCarga", "ID_Precarga")
VALUES
    (1, 100001, 200001),
    (2, 100001, 200002),
    (3, 100002, 200002),
    (4, 100003, 200006),
    (5, 100003, 200008),
    (6, 100004, 200002),
    (7, 100004, 200001),
    (8, 100004, 200006);

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

-- Insertar datos en la tabla Notificacion
INSERT INTO public."Notificacion"(
    "Notificacion_Id", "Pedido_Id", "Squad_Id", "Notificacion_Fecha", "Notificacion_Hora", "Notificacion_Asunto", "Notificacion_Contenido")
VALUES
    (1, 1, 1, '2024-04-27', '09:15:00', 'Adición de Campo', 'Se informa que se necesita agregar un nuevo campo en la migración.'),
    (2, 1, 1, '2024-04-27', '11:45:00', 'Tiempo Limite', 'Recordatorio que la fecha límite del pedido es el día de mañana.'),
    (3, 2, 3, '2024-04-27', '15:30:00', 'Aviso de Cancelación', 'Se informa que el proceso de migración ha sido cancelado.');

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

INSERT INTO public."Tipo_Reunion"(
	"TipoReunion_Id", "Nombre", "Descripcion")
	VALUES
    (1, 'Entrada', 'Reunión inicial para discutir los detalles del pedido de migración.'),
    (2, 'Salida', 'Reunión final para verificar la migración y obtener la aprobación del usuario.');

-- Insertando datos en la tabla Tipo_Recordatorio

INSERT INTO public."Tipo_Recordatorio" ("TipoRecordatorio_Id", "Nombre", "Descripcion", "Mensaje") VALUES
(1, 'Cancelación de Reunión', 'Notificación de cancelación de una reunión', 'La reunión programada ha sido cancelada.'),
(2, 'Modificación de Reunión', 'Notificación de cambios en una reunión', 'Se han realizado cambios en la reunión programada. Por favor, revíselos.'),
(3, 'Inicio de Reunión', 'Recordatorio de inicio de la reunión', 'La reunión está a punto de comenzar. Por favor, únase a tiempo.'),
(4, 'Finalización de Reunión', 'Notificación de finalización de la reunión', 'La reunión ha finalizado. Gracias por su participación.'),
(5, 'Programación de Reunión', 'Notificación de programación de una nueva reunión', 'Se ha programado una nueva reunión. Por favor, revísela.');
-- Insertando datos en la tabla Reunion

INSERT INTO public."Reunion" ("Reunion_Id", "Id_Empleado", "Pedido_Id", "TipoReunion_Id", "HoraInicio", "HoraFin", "Plataforma", "Fecha", "Estado", "Agenda", "Acuerdos", "FechaProgramacion", "HoraProgramacion") VALUES
(1, 7, 1, 1, '09:00:00-05:00', '10:00:00-05:00', 'Zoom', '2024-04-09', 'Completada', 'Presentación del equipo de migración de datos y explicación del proceso de migración. Revisión del diccionario de datos. Validación de la unicidad y nulidad de los campos. Identificación de datos sensibles del cliente. Establecimiento de la frecuencia de migración.', '1. Los campos que se van a migrar: "CODCLAVEDESDIRESTANDARIZADO", "CODDEPARTAMENTOX", "CODPROVINCIAX", "CODDISTRITOX", "CODUBIGEOX", "TIPCLASIFRIESGO", "DESTIPCLASIFRIESGO". 2. Los campos llave: "CODCLAVEDESDIRESTANDARIZADO". 3. La frecuencia de migración será quincenal.', '2024-04-08', '21:00:00-05:00'),
(2, 7, 1, 1, '10:00:00-05:00', '11:00:00-05:00', 'Zoom', '2024-04-10', 'Completada', 'Revisión breve de los avances desde la última reunión. Presentación de los datos duplicados o nulos identificados. Evaluación de los campos críticos que decantan en reglas post carga. Discusión sobre la eliminación, modificación o retención de datos.', '1. Los datos duplicados fueron: No hubo datos. 2. No hay datos EDC (Elemento de dato crítico). 3. No se elimina ningún campo.', '2024-04-08', '22:00:00-05:00');


-- Insertando datos en la tabla Participante

INSERT INTO public."Participante"("Participante_Id", "Area_Id", "Nombre", "Apellido", "Correo")
VALUES 
    (1, 1, 'Carlos', 'Sanchez', 'carloss@bcp.pe'),
    (2, 1, 'Lucia', 'Hernandez', 'luciah@bcp.pe'),
    (3, 1, 'Diego', 'Mendoza', 'diegom@bcp.pe'),
    (4, 2, 'Marta', 'Gomez', 'martag@bcp.pe'),
    (5, 2, 'Ricardo', 'Diaz', 'ricardod@bcp.pe'),
    (6, 2, 'Sofia', 'Torres', 'sofiat@bcp.pe'),
    (7, 3, 'Luis', 'Gutierrez', 'luisg@bcp.pe'),
    (8, 3, 'Elena', 'Perez', 'elenap@bcp.pe'),
    (9, 3, 'Mario', 'Lopez', 'mariol@bcp.pe');


-- Insertando datos en la tabla Participa_en

INSERT INTO public."Participa_en"("Id_Participa_en", "Reunion_Id", "Participante_Id") VALUES
(1, 1, 1),
(2, 1, 2),
(3, 1, 3),
(4, 2, 1),
(5, 2, 2);

-- Insertando datos en la tabla Recordatorio

INSERT INTO public."Recordatorio" ("Recordatorio_Id", "Reunion_Id", "TipoRecordatorio_Id", "Hora", "Fecha") VALUES
(1, 1, 5, '21:00:00-05:00', '2024-04-08'),
(2, 1, 3, '08:30:00-05:00', '2024-04-09'),
(3, 1, 4, '09:00:00-05:00', '2024-04-09'),
(4, 2, 5, '22:00:00-05:00', '2024-04-08'),
(5, 2, 3, '09:30:00-05:00', '2024-04-10'),
(6, 2, 4, '10:00:00-05:00', '2024-04-10'),
(7, 2, 2, '09:00:00-05:00', '2024-04-10');

-- Insertando datos en la tabla Recordatorio_Enviado

INSERT INTO public."Recordatorio_Enviado" ("Id_RecordatorioEnviado", "Recordatorio_Id", "Participante_Id") VALUES
(1, 1, 1),
(2, 1, 2),
(3, 1, 3),
(4, 2, 1),
(5, 2, 2),
(6, 2, 3),
(7, 3, 1),
(8, 3, 2),
(9, 3, 3),
(10, 4, 1),
(11, 4, 2),
(12, 5, 1),
(13, 5, 2),
(14, 6, 1),
(15, 6, 2),
(16, 7, 1),
(17, 7, 2);


--Insertando datos en la tabla Reporte conformidad

INSERT INTO public."Reporte_Conformidad"("Reporte_Id", "Estado", "Fecha") VALUES
(1, 'Completo', '2024-04-10');

-- Insertando datos en la tabla Reunion_Reporte_Conformidad

INSERT INTO public."Reunion_Reporte_Conformidad"("Id_Reu_Rep", "Reporte_Id", "Reunion_Id") VALUES
(1, 1, 1),
(2, 1, 2);

END;
```
