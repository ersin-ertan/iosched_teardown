package ca.ersin.model

data class Tag(
        val id: String,
        val category: String,
        val tag: String,
        val orderInCategory: Int,
        val name: String,
        val color: Int,
        val fontColor: Int? = null
) {

    companion object {
        const val CATEGORY_TOPIC = "topic"
        const val CATEGORY_TYPE = "type"
        const val CATEGORY_THEME = "theme"
        const val CATEGORY_LEVEL = "level"

        // Exhaustive list of IDs for tags with category = TYPE
        const val TYPE_SESSIONS = "type_sessions"
        const val TYPE_APP_REVIEWS = "type_appreviews"
        const val TYPE_AFTERHOURS = "type_afterhours"
        const val TYPE_CODELABS = "type_codelabs"
        const val TYPE_OFFICEHOURS = "type_officehours"
        const val TYPE_SANDBOXDEMO = "type_sandboxdemos"
    }

    /** Only IDs are used for equality. */
    override fun equals(other: Any?): Boolean = this === other || (other is Tag && other.id == id)

    /** Only IDs are used for equality. */
    override fun hashCode(): Int = id.hashCode()

    fun isUiContentEqual(other: Tag) = color == other.color && name == other.name

    fun isLightFontColor() = fontColor?.toLong() == 0xFFFFFFFF
}