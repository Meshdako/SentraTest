# language: es
Característica: Creación de un Perfil
    Antecedentes:
        Dado Navego a 192.168.80.43:10200

    Escenario: Creación Exitosa
        Dado Quiero crear un perfil nuevo
        Cuando Ingreso el usuario "alberto" y apellido "hurtado"
        Y El correo "ahurtado@sentra.cl" y la a contraseña "ahurtado01"
        Y Creamos el usuario
        Entonces Validamos su creación

