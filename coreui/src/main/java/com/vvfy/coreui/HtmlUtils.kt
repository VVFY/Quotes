package com.vvfy.coreui

import android.os.Build
import android.text.Html
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.widget.TextView
import androidx.annotation.StringRes

@Suppress("DEPRECATION")
fun String.htmlSpanned(): Spanned {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        Html.fromHtml(this, Html.FROM_HTML_MODE_LEGACY)
    } else {
        Html.fromHtml(this)
    }
}

fun TextView.hyperlink(@StringRes id: Int) {
    text = context.getString(id).htmlSpanned()
    movementMethod = LinkMovementMethod.getInstance()
}