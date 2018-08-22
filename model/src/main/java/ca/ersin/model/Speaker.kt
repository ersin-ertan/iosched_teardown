package ca.ersin.model

typealias SpeakerId = String

/**
 * Describes a speaker at the conference.
 */
data class Speaker(
        /**
         * Unique string identifying this speaker.
         */
        val id: SpeakerId,

        /**
         * Name of this speaker.
         */
        val name: String,

        /**
         * Profile photo of this speaker.
         */
        val imageUrl: String,

        /**
         * Company this speaker works for.
         */
        val company: String,

        /**
         * Text describing this speaker in detail.
         */
        val abstract: String,

        /**
         * Full URL of the speaker's website.
         */
        val websiteUrl: String? = null,

        /**
         * Full URL of the speaker's Twitter profile.
         */
        val twitterUrl: String? = null,

        /**
         * Full URL of the speaker's GitHub profile.
         */
        val githubUrl: String? = null,

        /**
         * Full URL of the speaker's LinkedIn profile.
         */
        val linkedInUrl: String? = null
) {
    val hasCompany
        get() = company.isNotEmpty()

    val hasAbstract
        get() = abstract.isNotEmpty()
}