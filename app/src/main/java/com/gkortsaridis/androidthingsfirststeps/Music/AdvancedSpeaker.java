package com.gkortsaridis.androidthingsfirststeps.Music;

import android.util.Log;

import com.google.android.things.contrib.driver.pwmspeaker.Speaker;

import java.io.IOException;

import static com.gkortsaridis.androidthingsfirststeps.Music.Note.Ab3;
import static com.gkortsaridis.androidthingsfirststeps.Music.Note.Ab4;
import static com.gkortsaridis.androidthingsfirststeps.Music.Note.B3;
import static com.gkortsaridis.androidthingsfirststeps.Music.Note.Bb3;
import static com.gkortsaridis.androidthingsfirststeps.Music.Note.C4;
import static com.gkortsaridis.androidthingsfirststeps.Music.Note.D4;
import static com.gkortsaridis.androidthingsfirststeps.Music.Note.Db4;
import static com.gkortsaridis.androidthingsfirststeps.Music.Note.E;
import static com.gkortsaridis.androidthingsfirststeps.Music.Note.E4;
import static com.gkortsaridis.androidthingsfirststeps.Music.Note.Eb4;
import static com.gkortsaridis.androidthingsfirststeps.Music.Note.F3;
import static com.gkortsaridis.androidthingsfirststeps.Music.Note.F4;
import static com.gkortsaridis.androidthingsfirststeps.Music.Note.G4;
import static com.gkortsaridis.androidthingsfirststeps.Music.Note.Gb4;
import static com.gkortsaridis.androidthingsfirststeps.Music.Note.H;
import static com.gkortsaridis.androidthingsfirststeps.Music.Note.LA3;
import static com.gkortsaridis.androidthingsfirststeps.Music.Note.LA4;
import static com.gkortsaridis.androidthingsfirststeps.Music.Note.Q;
import static com.gkortsaridis.androidthingsfirststeps.Music.Note.S;
import static java.lang.Thread.sleep;

/**
 * Created by george.kortsaridis on 27/03/2017.
 */

public class AdvancedSpeaker {
    private Speaker mSpeaker;

    public AdvancedSpeaker(String GPI_SPEAKER){
        try {
            mSpeaker = new Speaker(GPI_SPEAKER);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void delay(long milis){
        try{
            sleep(milis);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private void delay(double milis){
        try{
            sleep((long) milis);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void starWars(){
        //tone(pin, note, duration)
        playTone(LA3, Q);
        delay(1+Q); //delay duration should always be 1 ms more than the note in order to separate them.
        playTone(LA3,Q);
        delay(1+Q);
        playTone(LA3,Q);
        delay(1+Q);
        playTone(F3,E+S);
        delay(1+E+S);
        playTone(C4,S);
        delay(1+S);

        playTone(LA3,Q);
        delay(1+Q);
        playTone(F3,E+S);
        delay(1+E+S);
        playTone(C4,S);
        delay(1+S);
        playTone(LA3,H);
        delay(1+H);

        playTone(E4,Q);
        delay(1+Q);
        playTone(E4,Q);
        delay(1+Q);
        playTone(E4,Q);
        delay(1+Q);
        playTone(F4,E+S);
        delay(1+E+S);
        playTone(C4,S);
        delay(1+S);

        playTone(Ab3,Q);
        delay(1+Q);
        playTone(F3,E+S);
        delay(1+E+S);
        playTone(C4,S);
        delay(1+S);
        playTone(LA3,H);
        delay(1+H);

        playTone(LA4,Q);
        delay(1+Q);
        playTone(LA3,E+S);
        delay(1+E+S);
        playTone(LA3,S);
        delay(1+S);
        playTone(LA4,Q);
        delay(1+Q);
        playTone(Ab4,E+S);
        delay(1+E+S);
        playTone(G4,S);
        delay(1+S);

        playTone(Gb4,S);
        delay(1+S);
        playTone(E4,S);
        delay(1+S);
        playTone(F4,E);
        delay(1+E);
        delay(1+E);//PAUSE
        playTone(Bb3,E);
        delay(1+E);
        playTone(Eb4,Q);
        delay(1+Q);
        playTone(D4,E+S);
        delay(1+E+S);
        playTone(Db4,S);
        delay(1+S);

        playTone(C4,S);
        delay(1+S);
        playTone(B3,S);
        delay(1+S);
        playTone(C4,E);
        delay(1+E);
        delay(1+E);//PAUSE QUASI FINE RIGA
        playTone(F3,E);
        delay(1+E);
        playTone(Ab3,Q);
        delay(1+Q);
        playTone(F3,E+S);
        delay(1+E+S);
        playTone(LA3,S);
        delay(1+S);

        playTone(C4,Q);
        delay(1+Q);
        playTone(LA3,E+S);
        delay(1+E+S);
        playTone(C4,S);
        delay(1+S);
        playTone(E4,H);
        delay(1+H);

        playTone(LA4,Q);
        delay(1+Q);
        playTone(LA3,E+S);
        delay(1+E+S);
        playTone(LA3,S);
        delay(1+S);
        playTone(LA4,Q);
        delay(1+Q);
        playTone(Ab4,E+S);
        delay(1+E+S);
        playTone(G4,S);
        delay(1+S);

        playTone(Gb4,S);
        delay(1+S);
        playTone(E4,S);
        delay(1+S);
        playTone(F4,E);
        delay(1+E);
        delay(1+E);//PAUSE
        playTone(Bb3,E);
        delay(1+E);
        playTone(Eb4,Q);
        delay(1+Q);
        playTone(D4,E+S);
        delay(1+E+S);
        playTone(Db4,S);
        delay(1+S);

        playTone(C4,S);
        delay(1+S);
        playTone(B3,S);
        delay(1+S);
        playTone(C4,E);
        delay(1+E);
        delay(1+E);//PAUSE QUASI FINE RIGA
        playTone(F3,E);
        delay(1+E);
        playTone(Ab3,Q);
        delay(1+Q);
        playTone(F3,E+S);
        delay(1+E+S);
        playTone(C4,S);
        delay(1+S);

        playTone(LA3,Q);
        delay(1+Q);
        playTone(F3,E+S);
        delay(1+E+S);
        playTone(C4,S);
        delay(1+S);
        playTone(LA3,H);
        delay(1+H);

        delay(2*H);
    }

    public void playMusic(int[] freqs, long[] milis){
        for(int i=0; i<freqs.length; i++){
            long noteDuration = 1000 / milis[i];
            playTone(freqs[i],milis[i]*17);

            playTone(0,milis[i]*10);
        }
    }

    public void playTone(int freq, long milis){
        try {
            mSpeaker.play(freq);
            delay(milis);
            mSpeaker.stop();
        } catch (IOException e) {
            Log.i("SPEAKER ERROR",e.toString());
        }
    }

    public void playTone(double freq, double milis){
        try {
            mSpeaker.play(freq);
            delay(milis);
            mSpeaker.stop();
        } catch (IOException e) {
            Log.i("SPEAKER ERROR",e.toString());
        }
    }

    public void playTone(int freq){
        try {
            mSpeaker.play(freq);
        } catch (IOException e) {
            Log.i("SPEAKER ERROR",e.toString());
        }
    }

    public void stopTone(){
        try {
            mSpeaker.stop();
        } catch (IOException e) {
            Log.i("SPEAKER ERROR",e.toString());
        }
    }
}
