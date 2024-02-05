package br.com.weather.brazil.view.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import br.com.weather.brazil.R
import br.com.weather.brazil.databinding.BottomSheetLanguageBinding

class BottomSheetLanguage : Fragment(R.layout.bottom_sheet_language) {

    private lateinit var binding: BottomSheetLanguageBinding
    private var selectLanguage: String = ""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = BottomSheetLanguageBinding.bind(view)
        onCheckboxClicked()
    }

    private fun onCheckboxClicked() {
        binding.groupLanguage.setOnCheckedChangeListener { group, checkedId ->
            when (group) {
                binding.checkPt -> selectLanguage = "PT"
                binding.checkEn -> selectLanguage = "US"
            }
        }
    }
}
