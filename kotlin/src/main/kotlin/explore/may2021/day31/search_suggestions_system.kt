package explore.may2021.day31

class Solution {
    fun suggestedProducts(products: Array<String>, searchWord: String): List<List<String>> {
        val pres = mutableMapOf<String, Pre>()
        for (i in searchWord.indices) {
            pres[searchWord.substring(0, i + 1)] = Pre()
        }
        for (product in products) {
            for (i in product.indices) {
                val pre = pres[product.substring(0, i + 1)] ?: break
                pre.add(product)
                pres[product.substring(0, i + 1)] = pre
            }
        }
        return searchWord.indices.map { pres[searchWord.substring(0, it + 1)]!!.toList() }
    }
}

class Pre {
    var first: String? = null
    var second: String? = null
    var third: String? = null

    fun add(word: String) {
        if (first == null) {
            first = word
            return
        }
        if (first!! > word) {
            third = second
            second = first
            first = word
            return
        }

        if (second == null) {
            second = word
            return
        }
        if (second!! > word) {
            third = second
            second = word
            return
        }

        if (third == null) {
            third = word
            return
        }
        if (third!! > word) {
            third = word
        }
    }

    fun toList(): List<String> {
        return listOfNotNull(first, second, third)
    }

}