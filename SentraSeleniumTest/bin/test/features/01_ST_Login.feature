# language: es
Característica: Inicio de sesión
Escenario: Sign In Fallido
Dado Navego a 192.168.80.43:10200
Cuando Inicio sesión con las credenciales inválidas
Entonces Accedo al sistema

Escenario: Sign In Exitoso
Dado Navego a 192.168.80.43:10200
Cuando Inicio sesión con las credenciales válidas
Entonces Accedo al sistema

