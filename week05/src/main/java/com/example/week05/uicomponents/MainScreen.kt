package com.example.week05.uicomponents

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun MainScreen() {
    val parts = listOf(
        "arms", "ears", "eyebrows", "eyes", "glasses",
        "hat", "mouth", "mustache", "nose", "shoes"
    )

    val partStates = rememberSaveable(
        saver = listSaver(
            save = { list -> list.map { "${it.first}:${it.second}" } },  //example: "arms:true"
            restore = { savedList ->
                savedList.map {
                    val (name, value) = it.split(":")
                    name to value.toBoolean()
                }.toMutableStateList()
            }
        )
    ) {

        mutableStateListOf(*parts.map { it to false }.toTypedArray()) // 초기값 아이템 선택 아무것도 안한걸로 설정
    }

    val orientation = LocalConfiguration.current.orientation
    if (orientation == Configuration.ORIENTATION_PORTRAIT) {

        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                DollImage(partStates.toMap())  // toMap()으로 변환해서 사용
            }

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                items(partStates.size) { index ->
                    val (part, isVisible) = partStates[index]
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(4.dp)
                    ) {
                        Checkbox(
                            checked = isVisible,
                            onCheckedChange = {
                                partStates[index] = part to it
                            }
                        )
                        Text(text = part.replaceFirstChar { it.uppercaseChar() })
                    }
                }
            }
        }
    } else {
        Row(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                contentAlignment = Alignment.Center
            ) {
                DollImage(partStates.toMap())  // toMap()으로 변환해서 사용
            }

            LazyHorizontalGrid(
                rows = GridCells.Fixed(5),
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
            ) {
                items(partStates.size) { index ->
                    val (part, isVisible) = partStates[index]
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(4.dp)
                    ) {
                        Checkbox(
                            checked = isVisible,
                            onCheckedChange = {
                                partStates[index] = part to it
                            }
                        )
                        Text(text = part)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview(modifier: Modifier = Modifier.fillMaxSize()) {
    MainScreen()
}