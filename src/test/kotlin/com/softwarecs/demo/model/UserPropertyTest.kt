package com.softwarecs.demo.model

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.property.Arb
import io.kotest.property.arbitrary.filter
import io.kotest.property.arbitrary.localDate
import io.kotest.property.forAll
import java.time.LocalDate

class UserPropertyTest : AnnotationSpec() {

    private val user = User(firstname = "Hasta", lastname = "La Vista", birthday = LocalDate.of(1991, 5, 2), friends = setOf())

    @Test
    suspend fun `is always birthday`() {
        forAll(Arb.localDate(LocalDate.of(1991, 5, 2))
                .filter { date -> date.month == user.birthday.month && date.dayOfMonth == user.birthday.dayOfMonth }) { generatedDate ->
            user.isBirthday(generatedDate)
        }
    }

    @Test
    suspend fun `is never birthday`() {
        forAll(Arb.localDate(LocalDate.of(1991, 5, 2))
                .filter { date -> date.month != user.birthday.month || date.dayOfMonth != user.birthday.dayOfMonth }) { generatedDate ->
            !user.isBirthday(generatedDate)
        }
    }

}