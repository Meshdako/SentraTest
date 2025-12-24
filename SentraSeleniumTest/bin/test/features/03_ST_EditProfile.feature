# language: es
Característica: Editar perfil
    Antecedentes:
        Dado Navego a 192.168.80.43:10200
        Cuando Ingreso el usuario "msobarzo@sentra.cl" y la contraseña "msobarzo02"

    Escenario: Edición del Perfil
        Cuando Navego a la sección del perfil
        Y Edito el nombre por "Jesús" y el apellido por "De Nazaret"
        Entonces Se valida la edición
        