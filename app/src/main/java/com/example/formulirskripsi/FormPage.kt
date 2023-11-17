package com.example.formulirskripsi

import android.icu.text.FormattedValue
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.formulirskripsi.data.DataSources
import com.example.formulirskripsi.data.DataSources.dosbing

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormPage(
    onSubmitButtonClicked: (MutableList<String>) -> Unit,
    onCancelButtonClicked: () -> Unit,
) {
    var txtName by rememberSaveable {
        mutableStateOf("")
    }
    var txtNIM by rememberSaveable {
        mutableStateOf("")
    }
    var txtKonsen by rememberSaveable {
        mutableStateOf("")
    }
    var txtJudul by rememberSaveable {
        mutableStateOf("")
    }
    var txtDosbing1 by rememberSaveable {
        mutableStateOf("")
    }
    var txtDosbing2 by rememberSaveable {
        mutableStateOf("")
    }
    var listDataTxt: MutableList<String> = mutableListOf(txtName, txtNIM, txtKonsen, txtJudul,txtDosbing1, txtDosbing2)
    val context = LocalContext.current
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(dimensionResource(id = R.dimen.padding_medium))
            .fillMaxSize()
    ) {
        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = stringResource(id = R.string.form),
            style = MaterialTheme.typography.headlineMedium)
        OutlinedTextField(
            value = txtName,
            onValueChange = { txtName = it },
            label = {
                Text(text = stringResource(id = R.string.nama))
            }
        )
        OutlinedTextField(
            value = txtNIM,
            onValueChange = { txtNIM = it },
            label = {
                Text(text = stringResource(id = R.string.nim))
            }
        )
        OutlinedTextField(
            value = txtKonsen,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onValueChange = { txtKonsen = it },
            label = {
                Text(text = stringResource(id = R.string.konsen))
            }
        )
        OutlinedTextField(
            value = txtJudul,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onValueChange = { txtJudul = it },
            label = {
                Text(text = stringResource(id = R.string.judul))
            }
        )
        Row {
            Column {
                Text(text = "Dosen Pembimbing 1 :")
                SelectDosbing1(
                    options = dosbing.map { id -> context.resources.getString(id) },
                )
            }
            Column {
                Text(text = "Dosen pembimbing 2 :")
                SelectDosbing2(
                    options = dosbing.map { id -> context.resources.getString(id) },)
            }
        }
        Spacer(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_medium)))
        Button(onClick = { onSubmitButtonClicked(listDataTxt) }) {
            Text(text = stringResource(id = R.string.submit))
        }
    }
}

@Composable
fun SelectDosbing1(
    options: List<String>,
    onSelectionChanged: (String) -> Unit = {}
) {
    var selectedValue by rememberSaveable { mutableStateOf("") }
    Column (
        modifier = Modifier
            .padding(10.dp)
    ){
        options.forEach{
                item ->
            Row(
                modifier = Modifier
                    .selectable(
                        selected = selectedValue == item,
                        onClick = {
                            selectedValue = item
                            onSelectionChanged(item)
                        }
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(selected = selectedValue == item,
                    onClick = {
                        selectedValue = item
                        onSelectionChanged(item)
                    }
                )
                Text(item)
            }
        }
    }
}

@Composable
fun SelectDosbing2(
    options: List<String>,
    onSelectionChanged: (String) -> Unit = {}
) {
    var selectedValue by rememberSaveable { mutableStateOf("") }
    Column (
        modifier = Modifier
            .padding(10.dp)
    ){
        options.forEach{
                item ->
            Row(
                modifier = Modifier
                    .selectable(
                        selected = selectedValue == item,
                        onClick = {
                            selectedValue = item
                            onSelectionChanged(item)
                        }
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(selected = selectedValue == item,
                    onClick = {
                        selectedValue = item
                        onSelectionChanged(item)
                    }
                )
                Text(item)
            }
        }
    }
}