import java.util.*

class JavaPersonKT(
    val id: Long,
    val title: String,
    val firstName: String,
    val surname: String,
    val dateOfBirth: Calendar?
) {


    val age: Int
    get() = getAge(dateOfBirth)


    companion object {
        fun getAge(dateOfBirth: Calendar?): Int {
            if(dateOfBirth == null) {
                return -1
            }
            val today = GregorianCalendar()
            val years = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR)
            return if(dateOfBirth.get(Calendar.DAY_OF_YEAR) >= today.get(Calendar.YEAR)) {
                years - 1
            } else {
                years
            }
        }
    }

    override fun toString() = "$title $firstName $surname"
}

fun main() {
    val john = JavaPersonKT(1L, "Mr", "John", "Blue", GregorianCalendar(1988, 9, 3))
    val jane = JavaPersonKT(1L, "Mrs", "Jane", "Green", null)
    println("${john}'s age is ${john.age}")
    println("${jane}'s age is ${jane.age}")
    println("The age of someone born on 3rd May 1988 is ${JavaPersonKT.getAge(GregorianCalendar(1988,5,3))}")
}