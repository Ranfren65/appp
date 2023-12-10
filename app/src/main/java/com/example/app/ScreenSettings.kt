package com.example.app


import androidx.annotation.StringRes
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
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
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
fun ScreenSettings(@StringRes columnName: Int) {
    val textSize = 15.sp

    val interfaceLanguage = Preferences.InterfaceLanguage

    val contentLanguage = Preferences.ContentLanguage

    val currency = Preferences.Currency

    val darkTheme = Preferences.DarkTheme

    val adultContentRestrictions = Preferences.AdultContentRestrictions

    val autoloadOnPlay = Preferences.AutoloadOnPlay

    val downloadOnlyViaWiFi = Preferences.DownloadOnlyViaWiFi

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
            .background(Color.Transparent),

        ) {

        Column(
            Modifier
                .fillMaxWidth()
                .background(Color.Transparent),
            horizontalAlignment = Alignment.Start,
        ) {

            Row(
                Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(start = 15.dp)
                    .padding(top = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    stringResource(id = columnName),
                    fontSize = textSize,
                )
            }
            for (row in rowsWithoutSwitch) {

                RowView(
                    row
                )

                Divider(
                    color = Color.Transparent,
                    modifier = Modifier.padding(top = 1.dp)
                )
            }
            for (row in rowsWithSwitch) {

                RowWithSwitch(
                    row
                )

                Divider(
                    modifier = Modifier.padding(top = 1.dp)
                )
            }

            Row(
                modifier = Modifier
                    .height(3.dp)
                    .fillMaxWidth()
                    .background(colorResource(id = R.color.gray))
                    .padding(top = 2.dp)
            ) {}
        }
    }
}

@Composable
private fun RowWithSwitch(
    preference: Preferences,
    modifier: Modifier = Modifier,
) {
    var checkedState by remember { mutableStateOf(false) }

    val textSize = 15.sp

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
            fontSize = textSize,

            modifier = Modifier

        )

        Spacer(modifier = Modifier.weight(1.0f))

            Switch(
                checked = checkedState,
                onCheckedChange = { checkedState = it }
            )

            Image(
                painter = painterResource(id = R.drawable.triangle),
                contentDescription = "triangle",
                modifier = Modifier
                    .padding(horizontal = 13.dp)
                    .size(10.dp)
            )
        }
    }


@Composable
private fun RowView(
    preference: Preferences,
    modifier: Modifier = Modifier,
) {
    val textSize = 15.sp

    Row(
        Modifier
            .safeContentPadding()
            .fillMaxWidth()
            .clickable {
            }
            .height(45.dp)
            .background(Color.White)
            .padding(start = 15.dp, end = 2.dp),

        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(

            stringResource(preference.leftName),
            fontSize = textSize,
            modifier = Modifier
        )

        Spacer(modifier = Modifier.weight(1.0f))


        Text(
            stringResource(id = preference.rightName),
            modifier = Modifier.alpha(0.7f),
            fontSize = textSize,
        )

        Image(
            painter = painterResource(id = R.drawable.triangle),
            contentDescription = "triangle",
            modifier = Modifier
                .padding(horizontal = 13.dp)
                .size(10.dp)
        )
    }
}
@Composable
private fun RowMaker(modifier: Modifier,
                     preference: Preferences,
                     content:@Composable() -> Unit){

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

            modifier = Modifier

        )

        Spacer(modifier = Modifier.weight(1.0f))

        content


    }
}

@Preview
@Composable
private fun SettingsScreenPreview() {
    val pref = Preferences.ReportProblem

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.light_gray))
    ) {

        Column(
            modifier = Modifier.fillMaxSize()
        ) {

            ScreenSettings(R.string.settings)

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(start = 15.dp)
                    .padding(top = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(stringResource(id = R.string.support))
            }

            RowView(preference = pref)
        }
    }
}
