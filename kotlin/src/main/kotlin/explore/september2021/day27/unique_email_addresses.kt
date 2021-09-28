package explore.september2021.day27

class Solution {
    fun numUniqueEmails(emails: Array<String>): Int {
        val transformer = fun(email: String): String {
            val (local, domain) = email.split('@')
            return local.split('+')[0].replace(".", "") + "@" + domain
        }
        return emails.map(transformer).toSet().size
    }
}
