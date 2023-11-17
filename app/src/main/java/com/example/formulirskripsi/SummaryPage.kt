package com.example.formulirskripsi

import com.example.formulirskripsi.data.FormUIState

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight

@Composable
fun SummaryPage(
    formUIState: FormUIState,
    onCancelButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    val items = listOf(
        Pair(stringResource(R.string.nama), formUIState.nama),
        Pair(stringResource(R.string.nim), formUIState.nim),
        Pair(stringResource(R.string.konsen), formUIState.konsen),
        Pair(stringResource(R.string.judul), formUIState.judul),
        Pair(stringResource(R.string.dosbing1), formUIState.dobing1),
        Pair(stringResource(R.string.dosbing2), formUIState.dobing2),
    )

    Column(
        modifier = Modifier
            .padding(dimensionResource(id = R.dimen.padding_medium))
    ) {
        items.forEach { item ->
            Row(
                modifier = Modifier.padding(vertical = dimensionResource(id = R.dimen.padding_small))
            ) {
                Text(item.first.uppercase())
                Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.padding_medium)))
                Text(text = item.second.toString(), fontWeight = FontWeight.Bold)
            }
            Divider(thickness = dimensionResource(id = R.dimen.thickness_divider))
        }
        Spacer(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_medium)))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = dimensionResource(id = R.dimen.padding_medium))
        ) {
            Button(
                modifier = Modifier.weight(1f),
                onClick = {}
            ) {
                Text(stringResource(id = R.string.next))
            }
            Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.padding_medium)))
            OutlinedButton(
                modifier = Modifier.weight(1f),
                onClick = onCancelButtonClicked
            ) {
                Text(stringResource(id = R.string.back))
            }
        }
    }
}