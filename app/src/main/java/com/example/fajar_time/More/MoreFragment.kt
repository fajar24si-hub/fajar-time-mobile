package com.example.fajar_time.More

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.fajar_time.databinding.FragmentMoreBinding

class MoreFragment : Fragment() {

    private var _binding: FragmentMoreBinding? = null
    private val binding get() = _binding!!

    private val dataList = listOf(
        "Kotlin",
        "Java",
        "Python",
        "C++",
        "JavaScript",
        "Dart",
        "Swift",
        "Go",
        "Ruby",
        "R",
        "PHP",
        "C#",
        "TypeScript",
        "Shell",
        "SQL",
        "Perl",
        "Rust",
        "Scala",
        "Haskell",
        "Lua",
        "Erlang",
        "Prolog",
        "Assembly",
        "Objective-C",
        "VBA"
    )


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMoreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "More"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
