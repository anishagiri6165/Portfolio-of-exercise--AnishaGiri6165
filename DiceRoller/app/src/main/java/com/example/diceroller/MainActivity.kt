package com.example.diceroller

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.diceroller.ui.theme.DiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    DiceWithButtonAndImage(
                        modifier = Modifier
                            .fillMaxSize()
                            .wrapContentSize(Alignment.Center)
                    )
                }
            }
        }
    }
}

@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    var diceNumber by remember {
        mutableStateOf<DiceNumber?>(null)
    }
    var secondDiceNumber by remember {
        mutableStateOf<DiceNumber?>(null)
    }
    var displayText by remember {
        mutableStateOf<String?>("")
    }
    val onDiceRollClick: () -> Unit = {
        diceNumber = DiceNumber.entries.random()
        secondDiceNumber = DiceNumber.entries.random()
        displayText = when {
            diceNumber == DiceNumber.One && secondDiceNumber == DiceNumber.One -> "You rolled a double 1"
            diceNumber == DiceNumber.Two && secondDiceNumber == DiceNumber.Two -> "You rolled a double 2"
            diceNumber == DiceNumber.Three && secondDiceNumber == DiceNumber.Three -> "You rolled a double 3"
            diceNumber == DiceNumber.Four && secondDiceNumber == DiceNumber.Four -> "You rolled a double 4"
            diceNumber == DiceNumber.Five && secondDiceNumber == DiceNumber.Five -> "You rolled a double 5"
            diceNumber == DiceNumber.Six && secondDiceNumber == DiceNumber.Six -> "You rolled a double 6"
            else -> "" // If the combination of selected fruit and color does not match any case
        }
    }

    Column(
        modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Box(
                modifier = Modifier.size(200.dp)
            ) {
                diceNumber?.let { dice ->
                    Image(
                        modifier = Modifier.fillMaxSize(),
                        painter = painterResource(id = dice.imageResource),
                        contentDescription = null
                    )
                }

            }
            Box(
                modifier = Modifier.size(200.dp)
            ) {
                secondDiceNumber?.let { dice ->
                    Image(
                        modifier = Modifier.fillMaxSize(),
                        painter = painterResource(id = dice.imageResource),
                        contentDescription = null
                    )
                }

            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onDiceRollClick) {
            Text(stringResource(R.string.roll))
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = displayText.toString(), style = TextStyle(
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                textDecoration = TextDecoration.Underline
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DiceRollerApp() {
    DiceRollerTheme {
        DiceWithButtonAndImage(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
        )
    }
}