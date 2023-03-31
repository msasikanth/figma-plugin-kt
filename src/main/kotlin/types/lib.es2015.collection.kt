@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package types

import kotlin.js.*

external interface ReadonlyMap<K, V> {
    fun entries(): IterableIterator<dynamic /* JsTuple<K, V> */>
    fun keys(): IterableIterator<K>
    fun values(): IterableIterator<V>
    fun forEach(callbackfn: (value: V, key: K, map: ReadonlyMap<K, V>) -> Unit, thisArg: Any = definedExternally)
    fun get(key: K): V?
    fun has(key: K): Boolean
    var size: Number
}
