package redrocketz.project.com.glideapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.load.engine.DiskCacheStrategy;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.image_view)
    ImageView imageView;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        GlideApp.with(this)
                .load("http://dailyhdwallpaper.com/wp-content/uploads/Retro-Robot-Desktop-Art-Free-Wallpaper.jpg")
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .listener(new GlideRequestListener(progressBar))
                .transform(new PositionedCropTransformation(1, 0))
                .into(imageView);
    }
}
