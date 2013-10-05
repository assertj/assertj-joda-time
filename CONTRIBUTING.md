Contributing
============

Thank you for your interest in contributing to AssertJ assertions !  
We appreciate your effort and to make sure that your pull request is easy to review, we ask you to make note of the following guidelines :

* Use **[AssertJ code Eclipse formatting preferences](https://github.com/joel-costigliola/assertj-core/blob/master/src/ide-support/assertj-eclipse-formatter.xml)** (for Idea users, it is possible to import it)
* Write complete Javadocs on each assertion methods including a code example.
* Write one JUnit test class for each assertion method with the following naming convention : `<AssertClass>_<assertion>_Test`. 
* Unit tests method naming convention is underscore based (like python) and not camel case, we find it is much readable for long test names !
* Successfull assertion unit test method name must start with : `should_pass_...`.
* Failing assertion unit test method name must start with : `should_fail_...`.
* If possible, add a (fun) code example in [assertj-examples](https://github.com/joel-costigliola/assertj-examples) and use it in the javadoc. 

Example with `DateTimeAssert` : 

Among `DateTimeAssert` assertions you can find : `isBefore`, `isAfter`, `isEqualToIgnoringHours`, with the corresponding test classes : 
* `DateTimeAssert_isBefore_Test`
* `DateTimeAssert_isAfter_Test`
* `DateTimeAssert_isEqualToIgnoringHours_Test`

Let's look at `DateTimeAssert_isEqualToIgnoringHours_Test` tests names :
* `should_pass_if_actual_is_equal_to_other_ignoring_hours`
* `should_fail_if_actual_is_not_equal_to_given_datetime_with_hours_ignored`
* `should_fail_as_hours_fields_are_different_even_if_time_difference_is_less_than_a_hour`
* `should_fail_if_actual_is_null`
