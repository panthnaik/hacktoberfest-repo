fun main() {

    // set adalah jenis collection untuk meyimpan nilai unik, tidak terduplikasi
    val setA = setOf(1, 2, 3, 2, 1, 4, 5)
    val setB = setOf(4, 5, 6, 7, 8, 9, 10)

    val union = setA.union(setB) // gabungan
    val intersect = setA.intersect(setB) // irisan

    println("Union : $union")
    println("Intersect : $intersect")

    // tidak berduplikat
    println("Set A : $setA")
}