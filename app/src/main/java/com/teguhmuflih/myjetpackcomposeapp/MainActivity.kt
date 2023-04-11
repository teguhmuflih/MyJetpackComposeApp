package com.teguhmuflih.myjetpackcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column() {
                val checkBoxState = remember {
                    mutableStateOf(false)
                }
                CustomCheckBox(title = "Check Box 1", checkBoxState = checkBoxState.value, onCheckedPressed = {checkBoxState.value = it} )
                checkBoxState.value = !checkBoxState.value
            }
        }
    }
}

@Composable
fun CustomCheckBox(title: String,
                   checkBoxState: Boolean,
                   onCheckedPressed: ((Boolean) -> Unit)?
) {
    Row(
        modifier = Modifier.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = checkBoxState,
            onCheckedChange = onCheckedPressed)
        Spacer(modifier = Modifier.padding(4.dp))
        Text(text = title)
    }
}
