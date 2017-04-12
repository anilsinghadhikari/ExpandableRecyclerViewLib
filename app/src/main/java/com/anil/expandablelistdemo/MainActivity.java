package com.anandbose.expandablelistdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.apache.commons.codec.binary.Hex;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;


public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerview;
//    private static final Logger logger = Logger.getLogger(GenerateFingerprint.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button smootScrollBtn = (Button) findViewById(R.id.smootScrollBtn);
        smootScrollBtn .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerview.smoothScrollToPosition(6);
            }
        });

        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        List<ExpandableListAdapter.Item> data = new ArrayList<>();

        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.HEADER, "Fruits"));
        ExpandableListAdapter.Item cars = new ExpandableListAdapter.Item(ExpandableListAdapter.HEADER, "Cars");
        cars.invisibleChildren= new ArrayList<>();

        cars.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Audi"));
        cars.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Aston Martin"));
        cars.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Cadillac"));

        cars.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Cadillac1"));
        cars.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Audi1"));
        cars.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Aston Martin1"));

        cars.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Audi2"));
        cars.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Aston Martin2"));
        cars.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Cadillac2"));

        data.add(cars);


        ExpandableListAdapter.Item places = new ExpandableListAdapter.Item(ExpandableListAdapter.HEADER, "Places");
        places.invisibleChildren = new ArrayList<>();
        places.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Kerala"));
        places.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Tamil Nadu"));
        places.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Karnataka"));
        places.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Maharashtra"));
        places.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Kerala1"));
        places.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Tamil Nadu1"));
        places.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Karnataka1"));
        places.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Maharashtra1"));

        places.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Kerala2"));
        places.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Tamil Nadu2"));
        places.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Karnataka2"));
        places.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Maharashtra2"));
        places.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Kerala2"));
        places.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Tamil Nadu2"));
        places.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Karnataka2"));
        places.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Maharashtra2"));


        places.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Kerala"));
        places.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Tamil Nadu"));
        places.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Karnataka"));
        places.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Maharashtra"));
        places.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Kerala1"));
        places.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Tamil Nadu1"));
        places.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Karnataka1"));
        places.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Maharashtra1"));

        places.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Kerala2"));
        places.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Tamil Nadu2"));
        places.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Karnataka2"));
        places.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Maharashtra2"));
        places.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Kerala2"));
        places.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Tamil Nadu2"));
        places.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Karnataka2"));
        places.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Maharashtra2"));


        places.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Kerala"));
        places.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Tamil Nadu"));
        places.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Karnataka"));
        places.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Maharashtra"));
        places.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Kerala1"));
        places.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Tamil Nadu1"));
        places.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Karnataka1"));
        places.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Maharashtra1"));

        places.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Kerala2"));
        places.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Tamil Nadu2"));
        places.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Karnataka2"));
        places.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Maharashtra2"));
        places.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Kerala2"));
        places.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Tamil Nadu2"));
        places.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Karnataka2"));
        places.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Maharashtra2"));


        data.add(places);

        ExpandableListAdapter.Item sweets = new ExpandableListAdapter.Item(ExpandableListAdapter.HEADER, "Sweet");
        sweets.invisibleChildren = new ArrayList<>();
        sweets.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Laddu"));
        sweets.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Jalebi"));

        data.add(sweets);

        ExpandableListAdapter.Item companies = new ExpandableListAdapter.Item(ExpandableListAdapter.HEADER, "Company");
        companies.invisibleChildren = new ArrayList<>();
        companies.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "QA"));
        companies.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "IBM"));
        companies.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Nucleaous"));
        companies.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "QA"));
        companies.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "IBM"));
        companies.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Nucleaous"));
        companies.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "QA1"));
        companies.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "IBM1"));
        companies.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Nucleaous1"));
        companies.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "QA1"));
        companies.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "IBM1"));
        companies.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Nucleaous1"));
        data.add(companies);

        recyclerview.setAdapter(new ExpandableListAdapter(data));


    }


    public static void generate() {

// provided by authorize.net
        String transactionKey = "9DUV2jR5Ux43ap3u";
// provided by authorize.net
        String apiLoginId = "23E7uTk5";
        String amount = "20";
// currency Code
        String currencyCode = "USD";

        try {

// generate timestamp in sequence number
            long timeStamp = System.currentTimeMillis() / 1000;

// generate random sequence number
            Random random = new Random();
            long loginSequence = random.nextInt(100000000);

// section use java Cryptography functions to generate a fingerprint

// convert transaction key to Secret key object
            SecretKey key = new SecretKeySpec(transactionKey.getBytes(), "HmacMD5");

// create a MAC object to generate the fingerprint using the HmacMD5 algorithm
            Mac mac = null;
            try {
                mac = Mac.getInstance("HmacMD5");
                mac.init(key);
            } catch (Exception e) {
                e.printStackTrace();
            }

// add caret(^) between input values as per documented by authorizenet
            String inputString = apiLoginId + "^" + loginSequence + "^" + timeStamp + "^" + amount + "^" + currencyCode;

// get String as bytes
            byte[] inputBytes= inputString.getBytes();

// create digest from byte array
            byte[] result = mac.doFinal(inputBytes);

// convert HMAC byte array to char array.
            char[] resultCharArray = Hex.encodeHex(result);

// convert char array to string
            String fingerprint = new String(resultCharArray);


            Log.d("LOG", "Login Sequence ::"+ loginSequence);
            Log.d("LOG", ""+ timeStamp);
//            Log.d("-----------------------------------------------");
            Log.d("LOG", ""+ fingerprint);


        } catch (Exception e) {

        }

    }


}
