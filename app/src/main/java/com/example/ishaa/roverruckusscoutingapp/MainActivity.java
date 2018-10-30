package com.example.ishaa.roverruckusscoutingapp;

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

import org.apache.poi.hssf.record.formula.functions.Match;

public class MainActivity extends AppCompatActivity {
    TextView AllianceLabel, BlueAllianceLabel, RedAllianceLabel, AutonomousLabel, CraterStartLabel, DepotStartLabel,
    SamplingLabel, TeleOpLabel, SilverLabelCargo, SilverCargoNumber, GoldCargoLabel, GoldCargoNumber, SilverDepotLabel,
    SilverDepotNumber, EndGameLabel, EndPositionLabel, ScoreLabel, ScoreNumber, GoldDepotLabel, GoldDepotNumber;

    Button RemoveSilverCargo, AddSilverCargo, RemoveGoldCargo, AddGoldCargo, RemoveSilverDepot, AddSilverDepot,
    RemoveGoldDepot, AddGoldDepot, Submit, Reset;

    EditText SheetName, TeamNumber, MatchNumber, HangTime, AdditionalComments, Initials;

    CheckBox AutoLand, AutoTeamMarker, AutoPark, FTAError;

    Switch AllianceSwitch, StartingSwitch;

    Spinner SamplingSpinner, EndGameSpinner;


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
        Initials = (EditText) findViewById(R.id.AdditionalComments);

        AutoPark = (CheckBox) findViewById(R.id.AutoPark);
        AutoLand = (CheckBox) findViewById(R.id.AutoLand);
        AutoTeamMarker = (CheckBox) findViewById(R.id.AutoTeamMarker);
        FTAError = (CheckBox) findViewById(R.id.FTAError);

        AllianceSwitch = (Switch) findViewById(R.id.AllianceSwitch);
        StartingSwitch = (Switch) findViewById(R.id.StartingSwitch);

        SamplingSpinner = (Spinner) findViewById(R.id.SamplingSpinner);
        EndGameSpinner = (Spinner) findViewById(R.id.EndGameSpinner);

        ArrayAdapter<CharSequence> SamplingAdapter = ArrayAdapter.createFromResource(this,
                R.array.SamplingSpinnerItems, android.R.layout.simple_spinner_item);

        ArrayAdapter<CharSequence> EndGameAdapter = ArrayAdapter.createFromResource(this,
                R.array.EndGameSpinner, android.R.layout.simple_spinner_item);

        SamplingSpinner.setAdapter(SamplingAdapter);
        EndGameSpinner.setAdapter(EndGameAdapter);

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

        View[] quarterWidgets = {BlueAllianceLabel, RedAllianceLabel, AllianceSwitch, CraterStartLabel, StartingSwitch, DepotStartLabel,
        SilverLabelCargo, AddSilverCargo, SilverCargoNumber, RemoveSilverCargo, GoldCargoLabel, RemoveGoldCargo, GoldCargoNumber,
        AddGoldCargo, SilverDepotLabel, RemoveSilverDepot, SilverDepotNumber, AddSilverDepot, GoldDepotLabel, RemoveGoldDepot, GoldDepotNumber,
        AddGoldDepot};
        View[] halfWidgets = {ScoreLabel, ScoreNumber, Submit, Reset};
        View[] fullWidgets = {SheetName, TeamNumber, MatchNumber, AllianceLabel, AutonomousLabel, AutoLand, AutoPark, AutoTeamMarker,
        SamplingLabel, SamplingSpinner, TeleOpLabel, EndGameLabel, EndPositionLabel, EndGameSpinner, FTAError, AdditionalComments, Initials};

        int width = (getResources().getDisplayMetrics().widthPixels)-32;
        ViewGroup.LayoutParams layout;
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

    public void update(){

    }
}
