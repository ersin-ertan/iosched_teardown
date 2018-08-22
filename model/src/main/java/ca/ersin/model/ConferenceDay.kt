package ca.ersin.model

import org.threeten.bp.ZonedDateTime
import org.threeten.bp.format.DateTimeFormatter
import java.util.*

private const val formatPattern = "MMMM d"

val FORMATTER_MONTH_DAY: DateTimeFormatter =
        DateTimeFormatter.ofPattern(formatPattern, Locale.getDefault())

data class ConferenceDay(val start: ZonedDateTime, val end: ZonedDateTime) {
    fun contains(session: Session) = start <= session.startTime && end >= session.endTime

    fun formatMonthDay(): String = FORMATTER_MONTH_DAY.format(start)
}