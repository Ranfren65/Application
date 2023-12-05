package com.example.myapp

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


enum class CategoryEnum(
    @DrawableRes val icon: Int,
    @StringRes val btn_text:Int,
    @StringRes val description:Int) {
    VOLUNTEER(R.drawable.volunteer,R.string.volunteer_btn_text, R.string.volunteer_description ),
    HAND(R.drawable.handshake,R.string.from_hand_to_hand_btn_text,R.string.from_hand_to_hand_description),
    STREET(R.drawable.street,R.string.free_stuff_btn_text,R.string.free_stuff_on_the_street_description),;



    @Composable
     fun CreateCategory(categoryEnum: CategoryEnum){


        Column(
            modifier= Modifier
                .background(Color.Black)
                .padding(15.dp, 15.dp)
                .fillMaxWidth(0.8f)
                .clickable {

                }
                .alpha(alpha = 0.7f),

            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                modifier= Modifier
                    .width(80.dp)
                    .height(80.dp),
                painter= painterResource(icon),
                contentDescription = "Volunteer"
            )
            Row(
                modifier = Modifier
                    .height(1.dp)
                    .background(Color.White)
                    .fillMaxWidth(0.74f),
            ){}



            Button(onClick = {

            },
                modifier= Modifier
                    .fillMaxWidth(0.74f)
                    .padding(vertical = 10.dp),
                border = BorderStroke(1.dp, Color.White),
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White)
            ) {
                Text(
                    text = stringResource(id = btn_text),
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 16.sp,
                )

            }
            Text(modifier = Modifier
                .padding(vertical = 10.dp)
                .padding(bottom = 20.dp),
                text = stringResource(id = description),
                fontFamily = FontFamily.SansSerif,
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                color = Color.White,
                overflow = TextOverflow.Visible,


                style = TextStyle(lineHeight = 23.sp)

            )

        }

    }



}
