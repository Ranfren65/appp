package com.example.app

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding

import androidx.compose.material3.Divider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ScreenSettings(
    modifier: Modifier = Modifier,
) {
    val interfaceLanguage = Preferences.InterfaceLanguage
    val contentLanguage = Preferences.ContentLanguage
    val currency = Preferences.Currency
    val darkTheme = Preferences.DarkTheme
    val adultContentRestrictions = Preferences.AdultContentRestrictions
    val autoloadOnPlay = Preferences.AutoloadOnPlay
    val downloadOnlyViaWiFi = Preferences.DownloadOnlyViaWiFi
    val reportProblem = Preferences.ReportProblem

    val rowsWithoutSwitch = listOf(
        interfaceLanguage, contentLanguage,
        currency,
        darkTheme,
        adultContentRestrictions,
    )
    val rowsWithSwitch = listOf(
        autoloadOnPlay,
        downloadOnlyViaWiFi
    )

    Box(
        Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.light_gray)),

        ) {

        Column(
            Modifier
                .fillMaxWidth()
                .background(Color.Transparent),
            horizontalAlignment = Alignment.Start,
        ) {
            ContentName(stringResource(R.string.settings))

            for (row in rowsWithoutSwitch) {
                TextRow(
                    row
                )

                Divider(
                    color = Color.Transparent,
                    modifier = Modifier.padding(top = 1.dp)
                )
            }
            for (row in rowsWithSwitch) {
                SwitchRow(
                    row
                )

                Divider(
                    modifier = Modifier.padding(top = 1.dp)
                )
            }

            Divider(
                color = colorResource(R.color.gray),
                thickness = 2.dp
            )
            ContentName(stringResource(R.string.report))
            TextRow(reportProblem)
        }
    }
}

@Composable
private fun TextRow(preference: Preferences) {
    Row(
        Modifier
            .clickable { }
    ) {
        RowMaker(
            Modifier,
            preference,
            content = {
                Text(
                    text = stringResource(id = preference.rightName),
                    Modifier
                        .padding(10.dp)
                        .alpha(0.75f)
                )
            }
        )

        Image(painter = painterResource(id = R.drawable.triangle), contentDescription = "triangle")
    }
}

@Composable
private fun SwitchRow(preference: Preferences) {
    var checkedState by remember { mutableStateOf(false) }

    RowMaker(
        Modifier,
        preference,
        content = { Switch(checked = checkedState, onCheckedChange = { checkedState = it }) }
    )
}

@Composable
private fun ContentName(contentName: String) {
    Row(
        Modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(start = 15.dp)
            .padding(top = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = contentName,
            fontSize = 15.sp,
        )
    }
}

@Composable
private fun RowMaker(
    modifier: Modifier = Modifier,
    preference: Preferences,
    content: @Composable () -> Unit,
) {


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(45.dp)
            .background(Color.White)
            .padding(start = 15.dp, end = 2.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            stringResource(preference.leftName),
            fontSize = 15.sp,
            modifier = Modifier
        )

        Spacer(modifier = Modifier.weight(1.0f))

        content()
    }
}

@Preview
@Composable
private fun ScreenSettingsPreview() {
    ScreenSettings()
}
