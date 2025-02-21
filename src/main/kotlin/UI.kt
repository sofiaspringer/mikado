import java.awt.FlowLayout
import java.awt.GridBagLayout
import java.awt.event.ActionEvent
import javax.swing.*

class UI {
    private val frame = JFrame()
    private val database: FileDB = FileDB()

    init {
        database.setStore(App.storageFile)
    }

    fun showLogin() {
        database.load("users")?.let {
            addLoginSelector(it)
            addButtons()
            frame.setSize(800, 600)
            frame.isVisible = true
        }
    }

    private fun addLoginSelector(users: List<String>) {
        val combo: JComboBox<*> = JComboBox<Any?>(users.toTypedArray())
        frame.layout = GridBagLayout()
        frame.add(combo)
    }

    private fun addButtons() {
        val buttons = JPanel(FlowLayout())
        buttons.add(actionButton(exitAction("Cancel")))
        buttons.add(actionButton(getLoginAction("Login")))
        frame.add(buttons)
    }

    private fun exitAction(label: String): AbstractAction {
        return object : AbstractAction(label) {
            private val serialVersionUID = 1L

            override fun actionPerformed(e: ActionEvent) {
                System.exit(0)
            }
        }
    }

    private fun actionButton(action: AbstractAction): JButton {
        return JButton(action)
    }

    private fun getLoginAction(label: String): AbstractAction {
        return object : AbstractAction(label) {
            private val serialVersionUID = 1L

            override fun actionPerformed(e: ActionEvent) {
                println("Logging in")
            }
        }
    }
}
