package nobleworks.libmpg.test;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.StringDescription;

/**
 * This class provides the asserThat methods that come with
 * jUnit 4.4 and above. Android has an older version of jUnit
 * that does not have this assertion. Attempting to include
 * the junit library and hamcrest fails due to duplicate
 * LICENSE.txt file. So I just duplicate the functionality
 * here.
 * @author Dale King
 */
public class HamcrestAssert
{
    /**
     * Asserts that <code>actual</code> satisfies the condition specified by
     * <code>matcher</code>. If not, an {@link AssertionError} is thrown with
     * information about the matcher and failing value. Example:
     *
     * <pre>
     * assertThat(0, is(1)); // fails:
     * // failure message:
     * // expected: is &lt;1&gt;
     * // got value: &lt;0&gt;
     * assertThat(0, is(not(1))) // passes
     * </pre>
     *
     * @param <T>
     * the static type accepted by the matcher (this can flag obvious
     * compile-time problems such as {@code assertThat(1, is("a"))}
     * @param actual
     * the computed value being compared
     * @param matcher
     * an expression, built of {@link Matcher}s, specifying allowed
     * values
     *
     * @see org.hamcrest.CoreMatchers
     * @see org.junit.matchers.JUnitMatchers
     */
     public static <T> void assertThat(T actual, Matcher<T> matcher)
     {
         assertThat("", actual, matcher);
     }

     /**
     * Asserts that <code>actual</code> satisfies the condition specified by
     * <code>matcher</code>. If not, an {@link AssertionError} is thrown with
     * the reason and information about the matcher and failing value. Example:
     *
     * <pre>
     * :
     * assertThat(&quot;Help! Integers don't work&quot;, 0, is(1)); // fails:
     * // failure message:
     * // Help! Integers don't work
     * // expected: is &lt;1&gt;
     * // got value: &lt;0&gt;
     * assertThat(&quot;Zero is one&quot;, 0, is(not(1))) // passes
     * </pre>
     *
     * @param reason
     * additional information about the error
     * @param <T>
     * the static type accepted by the matcher (this can flag obvious
     * compile-time problems such as {@code assertThat(1, is("a"))}
     * @param actual
     * the computed value being compared
     * @param matcher
     * an expression, built of {@link Matcher}s, specifying allowed
     * values
     *
     * @see org.hamcrest.CoreMatchers
     * @see org.junit.matchers.JUnitMatchers
     */
     public static <T> void assertThat(String reason, T actual, Matcher <T> matcher)
     {
         if (!matcher.matches(actual))
         {
             Description description= new StringDescription();
             description.appendText(reason);
             description.appendText("\nExpected: ");
             matcher.describeTo(description);
             description.appendText("\n got: ");
             description.appendValue(actual);
             description.appendText("\n");
             throw new java.lang.AssertionError(description.toString());
         }
     }
}
