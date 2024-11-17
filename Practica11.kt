//Gestion de tareas
class CustomList<T> {
    private val elements = mutableListOf<T>()

    fun add(element: T): Boolean {
        return if (element !in elements){
            elements.add(element)
            println("Tareas agregadas exitosamente")
            true 
        } else {
            println("La tarea ya existe")
            false
        }
    }

    fun remove(element: T): Boolean{
        return if (element in elements){
            elements.remove(element)
            println("Tarea eliminada!")
            true
        } else {
            println("Tarea no se encontro en la lista")
            false
        }
    }

    fun showAll(){
        if (elements.isEmpty()){
            println("Lista de tareas vacia")
        }else{
            println("Lista de tareas:")
            elements.forEach {println(" -$it")}
        }
    }

    fun size(): Int{
        return elements.size
    }
}

//Main 
fun main(args: Array<String>) {
    val listaTareas = CustomList<String>()
    var opcion: Int

    do{
        println("\nGestor de tareas")
        println("1. Agregar tareas")
        println("2. Eliminar tareas")
        println("3. Ver lista de tareas")
        println("4. Salir")
        println("Selecione una opcion")
        opcion = readLine()?.toIntOrNull() ?: 0

        when (opcion){
            1->{
                println("Ingrese la nueva tarea")
                val nuevaTarea = readLine()?: ""
                listaTareas.add(nuevaTarea)
            }
            2->{
                if (listaTareas.size() > 0){
                    println("Selecione la tarea que desea eliminar")
                    listaTareas.showAll()
                    println("Ingrese el nombre de la tarea:")
                    val eliminarTarea = readLine()?: ""
                    listaTareas.remove(eliminarTarea)
                }else{
                    println("La tarea no esta en la lista")
                }
            }
            3->{
                listaTareas.showAll()
            }
            4->println("Saliendo del programa...")

            else -> println("Opcion no valida, ingrese una opcion valida.")
        }
    } while (opcion != 4)
}