package com.vvfy.coreui

/**
 * A generic class representing an event with a payload of type T.
 * It provides functionality to consume the event content only once and
 * to access the event content without consuming it.
 *
 * @param content The event content.
 */
class Event<out T>(private val content: T) {

    /**
     * A boolean property indicating whether the event has been used/consumed.
     */
    var used = false
        private set

    /**
     * Consumes the event content and marks the event as used.
     * @return The event content if it hasn't been consumed yet, or null if the event has already been used.
     */
    fun use(block: (T) -> Unit) {
        if (!used && content != null) {
            block(content)
        }
    }

    /**
     * @return The event content without consuming it.
     */
    fun peek(): T = content
}

fun <T : Any> T?.toEvent(): Event<T>? {
    return this?.let { Event(it) }
}