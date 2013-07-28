AssertJ assertions for Joda Time library
========================================

Provides assertions like AssertJ for [Joda Time](http://joda-time.sourceforge.net/index.html), more precisely for [DateTime](http://joda-time.sourceforge.net/api-release/org/joda/time/DateTime.html) and [LocalDateTime](http://joda-time.sourceforge.net/api-release/org/joda/time/LocalDateTime.html) classes, more will come later but that's a start (contributions are welcome to add new assertions !).

* [Quick start](#quickstart)
* [Latest news](#news)
* [Javadoc](#javadoc)
* [Migrating from Fest Joda Time assertions](#migrating-from-fest)
* [Tips & tricks](#tip)
* [Using both AssertJ Core assertions and Joda Time assertions](#core-and-joda-time-assertions)
* [Contributing](#contributing)

## <a name="quickstart"/>Quick start

To start using Joda Time assertions :

1 - Add this dependency snippet to your project

```xml
 <dependency>
   <groupId>org.assertj</groupId>
   <artifactId>assertj-joda-time</artifactId>
   <version>1.1.0</version>
   <scope>test</scope>
 </dependency>
```

2 - statically import `Assertions.assertThat` and use your preferred IDE code completion after `assertThat.` !

Some examples : 

```java
import static org.assertj.jodatime.api.Assertions.assertThat;
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

For `DateTime` assertions, comparison is performed in `DateTime`'s `DateTimeZone` thus the following assertion passes : 

```java
DateTime utcTime = new DateTime(2013, 6, 10, 0, 0, DateTimeZone.UTC);
DateTime cestTime = new DateTime(2013, 6, 10, 2, 0, DateTimeZone.forID("Europe/Berlin"));
assertThat(utcTime).as("in UTC time").isEqualTo(cestTime);
```

Available assertions are `isBefore`, `isBeforeOrEqualTo`, `isAfter`, `isAfterOrEqualTo` (base assertions like `isEqualTo` or `isIn` are of course available).

You can compare `DateTime` to another `DateTime`, or `LocalDateTime` to `LocalDateTime`, but not `DateTime` to `LocalDateTime`, it doesn't make sense as one is timezone dependent and the other one is not.

Note that you can find working examples in [JodaTimeAssertionsExamples.java](https://github.com/joel-costigliola/assertj-examples/blob/master/src/test/java/org/assertj/examples/JodaTimeAssertionsExamples.java) from [assertj-examples](https://github.com/joel-costigliola/assertj-examples/) project.

## <a name="news"/>Latest News
 
**2013-07-14 : 1.1.0 release :**
* In `DateTime` assertions, comparison is performed in the `DateTimeZone` of `DateTime` to check.
* assertj-joda-time does not impose joda-time 2.2 version anymore, it is compatible with any 2.0+ version.
* Multiline error message improvements to ease see what was wrong.
* Javadoc improvements : fix inconsistent documenation and add more code examples.

**2013-03-26 : 1.0.0 release : the first release after Fest fork.**

## <a name="javadoc"/>Javadoc of latest release

Latest javadoc release : [**AssertJ Joda Time javadoc**](http://joel-costigliola.github.io/assertj/jodatime/api/index.html).

## <a name="migrating-from-fest"/>Migrating from Fest Joda Time assertions

AssertJ Assertions for Joda Time is a fork form FEST Joda Time assertions and is part of AssertJ assertions portfolio.
The main reason for this fork is that FEST will only provide a small core of assertions in the future whereas I felt on the contrary that it should have provided more assertions.  
Another reason is that AssertJ projects are also more opened to community contributions than FEST ones.


Migrating from Fest Joda Time to AssertJ Joda Time Assertions is super easy, you only have to change your static import.  

Just replace :

```java 
import static org.fest.assertions.api.JODA_TIME
``` 

by :

```java 
import static org.assertj.jodatime.api.Assertions
```


## <a name="tip"/>Tips & tricks

To be even easier to use, one can specify `DateTime` or `LocalDateTime` with their String representation to avoid manual String conversion, like in the example below :

```java
// instead of writing ...
assertThat(dateTime).isBefore(new DateTime("2004-12-13T21:39:45.618-08:00"));
// ... you can simply write (if you prefer)
assertThat(dateTime).isBefore("2004-12-13T21:39:45.618-08:00");
```

## <a name="core-and-joda-time-assertions"/>Using both AssertJ [Core assertions](https://github.com/joel-costigliola/assertj-core) and Joda Time assertions

You will have to make two static import : one for `Assertions.assertThat` to get **core** assertions and one `Assertions.assertThat` for **Joda Time** assertions.

```java
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.jodatime.api.Assertions.assertThat;
...
// assertThat comes from org.assertj.jodatime.api.Assertions.assertThat static import
assertThat(new DateTime("2000-01-01")).isAfter(new DateTime("1999-12-31"));

// assertThat comes from org.assertj.core.api.Assertions.assertThat static import
assertThat("hello world").startsWith("hello");
```

## <a name="contributing"/>Contributing

Thanks for your interest, check our [contributor's guidelines](CONTRIBUTING.md).


