# language: es
Característica: Editar perfil
    Antecedentes:
        Dado Navegar a 192.168.80.43:10200
        Cuando Ingreso el usuario "msobarzo@sentra.cl" y la contraseña "msobarzo02"

    Escenario: Realizar cambio de nombre y apellido
        Cuando Navego a la sección del perfil
        Y Edito el nombre por "Jesús" y el apellido por "De Nazaret"
        