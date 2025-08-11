package com.example.quadrants

import android.graphics.drawable.Drawable
import android.graphics.drawable.PaintDrawable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quadrants.ui.theme.QuadrantsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuadrantsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainPage()
                }
            }
        }
    }
}


/**
 * Composable function to display details with a header and summary text.
 *
 * @param modifier Modifier to be applied to the root layout.
 * @param header Header text to be displayed.
 * @param summery Summary text to be displayed.
 */
@Composable
fun QuadraticDetails(modifier: Modifier = Modifier, header: String, summery: String) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Display the header text in bold
        Text(
            text = header,
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold
        )
        // Display the summary text with padding and justified alignment
        Text(
            text = summery,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}


/**
 * Composable function to display an image with a title.
 *
 * @param modifier Modifier to be applied to the root layout.
 * @param title Title text to be displayed below the image.
 * @param imageName Resource ID of the image to be displayed.
 */
@Composable
fun DisplayImage(modifier: Modifier = Modifier, title: String, imageName: Int) {
    // Load the image resource
    val flag = painterResource(id = imageName)

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Display the image
        Box(modifier = modifier, contentAlignment = Alignment.Center) {
            Image(
                painter = flag,
                contentDescription = "belgium flag",
                contentScale = ContentScale.Crop
            )
        }

        // Spacer for vertical spacing
        Spacer(modifier = Modifier.height(8.dp))

        // Display the title text below the image
        Text(
            text = title,
            fontSize = 30.sp,
            modifier = Modifier.padding(horizontal = 18.dp),
            color = Color.Black, // Optional color for the title
            fontWeight = FontWeight.Bold
        )
    }
}


/**
 * Composable function to display the main page layout.
 *
 * @param modifier Modifier to be applied to the root layout.
 */
@Composable
fun MainPage(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.weight(1f)
        ) {
            // First quadrant
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
                    .background(Color(0xFFEADDFF))
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                // Display image and title (commented out QuadraticDetails)
                DisplayImage(
                    modifier = Modifier.fillMaxWidth().size(100.dp),
                    title = "Belgium",
                    imageName = R.drawable.flag_belgium
                )
            }
            // Second quadrant
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
                    .background(Color(0xFFD0BCFF))
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                // Display image and title (commented out QuadraticDetails)
                DisplayImage(
                    modifier = Modifier.fillMaxWidth().size(100.dp),
                    title = "Malaysia",
                    imageName = R.drawable.flag_of_malaysia_svg
                )
            }
        }
        Row(
            modifier = Modifier.weight(1f)
        ) {
            // Third quadrant
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
                    .background(Color(0xFFB69DF8))
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                // Display image and title (commented out QuadraticDetails)
                DisplayImage(
                    modifier = Modifier.fillMaxWidth().size(100.dp),
                    title = "Tanzania",
                    imageName = R.drawable.flag_tanzania
                )
            }
            // Fourth quadrant
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
                    .background(Color(0xFFF6EDFF))
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                // Display image and title (commented out QuadraticDetails)
                DisplayImage(
                    modifier = Modifier.fillMaxWidth().size(100.dp),
                    title = "Peru",
                    imageName = R.drawable.peru_flag
                )
            }
        }
    }
}



// QuadraticDetails(
//    modifier = Modifier.padding(16.dp), "Text composable", "Displays text and follows the recommended Material Design guidelines."
//)


@Preview(showBackground = true)
@Composable
fun QuadrantsPreview() {
    QuadrantsTheme {
        MainPage(modifier = Modifier.fillMaxSize())
//        DisplayImage(modifier = Modifier.fillMaxSize())
    }
}