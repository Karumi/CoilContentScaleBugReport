package com.karumi.coilcontentscalebug

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.transform.RoundedCornersTransformation
import com.google.accompanist.coil.CoilImage
import com.google.accompanist.coil.rememberCoilPainter
import com.karumi.coilcontentscalebug.ui.theme.CoilContentScaleBugTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoilContentScaleBugTheme {
                Column {
                    val imageUrl =
                        "https://play-lh.googleusercontent.com/S9lyB4MKAddMAHgSk7Kwjy1FG6yk6x7Nct5jciQxLy6LpRGDijCP7S34Z8W4wsF8RA"
                    Box(
                        Modifier
                            .height(40.dp)
                            .fillMaxWidth()) {
                        CoilImage(
                            modifier = Modifier
                                .background(Color.Green),
                            data = imageUrl,
                            contentDescription = "",
                            requestBuilder = {
                                transformations(
                                    RoundedCornersTransformation(1000f)
                                )
                            },
                            contentScale = ContentScale.Crop
                        )
                    }
                    Box(
                        Modifier
                            .height(40.dp)
                            .fillMaxWidth()) {
                        Image(
                            modifier = Modifier
                                .background(Color.Red),
                            painter = rememberCoilPainter(
                                request = imageUrl,
                                requestBuilder = {
                                    transformations(
                                        RoundedCornersTransformation(1000f)
                                    )
                                },
                            ),
                            contentDescription = "",
                            contentScale = ContentScale.Crop
                        )
                    }

                }
            }
        }
    }
}
