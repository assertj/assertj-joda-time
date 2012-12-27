Fest assertions for [Joda Time](http://joda-time.sourceforge.net/index.html) library
========================================

Provides assertions like FEST Assert for Joda Time, more precisely for [DateTime](http://joda-time.sourceforge.net/api-release/org/joda/time/DateTime.html) and [LocalDateTime](http://joda-time.sourceforge.net/api-release/org/joda/time/LocalDateTime.html) classes, more will come later but that's a start (contributions are welcome to add new assertions !).

## Quick start

To start using Joda Time assertions, you just have to statically import `JODA_TIME.assertThat` and use your preferred IDE code completion after `assertThat.` !
 
Code example 

```java
import static org.fest.assertions.api.JODA_TIME.assertThat;
...
assertThat(dateTime).isBefore(firstDateTime);
assertThat(dateTime).isAfterOrEqualTo(secondDateTime);
```

Available assertions are `isBefore`, `isBeforeOrEqualTo`, `isAfter`, `isAfterOrEqualTo` (base assertions like `isEqualTo` or `isIn` are of course available).

You can compare `DateTime` to another `DateTime`, or `LocalDateTime` to `LocalDateTime`, but not `DateTime` to `LocalDateTime`,
it doesn't make sense because one is timezone dependent and the other one is not.

## Tip

To be even easier to use, one can specify `DateTime` or `LocalDateTime` with their String representation to avoid manual String conversion, like in the example below :

```java
// instead of writing ...
assertThat(dateTime).isBefore(new DateTime("2004-12-13T21:39:45.618-08:00"));
// ... you can simply write (if you prefer)
assertThat(dateTime).isBefore("2004-12-13T21:39:45.618-08:00");
```

## Using both FEST [Core assertions](https://github.com/alexruiz/fest-assert-2.x/wiki) and Joda Time assertions

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

