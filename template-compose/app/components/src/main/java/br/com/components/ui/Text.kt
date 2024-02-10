package br.com.components.ui

import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import br.com.components.R
import br.com.components.pieces.Typography

@Preview(showBackground = true)
@Composable
fun TitlePreview() {
    Title(title = stringResource(id = R.string.template))
}

@Composable
fun Title(
    modifier: Modifier = Modifier,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
    title: String
) {
    BasicText(
        text = title,
        modifier = modifier,
        style = Typography(textAlign = textAlign).title,
        maxLines = maxLines
    )
}

@Preview(showBackground = true)
@Composable
fun SubTitlePreview() {
    SubTitle(subTitle = stringResource(id = R.string.template))
}

@Composable
fun SubTitle(
    subTitle: String,
    modifier: Modifier = Modifier,
    maxLines: Int = Int.MAX_VALUE,
    textAlign: TextAlign? = null
) {
    BasicText(
        text = subTitle,
        modifier = modifier,
        style = Typography(textAlign = textAlign).subTitle,
        maxLines = maxLines
    )
}

@Preview(showBackground = true)
@Composable
fun DescriptionPreview() {
    Description(description = stringResource(id = R.string.template))
}

@Composable
fun Description(
    description: String,
    modifier: Modifier = Modifier,
    maxLines: Int = Int.MAX_VALUE,
    textAlign: TextAlign? = null
) {
    BasicText(
        text = description,
        modifier = modifier,
        style = Typography(textAlign = textAlign).description,
        maxLines = maxLines
    )
}

@Preview(showBackground = true)
@Composable
fun SimpleTextPreview() {
    SimpleText(text = stringResource(id = R.string.template))
}

@Composable
fun SimpleText(
    text: String,
    modifier: Modifier = Modifier,
    maxLines: Int = Int.MAX_VALUE,
    textAlign: TextAlign? = null
) {
    BasicText(
        text = text,
        modifier = modifier,
        style = Typography(textAlign = textAlign).simpleText,
        maxLines = maxLines
    )
}