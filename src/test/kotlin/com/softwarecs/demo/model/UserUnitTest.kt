package com.softwarecs.demo.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.time.LocalDate

class UserUnitTest {

    private val user = User(firstname = "Hasta", lastname = "La Vista", birthday = LocalDate.of(1991, 5, 2), friends = setOf())

    @Test
    fun `is birthday - unit test mode`() {
        assertThat(user.isBirthday(LocalDate.of(1992, 5, 2))).isTrue
        assertThat(user.isBirthday(LocalDate.of(1995, 5, 2))).isTrue
        assertThat(user.isBirthday(LocalDate.of(2000, 5, 2))).isTrue
    }

    @Test
    fun `is not birthday - unit test mode`() {
        assertThat(user.isBirthday(LocalDate.of(1992, 8, 2))).isFalse
        assertThat(user.isBirthday(LocalDate.of(2010, 7, 10))).isFalse
        assertThat(user.isBirthday(LocalDate.of(2000, 1, 22))).isFalse
    }

    @ParameterizedTest
    @ValueSource(strings = ["1992-05-02", "1995-05-02", "2000-05-02"])
    fun `is birthday - parameterized test mode`(dateAsString: String) {
        assertThat(user.isBirthday(LocalDate.parse(dateAsString))).isTrue
    }

    @ParameterizedTest
    @ValueSource(strings = ["1992-08-02", "2010-07-10", "2000-01-22"])
    fun `is not birthday - parameterized test mode`(dateAsString: String) {
        assertThat(user.isBirthday(LocalDate.parse(dateAsString))).isFalse
    }

}