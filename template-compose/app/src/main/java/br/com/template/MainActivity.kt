package br.com.template

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import br.com.components.pieces.SpaceSize
import br.com.components.ui.Title
import br.com.template.ui.theme.TemplatecomposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TemplatecomposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ShowComponents()
                }
            }
        }
    }
}

@Composable
fun ShowComponents(modifier: Modifier = Modifier) {
    Title(
        title = "stringResource(id = R.string.app_name)",
        modifier = Modifier
            .background(Color.Red)
            .padding(SpaceSize.spaceSize32)
            .fillMaxSize()
    )
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    TemplatecomposeTheme {
        ShowComponents()
    }
}