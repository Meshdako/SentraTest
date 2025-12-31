# language: es
Característica: Editar perfil
Antecedentes:
Dado Navego a 192.168.80.43:10200
Cuando Inicio sesión con las credenciales válidas
Entonces Accedo al sistema

Escenario: Edición del Perfil Fallida
Dado Navego a la sección del perfil
Y Quiero editar el perfil
Cuando Edito el perfil incorrectamente
Entonces El perfil se modifica
Y Se valida la modificación

Escenario: Edición del Perfil Exitosa
Dado Navego a la sección del perfil
Y Quiero editar el perfil
Cuando Edito el perfil
Entonces El perfil se modifica
Y Se valida la modificación

Escenario: Edición del Perfil Fallida: Cambiar Contraseña
Dado Navego a la sección del perfil
Cuando Quiero cambiar la contraseña
Y Ingreso las contraseñas mal
Entonces La modifico la contraseña
Y Valido el error