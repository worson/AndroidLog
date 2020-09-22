package app.worson.lib.log

import android.util.Log
import java.io.PrintWriter
import java.io.StringWriter

/**
 * 说明:
 * @author wangshengxing  09.22 2020
 */

object L {
    private var logLevel = Log.INFO

    const val TAG_PREFIX = "LogX"


    fun init(logLevel: Int) {
        L.i("init#logLevel=${logLevel}")
        this.logLevel = logLevel
    }

    @JvmStatic
    @Deprecated("please use msg:() -> Any?")
    fun d(msg: Any?) {
        log(priority = Log.DEBUG, tag = TAG_PREFIX, holder = { msg })
    }

    @JvmStatic
    @Deprecated("please use msg:() -> Any?")
    fun d(tag: String, msg: Any?) {
        log(priority = Log.DEBUG, tag = "${TAG_PREFIX}#$tag", holder = { msg })
    }

    @JvmStatic
    fun d(msg: () -> Any?) {
        log(priority = Log.DEBUG, tag = TAG_PREFIX, holder = msg)
    }


    @JvmStatic
    fun d(tag: String, msg: () -> Any?) {
        log(priority = Log.DEBUG, tag = "${TAG_PREFIX}#$tag", holder = msg)
    }

    @JvmStatic
    @Deprecated("please use msg:() -> Any?")
    fun i(msg: Any?) {
        log(priority = Log.INFO, tag = TAG_PREFIX, holder = { msg })
    }

    @JvmStatic
    @Deprecated("please use msg:() -> Any?")
    fun i(tag: String, msg: Any?) {
        log(priority = Log.INFO, tag = "${TAG_PREFIX}#$tag", holder = { msg })
    }

    @JvmStatic
    fun i(msg: () -> Any?) {
        log(priority = Log.INFO, tag = TAG_PREFIX, holder = msg)
    }

    @JvmStatic
    fun i(tag: String, msg: () -> Any?) {
        log(priority = Log.INFO, tag = "${TAG_PREFIX}#$tag", holder = msg)
    }

    @JvmStatic
    fun w(msg: Any?) {
        log(priority = Log.WARN, tag = TAG_PREFIX, holder = { msg })
    }

    @JvmStatic
    fun w(tag: String, msg: Any?) {
        log(priority = Log.WARN, tag = "${TAG_PREFIX}#$tag", holder = { msg })
    }

    @JvmStatic
    fun w(msg: () -> Any?) {
        log(priority = Log.WARN, tag = TAG_PREFIX, holder = msg)
    }

    @JvmStatic
    fun w(tag: String, msg: () -> Any?) {
        log(priority = Log.WARN, tag = "${TAG_PREFIX}#$tag", holder = msg)
    }

    @JvmStatic
    fun e(msg: Any?) {
        log(priority = Log.ERROR, tag = TAG_PREFIX, holder = { msg })
    }

    @JvmStatic
    fun e(tag: String, msg: Any?) {
        log(priority = Log.ERROR, tag = "${TAG_PREFIX}#$tag", holder = { msg })
    }

    @JvmStatic
    fun e(tag: String, msg: Any?, throwable: Throwable?) {
        log(
            priority = Log.ERROR,
            tag = "${TAG_PREFIX}#$tag",
            msg = throwable?.let {
                "$msg\n${throwableToString(throwable)}"
            } ?: "throwable is null"
        )
    }

    @JvmStatic
    fun wtf(msg: Any?) {
        log(priority = Log.ASSERT, tag = TAG_PREFIX, holder = { msg })
    }

    @JvmStatic
    fun wtf(tag: String, msg: Any?) {
        log(priority = Log.ASSERT, tag = "${TAG_PREFIX}#$tag", holder = { msg })
    }


    private fun throwableToString(throwable: Throwable): String {
        val sw = StringWriter(256)
        val pw = PrintWriter(sw, false)
        throwable.printStackTrace(pw)
        pw.flush()

        return sw.toString()
    }

    @JvmStatic
    private fun log(priority: Int, tag: String, msg: Any?) {
        if (logLevel <= priority) {
            val message = if (msg is Throwable) {
                val sw = StringWriter(256)
                val pw = PrintWriter(sw, false)
                msg.printStackTrace(pw)
                pw.flush()
                sw.toString()
            } else {
                msg?.toString() ?: "null"
            }
            Log.println(priority, tag, message)
        }
    }


    @JvmStatic
    private fun log(priority: Int, tag: String, holder: () -> Any?) {
        if (logLevel <= priority) {
            val msg = holder()
            val message = if (msg is Throwable) {
                val sw = StringWriter(256)
                val pw = PrintWriter(sw, false)
                msg.printStackTrace(pw)
                pw.flush()
                sw.toString()
            } else {
                msg?.toString() ?: "null"
            }
            Log.println(priority, tag, message)
        }

    }


}
