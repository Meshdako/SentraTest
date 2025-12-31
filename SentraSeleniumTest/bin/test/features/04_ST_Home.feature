# language: es
Característica: Vista de la Pantalla Principal
Antecedentes:
Dado Navego a 192.168.80.43:10200
Cuando Inicio sesión con las credenciales válidas
Entonces Accedo al sistema

Escenario: Visualizar Lista de Tareas
Cuando Navego a la sección principal
Entonces Veo la lista de tareas

Escenario: Creando una Nueva Tarea Exitosa
Cuando Navego a la sección principal
Y Quiero crear una nueva tarea
Y Ingreso los nuevos datos
Entonces Creo una tarea
Y Valido la nueva tarea creada

Escenario: Creando una Nueva Tarea Fallida
Cuando Navego a la sección principal
Y Quiero crear una nueva tarea
Y Ingreso los nuevos datos incorrectos
Entonces Creo una tarea
Y Valido la nueva tarea creada

Escenario: Ordenar Tareas por Título
Cuando Navego a la sección principal
Y Ordeno las tareas por título
Entonces Las tareas están ordenadas por título

Escenario: Ordenar por Prioridad
Cuando Navego a la sección principal
Y Ordeno las tareas por Prioridad
Entonces Las tareas se ordenan por prioridad
@solo
Escenario: Ordenar por Fecha de Término
Cuando Navego a la sección principal
Y Ordeno las tareas por fecha de término
Entonces Las tareas se ordenan por fecha de término

Escenario: Paginar Lista de Tareas
Cuando Navego a la sección principal
Y Pagino la lista de tareas
Entonces La página me muestra las demás tareas

Escenario: Compactar la Lista de Tareas
Cuando Navego a la sección principal
Y Doy clic en la visualización compacta
Entonces La tabla se compacta correctamente

Escenario: Cerrar Barra Lateral del Menú
Cuando Navego a la sección principal
Y Doy clic en el cierre de la barra lateral
Entonces La página cierra la barra