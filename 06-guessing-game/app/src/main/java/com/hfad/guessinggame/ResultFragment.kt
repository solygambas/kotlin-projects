package com.hfad.guessinggame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
//import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.findNavController
//import com.hfad.guessinggame.databinding.FragmentResultBinding

/**
 * A simple [Fragment] subclass.
 * Use the [ResultFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ResultFragment : Fragment() {
/*    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!*/
    //lateinit var viewModel: ResultViewModel
    //lateinit var viewModelFactory: ResultViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        /*_binding = FragmentResultBinding.inflate(inflater, container, false).apply {
            composeView.setContent {
//                Text("This a composable")
                MaterialTheme {
                    Surface {
                        view?.let { ResultFragmentContent(it, viewModel) }
                    }
                }
            }
        }
        val view = binding.root*/

        val result = ResultFragmentArgs.fromBundle(requireArguments()).result
        /*viewModelFactory = ResultViewModelFactory(result)
        viewModel = ViewModelProvider(this, viewModelFactory).get(ResultViewModel::class.java)*/
        //binding.wonLost.text = viewModel.result
        /*binding.resultViewModel = viewModel // set the layout's data binding variable

        binding.newGameButton.setOnClickListener {
            view.findNavController().navigate(R.id.action_resultFragment_to_gameFragment)
        }*/

        return ComposeView(requireContext()).apply {
            setContent {
                MaterialTheme {
                    Surface {
                        view?.let { ResultFragmentContent(it, result) }
                    }
                }
            }
        }
    }

    @Composable
    fun ResultText(result: String) {
        Text(text = result,
            fontSize = 28.sp,
            textAlign = TextAlign.Center)
    }

    @Composable
    fun NewGameButton(clicked: () -> Unit) {
        Button(onClick = clicked) {
            Text("Start New Game")
        }
    }

    @Composable
    fun ShareButton(clicked: () -> Unit) {
        Button(onClick = clicked) {
            Text("Share Your Result")
        }
    }

    @Composable
    fun ResultFragmentContent(view: View, result: String) {
        val viewModel: ResultViewModel = viewModel(
            factory = ResultViewModelFactory(result)
        )

        Column(modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally) {
            ResultText(viewModel.result)
            NewGameButton {
                view.findNavController().navigate(R.id.action_resultFragment_to_gameFragment)
            }
            ShareButton {
                val shareIntent = viewModel.shareResult()
                startActivity(shareIntent)
            }
        }
    }

    /*override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }*/
}