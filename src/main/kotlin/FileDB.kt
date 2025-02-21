
import java.io.*

class FileDB {
    private var file: File? = null

    fun load(key: String): List<String>? {
        try {
            val stream = ObjectInputStream(FileInputStream(file))
            val data = stream.readObject() as Map<String, Serializable>
            return data[key] as List<String>?
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }

    fun store(data: Map<String?, Serializable?>?) {
        try {
            val out = FileOutputStream(file)
            val stream = ObjectOutputStream(out)
            stream.writeObject(data)
            out.close()
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }


    fun setStore(storageFile: String) {
        file = File(storageFile)
    }
}