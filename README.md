Fest assertions for Joda Time library
========================================

Provides assertions like FEST Assert for [Joda Time](http://joda-time.sourceforge.net/index.html), more precisely for [DateTime](http://joda-time.sourceforge.net/api-release/org/joda/time/DateTime.html) and [LocalDateTime](http://joda-time.sourceforge.net/api-release/org/joda/time/LocalDateTime.html) classes, more will come later but that's a start (contributions are welcome to add new assertions !).

* [Latest news](#news)
* [Quick start](#quickstart)
* [Tips & tricks](#tip)
* [Using both FEST Core assertions and Joda Time assertions](#core-and-joda-time-assertions)

## <a name="news"/>Latest News

#### 2013-02-12 : 1.1.0 version released

New features :
* github #5 : DateTime and LocalDateTime equals comparison with a precision level

One can now compare DateTime and LocalDateTime ignoring millisecond to hour fields in comparison, see the examples below :

```java
// comparing DateTime ignoring milliseconds.
DateTime dateTime1 = new DateTime(2000, 1, 1, 0, 0, 1, 0, UTC);
DateTime dateTime2 = new DateTime(2000, 1, 1, 0, 0, 1, 456, UTC);
assertThat(dateTime1).isEqualToIgnoringMillis(dateTime2); // OK

// comparing DateTime ignoring hours, minutes, seconds and milliseconds.
DateTime dateTime1 = new DateTime(2000, 1, 1, 23, 59, 59, 999);
DateTime dateTime2 = new DateTime(2000, 1, 1, 00, 00, 00, 000);
assertThat(dateTime1).isEqualToIgnoringHours(dateTime2); // OK
```

See [release-notes.txt](https://raw.github.com/joel-costigliola/fest-joda-time-assert/master/release-notes.txt) for full releases history.


## <a name="quickstart"/>Quick start

To start using Joda Time assertions, you just have to statically import `JODA_TIME.assertThat` and use your preferred IDE code completion after `assertThat.` !

Some examples  

```java
import static org.fest.assertions.api.JODA_TIME.assertThat;
...
assertThat(dateTime).isBefore(firstDateTime);
assertThat(dateTime).isAfterOrEqualTo(secondDateTime);

// you can use directly String in comparison to avoid a conversion (we do that for you)
assertThat(new DateTime("2000-01-01")).isEqualTo("2000-01-01");

// compare DateTime or LocalDateTime with a precision level, ignoring time fields 
dateTime1 = new DateTime(2000, 1, 1, 23, 50, 0, 0, UTC);
dateTime2 = new DateTime(2000, 1, 1, 23, 50, 10, 456, UTC);
// ignore seconds and milliseconds in comparison
assertThat(dateTime1).isEqualToIgnoringSeconds(dateTime2);

```

Available assertions are `isBefore`, `isBeforeOrEqualTo`, `isAfter`, `isAfterOrEqualTo` (base assertions like `isEqualTo` or `isIn` are of course available).

You can compare `DateTime` to another `DateTime`, or `LocalDateTime` to `LocalDateTime`, but not `DateTime` to `LocalDateTime`,
it doesn't make sense because one is timezone dependent and the other one is not.

Fest assertions for Joda Time is available in Maven Central

```xml
<dependency>
   <groupId>org.easytesting</groupId>
   <artifactId>fest-joda-time-assert</artifactId>
   <version>1.1.0</version>
</dependency>
```

Note that you can find working example in [JodaTimeAssertionsExamples.java](https://github.com/joel-costigliola/fest-examples/blob/master/src/main/java/org/fest/assertions/examples/JodaTimeAssertionsExamples.java) from [fest-examples](https://github.com/joel-costigliola/fest-examples/) project.

## <a name="tip"/>Tips & tricks

To be even easier to use, one can specify `DateTime` or `LocalDateTime` with their String representation to avoid manual String conversion, like in the example below :

```java
// instead of writing ...
assertThat(dateTime).isBefore(new DateTime("2004-12-13T21:39:45.618-08:00"));
// ... you can simply write (if you prefer)
assertThat(dateTime).isBefore("2004-12-13T21:39:45.618-08:00");
```

## <a name="core-and-joda-time-assertions"/>Using both FEST [Core assertions](https://github.com/alexruiz/fest-assert-2.x/wiki) and Joda Time assertions

You will have to make two static import : one for `Assertions.assertThat` to get **core** assertions and one `JODA_TIME.assertThat` for **Joda Time** assertions.

```java
import static org.fest.assertions.api.Assertions.assertThat;
import static org.fest.assertions.api.JODA_TIME.assertThat;
...
// assertThat comes from org.fest.assertions.api.JODA_TIME.assertThat static import
assertThat(new DateTime("2000-01-01")).isAfter(new DateTime("1999-12-31"));

// assertThat comes from org.fest.assertions.api.Assertions.assertThat static import
assertThat("hello world").startsWith("hello");
```


