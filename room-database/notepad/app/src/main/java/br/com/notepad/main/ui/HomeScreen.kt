package br.com.notepad.main.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import br.com.notepad.R
import br.com.notepad.theme.SpaceSize

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun HomeScreenPreview() {
    HomeScreen()
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize().padding(SpaceSize.spaceSize36)) {
        CreateNote()
    }
}

@Composable
fun CreateNote(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.End,
        modifier = modifier
            .fillMaxSize()
            .fillMaxWidth()
            .wrapContentHeight(Alignment.Bottom)
    ) {
        FloatingActionButton(onClick = { /*TODO*/ }) {
            Icon(Icons.Default.Create, stringResource(id = R.string.create_note))
        }
    }
}