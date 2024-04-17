# Glosario de datos

| N° |     Término     |      Definición     |
|----|---------------- | ------------------- |  
| 1 | Documento de Alcance | Es aquel documento que sirve para garantizar la migración de datos. |         
| 2  |Tipo referencia  | Ambiente dónde se encuentra la tabla que es referencia para la carga DDV. |
| 3  |Esquema referencia | Esquema de la tabla que es referencia para la carga DDV. (Ej. Si el ambiente es Oracle, el esquema será: ODS, EDS, BDS, etc.) |
| 4  |Tabla referencia | Indica la entidad, tabla o broad mapeada, puede encontrarse en ambientes DWH, Sandbox o reportes. |
| 5  |Campo referencia | Campo asociado a la entidad, tabla o broad. |
| 6  |Dominio | Owner de la información. |
| 7  |Subdominio | Agrupamientos de información específicos a cargo de distintos equipos dentro del dominio. |
| 8  |Usuario Origen | Cliente interno del área que requiere la migración de datos. |
| 9  |Usuario Destino | Cliente interno del área a la que se va a migrar los datos |
| 10 | ODS | Operational Data Store: Es un repositorio de datos que se actualiza con frecuencia y que se utiliza para dar soporte a las aplicaciones y procesos de negocio. |
| 11 | EDS | Enterprise Data Store: Es un repositorio de datos centralizado que integra datos de diferentes fuentes dentro de una organización. |
| 12 | BDS | Business Data Store: Es un repositorio de datos que se utiliza para dar soporte a las necesidades de análisis e inteligencia de negocio.|
| 13  | Data WareHouse | “Almacén de Datos”,  su diferencia con una base de datos tradicional es que los datos se preparan para un facil análisis y la buena toma de decisiones. Además la información no se pierde ni se modifica, guarda un registro histórico|
| 14 |Data Lake| Es una plataforma de almacenamiento de datos, con cualquier tipo de estructura, se almacenan en su formato "raw" sin propósito definido, la arquitectura del BCP divide al Data Lake en 4 capas: RDV, UDV, DDV, EDV |
| 15 | RDV |Raw Data Vault, donde los datos se almacenan en una estructura simple sin ningún o poca modificación desde sus sistemas de origen "directo desde el broad", esto permitía que toda la información se tenga disponible en todo momento en esta zona, de tal manera que el time to market de los proyectos de data sea menor.|
| 16 | UDV |Universe Data Vault, en esta zona se encuentran ya los datos modelados, si bien no tienen una estructura muy normalizada, aquí se encuentran los datos ya disponibles para ser consumidos con los controles de gobierno y calidad definidos e implementadosm, todo es público a la organización
| 17 | DDV |Dimensional Data Vault, es lo más similar a los datamarts, se encuentra la información que puede ser consumida o generada por una determinada área de negocio, en caso se generen datos importantes para la organización ésta se trasladaba luego al Universal Data.
| 18 | EDV |Son los sandbox administrados, se crean por un tiempo determinado para que puedan probar la validez de una determinada hipótesis en base a datos y luego esta zona se elimina.
| 19 | Datamart |Subconjunto de un almacén de datos centrado en una línea de negocio (información específica)
| 20 | Data PipeLine | Datos de un sistema a otro, aplicando reglas y procesamiento de datos, transforma Raw Data en Data lista para hacer análisis, machine learning etc.

---

[Regresar al Entregable 2](../entregable2.md)

[Regresar al índice](../../README.md)