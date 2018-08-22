package ca.ersin.shared.util

import ca.ersin.model.ConferenceDay
import ca.ersin.model.Session
import ca.ersin.shared.BuildConfig
import org.threeten.bp.ZoneId
import org.threeten.bp.ZonedDateTime
import org.threeten.bp.format.DateTimeFormatter

object TimeUtils {

//    val CONFERENCE_TIMEZONE = ZoneId.of(BuildConfig.CONFERENCE_TIMEZONE)

    val ConferenceDays = listOf(
            ConferenceDay(
                    ZonedDateTime.parse(BuildConfig.CONFERENCE_DAY1_START),
                    ZonedDateTime.parse(BuildConfig.CONFERENCE_DAY1_END)
            ),
            ConferenceDay(
                    ZonedDateTime.parse(BuildConfig.CONFERENCE_DAY2_START),
                    ZonedDateTime.parse(BuildConfig.CONFERENCE_DAY2_END)
            ),
            ConferenceDay(
                    ZonedDateTime.parse(BuildConfig.CONFERENCE_DAY3_START),
                    ZonedDateTime.parse(BuildConfig.CONFERENCE_DAY3_END)
            )
    )

    enum class SessionRelativeTimeState { BEFORE, DURING, AFTER, UNKNOWN }

    /** Determine whether the current time is before, during, or after a Session's time slot **/
    fun getSessionState(
            session: Session?,
            currentTime: ZonedDateTime = ZonedDateTime.now()
    ): SessionRelativeTimeState {
        return when {
            session == null -> SessionRelativeTimeState.UNKNOWN
            currentTime < session.startTime -> SessionRelativeTimeState.BEFORE
            currentTime > session.endTime -> SessionRelativeTimeState.AFTER
            else -> SessionRelativeTimeState.DURING
        }
    }

    fun zonedTime(time: ZonedDateTime, zoneId: ZoneId = ZoneId.systemDefault()): ZonedDateTime {
        return ZonedDateTime.ofInstant(time.toInstant(), zoneId)
    }

//    fun physicallyInConferenceTimeZone(): Boolean {
//        return ZoneId.systemDefault() == CONFERENCE_TIMEZONE
//    }

    fun abbreviatedTimeString(startTime: ZonedDateTime): String {
        return DateTimeFormatter.ofPattern("EEE, MMM d").format(startTime)
    }

    fun timeString(startTime: ZonedDateTime, endTime: ZonedDateTime): String {
        val sb = StringBuilder()
        sb.append(DateTimeFormatter.ofPattern("EEE, MMM d, h:mm ").format(startTime))

        val startTimeMeridiem: String = DateTimeFormatter.ofPattern("a").format(startTime)
        val endTimeMeridiem: String = DateTimeFormatter.ofPattern("a").format(endTime)
        if (startTimeMeridiem != endTimeMeridiem) {
            sb.append(startTimeMeridiem).append(" ")
        }

        sb.append(DateTimeFormatter.ofPattern("- h:mm a").format(endTime))
        return sb.toString()
    }

    fun conferenceHasStarted(): Boolean {
        return ZonedDateTime.now().isAfter(ConferenceDays.first().start)
    }

    fun conferenceHasEnded(): Boolean {
        return ZonedDateTime.now().isAfter(ConferenceDays.last().end)
    }

    fun conferenceWifiOfferingStarted(): Boolean {
        val wifiStartedTime = ZonedDateTime.parse(BuildConfig.CONFERENCE_WIFI_OFFERING_START)
        return ZonedDateTime.now().isAfter(wifiStartedTime)
    }
}