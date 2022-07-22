package com.example.recyclerview.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.recyclerview.R
import com.example.recyclerview.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding

    // TODO lade mit Hilfe von activityViewModels() das MainViewModel

    private var vacationId: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO lade die richtige id aus den arguments
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_detail, container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        // TODO finde mit Hilfe der ID die passende Vacation aus den vacations des ViewModels
        //  danach setze die BackgroundResource des Layouts die ImageResource des BackgroundImage
        //  sowie die den text der TextView auf die in der Vacation gespeicherten Werte
        //  (das ganze sollte innerhalb eines Observers geschehen)


        binding.detailShareButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_TEXT, "Ich habe einen tollen Urlaub für gefunden :)")
            intent.type = "text/plain"
            val shareIntent = Intent.createChooser(intent, null)
            startActivity(shareIntent)
        }
    }
}
