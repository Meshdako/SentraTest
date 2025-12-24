# language: es
Característica: Inicio de sesión
    Escenario: Login Fallido
        Dado Navego a 192.168.80.43:10200
        Cuando Ingreso el usuario "ehuerta@sentra.cl" y la contraseña "1a23456"
        Entonces Aparece un mensaje de error

    Escenario: Login Exitoso
        Dado Navego a 192.168.80.43:10200
        Cuando Ingreso el usuario "msobarzo@sentra.cl" y la contraseña "msobarzo02"
        Entonces Cerramos sesión

