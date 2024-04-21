Banco tiene: Productos (Tarjeta, etc)

Servicios: Prestamos, Pedido de tarjeta

Para el servicio Pedido de tarjeta, se tienen muchos procesos:

Recibimiento de la información->...->Le llega la tarjeta.

Contacto: Analista de Gobierno de datos (más que nada Técnico)

El contacto se encuentra en uno de esos procesos internos, para que un servicio (Préstamo, pedido de tarjeta, etc. se de)

Todo está de acuerdo a lineamientos, reglas.

“Data y Analytics Migration Score” Es un área, esta vez la tomaremos como la empresa total (BCP)
>Score: Conjunto de datos que están relacionados para un fin

>Ejemplo: 
>Perfil del cliente: Deudor, Puntual, etc.
>Tipo de Prestamo: Hipotecario, Vehicular, personal.
Lo que hace su área es un entregable, que no sale al cliente, sale a otra área, porque es parte de un macroproceso más grande.

Servicios del área: 

* Migrar Datos, Score, Tablas, Aplicaciones principalmente datos.

Básicamente, Se recibe información desordenada→ Se ve la calidad de datos→  se devuelven información estructurada
>Migración de datos: Para la empresa, es pasar los datos de un entorno de Data WareHouse a uno de Data Lake

En general todo son tablas datos están enfocados a tablas y estas a los esquemas.
>Esquema: Plano de cómo está organizado
Para elaborar el entregable se tienen los pasos de un flujograma

<center><img src=".\Recursos\FlujoGrama.png"/></center>

>Para ellos Dato=Campo=Variable

Procesos del área(Todos relacionados a la migración de datos), cada uno es un flujo:

>Interfaz Entrada -> Doc de alcance -> Interfaz Salida
---
### Data Vault
Es una arquitectura de datos propia del BCP, consiste en dividir el DataLake en capas o sectores:
<center><img src=".\Recursos\DataLake.png"/></center>

***Universal Data***, donde los datos se almacenaban en una estructura simple sin ningún o poca modificación desde sus sistemas de origen, esto permitía que toda la información se tenga disponible en todo momento en esta zona, de tal manera que el time to market de los proyectos de data sea menor.

***Dimensional Data***, donde los datos se almacenaban en una estructura simple sin ningún o poca modificación desde sus sistemas de origen, esto permitía que toda la información se tenga disponible en todo momento en esta zona, de tal manera que el time to market de los proyectos de data sea menor.

***Experimental Data***, donde los datos se almacenaban en una estructura simple sin ningún o poca modificación desde sus sistemas de origen, esto permitía que toda la información se tenga disponible en todo momento en esta zona, de tal manera que el time to market de los proyectos de data sea menor.

---

## Documento de Interfaz de Entrada:

Un usuario anterior (área anterior) hace un perfilamiento o validez de los datos, socializan ambas áreas para hacer esto.
**Socializar**:   
1. Reunirse con el usuario origen para que nos brinde toda la info detallada sobre el diccionario de datos
2. Validar la Unicidad y Nulidad de los campos llaves -> Si salen reunirse con el usuario origen y alertarlos, así lo corrigen.
3. Identificar campos DAC 
4. Socializarlo con el Data Engineer.
5. Finalizar proceso enviando un correo de conformidad al usuario de origen. (Usuario ve y dice que es conforme, si dice que no es su culpa, no se puede eliminar la tabla)
## Elaborar el (los) documento de alcance: 
Documento que garantiza la calidad (que todo lo que se envía es correcto) de la migración de datos (Se le entrega al usuario destino (siguiente área))
1. Se recoge info desde un broad (se entrega el broad en la parte de Interfaz de entrada implícitamente) y se traspasa a la capa RDV
2. Se traspasa la información de RDV al UDV
3. Se traspasa la información de la caba UDV a la capa DDV
## Documento de Interfaz de Salida
Es similar, pero en este caso la información no solo se entrega la tabla, sino que también se almacena en un repositorio mediante un pipeline (otro flujo) el usuario de salida recoge es info del repositorio. Nosotros somos el usuario origen
1. Ratificación de información entre la tabla “de salida” con la tabla que se deja en el repositorio (con el pipeline), origen vs destino. (si esta mal vamos con el data Engineer)
2. Reunirse con el Usuario destino para brindarle información detallada sobre el diccionario de datos e información técnica (Scripts, jobs)
3. Enviar un correo de conformidad al usuario destino