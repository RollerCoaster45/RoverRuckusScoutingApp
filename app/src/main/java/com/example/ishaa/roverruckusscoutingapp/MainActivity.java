package com.example.ishaa.roverruckusscoutingapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView AllianceLabel, BlueAllianceLabel, RedAllianceLabel, AutonomousLabel, CraterStartLabel, DepotStartLabel,
    SamplingLabel, TeleOpLabel, SilverLabelCargo, SilverCargoNumber, GoldCargoLabel, GoldCargoNumber, SilverDepotLabel,
    SilverDepotNumber, EndGameLabel, EndPositionLabel, ScoreLabel, ScoreNumber;

    Button RemoveSilverCargo, AddSilverCargo, RemoveGoldCargo, AddGoldCargo, RemoveSilverDepot, AddSilverDepot,
    RemoveGoldDepot, AddGoldDepot, Submit, Reset;

    EditText SheetName, TeamNumber, MatchNumber, HangTime, AdditionalComments, Initials;

    CheckBox AutoLand, AutoTeamMarker, AutoPark, FTAError;

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



    }
}
