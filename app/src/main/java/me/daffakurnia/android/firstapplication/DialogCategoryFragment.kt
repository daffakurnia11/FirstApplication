package me.daffakurnia.android.firstapplication

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DialogCategoryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DialogCategoryFragment : DialogFragment() {

    private var optionDialogListener: OnOptionDialogListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dialog_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnCategoryChoose: Button = view.findViewById(R.id.btnCategoryChoose)
        val btnCategoryClose: Button = view.findViewById(R.id.btnCategoryClose)
        val categoryGroup: RadioGroup = view.findViewById(R.id.categoryGroup)
        val categoryOne: RadioButton = view.findViewById(R.id.categoryOne)
        val categoryTwo: RadioButton = view.findViewById(R.id.categoryTwo)
        val categoryThree: RadioButton = view.findViewById(R.id.categoryThree)
        val categoryFour: RadioButton = view.findViewById(R.id.categoryFour)

        btnCategoryChoose.setOnClickListener {
            val checkedRadioButtonId = categoryGroup.checkedRadioButtonId
            if (checkedRadioButtonId != -1) {
                val developer: String? = when (checkedRadioButtonId) {
                    R.id.categoryOne -> categoryOne.text.toString().trim()
                    R.id.categoryTwo -> categoryTwo.text.toString().trim()
                    R.id.categoryThree -> categoryThree.text.toString().trim()
                    R.id.categoryFour -> categoryFour.text.toString().trim()
                    else -> null
                }
                optionDialogListener?.onOptionChosen(developer)
                dialog?.dismiss()
            }
        }

        btnCategoryClose.setOnClickListener {
            dialog?.cancel()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val fragment = parentFragment
        if (fragment is DetailCategoryFragment) {
            this.optionDialogListener = fragment.optionDialogListener
        }
    }

    override fun onDetach() {
        super.onDetach()
        this.optionDialogListener = null
    }

    interface OnOptionDialogListener {
        fun onOptionChosen(text: String?)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DialogCategoryFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DialogCategoryFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}