
object App {
    lateinit var ui: UI
    lateinit var storageFile: String

    fun launch() {
        ui = UI()
        ui.showLogin()
    }
}