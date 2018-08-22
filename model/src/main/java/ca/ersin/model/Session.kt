package ca.ersin.model

import org.threeten.bp.ZonedDateTime

typealias SessionId = String

data class Session(
        val id: SessionId,
        val startTime: ZonedDateTime,
        val endTime: ZonedDateTime,
        val title: String,
        val abstract: String,
        val room: Room?,
        val sessionUrl: String,
        val liveStreamUrl: String?,
        val isLivestream: Boolean,
        val youTubeUrl: String,
        val tags: List<Tag>,
        val displayTags: List<Tag>,
        val speakers: Set<Speaker>,
        val photoUrl: String?,
        val relatedSessions: Set<SessionId>
) {

    fun isLive(): Boolean {
        val now = ZonedDateTime.now()
        // TODO: Determine when a session is live based on the time AND the liveStream being
        // available.
        return startTime <= now && endTime >= now
    }

    fun hasVideo() = youTubeUrl.isNotEmpty()

    val year = startTime.year

    // TODO: Get duration from the YouTube video. Not every talk fills the full session time.
    val duration = endTime.toInstant().toEpochMilli() - startTime.toInstant().toEpochMilli()

    val type: SessionType by lazy(LazyThreadSafetyMode.PUBLICATION) {
        SessionType.fromTags(tags)
    }

    fun levelTag(): Tag? {
        return tags.firstOrNull { it.category == Tag.CATEGORY_LEVEL }
    }

    /**
     * Whether this event is reservable, based upon [type].
     */
    fun isReservable() = type == SessionType.SESSION

    fun isOverlapping(session: Session): Boolean {
        return this.startTime < session.endTime && this.endTime > session.startTime
    }
}

/**
 * Represents the type of the event e.g. Session, Codelab etc.
 */
enum class SessionType {
    SESSION,
    APP_REVIEW,
    OFFICE_HOURS,
    CODELAB,
    SANDBOX,
    AFTER_HOURS,
    UNKNOWN;

    companion object {

        fun fromTags(tags: List<Tag>): SessionType {
            val typeTag = tags.firstOrNull { it.category == Tag.CATEGORY_TYPE }

            return when (typeTag?.tag) {
                Tag.TYPE_APP_REVIEWS -> APP_REVIEW
                Tag.TYPE_AFTERHOURS -> AFTER_HOURS
                Tag.TYPE_CODELABS -> CODELAB
                Tag.TYPE_OFFICEHOURS -> OFFICE_HOURS
                Tag.TYPE_SANDBOXDEMO -> SANDBOX
                Tag.TYPE_SESSIONS -> SESSION
                else -> UNKNOWN
            }
        }
    }
}