package com.example.app

import androidx.annotation.StringRes

enum class Preferences(
    @StringRes val leftName:Int, @StringRes val rightName:Int, var withSwitch: Boolean
) {
   interfaceLanguage(R.string.app_interface_language,R.string.english,false),
    contentLanguage(R.string.content_language,R.string.russian,false),
    currency(R.string.currency,R.string.selected_currency,false),
    darkTheme(R.string.dark_theme,R.string.sys_design,false),
    adultContentRestrictions(R.string.adult_content,R.string.disabled,false),

    autoloadOnPlay(R.string.autoload,R.string.without,true),
    downloadOnlyViaWiFi(R.string.download_only_via_wifi,R.string.without,true),

    reportProblem(R.string.report,R.string.without,false)


}