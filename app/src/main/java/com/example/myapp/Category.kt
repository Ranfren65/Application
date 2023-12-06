package com.example.myapp

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

enum class Category(
    @StringRes val labelTextId: Int,
    @DrawableRes val iconId: Int,
    @StringRes val descriptionTextId: Int,
) {
    VOLUNTEER(
        R.drawable.volunteer,
        R.string.volunteer_btn_text,
        R.string.volunteer_description
    ),
    HAND(
        R.drawable.handshake,
        R.string.from_hand_to_hand_btn_text,
        R.string.from_hand_to_hand_description
    ),
    STREET(
        R.drawable.street,
        R.string.free_stuff_btn_text,
        R.string.free_stuff_on_the_street_description
    ),

    HandToHand(
        labelTextId = R.string.volunteer_btn_text,
        iconId = R.drawable.volunteer,
        descriptionTextId = R.string.volunteer_description,
    ),
    FreeStuffStreet(
        labelTextId = R.string.from_hand_to_hand_btn_text,
        iconId = R.drawable.handshake,
        descriptionTextId = R.string.from_hand_to_hand_description,
    ),
    VolunteerActivities(
        labelTextId = R.string.free_stuff_btn_text,
        iconId = R.drawable.street,
        descriptionTextId = R.string.free_stuff_on_the_street_description,
    ),
}
