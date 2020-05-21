package xyz.ptgms.excusemaker.ui.dashboard

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Switch
import androidx.fragment.app.Fragment
import xyz.ptgms.excusemaker.MainActivity
import xyz.ptgms.excusemaker.R

class DashboardFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)
        val activity = activity as MainActivity?
        val lowercaseState = activity!!.LoadSetting(0)
        val uppercaseState = activity.LoadSetting(1)
        val furryState = activity.LoadSetting(2)
        val mockeryState = activity.LoadSetting(3)
        val lowercase = view.findViewById<Switch>(R.id.switch1)
        val uppercase = view.findViewById<Switch>(R.id.switch2)
        val furry = view.findViewById<Switch>(R.id.switch3)
        val mockery = view.findViewById<Switch>(R.id.switch4)
        val source = view.findViewById<Button>(R.id.sourceButton)
        lowercase.isChecked = lowercaseState
        uppercase.isChecked = uppercaseState
        furry.isChecked = furryState
        mockery.isChecked = mockeryState
        lowercase.setOnCheckedChangeListener { buttonView, isChecked ->
            val activity = getActivity() as MainActivity?
            activity!!.saveSetting(0, isChecked)
            mockery.isChecked = false
            if (uppercase.isChecked && isChecked) {
                uppercase.isChecked = false
                activity.saveSetting(1, false)
            }
            if (mockery.isChecked && isChecked) {
                mockery.isChecked = false
                activity.saveSetting(3, false)
            }
        }
        uppercase.setOnCheckedChangeListener { buttonView, isChecked ->
            val activity = getActivity() as MainActivity?
            activity!!.saveSetting(1, isChecked)
            if (lowercase.isChecked && isChecked) {
                lowercase.isChecked = false
                activity.saveSetting(0, false)
            }
            if (mockery.isChecked && isChecked) {
                mockery.isChecked = false
                activity.saveSetting(3, false)
            }
        }
        furry.setOnCheckedChangeListener { buttonView, isChecked ->
            val activity = getActivity() as MainActivity?
            activity!!.saveSetting(2, isChecked)
        }
        mockery.setOnCheckedChangeListener { buttonView, isChecked ->
            val activity = getActivity() as MainActivity?
            activity!!.saveSetting(3, isChecked)
            if (uppercase.isChecked && isChecked) {
                uppercase.isChecked = false
                activity.saveSetting(0, false)
            }
            if (lowercase.isChecked && isChecked) {
                lowercase.isChecked = false
                activity.saveSetting(1, false)
            }
        }
        source.setOnClickListener {
            val url = "https://github.com/ptgms/ExcuseMaker-Android"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }
        return view
    }
}