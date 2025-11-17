package com.example.appmusica;

import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private SeekBar seekBar;
    private TextView tReproduccion, tTotal, tituloCancion;
    private Button bPlay, bPausa, bcancion1, bcancion2, bcancion3, bcancion4;
    private ImageView imageView;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private Runnable updateSeekBar;

    private SoundPool soundPool;
    private int sonido1, sonido2, sonido3, sonido4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        mediaPlayer = MediaPlayer.create(this, R.raw.guy);

        bPlay = findViewById(R.id.bPlay);
        bPausa = findViewById(R.id.bPausa);
        seekBar = findViewById(R.id.seekBar);
        tReproduccion = findViewById(R.id.tReproduccion);
        tTotal = findViewById(R.id.tTotal);
        tituloCancion = findViewById(R.id.tituloCancion);
        imageView = findViewById(R.id.imageView);
        bcancion1 = findViewById(R.id.bcancion1);
        bcancion2 = findViewById(R.id.bcancion2);
        bcancion3 = findViewById(R.id.bcancion3);
        bcancion4 = findViewById(R.id.bcancion4);

        int duracionTotal = mediaPlayer.getDuration();
        seekBar.setMax(duracionTotal);
        tTotal.setText(formatearTiempo(duracionTotal));
        tReproduccion.setText("00:00");

        bPlay.setOnClickListener(v -> {
            if (!mediaPlayer.isPlaying()) {
                mediaPlayer.start();
                actualizarSeekBar();
            }
        });

        bPausa.setOnClickListener(v -> {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    mediaPlayer.seekTo(progress);
                    tReproduccion.setText(formatearTiempo(progress));
                }
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        mediaPlayer.setOnCompletionListener(mp -> {
            seekBar.setProgress(0);
            tReproduccion.setText("00:00");
        });

        AudioAttributes audioAttributes = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build();

        soundPool = new SoundPool.Builder()
                .setMaxStreams(4)
                .setAudioAttributes(audioAttributes)
                .build();

        sonido1 = soundPool.load(this, R.raw.sonido1, 1);
        sonido2 = soundPool.load(this, R.raw.sonido2, 1);
        sonido3 = soundPool.load(this, R.raw.sonido3, 1);
        sonido4 = soundPool.load(this, R.raw.sonido4, 1);

        bcancion1.setOnClickListener(v -> {
            soundPool.play(sonido1, 1.0f, 1.0f, 1, 0, 1.0f);
        });

        bcancion2.setOnClickListener(v -> {
            soundPool.play(sonido2, 1.0f, 1.0f, 1, 0, 1.0f);
        });

        bcancion3.setOnClickListener(v -> {
            soundPool.play(sonido3, 1.0f, 1.0f, 1, 0, 1.0f);
        });

        bcancion4.setOnClickListener(v -> {
            soundPool.play(sonido4, 1.0f, 1.0f, 1, 0, 1.0f);
        });
    }

    private void actualizarSeekBar() {
        updateSeekBar = new Runnable() {
            @Override
            public void run() {
                if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                    int posicionActual = mediaPlayer.getCurrentPosition();
                    seekBar.setProgress(posicionActual);
                    tReproduccion.setText(formatearTiempo(posicionActual));
                    handler.postDelayed(this, 100);
                }
            }
        };
        handler.post(updateSeekBar);
    }

    private String formatearTiempo(int milisegundos) {
        int segundos = (milisegundos / 1000) % 60;
        int minutos = (milisegundos / (1000 * 60)) % 60;
        return String.format("%02d:%02d", minutos, segundos);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
        handler.removeCallbacks(updateSeekBar);

        if (soundPool != null) {
            soundPool.release();
            soundPool = null;
        }
    }
}