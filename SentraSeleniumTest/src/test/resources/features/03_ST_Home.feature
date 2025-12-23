# language: es
Característica: Vista del Home
    Antecedentes:
        Dado Navegar a 192.168.80.43:10200
        Cuando Ingreso el usuario "msobarzo@sentra.cl" y la contraseña "msobarzo02"
    Escenario: Creando una nueva tarea
        Cuando Navego a la sección principal
        Entonces Creo una tarea
        