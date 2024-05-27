```sql
BEGIN;


CREATE TABLE IF NOT EXISTS public."Pedido"
(
    "Pedido_Id" serial NOT NULL,
    "Area_Id" serial NOT NULL,
    "Prioridad_Id" serial NOT NULL,
    "Estado_Id" serial NOT NULL,
    "Pedido_Fecha" date,
    "Pedido_FechaLimite" date,
    PRIMARY KEY ("Pedido_Id")
);

CREATE TABLE IF NOT EXISTS public."Prioridad"
(
    "Prioridad_Id" serial NOT NULL,
    "Prioridad_Tipo" character varying(5),
    "Prioridad_Detalle" character varying(250),
    PRIMARY KEY ("Prioridad_Id")
);

CREATE TABLE IF NOT EXISTS public."Estado"
(
    "Estado_Id" serial NOT NULL,
    "Estado_Tipo" character varying(10),
    PRIMARY KEY ("Estado_Id")
);

CREATE TABLE IF NOT EXISTS public."Area"
(
    "Area_Id" serial NOT NULL,
    "Area_Nombre" character varying(100),
    "Area_Descripcion" character varying(100),
    "Area_Direccion" character varying(50),
    PRIMARY KEY ("Area_Id")
);

CREATE TABLE IF NOT EXISTS public."Migracion"
(
    "Migracion_Id" serial NOT NULL,
    "Pedido_Id" serial NOT NULL,
    "Id_Squad" serial NOT NULL,
    "Id_Tecnologia" serial NOT NULL,
    "Entorno" character varying(50),
    "Fecha_migracion" date,
    "Valido" boolean,
    "Ultimo" boolean,
    PRIMARY KEY ("Migracion_Id")
);

CREATE TABLE IF NOT EXISTS public."Tecnologia"
(
    id_tecnologia serial NOT NULL,
    nombre_tecnologia character varying(50),
    PRIMARY KEY (id_tecnologia)
);

CREATE TABLE IF NOT EXISTS public."Notificacion"
(
    "Notificacion_Id" serial NOT NULL,
    "Pedido_Id" serial NOT NULL,
    "Squad_Id" serial NOT NULL,
    "Notificacion_Fecha" date,
    "Notificacion_Hora" time with time zone,
    "Notificacion_Asunto" character varying(50),
    "Notificacion_Contenido" character varying(250),
    PRIMARY KEY ("Notificacion_Id")
);

CREATE TABLE IF NOT EXISTS public."Empleado"
(
    id_empleado serial NOT NULL,
    nombre character varying(50),
    correo character varying(50),
    "contraseña" character varying(50),
    nivel_acceso character varying(50),
    telefono character varying(20),
    dni character varying(8),
    PRIMARY KEY (id_empleado)
);

CREATE TABLE IF NOT EXISTS public."Cargo"
(
    id_cargo serial NOT NULL,
    nombre_cargo character varying(50),
    PRIMARY KEY (id_cargo)
);

CREATE TABLE IF NOT EXISTS public."Squad"
(
    id_squad serial NOT NULL,
    nombre_squad character varying(50),
    PRIMARY KEY (id_squad)
);

CREATE TABLE IF NOT EXISTS public."Pertenece"
(
    id_pertenece serial NOT NULL,
    "SquadId" bigint NOT NULL,
    "EmpleadoId" bigint NOT NULL,
    "CargoId" bigint NOT NULL,
    PRIMARY KEY (id_pertenece)
);

CREATE TABLE IF NOT EXISTS public."Dominio"
(
    id_dominio serial NOT NULL,
    tipo_dominio character varying(50) NOT NULL,
    PRIMARY KEY (id_dominio)
);

CREATE TABLE IF NOT EXISTS public."Ambiente"
(
    id_ambiente serial NOT NULL,
    nombre_ambiente character varying(100) NOT NULL,
    PRIMARY KEY (id_ambiente)
);

CREATE TABLE IF NOT EXISTS public."Esquema"
(
    id_esquema serial NOT NULL,
    "AmbienteId" serial NOT NULL,
    nombre_esquema character varying(100),
    PRIMARY KEY (id_esquema)
);

CREATE TABLE IF NOT EXISTS public."Modelado"
(
    "ID_Modelo" serial NOT NULL,
    "EsquemaDDV" character varying(200),
    "TablaDDV" character varying(200),
    "CampoDDV" character varying(200),
    "CampoLlave" boolean,
    "Campo_Descarta" boolean,
    PRIMARY KEY ("ID_Modelo")
);

CREATE TABLE IF NOT EXISTS public."DefinicionesTecnicas"
(
    "id_DT" serial NOT NULL,
    "EquivalenciaId" serial,
    "ModeloId" serial,
    "EsquemaId" serial NOT NULL,
    "Tabla" character varying(200),
    "Campo" character varying(100),
    PRIMARY KEY ("id_DT")
);

CREATE TABLE IF NOT EXISTS public."ConceptosNegocio"
(
    "id_CN" serial NOT NULL,
    id_dominio serial NOT NULL,
    subdominio character varying(100),
    id_referencia serial NOT NULL,
    "DefinicionTabla" text,
    "DefinicionCampo" text,
    "PedidoId" serial NOT NULL,
    PRIMARY KEY ("id_CN")
);

CREATE TABLE IF NOT EXISTS public."ReglasDeCarga"
(
    "ID_ReglaCarga" serial NOT NULL,
    id_campo serial NOT NULL,
    id_tecnologia serial NOT NULL,
    detalle_carga text,
    PRIMARY KEY ("ID_ReglaCarga")
);

CREATE TABLE IF NOT EXISTS public."PreCarga"
(
    "ID_Precarga" serial NOT NULL,
    "Nombre_Regla" character varying(30),
    "Detalle_Precarga" character varying(50),
    PRIMARY KEY ("ID_Precarga")
);

CREATE TABLE IF NOT EXISTS public."CargaPreCarga"
(
    "ID_CargaPrecarga" serial NOT NULL,
    "ID_ReglaCarga" serial NOT NULL,
    "ID_Precarga" serial NOT NULL,
    PRIMARY KEY ("ID_CargaPrecarga")
);

CREATE TABLE IF NOT EXISTS public."Reunion"
(
    "Reunion_Id" serial NOT NULL,
    "Id_Empleado" serial NOT NULL,
    "Pedido_Id" serial NOT NULL,
    "TipoReunion_Id" serial NOT NULL,
    "HoraInicio" time with time zone,
    "Horafin" time with time zone,
    "Plataforma" character varying(50),
    "Fecha" date,
    "Estado" character varying(20),
    "Agenda" text,
    "Acuerdos" text,
    PRIMARY KEY ("Reunion_Id")
);

CREATE TABLE IF NOT EXISTS public."RegistroErrores"
(
    "Id_registro_errores" serial NOT NULL,
    "Migracion_Id" serial NOT NULL,
    "Id_error" serial NOT NULL,
    "Id_Empleado" serial NOT NULL,
    "Correcion_error" character varying(50),
    "Fecha_registro" date,
    "Causa_error" character varying(50),
    PRIMARY KEY ("Id_registro_errores")
);

CREATE TABLE IF NOT EXISTS public."TipoError"
(
    "Id_error" serial NOT NULL,
    "Nombre_error" character varying(50),
    PRIMARY KEY ("Id_error")
);

CREATE TABLE IF NOT EXISTS public."Programacion"
(
    "Programacion_Id" serial NOT NULL,
    "Migracion_Id" serial NOT NULL,
    "FrecuenciaEjecucion" character varying,
    "DiaInicio" character varying(50),
    "DiaFin" character varying(50),
    "ConsideracionFrecuencia" character varying(50),
    PRIMARY KEY ("Programacion_Id")
);

CREATE TABLE IF NOT EXISTS public."Campo"
(
    id_campo serial NOT NULL,
    "ID_Modelo" serial NOT NULL,
    "id_TipodeDato" serial NOT NULL,
    valor character varying(100),
    propiedades character varying(250),
    "id_AlgoritmoEnc" serial NOT NULL,
    "id_AlgoritmoEnm" serial NOT NULL,
    PRIMARY KEY (id_campo)
);

CREATE TABLE IF NOT EXISTS public."Algoritmo"
(
    id_algoritmo serial NOT NULL,
    nombre_algoritmo character varying(20),
    descripcion character varying(50),
    "longClave" character varying(10),
    tipo character varying(20),
    PRIMARY KEY (id_algoritmo)
);

CREATE TABLE IF NOT EXISTS public."CampoAsegurado"
(
    "id_CampoAsegurado" serial NOT NULL,
    id_admin serial NOT NULL,
    id_campo serial NOT NULL,
    PRIMARY KEY ("id_CampoAsegurado")
);

CREATE TABLE IF NOT EXISTS public."Reporte"
(
    id_reporte serial NOT NULL,
    id_admin serial NOT NULL,
    id_usuario serial NOT NULL,
    detalles character varying(50),
    fecha date,
    formato character varying(15),
    PRIMARY KEY (id_reporte)
);

CREATE TABLE IF NOT EXISTS public."TipoDato"
(
    "id_TipoDeDato" serial NOT NULL,
    "Nombre" character varying(200),
    "Nivel de acceso" character varying(200),
    "Enmascarado" boolean,
    "Encriptación" boolean,
    PRIMARY KEY ("id_TipoDeDato")
);

CREATE TABLE IF NOT EXISTS public."Reporte_Conformidad"
(
    "Reporte_Id" serial NOT NULL,
    "Estado" character varying(50),
    "Fecha" date,
    PRIMARY KEY ("Reporte_Id")
);

CREATE TABLE IF NOT EXISTS public."Tipo_Reunion"
(
    "TipoReunion_Id" serial NOT NULL,
    "Nombre" character varying(50),
    "Descripcion" text,
    PRIMARY KEY ("TipoReunion_Id")
);

CREATE TABLE IF NOT EXISTS public."Recordatorio"
(
    "Recordatorio_Id" serial NOT NULL,
    "Reunion_Id" serial NOT NULL,
    "TipoRecordatorio_Id" serial NOT NULL,
    "Hora" time with time zone,
    "Fecha" date,
    PRIMARY KEY ("Recordatorio_Id")
);

CREATE TABLE IF NOT EXISTS public."Tipo_Recordatorio"
(
    "TipoRecordatorio_Id" serial NOT NULL,
    "Nombre" character varying(50),
    "Descripcion" text,
    "Mensaje" text,
    PRIMARY KEY ("TipoRecordatorio_Id")
);

CREATE TABLE IF NOT EXISTS public."Participante"
(
    "Participante_Id" serial NOT NULL,
    "Area_Id" serial NOT NULL,
    "Nombre" character varying(100),
    "Apellido" character varying(100),
    "Correo" character varying(100),
    PRIMARY KEY ("Participante_Id")
);

CREATE TABLE IF NOT EXISTS public."Participa_en"
(
    "Id_Participa_en" serial NOT NULL,
    "Reunion_Id" serial NOT NULL,
    "Participante_Id" serial NOT NULL,
    PRIMARY KEY ("Id_Participa_en")
);

CREATE TABLE IF NOT EXISTS public."Recordatorio_Enviado"
(
    "Id_RecordatorioEnviado" serial NOT NULL,
    "Recordatorio_Id" serial NOT NULL,
    "Participante_Id" serial NOT NULL,
    PRIMARY KEY ("Id_RecordatorioEnviado")
);

CREATE TABLE IF NOT EXISTS public."Reunion_Reporte_Conformidad"
(
    "Id_Reu_Rep" serial NOT NULL,
    "Reporte_Id" serial NOT NULL,
    "Reunion_Id" serial NOT NULL,
    PRIMARY KEY ("Id_Reu_Rep")
);

ALTER TABLE IF EXISTS public."Pedido"
    ADD FOREIGN KEY ("Area_Id")
    REFERENCES public."Area" ("Area_Id") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."Pedido"
    ADD FOREIGN KEY ("Prioridad_Id")
    REFERENCES public."Prioridad" ("Prioridad_Id") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."Pedido"
    ADD FOREIGN KEY ("Estado_Id")
    REFERENCES public."Estado" ("Estado_Id") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."Migracion"
    ADD FOREIGN KEY ("Pedido_Id")
    REFERENCES public."Pedido" ("Pedido_Id") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."Migracion"
    ADD FOREIGN KEY ("Id_Squad")
    REFERENCES public."Squad" (id_squad) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."Migracion"
    ADD FOREIGN KEY ("Id_Tecnologia")
    REFERENCES public."Tecnologia" (id_tecnologia) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."Notificacion"
    ADD FOREIGN KEY ("Pedido_Id")
    REFERENCES public."Pedido" ("Pedido_Id") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."Notificacion"
    ADD FOREIGN KEY ("Squad_Id")
    REFERENCES public."Squad" (id_squad) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."Pertenece"
    ADD FOREIGN KEY ("SquadId")
    REFERENCES public."Squad" (id_squad) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."Pertenece"
    ADD FOREIGN KEY ("EmpleadoId")
    REFERENCES public."Empleado" (id_empleado) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."Pertenece"
    ADD FOREIGN KEY ("CargoId")
    REFERENCES public."Cargo" (id_cargo) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."Esquema"
    ADD FOREIGN KEY ("AmbienteId")
    REFERENCES public."Ambiente" (id_ambiente) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."DefinicionesTecnicas"
    ADD FOREIGN KEY ("EquivalenciaId")
    REFERENCES public."DefinicionesTecnicas" ("id_DT") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."DefinicionesTecnicas"
    ADD FOREIGN KEY ("ModeloId")
    REFERENCES public."Modelado" ("ID_Modelo") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."DefinicionesTecnicas"
    ADD FOREIGN KEY ("EsquemaId")
    REFERENCES public."Esquema" (id_esquema) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."ConceptosNegocio"
    ADD FOREIGN KEY (id_dominio)
    REFERENCES public."Dominio" (id_dominio) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."ConceptosNegocio"
    ADD FOREIGN KEY (id_referencia)
    REFERENCES public."DefinicionesTecnicas" ("id_DT") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."ConceptosNegocio"
    ADD FOREIGN KEY ("PedidoId")
    REFERENCES public."Pedido" ("Pedido_Id") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."ReglasDeCarga"
    ADD FOREIGN KEY (id_campo)
    REFERENCES public."Campo" (id_campo) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."ReglasDeCarga"
    ADD FOREIGN KEY (id_tecnologia)
    REFERENCES public."Tecnologia" (id_tecnologia) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."CargaPreCarga"
    ADD FOREIGN KEY ("ID_ReglaCarga")
    REFERENCES public."ReglasDeCarga" ("ID_ReglaCarga") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."CargaPreCarga"
    ADD FOREIGN KEY ("ID_Precarga")
    REFERENCES public."PreCarga" ("ID_Precarga") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."Reunion"
    ADD FOREIGN KEY ("Id_Empleado")
    REFERENCES public."Empleado" (id_empleado) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."Reunion"
    ADD FOREIGN KEY ("Pedido_Id")
    REFERENCES public."Pedido" ("Pedido_Id") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."Reunion"
    ADD FOREIGN KEY ("TipoReunion_Id")
    REFERENCES public."Tipo_Reunion" ("TipoReunion_Id") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."RegistroErrores"
    ADD FOREIGN KEY ("Migracion_Id")
    REFERENCES public."Migracion" ("Migracion_Id") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."RegistroErrores"
    ADD FOREIGN KEY ("Id_error")
    REFERENCES public."TipoError" ("Id_error") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."RegistroErrores"
    ADD FOREIGN KEY ("Id_Empleado")
    REFERENCES public."Empleado" (id_empleado) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."Programacion"
    ADD FOREIGN KEY ("Migracion_Id")
    REFERENCES public."Migracion" ("Migracion_Id") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."Campo"
    ADD FOREIGN KEY ("ID_Modelo")
    REFERENCES public."Modelado" ("ID_Modelo") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."Campo"
    ADD FOREIGN KEY ("id_AlgoritmoEnc")
    REFERENCES public."Algoritmo" (id_algoritmo) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."Campo"
    ADD FOREIGN KEY ("id_AlgoritmoEnm")
    REFERENCES public."Algoritmo" (id_algoritmo) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."Campo"
    ADD FOREIGN KEY ("id_TipodeDato")
    REFERENCES public."TipoDato" ("id_TipoDeDato") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."CampoAsegurado"
    ADD FOREIGN KEY (id_admin)
    REFERENCES public."Empleado" (id_empleado) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."CampoAsegurado"
    ADD FOREIGN KEY (id_campo)
    REFERENCES public."Campo" (id_campo) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."Reporte"
    ADD FOREIGN KEY (id_admin)
    REFERENCES public."Empleado" (id_empleado) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."Reporte"
    ADD FOREIGN KEY (id_usuario)
    REFERENCES public."Empleado" (id_empleado) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."Recordatorio"
    ADD FOREIGN KEY ("Reunion_Id")
    REFERENCES public."Reunion" ("Reunion_Id") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."Recordatorio"
    ADD FOREIGN KEY ("TipoRecordatorio_Id")
    REFERENCES public."Tipo_Recordatorio" ("TipoRecordatorio_Id") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."Participante"
    ADD FOREIGN KEY ("Area_Id")
    REFERENCES public."Area" ("Area_Id") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."Participa_en"
    ADD FOREIGN KEY ("Reunion_Id")
    REFERENCES public."Reunion" ("Reunion_Id") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."Participa_en"
    ADD FOREIGN KEY ("Participante_Id")
    REFERENCES public."Participante" ("Participante_Id") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."Recordatorio_Enviado"
    ADD FOREIGN KEY ("Recordatorio_Id")
    REFERENCES public."Recordatorio" ("Recordatorio_Id") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."Recordatorio_Enviado"
    ADD FOREIGN KEY ("Participante_Id")
    REFERENCES public."Participante" ("Participante_Id") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."Reunion_Reporte_Conformidad"
    ADD FOREIGN KEY ("Reunion_Id")
    REFERENCES public."Reunion" ("Reunion_Id") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public."Reunion_Reporte_Conformidad"
    ADD FOREIGN KEY ("Reporte_Id")
    REFERENCES public."Reporte_Conformidad" ("Reporte_Id") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;

---Estos son correcciones que hize despues de creadas las tablas, mas que todo en el tipo de variable.
	
ALTER TABLE public."Algoritmo" ALTER COLUMN descripcion TYPE text;
ALTER TABLE public."Algoritmo" ALTER COLUMN nombre_algoritmo TYPE character varying(200);
ALTER TABLE public."Algoritmo" ALTER COLUMN "longClave" TYPE character varying(200);
ALTER TABLE public."Algoritmo" ALTER COLUMN tipo TYPE character varying(200);
ALTER TABLE public."DefinicionesTecnicas" ALTER COLUMN "EquivalenciaId" DROP NOT NULL;
ALTER TABLE public."PreCarga" ALTER COLUMN "Detalle_Precarga" TYPE character varying (200);
ALTER TABLE public."PreCarga" ALTER COLUMN "Nombre_Regla" TYPE character varying (200);
ALTER TABLE public."RegistroErrores" ALTER COLUMN "Id_Empleado" DROP NOT NULL;

END;
```
