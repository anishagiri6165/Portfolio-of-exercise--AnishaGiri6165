package com.example.happybirthday

import android.graphics.fonts.Font
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.MagnifierStyle
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    // Displays a greeting image with a message "Happy Birthday Sam" and a signature text retrieved from string resources.
                    GreetingImage(
                        message = stringResource(R.string.merry_christmas), // Retrieves the "Happy Birthday Sam" message from string resources.
                        from = stringResource(
                            R.string.subtitle_leeds // Retrieves the signature text from string resources.
                        )
                    )
                }
            }
        }
    }
}



@Composable
        /**
         * A composable function that displays greeting text with a message and a sender's name.
         *
         * @param message The message to be displayed.
         * @param from The sender's name.
         * @param modifier Modifier for styling and positioning the greeting text column.
         */
fun GreetingText(
    message: String, // The message to be displayed.
    from: String, // The sender's name.
    modifier: Modifier = Modifier // Modifier for styling and positioning the greeting text column.
) {
    val materialTextStyle = TextStyle(
        fontFamily = FontFamily.Cursive, // Sets the font family to Cursive, one of the Material Design fonts
        fontWeight = FontWeight.SemiBold, // Sets the font weight to semi-bold
        color = Color.White // Sets the text color to white
    )
    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = modifier // Applies the provided modifier to the Column composable.
    ) {
        Text(
            text = message,
            style = materialTextStyle,
            fontSize = 90.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center // Aligns the message text to the center.
        )
        Text(
            text = from,
            style = materialTextStyle,
            fontSize = 25.sp,
            color = Color.White,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.CenterHorizontally) // Aligns the sender's name text to the center horizontally.
        )
    }
}


@Composable
        /**
         * A composable function that displays a greeting image with a message and a sender's name.
         *
         * @param message The message to be displayed.
         * @param from The sender's name.
         * @param modifier Modifier for styling and positioning the greeting image box.
         */
fun GreetingImage(
    message: String, // The message to be displayed.
    from: String, // The sender's name.
    modifier: Modifier = Modifier // Modifier for styling and positioning the greeting image box.
) {
    val image = painterResource(R.drawable.christmas) // Retrieves the image resource.
    Box(modifier) {
        Image(
            painter = image,
            contentDescription = "Background Image of party", // Description for the image content.
            contentScale = ContentScale.Crop, // Scales the image content to fill the available space while maintaining its aspect ratio.
            alpha = 1F // Sets the transparency level of the image.
        )
        GreetingText(
            message = message,
            from = from,
            modifier = Modifier
                .fillMaxSize() // Fills the maximum available size within the Box.
                .padding(8.dp) // Adds padding around the greeting text.
        )
    }
}



@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    HappyBirthdayTheme {
        // Displays a greeting image with a message "Happy Birthday Sam" and a signature text retrieved from string resources.
        GreetingImage(
            message = stringResource(id = R.string.happy_birthday_sam), // Retrieves the "Happy Birthday Sam" message from string resources.
            from = stringResource(id = R.string.signature_text) // Retrieves the signature text from string resources.
        )

    }
}