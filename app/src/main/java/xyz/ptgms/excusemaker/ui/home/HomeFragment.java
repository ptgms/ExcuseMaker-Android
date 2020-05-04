package xyz.ptgms.excusemaker.ui.home;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import java.util.Locale;
import java.util.Objects;
import java.util.Random;

import xyz.ptgms.excusemaker.MainActivity;
import xyz.ptgms.excusemaker.R;


public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        final String[] excusesOne = { "Sorry, I can't come today, since", "Sorry, I can't be there, because", "I think I'm in trouble here, since", "Ah damn, I can't do that because", "I can't come,", "I know I'm kinda late with this, I can't come since", "Ahh crap, I can't come,", "Idk if I can come since", "Fucking hell," };
        final String[] excusesTwo = { "I forgot I have to turn in a paper today", "I gotta bring the dog to the vet", "I have to watch a movie today", "someone from the family needs urgent help right now", "I got an suprise visit here", "I have an project whose deadline is today", "I got an call from my boss", "I have to help at home", "I'm busy working on my project", "someone invited me to the cinema right now" };

        final String[] excusesOneDE = { "Sorry, ich kann nicht kommen, denn", "Sorry, ich kann nicht erscheinen, denn", "Ich glaube ich hab hier ein Problem, denn", "Ah verdammt, ich kann das nicht machen, denn", "Ich kann nicht kommen,", "Ich weiß ich bin spät damit, aber ich kann nicht kommen, denn", "Ahh verdammt, ich kann nicht kommen,", "Weiß nich ob ich kommen kann,", "Verdammt nochmal," };
        final String[] excusesTwoDE = { "ich hab vergessen ich muss eine Arbeit heute abgeben", "ich muss meinen Hund zum Tierarzt bringen", "ich muss heute einen Film angucken", "jemand von meiner Familie braucht drigends Hilfe", "ich hab einen Überraschungsbesuch hier", "ich hab ein Projekt was ich heute einreichen muss", "ich werde von meinem Chef angerufen", "ich muss zuhause helfen", "ich arbeite an meinem Projekt", "jemand hat mich gerade zum Kino eingeladen" };

        final String[] furryEmotes = { ";_;", "._.", "*.*", "owo", "uwu", "YwY" };

        final Button button = view.findViewById(R.id.button);
        Button button2 = view.findViewById(R.id.button2);
        final TextView text1 = view.findViewById(R.id.text_home);
        final TextView text2 = view.findViewById(R.id.text_home2);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                System.out.println("Yo");
                ClipboardManager clipboard = (ClipboardManager) getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("Excuse", text1.getText().toString() + " " + text2.getText().toString());
                clipboard.setPrimaryClip(clip);
            }
        });


        button2.setOnClickListener(new View.OnClickListener()
        {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v)
            {
                button.setEnabled(true);
                button.setTextColor(getResources().getColor(R.color.buttonPrimary));
                MainActivity activity = (MainActivity) getActivity();
                boolean lowercase = activity.LoadSetting(0);
                boolean uppercase = activity.LoadSetting(1);
                boolean furry = activity.LoadSetting(2);
                boolean mockery = activity.LoadSetting(3);

                if (Locale.getDefault().getLanguage().equals("de")) {
                    Random r=new Random();
                    Random r2=new Random();
                    int random1=r.nextInt(excusesOneDE.length);
                    int random2=r2.nextInt(excusesTwoDE.length);

                    if (lowercase) {
                        text1.setText(excusesOneDE[random1].toLowerCase());
                        text2.setText(excusesTwoDE[random2].toLowerCase());
                    } else if (uppercase) {
                        text1.setText(excusesOneDE[random1].toUpperCase());
                        text2.setText(excusesTwoDE[random2].toUpperCase());
                    } else {
                        text1.setText(excusesOneDE[random1]);
                        text2.setText(excusesTwoDE[random2]);
                    }
                } else {
                    Random r=new Random();
                    Random r2=new Random();
                    int random1=r.nextInt(excusesOne.length);
                    int random2=r2.nextInt(excusesTwo.length);

                    if (lowercase) {
                        text1.setText(excusesOne[random1].toLowerCase());
                        text2.setText(excusesTwo[random2].toLowerCase());
                    } else if (uppercase) {
                        text1.setText(excusesOne[random1].toUpperCase());
                        text2.setText(excusesTwo[random2].toUpperCase());
                    } else {
                        text1.setText(excusesOne[random1]);
                        text2.setText(excusesTwo[random2]);
                    }
                }
                if (furry) {
                    Random r=new Random();
                    int randomdec = r.nextInt(2);
                    if (randomdec==0) {
                        text1.setText(text1.getText().toString().charAt(0) + "-" + text1.getText().toString());
                    }
                    int randomdec2 = r.nextInt(2);
                    if (randomdec2==0) {
                        Random rand = new Random();
                        int randomEmote = rand.nextInt(furryEmotes.length);
                        text2.setText(text2.getText().toString() + " " + furryEmotes[randomEmote]);
                    }

                    text1.setText(text1.getText().toString().replace("l", "w"));
                    text1.setText(text1.getText().toString().replace("L", "W"));
                    text1.setText(text1.getText().toString().replace("r", "w"));
                    text1.setText(text1.getText().toString().replace("R", "W"));

                    text2.setText(text2.getText().toString().replace("l", "w"));
                    text2.setText(text2.getText().toString().replace("L", "W"));
                    text2.setText(text2.getText().toString().replace("r", "w"));
                    text2.setText(text2.getText().toString().replace("R", "W"));

                }
                if (mockery) {
                    String final1 = "";
                    String final2 = "";
                    boolean state = true;

                    for(int i=0; i<=text1.getText().toString().length()-1; i++) {
                        if (state) {
                            final1 += text1.getText().toString().toUpperCase().charAt(i);
                        } else {
                            final1 += text1.getText().toString().toLowerCase().charAt(i);
                        }
                        state = !state;
                    }
                    for(int i=0; i<=text2.getText().toString().length()-1; i++) {
                        if (state) {
                            final2 += text2.getText().toString().toUpperCase().charAt(i);
                        } else {
                            final2 += text2.getText().toString().toLowerCase().charAt(i);
                        }
                        state = !state;
                    }
                    text1.setText(final1);
                    text2.setText(final2);
                }
            }
        });

        return view;
    }
}
