# Módulos

## Módulo de Seguridad

El módulo de seguridad se encarga de administrar la autenticación, autorización y control de acceso de los usuarios al sistema, garantizando la integridad y confidencialidad de los datos.

#### Interacción con otros módulos: 
Este módulo se integra estrechamente con todos los demás módulos del sistema para garantizar que el acceso a las funcionalidades y datos esté protegido según los roles y permisos definidos, además implementa medidas para prevenir y mitigar posibles ataques cibernéticos, protegiendo así la integridad y confidencialidad de los datos del sistema.

#### Responsabilidades
* Gestionar el registro de usuarios, incluyendo la creación, modificación y eliminación de cuentas.
* Implementar la autenticación de doble factor para añadir una capa adicional de seguridad al proceso de inicio de sesión.
* Autorizar el acceso a recursos y funcionalidades según los roles y permisos asignados
* Controlar el acceso a áreas sensibles del sistema y proteger contra intentos de intrusión.
* Registrar y auditar la actividad de los usuarios para detectar posibles amenazas o violaciones de seguridad.
* Gestionar la sesión de usuario, incluyendo la gestión de tokens de autenticación y la expiración de sesiones.
* Mantener actualizadas las políticas de seguridad y protocolos de autenticación para adaptarse a las necesidades cambiantes del sistema y las regulaciones de seguridad.
* Implementar firewalls y filtros de paquetes para controlar el tráfico de red y evitar intrusiones no autorizadas.
* Mantener el software y los sistemas del sistema actualizados con los últimos parches de seguridad para evitar vulnerabilidades conocidas.


## Módulo de Administración de Documento

Este módulo es responsable de iniciar la elaboración del Documento de Alcance DDV a pedido del usuario de origen, para garantizar la migración de datos y entregarla al usuario destino. Además, este módulo también se encarga de administrar los diferentes documentos DDV existentes y de gestionar las versiones de cada uno de ellos.

#### Interracción con otros módulos: 

Módulo de Seguridad

Módulo de Ingreso de Información y Equivalencias


#### Responsabilidades

* Crear nuevo Documento de Alcance a partir de una platilla ya establecida.
* Modificar Documento de Alcance.
* Actualizar la versión  del Documento de Alcance.
* Controlar y gestionar los diferentes Documento de Alcance existentes.
* Controlar las versiones de cada uno de los Documento de Alcance.
* Visualizar y controlar los cambios en la estructura de los  Documento de Alcance.


## Módulo de Ingreso de Información y Equivalencias

Facilitará el ingreso de la información general, de referencia y los conceptos de negocio, así como la información del modelo DDV. Asimismo, buscará las equivalencias de las referencias dadas y las ingresará en los campos requeridos.

#### Interracción con otros módulos: 
Módulo de Inicialización de Documento.

#### Responsabilidades

Mostrar opciones de llenado de los campos del sector de información general.

Mostrar opciones de llenado de los campos tipo de referencia, esquema de referencia, tabla de referencia y campo de referencia.

Mostrar opciones de llenado de los campos dominio, subdominio, producto de dato, historia y todo lo restante del sector concepto de negocio.

Permitirá completar los datos del modelo DDV, ya sea con una opción para insertar datos o para seleccionarlos de una lista predeterminada, según sea el caso.

Buscar equivalencias de los campos de referencia.

Colocar equivalencias en los campos requeridos.

## Módulo de Reglas de Precarga y Carga 

Se trata de aplicar las reglas de precarga obligatorias y sus soluciones (Table Reject), así como considerar los casos de aplicación de las demás reglas (condiciones), considera casuítico aplicar las reglas de precarga opcionales, el encargado de decidir lo hace mediante una lista desplegable en excel,también se muestra una descripción de lo que hace cada una de las reglas.

Sobre las reglas de carga se trata de escribir el codigo en SQL, PySpark, pseudocódigo, etc. Además se debe explicar paso por paso y de manera que puedan ser entendidos por todos los usuarios del negocio. 

#### Interacción

Este modulo interacciona con el de Ingreso de información y equivalencias, pues en las reglas de carga se hacen los joins entre las referencias y el universo.

#### Responsabilidades

Verificar las reglas de precarga obligatorias y enviar a la tabla Reject las que no cumplan.

Consultar la aplicación de las reglas de precarga opcionales.

Mostrar una descripción adecuada de las reglas de precarga.

Posibilitar la comprensión del usuario de negocio de las reglas de carga, explicando paso a paso la codificación.



## Módulo de Gestión de Reuniones


El módulo permite programar, coordinar y supervisar reuniones relacionadas con el proceso de migración de datos. Facilita la creación y gestión de reuniones, el registro de agendas y acuerdos, y la notificación de eventos pendientes.

### Interacción 
Interactúa con el módulo de Pedidos para coordinar las reuniones según las necesidades de cada solicitud.

### Responsabilidades
* Programar reuniones de entrada y salida relacionadas con los pedidos de migración de datos.
* Registrar participantes, agendas, acuerdos y documentos asociados a cada reunión.
* Enviar recordatorios automáticos a los participantes antes de las reuniones pendientes.
* Seguimiento del estado de las reuniones y registro de conclusiones o acuerdos alcanzados.
* Generación de reportes de conformidad para verificar el cumplimiento de los objetivos de las reuniones.

## Módulo de  Reporte y Registro de errores


Este módulo se encargará de hacer el reporte de errores ocurridos y corregidos, la cual se usará la trazabilidad de los errores presentados para finalmente validar y actualizarlo en el Governance Catalog.


### Interacción 

Este módulo interacciona con el módulo de ingreso de información y equivalencias, módulo de reglas de precarga y carga y módulo de seguridad del dato.
### Responsabilidades
* reportar los errores indicando que campo tiene dicho error
* corregir los errores de acuerdo a los tipos de validación
* trazabilidad de los errores detallando el porqué de dicho error
registrar los errores.
* actualizar el registro de errores en el Governance Catalog.


# Diagrama UML

[DiagramaUML](https://lucid.app/lucidchart/ca94a4af-ce07-40c8-b99d-e0010a8ef1df/edit?beaconFlowId=D353CD2FED807B85&invitationId=inv_a5ba4607-1d4e-42e2-bff5-ce6a936fa2a3&page=0_0#)

<div style="text-align: center;">
<img src="DiagramaUML.jpg" alt="Creación 1" style="width: 90%; height: auto;"/>
</div>
<br>

---

[Regresar al Entregable 2](entregable2.md)

[Regresar al índice](../README.md)
