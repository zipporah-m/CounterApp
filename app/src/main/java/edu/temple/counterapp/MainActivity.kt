package edu.temple.counterapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import edu.temple.counterapp.ui.theme.CounterAppTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    // implementation of the lazy instantiation
    //val counterViewModel by viewModels<CounterViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CounterAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Counter(
                        // counterViewModel = counterViewModel,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Counter(//counterViewModel: CounterViewModel,
            modifier: Modifier = Modifier) {

    val counterViewModel : CounterViewModel = viewModel()
    Column(modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

        var counter by rememberSaveable() { mutableIntStateOf(0) }

        Button({
            counterViewModel.counterValue.intValue++
        }) { Text("Up") }

        Text(
            text = counterViewModel.counterValue.intValue.toString(),
            modifier = modifier,
            fontSize = 48.sp
        )

        Button({
            if (counter > 0)
                counterViewModel.counterValue.intValue--
        }) { Text("Down") }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CounterAppTheme {
        // Counter()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    CounterAppTheme {
        // Counter()
    }
}