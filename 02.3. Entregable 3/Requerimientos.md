# Requerimientos

### Caso de uso 1 : Registro de usuario

| Objetivo | Registrar un nuevo usuario en el sistema. |
|:----------:|-------------------|
| Descripción | Registro de un nuevo usuario por parte del administrador del sistema, proporcionándole las credenciales de inicio de sesión necesarias. |
| Actor | <p align="center"> Administrador del sistema |
| Precondición | <p align="center"> El administrador del sistema debe estar autenticado en el sistema y tener los privilegios necesarios para registrar nuevos usuarios |
| <p align="center">  Paso | <p align="center">  Acción </p> |
| 1 | El administrador del sistema accede al panel de administración de usuarios del sistema. |
| 2 | El administrador selecciona la opción para registrar un nuevo usuario.|
| 3 | Se solicitan al administrador los detalles del nuevo usuario: nombre, correo electrónico y rol en el sistema. |
| 4 | El administrador ingresa la información del nuevo usuario y genera automáticamente las credenciales de inicio de sesión: número de acceso y contraseña. |
| 5 | Se envían las credenciales de inicio de sesión al nuevo usuario, junto con las instrucciones necesarias para acceder al sistema. |
| 6 | El caso de uso termina. |

### Caso de uso 2 : Autenticación de Usuario

| Objetivo | Autenticar a un usuario en el sistema. |
|:----------:|-------------------|
| Descripción | Proceso mediante el cual un usuario proporciona sus credenciales de inicio de sesión para acceder al sistema. |
| Actor | <p align="center"> Usuario |
| Precondición | <p align="center">El usuario debe haber sido previamente registrado en el sistema y poseer credenciales de inicio de sesión válidas. |
| <p align="center">  Paso | <p align="center">  Acción </p> |
| 1 | El usuario accede a la página de inicio de sesión del sistema. |
| 2 | El usuario ingresa su nombre de usuario y contraseña en los campos correspondientes.|
| 3 | El sistema valida las credenciales ingresadas por el usuario. |
| 4 | Si las credenciales son válidas, el usuario es autenticado y redirigido al panel principal del sistema. |
| 3 | Si las credenciales son inválidas, el sistema muestra un mensaje de error al usuario y le permite volver a intentarlo. |
| 6 | El caso de uso termina. |

### Caso de uso 3 : Protección contra ataques de Phishing

| Objetivo | Proteger al sistema y a los usuarios contra ataques de phishing. |
|:----------:|-------------------|
| Descripción | Proceso mediante el cual el sistema implementa medidas de seguridad para prevenir y mitigar los ataques de phishing, protegiendo así la información confidencial de los usuarios. |
| Actor | <p align="center"> Administrador del sistema |
| Precondición | <p align="center">El sistema debe tener implementadas medidas de seguridad adecuadas y actualizadas para proteger contra ataques de phishing. |
| <p align="center">  Paso | <p align="center">  Acción </p> |
| 1 | El sistema utiliza filtros de correo electrónico (bcp) para detectar y bloquear correos electrónicos sospechosos que puedan contener ataques de phishing. |
| 2 | El sistema implementa herramientas de filtrado de URL para bloquear el acceso a sitios web conocidos por ser maliciosos o fraudulentos.|
| 3 | El sistema realiza análisis de comportamiento del usuario para detectar actividades inusuales que puedan indicar un intento de phishing, como patrones de navegación anómalos o intentos de inicio de sesión desde ubicaciones no habituales. |
| 4 | El sistema utiliza tecnologías de autenticación fuertes, como la autenticación de dos factores, para agregar una capa adicional de seguridad a las cuentas de usuario y protegerlas contra el robo de credenciales. |
| 5 | El sistema utiliza software antivirus y antimalware actualizado para detectar y eliminar posibles amenazas de phishing en los dispositivos de los usuarios. |
| 6 | para garantizar que se puedan restaurar en caso de un ataque exitoso de phishing o cualquier otro incidente de seguridad. |
| 7 | El caso de uso termina. |

### Caso de uso 4 : Creación o modificación del Documento de Alcance

| Objetivo | Dar inicio al proceso. |
|:----------:|-------------------|
| Descripción | Proceso donde se da inicio a la creación o modificación de un documento que sirve como garantía para el proceso de migración de datos y este pueda ser entregado al usuario de destino. |
| Actor | <p align="center"> Data Steward |
| Precondición | <p align="center"> El usuario debió iniciar sesión con sus credenciales. |
| <p align="center">  Paso | <p align="center">  Acción </p> |
| 1 | El usuario una vez registrado, estará en la página principal del sistema el cual mostrará dos opciones: “Crear Nuevo Documento de Alcance” y “Modificar nuevo Documento de Alcance”. El usuario deberá escoger una de las dos opciones. |
| 2 | Si ha escogido la opción de “Modificar nuevo Documento de Alcance” deberá escoger el documento que se quiera modificar.|
| 3 | Luego de haber escogido, saldrá una ventana emergente para detallar la versión del documento. Los campos que tendrá serán para especificar qué cambios se va realizar y por quien fue solicitado esos cambios. |

### Caso de uso 5 : Ingreso información general

| Objetivo | Completar la sección de información general con lo datos requeridos en su totalidad. |
|:----------:|-------------------|
| Descripción | Proceso por el cual el usuario podrá seleccionar datos en cada campo requerido. |
| Actor | <p align="center"> Data Steward |
| Precondición | <p align="center"> El usuario debió iniciar sesión con sus credenciales y haber inicializado el documento de alcance que completará. |
| <p align="center">  Paso | <p align="center">  Acción </p> |
| 1 | El sistema muestra la sección de información general con los campos a rellenar. |
| 2 | El usuario selecciona el campo "tecnología" y le da click a una de las opciones dependiendo del caso.|
| 3 | El usuario selecciona el campo "producto owner" y le da click a una de las opciones dependiendo del caso. |
| 4 | El usuario selecciona el campo "squad" y le da click a una de las opciones dependiendo del caso. |
| 5 | El usuario selecciona el campo "responsable" y le da click a una de las opciones dependiendo del caso. |
| 6 | El usuario le dará click a "Siguiente", para poder ingresar los datos de la siguiente sección. |
| 7 | El caso de uso culmina. |

### Caso de uso 6 : Ingreso información de referencia

| Objetivo | Completar los campos de información de referencia. |
|:----------:|-------------------|
| Descripción | Proceso por el cual el usuario podrá seleccionar datos o insertarlos, dependiendo del caso, en cada campo requerido. |
| Actor | <p align="center"> Data Steward |
| Precondición | <p align="center"> Haber llenado la seccion de información general. |
| <p align="center">  Paso | <p align="center">  Acción </p> |
| 1 | El sistema muestra la sección de información de referencia con los campos a rellenar. |
| 2 | El usuario selecciona el campo "tipo de referencia" y le da click a una de las opciones dependiendo del caso. |
| 3 | El usuario selecciona el campo "esquema de referencia" e inserta el dato pedido. |
| 4 | El usuario selecciona el campo "tabla de referencia" e inserta el dato pedido.  |
| 5 | El usuario selecciona el "campo de referencia" e inserta el dato pedido. |
| 6 | El usuario le dará click a "Siguiente". |
| 7 | El caso de uso culmina. |

### Caso de uso 7 : Ingreso conceptos de negocio
| Objetivo | Completar los campos respectivos de los conceptos de negocio. |
|:----------:|-------------------|
| Descripción | Proceso por el cual el usuario podrá seleccionar datos o insertarlos, dependiendo del caso, en cada campo requerido. |
| Actor | <p align="center"> Data Steward |
| Precondición | <p align="center"> Haber llenado la sección de información de referencia e información general. |
| <p align="center">  Paso | <p align="center">  Acción </p> |
| 1 | El sistema muestra la sección de conceptos de negocio con los campos a rellenar. |
| 2 | El usuario selecciona el campo "dominio" y le da click a una de las opciones dependiendo del caso. |
| 3 | El usuario selecciona el campo "subdominio" e inserta el dato pedido. |
| 4 | El usuario selecciona el campo "producto de datos" e inserta el dato pedido.  |
| 5 | El usuario selecciona el "historia" y selecciona la fecha. |
| 6 | El usuario selecciona el "Nombre del elemento de dato" e inserta el dato pedido. |
| 6 | El usuario selecciona el "Nombre del elemento de dato" e inserta el dato pedido. |
|  7| El usuario selecciona el "Definición del campo" e inserta la información pedida. |
| 8 | El usuario selecciona el "Definición de la tabla" e inserta la información pedida. |
| 9 | El usuario le dará click a "Siguiente". |
| 10 | El caso de uso culmina. |

### Caso de uso 8 : Ingresar información del modelo DDV

| Objetivo | Completar los campos de información del modelo DDV |
|:----------:|-------------------|
| Descripción | Proceso por el cual el usuario podrá seleccionar datos o insertarlos, dependiendo del caso, en cada campo requerido. |
| Actor | <p align="center"> Data Modeler |
| Precondición | <p align="center"> Haber llenado la información de conceptos de negocio, referencia e información general. |
| <p align="center">  Paso | <p align="center">  Acción </p> |
| 1 | El sistema muestra la sección de información del modelo DDV con los campos a rellenar. |
| 2 | El usuario selecciona el campo "Esquema DDV" e inserta el dato pedido. |
| 3 | El usuario selecciona el campo "Tipología" y le da click a una de las opciones dependiendo del caso. |
| 4 | El usuario selecciona el campo "Tabla DDV" e inserta el dato pedido.  |
| 5 | El usuario selecciona el campo "Campo DDV" e inserta el dato pedido. |
| 6 | El usuario selecciona el campo "Llave entidad DDV" y selecciona la opción "Si" o "No", dependiendo del caso. |
| 7 | El usuario selecciona el campo "Descartado" y selecciona la opción "Si" o "No", dependiendo del caso. |
| 9 | El usuario selecciona el campo "Comentarios Descarte/Otros" e inserta el comentario solicitado en caso se requiera. |
| 10 | El usuario le dará click a "Guardar". |
| 11 | El caso de uso culmina. |

### Caso de uso 9 : Buscar y colocar equivalencias

| Objetivo | Buscar las equivalencias de los campos de referencia en una base de datos y autocompletarlas en los campos requeridos.|
|:----------:|-------------------|
| Descripción | Proceso por el cual el sistema podrá autocompletar las equivalencias de los campos de referencia en el DLK para que se logre la migración de datos. |
| Actor | <p align="center"> Sistema |
| Precondición | <p align="center"> Haber llenado la sección de información de referencia. |
| <p align="center">  Paso | <p align="center">  Acción </p> |
| 1 | El sistema recorré cada campo de referencia completado anteriormente.|
| 2 | El sistema busca la equivalencia de cada campo en una base de datos interna.|
| 3 | El sistema asigna a cada campo su respectiva equivalencia. |
| 4 | El sistema autocompleta los campos requeridos con las equivalencias asignadas en el documento DDV.|
| 5 | El caso de uso culmina |

### Caso de uso 10 : Registrar la Seguridad de datos

| Objetivo | Completar la información de seguridad de datos  |
|:----------:|-------------------|
| Descripción | En este proceso se ingresan los datos de seguridad definidos anteriormente.  |
| Actor | <p align="center"> Data Steward |
| Precondición | <p align="center"> Que esté completa la sección de información de referencias |
| <p align="center">  Paso | <p align="center">  Acción </p> |
| 1 | El usuario selecciona la condición del dato DAC (SI/NO) |
| 2 | El usuario selecciona la criticidad del dato. |
| 3 | El usuario selecciona el sustento de criticidad |
| 4 | El usuario selecciona el nivel de seguridad |
| 5 | El usuario selecciona la frecuencia de actualización |
| 6 | El usuario selecciona el uso en reporte regulatorio |
| 7 | El usuario selecciona la entidad regulatoria|
| 8 | El usuario le dará click a "Actualizar Doc DDV", para poder actualizar los datos y tener una versión preliminar. |
| 9 | El usuario le dará click a "Siguiente", para poder ingresar los datos de la siguiente sección. |
| 10 | El caso de uso culmina. |

### Caso de uso 11 : Registrar información adicional

| Objetivo | Ingresar los datos de la información adicioanal  |
|:----------:|-------------------|
| Descripción | En este proceso se ingresan los datos de la información adicional de proceso |
| Actor | <p align="center"> Data Steward |
| Precondición | <p align="center"> Tener el Doc. de alcance preliminar |
| <p align="center">  Paso | <p align="center">  Acción </p> |
| 1 | El usuario ingresa el nombre de la tabla DDV|
| 2 | El usuario ingresa el combre del Aplicativo |
| 3 | El sistema genera el Nombre del proceso. |
| 4 | El usuario ingresa el Nombre del Job@ |
| 5 | El usuario selecciona la Frecuencia de ejecución |
| 6 | El usuario selecciona el Detalle de la Frecuencia |
| 7 | El usuario indica un comentario alusivo a la frecuencia de ejecución del job predecesor. |
| 8 | El usuario le dará click a "Siguiente", para poder ingresar los datos de la siguiente sección. |
| 9 | El caso de uso culmina. |
### Caso de uso 10 : Definir Reglas funcionales de precarga y carga


| Objetivo | Enlazar el Universo y la tabla de equivalencias mediante llaves, usar las reglas de precarga preestablecidas para validar los datos|
|:----------:|-------------------|
| Descripción | Proceso en el que se hacen los joins de las tablas, mediante SQL, PySpark, Pseudocódigo. Aplicar validación con las reglas de precarga, mandando a la tabla Reject a los registros que no pasen|
| Actor | <p align="center"> Data Steward/Sistema|
| Precondición | <p align="center"> Haber hallado las tablas de equivalencias con las referencias y haber definido el universo |
| <p align="center">  Paso | <p align="center">  Acción </p> |
| 1 | El Data Steward se encarga de escribir las reglas de carga como en el lenguaje que prefiera, explicando paso a paso para que sea entendible a los usuarios del negocio|
| 2 | El Sistema se encarga de validar primero las reglas de precarga obligatorias, analizando los casos|
| 3 | Una vez finalizado, el data Governance se encaraga de analizar la casuística de la situación para determinar si se deben aplicar o no las reglas de precarga opcionales |
| 4 | De ser determinado necesario se aplican las reglas de precarga opcionales|
| 5 | El caso de uso culmina |

### Caso de uso 12: Definir Reglas técnicas de carga


| Objetivo | Formalizar las reglas de carga para que puedan ser ejecutadas y realizar un query a la base de datos|
|:----------:|-------------------|
| Descripción | Proceso que consiste en escribir o reescribir el código planteado en el caso de uso 8, para que pueda ser ejecutado por el Data Engineer|
| Actor | <p align="center"> Custodio Técnico|
| Precondición | <p align="center"> Haber pasado las reglas de precarga |
| <p align="center">  Paso | <p align="center">  Acción </p> |
| 1 | El Custodio Técnico se encarga de llevar el codigo hecho por el Data Steward a uno ejecutable|
| 2 | El caso de uso culmina |

### Caso de uso 13: Complementar definiciones técnicas


| Objetivo | Comprobar el buen funcionamiento de las reglas de carga formalizadas que se tienen en el Caso de uso 11|
|:----------:|-------------------|
| Descripción | El Data Engineer ejecuta el codigo y le da feedback al Custodio técnico, de tal manera que corrige y se lo vuelve a mandar, hasta que cumpla los requerimientos del cliente|
| Actor | <p align="center"> Custodio Técnico/Data Engineer|
| Precondición | <p align="center"> Haber pasado las reglas de precarga |
| <p align="center">  Paso | <p align="center">  Acción </p> |
| 1 | El Data Engineer recibe el codigo de parte del Custodio técnico para ejecutar un query en su basa de datos|
| 2 | El Data Engineer corrige y manda de vuelta el codigo al Custodio técnico, con las observaciones|
| 3 | El Custodio técnico revisa las correcciones y las corrige, para volverlo a mandar.|
| 4 | El ciclo continua hasta que el query haga lo que debería hacer|
| 5 | El caso de uso culmina|

### Caso de uso 14 : Corregir errores de modelamiento

| Objetivo | Corregir los errores de modelamiento encontrados durante el proceso anterior  |
|:----------:|-------------------|
| Descripción | En este proceso se verificará qué errores fueron encontrados y cómo serán resueltos |
| Actor | <p align="center"> Data Modeler |
| Precondición | <p align="center"> Tener el Doc. de alcance con la información adicional |
| <p align="center">  Paso | <p align="center">  Acción </p> |
| 1 | El usuario presiona el botón "validar DA DDV"|
| 2 | El sistema generará el reporte de errores de modelado |
| 3 | El usuario presionará "aceptar"  |
| 4 | El sistema le dará un reporte más detallado donde podrá editar |
| 5 | El usuario corregirá los errores cambiando los campos incorrectos |
| 6 | El usuario presionará "ok" |
| 7 | El sistema le informará que los errores de modelado fueron corregidos |
| 8 | El usuario guardará el documento |
| 9 | El caso de uso culmina. |

### Caso de uso 15 : Corregir otros errores

| Objetivo | Corregir los otros errore encontrados luego de corregir los errores de modelamiento  |
|:----------:|-------------------|
| Descripción | En este proceso se verificará qué otros errores fueron encontrados y cómo serán resueltos |
| Actor | <p align="center"> Data Steward |
| Precondición | <p align="center"> Tener el Doc. de alcance guardado anteriormente |
| <p align="center">  Paso | <p align="center">  Acción </p> |
| 1 | El usuario presiona el botón "validar DA DDV"|
| 2 | El sistema generará el reporte de otros errores |
| 3 | El usuario presionará "aceptar"  |
| 4 | El sistema le dará un reporte más detallado donde podrá editar |
| 5 | El usuario corregirá los errores cambiando los campos incorrectos |
| 6 | El usuario presionará "ok" |
| 7 | El sistema le informará que los otros errores fueron corregidos |
| 8 | El usuario guardará el documento |
| 9 | El caso de uso culmina. |

### Caso de uso 16 : Generar metadata y linaje

| Objetivo | Tener guardado el registro de errores encontrados y corregidos durante todos los cambios realizados anterioremente  |
|:----------:|-------------------|
| Descripción | En este proceso se hará el registro de errores encontrados y solucionados  |
| Actor | <p align="center"> Data Steward |
| Precondición | <p align="center"> Tener el Doc. de alcance guardado anteriormente |
| <p align="center">  Paso | <p align="center">  Acción </p> |
| 1 | El usuario realizará trazabilidad con los metadatos|
| 2 | El sistema botará un archivo donde se encuentran todos los errores ocurridos |
| 3 | El usuario presionará cada error |
| 4 | El sistema le hará el detalle de cada error|
| 5 | El usuario guardará todo el registro |
| 6 | El sistema le informará que los errores se registraron correctamente |
| 7 | El usuario actualizará el documento de Alcance DDV  |
| 8 | El usuario guardará el documento de Alcance DDV|
| 9 | El caso de uso culmina. |

### Caso de uso 17 : Actualizar Governance Catalog

| Objetivo | Tener el archivo actualizado en  el Governance Catalog para una mejor seguridad |
|:----------:|-------------------|
| Descripción | En este proceso se actualizará el Governance Catalog añadiendo el documento de alcance DDV sin error alguno  |
| Actor | <p align="center"> Data Governance Expert |
| Precondición | <p align="center"> Tener el Doc. de alcance guardado anteriormente sin errores |
| <p align="center">  Paso | <p align="center">  Acción </p> |
| 1 | El usuario escogerá el archivo de alcance DDV actualizado últimamente|
| 2 | El usuario añadirá el archivo a la sección de "Documento de alcance DDV oficial" |
| 3 | El sistema actualizará el Governance Catalog|
| 4 | El caso de uso culmina. |

***

[Regresar al Entregable 3](entregable3.md)

[Regresar al índice](../README.md)