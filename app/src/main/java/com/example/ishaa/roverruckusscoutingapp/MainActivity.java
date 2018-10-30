package com.example.ishaa.roverruckusscoutingapp;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import org.apache.poi.ss.usermodel.Sheet;

public class MainActivity extends AppCompatActivity {
    TextView AllianceLabel, BlueAllianceLabel, RedAllianceLabel, AutonomousLabel, CraterStartLabel, DepotStartLabel,
    SamplingLabel, TeleOpLabel, SilverLabelCargo, SilverCargoNumber, GoldCargoLabel, GoldCargoNumber, SilverDepotLabel,
    SilverDepotNumber, GoldDepotLabel, GoldDepotNumber, EndGameLabel, EndPositionLabel, ScoreLabel, ScoreNumber;

    Button RemoveSilverCargo, AddSilverCargo, RemoveGoldCargo, AddGoldCargo, RemoveSilverDepot, AddSilverDepot,
    RemoveGoldDepot, AddGoldDepot, Submit, Reset;

    EditText SheetName, TeamNumber, MatchNumber, HangTime, AdditionalComments, Initials;

    CheckBox AutoLand, AutoTeamMarker, AutoPark, FTAError;

    Spinner SamplingSpinner, EndGameSpinner;

    Switch AllianceSwitch, AutoStartSwitch;

    int score = 0;
    int silverCargoMinerals = 0;
    int goldCargoMinerals = 0;
    int silverDepotMinerals = 0;
    int goldDepotMinerals = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AllianceLabel = (TextView) findViewById(R.id.AllianceLabel);
        BlueAllianceLabel = (TextView) findViewById(R.id.BlueAllianceLabel);
        RedAllianceLabel = (TextView) findViewById(R.id.RedAllianceLabel);
        AutonomousLabel = (TextView) findViewById(R.id.AutonomousLabel);
        CraterStartLabel = (TextView) findViewById(R.id.CraterStartLabel);
        DepotStartLabel = (TextView) findViewById(R.id.DepotStartLabel);
        SamplingLabel = (TextView) findViewById(R.id.SamplingLabel);
        TeleOpLabel = (TextView) findViewById(R.id.TeleOpLabel);
        SilverLabelCargo = (TextView) findViewById(R.id.SilverLabelCargo);
        SilverCargoNumber = (TextView) findViewById(R.id.SilverCargoNumber);
        GoldCargoLabel = (TextView) findViewById(R.id.GoldCargoLabel);
        GoldCargoNumber = (TextView) findViewById(R.id.GoldCargoNumber);
        SilverDepotLabel = (TextView) findViewById(R.id.SilverDepotLabel);
        SilverDepotNumber = (TextView) findViewById(R.id.SilverDepotNumber);
        GoldDepotLabel = (TextView) findViewById(R.id.GoldDepotLabel);
        GoldDepotNumber = (TextView) findViewById(R.id.GoldDepotNumber);
        EndGameLabel = (TextView) findViewById(R.id.EndGameLabel);
        EndPositionLabel = (TextView) findViewById(R.id.EndPositionLabel);
        ScoreLabel = (TextView) findViewById(R.id.ScoreLabel);
        ScoreNumber = (TextView) findViewById(R.id.ScoreNumber);

        RemoveSilverCargo = (Button) findViewById(R.id.RemoveSilverCargo);
        AddSilverCargo = (Button) findViewById(R.id.AddSilverCargo);
        RemoveGoldCargo = (Button) findViewById(R.id.RemoveGoldCargo);
        AddGoldCargo = (Button) findViewById(R.id.AddGoldCargo);
        RemoveSilverDepot = (Button) findViewById(R.id.RemoveSilverDepot);
        AddSilverDepot = (Button) findViewById(R.id.AddSilverDepot);
        RemoveGoldDepot = (Button) findViewById(R.id.RemoveGoldDepot);
        AddGoldDepot = (Button) findViewById(R.id.AddGoldDepot);
        Submit = (Button) findViewById(R.id.SubmitButton);
        Reset = (Button) findViewById(R.id.ResetButton);

        SheetName = (EditText) findViewById(R.id.sheetName);
        TeamNumber = (EditText) findViewById(R.id.teamNumber);
        MatchNumber = (EditText) findViewById(R.id.matchNumber);
        HangTime = (EditText) findViewById(R.id.HangTime);
        AdditionalComments = (EditText) findViewById(R.id.AdditionalComments);
        Initials = (EditText) findViewById(R.id.Initials);

        AutoLand = (CheckBox) findViewById(R.id.AutoLand);
        AutoTeamMarker = (CheckBox) findViewById(R.id.AutoTeamMarker);
        AutoPark = (CheckBox) findViewById(R.id.AutoPark);
        FTAError = (CheckBox) findViewById(R.id.FTAError);

        SamplingSpinner = (Spinner) findViewById(R.id.SamplingSpinner);
        EndGameSpinner = (Spinner) findViewById(R.id.EndGameSpinner);


        SamplingSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                update();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        EndGameSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                update();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        AllianceSwitch = (Switch) findViewById(R.id.AllianceSwitch);
        AutoStartSwitch = (Switch) findViewById(R.id.StartingSwitch);







        int width = (getResources().getDisplayMetrics().widthPixels)-32;

        ViewGroup.LayoutParams layout;
        View[] quarterWidgets = {BlueAllianceLabel, RedAllianceLabel, CraterStartLabel, DepotStartLabel, SilverLabelCargo, SilverCargoNumber, GoldCargoLabel,
                GoldCargoNumber, SilverDepotLabel, SilverDepotNumber, GoldDepotLabel, GoldDepotNumber, RemoveSilverCargo, RemoveGoldCargo, RemoveSilverDepot, RemoveGoldDepot, AddSilverCargo,
                AddGoldCargo, AddSilverDepot, AddGoldDepot};

        View[] halfWidgets = {AllianceSwitch, AutoStartSwitch, Submit, Reset, ScoreLabel, ScoreNumber};

        View[] fullWidgets = {SheetName, TeamNumber, MatchNumber, AutonomousLabel, AllianceLabel, AutoLand, AutoTeamMarker, AutoPark, SamplingLabel, SamplingSpinner,
        TeleOpLabel, EndGameLabel, EndPositionLabel, EndGameSpinner, HangTime, FTAError, AdditionalComments, Initials};

        for(View widget:quarterWidgets){
            layout = widget.getLayoutParams();
            layout.width = width/4;
            widget.setLayoutParams(layout);
        }for(View widget:halfWidgets){
            layout = widget.getLayoutParams();
            layout.width = width/2;
            widget.setLayoutParams(layout);

        }
        for(View widget:fullWidgets){
            layout = widget.getLayoutParams();
            layout.width = width;
            widget.setLayoutParams(layout);
        }

    }


    public void submit() {

    }

    public void update(){
        SilverCargoNumber.setText(""+silverCargoMinerals);
        GoldCargoNumber.setText(""+goldCargoMinerals);
        SilverDepotNumber.setText(""+silverDepotMinerals);
        GoldDepotNumber.setText(""+goldDepotMinerals);
        this.calculateScore();
        ScoreNumber.setText(""+score);
    }

    public void reset(){

    }

    public void addSilverCargo(View view){
        silverCargoMinerals++;
        update();
    }
    public void subSilverCargo(View view){
        if(silverCargoMinerals>0) {
            silverCargoMinerals--;
            update();
        }
    }
    public void addGoldCargo(View view){
        goldCargoMinerals++;
        update();
    }
    public void subGoldCargo(View view){
        if(goldCargoMinerals>0){
            goldCargoMinerals--;
            update();
        }
    }
    public void addSilverDepot(View view){
        silverDepotMinerals++;
    }
    public void subSilverDepot(View view){
        if(silverDepotMinerals>0){
            silverDepotMinerals--;
            update();
        }
    }
    public void addGoldDepot(View view){
        goldDepotMinerals++;
        update();
    }
    public void subGoldDepot(View view){
        if(goldDepotMinerals>0){
            goldDepotMinerals++;
            update();
        }
    }
    public void updateClick(View view){
        update();
    }
    public void calculateScore(){
        score=0;
        if(AutoLand.isChecked()){
            score+=30;
        }
        if(AutoTeamMarker.isChecked()){
            score+=15;
        }
        if(AutoPark.isChecked()){
            score+=10;
        }
        score+=(goldCargoMinerals+silverCargoMinerals)*5;
        score+=(goldDepotMinerals+silverDepotMinerals)*2;
    }
}
