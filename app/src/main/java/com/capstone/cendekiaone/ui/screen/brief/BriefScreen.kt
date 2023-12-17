package com.capstone.cendekiaone.ui.screen.brief

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.capstone.cendekiaone.R

@Composable
fun BriefScreen(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text(stringResource(R.string.menu_brief))
    }
}

@Preview(showBackground = true, device = "id:pixel_4")
@Composable
fun BriefScreenPreview() {
    BriefScreen()
}