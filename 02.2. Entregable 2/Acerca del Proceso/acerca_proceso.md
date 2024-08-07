# Migración de Analítica de Datos

## Principal servicio ofrecido

La migración de datos, esto se refiere a la transferencia de datos entre diferentes tipos de formatos de archivos, esquemas de bases de datos y sistemas de almacenamiento. Incluye asignaciones y transformaciones entre datos de origen y de destino si los datos son diversos.

Primero, se recibe la información _desordenada_.

Luego pasa por **calidad de datos**, debe evaluarse antes de la migración para garantizar una implementación exitosa sin pérdida de datos. La tasa de éxito de cualquier proyecto de migración de datos depende de la diversidad, el volumen y la calidad de los datos que se transfieren.

Por último, se entrega la información estructurada. Por información nos refirimos a tablas, aplicaciones, scores (conjunto de datos relacionados con un fin: perfil cliente, tipo de préstamo (hipotecario, vehicular, personal), etc).

## Responsables del proceso

**1. Data architec:** Estructura el flujo de información de inicio a fin.

**2. Data governance:** Solicita, recibe y transforma la información del usuario origen. Relevamiento de información.

**3. Data modeler:** Modelar los objetos (esquemas, tablas, base de datos, etc).

**4. Data engneer:** Recibe la info del data governance y en base al modelamiento de datos crea las tablas con sus respectivos esquemas dentro de DB.

**5.Data quality:** Responsable de verificar que lo que hizo el data engieneer en base a lo proporcionado por el data governance es correcto.

## Descripción del proceso

Procesos para migrar datos en base a los roles:

- [Ver el Flujograma Completo en LucidChart](https://lucid.app/lucidchart/29fab1dd-40e5-4da9-84bc-d9a41e26717b/edit?viewport_loc=-9379%2C-1461%2C8710%2C3790%2C0_0&invitationId=inv_ad1e5fc2-becf-482e-b4bc-954471623807)

<img src="Flujograma Corregido.png" alt="DiagramaDeFlujo" style="width: 100%; height: auto;"/>


### Proceso AS-IS

| Secuencia | Actividad                                          | Descripción         | Responsable  |
| --------- | -------------------------------------------------- | ------------------- | ------------ |
| 1         | Elaborar Documento de Alcance DDV | Este paso representaría la intención de crear o modificar un documento de alcance DDV a pedido de un usuario origen o por alguna modificación que quiera hacer un integrante del squad encargado de esta tarea. De acuerdo con lo que se necesita hacer, se va a crear un nuevo documento o se va a modificar uno ya existente. | Data Steward |
| 2         | Tomar última versión del documento DDV | Si lo que se quiere es solo agregar o modificar campos, se tomará la última versión del documento  que se encuentra en el Sharepoint. | Data Steward |
| 3         | Generar nuevo documento DDV | Si se quiere agregar tablas nuevas o el formato de la última versión que se encuentra en el Sharepoint no es el actual, se descarga una plantilla del Documento de Alcance de la plataforma Confluence (plataforma virtual de BCP) para apartir de allí crear un nuevo Documento de Alcance | Data Steward |
| 4         | Ingresar historial de versiones | En el documento de Alcance, en una sección del Excel, se especificará qué versión es la modificación que se está haciendo. Asimismo, se tiene que detallar cuál ha sido, en qué fecha se realizó los cambios, cuál Squad lo ha hecho, qué miembro del Squad lo ha hecho y quién fue que solicitó el cambio. Si es la primera versión del documento, esto será solo de llenado de datos| Data Steward |
| 5         | Solicitar actualización de la lista de desplegables | En caso de que se haya validado que los parámetros del documento de alcance contienen errores, se le solicita al Data Governance Expert la actualización de los parámetros de la lista de desplegables relacionada. | Data Steward |
| 6         | Actualizar lista de desplegables | Se agrega el nuevo valor al campo relacionado con la lista desplegable, esto se realiza en un documento excel aparte denominado "DA-parámetros" que se relacionará con el excel del documento de alcance DDV. | Data Gobernance Expert |
| 7         | Ingresar información general y de referencia | Se empieza con el llenado del excel del documento de alcance DDV, primero completamos la sección de "información general" que incluye los datos de los responsables del DA que se esta ejecutando. Luego, se llena la sección de referencia, dónde se encuentra el tipo de referencia, esquema de referencia, la tabla de referencia y el campo de referencia, que indica el origen de los datos en base a los cuales se hará la migración. | Data Steward |
| 8         | Ingresar conceptos de negocio | Se ingresa información en los campos del primer bloque del documento de alcance DDV, que incluye el dominio, subdominio, producto de datos, la historia, es decir desde cuando se tiene la información disponilble, y por ultimo el nombre del dato junto con su definición.   | Data Steward |
| 9       | Buscar y colocar información equivalente de las referencias | A partir de los datos del campo de referencias del DWH, se busca su equivalente respectivo en el DLK para que sea posible la migración.  | Custodio Técnico |
| 10         | Ingresar información del modelo DDV | Se define la tabla, campos y llaves del modelo final en DDV. | Data Modeler |
| 11        | Definición del Universo | Existen dos tipos, Universo Orientado a cuentas y Universo orientado a clientes, la definición se hace conforme a eso, el Custodio técnico Socializa con el Usuario Origen para conocer sus requerimientos, en palabras, el luego define un código SQL que para conseguir los usuarios (o cuentas) del DataLake que cumplan dichos requerimientos. Este Universo es único para todo el documento DDV (todos los campos a migrar). Toda esta definición se coloca en una sola celda de excel y se copia para cada campo y debe estar explicada paso a paso en lenguaje sencillo para el entendimiento del usuario de negocio | Custodio técnico |
| 12        | Definir reglas funcionales de pre carga y carga | Las reglas de carga consisten en usar las tablas equivalentes encontradas y colocadas en las definiciones técnicas, junto con el Universo. Lo que se hace es realizar un Left Join Entre el Universo y dicha tabla, junto con un select del campo que se migrará al Tablón definido en DDV. Las reglas de precarga son un filtro, que se hace luego de haber encontrado los campos que irán al tablón, se aplican a criterio del Squad, excepto el de Validación de Unicidad que si es Obligatorio, solo se hace al campo definido antes como Primary Key. Las reglas de carga son definidas para cada campo, y se colocan en una sola celda e excel| Data Steward |
| 13        | Definir reglas técnicas de pre carga | Todo lo anterior fue realizado en pseudocódigo o similar, por lo que el custodio técnico lo traduce a lenguaje técnico (código) para ser evaluado posteriormente, importante considerar que este debe estar explicado en pasos secuenciales con lenguaje sencillo entendible para el usuario de negocio| Custodio Técnico |
| 14        | Complementar definciones técnicas | Se trata de la evaluación de lo codificado por el Custodio técnico, el Data Engineer lo traduce a PySpark donde ejecuta el Query, verificando si obtiene lo que debería obtener, en caso no obtenga le devuelve el código al custodio para que lo corrija (Se establece un ida y vuelta). Este paso no es solo una revisión sino que un complementación, el Data Engineer también debe optimizar el código del custodio, en caso sea necesario. | Data Engineer |
| 15        | Elaborar lógica pre carga | Tras el paso anterior, la lógica es elaborada es formalmente elaborada fuera del excel | Data Engineer |
| 16        | Registrar seguridad de datos y consumo de aplicativo | El Data Steward junto con el Custodio Técnico colaboran para ver si un campo es DAC o si tiene alguna Frecuencia de actualización. Esto se realiza generalmente revisando documentos proporcionados por el usuario, que suelen ser documentos de interfaz. En caso de no contar con estos documentos, se organiza una reunión para obtener la información necesaria. Con respecto al consumo aplicativo, se llena sólo si aplica para su caso de negocio (normalmente NO APLICA). | Data Steward |
| 17        | Evaluar criticidad de los datos | Se elige entre dos opciones de la lista desplegable: EDC (Elemento de Dato Crítico) o EDNC (Elemento de Dato No Crítico). Los campos marcados como datos críticos (EDC) son aquellos que, a pesar de posibles inconvenientes como duplicaciones, deben ser necesariamente admitidos según la solicitud del usuario. Esto se debe a que el rechazo de estos campos podría afectar aspectos del negocio, por lo que se hace esa excepción. De igual manera, estos no deben superar el 20% del total de la tabla. | Data Steward |
| 18        | Actualizar Documento de Alcance DDV | En caso hayan nuevos datos críticos, se actualiza el documento de alcance ubicado en el Sharepoint.Luego de ello, ya se tendría un documento de alcance preliminar listo para su validación.| Data Engineer |
| 19        | Ingresar información adicional de proceso | Antes de la Validación, se debe completar la siguiente información a nivel tabla: La tabla DDV, Codigo del proceso, Nombre del proceso, Nombre del Job@, la ruta de la tabla y las Definiciones técnicas. Todos ellos siguiendo los lineamientos establecidos. | Data Engineer |
| 20        | Corregir errores de modelamiento | El data modeler tiene que dar la validación en base a las modificaciones realizadas por el data engineer en el proceso anterior, este le indicará los cambios y errores que encuentre. Luego de ser verificado por el data modeleer se pasará a la revisión por el Data Steward. | Data Modeler |
| 21        | Validar Documento de Alcance con macro | Proceso encargado por el data steward, en la cual una vez culminado el llenado del documento de alcance y validar si se ha ingresado todos los campos obligatorios se debe dar clic en el botón “Validar DA DDV” . Los tipos de validación son: Validación de esquema validación de longitud y no nulidad, validación de dominio de datos, validación de fuentes.| Data Steward |
| 22        | Corregir errores | En caso se encuentre un atributo obligatorio sin información, se mostrará el mensaje “Se identifica errores en algunos campos, revisar el resultado de validación”, luego de aceptar le saldrá la hoja “validación” y se mostrará los campos con error. En caso todos los atributos obligatorios del documento de alcance se encuentren con información, se mostrará el mensaje “validación conforme”. | Data Steward |
| 23        | Generar Metadata y Linaje | Trazabilidad de los errores presentados en todo el proceso con una explicación del error presentado | Data Steward |
| 24        | Actualizar Documento de Alcance DDV | Se actualiza el documento de alcance libre de errores para la posterior revisión del Data Steward Senior | Data Gobernance Expert |
| 25         | Revisar documentos de Alcance DDV | Validación de los documentos de alcance presentando observaciones (generalmente no se encuentran errores en este punto) | Data Steward Senior |
| 26        | Actualizar Governance Catalog | Se suben los documentos de alcance a InfoSphere Information Governance Catalog, que es una herramienta de IBM para el gobierno de datos | Data Steward |

### Proceso TO-BE

| Secuencia | Actividad                                          | Descripción         | Responsable  |
| --------- | -------------------------------------------------- | ------------------- | ------------ |
| 3         | Generar nuevo documento DDV | Si se quiere agregar tablas nuevas, se debe generar un nuevo documento a partir de la plantilla que el sistema te va a dar. | Data Steward |
| 4         | Ingresar historial de versiones | En el sistema, se detallará sobre la versión del documento. Se debe especificar qué cambios se va realizar y por quien fue solicitado esos cambios.| Data Steward |
| 6         | Actualizar lista de desplegables | Se agrega el nuevo valor al campo relacionado con la lista desplegable, en la base de datos. | Data Gobernance Expert |
| 9       | Buscar y colocar información equivalente de las referencias | El sistema buscará automáticamente las equivalencias de la información de referencia en una base de datos interna y mostrará una tabla con los resultados a la que el usuario podrá acceder. | Data Steward |
| 11        | Definición del Universo | Esta definición se hará en una pantalla específica para ello donde se facilite ver los requerimientos de los clientes, también se facilitará el escribir los pasos del codigo. | Custodio técnico |
| 12        | Definir reglas funcionales de pre carga y carga | Se facilitara el escribir el pseudocódigo de la regla de carga teniendo acceso a tanto el Universo, la tabla equivalente y el tablón. Para las reglas de precarga se podrán ver las reglas aplicadas y una breve descripción de las que se podrá usar, según el caso de uso.  | Data Steward |
| 13        | Definir reglas técnicas de pre carga | Esta definición se hará en una pantalla específica para ello donde se facilite ver el pseudocódigo de estas reglas de carga, así como el Universo, la tabla equivalente, y el esquema del Tablón en DDV | Custodio Técnico |
| 14        | Complementar definciones técnicas | El Envío de las reglas de carga y del Universo se implementarán con un botón de envío.| Data Engineer |
| 15        | Elaborar lógica pre carga | No se harán modificaciones | Data Engineer |
| 16        | Registrar seguridad de datos | El usuario selecciona en "Vincular con Doc de Interfaz" y el sistema hará la clasificación y mostrará los cambios que hizo. | Data Steward |
| 19        | Ingresar información adicional de proceso | El usuario deberá completar la siguiente información a nivel tabla: La tabla DDV, Codigo del proceso, Nombre del proceso, Nombre del Job@, la ruta de la tabla y las Definiciones técnicas. | Data Engineer |


[Glosario](GlosarioDatos.md)

---

[Regresar al Entregable 2](../entregable2.md)

[Regresar al índice](../../README.md)
