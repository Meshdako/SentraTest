# language: es
Característica: Creación de un Perfil
Antecedentes:
Dado Navego a 192.168.80.43:10200

Escenario: Sign Up Exitosa
Dado Quiero crear un perfil nuevo
Cuando Ingreso los datos válidos de usuario
Y Creo el perfil nuevo
Entonces Valido el perfil nuevo válido

Escenario: Sign Up Fallida
Dado Quiero crear un perfil nuevo
Cuando Ingreso los datos inválidos de usuario
Y Creo el perfil nuevo
Entonces Valido el perfil nuevo inválido

Escenario: Sign Up Fallida: Contraseña Incorrecta
Dado Quiero crear un perfil nuevo
Cuando Ingreso los datos incorrectos de usuario
Y Creo el perfil nuevo
Entonces Valido el perfil nuevo inválido

