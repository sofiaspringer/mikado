interface FileStorage {

    fun setStore(storageFile: String)

    fun load(key: String): List<String>?

}