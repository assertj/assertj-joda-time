AssertJ assertions for Joda Time library
========================================

Provides assertions like AssertJ for [Joda Time](http://joda-time.sourceforge.net/index.html), more precisely for [DateTime](http://joda-time.sourceforge.net/api-release/org/joda/time/DateTime.html) and [LocalDateTime](http://joda-time.sourceforge.net/api-release/org/joda/time/LocalDateTime.html) classes, more will come later but that's a start (contributions are welcome to add new assertions !).  
IMPORTANT : It requires AssertJ core.

* [Latest news](#news)
* [Quick start](#quickstart)
* [Tips & tricks](#tip)
* [Using both AssertJ Core assertions and Joda Time assertions](#core-and-joda-time-assertions)
* [Contributing](#contributing)

## <a name="news"/>Latest News

See [release-notes.txt](release-notes.txt) for full releases history.


## <a name="quickstart"/>Quick start

To start using Joda Time assertions, you just have to statically import `JODA_TIME.assertThat` and use your preferred IDE code completion after `assertThat.` !

Some examples  

```java
import static org.assertj.jodatime.api.JODA_TIME.assertThat;
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

AssertJ assertions for Joda Time is available in Maven Central

```xml
<dependency>
   <groupId>org.assertj</groupId>
   <artifactId>assertj-joda-time</artifactId>
   <version>1.0.0</version>
</dependency>
```

Note that you can find working example in [JodaTimeAssertionsExamples.java](https://github.com/joel-costigliola/assertj-examples/blob/master/src/test/java/org/assertj/examples/JodaTimeAssertionsExamples.java) from [assertj-examples](https://github.com/joel-costigliola/assertj-examples/) project.

## <a name="tip"/>Tips & tricks

To be even easier to use, one can specify `DateTime` or `LocalDateTime` with their String representation to avoid manual String conversion, like in the example below :

```java
// instead of writing ...
assertThat(dateTime).isBefore(new DateTime("2004-12-13T21:39:45.618-08:00"));
// ... you can simply write (if you prefer)
assertThat(dateTime).isBefore("2004-12-13T21:39:45.618-08:00");
```

## <a name="core-and-joda-time-assertions"/>Using both AssertJ [Core assertions](https://github.com/joel-costigliola/assertj-core) and Joda Time assertions

You will have to make two static import : one for `Assertions.assertThat` to get **core** assertions and one `JODA_TIME.assertThat` for **Joda Time** assertions.

```java
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.jodatime.api.JODA_TIME.assertThat;
...
// assertThat comes from org.assertj.jodatime.api.JODA_TIME.assertThat static import
assertThat(new DateTime("2000-01-01")).isAfter(new DateTime("1999-12-31"));

// assertThat comes from org.assertj.core.api.Assertions.assertThat static import
assertThat("hello world").startsWith("hello");
```

## <a name="contributing"/>Contributing

Thanks for your interest, check our [contributor's guidelines](CONTRIBUTING.md)


