```sql
BEGIN;

DROP TABLE IF EXISTS public."Algoritmo" CASCADE;
DROP TABLE IF EXISTS public."Ambiente" CASCADE;
DROP TABLE IF EXISTS public."Area" CASCADE;
DROP TABLE IF EXISTS public."Campo" CASCADE;
DROP TABLE IF EXISTS public."CampoAsegurado" CASCADE;
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
DROP TABLE IF EXISTS public."Tarea" CASCADE;
DROP TABLE IF EXISTS public."RendimientoEmpleado" CASCADE;

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
    id_dominio serial NOT NULL,
    subdominio character varying(100) COLLATE pg_catalog."default",
    id_referencia serial NOT NULL,
    "DefinicionTabla" text COLLATE pg_catalog."default",
    "DefinicionCampo" text COLLATE pg_catalog."default",
    "PedidoId" serial NOT NULL,
    CONSTRAINT "ConceptosNegocio_pkey" PRIMARY KEY ("id_CN")
);

CREATE TABLE IF NOT EXISTS public."DefinicionesTecnicas"
(
    "id_DT" serial NOT NULL,
    "EquivalenciaId" serial,
    "ModeloId" serial NOT NULL,
    "EsquemaId" serial NOT NULL,
    "Tabla" character varying(200) COLLATE pg_catalog."default",
    "Campo" character varying(100) COLLATE pg_catalog."default",
    CONSTRAINT "DefinicionesTecnicas_pkey" PRIMARY KEY ("id_DT")
);

CREATE TABLE IF NOT EXISTS public."Dominio"
(
    id_dominio serial NOT NULL,
    tipo_dominio character varying(50) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT "Dominio_pkey" PRIMARY KEY (id_dominio)
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

CREATE TABLE IF NOT EXISTS public."Tarea"
(
    id_tarea serial NOT NULL,
    id_empleado integer NOT NULL,
    descripcion text COLLATE pg_catalog."default",
    fecha_inicio date,
    fecha_fin date,
    estado character varying(50) COLLATE pg_catalog."default",
    CONSTRAINT "Tarea_pkey" PRIMARY KEY (id_tarea)
);

CREATE TABLE IF NOT EXISTS public."RendimientoEmpleado"
(
    id_rendimiento serial NOT NULL,
    id_empleado integer NOT NULL,
    tareas_completadas integer,
    tiempo_promedio_tareas interval,
    calidad_trabajo integer,
    participacion_reuniones integer,
    documentos_generados integer,
    fecha date DEFAULT CURRENT_DATE,
    CONSTRAINT "RendimientoEmpleado_pkey" PRIMARY KEY (id_rendimiento)
);


CREATE TABLE IF NOT EXISTS public."Esquema"
(
    id_esquema serial NOT NULL,
    "AmbienteId" serial NOT NULL,
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
    ADD CONSTRAINT "ConceptosNegocio_PedidoId_fkey" FOREIGN KEY ("PedidoId")
    REFERENCES public."Pedido" ("Pedido_Id") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."ConceptosNegocio"
    ADD CONSTRAINT "ConceptosNegocio_id_dominio_fkey" FOREIGN KEY (id_dominio)
    REFERENCES public."Dominio" (id_dominio) MATCH SIMPLE
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


ALTER TABLE IF EXISTS public."DefinicionesTecnicas"
    ADD CONSTRAINT "DefinicionesTecnicas_ModeloId_fkey" FOREIGN KEY ("ModeloId")
    REFERENCES public."Modelado" ("ID_Modelo") MATCH SIMPLE
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

ALTER TABLE IF EXISTS public."Tarea"
    ADD CONSTRAINT "Tarea_id_empleado_fkey" FOREIGN KEY (id_empleado)
    REFERENCES public."Empleado" (id_empleado) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;

ALTER TABLE IF EXISTS public."RendimientoEmpleado"
    ADD CONSTRAINT "RendimientoEmpleado_id_empleado_fkey" FOREIGN KEY (id_empleado)
    REFERENCES public."Empleado" (id_empleado) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;

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

END;

```
