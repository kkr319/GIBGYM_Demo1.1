package com.example.gibgym_demo11;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.SeekBar;


import com.amplifyframework.AmplifyException;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.core.model.query.Where;
import com.amplifyframework.datastore.AWSDataStorePlugin;
import com.amplifyframework.datastore.generated.model.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;


import com.amazonaws.mobileconnectors.dynamodbv2.document.datatype.Document;
import com.amazonaws.mobileconnectors.dynamodbv2.document.datatype.Primitive;
import static com.amplifyframework.datastore.generated.model.Task.USERNAME;


public class UInfoFragment extends Fragment {
    /*
    ArrayList<String> weekdaysAL = new ArrayList<String>();
    ArrayList<String> durationAl = new ArrayList<String>();
    ArrayList<String> objectiveAL = new ArrayList<String>();
    ArrayList<String> BodyPartsAL = new ArrayList<String>();
    ArrayList<String> everything = new ArrayList<String>();
     */
    String monday;String tuesday;String wednesday;String thursday;String friday;String saturday;String sunday;String fifteen;
    String twentifive;String thirtifive;String fortifive;String muscle;String slim;String fit;String restoration;String intensity;String waist;
    String arm;String leg;String hip;String shoulder;String chest;String back;String neck;String whole;String abdomen;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_u_info, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        try {
            Amplify.addPlugin(new AWSDataStorePlugin());
            Amplify.configure(requireActivity().getApplicationContext());

            Log.i("MyAmplifyApp", "Initialized Amplify");
        } catch (AmplifyException error) {
            Log.e("MyAmplifyApp", "Could not initialize Amplify", error);
        }

        SharedPreferences prefs = getActivity().getApplicationContext().getSharedPreferences("myAppPackage", 0);
        String username = prefs.getString("Susername", "");

        Button submit = requireView().findViewById(R.id.button_uifFrag_submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onWeekdayCheckboxClicked();
                onDurationCheckboxClicked();
                onObjevtiveCheckboxClicked();
                getSeekbarValue();
                onBodyPartsCheckboxClicked();

                CreateItemAsyncTask createItemAsyncTask = new CreateItemAsyncTask();
                createItemAsyncTask.execute();

                GetAllItemsAsyncTask getAllDevicesTask = new GetAllItemsAsyncTask();
                getAllDevicesTask.execute();


                //System.out.println(Arrays.toString(everything.toArray()));

             //   System.out.println(queryprevious(username));

                /*
               if(queryprevious(username)){
                    deleteprevious(username);
                    retrieveinfo();

                }else if(!queryprevious(username)) {
                    storeinputs(username, everything.get(0), everything.get(1), everything.get(2), everything.get(3), everything.get(4), everything.get(5), everything.get(6), everything.get(7)
                            , everything.get(8), everything.get(9), everything.get(10), everything.get(11), everything.get(12)
                            , everything.get(13), everything.get(14), everything.get(15), everything.get(16), everything.get(17), everything.get(18), everything.get(19)
                            , everything.get(20), everything.get(21), everything.get(22), everything.get(23), everything.get(24), everything.get(25));
                  //  retrieveinfo();
                }

                 */



            }
        });

    }

    private class GetAllItemsAsyncTask extends AsyncTask<Void, Void, List<Document>> {
        @Override
        protected List<Document> doInBackground(Void... params) {
            SharedPreferences prefs = getActivity().getApplicationContext().getSharedPreferences("myAppPackage", 0);
            String username = prefs.getString("Susername", "");


            DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getContext());
            Log.d("TAG", "databases content" + databaseAccess.getAllItems(username).toString());
            return databaseAccess.getAllItems(username);
        }
        @Override
        protected void onPostExecute(List<Document> documents) {
        }

    }

    private class CreateItemAsyncTask extends AsyncTask<Document, Void, Void> {
        @Override
        protected Void doInBackground(Document... documents) {
            SharedPreferences prefs = getActivity().getApplicationContext().getSharedPreferences("myAppPackage", 0);
            String username = prefs.getString("Susername", "");

            DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getContext());
            databaseAccess.addAllItems(username, monday,tuesday,wednesday,thursday,friday,saturday,sunday,fifteen,twentifive,thirtifive,fortifive,muscle,slim,fit,restoration,intensity,waist,arm,leg,hip,shoulder,chest,back,neck,whole,abdomen);
            return null;
        }
    }



    public void onWeekdayCheckboxClicked() {
        // Is the view now checked?
        CheckBox mondayC = requireView().findViewById(R.id.checkBox_uifFrag_mon);
        CheckBox tuesdayC = requireView().findViewById(R.id.checkBox_uifFrag_tue);
        CheckBox wednesdayC = requireView().findViewById(R.id.checkBox_uifFrag_wed);
        CheckBox thursdayC = requireView().findViewById(R.id.checkBox_uifFrag_thu);
        CheckBox fridayC = requireView().findViewById(R.id.checkBox_uifFrag_fri);
        CheckBox saturdayC = requireView().findViewById(R.id.checkBox_uifFrag_sat);
        CheckBox sundayC = requireView().findViewById(R.id.checkBox_uifFrag_sun);

        boolean mondayB = mondayC.isChecked();
        boolean tuesdayB = tuesdayC.isChecked();
        boolean wednesdayB = wednesdayC.isChecked();
        boolean thursdayB = thursdayC.isChecked();
        boolean fridayB = fridayC.isChecked();
        boolean saturdayB = saturdayC.isChecked();
        boolean sundayB = sundayC.isChecked();



        if(mondayB){
            monday="monday";
        }else {
            monday="notmonday";
        }
        if(tuesdayB){
            tuesday="tuesday";
        }else {
            tuesday="nottuesday";
        }
        if(wednesdayB){
            wednesday="wednesday";
        }else {
            wednesday="notwednesday";
        }
        if(thursdayB){
            thursday="thursday";
        }else {
            thursday="notthursday";
        }
        if(fridayB){
            friday="friday";
        } else {
            friday="notfriday";
        }
        if(saturdayB){
            saturday="saturday";
        } else {
            saturday="notsaturday";
        }
        if(sundayB){
            sunday="sunday";
        }else {
            sunday="notsunday";
        }

    }

    public void onDurationCheckboxClicked() {


        CheckBox fifteenC = requireView().findViewById(R.id.checkBox_uifFrag_15min);
        CheckBox twentyfiveC = requireView().findViewById(R.id.checkBox_uifFrag_25min);
        CheckBox thirtyfiveC = requireView().findViewById(R.id.checkBox_uifFrag_35min);
        CheckBox fortyfiveC = requireView().findViewById(R.id.checkBox_uifFrag_45min);


        boolean fifteenB = fifteenC.isChecked();
        boolean tweentyfiveB = twentyfiveC.isChecked();
        boolean thirtyfiveB = thirtyfiveC.isChecked();
        boolean fortyfiveB = fortyfiveC.isChecked();

        if (fifteenB) {
            fifteen="15";
        } else {
            fifteen="emp";
        }
        if (tweentyfiveB) {
            twentifive="25";
        } else {
            twentifive="emp";
        }
        if (thirtyfiveB) {
            thirtifive="35";
        } else {
            thirtifive="emp";
        }
        if (fortyfiveB) {
            fortifive="45";
        } else {
            fortifive="emp";
        }


    }

    public void onObjevtiveCheckboxClicked() {


        CheckBox muscleC = requireView().findViewById(R.id.checkBox_uifFrag_mus);
        CheckBox slimC = requireView().findViewById(R.id.checkBox_uifFrag_slim);
        CheckBox fitC = requireView().findViewById(R.id.checkBox_uifFrag_fit);
        CheckBox restorationC = requireView().findViewById(R.id.checkBox_uifFrag_rest);

        boolean muscleB = muscleC.isChecked();
        boolean slimB = slimC.isChecked();
        boolean fitB = fitC.isChecked();
        boolean restroationB = restorationC.isChecked();

        if(muscleB){
            muscle="musclebuilding";
        }else {
            muscle="notmusclebuilding";
        }
        if(slimB){
            slim="slimming";
        }else {
            slim="notslimming";
        }
        if(fitB){
            fit="fitness";
        }else {
            fit="notfitness";
        }
        if(restroationB){
            restoration="restoration";
        }else {
            restoration="notrestoration";
            }

    }

    public String getSeekbarValue(){
        SeekBar intensitySeekbar = requireView().findViewById(R.id.seekBar_uifFrag);
        int intensityInt = intensitySeekbar.getProgress();
        int realIntensity = intensityInt+1;
        String intens = String.valueOf(realIntensity);
        intensity = intens;
        return intens;
    }

    public void onBodyPartsCheckboxClicked() {



        CheckBox waistC = requireView().findViewById(R.id.checkBox_uifFrag_waist);
        CheckBox armsC = requireView().findViewById(R.id.checkBox_uifFrag_arms);
        CheckBox legsC = requireView().findViewById(R.id.checkBox_uifFrag_legs);
        CheckBox hipC = requireView().findViewById(R.id.checkBox_uifFrag_hip);
        CheckBox shouldersC = requireView().findViewById(R.id.checkBox_uifFrag_should);
        CheckBox chestC = requireView().findViewById(R.id.checkBox_uifFrag_chest);
        CheckBox backC = requireView().findViewById(R.id.checkBox_uifFrag_back);
        CheckBox neckC = requireView().findViewById(R.id.checkBox_uifFrag_neck);
        CheckBox wholeC = requireView().findViewById(R.id.checkBox_uifFrag_whole);
        CheckBox abdomenC = requireView().findViewById(R.id.checkBox_uifFrag_abdomen);

        boolean waistB = waistC.isChecked();
        boolean armsB = armsC.isChecked();
        boolean legsB = legsC.isChecked();
        boolean hipB = hipC.isChecked();
        boolean shoulderB = shouldersC.isChecked();
        boolean chestB = chestC.isChecked();
        boolean backB = backC.isChecked();
        boolean neckB = neckC.isChecked();
        boolean wholeB = wholeC.isChecked();
        boolean abdomenB = abdomenC.isChecked();

        if(waistB){
            waist="waist";
        }else {
            waist="notwaist";
        }
        if(armsB){
            arm="arms";
        }else {
            arm="notarms";
        }
        if(legsB){
            leg="legsB";
        }else {
            leg="notlegs";
        }
        if(hipB){
            hip="hip";
        }else {
            hip="nothip";
        } if(shoulderB){
            shoulder="shoulder";
        }else {
            shoulder="notshoulder";
        }
        if(chestB){
            chest="chest";
        }else {
            chest="notchest";
        }
        if(backB){
            back="back";
        }else {
            back="notback";
        }
        if(neckB){
            neck="neck";
        }else {
            neck="notneck";
        } if(wholeB){
            whole="whole";
        }else {
            whole="notwhole";
        } if(abdomenB){
            abdomen="abdomen";
        }else {
            abdomen="notabdomen";
        }

    }

    public void deleteprevious(String uname){
        String result;
        Amplify.DataStore.query(Task.class, Where.matches(USERNAME.eq(uname)),
                matches -> {
                    if (matches.hasNext()) {
                        Task post = matches.next();
                        Amplify.DataStore.delete(post,
                                deleted -> Log.i("I HAVE FUCKING DELETED THIS SHIT", "DELETED THIS SHIT."),
                                failure -> Log.e("MyAmplifyApp", "Delete failed.", failure)
                        );
                    }
                },
                failure -> Log.e("MyAmplifyApp", "Query failed.", failure)
        );
    }

    public boolean queryprevious(String username) {
         String[] something = new String[1];
          Amplify.DataStore.query(Task.class, Where.matches(USERNAME.contains(username)), goodPosts -> {
                        if (goodPosts.next().getUsername().equals(username)) {
                            Task post = goodPosts.next();
                            something[0] = post.getUsername();
                            System.out.println(something[0]);

                            Log.i("querySearchis:", "Post: " +  post);
                        }
                    },
                    failure -> Log.e("MyAmplifyApp", "Query failed.", failure)
            );

            if(Objects.equals(something[0], username)){
                return true;
            }else return false;


    }

    /*
    public void storeinputs (String usrname, String mon, String tue, String wed, String thu, String fri, String sat,
                             String sun, String fift, String twtfive, String thtyfive, String frtyfive,
                             String muscle, String slm, String fit, String restor, String intensity, String waist, String arm,
                             String legs, String hip, String shoulder, String chest, String back,
                             String neck, String whole, String abdomen){

        Task post = Task.builder()
                .username(usrname)
                .monday(mon).tuesday(tue).wednesday(wed).thursday(thu).friday(fri).saturday(sat).sunday(sun).fifteen(fift).twentyfive(twtfive).thirtyfive(thtyfive).fortyfive(frtyfive).muscle(muscle)
                .slim(slm).fit(fit).restoration(restor).intensity(intensity).arms(arm).waist(waist).legs(legs).hip(hip).shoulder(shoulder).chest(chest).back(back).neck(neck).whole(whole).abdomen(abdomen)
                .build();


        Amplify.DataStore.save(post,
                saved -> Log.i("MyAmplifyApp", "Saved a post."),
                failure -> Log.e("MyAmplifyApp", "Save failed.", failure)
        );

    }

    public void retrieveinfo(){
        Amplify.DataStore.query(Task.class,
                allPosts -> {
                    while (allPosts.hasNext()) {
                        Task post = allPosts.next();
                        Log.i("MyAmplifyApp", "username: " + post.getUsername());

                        Log.i("MyAmplifyApp", "Title: " + post.getMonday());
                    }
                },
                failure -> Log.e("MyAmplifyApp", "Query failed.", failure)
        );
    }


     */

}