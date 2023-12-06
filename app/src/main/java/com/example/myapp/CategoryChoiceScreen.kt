package com.example.myapp

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapp.ui.theme.AppTheme

@Composable
fun CategoryChoiceScreen(
    modifier: Modifier = Modifier,
) {
    val volunteerActivitiesCategory = Category.VolunteerActivities
    val handToHandCategory = Category.HandToHand
    val freeStuffCategory = Category.FreeStuffStreet

    val categories = listOf(
        volunteerActivitiesCategory,
        handToHandCategory,
        freeStuffCategory,
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = modifier
                .align(Alignment.Center)
                .width(280.dp),
        ) {
            for (category in categories) {
                CategoryView(
                    category = category,
                    modifier = Modifier.padding(bottom = 32.dp),
                )
            }
        }
    }
}

@Composable
private fun CategoryView(
    category: Category,
    modifier: Modifier = Modifier,
) {
    var isSelected by remember { mutableStateOf(false) }

    val contentAlpha = if (isSelected) 1.0f else 0.7f
    val buttonBackgroundColor = if (isSelected) MaterialTheme.colorScheme.secondary
        else MaterialTheme.colorScheme.background
    val buttonBorderColor = if (isSelected) MaterialTheme.colorScheme.secondary
        else MaterialTheme.colorScheme.primary
    val buttonTextColor = if (isSelected) Color.White
        else MaterialTheme.colorScheme.primary

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
            .alpha(alpha = contentAlpha),
    ) {
        Image(
            painter = painterResource(category.iconId),
            contentDescription = stringResource(category.labelTextId),
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary),
            modifier = Modifier.size(70.dp),
        )

        Divider(
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(vertical = 2.dp),
        )

        Button(
            onClick = {
                isSelected = true
            },
            border = BorderStroke(1.dp, buttonBorderColor),
            shape = CircleShape,
            colors = ButtonDefaults.buttonColors(buttonBackgroundColor),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
        ) {
            Text(
                text = stringResource(category.labelTextId),
                color = buttonTextColor,
                fontSize = 16.sp,
            )
        }

        category.descriptionTextId?.let { categoryDescription ->
            Text(
                text = stringResource(categoryDescription),
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.primary,
            )
        }
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun CategoryChoiceScreenPreview() {
    AppTheme {
        CategoryChoiceScreen()
    }
}
