package com.example.week05.uicomponents

import android.R.attr.contentDescription
import com.example.week05.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun DollImage(partState: Map<String, Boolean>,modifier: Modifier = Modifier) {
    Box {
        Image(painter = painterResource(id = R.drawable.body), contentDescription = "body")
        if (partState["arms"] == true) {
            Image(
                painter = painterResource(id = R.drawable.arms),
                contentDescription = "arms",
            )
        }
        if (partState["eyebrows"] == true) {
            Image(
                painter = painterResource(id = R.drawable.eyebrows),
                contentDescription = "eyebrows",
            )
        }
        if (partState["glasses"] == true) {
            Image(
                painter = painterResource(id = R.drawable.glasses),
                contentDescription = "glasses",
            )
        }
        if (partState["mouth"] == true) {
            Image(
                painter = painterResource(id = R.drawable.mouth),
                contentDescription = "mouth",
            )
        }
        if (partState["nose"] == true) {
            Image(
                painter = painterResource(id = R.drawable.nose),
                contentDescription = "nose",
            )
        }
        if (partState["ears"] == true) {
            Image(
                painter = painterResource(id = R.drawable.ears),
                contentDescription = "ears",
            )
        }
        if (partState["eyes"] == true) {
            Image(
                painter = painterResource(id = R.drawable.eyes),
                contentDescription = "eyes",
            )
        }
        if (partState["hat"] == true) {
            Image(
                painter = painterResource(id = R.drawable.hat),
                contentDescription = "hat",
            )
        }
        if (partState["mustache"] == true) {
            Image(
                painter = painterResource(id = R.drawable.mustache),
                contentDescription = "mustache",
            )
        }
        if (partState["shoes"] == true) {
            Image(
                painter = painterResource(id = R.drawable.shoes),
                contentDescription = "shoes",
            )
        }
    }
}

@Preview
@Composable
private fun DollImagePreview() {
    DollImage(
        partState = mapOf(
            "arms" to true,
            "eyebrows" to true,
            "glasses" to true,
            "mouth" to true,
            "nose" to true,
            "ears" to true,
            "eyes" to true,
            "hat" to true,
            "mustache" to true,
            "shoes" to true
        )
    )
}