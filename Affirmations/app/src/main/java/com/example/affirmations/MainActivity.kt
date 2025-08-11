package com.example.affirmations

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.affirmations.Data.Datasource
import com.example.affirmations.model.Affirmation
import com.example.affirmations.ui.theme.AffirmationsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AffirmationsTheme {
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
 * A composable function representing the main screen of the app.
 * @param modifier Optional modifier to be applied to the main screen.
 */
@Composable
fun MainPage(modifier: Modifier = Modifier) {
    // Display a preview of the affirmation cards
    AffirmationCardPreview()
}

/**
 * A composable function representing a single affirmation card.
 * @param affirmation The affirmation to display.
 * @param modifier Optional modifier to be applied to the card.
 */
@Composable
fun AffirmationCard(affirmation: Affirmation, modifier: Modifier = Modifier) {
    // State to manage the visibility of the dialog
    var showDialog by remember { mutableStateOf(false) }
    // Get the context
    val context = LocalContext.current

    // Dialog composable to show affirmation details when showDialog is true
    if (showDialog) {
        Dialog(onDismissRequest = { showDialog = false }) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp)
                    .clip(RoundedCornerShape(23.dp)),
                color = Color.LightGray,
                shadowElevation = 8.dp
            ) {
                Column {
                    // Display the image associated with the affirmation
                    Image(
                        painter = painterResource(id = affirmation.imageResourceId),
                        contentDescription = stringResource(id = affirmation.stringResourceId),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(194.dp),
                        contentScale = ContentScale.Crop
                    )
                    // Display the text associated with the affirmation in the center
                    Text(
                        text = context.getString(affirmation.stringResourceId),
                        modifier = Modifier.padding(16.dp).fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
    }

    // Card composable to trigger the dialog when clicked
    Card(
        modifier = modifier.clickable {
            showDialog = true
            // Show a toast message with the affirmation text when clicked
            Toast.makeText(context, context.getString(affirmation.stringResourceId), Toast.LENGTH_SHORT).show()
        }
    ) {
        Column {
            // Display the image associated with the affirmation
            Image(
                painter = painterResource(id = affirmation.imageResourceId),
                contentDescription = stringResource(id = affirmation.stringResourceId),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )
            // Display the text associated with the affirmation
            Text(
                text = context.getString(affirmation.stringResourceId),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}

/**
 * A composable function representing a list of affirmations.
 * @param affirmationList The list of affirmations to display.
 * @param modifier Optional modifier to be applied to the list.
 */
@Composable
fun AffirmationList(affirmationList: List<Affirmation>, modifier: Modifier = Modifier) {
    // LazyColumn to display a list of affirmation cards
    LazyColumn(modifier = modifier) {
        items(affirmationList) { affirmationList ->
            // Display each affirmation as a card with padding
            AffirmationCard(affirmation = affirmationList, modifier = Modifier.padding(8.dp))
        }
    }
}

/**
 * A preview function to display the main screen of the app with system UI.
 */
@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "My Preview"
)
@Composable
fun AffirmationsPreview() {
    // Display the main screen of the app with system UI
    AffirmationsTheme {
        MainPage()
    }
}

/**
 * A preview function to display a single affirmation card.
 */
@Preview(showBackground = true)
@Composable
private fun AffirmationCardPreview() {
    // Display a preview of a list of affirmations
    AffirmationList(affirmationList = Datasource().loadAffirmations())
}

