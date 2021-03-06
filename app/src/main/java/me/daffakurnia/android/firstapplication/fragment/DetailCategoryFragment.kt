package me.daffakurnia.android.firstapplication.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import me.daffakurnia.android.firstapplication.R
import me.daffakurnia.android.firstapplication.fragment.FragmentActivity

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DetailCategoryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailCategoryFragment : Fragment() {

    lateinit var textCategoryName: TextView
    lateinit var textCategoryDesc: TextView
    lateinit var btnBackCategory: Button
    lateinit var btnShowDialog: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val textCategoryName: TextView = view.findViewById(R.id.textCategoryName)
        val textCategoryDesc: TextView = view.findViewById(R.id.textCategoryDesc)
        val btnBackCategory: Button = view.findViewById(R.id.btnBackCategory)
        val btnShowDialog: Button = view.findViewById(R.id.btnShowDialog)

        if (arguments != null) {
            val categoryName = arguments?.getString(CATEGORY)
            val categoryDesc = arguments?.getString(DESCRIPTION)
            textCategoryName.text = categoryName
            textCategoryDesc.text = categoryDesc
        }

        btnShowDialog.setOnClickListener {
            val mDialogCategoryFragment = DialogCategoryFragment()
            val mFragmentManager = childFragmentManager
            mDialogCategoryFragment.show(mFragmentManager, DialogCategoryFragment::class.java.simpleName)
        }

        btnBackCategory.setOnClickListener {
            startActivity(Intent(requireActivity(), FragmentActivity::class.java))
        }
    }

    internal var optionDialogListener: DialogCategoryFragment.OnOptionDialogListener = object : DialogCategoryFragment.OnOptionDialogListener {
        override fun onOptionChosen(text: String?) {
            Toast.makeText(requireActivity(), text, Toast.LENGTH_SHORT).show()
        }
    }

    companion object {

        var CATEGORY = "category"
        var DESCRIPTION = "description"

        fun newInstance(param1: String, param2: String) =
            DetailCategoryFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}