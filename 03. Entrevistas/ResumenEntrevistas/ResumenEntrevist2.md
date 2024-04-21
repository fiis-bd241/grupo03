* Data Engineer, Responsable de la carga y mantenimiento de los datos
* Data Modeler, Responsable del modelamiento en las diversas capas del Data Lake
* Data Governance, Responsable de la definición e implementación del gobierno de datos y controles de calidad
* Data Architect, Responsable de la definición de la arquitectura de datos general y de cada proyecto así como de las políticas que lo gobiernan
* Data Owner, Responsable de la gestión efectiva de cada dominio de datos, naturalmente debía ser un gerente del área responsable
* Data Steward, Responsable de la gestión de la calidad del dato y definición de nuevos elementos de datos, si se crearon nuevos
Migración de datos para el BCP: Forma Local -> Nube
Lo que está en los servidores del banco hacia la nube, para mayor velocidad de ejecución de querys, ahorro de recursos, etc.
# EXPLICACIÓN FLUJOGRAMA DOCUMENTO DE ALCANCE DDV
<center><img src=".\Recursos\Flujograma p1.png"/></center>
Pregunta si la tabla es nueva porque a veces no lo es. Trabajan con un sistema de versiones, donde la primera versión es el primer llenado del documento
<center><img src=".\Recursos\Flujograma p2.png"/></center>
Posteriormente, a pedido del usuario origen, se pueden agregar campos a la tabla, osea:

Al inicio se tiene una tabla de 10 campos a migrar, de la que se hace el documento de alcance, a pedido del usuario origen (área anterior) se agregan más campos, en ese caso se generaría una nueva versión a partir de la última versión del documento.
> “El documento cambia poco (contenido) pero muchas veces, es cambiante en el tiempo”
<center><img src=".\Recursos\Flujograma p3.png"/></center>
Como los DA son cambiantes en el tiempo, puede que antes haya sido elaborado en un formato anterior (plantilla) y ahora esté en otro distinto, en ese caso se buscaría la nueva plantilla en confluence. Esto también se guarda en el historial de versiones (uno específico para la plantilla)
<center><img src=".\Recursos\Flujograma p4.png"/></center>
En todo caso, se hacen los cambios en un duplicado del documento original, que se ingresa en el historial de versiones.
<center><img src=".\Recursos\Flujograma p5.png"/></center>
Parámetros del DA: Parámetros del documento de alcance

Ejemplos:

*Parámetros de validación*: Validar DA DDV, Generar Metadata, Generar archivo de linaje, actualizar parámetros.

*Otro parámetro*: Lo que dice en el dato debe estar dentro de la lista de desplegables para ese campo.

Si no correspondiera, se debe añadir a esa lista, que está en un excel aparte.
<center><img src=".\Recursos\Flujograma p6.png"/></center>
Esto lo hace el Data Governance Expert (tiene el deber de que todo lo que esté en la plantilla esté actualizado y correcto)
<center><img src=".\Recursos\Roles.png"/></center>
Data Governance Expert y Data Steward Senior, son más que nada verificadores y validadores
<center><img src=".\Recursos\Squad.png"/></center>
Así funciona la estructura de roles de acuerdo al desarrollo del DA.

>Gobierno de datos es más que nada CT y DS (Antes no existía la diferencia)
>
>Data Stewart: Parte administrativa del negocio
>
>Custodio técnico:  Parte técnica del negocio
>
>No es que si yo no hago un DA DDV, el UDV no me va a funcionar, hay veces que no se usa el UDV y se pasa directo al DDV.
<center><img src=".\Recursos\Flujograma p7.png"/></center>
Llenar lo que ya se sabe, lo que ya se tiene a la mano (conceptos de negocio(referencias, definición etc)) que ya dio el usuario de origen mediante el documento de entrada.
<center><img src=".\Recursos\EjmTabla1.png"/></center>
El Custodio se encarga de encontrar la tabla equivalente en base a la información de referencia, en caso no hubiera ("NO APLICA") El Data modeler creará el campo en DDV en base a la definición del campo
<center><img src=".\Recursos\Flujograma p8.png"/></center>
Apartir de las referencias (que da el usuario)
<center><img src=".\Recursos\EjmTabla2.png"/></center>

>***Ejemplo***: De esas 2 tablas, quiero que busques su referencia en el Data Lake y me generes una única tabla (Tablón)
<center><img src=".\Recursos\EjmTabla3.png"/></center>

Se encuentran las Equivalencias (Data Warehouse (Oracle) - DataLake (Azure)) y se colocan en la tabla azul Esto lo hace el custodio técnico

***Cómo se busca:*** Se recomienda empezar buscando la equivalencia de la tabla, existe una tabla de equivalencias (Antes era un excel ahora es  Sistema(un archivo vivo)) te dice esta tabla (Data WareHouse) tiene su equivalencia en Lake, o te da más de una y tu elijes de acuerdo a los campos.

**Ahora ya no trabajaremos con la información de referencia, sino con lo obtenido en las definiciones técnicas.**
<center><img src=".\Recursos\Flujograma p9.png"/></center>
El Data Modeler creará el Tablón.
***Tablón***: Solo el diseño, el modelo, a partir de esto el Data Engineer puede hacer su chamba, pues tiene los nombres (campo, tabla, esquema).
Además, los nombres se colocan de acuerdo a los lineamientos propios de los Data Modeler

## CÓMO SE RELLENA EL TABLON
<center><img src=".\Recursos\EjmTabla4.png"/></center>

> ***Siguiendo con el ejemplo***: Usando las equivalencias el Data Modeler se guía (ve de donde sacar la información), se pregunta, ¿Cómo enlazo esta tabla (md_direccioncontacto) con la otra parte(h_deudorsbsdetalle) para generar el tablón? Respuesta: Con las llaves
<center><img src=".\Recursos\Flujograma p10.png"/></center>

### SOBRE LA LÓGICA DE DEFINICIÓN DEL UNIVERSO
Lo hace el custodio técnico sobre el Data Lake
Puede ser a:
***Nivel Cuenta:*** No interesa como tal la existencia del cliente, sino la existencia de sus cuentas de banco (datos), si puede existir cliente en la tabla, pero no es relevante. 

***Nivel Cliente:***  Información en general acerca del cliente
>En la definición del universo definimos, en caso sea a nivel cliente, todos los clientes que queramos pasar a la tabla antes diseñada por el Data Modeler, est¡a definición es como codigo SQL o pseudocódigo

***¿Cómo se determina la definición del Universo?***

El usuario origen te da sus requerimientos.
>***Siguiendo con el ejemplo***: Imaginemos que el Usuario origen nos dice, mira quiero que este tablon que tu compañero data modeler creó, tenga a todos los usuarios castigados ( que deben) o te dice, quiero todos los que tengan un juicio. El Custodio técnico se encarga de convertir esto en CODIGO. 

**En cada Documento DDV, el universo es único..**
**El universo está compuesto con los codclavepartycli**
<center><img src=".\Recursos\Flujograma p11.png"/></center>

### REGLAS DE CARGA
Se construyen de acuerdo a lo que necesite el usuario. 

**¿Diferencia con el universo?**
<center><img src=".\Recursos\EjmTabla5.png"/></center>
Volvemos al paso de busqueda de campos equivalentes.

¿Qué hicimos allí? Buscamos campos en el Data Lake que eran equivalentes a los del Data Warehouse.

Entendamos que estos campos encontrados en el Data Lake (Nube) siempre (bueno no siempre) tienen más datos de los que el cliente origen solicitó.

Obs: Si tuviera solo los datos que solicitó el cliente, no sería necesario aplicar una regla de carga.

***¿Cómo obtenemos en el tablón los datos de cada campo que solicitó el cliente?***

Usaremos el campo equivalente que encontramos para determinado campo de referencia y usaremos el ya definido UNIVERSO.

La idea es ir seleccionando campo por campo de la tabla resultante al hacer un ***Left Join*** donde la tabla A sería el Universo y la tabla B sería la tabla equivalente que contenga dicho campo equivalente.
***Left Join:***
<center><img src=".\Recursos\Left Join.png"/></center>
Haciendo este Left Join se obtiene una tabla con los datos que queremos del cliente y con un comando select tenemos ese campo del tablón que necesitamos.

***OBS***: Se carga campo por campo
>***Siguiendo con el ejemplo***: El Custodio técnico ya definió tu universo de clientes morosos, y el Data Engineer ya encontró la tabla equivalente (campos equivalentes) ahora tu quieres tener esos campos equivalentes pero solo de tus clientes morosos (tu universo) por lo que harías un left join
### REGLAS DE PRECARGA
En las reglas de carga veíamos las formas de conseguir los datos requeridos por el cliente para cargarla al tablón en DDV, pero falto un paso importante: La calidad estos datos que se cargan.
>***Tablas Rejected***: Contiene la información de los registros que no cumplieron las reglas de carga usadas.
---
#### TIPOLOGÍA DE TABLAS:
* ***Tablas FACT***: En un esquema dimensional de un DataWarehouse, contiene los valores de las medidas de negocio o dicho de otra forma los indicadores de negocio. 
* ***Tablas Look Up (De búsqueda)***: Contiene una columna identificatoria (id) y, si existe, una columna de descripción del atributo que representa
* ***Tabla maestra:*** Tabla Independiente a la q están enlazadas una o más tablas
---
Esta calidad se ve con las reglas de precarga, a las que son sometidos los campos del tablón (modelo DDV).

Para esto tenemos una regla de precarga obligatoria:
- ***VALDACIÓN UNICIDAD:***
<center><img src=".\Recursos\ValidacionUnicidad.png"/></center>
Al campo que será primary Key del tablón se le somete

>Las demás reglas de carga son a criterio del Squad, dependiendo del caso de uso.
<center><img src=".\Recursos\Flujograma p12.png"/></center>
La codificación de lo hallada anteriormente (lo hace el custodio técnico)
<center><img src=".\Recursos\Flujograma p13.png"/></center>
Luego de completar las definiciones técnicas, se valida con el Data Engineer, el gobierno de datos le proporciona la información para que el ejecute la query. (Primero lo pasan a Python PySpark)

El gobierno puede ejecutarlo en el Databricks y corre todo bien.

Pero si ellos lo ejecutan y no les sale lo mismo, vuelven al data gobernance a ver si algo falló en lo que hicieron, si nada falló los Data Engineers corrigen el suyo.
>El trabajo de los Data Engineers es traducir a su lenguaje y optimizar (y completar) el codigo que les llega de las definiciones técnicas. Por ello es una complementación.
Ejemplo: Universo muy largo, lo voy a optimizar, esto se socializa, se pacta una reunión.
<center><img src=".\Recursos\Flujograma p14.png"/></center>
Aquí el Data Engineer elabora la lógica, ya fuera de excel, lo hacen en PySpark.

**Y se lo pasan al Data Steward**
<center><img src=".\Recursos\Flujograma p15.png"/></center>
Idealmente el usuario origen tuvo que poner en el documento de interfaz de entrada la relación de los campos (o datos) críticos al cliente, sino en todo caso, se socializa con el para preguntar.
<center><img src=".\Recursos\EjmTabla6.png"/></center>

Así se rellena el primer campo si es o no es DAC.
<center><img src=".\Recursos\Flujograma p16.png"/></center>

* ***Segundo campo, Dato crítico:*** El usuario origen indica que datos son críticos **(si o si se deben subir, hayan pasado o no las reglas de pre carga)**. Dicen: Así dice: aunque exista la basura en este dato, no lo mandes a los rejectados, cargalo al tablón y luego lo limpiamos.
<center><img src=".\Recursos\SustentoCriticidad.png"/></center>
* ***Sustento de criticidad:*** Por qué es crítico.

- ***Nivel de seguridad del dato:***
    * Público: El dato es conocido y utilizado por cualquier colaborador. Una pérdida o modificación no autorizada puede repararse fácilmente y no compromete las operaciones del BCP.
    * Uso interno: El dato puede ser conocido o utilizado por algunos colaboradores y algunas autoridades externas. Una pérdida o modificación no autorizada podría repararse, aunque podría causar pérdidas para el BCP. Su pérdida permanente sí podría causar daños significativos a las operaciones del BCP.
    * Restringido: El dato solo puede ser conocido por un grupo de colaboradores y si se pierde, corrompe o se divulga sin autorización produce un daño serio para la reputación y/o posición de negocio de la organización. Resulta en una severa pérdida financiera, legal o reputacional.
* ***Frecuencia de Actualización:*** Cada cuanto se actualiza el dato en la fuente.
<center><img src=".\Recursos\Flujograma p17.png"/></center>
En caso no haya nuevos datos críticos, se va a ingresa la información adicional del proceso, esto además implica que el Data Engineer Se encuentra conforme con el llenado del DA, salvo salvedades que se resolverán en la validación
<center><img src=".\Recursos\Flujograma p18.png"/></center>
El Macro se encuentra en el documento de alcance DDV:
<center><img src=".\Recursos\Flujograma p19.png"/></center>
El Data Steward lo ejecuta, y encuentra errores:
<center><img src=".\Recursos\Errores.png"/></center>
<center><img src=".\Recursos\Flujograma p20.png"/></center>
El Data Modeler entonces corrige los errores del modelado (tablón DDV)
<center><img src=".\Recursos\Flujograma p21.png"/></center>
Se pregunta si hay otros errores, aparte de errores de modelamiento, que hayan sido marcados al darle al macro.
<center><img src=".\Recursos\Flujograma p22.png"/></center>
Al corregir los errores, se genera Metadata y Linaje (trazabilidad de errores), en cada campo hay errores, la trazabilidad viene a ser algo como “por qué este dato debe ser así y no así”
<center><img src=".\Recursos\Flujograma p23.png"/></center>
Una vez que tienen los errores corregidos, se pasa a actualizar denuevo en DA. 
