@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package types

import kotlin.js.*
import org.khronos.webgl.*
import PluginAPI

external val figma: PluginAPI

external var __html__: String

external object __uiFiles__ {
    @nativeGetter
    operator fun get(key: String): String?
    @nativeSetter
    operator fun set(key: String, value: String)
}

external var console: Console

external fun setTimeout(callback: Function<*>, timeout: Number): Number

external fun clearTimeout(handle: Number)

external fun setInterval(callback: Function<*>, timeout: Number): Number

external fun clearInterval(handle: Number)

external var fetch: (url: String, init: FetchOptions) -> Promise<FetchResponse>

external interface `T$0` {
    @nativeGetter
    operator fun get(name: String): String?
    @nativeSetter
    operator fun set(name: String, value: String)
}

external interface FetchOptions {
    var method: String?
        get() = definedExternally
        set(value) = definedExternally
    var headers: `T$0`?
        get() = definedExternally
        set(value) = definedExternally
    var headersObject: `T$0`?
        get() = definedExternally
        set(value) = definedExternally
    var body: dynamic /* Uint8Array? | String? */
        get() = definedExternally
        set(value) = definedExternally
    var credentials: String?
        get() = definedExternally
        set(value) = definedExternally
    var cache: String?
        get() = definedExternally
        set(value) = definedExternally
    var redirect: String?
        get() = definedExternally
        set(value) = definedExternally
    var referrer: String?
        get() = definedExternally
        set(value) = definedExternally
    var integrity: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface FetchResponse {
    var headersObject: `T$0`
    var ok: Boolean
    var redirected: Boolean
    var status: Number
    var statusText: String
    var type: String
    var url: String
    fun arrayBuffer(): Promise<ArrayBuffer>
    fun text(): Promise<String>
    fun json(): Promise<Any>
}
