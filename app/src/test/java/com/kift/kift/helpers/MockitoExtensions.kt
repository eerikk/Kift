package com.kift.storage.helpers


import com.kift.storage.models.Event
import org.junit.Assert
import org.mockito.Mockito
import org.mockito.stubbing.OngoingStubbing
import org.mockito.verification.VerificationMode

/**
 * Created by kaspar on 03/08/2017.
 */
inline fun <reified T : Any> mock(): T = Mockito.mock(T::class.java)

fun <T> verify(mock: T): T = Mockito.verify(mock)!!
fun <T> verify(mock: T, mode: VerificationMode): T = Mockito.verify(mock, mode)!!


fun <T> whenever(methodCall: T): OngoingStubbing<T> = Mockito.`when`(methodCall)!!

fun <T> reset(vararg mocks: T) = Mockito.reset(*mocks)

@Suppress("UNCHECKED_CAST")
fun <T> uninitialized(): T = null as T

/** Matches any object, excluding nulls. */
inline fun <reified T : Any> any() = Mockito.any(T::class.java)

/** Matches anything, including nulls. */
inline fun <reified T : Any> anyOrNull(): T = Mockito.any<T>()

/** Matches any vararg object, including nulls. */
inline fun <reified T : Any> anyVararg(): T = Mockito.any<T>()

/** Matches any array of type T. */
inline fun <reified T : Any?> anyArray(): Array<T> = Mockito.any(Array<T>::class.java) ?: arrayOf()

fun <T> anyObject(): T {
    @Suppress("DEPRECATION")
    Mockito.anyObject<T>()
    return uninitialized()
}

fun <T> assertListEquals(expected: List<T>, actual: List<T>) {
    if (expected.toString() != actual.toString())
        throw AssertionError("Lists do not match!")
}
