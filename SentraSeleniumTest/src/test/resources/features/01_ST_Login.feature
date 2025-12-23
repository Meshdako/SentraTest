# language: es
Característica: Inicio de sesión
    Esquema del escenario: Login fallido
        Dado Navegar a 192.168.80.43:10200
        Cuando Ingreso el usuario <email> y la contraseña <contraseña>
        Entonces Aparece un mensaje de error

        Ejemplos:
        | email               | contraseña  |
        | msobarzo@sentra.cl | mala123     |
        | ehuerta@sentra.cl  | 1a23456     |

    Escenario: Login exitoso
        Dado Navegar a 192.168.80.43:10200
        Cuando Ingreso el usuario "msobarzo@sentra.cl" y la contraseña "msobarzo02"
        Entonces Cerramos sesión

