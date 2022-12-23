// Code for developing Color Transition animation in android jetpack compose

// Please replace the name of package with your project name
package com.example.colortransition

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

class Animation2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // This sets the @Composable function as the root view of the activity.
        // This is meant to replace the .xml file that we would typically
        // set using the setContent(R.id.xml_file) method.
        setContent {
            AnimateColorComponent()
        }
    }
}

@Composable
fun AnimateColorComponent() {
    // Animatable is a value holder that can animate the value
    // as it is changed via animateTo
    val color = remember { Animatable(Color.Red) }
    // using the LaunchedEffect composable to create a scope
    // just for the duration of the specified key value.
    LaunchedEffect(Unit) {
        color.animateTo(Color.Red, animationSpec = tween(1500))
        color.animateTo(Color.Gray, animationSpec = tween(1500))
        color.animateTo(Color.Blue, animationSpec = tween(1500))
        color.animateTo(Color.Black, animationSpec = tween(1500))
        color.animateTo(Color.Yellow, animationSpec = tween(1500))
        color.animateTo(Color.Cyan, animationSpec = tween(1500))
    }

    // Below, we use color to get get the latest value of color
    // and use it to paint the screen by setting
    // it as the backgroundColor of the screen.
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color.value)) { }
}

/**
 * Significance of @Preview & @Composable annotations.
 */
@Preview
@Composable
fun AnimateColorComponentPreview() {
    AnimateColorComponent()
}