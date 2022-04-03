package com.hfad.guessinggame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.findNavController
//import com.hfad.guessinggame.databinding.FragmentGameBinding

/**
 * A simple [Fragment] subclass.
 * Use the [GameFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GameFragment : Fragment() {
    /*private var _binding: FragmentGameBinding? = null
    private val binding get() = _binding!!*/
    lateinit var viewModel: GameViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        /*_binding = FragmentGameBinding.inflate(inflater, container, false).apply {
            composeView.setContent {
                MaterialTheme {
                    Surface {
                        GameFragmentContent(viewModel)
                    }
                }
            }
        }
        val view = binding.root*/
        viewModel = ViewModelProvider(this).get(GameViewModel::class.java)

        // viewModel.incorrectGuesses.observe(viewLifecycleOwner, Observer { newValue ->
        //    binding.incorrectGuesses.text = "Incorrect guesses: $newValue"
        //})
        //viewModel.livesLeft.observe(viewLifecycleOwner, Observer { newValue ->
        //    binding.lives.text = "You have $newValue lives left"
        //})
        //viewModel.secretWordDisplay.observe(viewLifecycleOwner, Observer { newValue ->
        //    binding.word.text = newValue
        //})

        viewModel.gameOver.observe(viewLifecycleOwner, Observer { newValue ->
            if (newValue) {
                val action = GameFragmentDirections.actionGameFragmentToResultFragment(viewModel.wonLostMessage())
                view?.findNavController()?.navigate(action)
            }
        })

        // set the data binding variable
        //binding.gameViewModel = viewModel
        // respond to live data updates
        //binding.lifecycleOwner = viewLifecycleOwner

        /*binding.guessButton.setOnClickListener {
            viewModel.makeGuess(binding.guess.text.toString().uppercase())
            binding.guess.text = null
        }*/

        return ComposeView(requireContext()).apply {
            setContent {
                MaterialTheme {
                    Surface {
                        GameFragmentContent()
                    }
                }
            }
        }
    }

    @Composable
    fun SecretWordDisplay(viewModel: GameViewModel) {
        val display = viewModel.secretWordDisplay.observeAsState()
        display.value?.let {
            Text(text = it,
                letterSpacing = 0.1.em,
                fontSize = 36.sp)
        }
    }

    @Composable
    fun LivesLeftText(viewModel: GameViewModel) {
        val livesLeft = viewModel.livesLeft.observeAsState()
        livesLeft.value?.let {
            Text(stringResource(R.string.lives_left, it))
        }
    }

    @Composable
    fun IncorrectGuessesText(viewModel: GameViewModel) {
        val incorrectGuesses = viewModel.incorrectGuesses.observeAsState()
        incorrectGuesses.value?.let {
            Text(stringResource(R.string.incorrect_guesses, it))
        }
    }

    @Composable
    fun EnterGuess(guess: String, changed: (String) -> Unit) {
        TextField(value = guess,
            onValueChange = changed,
            label = { Text("Guess a letter") })
    }

    @Composable
    fun GuessButton(clicked: () -> Unit) {
        Button(onClick = clicked) {
            Text("Guess!")
        }
    }

    @Composable
    fun FinishGameButton(clicked: () -> Unit) {
        Button(onClick = clicked) {
            Text("Finish Game")
        }
    }

    @Composable
    fun GameFragmentContent() {
        val guess = remember { mutableStateOf("") }
        val viewModel: GameViewModel = viewModel()

        Column(modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally) {
            SecretWordDisplay(viewModel)
            LivesLeftText(viewModel)
            IncorrectGuessesText(viewModel)
            EnterGuess(guess.value) { guess.value = it }
            GuessButton {
                viewModel.makeGuess(guess.value.uppercase())
                guess.value = ""
            }
            FinishGameButton {
                viewModel.finishGame()
            }
        }
    }

    /*override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }*/

}