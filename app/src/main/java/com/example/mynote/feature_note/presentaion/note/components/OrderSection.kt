package com.example.mynote.feature_note.presentaion.note.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.mynote.R
import com.example.mynote.feature_note.domain.util.NoteOrder
import com.example.mynote.feature_note.domain.util.OrderType

@Composable
fun OrderSection(
    modifier: Modifier = Modifier,
    noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    onOrderChange: (NoteOrder) -> Unit
) {
    val context = LocalContext.current
    Column(modifier = modifier) {
        Row(modifier = Modifier.fillMaxWidth()) {
            DefaultRadioButton(
                text = context.getString(R.string.title_order),
                selected = noteOrder is NoteOrder.Title,
                onSelected = {
                    onOrderChange(NoteOrder.Title(OrderType.Descending))
                }
            )
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(
                text = context.getString(R.string.date_order),
                selected = noteOrder is NoteOrder.Date,
                onSelected = {
                    onOrderChange(NoteOrder.Date(OrderType.Descending))
                }
            )
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(
                text = context.getString(R.string.color_order),
                selected = noteOrder is NoteOrder.Color,
                onSelected = {
                    onOrderChange(NoteOrder.Color(OrderType.Descending))
                }
            )
        }
        Spacer(modifier = Modifier.width(20.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            DefaultRadioButton(
                text = context.getString(R.string.ascending_order),
                selected = noteOrder.orderType is OrderType.Ascending,
                onSelected = {
                    onOrderChange(noteOrder.copy(OrderType.Ascending))
                }
            )
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(
                text = context.getString(R.string.descending_order),
                selected = noteOrder.orderType is OrderType.Descending,
                onSelected = {
                    onOrderChange(noteOrder.copy(OrderType.Descending))
                }
            )
        }
    }
}

@Composable
fun DefaultRadioButton(
    text: String,
    selected: Boolean,
    onSelected: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        RadioButton(
            selected = selected,
            onClick = onSelected,
            colors = RadioButtonDefaults.colors(
                selectedColor = MaterialTheme.colors.primary,
                unselectedColor = MaterialTheme.colors.onBackground
            )
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = text, style = MaterialTheme.typography.body1)
    }
}