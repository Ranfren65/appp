package com.example.app

import androidx.annotation.StringRes

enum class Preferences(
    @StringRes val leftName:Int, @StringRes val rightName:Int, var withSwitch: Boolean
) {
    InterfaceLanguage(R.string.app_interface_language,R.string.english,false),
    ContentLanguage(R.string.content_language,R.string.russian,false),
    Currency(R.string.currency,R.string.selected_currency,false),
    DarkTheme(R.string.dark_theme,R.string.sys_design,false),
    AdultContentRestrictions(R.string.adult_content,R.string.disabled,false),
    AutoloadOnPlay(R.string.autoload,R.string.without,true),
    DownloadOnlyViaWiFi(R.string.download_only_via_wifi,R.string.without,true),
    ReportProblem(R.string.report,R.string.without,false)
}