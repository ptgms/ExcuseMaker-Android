package xyz.ptgms.excusemaker.ui.home

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import xyz.ptgms.excusemaker.MainActivity
import xyz.ptgms.excusemaker.R
import java.util.*

class HomeFragment : Fragment() {
    private val homeViewModel: HomeViewModel? = null
    @SuppressLint("SetTextI18n")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val excusesOne = arrayOf("Sorry, I can't come today, since", "Sorry, I can't be there, because", "I think I'm in trouble here, since", "Ah damn, I can't do that because", "I can't come,", "I know I'm kinda late with this, I can't come since", "Ahh crap, I can't come,", "Idk if I can come since", "Fucking hell,")
        val excusesTwo = arrayOf("I forgot I have to turn in a paper today", "I gotta bring the dog to the vet", "I have to watch a movie today", "someone from the family needs urgent help right now", "I got an suprise visit here", "I have an project whose deadline is today", "I got an call from my boss", "I have to help at home", "I'm busy working on my project", "someone invited me to the cinema right now")
        val excusesOneDE = arrayOf("Sorry, ich kann nicht kommen, denn", "Sorry, ich kann nicht erscheinen, denn", "Ich glaube ich hab hier ein Problem, denn", "Ah verdammt, ich kann das nicht machen, denn", "Ich kann nicht kommen,", "Ich weiß ich bin spät damit, aber ich kann nicht kommen, denn", "Ahh verdammt, ich kann nicht kommen,", "Weiß nich ob ich kommen kann,", "Verdammt nochmal,")
        val excusesTwoDE = arrayOf("ich hab vergessen ich muss eine Arbeit heute abgeben", "ich muss meinen Hund zum Tierarzt bringen", "ich muss heute einen Film angucken", "jemand von meiner Familie braucht drigends Hilfe", "ich hab einen Überraschungsbesuch hier", "ich hab ein Projekt was ich heute einreichen muss", "ich werde von meinem Chef angerufen", "ich muss zuhause helfen", "ich arbeite an meinem Projekt", "jemand hat mich gerade zum Kino eingeladen")
        val furryEmotes = arrayOf(";_;", "._.", "*.*", "owo", "uwu", "YwY")
        val button = view.findViewById<Button>(R.id.button)
        val button2 = view.findViewById<Button>(R.id.button2)
        val text1 = view.findViewById<TextView>(R.id.text_home)
        val text2 = view.findViewById<TextView>(R.id.text_home2)
        button.setOnClickListener {
            println("Yo")
            val clipboard = activity!!.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("Excuse", text1.text.toString() + " " + text2.text.toString())
            clipboard.setPrimaryClip(clip)
        }
        button2.setOnClickListener {
            button.isEnabled = true
            button.setTextColor(resources.getColor(R.color.buttonPrimary))
            val activity = activity as MainActivity?
            val lowercase = activity!!.LoadSetting(0)
            val uppercase = activity.LoadSetting(1)
            val furry = activity.LoadSetting(2)
            val mockery = activity.LoadSetting(3)
            if (Locale.getDefault().language == "de") {
                val r = Random()
                val r2 = Random()
                val random1 = r.nextInt(excusesOneDE.size)
                val random2 = r2.nextInt(excusesTwoDE.size)
                when {
                    lowercase -> {
                        text1.text = excusesOneDE[random1].toLowerCase(Locale.ROOT)
                        text2.text = excusesTwoDE[random2].toLowerCase(Locale.ROOT)
                    }
                    uppercase -> {
                        text1.text = excusesOneDE[random1].toUpperCase(Locale.ROOT)
                        text2.text = excusesTwoDE[random2].toUpperCase(Locale.ROOT)
                    }
                    else -> {
                        text1.text = excusesOneDE[random1]
                        text2.text = excusesTwoDE[random2]
                    }
                }
            } else {
                val r = Random()
                val r2 = Random()
                val random1 = r.nextInt(excusesOne.size)
                val random2 = r2.nextInt(excusesTwo.size)
                when {
                    lowercase -> {
                        text1.text = excusesOne[random1].toLowerCase(Locale.ROOT)
                        text2.text = excusesTwo[random2].toLowerCase(Locale.ROOT)
                    }
                    uppercase -> {
                        text1.text = excusesOne[random1].toUpperCase(Locale.ROOT)
                        text2.text = excusesTwo[random2].toUpperCase(Locale.ROOT)
                    }
                    else -> {
                        text1.text = excusesOne[random1]
                        text2.text = excusesTwo[random2]
                    }
                }
            }
            if (furry) {
                val r = Random()
                val randomdec = r.nextInt(2)
                if (randomdec == 0) {
                    text1.text = text1.text.toString()[0].toString() + "-" + text1.text.toString()
                }
                val randomdec2 = r.nextInt(2)
                if (randomdec2 == 0) {
                    val rand = Random()
                    val randomEmote = rand.nextInt(furryEmotes.size)
                    text2.text = text2.text.toString() + " " + furryEmotes[randomEmote]
                }
                text1.text = text1.text.toString().replace("l", "w")
                text1.text = text1.text.toString().replace("L", "W")
                text1.text = text1.text.toString().replace("r", "w")
                text1.text = text1.text.toString().replace("R", "W")
                text2.text = text2.text.toString().replace("l", "w")
                text2.text = text2.text.toString().replace("L", "W")
                text2.text = text2.text.toString().replace("r", "w")
                text2.text = text2.text.toString().replace("R", "W")
            }
            if (mockery) {
                var final1 = ""
                var final2 = ""
                var state = true
                for (i in text1.text.toString().indices) {
                    if (state) {
                        final1 += text1.text.toString().toUpperCase(Locale.ROOT)[i]
                    } else {
                        final1 += text1.text.toString().toLowerCase(Locale.ROOT)[i]
                    }
                    state = !state
                }
                for (i in text2.text.toString().indices) {
                    if (state) {
                        final2 += text2.text.toString().toUpperCase(Locale.ROOT)[i]
                    } else {
                        final2 += text2.text.toString().toLowerCase(Locale.ROOT)[i]
                    }
                    state = !state
                }
                text1.text = final1
                text2.text = final2
            }
        }
        return view
    }
}