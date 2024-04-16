# Prototipo

## Seguridad de Gestión de usuarios

* El administrador del sistema se encargará de registrar a los usuarios ingresando su nombre, correo electrónico y rol en el sistema.
Una vez registrado, le proporcionará las credenciales de inicio de sesión a los respectivos usuarios.
Además, se encargará de tomar las configuraciones de seguridad y prevención de ataques correspondientes como la configuración de un servidor proxy o verificación de usuarios.

<div style="text-align: center;">
<img src=".\resources\prototipo\Creacion9.jpg" alt="Creación 1" style="width: 90%; height: auto;"/>
</div>
<br>

* El usuario inicia sesión con las credenciales proporcionadas por el adminsitrador del sistema.

<div style="text-align: center;">
<img src=".\resources\prototipo\Creacion10.jpg" alt="Creación 1" style="width: 90%; height: auto;"/>
</div>
<br>

## Administración de los Documentos DDV

* El usuario una vez registrado, estará en la página principal del sistema el cual mostrará los últimos documentos de Alcance y las últimas modificaciones que ha tenido el sistema, además, habrá una opción “Crear Nuevo Documento de Alcance” para crear un nuevo Documento.

<div style="text-align: center;">
<img src=".\resources\prototipo\Creacion1.jpeg" alt="Creación 1" style="width: 90%; height: auto;"/>
</div>
<br>

* Al seleccionar "Ver más" de "Últimas Modificaciones Generales", se detallará todas las modificaciones que ha tenido el documento. Si el usuario desea agregar una nueva modificación, puede hacerlo utilizando el botón "Agregar una nueva modificación" y el sistema deberá actualizar la información de los documentos de Alcance en la página mencionada anteriormente, donde indicará que el documento no esta en el formato actual.

<div style="text-align: center;">
<img src=".\resources\prototipo\Creacion1.1.jpeg" alt="Creación 1.1" style="width: 90%; height: auto;"/>
</div>
<br>

* Al seleccionar "Ver más" de "Últimos Documentos", se detallará todas los documentos de Alcance. Se mostrará información general del documento y podrás escoger cualquier de los documentos que hay allí. También, aparece de nuevo la opción “Crear Nuevo Documento de Alcance”.
<div style="text-align: center;">
<img src=".\resources\prototipo\Creacion1.2.jpeg" alt="Creación 1.2" style="width: 90%; height: auto;"/>
</div>
<br>

* Al escoger uno de los documentos, se detallará todas las versiones del documento y detalles generales de las versiones. Se podrá escoger la versiones para ver minuciosamente los cambios que tuvo esa versión. También, aparecerá una opción “Modificar Documento de Alcance".

<div style="text-align: center;">
<img src=".\resources\prototipo\Creacion2.1.jpeg" alt="Creación 1" style="width: 90%; height: auto;"/>
</div>
<br>

* Al escoger la opción “Modificar Documento de Alcance", saldrá una ventana emergente para detallar la versión del documento. Los campos que tendrá serán para especificar qué cambios se van a realizar y por quién fueron solicitados esos cambios.

<div style="text-align: center;">
<img src=".\resources\prototipo\Creacion2.2.jpeg" alt="Creación 2"  style="width: 60%; height: auto;"/>
</div>
<br>

## Ingresar información del documento de alcance y búsqueda de equivalencias

* Después de darle click a "Aceptar", se mostrará una ventana incial dónde se verá el progreso de llenado del documento de alcance por cada sección, con opciones de abrir cada una de ellas mediante un botón de enlace.

<div style="text-align: center;">
<img src=".\resources\prototipo\Creacion6.png" alt="Creación 3"  style="width: 60%; height: auto;"/>
</div>
<br>

* Al darle click al botón de enlace relacionado con la información general, se abrirá una pestaña dónde se podrá rellenar cada campo eligiendo una de las opciones de cada lista desplegable. Terminado el llenado se dará click a "siguiente".

<div style="text-align: center;">
<img src=".\resources\prototipo\Creacion3.png" alt="Creación 3"  style="width: 60%; height: auto;"/>
</div>
<br>

* Se abrirá la ventana de la sección de información de referencia, dónde al igual que la ventana anterior se podrá elegir entre opciones de la lista desplegable para ciertos campos, pero adicionalmente, para los campos restantes que lo requieren, se podrá insertar texto. Por último, se dará click a "Siguiente", o en caso se quiera modificar datos de la venta anterior se dará click a "Regresar".

<div style="text-align: center;">
<img src=".\resources\prototipo\Creacion4.png" alt="Creación 3"  style="width: 60%; height: auto;"/>
</div>
<br>

* En caso se haya seleccionado "Siguiente", se abrirá la ventana de la sección de conceptos de negocio, dónde se podrá rellenar los campos, seleccionando opciones o insertando texto. Y una función adicional, es que se podrá seleccionar de un calendario la fecha para el campo de "Fecha Historia". Por ultimo, seleccionamos "Guardar" o "Regresar" según se requiera.

<div style="text-align: center;">
<img src=".\resources\prototipo\Creacion5.png" alt="Creación 3"  style="width: 60%; height: auto;"/>
</div>
<br>

* Al darle click a "Guardar", nos redireccionará a la ventana inicial de progreso y el siguiente usuario responsable tendrá la opción de ver la tabla de equivalencias que se ha generado, en base a las datos de la seccion de información de referencia o ingresar directamente a la sección de información del modelo.

* En caso se seleccione la primera opción, se abrirá la ventana siguiente, con las equivalencias por cada dato.

<div style="text-align: center;">
<img src=".\resources\prototipo\Creacion7.png" alt="Creación 3"  style="width: 60%; height: auto;"/>
</div>
<br>

* Por otro lado, en la segunda opción se abrirá la ventana de la sección de información del modelo, dónde se podrá rellenar los campos en base a las equivalencias encontradas, y se podrán ayudar del botón "regresar a la tabla" para verlas. Asimismo, se tendrán otros campos dónde se podrán seleccionar opciones de las listas desplegables correspondientes. Por último, se le da click a "Finalizar y guardar" para almacenar la información en su totalidad.

<div style="text-align: center;">
<img src=".\resources\prototipo\Creacion8.png" alt="Creación 3"  style="width: 60%; height: auto;"/>
</div>
<br>

## Reglas de precarga y carga
* Se muestra un lector de código SQL, PySpark o Bloc de notas en caso se use pseudocódigo, en el se pueden crear bloques de codigo en el que se detalla el paso a paso de los joins hechos en la regla de carga.
* Se puede entrar a ver la definición del universo que se usa para hacer los joins así como un boton para enviar en caso se haya culminado.

<div style="text-align: center;">
<img src=".\resources\prototipo\Vista Carga.png" alt="Vista Carga"  style="width: 60%; height: auto;"/>
</div>
<br>

* Se muestra las reglas ya usadas, se irá actualizando conforme se hagan nuevas, además el detalle de cada una de ellas (descripción y que evalúa).

* Se da la opción de elegir si aplicar o no aplicar las reglas de precarga opcionales, en los detalles se especifican los casos en los que se debe usar.

* En la opción ver registro, se puede ver quién estuvo manejando la aplicación de las reglas de precarga usadas.

<div style="text-align: center;">
<img src=".\resources\prototipo\Vista PreCarga.png" alt="Vista PreCarga"  style="width: 60%; height: auto;"/>
</div>
<br>

## Seguridad de datos
* En esta sección, el usuario selecciona el Documento de interfaz relacionado con el porceso de migración actual, para que se pueda dar la clasificación de los datos ingresados. En este documento estarán las especificaciones brindadas por los usuarios de origen respecto a cada dato, detallando si son datos sensibles, su criticidad, el sustento de criticidad, etc.
El sistema internamente hará este proceso mientras se muestra la tabla de progreso y finalmente la opción de ver estos datos ya clasificados, para comprobarlo por última vez.

<div style="text-align: center;">
<img src=".\resources\prototipo\c1.png" alt="Creación 3"  style="width: 60%; height: auto;"/>
</div>
<br>

<div style="text-align: center;">
<img src=".\resources\prototipo\c2.png" alt="Creación 3"  style="width: 60%; height: auto;"/>
</div>
<br>

* En la parte de Información Adicional, consta de dos secciones: Información del moldelo y Definiciones técnicas. En la primera parte se tiene que ingresar el Nombre de la tabla, el código de proceso, nombre del job y la ruta de la tabla. La parte del Código del proceso será generado por el sistema ya que solo consta de la concatenación de [Nombre de la tabla]+[Código del proceso], según los lineamientos de calidad. 
 Igualmente con la sección de Definiciones técnicas.
 <div style="text-align: center;">
<img src=".\resources\prototipo\c3.png" alt="Creación 3"  style="width: 60%; height: auto;"/>
</div>
<br>
<div style="text-align: center;">
<img src=".\resources\prototipo\c4.png" alt="Creación 3"  style="width: 60%; height: auto;"/>
</div>
<br>

* Para la validación de datos se usará "Validar DA DVV" luego de agregar la información adicional, se visualizarán los errores encontrados y se podrá editar dichos errores con la guía del reporte; luego se hará el uso de metadata y linaje para hacer la trazabilidad de errores y registrar en detalle cada error, finalmente se actualizará el documento DA DDV y se enviará a la nube.
 <div style="text-align: center;">
<img src=".\resources\prototipo\V1.png" alt="Validación1"  style="width: 60%; height: auto;"/>
</div>
<br>
<div style="text-align: center;">
<img src=".\resources\prototipo\V2.png" alt="Validación2"  style="width: 60%; height: auto;"/>
</div>
<br>

[Regresar al Entregable 3](../entregable3.md)

[Regresar al índice](../../README.md)
