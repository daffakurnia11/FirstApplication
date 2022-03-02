package me.daffakurnia.android.firstapplication.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import me.daffakurnia.android.firstapplication.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

    /*
        Layout interface is defined and transformed from a layout in the xml file into
        a view object using the inflate() method
    */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /*
            Inflater.inflate() is an object of LayoutInflater that serves to convert the
            xml layout into a viewgroup object or widget by calling the inflate() method.
            The inflate() method itself is used to display the layout of the Fragment,
            where the layout shown here is fragment_home

            The following parameters in inflate() method :
            1. resource : Int -> Layout that want to change
            2. root : ViewGroup? -> Root from Layout Activity
            3. attachToRoot : Boolean -> Paste the layout into the root of parent layout.
         */
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnFragmentCategory: Button = view.findViewById(R.id.btnFragmentCategory)
        btnFragmentCategory.setOnClickListener {
            val mCategoryFragment = CategoryFragment()
            val mFragmentManager = parentFragmentManager
            mFragmentManager
                .beginTransaction()
                .apply {
                    // Replacing the existing fragment on layout container
                    replace(R.id.frameContainer, mCategoryFragment, CategoryFragment::class.java.simpleName)

                    // For returning back into previous fragment
                    addToBackStack(null)
                    commit()
                }
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}