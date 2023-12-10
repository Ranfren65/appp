package com.example.app

import androidx.annotation.StringRes

enum class Preferences(
    @StringRes val leftName: Int, @StringRes val rightName: Int,
) {
    InterfaceLanguage(R.string.app_interface_language, R.string.english),
    ContentLanguage(R.string.content_language, R.string.russian),
    Currency(R.string.currency, R.string.selected_currency),
    DarkTheme(R.string.dark_theme, R.string.sys_design),
    AdultContentRestrictions(R.string.adult_content, R.string.disabled),
    AutoloadOnPlay(R.string.autoload, R.string.without),
    DownloadOnlyViaWiFi(R.string.download_only_via_wifi, R.string.without),
    ReportProblem(R.string.report, R.string.without)
}
