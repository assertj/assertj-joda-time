Fest assertions for Joda Time library
========================================

Provides assertions like FEST Assert for org.joda.time.DateTime and org.joda.time.LocalDateTime classes. Examples

    JodaTimeAssertions.assertThat(dateTime).isBefore(laterDateTime);

Comparison methods are isBefore, isBeforeOrEqual, isAfter, isAfterOrEqual.

You can compare DateTime to another DateTime, or LocalDateTime to LocalDateTime, but not DateTime to LocalDateTime,
as it doesn't make sense because one is timezone dependent and the other one is not.
