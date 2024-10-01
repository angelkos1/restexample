# Para realizar Pruebas

### Configuración BD
revisar en el archivo application.properties la base de datos generada en memoria con la configuración del datasource, el script se crea automáticamente con las entidades.

### Configuración Regex de Password

En el archivo application properties se puede editar el regex que se utilizará para validar el campo password.

### Ejecutar desde Swagger o Aplicación Postman

### Swagger

Ingresar en la dirección http://localhost:8080/swagger-ui/index.html#/

En el método POST Registrar presionar Try Out según las indicaciones.

### Postman

Crear un nuevo Request POST a la dirección http://localhost:8080/register

Body de ejemplo:

{
"name": "Teodoro Gonzalez",
"email": "teodo2@mail.com",
"password": "Password1#",
"phones":[
{
"number": "1234567",
"citycode": "2",
"countrycode": "57"
}
]
}
