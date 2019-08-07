package edu.mnstate.rm8834yy.denioa4recyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private TextView info;
    private TextView infoText;
    private Button backBtn;
    private ImageView puppyImage;

    String[] nameList = {
            "pug",
            "wolf",
            "malamute",
            "Australian shepherd",
            "Water spaniel",
            "Collie",
            "Cocker spaniel",
            "Dachshund",
            "Doberman",
            "German shepherd",
            "Golden retriever",
            "Shih Tzu",
            "Papillon",
            "Corgi",
            "Chihuahua",
            "Pomeranian"

    };

    String[] infoList = {
            "Pugs are a small wrinkly breed with flat faces and stubby little legs. \n"
            + "They originated in China during the Ming dynasty.",
            "The Wolf is the ancestor of modern dogs, not quite \n" +
                    " as cute but majestic when fully grown.",
            "The malamute is a dog that was breed for pulling sleds in cold weather.\n"
            +"They are one of the oldest dog breeds and originated in Alaska.",
            "The Australian shepherd despite its name actually originated in western Europe,\n"
            +"They are closely related to the Border Collie.",
            "The American Water Spaniel has a water resistant coat and makes a good hunting\n"
            +"dog.",
            "The Collie is a very distinctive Breed that was raised for herding livestock\n"
            +"It has become well known as a friendly family dog. They originated in Scotland\n"
            +"and is one of the smartest dog breeds.",
            "Cocker spaniels are very hairy dogs that need to be brushed regularly to prevent\n"
            +"them from shedding all over the house. They make good hunting dogs with an \n"
            +"excellent sense of smell",
            "The Dachshund also known as the 'Wiener-dog' was breed to hunt badgers and other\n"
            +"burrow dwelling animals.",
            "The Doberman is known for its aggressive appearance when its ears and tail are cropped.\n"
            +"Cropping and tail docking has been done to make them more efficient fighting dogs\n"
            +"by removing any potential areas for people or other dogs to grab onto. The practice\n"
            +"has been banned in many places.",
            "The German shepherd is famous for its role in police and search and rescue as well as\n"
            +"military roles. It is also a great service animal for people with disabilities.",
            "The Golden Retriever is a loyal dog that was breed for hunting and is common as a \n"
            +"search and rescue dog. They tend to shed a lot and need frequent grooming.",
            "The Shih Tzu is pretty much just a walking hairball.",
            "Papillon means butterfly in french, this adorable little dog was named for its\n"
            +"large fluffy ears. They are generally very friendly.",
            "Legend has it that the Corgi was a gift from the woodland fairies and the markings \n"
            +"on their backs were left from the little fairy saddles. Any dog with such a cute \n"
            +"origin story definitely deserves a place on this list.",
            "The Chihuahua was made famous by Taco Bell and surprisingly actually comes from Mexico.\n"
            +"They are very tiny dogs with a tendency to have Napoleon complexes.",
            "The Pomeranian is basically a pompom in doggy form, they are normally quite adorable\n"
            +"but are less then friendly most of the time."

    };

    Integer[] imageIDs = {
            R.drawable.pug,
            R.drawable.wolf,
            R.drawable.malamute,
            R.drawable.australian_shepherd,
            R.drawable.water_spaniel,
            R.drawable.collie,
            R.drawable.cocker_spaniel,
            R.drawable.dachshund,
            R.drawable.doberman,
            R.drawable.german_shepherd,
            R.drawable.golden_retriever,
            R.drawable.shihtzu,
            R.drawable.papillon,
            R.drawable.corgi,
            R.drawable.chihuahua,
            R.drawable.pomeranian

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        info = findViewById(R.id.infoLbl);
        infoText = findViewById(R.id.infoText);
        backBtn = findViewById(R.id.backBtn);
        puppyImage = findViewById(R.id.puppyImage);

        Intent puppyIntent = getIntent();
        String msg = puppyIntent.getStringExtra("PuppyIndex");

        int tmpIndex = Integer.valueOf(msg);

        info.setText(nameList[tmpIndex]);
        infoText.setText(infoList[tmpIndex]);
        puppyImage.setImageResource(imageIDs[tmpIndex]);


        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v2) {
                try {
                    Intent back = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(back);

                }
                catch (Exception e) {
                    Toast.makeText(getApplicationContext(),"Back Button Failed",Toast.LENGTH_SHORT);
                }
            }
        });
    }
}
