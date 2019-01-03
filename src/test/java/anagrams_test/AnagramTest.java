package anagrams_test;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AnagramTest {
    @Test
    public void the_anagram_of_an_empty_string_should_be_itself() {
        assertThat(Anagram.ofForStepEnd(""), is(Arrays.asList("")));
    }

    @Test
    public void the_anagram_of_a_one_letter_string_should_be_itself() {
        assertThat(Anagram.ofForStepEnd("a"), is(Arrays.asList("a")));
    }

    @Test
    public void the_number_of_the_anagram_of_a_two_letter_string_should_be_2() {
        assertThat(Anagram.ofForStepFive("ab"), is(Arrays.asList("ab", "ba")));
    }

    @Test
    public void the_number_of_the_anagram_of_a_three_letter_string_should_be_6() {
        assertThat(Anagram.ofForStepFive("abc"), is(Arrays.asList("abc", "acb", "bac", "bca", "cab", "cba")));
    }

    @Test
    public void the_number_of_the_anagram_of_a_four_letter_string_should_be_24() {
        assertThat(Anagram.ofForStepEnd("abcd").size(), is(24));
    }

    @Test
    public void the_number_of_the_anagram_of_a_five_letter_string_should_be_120() {
        assertThat(Anagram.ofForStepEnd("abcde").size(), is(120));
    }
}
