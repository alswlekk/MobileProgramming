package com.example.week05.uicomponents

import android.R.attr.checked
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FeatureCheckBox(item : String,checked : Boolean? = null,modifier: Modifier = Modifier, onCheckedChange : (Boolean) -> Unit) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(
            checked = checked?: false,
            onCheckedChange = { checked -> onCheckedChange(checked) },
        )
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            text = item,
            modifier = modifier,
        )
    }
}

@Preview
@Composable
private fun FeatureCheckBoxPreview() {
    FeatureCheckBox(
        item = "arms"
    ) {}
}