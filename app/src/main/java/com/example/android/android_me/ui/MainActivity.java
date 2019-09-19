/*
* Copyright (C) 2017 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*  	http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.example.android.android_me.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.android_me.R;

// This activity is responsible for displaying the master list of all images
// Implement the MasterListFragment callback, OnImageClickListener
public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener{

    private int headIndex;
    private int bodyIndex;
    private int legIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    // Define the behavior for onImageSelected
    public void onImageSelected(int position) {
        // Create a Toast that displays the position that was clicked
        Toast.makeText(this, "Position clicked = " + position, Toast.LENGTH_SHORT).show();

        // done (2) Based on where a user has clicked, store the selected list index for the head, body, and leg BodyPartFragments
        // body parts based on 0 = head, 1 = body, 2 = leg
        int bodyParts = position/12;

        //ensure that the list is always between 0-11
        int indexList = position - (12*bodyParts);

        // done (3) Put this information in a Bundle and attach it to an Intent that will launch an AndroidMeActivity

        switch(bodyParts){
            case 0: headIndex = indexList;
                break;
            case 1: bodyIndex = indexList;
                break;
            case 2: legIndex = indexList;
                break;
        }

        Bundle bundle = new Bundle();

        bundle.putInt("head", headIndex);
        bundle.putInt("body", bodyIndex);
        bundle.putInt("leg", legIndex);

        final Intent intent = new Intent(getApplicationContext(), AndroidMeActivity.class);
        intent.putExtra("bodyPartsBundle", bundle);

        // done (4) Get a reference to the "Next" button and launch the intent when this button is clicked

        Button nextButton = (Button) findViewById(R.id.tv_next_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });

    }

}
